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

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import it.tidalwave.image.metadata.Directory;
import it.tidalwave.image.metadata.EXIF;
import it.tidalwave.image.metadata.EXIFDirectoryGenerated;
import it.tidalwave.image.metadata.EXIFTest;
import it.tidalwave.image.metadata.IPTC;
import it.tidalwave.image.metadata.TIFF;
import it.tidalwave.image.op.ReadOp;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import static it.tidalwave.image.op.ReadOp.Type.METADATA;
import static java.nio.charset.StandardCharsets.UTF_8;
import static it.tidalwave.util.test.FileComparisonUtils.assertSameContents;
import static org.junit.Assert.assertThat;
import static org.testng.AssertJUnit.*;
import static org.hamcrest.CoreMatchers.*;

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
        _testProperties(file_20030701_0043_jpg, 100, 66, 3, 8, 24, EditableImage.DataType.BYTE);
      }

    @Test
    public void testReadMetadataJpegExportedByCaptureOne()
            throws Exception
      {
        final var image = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
        assertEquals(3, image.getBandCount());
        assertEquals(8, image.getBitsPerBand());
        assertEquals(24, image.getBitsPerPixel());
        assertEquals(EditableImage.DataType.BYTE, image.getDataType());
        assertEquals(100, image.getWidth());
        assertEquals(66, image.getHeight());

        final var tiff = image.getMetadata(TIFF.class);
        assertNotNull(tiff);
        dumpTags("TIFF", tiff, log::info);
        assertFalse(tiff.isAvailable());

        final var exif = image.getMetadata(EXIF.class);
        assertNotNull(exif);
        dumpTags("EXIF", exif, log::info);
        assertTrue(exif.isAvailable());
        assertEquals(27, exif.getTagCodes().length);

        // assertOptionalEquals("NIKON CORPORATION", exif.getMake());
        // assertOptionalEquals("NIKON D100", exif.getModel());
        // assertOptionalEquals(Rational.of(300, 1), exif.getXResolution());
        // assertOptionalEquals(Rational.of(300, 1), exif.getYResolution());
        // assertOptionalEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
        // assertOptionalEquals("Nikon Capture Editor 4.1.3 W", exif.getSoftware());
        // assertOptionalEquals("2006:11:11 20:24:33", exif.getDateTime());
        // assertOptionalEquals("(C) Copyright 2006 by Fabrizio Giudici", exif.getCopyright());
        assertOptionalEquals(Rational.of(1, 320), exif.getExposureTime());
        assertOptionalEquals(Rational.of(28, 10), exif.getFNumber());
        assertOptionalEquals(EXIF.ExposureProgram.SHUTTER_PRIORITY, exif.getExposureProgram());
        assertOptionalEquals(400, exif.getISOSpeedRatings());
        assertOptionalEquals(new byte[]{48, 50, 50, 49}, exif.getEXIFVersion());
        assertOptionalEquals("2003:07:01 12:29:36", exif.getDateTimeOriginal());
        assertOptionalEquals("800", exif.getSubsecTimeOriginal());
        assertOptionalEquals(LocalDateTime.of(2003, 7, 1, 12, 29, 44, 0).toInstant(ZoneOffset.UTC),
                     exif.getDateTimeDigitizedAsDate());
        assertOptionalEquals("2003:07:01 12:29:36", exif.getDateTimeDigitized());
        assertOptionalEquals(LocalDateTime.of(2003, 7, 1, 12, 29, 44, 0).toInstant(ZoneOffset.UTC),
                     exif.getDateTimeOriginalAsDate());
        assertOptionalEquals("800", exif.getSubsecTimeDigitized());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
        assertOptionalEquals(Rational.of(8321928, 1000000), exif.getShutterSpeedValue());
        assertOptionalEquals(Rational.of(2970854, 1000000), exif.getApertureValue());
        assertOptionalEquals(Rational.of(0, 6), exif.getExposureBiasValue());
        assertOptionalEquals(Rational.of(3, 1), exif.getMaxApertureValue());
        assertOptionalEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        assertOptionalEquals(EXIF.LightSource.FINE_WEATHER, exif.getLightSource());
        assertOptionalEquals(0, exif.getFlash());
        assertOptionalEquals(Rational.of(180, 1), exif.getFocalLength());
//        assertEquals(9996, (long)exif.getMakerNote());
        assertOptionalEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici",
                                 exif.getUserComment().map(String::new));
        assertOptionalEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        assertOptionalEquals(EXIF.FileSource.DSC, exif.getFileSource());
        assertOptionalEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
      }

    @Test
    public void testReadMetadataJpegExportedByAdobeLightroom()
      {
        assertEquals(1, img20060603_0002_jpg.getMetadataCount(TIFF.class));
        final var tiff = img20060603_0002_jpg.getMetadata(TIFF.class);
        assertNotNull(tiff);
        assertFalse(tiff.isAvailable());

        final var exif = img20060603_0002_jpg.getMetadata(EXIF.class);
        assertEquals(35, exif.getTagCodes().length);

        assertOptionalEquals(6.0, exif.getApertureValue());
        assertOptionalEquals(EXIF.Contrast.NORMAL, exif.getContrast());
        assertOptionalEquals(EXIF.CustomRendered.NORMAL_PROCESS, exif.getCustomRendered());
        // assertOptionalEquals("2007:04:21 21:51:02", exif.getDateTime());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
        assertOptionalEquals("2006:06:03 12:04:53", exif.getDateTimeDigitized());
        assertOptionalEquals("70", exif.getSubsecTimeDigitized());
        assertOptionalEquals(LocalDateTime.of(2006, 6, 3, 12, 4, 53, 700000000).toInstant(ZoneOffset.UTC),
                             exif.getDateTimeDigitizedAsDate());
        assertOptionalEquals("2006:06:03 12:04:53", exif.getDateTimeOriginal());
        assertOptionalEquals("70", exif.getSubsecTimeOriginal());
        assertOptionalEquals(LocalDateTime.of(2006, 6, 3, 12, 4, 53, 700000000).toInstant(ZoneOffset.UTC),
                             exif.getDateTimeOriginalAsDate());
        assertOptionalEquals(1.0, exif.getDigitalZoomRatio());
        assertOptionalEquals(EXIF.ExposureProgram.APERTURE_PRIORITY, exif.getExposureProgram());
        assertOptionalEquals(new byte[]{2, 0, 2, 0, 1, 0, 2, 1}, exif.getEXIFCFAPattern());
        assertOptionalEquals(new byte[]{48, 50, 51, 48}, exif.getEXIFVersion());
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
        // assertOptionalEquals("NIKON CORPORATION", exif.getMake());
        assertOptionalEquals(1.6, exif.getMaxApertureValue());
        assertOptionalEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        // assertOptionalEquals("NIKON D100", exif.getModel());
        // assertOptionalEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
        assertOptionalEquals(EXIF.Saturation.NORMAL, exif.getSaturation());
        assertOptionalEquals(0, exif.getSceneCaptureType());
        assertOptionalEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
        assertOptionalEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
        assertOptionalEquals(EXIF.Sharpness.NORMAL, exif.getSharpness());
        assertOptionalEquals(7.321928, exif.getShutterSpeedValue());
        assertOptionalEquals(0, exif.getSubjectDistanceRange());
        // assertOptionalEquals("Ver.2.00", exif.getSoftware());
        // assertOptionalEquals(300.0, exif.getXResolution());
        // assertOptionalEquals(300.0, exif.getYResolution());
        assertOptionalEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici",
                             exif.getUserComment().map(String::new));
        assertOptionalEquals(EXIF.WhiteBalance.AUTO, exif.getWhiteBalance());
      }

    @Test(enabled = false)
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
//        assertEquals(Rational.of(72, 1), exif.getXResolution());
//        assertEquals(Rational.of(72, 1), exif.getYResolution());
//        assertEquals(EXIF.ResolutionUnit.INCHES, exif.getResolutionUnit());
//        assertEquals("2004:09:19 12:25:20", exif.getDateTime());
//        assertEquals(Rational.of(1, 250), exif.getExposureTime());
//
////        assertEquals(Rational.of(28, 10), exif.getFNumber());
////        assertEquals(EXIF.ExposureProgram.SHUTTER_PRIORITY, exif.getExposureProgram());
////        assertEquals(400, (int)exif.getISOSpeedRatings());
////        assertTrue(Arrays.equals(new byte[]{48, 50, 50, 49}, exif.getEXIFVersion()));
////        assertEquals("2004:09:19 12:25:20", exif.getDateTimeOriginal());
////        assertEquals("2004:09:19 12:25:20", exif.getDateTimeDigitized());
//////        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//////        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//////        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
////        assertEquals(Rational.of(8321928, 1000000), exif.getShutterSpeedValue());
////        assertEquals(Rational.of(2970854, 1000000), exif.getApertureValue());
////        assertEquals(Rational.of(0, 6), exif.getExposureBiasValue());
////        assertEquals(Rational.of(3, 1), exif.getMaxApertureValue());
////        assertEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
////        assertEquals(EXIF.LightSource.FINE_WEATHER, exif.getLightSource());
////        assertEquals(0, (int)exif.getFlash());
////        assertEquals(Rational.of(180, 1), exif.getFocalLength());
//////        assertEquals(9996, (long)exif.getMakerNote());
////        assertEquals("ASCII\u0000\u0000\u0000(C) Copyright by Fabrizio Giudici", new String(exif.getUserComment()));
////        assertEquals("80", exif.getSubsecTimeOriginal());
////        assertEquals("80", exif.getSubsecTimeDigitized());
////        assertEquals(EXIF.SensingMethod.ONE_CHIP_COLOR_AREA_SENSOR, exif.getSensingMethod());
////        assertEquals(EXIF.FileSource.DSC, exif.getFileSource());
////        assertEquals(EXIF.SceneType.DIRECTLY_PHOTOGRAPHED_IMAGE, exif.getSceneType());
//      }

    @Test(enabled = false)
    public void testReadMetadataFromNEF()
            throws Exception
      {
        final var file = file_20030701_0043_nef;
        assertTrue(file.exists());
        final var image = EditableImage.create(new ReadOp(file, METADATA));

        assertEquals(1, image.getMetadataCount(TIFF.class));
        final var tiff = image.getMetadata(TIFF.class);
        assertNotNull(tiff);
        assertTrue(tiff.isAvailable());
        assertEquals(25, tiff.getTagCodes().length);
        dumpTags("TIFF", tiff, log::info);
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
        assertEquals(Rational.of(300, 1), tiff.getXResolution());
        assertEquals(Rational.of(300, 1), tiff.getYResolution());
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
        final var exif = image.getMetadata(EXIF.class);
        assertNotNull(exif);
//        assertTrue(exif == tiff.getSubDirectory("EXIF"));
        assertTrue(exif.isAvailable());
        assertEquals(22, exif.getTagCodes().length);
        dumpTags("EXIF", exif, log::info);

        assertEquals(Rational.of(3125, 1000000), exif.getExposureTime());
        assertEquals(Rational.of(28, 10), exif.getFNumber());
        assertEquals(EXIF.ExposureProgram.SHUTTER_PRIORITY, exif.getExposureProgram());
        assertEquals("2003:07:01 12:29:36", exif.getDateTimeOriginal());
        assertEquals("2003:07:01 12:29:36", exif.getDateTimeDigitized());
//        assertEquals(FORMAT.parse("2007 04 21 21:51:02.000"), exif.getDateTimeAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeDigitizedAsDate());
//        assertEquals(FORMAT.parse("2006 06 03 12:04:53.700"), exif.getDateTimeOriginalAsDate());
        assertEquals(Rational.of(0, 6), exif.getExposureBiasValue());
        assertEquals(Rational.of(3, 1), exif.getMaxApertureValue());
        assertEquals(EXIF.MeteringMode.PATTERN, exif.getMeteringMode());
        assertEquals(EXIF.LightSource.FINE_WEATHER, exif.getLightSource());
        assertEquals(0, (int)exif.getFlash().get());
        assertEquals(Rational.of(180, 1), exif.getFocalLength());
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


    @Test(enabled = false)
    public void testReadIPTCFromJPEG1()
      {

        assertEquals(1, imgIPTC1_jpg.getMetadataCount(IPTC.class));
        final var iptc = imgIPTC1_jpg.getMetadata(IPTC.class);
        assertNotNull(iptc);
        assertTrue(iptc.isAvailable());

        final var caption = "The Shore Temple of the Seven Pagodas was built under Narsimha II of " +
                            "the Pallava dynasty between 7th and 8th century AD and is dedicated to " +
                            "Lord Shiva. It resembles the structure of the Dharmaraja rath, but its " +
                            "tower rises much higher (approx. five stories or ~ 60 ft. high) and its " +
                            "stupa spire is small and slender. ";
        final var keywords = "land, monument, nature, scenery, architectural, architecture, building, " +
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

    @Test(enabled = false)
    public void testSerialize()
            throws IOException, ClassNotFoundException
      {
        final var file = new File("target/Serialized");
        final var oos = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
        final var image1 = EditableImage.create(new ReadOp(file_20030701_0043_jpg));
        oos.writeObject(image1);
        oos.close();
        log.info("serialized" + image1);

        final var ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
        final var image2 = (EditableImage)ois.readObject();
        ois.close();
        log.info("deserialized" + image2);
      }

    @Test(dataProvider = "stoppingDownImages")
    public void testMetadata (@Nonnull final Path path)
            throws IOException
      {
        // WHEN
        final var underTest = EditableImage.create(new ReadOp(path, METADATA));
        final var tiff = underTest.getMetadata(TIFF.class);
        final var exif = underTest.getMetadata(EXIF.class);
        final var iptc = underTest.getMetadata(IPTC.class);
        // final XMP xmp = underTest.getMetadata(XMP.class);
        // THEN
        log.info("TIFF: {}", tiff);
        log.info("EXIF: {}", exif);
        log.info("IPTC: {}", iptc);
        // log.info("XMP: {}", xmp);
        final var resourceName = path.getFileName().toString().replaceAll("\\.jpg$", ".txt");
        final List<String> strings = new ArrayList<>();
        dumpTags("TIFF", tiff, strings::add);
        dumpTags("EXIF", exif, strings::add);
        dumpTags("IPTC", iptc, strings::add);
        final var actualResults = Path.of("target/test-results/stoppingdown_100_20230116");
        final var expectedResults = Path.of("src/test/resources/expected-results/stoppingdown_100_20230116");
        final var actualDump = actualResults.resolve(resourceName);
        final var expectedDump = expectedResults.resolve(resourceName);
        Files.createDirectories(actualResults);
        Files.write(actualDump, strings, UTF_8);
        assertSameContents(expectedDump, actualDump);
      }
  }
