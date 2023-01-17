/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
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
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.image;

import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import it.tidalwave.util.Pair;
import it.tidalwave.image.metadata.Directory;
import it.tidalwave.image.metadata.EXIF;
import it.tidalwave.image.metadata.EXIFTest;
import it.tidalwave.image.metadata.IPTC;
import it.tidalwave.image.metadata.TIFF;
import it.tidalwave.image.op.ReadOp;
import lombok.extern.slf4j.Slf4j;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static it.tidalwave.image.op.ReadOp.Type.METADATA;
import static java.nio.charset.StandardCharsets.UTF_8;
import static it.tidalwave.util.test.FileComparisonUtils.assertSameContents;
import static org.testng.AssertJUnit.*;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
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
        final EditableImage image = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
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

        assertOptionalEquals("NIKON CORPORATION", exif.getMake());
        assertOptionalEquals("NIKON D100", exif.getModel());
        assertOptionalEquals(new Rational(300, 1), exif.getXResolution());
        assertOptionalEquals(new Rational(300, 1), exif.getYResolution());
        assertOptionalEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
        assertOptionalEquals("Nikon Capture Editor 4.1.3 W", exif.getSoftware());
        assertOptionalEquals("2006:11:11 20:24:33", exif.getDateTime());
        assertOptionalEquals("(C) Copyright 2006 by Fabrizio Giudici", exif.getCopyright());
        assertOptionalEquals(new Rational(1, 320), exif.getExposureTime());
        assertOptionalEquals(new Rational(28, 10), exif.getFNumber());
        assertOptionalEquals(EXIF.ExposureProgram.SHUTTER_PRIORITY, exif.getExposureProgram());
        assertOptionalEquals(400, exif.getISOSpeedRatings());
        assertOptionalEquals(new byte[]{48, 50, 50, 49}, exif.getEXIFVersion());
        assertOptionalEquals("2003:07:01 12:29:36", exif.getDateTimeOriginal());
        assertOptionalEquals("2003:07:01 12:29:36", exif.getDateTimeDigitized());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
        assertOptionalEquals(new Rational(8321928, 1000000), exif.getShutterSpeedValue());
        assertOptionalEquals(new Rational(2970854, 1000000), exif.getApertureValue());
        assertOptionalEquals(new Rational(0, 6), exif.getExposureBiasValue());
        assertOptionalEquals(new Rational(3, 1), exif.getMaxApertureValue());
        assertOptionalEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        assertOptionalEquals(EXIF.LightSource.FINE_WEATHER, exif.getLightSource());
        assertOptionalEquals(0, exif.getFlash());
        assertOptionalEquals(new Rational(180, 1), exif.getFocalLength());
//        assertEquals(9996, (long)exif.getMakerNote());
        assertOptionalEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici",
                                 exif.getUserComment().map(String::new));
        assertOptionalEquals("80", exif.getSubsecTimeOriginal());
        assertOptionalEquals("80", exif.getSubsecTimeDigitized());
        assertOptionalEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        assertOptionalEquals(EXIF.FileSource.DSC, exif.getFileSource());
        assertOptionalEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
      }

    @Test
    public void testPropertiesWithNEF()
            throws IOException
      {
        // Reajent is enabled
        // FIXME: should be 16 and 48, UNSIGNED_SHORT
        _testProperties(file_20030701_0043_nef.toPath(), 3008, 2000, 3, 8, 24, EditableImage.DataType.BYTE);
      }

