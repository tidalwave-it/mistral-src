/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2011 by Tidalwave s.a.s.
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
 * SCM: https://kenai.com/hg/mistral~src
 *
 **********************************************************************************************************************/
package it.tidalwave.image;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import it.tidalwave.image.metadata.Directory;
import it.tidalwave.image.metadata.EXIF;
import it.tidalwave.image.metadata.IPTC;
import it.tidalwave.image.metadata.TIFF;
import it.tidalwave.image.op.ReadOp;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 *
 * @author  Fabrizio Giudici
 * @version $Id$
 *
 ******************************************************************************/
public class EditableImageTest extends BaseTestSupport
  {
    @Test
    public void testPropertiesWithJPG()
      throws IOException                                  
      {
        _testProperties(file_20030701_0043_jpg, 3000, 1995, 3, 8, 24, EditableImage.DataType.BYTE);     
      }
    
    @Test
    public void testReadMetadataFromJPEGWithBM25() 
      throws Exception
      {
        System.out.println("testLoadEXIFFromJPEGWithBM25");
        EditableImage image = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
        assertEquals(3, image.getBandCount());
        assertEquals(8, image.getBitsPerBand());
        assertEquals(24, image.getBitsPerPixel());
        assertEquals(EditableImage.DataType.BYTE, image.getDataType());
        assertEquals(1995, image.getHeight());
        assertEquals(3000, image.getWidth());
        
        final TIFF tiff = image.getMetadata(TIFF.class);
        assertNotNull(tiff);
        dump(tiff);
        assertFalse(tiff.isAvailable());
        
        final EXIF exif = image.getMetadata(EXIF.class);
        assertNotNull(exif);
        dump(exif);
        assertTrue(exif.isAvailable());
        assertEquals(29, exif.getTagCodes().length);
        
        assertEquals("NIKON CORPORATION", exif.getMake());
        assertEquals("NIKON D100", exif.getModel());
        assertEquals(new Rational(300, 1), exif.getXResolution());
        assertEquals(new Rational(300, 1), exif.getYResolution());
        assertEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
        assertEquals("Nikon Capture Editor 4.1.3 W", exif.getSoftware());
        assertEquals("2006:11:11 20:24:33", exif.getDateTime());
        assertEquals("(C) Copyright 2006 by Fabrizio Giudici", exif.getCopyright());
        assertEquals(new Rational(1, 320), exif.getExposureTime());
        assertEquals(new Rational(28, 10), exif.getFNumber());
        assertEquals(EXIF.ExposureProgram.SHUTTER_PRIORITY, exif.getExposureProgram());
        assertEquals(400, (int)exif.getISOSpeedRatings());
        assertTrue(Arrays.equals(new byte[]{48, 50, 50, 49}, exif.getEXIFVersion()));
        assertEquals("2003:07:01 12:29:36", exif.getDateTimeOriginal());
        assertEquals("2003:07:01 12:29:36", exif.getDateTimeDigitized());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
        assertEquals(new Rational(8321928, 1000000), exif.getShutterSpeedValue());
        assertEquals(new Rational(2970854, 1000000), exif.getApertureValue());
        assertEquals(new Rational(0, 6), exif.getExposureBiasValue());
        assertEquals(new Rational(3, 1), exif.getMaxApertureValue());
        assertEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        assertEquals(EXIF.LightSource.FINE_WEATHER, exif.getLightSource());
        assertEquals(0, (int)exif.getFlash());
        assertEquals(new Rational(180, 1), exif.getFocalLength());
//        assertEquals(9996, (long)exif.getMakerNote());
        assertEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici", new String(exif.getUserComment()));
        assertEquals("80", exif.getSubsecTimeOriginal());
        assertEquals("80", exif.getSubsecTimeDigitized());
        assertEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        assertEquals(EXIF.FileSource.DSC, exif.getFileSource());
        assertEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
      }  
    
    @Test
    public void testPropertiesWithNEF()
      throws IOException                                  
      {
        // Reajent is enabled
        // FIXME: should be 16 and 48, UNSIGNED_SHORT
        _testProperties(file_20030701_0043_nef, 3008, 2000, 3, 8, 24, EditableImage.DataType.BYTE);     
      }

//    @Test
//    public void testReadMetadataFromJPEXXX() 
//      throws Exception
//      {
//        final EditableImage image = EditableImage.create(new ReadOp(new File("/Users/fritz/Desktop/1205789521406.jpg"), ReadOp.Type.METADATA));
//        final EXIF exif = image.getMetadata(EXIF.class);
//        assertNotNull(exif);
//        assertEquals(38, exif.getTagCodes().length);
//        System.err.println("XXXX EXIF: " + exif);
//        
//        for (int i = 0; i < exif.getTagCodes().length; i++)
//          {
//            final int code = exif.getTagCodes()[i];
//            final String tag = exif.getTagName(code);
//            System.err.println("**** " + code + " " + tag + " " + exif.getObject(code));  
//          }
//            
//        assertEquals("Canon", exif.getMake());
//        assertEquals("Canon EOS 20D", exif.getModel());
//        assertEquals(new Rational(72, 1), exif.getXResolution());
//        assertEquals(new Rational(72, 1), exif.getYResolution());
//        assertEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
//        assertEquals("2004:09:19 12:25:20", exif.getDateTime());
//        assertEquals(new Rational(1, 250), exif.getExposureTime());
//        
////        assertEquals(new Rational(28, 10), exif.getFNumber());
////        assertEquals(EXIF.ExposureProgram.SHUTTER_PRIORITY, exif.getExposureProgram());
////        assertEquals(400, (int)exif.getISOSpeedRatings());
////        assertTrue(Arrays.equals(new byte[]{48, 50, 50, 49}, exif.getEXIFVersion()));
////        assertEquals("2004:09:19 12:25:20", exif.getDateTimeOriginal());
////        assertEquals("2004:09:19 12:25:20", exif.getDateTimeDigitized());
//////        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//////        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//////        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
////        assertEquals(new Rational(8321928, 1000000), exif.getShutterSpeedValue());
////        assertEquals(new Rational(2970854, 1000000), exif.getApertureValue());
////        assertEquals(new Rational(0, 6), exif.getExposureBiasValue());
////        assertEquals(new Rational(3, 1), exif.getMaxApertureValue());
////        assertEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
////        assertEquals(EXIF.LightSource.FINE_WEATHER, exif.getLightSource());
////        assertEquals(0, (int)exif.getFlash());
////        assertEquals(new Rational(180, 1), exif.getFocalLength());
//////        assertEquals(9996, (long)exif.getMakerNote());
////        assertEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici", new String(exif.getUserComment()));
////        assertEquals("80", exif.getSubsecTimeOriginal());
////        assertEquals("80", exif.getSubsecTimeDigitized());
////        assertEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
////        assertEquals(EXIF.FileSource.DSC, exif.getFileSource());
////        assertEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
//      }

    @Test
    public void testReadMetadataFromNEF()
      throws Exception
      {
        final File file = file_20030701_0043_nef;
        assertTrue(file.exists());
        final EditableImage image = EditableImage.create(new ReadOp(file, ReadOp.Type.METADATA));
        
        assertEquals(1, image.getMetadataCount(TIFF.class));
        final TIFF tiff = image.getMetadata(TIFF.class);
        assertNotNull(tiff);
        assertTrue(tiff.isAvailable());
        assertEquals(25, tiff.getTagCodes().length);
        dump(tiff);
        assertEquals(TIFF.NewSubFileType.REDUCED_RESOLUTION, tiff.getNewSubFileType());
        assertEquals(320, (long)tiff.getImageWidth());
        assertEquals(212, (long)tiff.getImageLength());
        assertTrue(Arrays.equals(new int[]{8,8,8}, tiff.getBitsPerSample()));
        assertEquals(TIFF.Compression.UNCOMPRESSED, tiff.getCompression());
        assertEquals(TIFF.PhotometricInterpretation.RGB, tiff.getPhotometricInterpretation());
        assertEquals("                                ", tiff.getImageDescription());
        assertEquals("NIKON CORPORATION", tiff.getMake());
        assertEquals("NIKON D100 ", tiff.getModel());
        assertEquals(17724, (long)tiff.getStripOffsets());
        assertEquals(TIFF.Orientation.TOP_LEFT, tiff.getOrientation());
        assertEquals(3, (int)tiff.getSamplesPerPixel());
        assertEquals(212, (int)tiff.getRowsPerStrip());
        assertEquals(203520, (int)tiff.getStripByteCounts());
        assertEquals(new Rational(300, 1), tiff.getXResolution());
        assertEquals(new Rational(300, 1), tiff.getYResolution());
        assertEquals(TIFF.PlanarConfiguration.CHUNKY, tiff.getPlanarConfiguration());
        assertEquals(TIFF.ResolutionUnit.INCHES, tiff.getResolutionUnit());
        assertEquals("Nikon Capture Editor 4.1.3 W", tiff.getSoftware());
        assertEquals("2004:11:05 16:30:47", tiff.getDateTime());
        assertTrue(Arrays.equals(new int[]{9534, 9652, 9770}, tiff.getSubIFDs()));
        assertEquals(9118, (long)tiff.getExifIFDPointer());
        assertEquals(8636, tiff.getInterColourProfile().length);
        assertEquals("2003:07:01 12:29:36", tiff.getDateTimeOriginal());
        assertTrue(Arrays.equals(new byte[]{1, 0, 0, 0}, tiff.getTIFF_EPStandardID()));
        
        assertEquals(Arrays.asList("EXIF"), new ArrayList<String>(tiff.getSubDirectoryNames()));
        assertEquals(1, image.getMetadataCount(EXIF.class));
        final EXIF exif = image.getMetadata(EXIF.class);
        assertNotNull(exif);
//        assertTrue(exif == tiff.getSubDirectory("EXIF"));
        assertTrue(exif.isAvailable());
        assertEquals(22, exif.getTagCodes().length);
        dump(exif);

        assertEquals(new Rational(3125, 1000000), exif.getExposureTime());
        assertEquals(new Rational(28, 10), exif.getFNumber());
        assertEquals(EXIF.ExposureProgram.SHUTTER_PRIORITY, exif.getExposureProgram());
        assertEquals("2003:07:01 12:29:36", exif.getDateTimeOriginal());
        assertEquals("2003:07:01 12:29:36", exif.getDateTimeDigitized());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
        assertEquals(new Rational(0, 6), exif.getExposureBiasValue());
        assertEquals(new Rational(3, 1), exif.getMaxApertureValue());
        assertEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        assertEquals(EXIF.LightSource.FINE_WEATHER, exif.getLightSource());
        assertEquals(0, (int)exif.getFlash());
        assertEquals(new Rational(180, 1), exif.getFocalLength());
        assertEquals(9996, (long)exif.getMakerNote());
        assertEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici   ", new String(exif.getUserComment()));
        assertEquals("80", exif.getSubsecTime());
        assertEquals("80", exif.getSubsecTimeOriginal());
        assertEquals("80", exif.getSubsecTimeDigitized());
        assertEquals(EXIF.ColorSpace.SRGB, exif.getColorSpace());
        assertEquals("            ", exif.getRelatedSoundFile());
        assertEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        assertEquals(EXIF.FileSource.DSC, exif.getFileSource());
        assertEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
        assertTrue(Arrays.equals(new byte[]{0,2,0,2,1,0,2,1}, exif.getEXIFCFAPattern()));
      }
    
    @Test
    public void testReadMetadataFromAdobeLightroomJPEG()
      throws Exception
      {
        assertEquals(1, img20060603_0002_jpg.getMetadataCount(TIFF.class));
        final TIFF tiff = img20060603_0002_jpg.getMetadata(TIFF.class);
        assertNotNull(tiff);
        assertFalse(tiff.isAvailable());
        
        final EXIF exif = img20060603_0002_jpg.getMetadata(EXIF.class);
        assertEquals(41, exif.getTagCodes().length);

        assertEquals(6.0, exif.getApertureValue().doubleValue());
        assertEquals(EXIF.Contrast.NORMAL, exif.getContrast());
        assertEquals(EXIF.CustomRendered.NORMAL_PROCESS, exif.getCustomRendered());
        assertEquals("2007:04:21 21:51:02", exif.getDateTime());
        assertEquals("2006:06:03 12:04:53", exif.getDateTimeDigitized());
        assertEquals("2006:06:03 12:04:53", exif.getDateTimeOriginal());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
        assertEquals(1.0, exif.getDigitalZoomRatio().doubleValue());
        assertEquals(EXIF.ExposureProgram.APERTURE_PRIORITY, exif.getExposureProgram());
        assertTrue(Arrays.equals(new byte[]{2,0,2,0,1,0,2,1}, exif.getEXIFCFAPattern()));
        assertTrue(Arrays.equals(new byte[]{48, 50, 50, 49}, exif.getEXIFVersion()));
        assertEquals(0.0, exif.getExposureBiasValue().doubleValue());
        assertEquals(EXIF.ExposureMode.AUTO, exif.getExposureMode());
        assertEquals(0.00625, exif.getExposureTime().doubleValue());
        assertEquals(EXIF.FileSource.DSC, exif.getFileSource());
        assertEquals(0, (int)exif.getFlash());
        assertEquals(8.0, exif.getFNumber().doubleValue());
        assertEquals(85.0, exif.getFocalLength().doubleValue());
        assertEquals(127.0, exif.getFocalLength35mmFilm().doubleValue());
        assertEquals(EXIF.GainControl.NONE, exif.getGainControl());
        assertEquals(200, (int)exif.getISOSpeedRatings());
        assertEquals(EXIF.LightSource.UNKNOWN, exif.getLightSource());
        assertEquals("NIKON CORPORATION", exif.getMake());
        assertEquals(1.6, exif.getMaxApertureValue().doubleValue());
        assertEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        assertEquals("NIKON D100", exif.getModel());
        assertEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
        assertEquals(EXIF.Saturation.NORMAL, exif.getSaturation());
        assertEquals(0, (int)exif.getSceneCaptureType());
        assertEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
        assertEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        assertEquals(EXIF.Sharpness.NORMAL, exif.getSharpness());
        assertEquals(7.321928, exif.getShutterSpeedValue().doubleValue());
        assertEquals(0, (int)exif.getSubjectDistanceRange());
        assertEquals("70", exif.getSubsecTimeDigitized());
        assertEquals("70", exif.getSubsecTimeOriginal());
        assertEquals("Ver.2.00", exif.getSoftware());
        assertEquals(300.0, exif.getXResolution().doubleValue());
        assertEquals(300.0, exif.getYResolution().doubleValue());
        assertEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici", new String(exif.getUserComment()));
        assertEquals(EXIF.WhiteBalance.AUTO, exif.getWhiteBalance());
      }
    
    @Test
    public void testReadIPTCFromJPEG1()
      {
                
        assertEquals(1, imgIPTC1_jpg.getMetadataCount(IPTC.class));
        final IPTC iptc = imgIPTC1_jpg.getMetadata(IPTC.class);
        assertNotNull(iptc);
        assertTrue(iptc.isAvailable());
        
        final String caption =  "The Shore Temple of the Seven Pagodas was built under Narsimha II of " +
                                "the Pallava dynasty between 7th and 8th century AD and is dedicated to " +
                                "Lord Shiva. It resembles the structure of the Dharmaraja rath, but its " +
                                "tower rises much higher (approx. five stories or ~ 60 ft. high) and its " +
                                "stupa spire is small and slender. ";
        final String keywords = "land, monument, nature, scenery, architectural, architecture, building, " +
                                "place of worship, religious building, structures, temple, sacred place, " +
                                "sanctum, Asia, India, Malibalipuram, Tamil Nadu, night, moonlight, moon, " +
                                "skies, sky, blue";
        
        assertEquals(17, iptc.getTagCodes().length);
        assertEquals("Julie Doe", iptc.getByline());
        assertEquals("Mugwum contract photographer", iptc.getBylineTitle());
        assertEquals(caption, iptc.getCaptionAbstract());
        assertEquals("Malibalipuram", iptc.getCity());
        assertEquals("�2005 Julie Doe / Mugwum Press, all rights reserved", iptc.getCopyrightNotice());
        assertEquals("India", iptc.getCountryPrimaryLocationName());
        assertEquals("Mugwum Press", iptc.getCredit());
        assertEquals("Sat Jan 01 00:00:00 CET 2005", iptc.getDateCreated().toString());
        assertEquals("Shore Temple, Malibalipuram, India", iptc.getHeadline());
        assertEquals("[" + keywords + "]", Arrays.asList(iptc.getKeywords()).toString());
        assertEquals("ar21319", iptc.getObjectName());
        assertEquals("Sacred India", iptc.getOriginalTransmissionReference());
        assertEquals("Tamil Nadu", iptc.getProvinceState());
        assertEquals("Julie Doe / Mugwum Press", iptc.getSource());
        assertEquals("Newsmagazines Out", iptc.getSpecialInstructions());
        assertEquals("Jacques Brown", iptc.getWriterEditor());
      }
    
    @Test
    public void testSerialize()
      throws IOException, ClassNotFoundException                                  
      {
        File file = new File("Serialized");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        EditableImage image1 = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
        oos.writeObject(image1);
        oos.close();
        log("serialized" + image1);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        EditableImage image2 = (EditableImage)ois.readObject();
        ois.close();
        log("deserialized" + image2);
      }

    private void _testProperties (final File file,
                                  final int expectedWidth,
                                  final int expectedHeight,
                                  final int expectedBandCount,
                                  final int expectedBitsPerBand,
                                  final int expectedBitsPerPixel,
                                  final EditableImage.DataType expectedDataType)
      throws IOException                                  
      {
        final EditableImage image = EditableImage.create(new ReadOp(file));
        final int width = image.getWidth();
        final int height = image.getHeight();
        final int bandCount = image.getBandCount();
        final int bitsPerBand = image.getBitsPerBand();
        final int bitsPerPixel = image.getBitsPerPixel();
        final EditableImage.DataType dataType = image.getDataType();
        
        assertEquals(expectedWidth, width);
        assertEquals(expectedHeight, height);
        assertEquals(expectedBandCount, bandCount);
        assertEquals(expectedBitsPerBand, bitsPerBand);
        assertEquals(expectedBitsPerPixel, bitsPerPixel);
        assertEquals(expectedDataType, dataType);
        
        log(">>>> File:           " + file);
        log(">>>> Size:           " + width + " x " + height);
        log(">>>> Bands:          " + bandCount);
        log(">>>> Bits per bands: " + bitsPerBand);
        log(">>>> Bits per pixel: " + bitsPerPixel);
        log(">>>> Data type:      " + dataType);     
      }
    
    private void dump (final Directory directory) 
      throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
      {
        final String name = directory.getClass().getSimpleName();
        
        for (final int tag : directory.getTagCodes())
          {
            String string = "???";
            String type = "???";
            final Object value = directory.getObject(tag);
            
            if (value == null)
              {
                string = "null";
                type = "null";
              }
            else if (!value.getClass().isArray())
              {
                string = value.toString();
                type = value.getClass().getSimpleName();
              }
            else 
              {
                string = (String)Arrays.class.getMethod("toString", value.getClass()).invoke(null, value);
                type = value.getClass().getSimpleName();
              }
            
            System.err.printf("%5d %-10s %-30s %-10s %s\n", tag, name, directory.getTagName(tag), type, string);
          }
      }
  }
