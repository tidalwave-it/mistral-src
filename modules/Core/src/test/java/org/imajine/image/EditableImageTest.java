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
 * WWW: http://mistral.imajine.org
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
package org.imajine.image;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.imajine.image.metadata.Directory;
import org.imajine.image.metadata.EXIF;
import org.imajine.image.metadata.IPTC;
import org.imajine.image.metadata.TIFF;
import org.imajine.image.op.ReadOp;

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
        AssertJUnit.assertEquals(3, image.getBandCount());
        AssertJUnit.assertEquals(8, image.getBitsPerBand());
        AssertJUnit.assertEquals(24, image.getBitsPerPixel());
        AssertJUnit.assertEquals(EditableImage.DataType.BYTE, image.getDataType());
        AssertJUnit.assertEquals(1995, image.getHeight());
        AssertJUnit.assertEquals(3000, image.getWidth());
        
        final TIFF tiff = image.getMetadata(TIFF.class);
        AssertJUnit.assertNotNull(tiff);
        dump(tiff);
        AssertJUnit.assertFalse(tiff.isAvailable());
        
        final EXIF exif = image.getMetadata(EXIF.class);
        AssertJUnit.assertNotNull(exif);
        dump(exif);
        AssertJUnit.assertTrue(exif.isAvailable());
        AssertJUnit.assertEquals(29, exif.getTagCodes().length);
        
        AssertJUnit.assertEquals("NIKON CORPORATION", exif.getMake());
        AssertJUnit.assertEquals("NIKON D100", exif.getModel());
        AssertJUnit.assertEquals(new Rational(300, 1), exif.getXResolution());
        AssertJUnit.assertEquals(new Rational(300, 1), exif.getYResolution());
        AssertJUnit.assertEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
        AssertJUnit.assertEquals("Nikon Capture Editor 4.1.3 W", exif.getSoftware());
        AssertJUnit.assertEquals("2006:11:11 20:24:33", exif.getDateTime());
        AssertJUnit.assertEquals("(C) Copyright 2006 by Fabrizio Giudici", exif.getCopyright());
        AssertJUnit.assertEquals(new Rational(1, 320), exif.getExposureTime());
        AssertJUnit.assertEquals(new Rational(28, 10), exif.getFNumber());
        AssertJUnit.assertEquals(EXIF.ExposureProgram.SHUTTER_PRIORITY, exif.getExposureProgram());
        AssertJUnit.assertEquals(400, (int)exif.getISOSpeedRatings());
        AssertJUnit.assertTrue(Arrays.equals(new byte[]{48, 50, 50, 49}, exif.getEXIFVersion()));
        AssertJUnit.assertEquals("2003:07:01 12:29:36", exif.getDateTimeOriginal());
        AssertJUnit.assertEquals("2003:07:01 12:29:36", exif.getDateTimeDigitized());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
        AssertJUnit.assertEquals(new Rational(8321928, 1000000), exif.getShutterSpeedValue());
        AssertJUnit.assertEquals(new Rational(2970854, 1000000), exif.getApertureValue());
        AssertJUnit.assertEquals(new Rational(0, 6), exif.getExposureBiasValue());
        AssertJUnit.assertEquals(new Rational(3, 1), exif.getMaxApertureValue());
        AssertJUnit.assertEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        AssertJUnit.assertEquals(EXIF.LightSource.FINE_WEATHER, exif.getLightSource());
        AssertJUnit.assertEquals(0, (int)exif.getFlash());
        AssertJUnit.assertEquals(new Rational(180, 1), exif.getFocalLength());