//    @Test
//    public void testReadMetadataFromJPEXXX()
//      throws Exception
//      {
//        final EditableImage image = EditableImage.create(new ReadOp(new File("/Users/fritz/Desktop/1205789521406
//        .jpg"), ReadOp.Type.METADATA));
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
        final EditableImage image = EditableImage.create(new ReadOp(file, METADATA));

        assertEquals(1, image.getMetadataCount(TIFF.class));
        final TIFF tiff = image.getMetadata(TIFF.class);
        assertNotNull(tiff);
        assertTrue(tiff.isAvailable());
        assertEquals(25, tiff.getTagCodes().length);
        dump(tiff);
        assertEquals(TIFF.NewSubFileType.REDUCED_RESOLUTION, tiff.getNewSubFileType());
        assertEquals(320, (long)tiff.getImageWidth().get());
        assertEquals(212, (long)tiff.getImageLength().get());
        assertTrue(Arrays.equals(new int[]{8, 8, 8}, tiff.getBitsPerSample().get()));
        assertEquals(TIFF.Compression.UNCOMPRESSED, tiff.getCompression());
        assertEquals(TIFF.PhotometricInterpretation.RGB, tiff.getPhotometricInterpretation());
        assertEquals("                                ", tiff.getImageDescription());
        assertEquals("NIKON CORPORATION", tiff.getMake());
        assertEquals("NIKON D100 ", tiff.getModel());
        assertEquals(17724, (long)tiff.getStripOffsets().get());
        assertEquals(TIFF.Orientation.TOP_LEFT, tiff.getOrientation());
        assertEquals(3, (int)tiff.getSamplesPerPixel().get());
        assertEquals(212, (int)tiff.getRowsPerStrip().get());
        assertEquals(203520, (int)tiff.getStripByteCounts().get());
        assertEquals(new Rational(300, 1), tiff.getXResolution());
        assertEquals(new Rational(300, 1), tiff.getYResolution());
        assertEquals(TIFF.PlanarConfiguration.CHUNKY, tiff.getPlanarConfiguration());
        assertEquals(TIFF.ResolutionUnit.INCHES, tiff.getResolutionUnit());
        assertEquals("Nikon Capture Editor 4.1.3 W", tiff.getSoftware());
        assertEquals("2004:11:05 16:30:47", tiff.getDateTime());
        assertTrue(Arrays.equals(new int[]{9534, 9652, 9770}, tiff.getSubIFDs().get()));
        assertEquals(9118, (long)tiff.getExifIFDPointer().get());
        assertEquals(8636, tiff.getInterColourProfile().get().length);
        assertEquals("2003:07:01 12:29:36", tiff.getDateTimeOriginal());
        assertTrue(Arrays.equals(new byte[]{1, 0, 0, 0}, tiff.getTIFF_EPStandardID().get()));

        assertEquals(List.of("EXIF"), new ArrayList<>(tiff.getSubDirectoryNames()));
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
        assertEquals(0, (int)exif.getFlash().get());
        assertEquals(new Rational(180, 1), exif.getFocalLength());
        assertEquals(9996, exif.getMakerNote());
        assertEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici   ",
                                 new String(exif.getUserComment().get()));
        assertEquals("80", exif.getSubsecTime());
        assertEquals("80", exif.getSubsecTimeOriginal());
        assertEquals("80", exif.getSubsecTimeDigitized());
        assertEquals(EXIF.ColorSpace.SRGB, exif.getColorSpace());
        assertEquals("            ", exif.getRelatedSoundFile());
        assertEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        assertEquals(EXIF.FileSource.DSC, exif.getFileSource());
        assertEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
        assertTrue(Arrays.equals(new byte[]{0, 2, 0, 2, 1, 0, 2, 1}, exif.getEXIFCFAPattern().get()));
      }

    @Test
    public void testReadMetadataFromAdobeLightroomJPEG()
      {
        assertEquals(1, img20060603_0002_jpg.getMetadataCount(TIFF.class));
        final TIFF tiff = img20060603_0002_jpg.getMetadata(TIFF.class);
        assertNotNull(tiff);
        assertFalse(tiff.isAvailable());

        final EXIF exif = img20060603_0002_jpg.getMetadata(EXIF.class);
        assertEquals(41, exif.getTagCodes().length);

        assertOptionalEquals(6.0, exif.getApertureValue());
        assertOptionalEquals(EXIF.Contrast.NORMAL, exif.getContrast());
        assertOptionalEquals(EXIF.CustomRendered.NORMAL_PROCESS, exif.getCustomRendered());
        assertOptionalEquals("2007:04:21 21:51:02", exif.getDateTime());
        assertOptionalEquals("2006:06:03 12:04:53", exif.getDateTimeDigitized());
        assertOptionalEquals("2006:06:03 12:04:53", exif.getDateTimeOriginal());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
        assertOptionalEquals(1.0, exif.getDigitalZoomRatio());
        assertOptionalEquals(EXIF.ExposureProgram.APERTURE_PRIORITY, exif.getExposureProgram());
        assertOptionalEquals(new byte[]{2, 0, 2, 0, 1, 0, 2, 1}, exif.getEXIFCFAPattern());
        assertOptionalEquals(new byte[]{48, 50, 50, 49}, exif.getEXIFVersion());
        assertOptionalEquals(0.0, exif.getExposureBiasValue());
        assertOptionalEquals(EXIF.ExposureMode.AUTO, exif.getExposureMode());
        assertOptionalEquals(0.00625, exif.getExposureTime());
        assertOptionalEquals(EXIF.FileSource.DSC, exif.getFileSource());
        assertOptionalEquals(0, exif.getFlash());
        assertOptionalEquals(8.0, exif.getFNumber());
        assertOptionalEquals(85.0, exif.getFocalLength());
        assertOptionalEquals(127, exif.getFocalLength35mmFilm());
        assertOptionalEquals(EXIF.GainControl.NONE, exif.getGainControl());
        assertOptionalEquals(200, exif.getISOSpeedRatings());
        assertOptionalEquals(EXIF.LightSource.UNKNOWN, exif.getLightSource());
        assertOptionalEquals("NIKON CORPORATION", exif.getMake());
        assertOptionalEquals(1.6, exif.getMaxApertureValue());
        assertOptionalEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        assertOptionalEquals("NIKON D100", exif.getModel());
        assertOptionalEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
        assertOptionalEquals(EXIF.Saturation.NORMAL, exif.getSaturation());
        assertOptionalEquals(0, exif.getSceneCaptureType());
        assertOptionalEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
        assertOptionalEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        assertOptionalEquals(EXIF.Sharpness.NORMAL, exif.getSharpness());
        assertOptionalEquals(7.321928, exif.getShutterSpeedValue());
        assertOptionalEquals(0, exif.getSubjectDistanceRange());
        assertOptionalEquals("70", exif.getSubsecTimeDigitized());
        assertOptionalEquals("70", exif.getSubsecTimeOriginal());
        assertOptionalEquals("Ver.2.00", exif.getSoftware());
        assertOptionalEquals(300.0, exif.getXResolution());
        assertOptionalEquals(300.0, exif.getYResolution());
        assertOptionalEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici",
                                 exif.getUserComment().map(String::new));
        assertOptionalEquals(EXIF.WhiteBalance.AUTO, exif.getWhiteBalance());
      }

    private static <T> void assertOptionalEquals (final T expected, final Optional<T> actual)
      {
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
      }

    private static void assertOptionalEquals (final double expected, final Optional<Rational> actual)
      {
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get().doubleValue());
      }

    @Test
    public void testReadIPTCFromJPEG1()
      {

        assertEquals(1, imgIPTC1_jpg.getMetadataCount(IPTC.class));
        final IPTC iptc = imgIPTC1_jpg.getMetadata(IPTC.class);
        assertNotNull(iptc);
        assertTrue(iptc.isAvailable());

        final String caption = "The Shore Temple of the Seven Pagodas was built under Narsimha II of " +
                               "the Pallava dynasty between 7th and 8th century AD and is dedicated to " +
                               "Lord Shiva. It resembles the structure of the Dharmaraja rath, but its " +
                               "tower rises much higher (approx. five stories or ~ 60 ft. high) and its " +
                               "stupa spire is small and slender. ";
        final String keywords = "land, monument, nature, scenery, architectural, architecture, building, " +
                                "place of worship, religious building, structures, temple, sacred place, " +
                                "sanctum, Asia, India, Malibalipuram, Tamil Nadu, night, moonlight, moon, " +
                                "skies, sky, blue";

        assertEquals(17, iptc.getTagCodes().length);
        assertOptionalEquals("Julie Doe", iptc.getByline());
        assertOptionalEquals("Mugwum contract photographer", iptc.getBylineTitle());
        assertOptionalEquals(caption, iptc.getCaptionAbstract());
        assertOptionalEquals("Malibalipuram", iptc.getCity());
        assertOptionalEquals("�2005 Julie Doe / Mugwum Press, all rights reserved", iptc.getCopyrightNotice());
        assertOptionalEquals("India", iptc.getCountryPrimaryLocationName());
        assertOptionalEquals("Mugwum Press", iptc.getCredit());
        assertOptionalEquals("Sat Jan 01 00:00:00 CET 2005", iptc.getDateCreated());
        assertOptionalEquals("Shore Temple, Malibalipuram, India", iptc.getHeadline());
        ///// assertOptionalEquals("[" + keywords + "]", Collections.singletonList(iptc.getKeywords()));
        assertOptionalEquals("ar21319", iptc.getObjectName());
        assertOptionalEquals("Sacred India", iptc.getOriginalTransmissionReference());
        assertOptionalEquals("Tamil Nadu", iptc.getProvinceState());
        assertOptionalEquals("Julie Doe / Mugwum Press", iptc.getSource());
        assertOptionalEquals("Newsmagazines Out", iptc.getSpecialInstructions());
        assertOptionalEquals("Jacques Brown", iptc.getWriterEditor());
      }

    @Test
    public void testSerialize()
            throws IOException, ClassNotFoundException
      {
        final File file = new File("target/Serialized");
        final ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
        final EditableImage image1 = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
        oos.writeObject(image1);
        oos.close();
        log.info("serialized" + image1);

        final ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
        final EditableImage image2 = (EditableImage)ois.readObject();
        ois.close();
        log.info("deserialized" + image2);
      }

    @Test(enabled = false)
    private void _testProperties (final Path file,
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

        log.info(">>>> File:           " + file);
        log.info(">>>> Size:           " + width + " x " + height);
        log.info(">>>> Bands:          " + bandCount);
        log.info(">>>> Bits per bands: " + bitsPerBand);
        log.info(">>>> Bits per pixel: " + bitsPerPixel);
        log.info(">>>> Data type:      " + dataType);
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

    @Test(dataProvider = "stoppingDownImages")
    public void testMetadata (@Nonnull final Path path)
            throws IOException
      {
        // WHEN
        final EditableImage underTest = EditableImage.create(new ReadOp(path, METADATA));
        final TIFF tiff = underTest.getMetadata(TIFF.class);
        final EXIF exif = underTest.getMetadata(EXIF.class);
        final IPTC iptc = underTest.getMetadata(IPTC.class);
        // final XMP xmp = underTest.getMetadata(XMP.class);
        // THEN
        log.info("TIFF: {}", tiff);
        log.info("EXIF: {}", exif);
        log.info("IPTC: {}", iptc);
        // log.info("XMP: {}", xmp);
        final String resourceName = path.getFileName().toString().replaceAll("\\.jpg$", ".txt");
        final List<String> strings = new ArrayList<>();
        dumpTags(strings, "TIFF", tiff);
        dumpTags(strings, "EXIF", exif);
        dumpTags(strings, "IPTC", iptc);
        final Path actualResults = Paths.get("target/test-results");
        Files.createDirectories(actualResults);
        final Path actualDump = actualResults.resolve(resourceName);
        Files.write(actualDump, strings, UTF_8);
        final Path expectedDump = path.resolveSibling(resourceName);
        assertSameContents(expectedDump, actualDump);
      }

    @DataProvider
    public static Object[][] stoppingDownImages()
            throws IOException
      {
        if (!Files.exists(TEST_SD100_FOLDER))
          {
            log.warn("TEST SET PATH NOT FOUND: {}", TEST_SD100_FOLDER);
            return new Object[0][1];
          }

        try (final Stream<Path> s = Files.list(TEST_SD100_FOLDER))
          {
            return s.filter(p -> p.getFileName().toString().endsWith(".jpg"))
                    .sorted()
                    .limit(99999)
                    .map(p -> new Object[]{p})
                    .toArray(Object[][]::new);
          }
      }

    /*******************************************************************************************************************
     *
     ******************************************************************************************************************/
    private static void dumpTags (@Nonnull final List<? super String> strings,
                                  @Nonnull final String directoryName,
                                  @Nonnull final Directory directory)
      {
        for (final int tag : directory.getTagCodes())
          {
            Object value = directory.getObject(tag);

            if (value instanceof byte[])
              {
                value = Arrays.toString((byte[])value);
              }
            else if (value instanceof Rational[])
              {
                value = Arrays.toString((Rational[])value);
              }
            else if (value instanceof Object[])
              {
                value = Arrays.toString((Object[])value);
              }
            else if (value instanceof Date)
              {
                value = ((Date)value).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                                     .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
              }

            final String s = String.format("%s [%d] %s: %s", directoryName, tag, directory.getTagName(tag), value);
            log.info("{}", s);
            strings.add(s);
          }

        if (directory instanceof EXIF)
          {
            final EXIF exif = (EXIF)directory;
            final List<Pair<String, Function<EXIF, Optional<Instant>>>> x = List.of(
                Pair.of("dateTimeAsDate", EXIF::getDateTimeAsDate),
                Pair.of("dateTimeOriginalAsDate", EXIF::getDateTimeOriginalAsDate),
                Pair.of("dateTimeDigitizedAsDate", EXIF::getDateTimeDigitizedAsDate));
            x.forEach(p ->
                      p.b.apply(exif).ifPresent(i -> strings.add(String.format("%s %s: %s", directoryName, p.a, i))));
          }
      }
  }
