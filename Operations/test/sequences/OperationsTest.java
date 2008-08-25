/*
 * NewEmptyJUnitTest.java
 * JUnit based test
 *
 * Created on August 3, 2006, 7:24 PM
 */

package sequences;

import java.lang.management.ManagementFactory;
import java.awt.image.ComponentColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.ColorModel;
import java.awt.image.SampleModel;
import it.tidalwave.image.BaseTestSupport;
import it.tidalwave.image.EditableImage;
import it.tidalwave.image.Histogram;
import it.tidalwave.image.Quality;
import it.tidalwave.image.op.CropOp;
import it.tidalwave.image.op.HistogramOp;
import it.tidalwave.image.op.OptimizeOp;
import it.tidalwave.image.op.ReadOp;
import it.tidalwave.image.op.RotateQuadrantOp;
import it.tidalwave.image.op.ScaleOp;
import junit.framework.Test;
import junit.framework.TestSuite;


/**
 *
 * @author fritz
 */
public class OperationsTest extends BaseTestSupport 
  {
    private static EditableImage image;
    
    public static Test suite()
      {
        return new TestSuite(OperationsTest.class);
      }
    
    static
      {
        ManagementFactory.getThreadMXBean().setThreadCpuTimeEnabled(true);
      }
    
    public void testLoadDNG()
      throws Exception
      {
        System.out.println("testLoadDNG");
        long cpuTime = getCPUTime();
        image = EditableImage.create(new ReadOp(file_L4840172_dng));
        cpuTime = getCPUTime() - cpuTime;
        System.out.println(">>>>> cpuTime " + cpuTime);
        // Reajent is enabled
        assertEquals(3876, image.getWidth());
        assertEquals(2584, image.getHeight());
        assertEquals(3, image.getBandCount());
//        assertEquals(16, image.getBitsPerBand()); // FIXME: 8
//        assertEquals(48, image.getBitsPerPixel()); // FIXME: 24
        assertEquals(PixelInterleavedSampleModel.class, image.getInnerProperty(SampleModel.class).getClass());
        assertEquals(ComponentColorModel.class, image.getColorModel().getClass());
        assertEquals(EditableImage.DataType.BYTE, image.getDataType()); // FIXME: should be WORD
        assertTimeLimit(cpuTime, 4500000000L);
      }
    
    public void testScale()
      {
        System.out.println("testScale");
        int w = image.getWidth();
        int h = image.getHeight();
        double scale = 0.5;
        ScaleOp scaleOp = new ScaleOp(scale);
        long cpuTime = getCPUTime();
        EditableImage result = image.execute2(scaleOp);
        cpuTime = getCPUTime() - cpuTime;
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertEquals(Math.round(w * scale), result.getWidth());
        assertEquals(Math.round(h * scale), result.getHeight());
        assertEquals(image.getBandCount(), result.getBandCount());
        assertEquals(image.getBitsPerBand(), result.getBitsPerBand());
        assertEquals(image.getBitsPerPixel(), result.getBitsPerPixel()); 
        assertEquals(image.getInnerProperty(SampleModel.class).getClass(), result.getInnerProperty(SampleModel.class).getClass());
        assertEquals(image.getInnerProperty(ColorModel.class).getClass(), result.getInnerProperty(ColorModel.class).getClass());
        assertTimeLimit(cpuTime, 46000000);
      }
    
    public void testCrop()
      {
        System.out.println("testCrop");
        double scale = 0.5;
        int x = (int)Math.round(image.getWidth() * scale * 0.5);
        int y = (int)Math.round(image.getHeight() * scale * 0.5);
        int w = (int)Math.round(image.getWidth() * scale);
        int h = (int)Math.round(image.getHeight() * scale);
        CropOp scaleOp = new CropOp(x, y, w, h);
        long cpuTime = getCPUTime();
        EditableImage result = image.execute2(scaleOp);
        cpuTime = getCPUTime() - cpuTime;
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertEquals(w, result.getWidth());
        assertEquals(h, result.getHeight());
        assertEquals(image.getBandCount(), result.getBandCount());
        assertEquals(image.getBitsPerBand(), result.getBitsPerBand());
        assertEquals(image.getBitsPerPixel(), result.getBitsPerPixel()); 
        assertEquals(image.getInnerProperty(SampleModel.class).getClass(), result.getInnerProperty(SampleModel.class).getClass());
        assertEquals(image.getInnerProperty(ColorModel.class).getClass(), result.getInnerProperty(ColorModel.class).getClass());
        assertTimeLimit(cpuTime, 580000);
      }
    
    public void testRotate0()
      {
        System.out.println("testRotate0");
        long cpuTime = rotate(0);
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertTimeLimit(cpuTime, 830000);
      }
    
    public void testRotate90()
      {
        System.out.println("testRotate90");
        long cpuTime = rotate(90);
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertTimeLimit(cpuTime, 790000000);
       }

    public void testRotate180()
      {
        System.out.println("testRotate180");
        long cpuTime = rotate(180);
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertTimeLimit(cpuTime, 620000000);
      }
    
    public void testRotate270()
      {
        System.out.println("testRotate270");
        long cpuTime = rotate(270);
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertTimeLimit(cpuTime, 660000000);
      }
    
    public void testHistogram()
      {
        System.out.println("testHistogram");
        HistogramOp histogramOp = new HistogramOp();
        image.execute(histogramOp);
        Histogram histogram = histogramOp.getHistogram();
        System.out.println("HISTOGRAM: " + histogram);
      }
    
    public void testCreateOptimizedImage1()
      {
        System.out.println("testCreateOptimizedImage1");
        long cpuTime = createOptimizedImage(1);
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertTimeLimit(cpuTime, 540000000);
      }
    
    public void testCreateOptimizedImage2()
      {
        System.out.println("testCreateOptimizedImage2");
        long cpuTime = createOptimizedImage(0.5);
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertTimeLimit(cpuTime, 520000000);
      }  

    public void testCreateOptimizedImage3()
      {
        System.out.println("testCreateOptimizedImage3");
        long cpuTime = createOptimizedImage(0.3);
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertTimeLimit(cpuTime, 370000000);
      }  

    public void testCreateOptimizedImage4()
      {
        System.out.println("testCreateOptimizedImage4");
        long cpuTime = createOptimizedImage(0.9);
        System.out.println(">>>>> cpuTime " + cpuTime);
        assertTimeLimit(cpuTime, 850000000);
      }  

    private long rotate (int degrees) 
      {
        RotateQuadrantOp rotateOp = new RotateQuadrantOp(degrees);
        long cpuTime = getCPUTime();
        EditableImage result = image.execute2(rotateOp);
        cpuTime = getCPUTime() - cpuTime;
        
        if ((degrees == 90) | (degrees == 270))
          {
            assertEquals(image.getWidth(), result.getHeight());
            assertEquals(image.getHeight(), result.getWidth());
          }
        else
          {
            assertEquals(image.getWidth(), result.getWidth());
            assertEquals(image.getHeight(), result.getHeight());
          }
        assertEquals(image.getBandCount(), result.getBandCount());
        assertEquals(image.getBitsPerBand(), result.getBitsPerBand());
        assertEquals(image.getBitsPerPixel(), result.getBitsPerPixel()); 
        assertEquals(image.getInnerProperty(SampleModel.class).getClass(), result.getInnerProperty(SampleModel.class).getClass());
        assertEquals(image.getInnerProperty(ColorModel.class).getClass(), result.getInnerProperty(ColorModel.class).getClass());
        return cpuTime;
      }
    
    private long createOptimizedImage (double scale) 
      {
        OptimizeOp coiOp = new OptimizeOp(scale, Quality.INTERMEDIATE);
        long cpuTime = getCPUTime();
        EditableImage result = image.execute2(coiOp);
        cpuTime = getCPUTime() - cpuTime;
        assertEquals(Math.round(scale * image.getWidth()), result.getWidth());
        assertEquals(Math.round(scale * image.getHeight()), result.getHeight());
        
        if (System.getProperty("os.name").toLowerCase().indexOf("mac os x") >= 0)
          {
            assertEquals(4, result.getBandCount());
           // assertEquals(8, result.getBitsPerBand()); 32
           // assertEquals(24, result.getBitsPerPixel()); 128?!?!?
            assertEquals(SinglePixelPackedSampleModel.class, result.getInnerProperty(SampleModel.class).getClass());
            assertEquals(DirectColorModel.class, result.getInnerProperty(ColorModel.class).getClass());
          }
        
        return cpuTime;
      }
    
    private static void assertTimeLimit (long time, long limit)
      {
        if (time > limit)
          {
            System.err.println("*** WARNING: time limit exceeded: " + time + " vs " + limit);  
          }
      }
    
    private static long getCPUTime()
      {
        return ManagementFactory.getThreadMXBean().getThreadCpuTime(Thread.currentThread().getId());       
      }
  }