//        assertEquals(9996, (long)exif.getMakerNote());
        AssertJUnit.assertEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici", new String(exif.getUserComment()));
        AssertJUnit.assertEquals("80", exif.getSubsecTimeOriginal());
        AssertJUnit.assertEquals("80", exif.getSubsecTimeDigitized());
        AssertJUnit.assertEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        AssertJUnit.assertEquals(EXIF.FileSource.DSC, exif.getFileSource());
        AssertJUnit.assertEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
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
        AssertJUnit.assertTrue(file.exists());
        final EditableImage image = EditableImage.create(new ReadOp(file, ReadOp.Type.METADATA));
        
        AssertJUnit.assertEquals(1, image.getMetadataCount(TIFF.class));
        final TIFF tiff = image.getMetadata(TIFF.class);
        AssertJUnit.assertNotNull(tiff);
        AssertJUnit.assertTrue(tiff.isAvailable());
        AssertJUnit.assertEquals(25, tiff.getTagCodes().length);
        dump(tiff);
        AssertJUnit.assertEquals(TIFF.NewSubFileType.REDUCED_RESOLUTION, tiff.getNewSubFileType());
        AssertJUnit.assertEquals(320, (long)tiff.getImageWidth());
        AssertJUnit.assertEquals(212, (long)tiff.getImageLength());
        AssertJUnit.assertTrue(Arrays.equals(new int[]{8,8,8}, tiff.getBitsPerSample()));
        AssertJUnit.assertEquals(TIFF.Compression.UNCOMPRESSED, tiff.getCompression());
        AssertJUnit.assertEquals(TIFF.PhotometricInterpretation.RGB, tiff.getPhotometricInterpretation());
        AssertJUnit.assertEquals("                                ", tiff.getImageDescription());
        AssertJUnit.assertEquals("NIKON CORPORATION", tiff.getMake());
        AssertJUnit.assertEquals("NIKON D100 ", tiff.getModel());
        AssertJUnit.assertEquals(17724, (long)tiff.getStripOffsets());
        AssertJUnit.assertEquals(TIFF.Orientation.TOP_LEFT, tiff.getOrientation());
        AssertJUnit.assertEquals(3, (int)tiff.getSamplesPerPixel());
        AssertJUnit.assertEquals(212, (int)tiff.getRowsPerStrip());
        AssertJUnit.assertEquals(203520, (int)tiff.getStripByteCounts());
        AssertJUnit.assertEquals(new Rational(300, 1), tiff.getXResolution());
        AssertJUnit.assertEquals(new Rational(300, 1), tiff.getYResolution());
        AssertJUnit.assertEquals(TIFF.PlanarConfiguration.CHUNKY, tiff.getPlanarConfiguration());
        AssertJUnit.assertEquals(TIFF.ResolutionUnit.INCHES, tiff.getResolutionUnit());
        AssertJUnit.assertEquals("Nikon Capture Editor 4.1.3 W", tiff.getSoftware());
        AssertJUnit.assertEquals("2004:11:05 16:30:47", tiff.getDateTime());
        AssertJUnit.assertTrue(Arrays.equals(new int[]{9534, 9652, 9770}, tiff.getSubIFDs()));
        AssertJUnit.assertEquals(9118, (long)tiff.getExifIFDPointer());
        AssertJUnit.assertEquals(8636, tiff.getInterColourProfile().length);
        AssertJUnit.assertEquals("2003:07:01 12:29:36", tiff.getDateTimeOriginal());
        AssertJUnit.assertTrue(Arrays.equals(new byte[]{1, 0, 0, 0}, tiff.getTIFF_EPStandardID()));
        
        AssertJUnit.assertEquals(Arrays.asList("EXIF"), new ArrayList<String>(tiff.getSubDirectoryNames()));
        AssertJUnit.assertEquals(1, image.getMetadataCount(EXIF.class));
        final EXIF exif = image.getMetadata(EXIF.class);
        AssertJUnit.assertNotNull(exif);
