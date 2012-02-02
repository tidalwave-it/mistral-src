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

import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.java2d.ChangeBufferTypeJ2DOp;
import it.tidalwave.image.java2d.ImplementationFactoryJ2D;
import it.tidalwave.image.op.ChangeBufferTypeOp;
import it.tidalwave.image.op.RotateQuadrantOp;
import it.tidalwave.image.render.AnimatedScaleController;
import it.tidalwave.image.render.EditableImageRenderer;
import it.tidalwave.image.render.EditingTool;
import it.tidalwave.image.render.DragPanningController;
import it.tidalwave.image.render.MouseClickZoomingController;
import it.tidalwave.image.render.MouseWheelZoomingController;
import it.tidalwave.image.render.ScaleController;
import it.tidalwave.image.render.event.EditableImageRendererAdapter;
import it.tidalwave.image.render.event.EditableImageRendererEvent;
import it.tidalwave.mistral.faxmanager.bd.FaxServerBD;
import it.tidalwave.mistral.faxmanager.edittool.TextTool;
import it.tidalwave.mistral.faxmanager.edittool.StampTool;
import it.tidalwave.mistral.faxmanager.edittool.EraseTool;
import it.tidalwave.mistral.faxmanager.edittool.CutterTool;
import it.tidalwave.mistral.faxmanager.edittool.PencilTool;
import it.tidalwave.mistral.faxmanager.edittool.MarkerTool;
import it.tidalwave.mistral.faxmanager.edittool.OmissisTool;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import org.openide.util.Lookup;

