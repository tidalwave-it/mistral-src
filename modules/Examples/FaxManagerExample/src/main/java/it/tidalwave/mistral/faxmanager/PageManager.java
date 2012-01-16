/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2012 by Tidalwave s.a.s.
 *
 ***********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 *
 ***********************************************************************************************************************
 *
 * WWW: http://mistral.tidalwave.it
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package it.tidalwave.mistral.faxmanager;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.net.MalformedURLException;
import java.awt.image.BufferedImage;
import javax.swing.DefaultListModel;
import com.sun.media.imageio.plugins.tiff.TIFFImageWriteParam;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Quality;
import it.tidalwave.image.metadata.TIFF;
import it.tidalwave.image.metadata.WangAnnotations;
import it.tidalwave.image.op.ChangeBufferTypeOp;
import it.tidalwave.image.op.CreateOp;
import it.tidalwave.image.op.PrintOp;
import it.tidalwave.image.op.ReadOp;
import it.tidalwave.image.op.ScaleOp;
import it.tidalwave.image.op.WriteOp;
import it.tidalwave.image.render.EditingTool;
import it.tidalwave.mistral.faxmanager.edittool.StampTool;
import it.tidalwave.mistral.faxmanager.bd.FaxServerBD;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Arrays;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.PrintRequestAttributeSet;