//        assertTrue(exif == tiff.getSubDirectory("EXIF"));
        AssertJUnit.assertTrue(exif.isAvailable());
        AssertJUnit.assertEquals(22, exif.getTagCodes().length);
        dump(exif);

        AssertJUnit.assertEquals(new Rational(3125, 1000000), exif.getExposureTime());
        AssertJUnit.assertEquals(new Rational(28, 10), exif.getFNumber());
        AssertJUnit.assertEquals(EXIF.ExposureProgram.SHUTTER_PRIORITY, exif.getExposureProgram());
        AssertJUnit.assertEquals("2003:07:01 12:29:36", exif.getDateTimeOriginal());
        AssertJUnit.assertEquals("2003:07:01 12:29:36", exif.getDateTimeDigitized());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
        AssertJUnit.assertEquals(new Rational(0, 6), exif.getExposureBiasValue());
        AssertJUnit.assertEquals(new Rational(3, 1), exif.getMaxApertureValue());
        AssertJUnit.assertEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        AssertJUnit.assertEquals(EXIF.LightSource.FINE_WEATHER, exif.getLightSource());
        AssertJUnit.assertEquals(0, (int)exif.getFlash());
        AssertJUnit.assertEquals(new Rational(180, 1), exif.getFocalLength());
        AssertJUnit.assertEquals(9996, (long)exif.getMakerNote());
        AssertJUnit.assertEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici   ", new String(exif.getUserComment()));
        AssertJUnit.assertEquals("80", exif.getSubsecTime());
        AssertJUnit.assertEquals("80", exif.getSubsecTimeOriginal());
        AssertJUnit.assertEquals("80", exif.getSubsecTimeDigitized());
        AssertJUnit.assertEquals(EXIF.ColorSpace.SRGB, exif.getColorSpace());
        AssertJUnit.assertEquals("            ", exif.getRelatedSoundFile());
        AssertJUnit.assertEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        AssertJUnit.assertEquals(EXIF.FileSource.DSC, exif.getFileSource());
        AssertJUnit.assertEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
        AssertJUnit.assertTrue(Arrays.equals(new byte[]{0,2,0,2,1,0,2,1}, exif.getEXIFCFAPattern()));
      }
    
    @Test
    public void testReadMetadataFromAdobeLightroomJPEG()
      throws Exception
      {
        AssertJUnit.assertEquals(1, img20060603_0002_jpg.getMetadataCount(TIFF.class));
        final TIFF tiff = img20060603_0002_jpg.getMetadata(TIFF.class);
        AssertJUnit.assertNotNull(tiff);
        AssertJUnit.assertFalse(tiff.isAvailable());
        
        final EXIF exif = img20060603_0002_jpg.getMetadata(EXIF.class);
        AssertJUnit.assertEquals(41, exif.getTagCodes().length);

        AssertJUnit.assertEquals(6.0, exif.getApertureValue().doubleValue());
        AssertJUnit.assertEquals(EXIF.Contrast.NORMAL, exif.getContrast());
        AssertJUnit.assertEquals(EXIF.CustomRendered.NORMAL_PROCESS, exif.getCustomRendered());
        AssertJUnit.assertEquals("2007:04:21 21:51:02", exif.getDateTime());
        AssertJUnit.assertEquals("2006:06:03 12:04:53", exif.getDateTimeDigitized());
        AssertJUnit.assertEquals("2006:06:03 12:04:53", exif.getDateTimeOriginal());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
        AssertJUnit.assertEquals(1.0, exif.getDigitalZoomRatio().doubleValue());
        AssertJUnit.assertEquals(EXIF.ExposureProgram.APERTURE_PRIORITY, exif.getExposureProgram());
        AssertJUnit.assertTrue(Arrays.equals(new byte[]{2,0,2,0,1,0,2,1}, exif.getEXIFCFAPattern()));
        AssertJUnit.assertTrue(Arrays.equals(new byte[]{48, 50, 50, 49}, exif.getEXIFVersion()));
        AssertJUnit.assertEquals(0.0, exif.getExposureBiasValue().doubleValue());
        AssertJUnit.assertEquals(EXIF.ExposureMode.AUTO, exif.getExposureMode());
        AssertJUnit.assertEquals(0.00625, exif.getExposureTime().doubleValue());
        AssertJUnit.assertEquals(EXIF.FileSource.DSC, exif.getFileSource());
        AssertJUnit.assertEquals(0, (int)exif.getFlash());
        AssertJUnit.assertEquals(8.0, exif.getFNumber().doubleValue());
        AssertJUnit.assertEquals(85.0, exif.getFocalLength().doubleValue());
        AssertJUnit.assertEquals(127.0, exif.getFocalLength35mmFilm().doubleValue());
        AssertJUnit.assertEquals(EXIF.GainControl.NONE, exif.getGainControl());
        AssertJUnit.assertEquals(200, (int)exif.getISOSpeedRatings());
        AssertJUnit.assertEquals(EXIF.LightSource.UNKNOWN, exif.getLightSource());
        AssertJUnit.assertEquals("NIKON CORPORATION", exif.getMake());
        AssertJUnit.assertEquals(1.6, exif.getMaxApertureValue().doubleValue());
        AssertJUnit.assertEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        AssertJUnit.assertEquals("NIKON D100", exif.getModel());
        AssertJUnit.assertEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
        AssertJUnit.assertEquals(EXIF.Saturation.NORMAL, exif.getSaturation());
        AssertJUnit.assertEquals(0, (int)exif.getSceneCaptureType());
        AssertJUnit.assertEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
        AssertJUnit.assertEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        AssertJUnit.assertEquals(EXIF.Sharpness.NORMAL, exif.getSharpness());
        AssertJUnit.assertEquals(7.321928, exif.getShutterSpeedValue().doubleValue());
        AssertJUnit.assertEquals(0, (int)exif.getSubjectDistanceRange());
        AssertJUnit.assertEquals("70", exif.getSubsecTimeDigitized());
        AssertJUnit.assertEquals("70", exif.getSubsecTimeOriginal());
        AssertJUnit.assertEquals("Ver.2.00", exif.getSoftware());
        AssertJUnit.assertEquals(300.0, exif.getXResolution().doubleValue());
        AssertJUnit.assertEquals(300.0, exif.getYResolution().doubleValue());
        AssertJUnit.assertEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici", new String(exif.getUserComment()));
        AssertJUnit.assertEquals(EXIF.WhiteBalance.AUTO, exif.getWhiteBalance());
      }
    
    @Test
    public void testReadIPTCFromJPEG1()
      {
                
        AssertJUnit.assertEquals(1, imgIPTC1_jpg.getMetadataCount(IPTC.class));
        final IPTC iptc = imgIPTC1_jpg.getMetadata(IPTC.class);
        AssertJUnit.assertNotNull(iptc);
        AssertJUnit.assertTrue(iptc.isAvailable());
        
        final String caption =  "The Shore Temple of the Seven Pagodas was built under Narsimha II of " +
                                "the Pallava dynasty between 7th and 8th century AD and is dedicated to " +
                                "Lord Shiva. It resembles the structure of the Dharmaraja rath, but its " +
                                "tower rises much higher (approx. five stories or ~ 60 ft. high) and its " +
                                "stupa spire is small and slender. ";
        final String keywords = "land, monument, nature, scenery, architectural, architecture, building, " +
                                "place of worship, religious building, structures, temple, sacred place, " +
                                "sanctum, Asia, India, Malibalipuram, Tamil Nadu, night, moonlight, moon, " +
                                "skies, sky, blue";
        
        AssertJUnit.assertEquals(17, iptc.getTagCodes().length);
        AssertJUnit.assertEquals("Julie Doe", iptc.getByline());
        AssertJUnit.assertEquals("Mugwum contract photographer", iptc.getBylineTitle());
        AssertJUnit.assertEquals(caption, iptc.getCaptionAbstract());
        AssertJUnit.assertEquals("Malibalipuram", iptc.getCity());
        AssertJUnit.assertEquals("�2005 Julie Doe / Mugwum Press, all rights reserved", iptc.getCopyrightNotice());
        AssertJUnit.assertEquals("India", iptc.getCountryPrimaryLocationName());
        AssertJUnit.assertEquals("Mugwum Press", iptc.getCredit());
        AssertJUnit.assertEquals("Sat Jan 01 00:00:00 CET 2005", iptc.getDateCreated().toString());
        AssertJUnit.assertEquals("Shore Temple, Malibalipuram, India", iptc.getHeadline());
        AssertJUnit.assertEquals("[" + keywords + "]", Arrays.asList(iptc.getKeywords()).toString());
        AssertJUnit.assertEquals("ar21319", iptc.getObjectName());
        AssertJUnit.assertEquals("Sacred India", iptc.getOriginalTransmissionReference());
        AssertJUnit.assertEquals("Tamil Nadu", iptc.getProvinceState());
        AssertJUnit.assertEquals("Julie Doe / Mugwum Press", iptc.getSource());
        AssertJUnit.assertEquals("Newsmagazines Out", iptc.getSpecialInstructions());
        AssertJUnit.assertEquals("Jacques Brown", iptc.getWriterEditor());
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

    @Test(enabled = false)
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
        
        AssertJUnit.assertEquals(expectedWidth, width);
        AssertJUnit.assertEquals(expectedHeight, height);
        AssertJUnit.assertEquals(expectedBandCount, bandCount);
        AssertJUnit.assertEquals(expectedBitsPerBand, bitsPerBand);
        AssertJUnit.assertEquals(expectedBitsPerPixel, bitsPerPixel);
        AssertJUnit.assertEquals(expectedDataType, dataType);
        
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