/*******************************************************************************
*
* @author  Fabrizio Giudici
* @version $Id$
*
******************************************************************************/
public class FaxApplet extends JApplet
 {
   private final static String CLASS = FaxApplet.class.getName();

   private final static Logger logger = Logger.getLogger(CLASS);

   private static final double MARGIN = 0.05f;

   private static final int INITIAL_FONT_SIZE = 9;

   /** The image renderer. */
   private final EditableImageRenderer imageRenderer = new EditableImageRenderer();

   /** The scale controller. */
   private final ScaleController scaleController = new AnimatedScaleController(imageRenderer);

   /** The zooming controller that runs with mouse click. */
   private final MouseClickZoomingController mouseClickZoomingController = new MouseClickZoomingController(scaleController);

   /** The zooming controller that runs with the mouse wheel. */
   private final MouseWheelZoomingController mouseWheelZoomingController = new MouseWheelZoomingController(scaleController);

   /** This controller pans the image with mouse dragging. */
   private final DragPanningController panningController = new DragPanningController(imageRenderer);

   /** The renderer for page thumbnails. */
   private final ThumbnailListCellRenderer thumbnailListCellRenderer = new ThumbnailListCellRenderer(ThumbnailListCellRenderer.Mode.WITHOUT_THUMBNAILS);

   /** The model for pages selection. */
   private final ListSelectionModel pageSelectionModel = new DefaultListSelectionModel();

   /** The pencil tool draws on the fax. */
   private final PencilTool pencilTool = new PencilTool(imageRenderer);

   /** The erase tool erases portions of the fax. */
   private final EraseTool eraseTool = new EraseTool(imageRenderer);

   /** The erase tool erases portions of the fax. */
   private final OmissisTool omissisTool = new OmissisTool(imageRenderer);

   /** The marker tool paints with yellow portions of the fax. */
   private final MarkerTool markerTool = new MarkerTool(imageRenderer);

   /** The text tool draws text on the fax. */
   private final TextTool textTool = new TextTool(imageRenderer);

   /** The page manager. */
   private final PageManager pageManager = new PageManager(thumbnailListCellRenderer);

   /** The cutter tool splits the fax in pages. */
   private final CutterTool cutterTool = new CutterTool(imageRenderer, pageManager, pageSelectionModel);

   /** The stamp tool registers the document. */
   private StampTool stampTool; //  = new StampTool(imageRenderer);

   private String faxName;

   private boolean disablePageChange;

   private int totalPageNumber = -1;

   public void setPageIndex (final int pageIndex)
     {
       final Cursor saveCursor = getCursor();
       try
         {
           setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
           final EditableImage image = pageManager.selectImage(pageIndex);
           imageRenderer.setImage(image);
           setNewPageSettings(image);
         }
       finally
         {
            setCursor(saveCursor);
         }
     }

   protected boolean isPrinting = false;

   /***************************************************************************
    *
    *
    **************************************************************************/
   abstract class GuardedAction extends AbstractAction
     {
        @Override
       public final void actionPerformed (final ActionEvent event)
         {
           try
             {
               performAction(event);
             }
           catch (Throwable t)
             {
               logger.throwing(CLASS, "", t);
               JOptionPane.showMessageDialog(FaxApplet.this, t.toString(), "Errore imprevisto", JOptionPane.ERROR_MESSAGE);
             }
         }

       protected abstract void performAction (final ActionEvent event)
         throws Exception;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   private Action reloadAction = new GuardedAction()
     {
        @Override
       protected void performAction (final ActionEvent event)
         {
           if (JOptionPane.showConfirmDialog(FaxApplet.this, "Vuoi veramente ricaricare il fax annullando tutte le modifiche?", "Conferma", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
             {
               loadFax();
             }
         }
     };

   enum DialogStrategy
     {
       DIALOG
         {
            @Override
           public PrintSelectionDialog.Selection getSelection()
             {
               final PrintSelectionDialog psDialog = new PrintSelectionDialog();
               final JDialog dialog = new JDialog((JFrame)null, "Stampa", true);
               dialog.getContentPane().add(psDialog);
               dialog.pack();
               dialog.setLocation(200, 200);
               dialog.setVisible(true);
               return psDialog.getSelection();
             }

            @Override
           public void notifyCompleted (final Component component)
             {
               JOptionPane.showMessageDialog(component, "Completata.", "Stampa", JOptionPane.WARNING_MESSAGE);
             }
         },

       NO_DIALOG
         {
            @Override
           public PrintSelectionDialog.Selection getSelection()
             {
               return PrintSelectionDialog.Selection.ALL;
             }

            @Override
           public void notifyCompleted (final Component component)
             {
             }
         };

       public abstract PrintSelectionDialog.Selection getSelection();

       public abstract void notifyCompleted (final Component component);
     };

   /***************************************************************************
    *
    *
    **************************************************************************/
   private MouseListener mouseListener = new MouseAdapter() 
     {
       @Override
       public void mousePressed(MouseEvent e) 
         {
           System.err.println(e + " c:" + hasBeenChanged() + " p:" + hasBeenPunched());
         }   
     };

   /***************************************************************************
    *
    *
    **************************************************************************/
   private Action printAction = new GuardedAction()
     {
        @Override
       protected void performAction (final ActionEvent event)
         throws PrinterException
         {
           print(FaxApplet.DialogStrategy.DIALOG);
         }
     };

   private Action fastPrintAction = new GuardedAction()
     {
        @Override
       protected void performAction (final ActionEvent event)
         throws PrinterException
         {
           print(FaxApplet.DialogStrategy.NO_DIALOG);
         }
     };

   /***************************************************************************
    *
    *
    **************************************************************************/
   private Action rotateLeftAction = new GuardedAction()
     {
        @Override
       protected void performAction (final ActionEvent event)
         {
           EditableImage image = imageRenderer.getImage();
           image = image.execute2(new RotateQuadrantOp(+90));
           image.setAttribute(EditingTool.CHANGED_ATTRIBUTE, true);
           pageManager.storeImage(image, pageManager.getPageNumber());
           imageRenderer.setImage(image);
           imageRenderer.centerImage();
         }
     };

   /***************************************************************************
    *
    *
    **************************************************************************/
   private Action rotateRightAction = new GuardedAction()
     {
        @Override
       protected void performAction (final ActionEvent event)
         {
           EditableImage image = imageRenderer.getImage();
           image = image.execute2(new RotateQuadrantOp(-90));
           image.setAttribute(EditingTool.CHANGED_ATTRIBUTE, true);
           pageManager.storeImage(image, pageManager.getPageNumber());
           imageRenderer.setImage(image);
           imageRenderer.centerImage();
         }
     };

   /***************************************************************************
    *
    *
    **************************************************************************/
   private Action saveAction = new GuardedAction()
     {
        @Override
       protected void performAction (final ActionEvent event)
         {
           final EditingTool editingTool = imageRenderer.getEditingTool();

           if (editingTool != null)
             {
               editingTool.commitChanges();
             }

           String url = null;

           try
             {
               url = getParameter("putFaxURL");
             }
           catch (NullPointerException e)
             {
//                url = "http://localhost:8080/FaxServer/PutFax";
               url = "http://192.168.50.4:9999/PutFax";
             }

           final String url2 = url;

           final Thread thread = new Thread(new Runnable()
             {
                @Override
               public void run()
                 {
                   try
                     {
                       faxName = pageManager.save(faxName, url2, pbProgressBar);
                       thumbnailListCellRenderer.clear();
                       JOptionPane.showMessageDialog(FaxApplet.this, "Completata.", "Archiviazione fax", JOptionPane.WARNING_MESSAGE);
                     }
                   catch (Throwable t)
                     {
                       logger.throwing(CLASS, "", t);
                       JOptionPane.showMessageDialog(FaxApplet.this, "Fax non archiviato a causa di un errore.", "Archiviazione fax", JOptionPane.WARNING_MESSAGE);
                     }
                 }
             });

           thread.start();
         }
     };

   /***************************************************************************
    *
    *
    **************************************************************************/
   private final DefaultComboBoxModel fontFamilyModel = new DefaultComboBoxModel()
     {{
        addElement("Arial");
        addElement("Courier");
        addElement("Times New Roman");
        setSelectedItem("Arial");
     }};

   /***************************************************************************
    *
    *
    **************************************************************************/
   private final DefaultComboBoxModel fontSizeModel = new DefaultComboBoxModel()
     {{
        for (int size = 6; size < 40; size++)
          {
            addElement(size);
          }

        setSelectedItem(INITIAL_FONT_SIZE);
     }};

   /***************************************************************************
    *
    * Initializes the applet FaxApplet.
    *
    **************************************************************************/
   @Override
   public void init()
     {
       setupLog();
       addMouseListener(mouseListener);
       Lookup.getDefault().lookup(ImplementationFactoryJ2D.class).registerImplementation(ChangeBufferTypeOp.class, ChangeBufferTypeJ2DOp.class);

       try
         {
           EventQueue.invokeAndWait(new Runnable()
             {
                @Override
               public void run()
                 {
                   initComponents();
//                    imageRenderer.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
//                    logger.info("Workaround for MST-63 disabled");
//                    imageRenderer.setScaledImageCachingEnabled(false);
//                    imageRenderer.setOptimizedImageEnabled(false);
                   pnImageViewer.setLayout(new BorderLayout());
                   pnImageViewer.add(imageRenderer, BorderLayout.CENTER);
                   liPageList.setModel(pageManager.getThumbnailsModel());
                   liPageList.setSelectionModel(pageSelectionModel);
                   liPageList.setCellRenderer(thumbnailListCellRenderer);

                   pencilTool.setIcon(new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/pencil.png")));
                   eraseTool.setIcon(new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/kcmdevices.png")));
                   omissisTool.setIcon(new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/omissis.png")));
                   markerTool.setIcon(new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/edit-clear.png")));
                   textTool.setIcon(new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/applixware.png")));
                   cutterTool.setIcon(new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/edit-cut_1.png")));
                   cutterTool.setEndActionIcon(new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/edit-cut.png")));
                   cutterTool.addEndActionButton(btCloseCutter);

                   printAction.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/print.png")));
                   fastPrintAction.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/fast_print.png")));
                   rotateLeftAction.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/left.png")));
                   rotateRightAction.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/right.png")));
                   reloadAction.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/reload.png")));

                   pencilTool.connectButton(btPencil);
                   eraseTool.connectButton(btRubber);
                   omissisTool.connectButton(btOmissis);
//                    markerTool.connectButton(btMarker);
                   textTool.connectButton(btText);
                   cutterTool.connectButton(btCutter);

                   pencilTool.setEnabled(false);
                   markerTool.setEnabled(false);
                   textTool.setEnabled(false);
                   cutterTool.setEnabled(false);
                   eraseTool.setEnabled(false);
                   printAction.setEnabled(false);
                   rotateLeftAction.setEnabled(false);
                   rotateRightAction.setEnabled(false);

                   mouseClickZoomingController.setClickCountToZoom(2);
                   mouseClickZoomingController.setEnabled(true);
                   mouseClickZoomingController.setFactor(1 - MARGIN);
                   mouseWheelZoomingController.setEnabled(true);
                   panningController.setEnabled(true);

                   imageRenderer.setMaxScale(2);

                   // FIXME: should be better to have EditingTool appear in the listener list before the controllers,
                   // so it could just consume the events.
                   imageRenderer.addImageRendererListener(new EditableImageRendererAdapter()
                     {
                       @Override
                       public void toolActivated (final EditableImageRendererEvent event)
                         {
                           mouseClickZoomingController.setEnabled(false);
                           panningController.setEnabled(false);
                         }

                       @Override
                       public void toolDeactivated (final EditableImageRendererEvent event)
                         {
                           mouseClickZoomingController.setEnabled(true);
                           panningController.setEnabled(true);
                         }
                     });
                 }
             });
         }
       catch (Exception e)
         {
           e.printStackTrace();
         }
     }

   private String getFaxURL = null;
   private String getStampURL = null;
   private String pages = null;

   /***************************************************************************
    *
    *
    **************************************************************************/

   private String printerName = "Samsung_ML";
   private MediaPrintableArea mediaPrintableArea;
   private MediaSizeName mediaSizeName = MediaSizeName.ISO_A4;
   private OrientationRequested orientation = OrientationRequested.PORTRAIT;

   @Override
   public void start()
     {
       logger.info("Max memory: " + Runtime.getRuntime().maxMemory() + ", total memory: " + Runtime.getRuntime().totalMemory());

       try
         {
           getFaxURL = getParameter("getFaxURL");
           getStampURL = getParameter("getStampURL");
           pages = getParameter("pages");
           faxName = getParameter("name");
           final String tpn = getParameter("totalPageNumber");

           if ((tpn != null) && !"".equals(tpn))
             {
               totalPageNumber = Integer.valueOf(tpn);
             }

           printerName = getParameter("printerName");
           final String margins = getParameter("margins");

           if (margins != null)
             {
               final String[] temp = margins.split(",");
               final int left = Integer.parseInt(temp[0]);
               final int top = Integer.parseInt(temp[1]);
               final int right = Integer.parseInt(temp[2]);
               final int bottom = Integer.parseInt(temp[3]);

               final MediaSize mediaSize = MediaSize.getMediaSizeForName(mediaSizeName);
               final float[] size = mediaSize.getSize(MediaSize.MM);
               mediaPrintableArea = new MediaPrintableArea(left, top, size[0] - left - right, size[1] - top - bottom, MediaPrintableArea.MM);
             }
         }

       catch (NullPointerException e) // we're not an applet, called from a main() for test
         {
           faxName = "Fax_1.tif";
//            pages = "1,2,3";
//            getStampURL = "http://localhost:8080/FaxServer/Stamp";
         }

       try
         {
           stampTool = new StampTool(imageRenderer, FaxServerBD.getInstance(null, getStampURL));
           stampTool.setIcon(new ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/stamp.png")));
           stampTool.connectButton(btStamp);

           loadFax();

           setEnablement(pencilTool, "pencilDisabled");
           setEnablement(markerTool, "markerDisabled");
           setEnablement(textTool, "textDisabled");
           setEnablement(cutterTool, "cutterDisabled");
           setEnablement(eraseTool, "eraseDisabled");
           setEnablement(omissisTool, "eraseDisabled");
           setEnablement(stampTool, "stampDisabled");
           setEnablement(printAction, "printDisabled");
           setEnablement(rotateLeftAction, "rotateDisabled");
           setEnablement(rotateRightAction, "rotateDisabled");
           setEnablement(saveAction, "saveDisabled");
         }
       catch (OutOfMemoryError e)
         {
           logger.throwing(CLASS, "", e);
           JOptionPane.showMessageDialog(this, "Memoria non sufficiente.", "Errore apertura fax", JOptionPane.ERROR_MESSAGE);
         }
       catch (Exception e)
         {
           logger.throwing(CLASS, "", e);
           JOptionPane.showMessageDialog(this, e.toString(), "Errore apertura fax", JOptionPane.ERROR_MESSAGE);
         }
     }

  private void loadFax()
    {
       thumbnailListCellRenderer.clear();
       pageSelectionModel.clearSelection();
       pbProgressBar.setVisible(true);
       pbProgressBar.setIndeterminate(true);
       pbProgressBar.setValue(0);
       pbProgressBar.setMaximum(100);
       pbProgressBar.setStringPainted(true);
       pbProgressBar.setString("Caricamento fax in corso...");

       final Thread thread = new Thread(new Runnable()
         {
           private boolean first = true;

            @Override
           public void run()
             {
               try
                 {
                   pageManager.load(pages, getFaxURL, new PageManager.Listener()
                     {
                        @Override
                       public void notifyPageLoaded (final int index)
                         {
                           if (first)
                             {
                               SwingUtilities.invokeLater(new Runnable()
                                 {
                                    @Override
                                   public void run()
                                     {
                                       loadImage(pageManager.selectImage(index));
                                     }
                                 });

                               first = false;
                             }
                         }
                     }, totalPageNumber);

                   SwingUtilities.invokeLater(new Runnable()
                     {
                        @Override
                       public void run()
                         {
                           pbProgressBar.setVisible(false);
                           disablePageChange = true;
                           pageSelectionModel.setSelectionInterval(0, 0);
                         }
                     });
                 }
               catch (MalformedURLException e)
                 {
                   logger.throwing(CLASS, "", e);
                 }
               catch (IOException e)
                 {
                   logger.throwing(CLASS, "", e);
                 }
             }
         });

       thread.start();
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public void loadImage (final EditableImage image)
     {
       imageRenderer.setImage(image);
       setNewPageSettings(image);
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   private void setNewPageSettings (final EditableImage image)
     {
//        final int hMargin = (int)Math.round(MARGIN * image.getWidth());
//        final int vMargin = (int)Math.round(MARGIN * image.getHeight());
//        imageRenderer.setMargin(new Insets(vMargin, hMargin, vMargin, hMargin));
//        scaleController.fitToView(1.0 - MARGIN);
       final double scale = (double) (imageRenderer.getWidth()) / image.getWidth();
       logger.info("Initial scale:" + scale);
       imageRenderer.setPositionOverImage(new Point(0, 0), new Point(0, 0));
       scaleController.setScale(scale);
       imageRenderer.setPositionOverImage(new Point(0, 0), new Point(0, 0));
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   // indica se sono state bollate tutte le pagine del fax corrente
   public boolean hasBeenPunched()
     {
       return pageManager.isFullyPunched();
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   public String getPunchString()
     {
       return stampTool.getStampCode();
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   // indica il numero di pagine totali
   public int getTotalPagesNumber()
     {
       return pageManager.getPageCount();
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   // indica la pagina correntemente visualizzata
   public int getCurrentPageNumber()
     {
       return liPageList.getSelectedIndex();
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   // indica le pagine correntemente selezionate
   public int[] getSelectedPagesNumbers()
     {
       final List<Integer> list = pageManager.getVisiblePageNumbers();
       final int[] result = new int[list.size()];

       for (int i = 0; i < result.length; i++)
         {
           result[i] = list.get(i);
         }

       return result;
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   // indica se sono state fatte modifiche dopo l'apertura o l'ultimo salvataggio
   public boolean hasBeenChanged()
     {
       return pageManager.isChanged();
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   // ritorna l'id (=nome) del fax
   public String getIdentifier()
     {
       return faxName;
     }

     /***************************************************************************
      *
      *
      **************************************************************************/
     // indica se l'applet è in fase di stampa
     public boolean isPrinting()
       {
         return isPrinting;
       }

   /***************************************************************************
    *
    *
    **************************************************************************/
   private void setEnablement (final EditingTool editingTool, final String propertyName)
     {
       boolean enabled = true;
       String propertyValue = null;

       try
         {
           propertyValue = getParameter(propertyName);

           if ((propertyValue != null) && "true".equalsIgnoreCase(propertyValue))
             {
               enabled = false;
             }
         }
       catch (NullPointerException e) // not in an applet
         {
           //
         }

       editingTool.setEnabled(enabled);
       logger.info("Enablement status for: " + editingTool + " is " + editingTool.isEnabled() +
                          "; parameter was: " + propertyName + "=" + propertyValue);
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   private void setEnablement (final Action action, final String propertyName)
     {
       boolean enabled = true;
       String propertyValue = null;

       try
         {
           propertyValue = getParameter(propertyName);

           if ((propertyValue != null) && "true".equalsIgnoreCase(propertyValue))
             {
               enabled = false;
             }
         }
       catch (NullPointerException e) // not in an applet
         {
           //
         }

       action.setEnabled(enabled);
       logger.info("Enablement status for: " + action + " is " + action.isEnabled() +
                          "; parameter was: " + propertyName + "=" + propertyValue);
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   private void changeFont()
     {
       final String fontFamily = (String)fontFamilyModel.getSelectedItem();
       final Integer fontSize = (Integer)fontSizeModel.getSelectedItem();
       textTool.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
     }

   /***************************************************************************
    *
    *
    **************************************************************************/
   private void setupLog()
     {
       try
         {
           InputStream is = getClass().getResourceAsStream("log.properties");
           LogManager.getLogManager().readConfiguration(is);
           is.close();
         }
       catch (Exception e)
         {
           e.printStackTrace();
         }
     }

   protected void print (final DialogStrategy dialogStrategy)
     throws PrinterException
     {
       logger.info("printAction.actionPerformed()");

       isPrinting = true;

       final PrintSelectionDialog.Selection selection = dialogStrategy.getSelection();
       logger.fine(">>>> selection: " + selection);

       if (selection != PrintSelectionDialog.Selection.NONE)
         {
           final PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
           aset.add(orientation);
           aset.add(mediaSizeName);

           if (mediaPrintableArea != null)
             {
               aset.add(mediaPrintableArea);
             }

           final Thread thread = new Thread(new Runnable()
             {
                @Override
               public void run()
                 {
                   try
                     {
                       pageManager.printPages(selection.getPageList(pageManager), pbProgressBar, printerName, aset, dialogStrategy == FaxApplet.DialogStrategy.DIALOG);
                       dialogStrategy.notifyCompleted(FaxApplet.this);
                       isPrinting = false;
                     }
                   catch (Throwable t)
                     {
                       logger.throwing(CLASS, "", t);
                       JOptionPane.showMessageDialog(FaxApplet.this, "Fax non stampato a causa di un errore.", "Stampa fax", JOptionPane.WARNING_MESSAGE);
                       isPrinting = false;
                     }
                 }
             });

           thread.start();
         }
       else
         {
           isPrinting = false;
         }
     }




   /***************************************************************************
    *
    * This method is called from within the init() method to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    *
    **************************************************************************/
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

       pnImageViewer = new javax.swing.JPanel();
       jPanel1 = new javax.swing.JPanel();
       btFontFamily = new javax.swing.JComboBox();
       btFontSize = new javax.swing.JComboBox();
       tbToolBar = new javax.swing.JToolBar();
       btSave = new javax.swing.JButton();
       btReload = new javax.swing.JButton();
       btPencil = new javax.swing.JToggleButton();
       btText = new javax.swing.JToggleButton();
       btRubber = new javax.swing.JToggleButton();
       btOmissis = new javax.swing.JToggleButton();
       btCutter = new javax.swing.JToggleButton();
       btCloseCutter = new javax.swing.JButton();
       btStamp = new javax.swing.JToggleButton();
       btRotateLeft = new javax.swing.JButton();
       btRotateRight = new javax.swing.JButton();
       btPrint = new javax.swing.JButton();
       btPrintAuto = new javax.swing.JButton();
       btActualPixels = new javax.swing.JButton();
       btZoomIn = new javax.swing.JButton();
       btZoomOut = new javax.swing.JButton();
       btFitToWindow = new javax.swing.JButton();
       jScrollPane1 = new javax.swing.JScrollPane();
       liPageList = new javax.swing.JList();
       pbProgressBar = new javax.swing.JProgressBar();

       pnImageViewer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new Color(210, 210, 210), new Color(190, 190, 190), null, null));

       org.jdesktop.layout.GroupLayout pnImageViewerLayout = new org.jdesktop.layout.GroupLayout(pnImageViewer);
       pnImageViewer.setLayout(pnImageViewerLayout);
       pnImageViewerLayout.setHorizontalGroup(
           pnImageViewerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(0, 767, Short.MAX_VALUE)
       );
       pnImageViewerLayout.setVerticalGroup(
           pnImageViewerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(0, 399, Short.MAX_VALUE)
       );

       btFontFamily.setModel(fontFamilyModel);
       btFontFamily.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               btFontFamilyActionPerformed(evt);
           }
       });

       btFontSize.setModel(fontSizeModel);
       btFontSize.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               btFontSizeActionPerformed(evt);
           }
       });

       tbToolBar.setFloatable(false);

       btSave.setAction(saveAction);
       btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/filesave.png"))); // NOI18N
       btSave.setToolTipText("Salva il fax");
       tbToolBar.add(btSave);

       btReload.setAction(reloadAction);
       btReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/reload.png"))); // NOI18N
       btReload.setToolTipText("Annulla modifiche e ricarica");
       btReload.setFocusable(false);
       btReload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
       btReload.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
       tbToolBar.add(btReload);

       btPencil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/pencil.png"))); // NOI18N
       btPencil.setToolTipText("Disegno a mano libera");
       tbToolBar.add(btPencil);

       btText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/applixware.png"))); // NOI18N
       btText.setToolTipText("Disegna testo");
       tbToolBar.add(btText);

       btRubber.setText("rb");
       btRubber.setToolTipText("Cancella area");
       tbToolBar.add(btRubber);

       btOmissis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/omissis.png"))); // NOI18N
       btOmissis.setToolTipText("Omissis");
       //btOmissis.setBorderPainted(false);
       btOmissis.setFocusable(false);
       btOmissis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
       btOmissis.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
       tbToolBar.add(btOmissis);

       btCutter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/edit-cut.png"))); // NOI18N
       btCutter.setToolTipText("Posiziona taglierina");
       tbToolBar.add(btCutter);

       btCloseCutter.setText("ct");
       btCloseCutter.setToolTipText("Aziona taglierina");
       tbToolBar.add(btCloseCutter);

       btStamp.setText("sst");
       btStamp.setToolTipText("Timbro");
       tbToolBar.add(btStamp);

       btRotateLeft.setAction(rotateLeftAction);
       btRotateLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/left.png"))); // NOI18N
       btRotateLeft.setToolTipText("Ruota in senso antiorario");
       tbToolBar.add(btRotateLeft);

       btRotateRight.setAction(rotateRightAction);
       btRotateRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/right.png"))); // NOI18N
       btRotateRight.setToolTipText("Ruota in senso orario");
       tbToolBar.add(btRotateRight);

       btPrint.setAction(printAction);
       btPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/print.png"))); // NOI18N
       btPrint.setToolTipText("Stampa...");
       tbToolBar.add(btPrint);

       btPrintAuto.setAction(fastPrintAction);
       btPrintAuto.setToolTipText("Stampa Rapida");
       btPrintAuto.setFocusable(false);
       btPrintAuto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
       btPrintAuto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
       tbToolBar.add(btPrintAuto);

       btActualPixels.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/viewmag1.png"))); // NOI18N
       btActualPixels.setToolTipText("Dimensioni reali");
       btActualPixels.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               btActualPixelsActionPerformed(evt);
           }
       });
       tbToolBar.add(btActualPixels);

       btZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/viewmag+.png"))); // NOI18N
       btZoomIn.setToolTipText("Ingrandisci");
       btZoomIn.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               btZoomInActionPerformed(evt);
           }
       });
       tbToolBar.add(btZoomIn);

       btZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/viewmag-.png"))); // NOI18N
       btZoomOut.setToolTipText("Rimpicciolisci");
       btZoomOut.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               btZoomOutActionPerformed(evt);
           }
       });
       tbToolBar.add(btZoomOut);

       btFitToWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/tidalwave/mistral/faxmanager/icons/viewmagfit.png"))); // NOI18N
       btFitToWindow.setToolTipText("Visualizza tutto");
       btFitToWindow.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               btFitToWindowActionPerformed(evt);
           }
       });
       tbToolBar.add(btFitToWindow);

       org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
               .add(tbToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 260, Short.MAX_VALUE)
               .add(btFontFamily, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
               .add(btFontSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(btFontSize, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(btFontFamily, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
           .add(tbToolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
       );

       jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

       liPageList.setModel(new javax.swing.AbstractListModel() {
           String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
           public int getSize() { return strings.length; }
           public Object getElementAt(int i) { return strings[i]; }
       });
       liPageList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
           public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
               liPageListValueChanged(evt);
           }
       });
       jScrollPane1.setViewportView(liPageList);

       org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(layout.createSequentialGroup()
               .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                   .add(pbProgressBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                   .add(pnImageViewer, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
               .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
           .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(layout.createSequentialGroup()
               .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
               .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                   .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                       .add(pnImageViewer, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                       .add(pbProgressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                   .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)))
       );
   }// </editor-fold>//GEN-END:initComponents

   private void liPageListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_liPageListValueChanged
       if (!disablePageChange)
         {
           setPageIndex(liPageList.getSelectedIndex());
         }

       disablePageChange = false;
   }//GEN-LAST:event_liPageListValueChanged

   private void btFontSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFontSizeActionPerformed
      changeFont();
   }//GEN-LAST:event_btFontSizeActionPerformed

   private void btFontFamilyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFontFamilyActionPerformed
      changeFont();
   }//GEN-LAST:event_btFontFamilyActionPerformed

   private void btFitToWindowActionPerformed(java.awt.event.ActionEvent event)//GEN-FIRST:event_btFitToWindowActionPerformed
   {//GEN-HEADEREND:event_btFitToWindowActionPerformed
       scaleController.fitToView(1.0 - MARGIN);
   }//GEN-LAST:event_btFitToWindowActionPerformed

   private void btZoomOutActionPerformed(java.awt.event.ActionEvent event)//GEN-FIRST:event_btZoomOutActionPerformed
   {//GEN-HEADEREND:event_btZoomOutActionPerformed
       scaleController.zoomOut();
   }//GEN-LAST:event_btZoomOutActionPerformed

   private void btZoomInActionPerformed(java.awt.event.ActionEvent event)//GEN-FIRST:event_btZoomInActionPerformed
   {//GEN-HEADEREND:event_btZoomInActionPerformed
       scaleController.zoomIn();
   }//GEN-LAST:event_btZoomInActionPerformed

   private void btActualPixelsActionPerformed(java.awt.event.ActionEvent event)//GEN-FIRST:event_btActualPixelsActionPerformed
   {//GEN-HEADEREND:event_btActualPixelsActionPerformed
       scaleController.showActualPixels();
   }//GEN-LAST:event_btActualPixelsActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btActualPixels;
   private javax.swing.JButton btCloseCutter;
   private javax.swing.JToggleButton btCutter;
   private javax.swing.JButton btFitToWindow;
   private javax.swing.JComboBox btFontFamily;
   private javax.swing.JComboBox btFontSize;
   private javax.swing.JToggleButton btOmissis;
   private javax.swing.JToggleButton btPencil;
   private javax.swing.JButton btPrint;
   private javax.swing.JButton btPrintAuto;
   private javax.swing.JButton btReload;
   private javax.swing.JButton btRotateLeft;
   private javax.swing.JButton btRotateRight;
   private javax.swing.JToggleButton btRubber;
   private javax.swing.JButton btSave;
   private javax.swing.JToggleButton btStamp;
   private javax.swing.JToggleButton btText;
   private javax.swing.JButton btZoomIn;
   private javax.swing.JButton btZoomOut;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JList liPageList;
   private javax.swing.JProgressBar pbProgressBar;
   private javax.swing.JPanel pnImageViewer;
   private javax.swing.JToolBar tbToolBar;
   // End of variables declaration//GEN-END:variables
}