abstract class Task<T>
 {
   private final JProgressBar progressBar;

   public Task (final JProgressBar progressBar, final boolean indeterminate, final int size, final String name)
     throws Exception
     {
       this.progressBar = progressBar; 

       if (progressBar != null)
         {
           SwingUtilities.invokeAndWait(new Runnable() 
             {
               public void run() 
                 {
                   progressBar.setIndeterminate(indeterminate);
                   progressBar.setValue(0);
                   progressBar.setMaximum(size);
                   progressBar.setStringPainted(true);
                   progressBar.setString(name);
                   progressBar.setVisible(true);
                 }
             });
         }
     }

   public T execute()
     throws Exception
     {        
       final T result = run();

       if (progressBar != null)
         {
           SwingUtilities.invokeLater(new Runnable() 
             {
               public void run() 
                 {
                   progressBar.setVisible(false);
                 }
             });
         }

       return result;
     }

   protected void setProgress (final int value)
     {
       if (progressBar != null)
         {
           SwingUtilities.invokeLater(new Runnable() 
             {
               public void run() 
                 {
                   progressBar.setValue(value);  
                 }
             });
         }
     }

   protected abstract T run()
      throws Exception;
 }

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class PageManager
 {
   private final static String CLASS = PageManager.class.getName();
   private final static Logger logger = Logger.getLogger(CLASS);

   /** The model representing the thumbnails. */
   private final DefaultListModel thumbnailsModel = new DefaultListModel();

   private byte[] buffer;

   private String pages;

   private final List<Integer> preparedPages = new ArrayList<Integer>();

   /** This is indexed by the page number. */
   private final List<byte[]> compressedImageList = new ArrayList<byte[]>();

   private final List<Map<String, Object>> attributeMapList = new ArrayList<Map<String, Object>>();

   /** The list of visible page numbers. */
   private final List<Integer> visiblePageNumbers = new ArrayList<Integer>();

   private int selectedPageNumber = -1;

   private int selectedImageIndex = -1;

   private int totalPagesCount;

   private EditableImage selectedImage;

   private final ThumbnailListCellRenderer thumbnailListCellRenderer;

   private WangAnnotations wangAnnotations;

   public static enum Intent
     {
       RENDERING, SAVING    
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public static interface Listener
     {
       public void notifyPageLoaded (int index);
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public PageManager (final ThumbnailListCellRenderer thumbnailListCellRenderer)
     {
       this.thumbnailListCellRenderer = thumbnailListCellRenderer;
       thumbnailListCellRenderer.setPageManager(this);
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public DefaultListModel getThumbnailsModel()
     {
       return thumbnailsModel;  
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public int getPageCount()
     {
       return totalPagesCount;  
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public int getPageNumber()
     {
       return selectedPageNumber;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public int getPageIndex()
     {
       return selectedImageIndex;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public void forceSelectedImage (final EditableImage image)
     {
       this.selectedImage = image;
     }

   /***************************************************************************
    *
    * indes is relative to visible pages
    *
    **************************************************************************/
   public EditableImage selectImage (final int index)
     {
//        if (selectedImage != null)
       if ((selectedImage != null) && (selectedPageNumber >= 0))
         {
           storeImage(selectedImage, selectedPageNumber);
           selectedImage.dispose();  
         }

       if (index < 0)
         {
           selectedPageNumber = -1;
           selectedImage = null;
           selectedImageIndex = -1;
           return null;
         }

       selectedPageNumber = visiblePageNumbers.get(index);
       selectedImage = retrieveImage(selectedPageNumber, PageManager.Intent.RENDERING);
       selectedImageIndex = index;
       return selectedImage;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public void insertImage (final EditableImage image, final int pageNumber)
     {
       logger.info("insertImage(" + pageNumber + ")");
       final EditableImage thumbnail = createThumbnail(image);
       logger.info(">>>> visible pages before insertion: " + visiblePageNumbers);
       final int n = visiblePageNumbers.size() + 1;
       boolean inserted = false;

       if ((pageNumber + 1) == n) // appending
         {
           thumbnailsModel.addElement(thumbnail);
           visiblePageNumbers.add(pageNumber);
         }

       else
         {
           thumbnailListCellRenderer.clear();

           for (int index = 0; index < n; index++)
             {
               final int oldPageNumber = visiblePageNumbers.get(index);

               if ((oldPageNumber == pageNumber) && !inserted)
                 {
                   logger.info(">>>> inserting new thumbnail at " + index);
                   thumbnailsModel.insertElementAt(thumbnail, index);
                   visiblePageNumbers.add(pageNumber, index);
                   inserted = true;
                   continue;
                 }

               if (inserted)
                 {
                   visiblePageNumbers.set(index, oldPageNumber + 1);
                 }
             }
         }

       compressedImageList.add(pageNumber, new byte[0]); // allocate element
       attributeMapList.add(pageNumber, new HashMap<String, Object>()/*Collections.emptyMap()*/);
       storeImage(image, pageNumber);

       logger.info(">>>> visible pages after insertion: " + visiblePageNumbers);
     }

   /***************************************************************************
    * 
    * Stores an image in compressed form.
    *
    **************************************************************************/
   public void storeImage (final EditableImage image, final int pageNumber)
     {
       try 
         {
           logger.info("storeImage(" + image + ", " + pageNumber + ")");
           final ByteArrayOutputStream baos = new ByteArrayOutputStream();
           image.execute(new WriteOp("TIFF", baos)); // FIXME: JPEG is lossy, TIFF is slow...
           baos.close();
           final byte[] buffer = baos.toByteArray();

           while (compressedImageList.size() <= pageNumber)
             {
               compressedImageList.add(new byte[0]); // allocate element
             }

           compressedImageList.set(pageNumber, buffer);

           while (attributeMapList.size() <= pageNumber)
             {
               attributeMapList.add(new HashMap<String, Object>()/*Collections.emptyMap()*/);
             }

           attributeMapList.set(pageNumber, image.getAttributes());
           logger.fine(">>>> stored page #" + pageNumber + ", " + buffer.length + " bytes");
           logger.fine(">>>> stored attributes: "+ image.getAttributes());

           final int index = visiblePageNumbers.indexOf(pageNumber);

           if (index >= 0)
             {
               thumbnailsModel.setElementAt(createThumbnail(image), index);
             }

           if (pageNumber == selectedPageNumber)
             {
               this.selectedImage = image;  
             }
         } 
       catch (IOException e) 
         {
           logger.throwing(CLASS, "", e);
         }
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   private EditableImage retrieveImage (final int pageNumber, final Intent intent)
     {
       try 
         {
           logger.info("retrieveImage(" + pageNumber + ")");

           for (int i = 0; i <= pageNumber; i++)
             {
               preparePage(i);
             }

           final byte[] buffer = compressedImageList.get(pageNumber);
           final ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
           final EditableImage result = EditableImage.create(new ReadOp(bais));
           bais.close();
           fixFormatForRenderer(result, intent);
           result.setAttributes(attributeMapList.get(pageNumber));
           result.removeAttribute(EditingTool.CHANGED_ATTRIBUTE);
           logger.fine(">>>> retrieved attributes: "+ result.getAttributes());
           return result;
           // TODO: make ReadOp able to work directly with a byte[]
         } 
       catch (IOException e) 
         {
           e.printStackTrace(); // FIXME
         }

       return null;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public List<Integer> getVisiblePageNumbers()
     {
       return visiblePageNumbers;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public void load (final String pages, final String getDataURL, final Listener listener, final int totalPageNumber) 
     throws MalformedURLException, IOException
     {
       this.pages = pages;
       thumbnailsModel.clear();
       compressedImageList.clear();
       attributeMapList.clear();
       visiblePageNumbers.clear();
       selectedPageNumber = -1;
       selectedImageIndex = -1;

       selectedImage = null;

       if ((pages != null) && !"".equals(pages))
         {
           for (final StringTokenizer st = new StringTokenizer(pages, ","); st.hasMoreTokens(); )
             {
               final int i = Integer.parseInt(st.nextToken()) - 1;
               visiblePageNumbers.add(i);
             }
         }

       buffer = FaxServerBD.getInstance(getDataURL, null).getData();

//        for (pageCount = 0; ; pageCount++)
//          {
//            try
//              {
//                EditableImage.create(new ReadOp(buffer, ReadOp.Type.METADATA, pageCount)); 
//              }
//            catch (IndexOutOfBoundsException e)
//              {
//                // ok, we got the last image    
//                break;
//              }
//          }

       int index = 0;

       if (totalPageNumber < 0)
         {
           for (int pageNumber = 0; ; pageNumber++)
             {
               try
                 {
                   final boolean loaded = addToModel(pageNumber);
                   preparePage(pageNumber);

                   if (loaded)
                     {
                       listener.notifyPageLoaded(index++); // this must be done AFTER storeImage()
                     }

                   this.totalPagesCount = pageNumber + 1;
                 }
               catch (IndexOutOfBoundsException e)
                 {
                   // ok, no more pages
                   break;
                 }       
             }

         }
       else
         {
           this.totalPagesCount = totalPageNumber;
           boolean first = true;

           for (int pageNumber = 0; pageNumber < totalPageNumber; pageNumber++)
             {
               if (addToModel(pageNumber))
                 {
                   if (first)
                     { 
                       preparePage(pageNumber);  
                       first = false;
                       listener.notifyPageLoaded(index++);
                     }
                 }

//                if (pages == null)
//                  {
//                    visiblePageNumbers.add(pageNumber);  
//                  }
//
//                if (visiblePageNumbers.isEmpty() || visiblePageNumbers.contains(pageNumber))
//                  {
//                    if (first)
//                      { 
//                        preparePage(pageNumber);  
//                        first = false;
//                        index++;
//                      }
//                    else
//                      {
//            //            thumbnailsModel.addElement(createThumbnail(image));
//                        thumbnailsModel.addElement(EditableImage.create(new CreateOp(10, 10, EditableImage.DataType.BYTE)));
//                        listener.notifyPageLoaded(index++);
//                      }
//                  }
             }
         }
     }

   public boolean addToModel (final int pageNumber)
     {
       if (pages == null)
         {
           visiblePageNumbers.add(pageNumber);  
         }

       if (visiblePageNumbers.isEmpty() || visiblePageNumbers.contains(pageNumber))
         {
//            thumbnailsModel.addElement(createThumbnail(image));
           thumbnailsModel.addElement(EditableImage.create(new CreateOp(10, 10, EditableImage.DataType.BYTE)));
           return true;
         }

       return false;
     }

   public boolean preparePage (final int pageNumber) 
     throws IOException
     {
       if (!preparedPages.contains(pageNumber))
         {
           EditableImage image = EditableImage.create(new ReadOp(buffer, pageNumber)); 
           final TIFF tiff = image.getMetadata(TIFF.class);

           if (tiff.isXResolutionAvailable() && tiff.isYResolutionAvailable())
             {
               final double aspect = tiff.getXResolution().doubleValue() / tiff.getYResolution().doubleValue();

               if (Math.abs(aspect - 1.0) > 0.1)
                 {
                   image = image.execute2(new ScaleOp(1.0, aspect, Quality.FASTEST));
                 }
             } 

           final Object pageNumbers = tiff.getObject(TIFF.PAGE_NUMBER);

           System.err.println("PAGE NUMBERS " + pageNumbers);
           System.err.println("TIFF TAGS available:");

           for (int tag : tiff.getTagCodes())
             {
               System.err.println(">>>> " + tiff.getTagName(tag));  
             }

   //            final IIOMetadata metadata = image.getInnerProperty(IIOMetadata.class);
   //
   //            if (metadata != null)
   //              {
   //                final Node node =  metadata.getAsTree("com_sun_media_imageio_plugins_tiff_image_1.0");
   //                final double aspect = getAspect(node);
   //                logger.info(">>>> aspect factor: " + aspect);
   //                // FIXME: why image.execute() doesn't work?
   //                if (Math.abs(aspect - 1.0) > 0.1)
   //                  {
   //                    image = image.execute2(new ScaleOp(1.0, aspect, Quality.FASTEST));
   //                  }
   //                
   //                for (int i = 0; i < node.getChildNodes().getLength(); i++)
   //                  {
   //                    final Node child = node.getChildNodes().item(i);
   ////                    System.err.println("XML DOC: " + child);
   //                    final Properties tiffTagSet = new Properties();
   //                    process(child, "" + i, tiffTagSet);
   //                    System.err.println("TAGS:" + tiffTagSet);
   //                  }
   //              }

           wangAnnotations = null;

           if (tiff.isWangAnnotationAvailable())
             {
               wangAnnotations = tiff.getWangAnnotations2();

               if (wangAnnotations != null)
                 {
                   wangAnnotations.render(image);  
                 }
             }

           storeImage(image, pageNumber); // this must be done AFTER updating thumbnailsModel()

           logger.info(">>>> Page #" + (pageNumber + 1) + ": size = " + image.getMemorySize());
           image.dispose();  
           preparedPages.add(pageNumber);

           return false;
         }

       return true;
     }


   /***************************************************************************
    *
    *
    **************************************************************************/
   private EditableImage createThumbnail (final EditableImage image)  
     {
       final int width = 200;
       final double scale = (double)width / Math.max(image.getWidth(), image.getHeight());
       final EditableImage thumbnail = image.execute2(new ScaleOp(scale));
       return thumbnail;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public void printPages (final List<Integer> pageNumbers, final JProgressBar progressBar, final String printerName, final PrintRequestAttributeSet aset, final boolean useDialog)
     throws Exception
     {
       logger.info("printPages(" + pageNumbers + ")");

       final Task<Void> task = new Task<Void>(progressBar, false, pageNumbers.size(), "Stampa fax in corso...")
         {
           protected Void run()
             throws PrinterException, InterruptedException, InvocationTargetException
             {
               final PrintService[] printServices = PrinterJob.lookupPrintServices();

               if (printServices.length > 0) 
                 {
                   PrintService selectedPrintService = PrintServiceLookup.lookupDefaultPrintService();

                   if (printerName != null)
                     {
                       for (final PrintService printService : printServices)  
                         {
                           if (printerName.equals(printService.getName()))
                             {
                               selectedPrintService = printService;
                               break;
                             }
                         }
                     }

                   logger.fine(String.format(">>>> available printers: %s", Arrays.toString(printServices)));
                   logger.fine(String.format(">>>> requested printer:  '%s'", printerName));
                   logger.fine(String.format(">>>> selected printer:   '%s'", selectedPrintService.getName()));
                   logger.fine(String.format(">>>> print attributes:   %s", Arrays.toString(aset.toArray())));
                   System.err.println(String.format(">>>> available printers: %s", Arrays.toString(printServices)));
                   System.err.println(String.format(">>>> requested printer:  '%s'", printerName));
                   System.err.println(String.format(">>>> selected printer:   '%s'", selectedPrintService.getName()));
                   System.err.println(String.format(">>>> print attributes:   %s", Arrays.toString(aset.toArray())));

                   final PrinterJob printerJob = PrinterJob.getPrinterJob();
                   printerJob.setPrintService(selectedPrintService);

                   if (!useDialog || (printerJob.pageDialog(aset) != null))
                     {
                       logger.fine(">>>> PrintAttributeSet: " + Arrays.toString(aset.toArray()));
                       final PrintOp printOp = new PrintOp(printerJob, aset, !useDialog);

                       for (final int pageNumber : pageNumbers)
                         {
                           logger.fine(">>>> printing page #" + pageNumber);
                           final boolean current = pageNumber == selectedPageNumber;
                           final EditableImage image = current ? selectedImage : retrieveImage(pageNumber, Intent.RENDERING);
                           image.execute(printOp);

                           if (!current)
                             {
                               logger.fine(">>>> disposing page #" + pageNumber);
                               image.dispose();  
                             }

                           setProgress(pageNumber + 1);
                         }
                     }
                 }

               return null;
             }
         };

       task.execute();
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public String save (final String faxName, final String url, final JProgressBar progressBar) 
     throws Exception
     {
       logger.info("save(" + faxName + ", " + url + ")");

       final Task<String> task = new Task<String>(progressBar, false, compressedImageList.size(), "Salvataggio fax in corso...")
         {
           protected String run()
             throws MalformedURLException, IOException, InterruptedException, InvocationTargetException
             {
               final URLConnection connection = new URL(url).openConnection();
               connection.setDoOutput(true);
               final DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
       //        final DataOutputStream dos = new DataOutputStream(new FileOutputStream("/tmp/output.tif"));
               dos.writeUTF(faxName);

               // TODO: make EditableImage able to work with multiple pages?
               // It's a bit tricky, since a lot of stuff depends on the single page concept (e.g. getWidth())
               final TIFFImageWriteParam writeParam = new TIFFImageWriteParam(Locale.getDefault());
               writeParam.setCompressionMode(TIFFImageWriteParam.MODE_EXPLICIT);
       //        writeParam.setCompressionType("JPEG");
               writeParam.setCompressionType("Deflate");

               final Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("TIFF");
               ImageWriter selectedWriter = null;

               while (writers.hasNext())
                 {
                   final ImageWriter writer = writers.next();
                   logger.finer(">>>> testing writer: " + writer);

                   if (selectedWriter == null) // keep the first one, keep on logging the others
                     {
                       selectedWriter = writer;
                     }
                 }

               if (selectedWriter == null)
                 {
                   throw new IOException("No writers for TIFF format");
                 }

               logger.fine(">>>> using writer: " + selectedWriter);
               final ImageOutputStream stream = ImageIO.createImageOutputStream(dos); 
               selectedWriter.setOutput(stream);
               selectedWriter.prepareWriteSequence(null);

               for (int pageNumber = 0; pageNumber < compressedImageList.size(); pageNumber++)
                 {
                   logger.fine(">>>> PageManager.save(): pageNumber=" + pageNumber + ", selectedPageNumber=" + selectedPageNumber);
                   preparePage(pageNumber);
                   final EditableImage img = (pageNumber == selectedPageNumber) ? selectedImage : retrieveImage(pageNumber, Intent.SAVING);
                   final BufferedImage buff = img.getInnerProperty(BufferedImage.class);
                   logger.fine(">>>> Bands: " + buff.getSampleModel().getNumBands());
                   selectedWriter.writeToSequence(new IIOImage(buff, null, null), writeParam);
                   getAttributes(pageNumber).remove(EditingTool.CHANGED_ATTRIBUTE);

                   if (pageNumber == selectedPageNumber)
                     {
                       selectedImage.removeAttribute(EditingTool.CHANGED_ATTRIBUTE);
                     }
                   else
                     {
                       System.err.println("Disposing page");
                       img.dispose();
                     }

                   System.err.println("Memory: " + Runtime.getRuntime().freeMemory());
                   setProgress(pageNumber);
                 }

               selectedWriter.endWriteSequence();
               stream.close();
               selectedWriter.dispose();

               dos.close();
               final InputStream is = connection.getInputStream();
               final BufferedReader br = new BufferedReader(new InputStreamReader(is));
               final String newId = br.readLine();
               br.close(); // flushes the connection

               return newId;
             }
         };

       return task.execute();
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public boolean isFullyPunched()
     {
       for (int i = 0; i < thumbnailsModel.getSize(); i++)
         {
           final Boolean punched = (Boolean)getAttributes(i).get(StampTool.PUNCHED);

           if ((punched == null) || !punched)
             {
               return false;  
             }
         }

       return true;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public boolean isChanged()
     {
         System.err.println("Checking only visible pages");
         for (int i = 0; i < visiblePageNumbers.size(); i++)
           {
             System.err.println("Checking visible page #"+visiblePageNumbers.get(i));
             final Boolean changed = (Boolean)getAttributes(visiblePageNumbers.get(i)).get(EditingTool.CHANGED_ATTRIBUTE);
             System.err.println(String.format("Page #%d changed? %s", visiblePageNumbers.get(i), changed));

             if ((changed != null) && changed)
               {
                 System.err.println("returning true");
                 return true;
               }
           }

         System.err.println("returning false");
       return false;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   private Map<String, Object> getAttributes (final int pageNumber)
     {
       return (pageNumber == selectedPageNumber) ? selectedImage.getAttributes() :
           (preparedPages.contains(pageNumber) ? attributeMapList.get(pageNumber) : new HashMap<String, Object>());
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   private void fixFormatForRenderer (final EditableImage image, final Intent intent) 
     {
       final int n = image.getBitsPerPixel();

       if (intent == Intent.RENDERING)
         {
           // FIXME: this code should be moved into the renderer, but first you have
           // to promote ChangeBufferTypeOp to the core.
           if (n < 24) // they are really slooooow in the renderer
             {
               image.execute(new ChangeBufferTypeOp(BufferedImage.TYPE_3BYTE_BGR));
             }
         }

       else if (intent == Intent.SAVING)
         {
           image.execute(new ChangeBufferTypeOp(BufferedImage.TYPE_BYTE_GRAY));
         }
     }

//    private double getAspect (final Node node)
//      {
//        final Properties properties = new Properties();
//        process(node, "metadata", properties);
//        System.err.println(properties);
//        final double xRes = parseRational(properties.getProperty("metadata.XResolution.value", "1/1"));
//        final double yRes = parseRational(properties.getProperty("metadata.YResolution.value", "1/1"));
//        return xRes / yRes;
//      }
//    
//    private double parseRational (final String s)
//      {
//        int i = (s + "/").indexOf('/');
//        return Double.parseDouble(s.substring(0, i));
//      }
//    
//    private void process (final Node node, final String prefix, final Properties properties)
//      {
//        String name = "";
//
//        for (int i = 0; i < node.getAttributes().getLength(); i++)
//          {
//            Node attr = node.getAttributes().item(i);
//            
//            if ("".equals(name) && "name".equals(attr.getNodeName()))
//              {
//                name = attr.getNodeValue();  
//              }
//            
//            else
//              {
//                properties.put(prefix + "." + attr.getNodeName(), attr.getNodeValue());    
//              }
//          }
//        
//        for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling())
//          {
//            if (!"".equals(name))
//              {
//                name = ":" + name;  
//              }
//            
//            process(child, prefix + name, properties);  
//          }
//      }
 }
