package it.tidalwave.image.metadata;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import it.tidalwave.image.Rational;

/* Automatically generated on Thu Jan 01 01:00:00 CET 1970 - DO NOT EDIT! */

public class EXIFDirectoryGenerated extends Directory
  {
    private final static long serialVersionUID = 2056233055989339523L;
    private final static Map<Integer, String> descriptionMapByTag = new HashMap<Integer, String>();

    public EXIFDirectoryGenerated()
      {
      }

    public EXIFDirectoryGenerated (final Date latestModificationTime)
      {
        super(latestModificationTime);
      }

    public final static int NEW_SUBFILE_TYPE = 254;
    public final static int SUB_FILETYPE = 255;
    public final static int IMAGE_WIDTH = 256;
    public final static int IMAGE_LENGTH = 257;
    public final static int BITS_PER_SAMPLE = 258;
    public final static int COMPRESSION = 259;
    public final static int PHOTOMETRIC_INTERPRETATION = 262;
    public final static int THRESHOLDING = 263;
    public final static int CELL_WIDTH = 264;
    public final static int CELL_LENGTH = 265;
    public final static int FILL_ORDER = 266;
    public final static int DOCUMENT_NAME = 269;
    public final static int IMAGE_DESCRIPTION = 270;
    public final static int MAKE = 271;
    public final static int MODEL = 272;
    public final static int STRIP_OFFSETS = 273;
    public final static int ORIENTATION = 274;
    public final static int SAMPLES_PER_PIXEL = 277;
    public final static int ROWS_PER_STRIP = 278;
    public final static int STRIP_BYTE_COUNTS = 279;
    public final static int MIN_SAMPLE_VALUE = 280;
    public final static int MAX_SAMPLE_VALUE = 281;
    public final static int X_RESOLUTION = 282;
    public final static int Y_RESOLUTION = 283;
    public final static int PLANAR_CONFIGURATION = 284;
    public final static int PAGE_NAME = 285;
    public final static int X_POSITION = 286;
    public final static int Y_POSITION = 287;
    public final static int FREE_OFFSETS = 288;
    public final static int FREE_BYTE_COUNTS = 289;
    public final static int GRAY_RESPONSE_UNIT = 290;
    public final static int GRAY_RESPONSE_CURVE = 291;
    public final static int GROUP_3_OPTIONS = 292;
    public final static int GROUP_4_OPTIONS = 293;
    public final static int RESOLUTION_UNIT = 296;
    public final static int PAGE_NUMBER = 297;
    public final static int COLOR_RESPONSE_UNIT = 300;
    public final static int TRANSFER_FUNCTION = 301;
    public final static int SOFTWARE = 305;
    public final static int DATETIME = 306;
    public final static int ARTIST = 315;
    public final static int HOST_COMPUTER = 316;
    public final static int PREDICTOR = 317;
    public final static int WHITE_POINT = 318;
    public final static int PRIMARY_CHROMATICITIES = 319;
    public final static int TILE_WIDTH = 322;
    public final static int TILE_LENGTH = 323;
    public final static int TILE_OFFSETS = 324;
    public final static int TILE_BYTE_COUNTS = 325;
    public final static int BAD_FAX_LINES = 326;
    public final static int CLEAN_FAX_DATA = 327;
    public final static int CONSECUTIVE_BAD_FAX_LINES = 328;
    public final static int SUB_IFDS = 330;
    public final static int INK_SET = 332;
    public final static int INK_NAMES = 333;
    public final static int NUMBER_OF_INKS = 334;
    public final static int DOT_RANGE = 336;
    public final static int TARGET_PRINTER = 337;
    public final static int EXTRA_SAMPLES = 338;
    public final static int SAMPLE_FORMAT = 339;
    public final static int TRANSFER_RANGE = 342;
    public final static int CLIP_PATH = 343;
    public final static int X_CLIP_PATH_UNITS = 344;
    public final static int Y_CLIP_PATH_UNITS = 345;
    public final static int INDEXED = 346;
    public final static int JPEG_TABLES = 347;
    public final static int OPI_PROXY = 351;
    public final static int JPEG_PROC = 512;
    public final static int JPEG_INTERCHANGE_FORMAT = 513;
    public final static int JPEG_INTERCHANGE_FORMAT_LENGTH = 514;
    public final static int JPEG_RESTART_INTERVAL = 515;
    public final static int JPEG_LOSSLESS_PREDICTORS = 517;
    public final static int JPEG_POINT_TRANSFORMS = 518;
    public final static int JPEG_Q_TABLES = 519;
    public final static int JPEG_DC_TABLES = 520;
    public final static int JPEG_AC_TABLES = 521;
    public final static int YCBCR_COEFFICIENTS = 529;
    public final static int YCBCR_SUBSAMPLING = 530;
    public final static int YCBCR_POSITIONING = 531;
    public final static int REFERENCE_BLACK_WHITE = 532;
    public final static int XMP = 700;
    public final static int IMAGE_ID = 32781;
    public final static int WANG_ANNOTATION = 32932;
    public final static int CFA_REPEAT_PATTERN_DIM = 33421;
    public final static int CFA_PATTERN = 33422;
    public final static int BATTERY_LEVEL = 33423;
    public final static int COPYRIGHT = 33432;
    public final static int EXPOSURE_TIME = 33434;
    public final static int F_NUMBER = 33437;
    public final static int IPTC_NAA = 33723;
    public final static int MODEL_PIXEL_SCALE_TAG = 33550;
    public final static int INTERGRAPH_MATRIX_TAG = 33920;
    public final static int MODEL_TIEPOINT_TAG = 33922;
    public final static int SITE = 34016;
    public final static int COLOR_SEQUENCE = 34017;
    public final static int IT8_HEADER = 34018;
    public final static int RASTER_PADDING = 34019;
    public final static int BITS_PER_RUN_LENGTH = 34020;
    public final static int BITS_PER_EXTENDED_RUN_LENGTH = 34021;
    public final static int COLOR_TABLE = 34022;
    public final static int IMAGE_COLOR_INDICATOR = 34023;
    public final static int BACKGROUND_COLOR_INDICATOR = 34024;
    public final static int IMAGE_COLOR_VALUE = 34025;
    public final static int BACKGROUND_COLOR_VALUE = 34026;
    public final static int PIXEL_INTENSITY_RANGE = 34027;
    public final static int TRANSPARENCY_INDICATOR = 34028;
    public final static int COLOR_CHARACTERIZATION = 34029;
    public final static int HC_USAGE = 34030;
    public final static int MODEL_TRANSFORMATION_TAG = 34264;
    public final static int PHOTOSHOP_IMAGE_RESOURCES = 34377;
    public final static int EXIF_IFD_POINTER = 34665;
    public final static int INTER_COLOUR_PROFILE = 34675;
    public final static int GEO_KEY_DIRECTORYTAG = 34735;
    public final static int GEO_DOUBLE_PARAMS_TAG = 34736;
    public final static int GEO_ASCII_PARAMS_TAG = 34737;
    public final static int EXPOSURE_PROGRAM = 34850;
    public final static int SPECTRAL_SENSITIVITY = 34852;
    public final static int GPS_INFO_IFD_POINTER = 34853;
    public final static int ISO_SPEED_RATINGS = 34855;
    public final static int OECF = 34856;
    public final static int INTERLACE = 34857;
    public final static int TIME_ZONE_OFFSET = 34858;
    public final static int SELF_TIMER_MODE = 34859;
    public final static int EXIF_VERSION = 36864;
    public final static int DATETIME_ORIGINAL = 36867;
    public final static int DATETIME_DIGITIZED = 36868;
    public final static int COMPONENT_CONFIGURATION = 37121;
    public final static int COMPRESSED_BITS_PER_PIXEL = 37122;
    public final static int SHUTTER_SPEEDVALUE = 37377;
    public final static int APERTURE_VALUE = 37378;
    public final static int BRIGHTNESS_VALUE = 37379;
    public final static int EXPOSURE_BIAS_VALUE = 37380;
    public final static int MAX_APERTURE_VALUE = 37381;
    public final static int SUBJECT_DISTANCE = 37382;
    public final static int METERING_MODE = 37383;
    public final static int LIGHT_SOURCE = 37384;
    public final static int FLASH = 37385;
    public final static int FOCAL_LENGTH = 37386;
    public final static int FLASH_ENERGY2 = 37387;
    public final static int SPATIAL_FREQUENCYRESPONSE2 = 37388;
    public final static int NOISE = 37389;
    public final static int FOCAL_PLANEXRESOLUTION2 = 37390;
    public final static int FOCAL_PLANEYRESOLUTION2 = 37391;
    public final static int FOCAL_PLANERESOLUTIONUNIT2 = 37392;
    public final static int IMAGE_NUMBER = 37393;
    public final static int SECURITY_CLASSIFICATION = 37394;
    public final static int IMAGE_HISTORY = 37395;
    public final static int SUBJECT_AREA = 37396;
    public final static int EXPOSURE_INDEX_2 = 37397;
    public final static int TIFF_EP_STANDARD_ID = 37398;
    public final static int SENSING_METHOD_2 = 37399;
    public final static int MAKER_NOTE = 37500;
    public final static int USER_COMMENT = 37510;
    public final static int SUBSEC_TIME = 37520;
    public final static int SUBSEC_TIME_ORIGINAL = 37521;
    public final static int SUBSEC_TIME_DIGITIZED = 37522;
    public final static int IMAGE_SOURCE_DATA = 37724;
    public final static int FLASHPIX_VERSION = 40960;
    public final static int COLOR_SPACE = 40961;
    public final static int PIXEL_X_DIMENSION = 40962;
    public final static int PIXEL_Y_DIMENSION = 40963;
    public final static int RELATED_SOUND_FILE = 40964;
    public final static int INTEROPERABILITY_IFD = 40965;
    public final static int FLASH_ENERGY = 41483;
    public final static int SPATIAL_FREQUENCY_RESPONSE = 41484;
    public final static int FOCAL_PLANE_X_RESOLUTION = 41486;
    public final static int FOCAL_PLANE_Y_RESOLUTION = 41487;
    public final static int FOCAL_PLANE_RESOLUTIONUNIT = 41488;
    public final static int SUBJECT_LOCATION = 41492;
    public final static int EXPOSURE_INDEX = 41493;
    public final static int SENSING_METHOD = 41495;
    public final static int FILE_SOURCE = 41728;
    public final static int SCENE_TYPE = 41729;
    public final static int EXIF_CFA_PATTERN = 41730;
    public final static int CUSTOM_RENDERED = 41985;
    public final static int EXPOSURE_MODE = 41986;
    public final static int WHITE_BALANCE = 41987;
    public final static int DIGITAL_ZOOM_RATIO = 41988;
    public final static int FOCAL_LENGTH_35MM_FILM = 41989;
    public final static int SCENE_CAPTURE_TYPE = 41990;
    public final static int GAIN_CONTROL = 41991;
    public final static int CONTRAST = 41992;
    public final static int SATURATION = 41993;
    public final static int SHARPNESS = 41994;
    public final static int DEVICE_SETTING_DESCRIPTION = 41995;
    public final static int SUBJECT_DISTANCE_RANGE = 41996;
    public final static int IMAGE_UNIQUE_ID = 42016;
    public final static int PHOTOSHOP_ANNOTATIONS = 50255;
    public final static int THUMBNAIL = 61441;
    public final static int DNG_VERSION = 50706;
    public final static int DNG_BACKWARD_VERSION = 50707;
    public final static int UNIQUE_CAMERA_MODEL = 50708;
    public final static int LOCALIZED_CAMERA_MODEL = 50709;
    public final static int CFA_PLANE_COLOR = 50710;
    public final static int CFA_LAYOUT = 50711;
    public final static int LINEARIZATION_TABLE = 50712;
    public final static int BLACK_LEVEL_REPEAT_DIM = 50713;
    public final static int BLACK_LEVEL = 50714;
    public final static int BLACK_LEVEL_DELTA_H = 50715;
    public final static int BLACK_LEVEL_DELTA_V = 50716;
    public final static int WHITE_LEVEL = 50717;
    public final static int DEFAULT_SCALE = 50718;
    public final static int BEST_QUALITY_SCALE = 50780;
    public final static int DEFAULT_CROP_ORIGIN = 50719;
    public final static int DEFAULT_CROP_SIZE = 50720;
    public final static int CALIBRATION_ILLUMINANT_1 = 50778;
    public final static int CALIBRATION_ILLUMINANT_2 = 50779;
    public final static int COLOR_MATRIX_1 = 50721;
    public final static int COLOR_MATRIX_2 = 50722;
    public final static int CAMERA_CALIBRATION_1 = 50723;
    public final static int CAMERA_CALIBRATION_2 = 50724;
    public final static int REDUCTION_MATRIX_1 = 50725;
    public final static int REDUCTION_MATRIX_2 = 50726;
    public final static int ANALOG_BALANCE = 50727;
    public final static int AS_SHOT_NEUTRAL = 50728;
    public final static int AS_SHOT_WHITE_XY = 50729;
    public final static int BASELINE_EXPOSURE = 50730;
    public final static int BASELINE_NOISE = 50731;
    public final static int BASELINE_SHARPNESS = 50732;
    public final static int BAYER_GREEN_SPLIT = 50733;
    public final static int LINEAR_RESPONSE_LIMIT = 50734;
    public final static int CAMERA_SERIAL_NUMBER = 50735;
    public final static int LENS_INFO = 50736;
    public final static int CHROMA_BLUR_RADIUS = 50737;
    public final static int ANTI_ALIAS_STRENGTH = 50738;
    public final static int DNG_PRIVATE_DATA = 50740;
    public final static int MAKER_NOTE_SAFETY = 50741;
    public final static int SHADOW_SCALE = 50739;
    public final static int RAW_DATA_UNIQUE_ID = 50781;
    public final static int ORIGINAL_RAW_FILE_NAME = 50827;
    public final static int ORIGINAL_RAW_FILE_DATA = 50828;
    public final static int ACTIVE_AREA = 50829;
    public final static int MASKED_AREAS = 50830;
    public final static int AS_SHOT_ICC_PROFILE = 50831;
    public final static int AS_SHOT_PRE_PROFILE_MATRIX = 50832;
    public final static int CURRENT_ICC_PROFILE = 50833;
    public final static int CURRENT_PRE_PROFILE_MATRIX = 50834;
    public final static int COLORIMETRIC_REFERENCE = 50879;
    public final static int CAMERA_CALIBRATION_SIGNATURE = 50931;
    public final static int PROFILE_CALIBRATION_SIGNATURE = 50932;
    public final static int EXTRA_CAMERA_PROFILES = 50933;
    public final static int AS_SHOT_PROFILE_NAME = 50934;
    public final static int NOISE_RESOLUTION_APPLIED = 50935;
    public final static int PROFILE_NAME = 50936;
    public final static int PROFILE_HUE_SAT_MAP_DIMS = 50397;
    public final static int PROFILE_HUE_SAT_MAP_DATA_1 = 50938;
    public final static int PROFILE_HUE_SAT_MAP_DATA_2 = 50939;
    public final static int PROFILE_TONE_CURVE = 50940;
    public final static int PROFILE_EMBED_POLICY = 50941;
    public final static int PROFILE_COPYRIGHT = 50942;
    public final static int FORWARD_MATRIX_1 = 50964;
    public final static int FORWARD_MATRIX_2 = 50965;
    public final static int PREVIEW_APPLICATION_NAME = 50966;
    public final static int PREVIEW_APPLICATION_VERSION = 50967;
    public final static int PREVIEW_SETTINGS_NAME = 50968;
    public final static int PREVIEW_IFD = 50969;
    public final static int PREVIEW_COLOR_SPACE = 50970;
    public final static int PREVIEW_DATE_TIME = 50971;
    public final static int RAW_IMAGE_DIGEST = 50972;
    public final static int ORIGINAL_RAW_FILE_DIGEST = 50793;
    public final static int SUB_TILE_BLOCK_SIZE = 50974;
    public final static int ROW_INTERLEAVE_FACTOR = 50975;
    public final static int PROFILE_LOOK_TABLE_DIMS = 50981;
    public final static int PROFILE_LOOK_TABLE_DATA = 50982;

    @Override
    public String getTagName (int tag)
      {
        return (String)descriptionMapByTag.get(tag);
      }
    static
      {
        descriptionMapByTag.put(254, "New SubFile Type");
        descriptionMapByTag.put(255, "Sub FileType");
        descriptionMapByTag.put(256, "Image Width");
        descriptionMapByTag.put(257, "Image Length");
        descriptionMapByTag.put(258, "Bits Per Sample");
        descriptionMapByTag.put(259, "Compression");
        descriptionMapByTag.put(262, "Photometric Interpretation");
        descriptionMapByTag.put(263, "Thresholding");
        descriptionMapByTag.put(264, "Cell Width");
        descriptionMapByTag.put(265, "Cell Length");
        descriptionMapByTag.put(266, "Fill Order");
        descriptionMapByTag.put(269, "Document Name");
        descriptionMapByTag.put(270, "Image Description");
        descriptionMapByTag.put(271, "Make");
        descriptionMapByTag.put(272, "Model");
        descriptionMapByTag.put(273, "Strip Offsets");
        descriptionMapByTag.put(274, "Orientation");
        descriptionMapByTag.put(277, "Samples Per Pixel");
        descriptionMapByTag.put(278, "Rows Per Strip");
        descriptionMapByTag.put(279, "Strip Byte Counts");
        descriptionMapByTag.put(280, "Min Sample Value");
        descriptionMapByTag.put(281, "Max Sample Value");
        descriptionMapByTag.put(282, "X Resolution");
        descriptionMapByTag.put(283, "Y Resolution");
        descriptionMapByTag.put(284, "Planar Configuration");
        descriptionMapByTag.put(285, "Page Name");
        descriptionMapByTag.put(286, "X Position");
        descriptionMapByTag.put(287, "Y Position");
        descriptionMapByTag.put(288, "Free Offsets");
        descriptionMapByTag.put(289, "Free Byte Counts");
        descriptionMapByTag.put(290, "Gray Response Unit");
        descriptionMapByTag.put(291, "Gray Response Curve");
        descriptionMapByTag.put(292, "Group 3 Options");
        descriptionMapByTag.put(293, "Group 4 Options");
        descriptionMapByTag.put(296, "Resolution Unit");
        descriptionMapByTag.put(297, "Page Number");
        descriptionMapByTag.put(300, "Color Response Unit");
        descriptionMapByTag.put(301, "Transfer Function");
        descriptionMapByTag.put(305, "Software");
        descriptionMapByTag.put(306, "Date/Time");
        descriptionMapByTag.put(315, "Artist");
        descriptionMapByTag.put(316, "Host Computer");
        descriptionMapByTag.put(317, "Predictor");
        descriptionMapByTag.put(318, "White Point");
        descriptionMapByTag.put(319, "Primary Chromaticities");
        descriptionMapByTag.put(322, "Tile Width");
        descriptionMapByTag.put(323, "Tile Length");
        descriptionMapByTag.put(324, "Tile Offsets");
        descriptionMapByTag.put(325, "Tile Byte Counts");
        descriptionMapByTag.put(326, "Bad Fax Lines");
        descriptionMapByTag.put(327, "Clean Fax Data");
        descriptionMapByTag.put(328, "Consecutive Bad Fax Lines");
        descriptionMapByTag.put(330, "Sub IFDs");
        descriptionMapByTag.put(332, "Ink Set");
        descriptionMapByTag.put(333, "Ink Names");
        descriptionMapByTag.put(334, "Number Of Inks");
        descriptionMapByTag.put(336, "Dot Range");
        descriptionMapByTag.put(337, "Target Printer");
        descriptionMapByTag.put(338, "Extra Samples");
        descriptionMapByTag.put(339, "Sample Format");
        descriptionMapByTag.put(342, "Transfer Range");
        descriptionMapByTag.put(343, "Clip Path");
        descriptionMapByTag.put(344, "X Clip Path Units");
        descriptionMapByTag.put(345, "Y Clip Path Units");
        descriptionMapByTag.put(346, "Indexed");
        descriptionMapByTag.put(347, "JPEG Tables");
        descriptionMapByTag.put(351, "OPI Proxy");
        descriptionMapByTag.put(512, "JPEG Proc");
        descriptionMapByTag.put(513, "JPEG Interchange Format");
        descriptionMapByTag.put(514, "JPEG Interchange Format Length");
        descriptionMapByTag.put(515, "JPEG Restart Interval");
        descriptionMapByTag.put(517, "JPEG Lossless Predictors");
        descriptionMapByTag.put(518, "JPEG Point Transforms");
        descriptionMapByTag.put(519, "JPEG Q Tables");
        descriptionMapByTag.put(520, "JPEG DC Tables");
        descriptionMapByTag.put(521, "JPEG AC Tables");
        descriptionMapByTag.put(529, "YCbCr Coefficients");
        descriptionMapByTag.put(530, "YCbCr Subsampling");
        descriptionMapByTag.put(531, "YCbCr Positioning");
        descriptionMapByTag.put(532, "Reference Black White");
        descriptionMapByTag.put(700, "XMP");
        descriptionMapByTag.put(32781, "Image ID");
        descriptionMapByTag.put(32932, "Wang Annotation");
        descriptionMapByTag.put(33421, "CFA Repeat Pattern Dim");
        descriptionMapByTag.put(33422, "CFA Pattern");
        descriptionMapByTag.put(33423, "Battery Level");
        descriptionMapByTag.put(33432, "Copyright");
        descriptionMapByTag.put(33434, "Exposure Time");
        descriptionMapByTag.put(33437, "F Number");
        descriptionMapByTag.put(33723, "IPTC NAA");
        descriptionMapByTag.put(33550, "Model Pixel Scale Tag");
        descriptionMapByTag.put(33920, "Intergraph Matrix Tag");
        descriptionMapByTag.put(33922, "Model Tiepoint Tag");
        descriptionMapByTag.put(34016, "Site");
        descriptionMapByTag.put(34017, "Color Sequence");
        descriptionMapByTag.put(34018, "IT8 Header");
        descriptionMapByTag.put(34019, "Raster Padding");
        descriptionMapByTag.put(34020, "Bits Per Run Length");
        descriptionMapByTag.put(34021, "Bits Per Extended Run Length");
        descriptionMapByTag.put(34022, "Color Table");
        descriptionMapByTag.put(34023, "Image Color Indicator");
        descriptionMapByTag.put(34024, "Background Color Indicator");
        descriptionMapByTag.put(34025, "Image Color Value");
        descriptionMapByTag.put(34026, "Background Color Value");
        descriptionMapByTag.put(34027, "Pixel Intensity Range");
        descriptionMapByTag.put(34028, "Transparency Indicator");
        descriptionMapByTag.put(34029, "Color Characterization");
        descriptionMapByTag.put(34030, "HC Usage");
        descriptionMapByTag.put(34264, "Model Transformation Tag");
        descriptionMapByTag.put(34377, "Photoshop Image Resources");
        descriptionMapByTag.put(34665, "Exif IFD Pointer");
        descriptionMapByTag.put(34675, "Inter Colour Profile");
        descriptionMapByTag.put(34735, "Geo Key DirectoryTag");
        descriptionMapByTag.put(34736, "Geo Double Params Tag");
        descriptionMapByTag.put(34737, "Geo Ascii Params Tag");
        descriptionMapByTag.put(34850, "Exposure Program");
        descriptionMapByTag.put(34852, "Spectral Sensitivity");
        descriptionMapByTag.put(34853, "GPS Info IFD Pointer");
        descriptionMapByTag.put(34855, "ISO Speed Ratings");
        descriptionMapByTag.put(34856, "OECF");
        descriptionMapByTag.put(34857, "Interlace");
        descriptionMapByTag.put(34858, "Time Zone Offset");
        descriptionMapByTag.put(34859, "Self Timer Mode");
        descriptionMapByTag.put(36864, "EXIF Version");
        descriptionMapByTag.put(36867, "Date/Time Original");
        descriptionMapByTag.put(36868, "Date/Time Digitized");
        descriptionMapByTag.put(37121, "Component Configuration");
        descriptionMapByTag.put(37122, "Compressed Bits Per Pixel");
        descriptionMapByTag.put(37377, "Shutter SpeedValue");
        descriptionMapByTag.put(37378, "Aperture Value");
        descriptionMapByTag.put(37379, "Brightness Value");
        descriptionMapByTag.put(37380, "Exposure Bias Value");
        descriptionMapByTag.put(37381, "Max Aperture Value");
        descriptionMapByTag.put(37382, "Subject Distance");
        descriptionMapByTag.put(37383, "Metering Mode");
        descriptionMapByTag.put(37384, "Light Source");
        descriptionMapByTag.put(37385, "Flash");
        descriptionMapByTag.put(37386, "Focal Length");
        descriptionMapByTag.put(37387, "Flash Energy2");
        descriptionMapByTag.put(37388, "Spatial FrequencyResponse2");
        descriptionMapByTag.put(37389, "Noise");
        descriptionMapByTag.put(37390, "Focal PlaneXResolution2");
        descriptionMapByTag.put(37391, "Focal PlaneYResolution2");
        descriptionMapByTag.put(37392, "Focal PlaneResolutionUnit2");
        descriptionMapByTag.put(37393, "Image Number");
        descriptionMapByTag.put(37394, "Security Classification");
        descriptionMapByTag.put(37395, "Image History");
        descriptionMapByTag.put(37396, "Subject Area");
        descriptionMapByTag.put(37397, "Exposure Index 2");
        descriptionMapByTag.put(37398, "TIFF_EP Standard ID");
        descriptionMapByTag.put(37399, "Sensing Method 2");
        descriptionMapByTag.put(37500, "Maker Note");
        descriptionMapByTag.put(37510, "User Comment");
        descriptionMapByTag.put(37520, "Subsec Time");
        descriptionMapByTag.put(37521, "Subsec Time Original");
        descriptionMapByTag.put(37522, "Subsec Time Digitized");
        descriptionMapByTag.put(37724, "Image Source Data");
        descriptionMapByTag.put(40960, "FlashPix Version");
        descriptionMapByTag.put(40961, "Color Space");
        descriptionMapByTag.put(40962, "Pixel X Dimension");
        descriptionMapByTag.put(40963, "Pixel Y Dimension");
        descriptionMapByTag.put(40964, "Related Sound File");
        descriptionMapByTag.put(40965, "Interoperability IFD");
        descriptionMapByTag.put(41483, "Flash Energy");
        descriptionMapByTag.put(41484, "Spatial Frequency Response");
        descriptionMapByTag.put(41486, "Focal Plane X Resolution");
        descriptionMapByTag.put(41487, "Focal Plane Y Resolution");
        descriptionMapByTag.put(41488, "Focal Plane ResolutionUnit");
        descriptionMapByTag.put(41492, "Subject Location");
        descriptionMapByTag.put(41493, "Exposure Index");
        descriptionMapByTag.put(41495, "Sensing Method");
        descriptionMapByTag.put(41728, "File Source");
        descriptionMapByTag.put(41729, "Scene Type");
        descriptionMapByTag.put(41730, "EXIF CFA Pattern");
        descriptionMapByTag.put(41985, "Custom Rendered");
        descriptionMapByTag.put(41986, "Exposure Mode");
        descriptionMapByTag.put(41987, "White Balance");
        descriptionMapByTag.put(41988, "Digital Zoom Ratio");
        descriptionMapByTag.put(41989, "Focal Length 35mm Film");
        descriptionMapByTag.put(41990, "Scene Capture Type");
        descriptionMapByTag.put(41991, "Gain Control");
        descriptionMapByTag.put(41992, "Contrast");
        descriptionMapByTag.put(41993, "Saturation");
        descriptionMapByTag.put(41994, "Sharpness");
        descriptionMapByTag.put(41995, "Device Setting Description");
        descriptionMapByTag.put(41996, "Subject Distance Range");
        descriptionMapByTag.put(42016, "Image Unique ID");
        descriptionMapByTag.put(50255, "Photoshop Annotations");
        descriptionMapByTag.put(61441, "Thumbnail");
        descriptionMapByTag.put(50706, "DNG Version");
        descriptionMapByTag.put(50707, "DNG Backward Version");
        descriptionMapByTag.put(50708, "Unique Camera Model");
        descriptionMapByTag.put(50709, "Localized Camera Model");
        descriptionMapByTag.put(50710, "CFA Plane Color");
        descriptionMapByTag.put(50711, "CFA Layout");
        descriptionMapByTag.put(50712, "Linearization Table");
        descriptionMapByTag.put(50713, "Black Level Repeat Dim");
        descriptionMapByTag.put(50714, "Black Level");
        descriptionMapByTag.put(50715, "Black Level Delta H");
        descriptionMapByTag.put(50716, "Black Level Delta V");
        descriptionMapByTag.put(50717, "White Level");
        descriptionMapByTag.put(50718, "Default Scale");
        descriptionMapByTag.put(50780, "Best Quality Scale");
        descriptionMapByTag.put(50719, "Default Crop Origin");
        descriptionMapByTag.put(50720, "Default Crop Size");
        descriptionMapByTag.put(50778, "Calibration Illuminant 1");
        descriptionMapByTag.put(50779, "Calibration Illuminant 2");
        descriptionMapByTag.put(50721, "Color Matrix 1");
        descriptionMapByTag.put(50722, "Color Matrix 2");
        descriptionMapByTag.put(50723, "Camera Calibration 1");
        descriptionMapByTag.put(50724, "Camera Calibration 2");
        descriptionMapByTag.put(50725, "Reduction Matrix 1");
        descriptionMapByTag.put(50726, "Reduction Matrix 2");
        descriptionMapByTag.put(50727, "Analog Balance");
        descriptionMapByTag.put(50728, "As Shot Neutral");
        descriptionMapByTag.put(50729, "As Shot White XY");
        descriptionMapByTag.put(50730, "Baseline Exposure");
        descriptionMapByTag.put(50731, "Baseline Noise");
        descriptionMapByTag.put(50732, "Baseline Sharpness");
        descriptionMapByTag.put(50733, "Bayer Green Split");
        descriptionMapByTag.put(50734, "Linear Response Limit");
        descriptionMapByTag.put(50735, "Camera Serial Number");
        descriptionMapByTag.put(50736, "Lens Info");
        descriptionMapByTag.put(50737, "Chroma Blur Radius");
        descriptionMapByTag.put(50738, "Anti Alias Strength");
        descriptionMapByTag.put(50740, "DNG Private Data");
        descriptionMapByTag.put(50741, "Maker Note Safety");
        descriptionMapByTag.put(50739, "Shadow Scale");
        descriptionMapByTag.put(50781, "Raw Data Unique ID");
        descriptionMapByTag.put(50827, "Original Raw File Name");
        descriptionMapByTag.put(50828, "Original Raw File Data");
        descriptionMapByTag.put(50829, "Active Area");
        descriptionMapByTag.put(50830, "Masked Areas");
        descriptionMapByTag.put(50831, "As Shot ICC Profile");
        descriptionMapByTag.put(50832, "As Shot Pre Profile Matrix");
        descriptionMapByTag.put(50833, "Current ICC Profile");
        descriptionMapByTag.put(50834, "Current Pre Profile Matrix");
        descriptionMapByTag.put(50879, "Colorimetric Reference");
        descriptionMapByTag.put(50931, "Camera Calibration Signature");
        descriptionMapByTag.put(50932, "Profile Calibration Signature");
        descriptionMapByTag.put(50933, "Extra Camera Profiles");
        descriptionMapByTag.put(50934, "As Shot Profile Name");
        descriptionMapByTag.put(50935, "Noise Resolution Applied");
        descriptionMapByTag.put(50936, "Profile Name");
        descriptionMapByTag.put(50397, "Profile Hue Sat Map Dims");
        descriptionMapByTag.put(50938, "Profile Hue Sat Map Data 1");
        descriptionMapByTag.put(50939, "Profile Hue Sat Map Data 2");
        descriptionMapByTag.put(50940, "Profile Tone Curve");
        descriptionMapByTag.put(50941, "Profile Embed Policy");
        descriptionMapByTag.put(50942, "Profile Copyright");
        descriptionMapByTag.put(50964, "Forward Matrix 1");
        descriptionMapByTag.put(50965, "Forward Matrix 2");
        descriptionMapByTag.put(50966, "Preview Application Name");
        descriptionMapByTag.put(50967, "Preview Application Version");
        descriptionMapByTag.put(50968, "Preview Settings Name");
        descriptionMapByTag.put(50969, "Preview IFD");
        descriptionMapByTag.put(50970, "Preview Color Space");
        descriptionMapByTag.put(50971, "Preview Date Time");
        descriptionMapByTag.put(50972, "Raw Image Digest");
        descriptionMapByTag.put(50793, "Original Raw File Digest");
        descriptionMapByTag.put(50974, "Sub Tile Block Size");
        descriptionMapByTag.put(50975, "Row Interleave Factor");
        descriptionMapByTag.put(50981, "Profile Look Table Dims");
        descriptionMapByTag.put(50982, "Profile Look Table Data");

      }
    public static enum NewSubFileType
       {
         IMAGE(0, "image"),
         REDUCED_RESOLUTION(1, "reduced resolution"),
         PAGE(2, "page"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private NewSubFileType (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static NewSubFileType fromInteger (int value)
           {
             if (value == 0) return IMAGE;
             if (value == 1) return REDUCED_RESOLUTION;
             if (value == 2) return PAGE;

             return _UNKNOWN;
           }
       }
    public void setNewSubFileType (final NewSubFileType newSubFileType)
      {
        final NewSubFileType oldValue = getNewSubFileType();
        final boolean oldPropAvailable = isNewSubFileTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.NEW_SUBFILE_TYPE, newSubFileType);
        propertyChangeSupport.firePropertyChange("newSubFileType", oldValue, newSubFileType);
        propertyChangeSupport.firePropertyChange("newSubFileTypeAvailable", oldPropAvailable, isNewSubFileTypeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public NewSubFileType getNewSubFileType()
      {
        return getObject(NEW_SUBFILE_TYPE, NewSubFileType.class);
      }

    public void setNewSubFileTypeAvailable (final boolean available)
      {
        final NewSubFileType oldValue = getNewSubFileType();
        final boolean oldPropAvailable = isNewSubFileTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(NEW_SUBFILE_TYPE))
          {
            setObject(NEW_SUBFILE_TYPE, null);
          }
        else if (!available)
          {
            removeTag(NEW_SUBFILE_TYPE);
          }

        propertyChangeSupport.firePropertyChange("newSubFileTypeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("newSubFileType", oldValue, getNewSubFileType());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isNewSubFileTypeAvailable()
      {
        return containsTag(NEW_SUBFILE_TYPE);
      }

    public static enum SubFileType
       {
         FULL_RESOLUTION(1, "full resolution"),
         REDUCED_RESOLUTION(2, "reduced resolution"),
         PAGE(3, "page"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private SubFileType (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static SubFileType fromInteger (int value)
           {
             if (value == 1) return FULL_RESOLUTION;
             if (value == 2) return REDUCED_RESOLUTION;
             if (value == 3) return PAGE;

             return _UNKNOWN;
           }
       }
    public void setSubFileType (final SubFileType subFileType)
      {
        final SubFileType oldValue = getSubFileType();
        final boolean oldPropAvailable = isSubFileTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUB_FILETYPE, subFileType);
        propertyChangeSupport.firePropertyChange("subFileType", oldValue, subFileType);
        propertyChangeSupport.firePropertyChange("subFileTypeAvailable", oldPropAvailable, isSubFileTypeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public SubFileType getSubFileType()
      {
        return getObject(SUB_FILETYPE, SubFileType.class);
      }

    public void setSubFileTypeAvailable (final boolean available)
      {
        final SubFileType oldValue = getSubFileType();
        final boolean oldPropAvailable = isSubFileTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUB_FILETYPE))
          {
            setObject(SUB_FILETYPE, null);
          }
        else if (!available)
          {
            removeTag(SUB_FILETYPE);
          }

        propertyChangeSupport.firePropertyChange("subFileTypeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subFileType", oldValue, getSubFileType());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubFileTypeAvailable()
      {
        return containsTag(SUB_FILETYPE);
      }

    public void setImageWidth (final Long imageWidth)
      {
        final Long oldValue = getImageWidth();
        final boolean oldPropAvailable = isImageWidthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_WIDTH, imageWidth);
        propertyChangeSupport.firePropertyChange("imageWidth", oldValue, imageWidth);
        propertyChangeSupport.firePropertyChange("imageWidthAvailable", oldPropAvailable, isImageWidthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getImageWidth()
      {
        return getObject(IMAGE_WIDTH, Long.class);
      }

    public void setImageWidthAvailable (final boolean available)
      {
        final Long oldValue = getImageWidth();
        final boolean oldPropAvailable = isImageWidthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_WIDTH))
          {
            setObject(IMAGE_WIDTH, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_WIDTH);
          }

        propertyChangeSupport.firePropertyChange("imageWidthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageWidth", oldValue, getImageWidth());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageWidthAvailable()
      {
        return containsTag(IMAGE_WIDTH);
      }

    public void setImageLength (final Long imageLength)
      {
        final Long oldValue = getImageLength();
        final boolean oldPropAvailable = isImageLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_LENGTH, imageLength);
        propertyChangeSupport.firePropertyChange("imageLength", oldValue, imageLength);
        propertyChangeSupport.firePropertyChange("imageLengthAvailable", oldPropAvailable, isImageLengthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getImageLength()
      {
        return getObject(IMAGE_LENGTH, Long.class);
      }

    public void setImageLengthAvailable (final boolean available)
      {
        final Long oldValue = getImageLength();
        final boolean oldPropAvailable = isImageLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_LENGTH))
          {
            setObject(IMAGE_LENGTH, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_LENGTH);
          }

        propertyChangeSupport.firePropertyChange("imageLengthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageLength", oldValue, getImageLength());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageLengthAvailable()
      {
        return containsTag(IMAGE_LENGTH);
      }

    public void setBitsPerSample (final int[] bitsPerSample)
      {
        final int[] oldValue = getBitsPerSample();
        final boolean oldPropAvailable = isBitsPerSampleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BITS_PER_SAMPLE, bitsPerSample);
        propertyChangeSupport.firePropertyChange("bitsPerSample", oldValue, bitsPerSample);
        propertyChangeSupport.firePropertyChange("bitsPerSampleAvailable", oldPropAvailable, isBitsPerSampleAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getBitsPerSample()
      {
        return getObject(BITS_PER_SAMPLE, int[].class);
      }

    public void setBitsPerSampleAvailable (final boolean available)
      {
        final int[] oldValue = getBitsPerSample();
        final boolean oldPropAvailable = isBitsPerSampleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BITS_PER_SAMPLE))
          {
            setObject(BITS_PER_SAMPLE, null);
          }
        else if (!available)
          {
            removeTag(BITS_PER_SAMPLE);
          }

        propertyChangeSupport.firePropertyChange("bitsPerSampleAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("bitsPerSample", oldValue, getBitsPerSample());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBitsPerSampleAvailable()
      {
        return containsTag(BITS_PER_SAMPLE);
      }

    public static enum Compression
       {
         UNCOMPRESSED(1, "uncompressed"),
         LZW(5, "lzw"),
         OJPEG(6, "OJPEG"),
         JPEG(7, "JPEG"),
         NEF_COMPRESSED(-30283, "NEF compressed"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private Compression (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static Compression fromInteger (int value)
           {
             if (value == 1) return UNCOMPRESSED;
             if (value == 5) return LZW;
             if (value == 6) return OJPEG;
             if (value == 7) return JPEG;
             if (value == -30283) return NEF_COMPRESSED;

             return _UNKNOWN;
           }
       }
    public void setCompression (final Compression compression)
      {
        final Compression oldValue = getCompression();
        final boolean oldPropAvailable = isCompressionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COMPRESSION, compression);
        propertyChangeSupport.firePropertyChange("compression", oldValue, compression);
        propertyChangeSupport.firePropertyChange("compressionAvailable", oldPropAvailable, isCompressionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Compression getCompression()
      {
        return getObject(COMPRESSION, Compression.class);
      }

    public void setCompressionAvailable (final boolean available)
      {
        final Compression oldValue = getCompression();
        final boolean oldPropAvailable = isCompressionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COMPRESSION))
          {
            setObject(COMPRESSION, null);
          }
        else if (!available)
          {
            removeTag(COMPRESSION);
          }

        propertyChangeSupport.firePropertyChange("compressionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("compression", oldValue, getCompression());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCompressionAvailable()
      {
        return containsTag(COMPRESSION);
      }

    public static enum PhotometricInterpretation
       {
         RGB(2, "rgb"),
         YCBCR(6, "YCbCr"),
         CFA(32803, "CFA"),
         LINEAR_RAW(34892, "Linear RAW"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private PhotometricInterpretation (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static PhotometricInterpretation fromInteger (int value)
           {
             if (value == 2) return RGB;
             if (value == 6) return YCBCR;
             if (value == 32803) return CFA;
             if (value == 34892) return LINEAR_RAW;

             return _UNKNOWN;
           }
       }
    public void setPhotometricInterpretation (final PhotometricInterpretation photometricInterpretation)
      {
        final PhotometricInterpretation oldValue = getPhotometricInterpretation();
        final boolean oldPropAvailable = isPhotometricInterpretationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PHOTOMETRIC_INTERPRETATION, photometricInterpretation);
        propertyChangeSupport.firePropertyChange("photometricInterpretation", oldValue, photometricInterpretation);
        propertyChangeSupport.firePropertyChange("photometricInterpretationAvailable", oldPropAvailable, isPhotometricInterpretationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public PhotometricInterpretation getPhotometricInterpretation()
      {
        return getObject(PHOTOMETRIC_INTERPRETATION, PhotometricInterpretation.class);
      }

    public void setPhotometricInterpretationAvailable (final boolean available)
      {
        final PhotometricInterpretation oldValue = getPhotometricInterpretation();
        final boolean oldPropAvailable = isPhotometricInterpretationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PHOTOMETRIC_INTERPRETATION))
          {
            setObject(PHOTOMETRIC_INTERPRETATION, null);
          }
        else if (!available)
          {
            removeTag(PHOTOMETRIC_INTERPRETATION);
          }

        propertyChangeSupport.firePropertyChange("photometricInterpretationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("photometricInterpretation", oldValue, getPhotometricInterpretation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPhotometricInterpretationAvailable()
      {
        return containsTag(PHOTOMETRIC_INTERPRETATION);
      }

    public void setThresholding (final Integer thresholding)
      {
        final Integer oldValue = getThresholding();
        final boolean oldPropAvailable = isThresholdingAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.THRESHOLDING, thresholding);
        propertyChangeSupport.firePropertyChange("thresholding", oldValue, thresholding);
        propertyChangeSupport.firePropertyChange("thresholdingAvailable", oldPropAvailable, isThresholdingAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getThresholding()
      {
        return getObject(THRESHOLDING, Integer.class);
      }

    public void setThresholdingAvailable (final boolean available)
      {
        final Integer oldValue = getThresholding();
        final boolean oldPropAvailable = isThresholdingAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(THRESHOLDING))
          {
            setObject(THRESHOLDING, null);
          }
        else if (!available)
          {
            removeTag(THRESHOLDING);
          }

        propertyChangeSupport.firePropertyChange("thresholdingAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("thresholding", oldValue, getThresholding());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isThresholdingAvailable()
      {
        return containsTag(THRESHOLDING);
      }

    public void setCellWidth (final Integer cellWidth)
      {
        final Integer oldValue = getCellWidth();
        final boolean oldPropAvailable = isCellWidthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CELL_WIDTH, cellWidth);
        propertyChangeSupport.firePropertyChange("cellWidth", oldValue, cellWidth);
        propertyChangeSupport.firePropertyChange("cellWidthAvailable", oldPropAvailable, isCellWidthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getCellWidth()
      {
        return getObject(CELL_WIDTH, Integer.class);
      }

    public void setCellWidthAvailable (final boolean available)
      {
        final Integer oldValue = getCellWidth();
        final boolean oldPropAvailable = isCellWidthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CELL_WIDTH))
          {
            setObject(CELL_WIDTH, null);
          }
        else if (!available)
          {
            removeTag(CELL_WIDTH);
          }

        propertyChangeSupport.firePropertyChange("cellWidthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("cellWidth", oldValue, getCellWidth());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCellWidthAvailable()
      {
        return containsTag(CELL_WIDTH);
      }

    public void setCellLength (final Integer cellLength)
      {
        final Integer oldValue = getCellLength();
        final boolean oldPropAvailable = isCellLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CELL_LENGTH, cellLength);
        propertyChangeSupport.firePropertyChange("cellLength", oldValue, cellLength);
        propertyChangeSupport.firePropertyChange("cellLengthAvailable", oldPropAvailable, isCellLengthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getCellLength()
      {
        return getObject(CELL_LENGTH, Integer.class);
      }

    public void setCellLengthAvailable (final boolean available)
      {
        final Integer oldValue = getCellLength();
        final boolean oldPropAvailable = isCellLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CELL_LENGTH))
          {
            setObject(CELL_LENGTH, null);
          }
        else if (!available)
          {
            removeTag(CELL_LENGTH);
          }

        propertyChangeSupport.firePropertyChange("cellLengthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("cellLength", oldValue, getCellLength());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCellLengthAvailable()
      {
        return containsTag(CELL_LENGTH);
      }

    public void setFillOrder (final Integer fillOrder)
      {
        final Integer oldValue = getFillOrder();
        final boolean oldPropAvailable = isFillOrderAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FILL_ORDER, fillOrder);
        propertyChangeSupport.firePropertyChange("fillOrder", oldValue, fillOrder);
        propertyChangeSupport.firePropertyChange("fillOrderAvailable", oldPropAvailable, isFillOrderAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getFillOrder()
      {
        return getObject(FILL_ORDER, Integer.class);
      }

    public void setFillOrderAvailable (final boolean available)
      {
        final Integer oldValue = getFillOrder();
        final boolean oldPropAvailable = isFillOrderAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FILL_ORDER))
          {
            setObject(FILL_ORDER, null);
          }
        else if (!available)
          {
            removeTag(FILL_ORDER);
          }

        propertyChangeSupport.firePropertyChange("fillOrderAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("fillOrder", oldValue, getFillOrder());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFillOrderAvailable()
      {
        return containsTag(FILL_ORDER);
      }

    public void setDocumentName (final String documentName)
      {
        final String oldValue = getDocumentName();
        final boolean oldPropAvailable = isDocumentNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DOCUMENT_NAME, documentName);
        propertyChangeSupport.firePropertyChange("documentName", oldValue, documentName);
        propertyChangeSupport.firePropertyChange("documentNameAvailable", oldPropAvailable, isDocumentNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getDocumentName()
      {
        return getObject(DOCUMENT_NAME, String.class);
      }

    public void setDocumentNameAvailable (final boolean available)
      {
        final String oldValue = getDocumentName();
        final boolean oldPropAvailable = isDocumentNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DOCUMENT_NAME))
          {
            setObject(DOCUMENT_NAME, null);
          }
        else if (!available)
          {
            removeTag(DOCUMENT_NAME);
          }

        propertyChangeSupport.firePropertyChange("documentNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("documentName", oldValue, getDocumentName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDocumentNameAvailable()
      {
        return containsTag(DOCUMENT_NAME);
      }

    public void setImageDescription (final String imageDescription)
      {
        final String oldValue = getImageDescription();
        final boolean oldPropAvailable = isImageDescriptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_DESCRIPTION, imageDescription);
        propertyChangeSupport.firePropertyChange("imageDescription", oldValue, imageDescription);
        propertyChangeSupport.firePropertyChange("imageDescriptionAvailable", oldPropAvailable, isImageDescriptionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getImageDescription()
      {
        return getObject(IMAGE_DESCRIPTION, String.class);
      }

    public void setImageDescriptionAvailable (final boolean available)
      {
        final String oldValue = getImageDescription();
        final boolean oldPropAvailable = isImageDescriptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_DESCRIPTION))
          {
            setObject(IMAGE_DESCRIPTION, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_DESCRIPTION);
          }

        propertyChangeSupport.firePropertyChange("imageDescriptionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageDescription", oldValue, getImageDescription());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageDescriptionAvailable()
      {
        return containsTag(IMAGE_DESCRIPTION);
      }

    public void setMake (final String make)
      {
        final String oldValue = getMake();
        final boolean oldPropAvailable = isMakeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MAKE, make);
        propertyChangeSupport.firePropertyChange("make", oldValue, make);
        propertyChangeSupport.firePropertyChange("makeAvailable", oldPropAvailable, isMakeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getMake()
      {
        return getObject(MAKE, String.class);
      }

    public void setMakeAvailable (final boolean available)
      {
        final String oldValue = getMake();
        final boolean oldPropAvailable = isMakeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MAKE))
          {
            setObject(MAKE, null);
          }
        else if (!available)
          {
            removeTag(MAKE);
          }

        propertyChangeSupport.firePropertyChange("makeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("make", oldValue, getMake());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isMakeAvailable()
      {
        return containsTag(MAKE);
      }

    public void setModel (final String model)
      {
        final String oldValue = getModel();
        final boolean oldPropAvailable = isModelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MODEL, model);
        propertyChangeSupport.firePropertyChange("model", oldValue, model);
        propertyChangeSupport.firePropertyChange("modelAvailable", oldPropAvailable, isModelAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getModel()
      {
        return getObject(MODEL, String.class);
      }

    public void setModelAvailable (final boolean available)
      {
        final String oldValue = getModel();
        final boolean oldPropAvailable = isModelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MODEL))
          {
            setObject(MODEL, null);
          }
        else if (!available)
          {
            removeTag(MODEL);
          }

        propertyChangeSupport.firePropertyChange("modelAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("model", oldValue, getModel());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isModelAvailable()
      {
        return containsTag(MODEL);
      }

    public void setStripOffsets (final Integer stripOffsets)
      {
        final Integer oldValue = getStripOffsets();
        final boolean oldPropAvailable = isStripOffsetsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.STRIP_OFFSETS, stripOffsets);
        propertyChangeSupport.firePropertyChange("stripOffsets", oldValue, stripOffsets);
        propertyChangeSupport.firePropertyChange("stripOffsetsAvailable", oldPropAvailable, isStripOffsetsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getStripOffsets()
      {
        return getObject(STRIP_OFFSETS, Integer.class);
      }

    public void setStripOffsetsAvailable (final boolean available)
      {
        final Integer oldValue = getStripOffsets();
        final boolean oldPropAvailable = isStripOffsetsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(STRIP_OFFSETS))
          {
            setObject(STRIP_OFFSETS, null);
          }
        else if (!available)
          {
            removeTag(STRIP_OFFSETS);
          }

        propertyChangeSupport.firePropertyChange("stripOffsetsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("stripOffsets", oldValue, getStripOffsets());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isStripOffsetsAvailable()
      {
        return containsTag(STRIP_OFFSETS);
      }

    public static enum Orientation
       {
         TOP_LEFT(1, "TOP LEFT"),
         TOP_RIGHT(2, "TOP RIGHT"),
         BOTTOM_RIGHT(3, "BOTTOM RIGHT"),
         BOTTOM_LEFT(4, "BOTTOM LEFT"),
         LEFT_TOP(5, "LEFT TOP"),
         RIGHT_TOP(6, "RIGHT TOP"),
         RIGHT_BOTTOM(7, "RIGHT BOTTOM"),
         LEFT_BOTTOM(8, "LEFT BOTTOM"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private Orientation (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static Orientation fromInteger (int value)
           {
             if (value == 1) return TOP_LEFT;
             if (value == 2) return TOP_RIGHT;
             if (value == 3) return BOTTOM_RIGHT;
             if (value == 4) return BOTTOM_LEFT;
             if (value == 5) return LEFT_TOP;
             if (value == 6) return RIGHT_TOP;
             if (value == 7) return RIGHT_BOTTOM;
             if (value == 8) return LEFT_BOTTOM;

             return _UNKNOWN;
           }
       }
    public void setOrientation (final Orientation orientation)
      {
        final Orientation oldValue = getOrientation();
        final boolean oldPropAvailable = isOrientationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ORIENTATION, orientation);
        propertyChangeSupport.firePropertyChange("orientation", oldValue, orientation);
        propertyChangeSupport.firePropertyChange("orientationAvailable", oldPropAvailable, isOrientationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Orientation getOrientation()
      {
        return getObject(ORIENTATION, Orientation.class);
      }

    public void setOrientationAvailable (final boolean available)
      {
        final Orientation oldValue = getOrientation();
        final boolean oldPropAvailable = isOrientationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ORIENTATION))
          {
            setObject(ORIENTATION, null);
          }
        else if (!available)
          {
            removeTag(ORIENTATION);
          }

        propertyChangeSupport.firePropertyChange("orientationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("orientation", oldValue, getOrientation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isOrientationAvailable()
      {
        return containsTag(ORIENTATION);
      }

    public void setSamplesPerPixel (final Integer samplesPerPixel)
      {
        final Integer oldValue = getSamplesPerPixel();
        final boolean oldPropAvailable = isSamplesPerPixelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SAMPLES_PER_PIXEL, samplesPerPixel);
        propertyChangeSupport.firePropertyChange("samplesPerPixel", oldValue, samplesPerPixel);
        propertyChangeSupport.firePropertyChange("samplesPerPixelAvailable", oldPropAvailable, isSamplesPerPixelAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getSamplesPerPixel()
      {
        return getObject(SAMPLES_PER_PIXEL, Integer.class);
      }

    public void setSamplesPerPixelAvailable (final boolean available)
      {
        final Integer oldValue = getSamplesPerPixel();
        final boolean oldPropAvailable = isSamplesPerPixelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SAMPLES_PER_PIXEL))
          {
            setObject(SAMPLES_PER_PIXEL, null);
          }
        else if (!available)
          {
            removeTag(SAMPLES_PER_PIXEL);
          }

        propertyChangeSupport.firePropertyChange("samplesPerPixelAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("samplesPerPixel", oldValue, getSamplesPerPixel());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSamplesPerPixelAvailable()
      {
        return containsTag(SAMPLES_PER_PIXEL);
      }

    public void setRowsPerStrip (final Integer rowsPerStrip)
      {
        final Integer oldValue = getRowsPerStrip();
        final boolean oldPropAvailable = isRowsPerStripAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ROWS_PER_STRIP, rowsPerStrip);
        propertyChangeSupport.firePropertyChange("rowsPerStrip", oldValue, rowsPerStrip);
        propertyChangeSupport.firePropertyChange("rowsPerStripAvailable", oldPropAvailable, isRowsPerStripAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getRowsPerStrip()
      {
        return getObject(ROWS_PER_STRIP, Integer.class);
      }

    public void setRowsPerStripAvailable (final boolean available)
      {
        final Integer oldValue = getRowsPerStrip();
        final boolean oldPropAvailable = isRowsPerStripAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ROWS_PER_STRIP))
          {
            setObject(ROWS_PER_STRIP, null);
          }
        else if (!available)
          {
            removeTag(ROWS_PER_STRIP);
          }

        propertyChangeSupport.firePropertyChange("rowsPerStripAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("rowsPerStrip", oldValue, getRowsPerStrip());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isRowsPerStripAvailable()
      {
        return containsTag(ROWS_PER_STRIP);
      }

    public void setStripByteCounts (final Integer stripByteCounts)
      {
        final Integer oldValue = getStripByteCounts();
        final boolean oldPropAvailable = isStripByteCountsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.STRIP_BYTE_COUNTS, stripByteCounts);
        propertyChangeSupport.firePropertyChange("stripByteCounts", oldValue, stripByteCounts);
        propertyChangeSupport.firePropertyChange("stripByteCountsAvailable", oldPropAvailable, isStripByteCountsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getStripByteCounts()
      {
        return getObject(STRIP_BYTE_COUNTS, Integer.class);
      }

    public void setStripByteCountsAvailable (final boolean available)
      {
        final Integer oldValue = getStripByteCounts();
        final boolean oldPropAvailable = isStripByteCountsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(STRIP_BYTE_COUNTS))
          {
            setObject(STRIP_BYTE_COUNTS, null);
          }
        else if (!available)
          {
            removeTag(STRIP_BYTE_COUNTS);
          }

        propertyChangeSupport.firePropertyChange("stripByteCountsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("stripByteCounts", oldValue, getStripByteCounts());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isStripByteCountsAvailable()
      {
        return containsTag(STRIP_BYTE_COUNTS);
      }

    public void setMinSampleValue (final int[] minSampleValue)
      {
        final int[] oldValue = getMinSampleValue();
        final boolean oldPropAvailable = isMinSampleValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MIN_SAMPLE_VALUE, minSampleValue);
        propertyChangeSupport.firePropertyChange("minSampleValue", oldValue, minSampleValue);
        propertyChangeSupport.firePropertyChange("minSampleValueAvailable", oldPropAvailable, isMinSampleValueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getMinSampleValue()
      {
        return getObject(MIN_SAMPLE_VALUE, int[].class);
      }

    public void setMinSampleValueAvailable (final boolean available)
      {
        final int[] oldValue = getMinSampleValue();
        final boolean oldPropAvailable = isMinSampleValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MIN_SAMPLE_VALUE))
          {
            setObject(MIN_SAMPLE_VALUE, null);
          }
        else if (!available)
          {
            removeTag(MIN_SAMPLE_VALUE);
          }

        propertyChangeSupport.firePropertyChange("minSampleValueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("minSampleValue", oldValue, getMinSampleValue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isMinSampleValueAvailable()
      {
        return containsTag(MIN_SAMPLE_VALUE);
      }

    public void setMaxSampleValue (final int[] maxSampleValue)
      {
        final int[] oldValue = getMaxSampleValue();
        final boolean oldPropAvailable = isMaxSampleValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MAX_SAMPLE_VALUE, maxSampleValue);
        propertyChangeSupport.firePropertyChange("maxSampleValue", oldValue, maxSampleValue);
        propertyChangeSupport.firePropertyChange("maxSampleValueAvailable", oldPropAvailable, isMaxSampleValueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getMaxSampleValue()
      {
        return getObject(MAX_SAMPLE_VALUE, int[].class);
      }

    public void setMaxSampleValueAvailable (final boolean available)
      {
        final int[] oldValue = getMaxSampleValue();
        final boolean oldPropAvailable = isMaxSampleValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MAX_SAMPLE_VALUE))
          {
            setObject(MAX_SAMPLE_VALUE, null);
          }
        else if (!available)
          {
            removeTag(MAX_SAMPLE_VALUE);
          }

        propertyChangeSupport.firePropertyChange("maxSampleValueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("maxSampleValue", oldValue, getMaxSampleValue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isMaxSampleValueAvailable()
      {
        return containsTag(MAX_SAMPLE_VALUE);
      }

    public void setXResolution (final Rational XResolution)
      {
        final Rational oldValue = getXResolution();
        final boolean oldPropAvailable = isXResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.X_RESOLUTION, XResolution);
        propertyChangeSupport.firePropertyChange("XResolution", oldValue, XResolution);
        propertyChangeSupport.firePropertyChange("XResolutionAvailable", oldPropAvailable, isXResolutionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getXResolution()
      {
        return getObject(X_RESOLUTION, Rational.class);
      }

    public void setXResolutionAvailable (final boolean available)
      {
        final Rational oldValue = getXResolution();
        final boolean oldPropAvailable = isXResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(X_RESOLUTION))
          {
            setObject(X_RESOLUTION, null);
          }
        else if (!available)
          {
            removeTag(X_RESOLUTION);
          }

        propertyChangeSupport.firePropertyChange("XResolutionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("XResolution", oldValue, getXResolution());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isXResolutionAvailable()
      {
        return containsTag(X_RESOLUTION);
      }

    public void setYResolution (final Rational YResolution)
      {
        final Rational oldValue = getYResolution();
        final boolean oldPropAvailable = isYResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.Y_RESOLUTION, YResolution);
        propertyChangeSupport.firePropertyChange("YResolution", oldValue, YResolution);
        propertyChangeSupport.firePropertyChange("YResolutionAvailable", oldPropAvailable, isYResolutionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getYResolution()
      {
        return getObject(Y_RESOLUTION, Rational.class);
      }

    public void setYResolutionAvailable (final boolean available)
      {
        final Rational oldValue = getYResolution();
        final boolean oldPropAvailable = isYResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(Y_RESOLUTION))
          {
            setObject(Y_RESOLUTION, null);
          }
        else if (!available)
          {
            removeTag(Y_RESOLUTION);
          }

        propertyChangeSupport.firePropertyChange("YResolutionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("YResolution", oldValue, getYResolution());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isYResolutionAvailable()
      {
        return containsTag(Y_RESOLUTION);
      }

    public static enum PlanarConfiguration
       {
         CHUNKY(1, "chunky"),
         PLANAR(2, "planar"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private PlanarConfiguration (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static PlanarConfiguration fromInteger (int value)
           {
             if (value == 1) return CHUNKY;
             if (value == 2) return PLANAR;

             return _UNKNOWN;
           }
       }
    public void setPlanarConfiguration (final PlanarConfiguration planarConfiguration)
      {
        final PlanarConfiguration oldValue = getPlanarConfiguration();
        final boolean oldPropAvailable = isPlanarConfigurationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PLANAR_CONFIGURATION, planarConfiguration);
        propertyChangeSupport.firePropertyChange("planarConfiguration", oldValue, planarConfiguration);
        propertyChangeSupport.firePropertyChange("planarConfigurationAvailable", oldPropAvailable, isPlanarConfigurationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public PlanarConfiguration getPlanarConfiguration()
      {
        return getObject(PLANAR_CONFIGURATION, PlanarConfiguration.class);
      }

    public void setPlanarConfigurationAvailable (final boolean available)
      {
        final PlanarConfiguration oldValue = getPlanarConfiguration();
        final boolean oldPropAvailable = isPlanarConfigurationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PLANAR_CONFIGURATION))
          {
            setObject(PLANAR_CONFIGURATION, null);
          }
        else if (!available)
          {
            removeTag(PLANAR_CONFIGURATION);
          }

        propertyChangeSupport.firePropertyChange("planarConfigurationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("planarConfiguration", oldValue, getPlanarConfiguration());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPlanarConfigurationAvailable()
      {
        return containsTag(PLANAR_CONFIGURATION);
      }

    public void setPageName (final String pageName)
      {
        final String oldValue = getPageName();
        final boolean oldPropAvailable = isPageNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PAGE_NAME, pageName);
        propertyChangeSupport.firePropertyChange("pageName", oldValue, pageName);
        propertyChangeSupport.firePropertyChange("pageNameAvailable", oldPropAvailable, isPageNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getPageName()
      {
        return getObject(PAGE_NAME, String.class);
      }

    public void setPageNameAvailable (final boolean available)
      {
        final String oldValue = getPageName();
        final boolean oldPropAvailable = isPageNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PAGE_NAME))
          {
            setObject(PAGE_NAME, null);
          }
        else if (!available)
          {
            removeTag(PAGE_NAME);
          }

        propertyChangeSupport.firePropertyChange("pageNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("pageName", oldValue, getPageName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPageNameAvailable()
      {
        return containsTag(PAGE_NAME);
      }

    public void setXPosition (final Rational XPosition)
      {
        final Rational oldValue = getXPosition();
        final boolean oldPropAvailable = isXPositionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.X_POSITION, XPosition);
        propertyChangeSupport.firePropertyChange("XPosition", oldValue, XPosition);
        propertyChangeSupport.firePropertyChange("XPositionAvailable", oldPropAvailable, isXPositionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getXPosition()
      {
        return getObject(X_POSITION, Rational.class);
      }

    public void setXPositionAvailable (final boolean available)
      {
        final Rational oldValue = getXPosition();
        final boolean oldPropAvailable = isXPositionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(X_POSITION))
          {
            setObject(X_POSITION, null);
          }
        else if (!available)
          {
            removeTag(X_POSITION);
          }

        propertyChangeSupport.firePropertyChange("XPositionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("XPosition", oldValue, getXPosition());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isXPositionAvailable()
      {
        return containsTag(X_POSITION);
      }

    public void setYPosition (final Rational YPosition)
      {
        final Rational oldValue = getYPosition();
        final boolean oldPropAvailable = isYPositionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.Y_POSITION, YPosition);
        propertyChangeSupport.firePropertyChange("YPosition", oldValue, YPosition);
        propertyChangeSupport.firePropertyChange("YPositionAvailable", oldPropAvailable, isYPositionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getYPosition()
      {
        return getObject(Y_POSITION, Rational.class);
      }

    public void setYPositionAvailable (final boolean available)
      {
        final Rational oldValue = getYPosition();
        final boolean oldPropAvailable = isYPositionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(Y_POSITION))
          {
            setObject(Y_POSITION, null);
          }
        else if (!available)
          {
            removeTag(Y_POSITION);
          }

        propertyChangeSupport.firePropertyChange("YPositionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("YPosition", oldValue, getYPosition());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isYPositionAvailable()
      {
        return containsTag(Y_POSITION);
      }

    public void setFreeOffsets (final int[] freeOffsets)
      {
        final int[] oldValue = getFreeOffsets();
        final boolean oldPropAvailable = isFreeOffsetsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FREE_OFFSETS, freeOffsets);
        propertyChangeSupport.firePropertyChange("freeOffsets", oldValue, freeOffsets);
        propertyChangeSupport.firePropertyChange("freeOffsetsAvailable", oldPropAvailable, isFreeOffsetsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getFreeOffsets()
      {
        return getObject(FREE_OFFSETS, int[].class);
      }

    public void setFreeOffsetsAvailable (final boolean available)
      {
        final int[] oldValue = getFreeOffsets();
        final boolean oldPropAvailable = isFreeOffsetsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FREE_OFFSETS))
          {
            setObject(FREE_OFFSETS, null);
          }
        else if (!available)
          {
            removeTag(FREE_OFFSETS);
          }

        propertyChangeSupport.firePropertyChange("freeOffsetsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("freeOffsets", oldValue, getFreeOffsets());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFreeOffsetsAvailable()
      {
        return containsTag(FREE_OFFSETS);
      }

    public void setFreeByteCounts (final int[] freeByteCounts)
      {
        final int[] oldValue = getFreeByteCounts();
        final boolean oldPropAvailable = isFreeByteCountsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FREE_BYTE_COUNTS, freeByteCounts);
        propertyChangeSupport.firePropertyChange("freeByteCounts", oldValue, freeByteCounts);
        propertyChangeSupport.firePropertyChange("freeByteCountsAvailable", oldPropAvailable, isFreeByteCountsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getFreeByteCounts()
      {
        return getObject(FREE_BYTE_COUNTS, int[].class);
      }

    public void setFreeByteCountsAvailable (final boolean available)
      {
        final int[] oldValue = getFreeByteCounts();
        final boolean oldPropAvailable = isFreeByteCountsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FREE_BYTE_COUNTS))
          {
            setObject(FREE_BYTE_COUNTS, null);
          }
        else if (!available)
          {
            removeTag(FREE_BYTE_COUNTS);
          }

        propertyChangeSupport.firePropertyChange("freeByteCountsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("freeByteCounts", oldValue, getFreeByteCounts());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFreeByteCountsAvailable()
      {
        return containsTag(FREE_BYTE_COUNTS);
      }

    public void setGrayResponseUnit (final Integer grayResponseUnit)
      {
        final Integer oldValue = getGrayResponseUnit();
        final boolean oldPropAvailable = isGrayResponseUnitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.GRAY_RESPONSE_UNIT, grayResponseUnit);
        propertyChangeSupport.firePropertyChange("grayResponseUnit", oldValue, grayResponseUnit);
        propertyChangeSupport.firePropertyChange("grayResponseUnitAvailable", oldPropAvailable, isGrayResponseUnitAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getGrayResponseUnit()
      {
        return getObject(GRAY_RESPONSE_UNIT, Integer.class);
      }

    public void setGrayResponseUnitAvailable (final boolean available)
      {
        final Integer oldValue = getGrayResponseUnit();
        final boolean oldPropAvailable = isGrayResponseUnitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(GRAY_RESPONSE_UNIT))
          {
            setObject(GRAY_RESPONSE_UNIT, null);
          }
        else if (!available)
          {
            removeTag(GRAY_RESPONSE_UNIT);
          }

        propertyChangeSupport.firePropertyChange("grayResponseUnitAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("grayResponseUnit", oldValue, getGrayResponseUnit());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isGrayResponseUnitAvailable()
      {
        return containsTag(GRAY_RESPONSE_UNIT);
      }

    public void setGrayResponseCurve (final int[] grayResponseCurve)
      {
        final int[] oldValue = getGrayResponseCurve();
        final boolean oldPropAvailable = isGrayResponseCurveAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.GRAY_RESPONSE_CURVE, grayResponseCurve);
        propertyChangeSupport.firePropertyChange("grayResponseCurve", oldValue, grayResponseCurve);
        propertyChangeSupport.firePropertyChange("grayResponseCurveAvailable", oldPropAvailable, isGrayResponseCurveAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getGrayResponseCurve()
      {
        return getObject(GRAY_RESPONSE_CURVE, int[].class);
      }

    public void setGrayResponseCurveAvailable (final boolean available)
      {
        final int[] oldValue = getGrayResponseCurve();
        final boolean oldPropAvailable = isGrayResponseCurveAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(GRAY_RESPONSE_CURVE))
          {
            setObject(GRAY_RESPONSE_CURVE, null);
          }
        else if (!available)
          {
            removeTag(GRAY_RESPONSE_CURVE);
          }

        propertyChangeSupport.firePropertyChange("grayResponseCurveAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("grayResponseCurve", oldValue, getGrayResponseCurve());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isGrayResponseCurveAvailable()
      {
        return containsTag(GRAY_RESPONSE_CURVE);
      }

    public void setGroup3Options (final Long group3Options)
      {
        final Long oldValue = getGroup3Options();
        final boolean oldPropAvailable = isGroup3OptionsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.GROUP_3_OPTIONS, group3Options);
        propertyChangeSupport.firePropertyChange("group3Options", oldValue, group3Options);
        propertyChangeSupport.firePropertyChange("group3OptionsAvailable", oldPropAvailable, isGroup3OptionsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getGroup3Options()
      {
        return getObject(GROUP_3_OPTIONS, Long.class);
      }

    public void setGroup3OptionsAvailable (final boolean available)
      {
        final Long oldValue = getGroup3Options();
        final boolean oldPropAvailable = isGroup3OptionsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(GROUP_3_OPTIONS))
          {
            setObject(GROUP_3_OPTIONS, null);
          }
        else if (!available)
          {
            removeTag(GROUP_3_OPTIONS);
          }

        propertyChangeSupport.firePropertyChange("group3OptionsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("group3Options", oldValue, getGroup3Options());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isGroup3OptionsAvailable()
      {
        return containsTag(GROUP_3_OPTIONS);
      }

    public void setGroup4Options (final Long group4Options)
      {
        final Long oldValue = getGroup4Options();
        final boolean oldPropAvailable = isGroup4OptionsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.GROUP_4_OPTIONS, group4Options);
        propertyChangeSupport.firePropertyChange("group4Options", oldValue, group4Options);
        propertyChangeSupport.firePropertyChange("group4OptionsAvailable", oldPropAvailable, isGroup4OptionsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getGroup4Options()
      {
        return getObject(GROUP_4_OPTIONS, Long.class);
      }

    public void setGroup4OptionsAvailable (final boolean available)
      {
        final Long oldValue = getGroup4Options();
        final boolean oldPropAvailable = isGroup4OptionsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(GROUP_4_OPTIONS))
          {
            setObject(GROUP_4_OPTIONS, null);
          }
        else if (!available)
          {
            removeTag(GROUP_4_OPTIONS);
          }

        propertyChangeSupport.firePropertyChange("group4OptionsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("group4Options", oldValue, getGroup4Options());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isGroup4OptionsAvailable()
      {
        return containsTag(GROUP_4_OPTIONS);
      }

    public static enum ResolutionUnit
       {
         INCHES(2, "inches"),
         CENTIMETERS(3, "centimeters"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private ResolutionUnit (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static ResolutionUnit fromInteger (int value)
           {
             if (value == 2) return INCHES;
             if (value == 3) return CENTIMETERS;

             return _UNKNOWN;
           }
       }
    public void setResolutionUnit (final ResolutionUnit resolutionUnit)
      {
        final ResolutionUnit oldValue = getResolutionUnit();
        final boolean oldPropAvailable = isResolutionUnitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.RESOLUTION_UNIT, resolutionUnit);
        propertyChangeSupport.firePropertyChange("resolutionUnit", oldValue, resolutionUnit);
        propertyChangeSupport.firePropertyChange("resolutionUnitAvailable", oldPropAvailable, isResolutionUnitAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public ResolutionUnit getResolutionUnit()
      {
        return getObject(RESOLUTION_UNIT, ResolutionUnit.class);
      }

    public void setResolutionUnitAvailable (final boolean available)
      {
        final ResolutionUnit oldValue = getResolutionUnit();
        final boolean oldPropAvailable = isResolutionUnitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(RESOLUTION_UNIT))
          {
            setObject(RESOLUTION_UNIT, null);
          }
        else if (!available)
          {
            removeTag(RESOLUTION_UNIT);
          }

        propertyChangeSupport.firePropertyChange("resolutionUnitAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("resolutionUnit", oldValue, getResolutionUnit());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isResolutionUnitAvailable()
      {
        return containsTag(RESOLUTION_UNIT);
      }

    public void setPageNumber (final int[] pageNumber)
      {
        final int[] oldValue = getPageNumber();
        final boolean oldPropAvailable = isPageNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PAGE_NUMBER, pageNumber);
        propertyChangeSupport.firePropertyChange("pageNumber", oldValue, pageNumber);
        propertyChangeSupport.firePropertyChange("pageNumberAvailable", oldPropAvailable, isPageNumberAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getPageNumber()
      {
        return getObject(PAGE_NUMBER, int[].class);
      }

    public void setPageNumberAvailable (final boolean available)
      {
        final int[] oldValue = getPageNumber();
        final boolean oldPropAvailable = isPageNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PAGE_NUMBER))
          {
            setObject(PAGE_NUMBER, null);
          }
        else if (!available)
          {
            removeTag(PAGE_NUMBER);
          }

        propertyChangeSupport.firePropertyChange("pageNumberAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("pageNumber", oldValue, getPageNumber());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPageNumberAvailable()
      {
        return containsTag(PAGE_NUMBER);
      }

    public void setColorResponseUnit (final Integer colorResponseUnit)
      {
        final Integer oldValue = getColorResponseUnit();
        final boolean oldPropAvailable = isColorResponseUnitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COLOR_RESPONSE_UNIT, colorResponseUnit);
        propertyChangeSupport.firePropertyChange("colorResponseUnit", oldValue, colorResponseUnit);
        propertyChangeSupport.firePropertyChange("colorResponseUnitAvailable", oldPropAvailable, isColorResponseUnitAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getColorResponseUnit()
      {
        return getObject(COLOR_RESPONSE_UNIT, Integer.class);
      }

    public void setColorResponseUnitAvailable (final boolean available)
      {
        final Integer oldValue = getColorResponseUnit();
        final boolean oldPropAvailable = isColorResponseUnitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COLOR_RESPONSE_UNIT))
          {
            setObject(COLOR_RESPONSE_UNIT, null);
          }
        else if (!available)
          {
            removeTag(COLOR_RESPONSE_UNIT);
          }

        propertyChangeSupport.firePropertyChange("colorResponseUnitAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("colorResponseUnit", oldValue, getColorResponseUnit());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isColorResponseUnitAvailable()
      {
        return containsTag(COLOR_RESPONSE_UNIT);
      }

    public void setTransferFunction (final int[] transferFunction)
      {
        final int[] oldValue = getTransferFunction();
        final boolean oldPropAvailable = isTransferFunctionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TRANSFER_FUNCTION, transferFunction);
        propertyChangeSupport.firePropertyChange("transferFunction", oldValue, transferFunction);
        propertyChangeSupport.firePropertyChange("transferFunctionAvailable", oldPropAvailable, isTransferFunctionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getTransferFunction()
      {
        return getObject(TRANSFER_FUNCTION, int[].class);
      }

    public void setTransferFunctionAvailable (final boolean available)
      {
        final int[] oldValue = getTransferFunction();
        final boolean oldPropAvailable = isTransferFunctionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TRANSFER_FUNCTION))
          {
            setObject(TRANSFER_FUNCTION, null);
          }
        else if (!available)
          {
            removeTag(TRANSFER_FUNCTION);
          }

        propertyChangeSupport.firePropertyChange("transferFunctionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("transferFunction", oldValue, getTransferFunction());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTransferFunctionAvailable()
      {
        return containsTag(TRANSFER_FUNCTION);
      }

    public void setSoftware (final String software)
      {
        final String oldValue = getSoftware();
        final boolean oldPropAvailable = isSoftwareAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SOFTWARE, software);
        propertyChangeSupport.firePropertyChange("software", oldValue, software);
        propertyChangeSupport.firePropertyChange("softwareAvailable", oldPropAvailable, isSoftwareAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSoftware()
      {
        return getObject(SOFTWARE, String.class);
      }

    public void setSoftwareAvailable (final boolean available)
      {
        final String oldValue = getSoftware();
        final boolean oldPropAvailable = isSoftwareAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SOFTWARE))
          {
            setObject(SOFTWARE, null);
          }
        else if (!available)
          {
            removeTag(SOFTWARE);
          }

        propertyChangeSupport.firePropertyChange("softwareAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("software", oldValue, getSoftware());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSoftwareAvailable()
      {
        return containsTag(SOFTWARE);
      }

    public void setDateTime (final String dateTime)
      {
        final String oldValue = getDateTime();
        final boolean oldPropAvailable = isDateTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DATETIME, dateTime);
        propertyChangeSupport.firePropertyChange("dateTime", oldValue, dateTime);
        propertyChangeSupport.firePropertyChange("dateTimeAvailable", oldPropAvailable, isDateTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getDateTime()
      {
        return getObject(DATETIME, String.class);
      }

    public void setDateTimeAvailable (final boolean available)
      {
        final String oldValue = getDateTime();
        final boolean oldPropAvailable = isDateTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DATETIME))
          {
            setObject(DATETIME, null);
          }
        else if (!available)
          {
            removeTag(DATETIME);
          }

        propertyChangeSupport.firePropertyChange("dateTimeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("dateTime", oldValue, getDateTime());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDateTimeAvailable()
      {
        return containsTag(DATETIME);
      }

    public void setArtist (final String artist)
      {
        final String oldValue = getArtist();
        final boolean oldPropAvailable = isArtistAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ARTIST, artist);
        propertyChangeSupport.firePropertyChange("artist", oldValue, artist);
        propertyChangeSupport.firePropertyChange("artistAvailable", oldPropAvailable, isArtistAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getArtist()
      {
        return getObject(ARTIST, String.class);
      }

    public void setArtistAvailable (final boolean available)
      {
        final String oldValue = getArtist();
        final boolean oldPropAvailable = isArtistAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ARTIST))
          {
            setObject(ARTIST, null);
          }
        else if (!available)
          {
            removeTag(ARTIST);
          }

        propertyChangeSupport.firePropertyChange("artistAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("artist", oldValue, getArtist());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isArtistAvailable()
      {
        return containsTag(ARTIST);
      }

    public void setHostComputer (final String hostComputer)
      {
        final String oldValue = getHostComputer();
        final boolean oldPropAvailable = isHostComputerAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.HOST_COMPUTER, hostComputer);
        propertyChangeSupport.firePropertyChange("hostComputer", oldValue, hostComputer);
        propertyChangeSupport.firePropertyChange("hostComputerAvailable", oldPropAvailable, isHostComputerAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getHostComputer()
      {
        return getObject(HOST_COMPUTER, String.class);
      }

    public void setHostComputerAvailable (final boolean available)
      {
        final String oldValue = getHostComputer();
        final boolean oldPropAvailable = isHostComputerAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(HOST_COMPUTER))
          {
            setObject(HOST_COMPUTER, null);
          }
        else if (!available)
          {
            removeTag(HOST_COMPUTER);
          }

        propertyChangeSupport.firePropertyChange("hostComputerAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("hostComputer", oldValue, getHostComputer());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isHostComputerAvailable()
      {
        return containsTag(HOST_COMPUTER);
      }

    public void setPredictor (final Integer predictor)
      {
        final Integer oldValue = getPredictor();
        final boolean oldPropAvailable = isPredictorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PREDICTOR, predictor);
        propertyChangeSupport.firePropertyChange("predictor", oldValue, predictor);
        propertyChangeSupport.firePropertyChange("predictorAvailable", oldPropAvailable, isPredictorAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getPredictor()
      {
        return getObject(PREDICTOR, Integer.class);
      }

    public void setPredictorAvailable (final boolean available)
      {
        final Integer oldValue = getPredictor();
        final boolean oldPropAvailable = isPredictorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PREDICTOR))
          {
            setObject(PREDICTOR, null);
          }
        else if (!available)
          {
            removeTag(PREDICTOR);
          }

        propertyChangeSupport.firePropertyChange("predictorAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("predictor", oldValue, getPredictor());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPredictorAvailable()
      {
        return containsTag(PREDICTOR);
      }

    public void setWhitePoint (final Rational[] whitePoint)
      {
        final Rational[] oldValue = getWhitePoint();
        final boolean oldPropAvailable = isWhitePointAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.WHITE_POINT, whitePoint);
        propertyChangeSupport.firePropertyChange("whitePoint", oldValue, whitePoint);
        propertyChangeSupport.firePropertyChange("whitePointAvailable", oldPropAvailable, isWhitePointAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getWhitePoint()
      {
        return getObject(WHITE_POINT, Rational[].class);
      }

    public void setWhitePointAvailable (final boolean available)
      {
        final Rational[] oldValue = getWhitePoint();
        final boolean oldPropAvailable = isWhitePointAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(WHITE_POINT))
          {
            setObject(WHITE_POINT, null);
          }
        else if (!available)
          {
            removeTag(WHITE_POINT);
          }

        propertyChangeSupport.firePropertyChange("whitePointAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("whitePoint", oldValue, getWhitePoint());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isWhitePointAvailable()
      {
        return containsTag(WHITE_POINT);
      }

    public void setPrimaryChromaticities (final Rational[] primaryChromaticities)
      {
        final Rational[] oldValue = getPrimaryChromaticities();
        final boolean oldPropAvailable = isPrimaryChromaticitiesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PRIMARY_CHROMATICITIES, primaryChromaticities);
        propertyChangeSupport.firePropertyChange("primaryChromaticities", oldValue, primaryChromaticities);
        propertyChangeSupport.firePropertyChange("primaryChromaticitiesAvailable", oldPropAvailable, isPrimaryChromaticitiesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getPrimaryChromaticities()
      {
        return getObject(PRIMARY_CHROMATICITIES, Rational[].class);
      }

    public void setPrimaryChromaticitiesAvailable (final boolean available)
      {
        final Rational[] oldValue = getPrimaryChromaticities();
        final boolean oldPropAvailable = isPrimaryChromaticitiesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PRIMARY_CHROMATICITIES))
          {
            setObject(PRIMARY_CHROMATICITIES, null);
          }
        else if (!available)
          {
            removeTag(PRIMARY_CHROMATICITIES);
          }

        propertyChangeSupport.firePropertyChange("primaryChromaticitiesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("primaryChromaticities", oldValue, getPrimaryChromaticities());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPrimaryChromaticitiesAvailable()
      {
        return containsTag(PRIMARY_CHROMATICITIES);
      }

    public void setTileWidth (final Integer tileWidth)
      {
        final Integer oldValue = getTileWidth();
        final boolean oldPropAvailable = isTileWidthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TILE_WIDTH, tileWidth);
        propertyChangeSupport.firePropertyChange("tileWidth", oldValue, tileWidth);
        propertyChangeSupport.firePropertyChange("tileWidthAvailable", oldPropAvailable, isTileWidthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getTileWidth()
      {
        return getObject(TILE_WIDTH, Integer.class);
      }

    public void setTileWidthAvailable (final boolean available)
      {
        final Integer oldValue = getTileWidth();
        final boolean oldPropAvailable = isTileWidthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TILE_WIDTH))
          {
            setObject(TILE_WIDTH, null);
          }
        else if (!available)
          {
            removeTag(TILE_WIDTH);
          }

        propertyChangeSupport.firePropertyChange("tileWidthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("tileWidth", oldValue, getTileWidth());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTileWidthAvailable()
      {
        return containsTag(TILE_WIDTH);
      }

    public void setTileLength (final Integer tileLength)
      {
        final Integer oldValue = getTileLength();
        final boolean oldPropAvailable = isTileLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TILE_LENGTH, tileLength);
        propertyChangeSupport.firePropertyChange("tileLength", oldValue, tileLength);
        propertyChangeSupport.firePropertyChange("tileLengthAvailable", oldPropAvailable, isTileLengthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getTileLength()
      {
        return getObject(TILE_LENGTH, Integer.class);
      }

    public void setTileLengthAvailable (final boolean available)
      {
        final Integer oldValue = getTileLength();
        final boolean oldPropAvailable = isTileLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TILE_LENGTH))
          {
            setObject(TILE_LENGTH, null);
          }
        else if (!available)
          {
            removeTag(TILE_LENGTH);
          }

        propertyChangeSupport.firePropertyChange("tileLengthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("tileLength", oldValue, getTileLength());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTileLengthAvailable()
      {
        return containsTag(TILE_LENGTH);
      }

    public void setTileOffsets (final int[] tileOffsets)
      {
        final int[] oldValue = getTileOffsets();
        final boolean oldPropAvailable = isTileOffsetsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TILE_OFFSETS, tileOffsets);
        propertyChangeSupport.firePropertyChange("tileOffsets", oldValue, tileOffsets);
        propertyChangeSupport.firePropertyChange("tileOffsetsAvailable", oldPropAvailable, isTileOffsetsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getTileOffsets()
      {
        return getObject(TILE_OFFSETS, int[].class);
      }

    public void setTileOffsetsAvailable (final boolean available)
      {
        final int[] oldValue = getTileOffsets();
        final boolean oldPropAvailable = isTileOffsetsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TILE_OFFSETS))
          {
            setObject(TILE_OFFSETS, null);
          }
        else if (!available)
          {
            removeTag(TILE_OFFSETS);
          }

        propertyChangeSupport.firePropertyChange("tileOffsetsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("tileOffsets", oldValue, getTileOffsets());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTileOffsetsAvailable()
      {
        return containsTag(TILE_OFFSETS);
      }

    public void setTileByteCounts (final int[] tileByteCounts)
      {
        final int[] oldValue = getTileByteCounts();
        final boolean oldPropAvailable = isTileByteCountsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TILE_BYTE_COUNTS, tileByteCounts);
        propertyChangeSupport.firePropertyChange("tileByteCounts", oldValue, tileByteCounts);
        propertyChangeSupport.firePropertyChange("tileByteCountsAvailable", oldPropAvailable, isTileByteCountsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getTileByteCounts()
      {
        return getObject(TILE_BYTE_COUNTS, int[].class);
      }

    public void setTileByteCountsAvailable (final boolean available)
      {
        final int[] oldValue = getTileByteCounts();
        final boolean oldPropAvailable = isTileByteCountsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TILE_BYTE_COUNTS))
          {
            setObject(TILE_BYTE_COUNTS, null);
          }
        else if (!available)
          {
            removeTag(TILE_BYTE_COUNTS);
          }

        propertyChangeSupport.firePropertyChange("tileByteCountsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("tileByteCounts", oldValue, getTileByteCounts());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTileByteCountsAvailable()
      {
        return containsTag(TILE_BYTE_COUNTS);
      }

    public void setBadFaxLines (final Long badFaxLines)
      {
        final Long oldValue = getBadFaxLines();
        final boolean oldPropAvailable = isBadFaxLinesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BAD_FAX_LINES, badFaxLines);
        propertyChangeSupport.firePropertyChange("badFaxLines", oldValue, badFaxLines);
        propertyChangeSupport.firePropertyChange("badFaxLinesAvailable", oldPropAvailable, isBadFaxLinesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getBadFaxLines()
      {
        return getObject(BAD_FAX_LINES, Long.class);
      }

    public void setBadFaxLinesAvailable (final boolean available)
      {
        final Long oldValue = getBadFaxLines();
        final boolean oldPropAvailable = isBadFaxLinesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BAD_FAX_LINES))
          {
            setObject(BAD_FAX_LINES, null);
          }
        else if (!available)
          {
            removeTag(BAD_FAX_LINES);
          }

        propertyChangeSupport.firePropertyChange("badFaxLinesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("badFaxLines", oldValue, getBadFaxLines());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBadFaxLinesAvailable()
      {
        return containsTag(BAD_FAX_LINES);
      }

    public void setCleanFaxData (final Integer cleanFaxData)
      {
        final Integer oldValue = getCleanFaxData();
        final boolean oldPropAvailable = isCleanFaxDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CLEAN_FAX_DATA, cleanFaxData);
        propertyChangeSupport.firePropertyChange("cleanFaxData", oldValue, cleanFaxData);
        propertyChangeSupport.firePropertyChange("cleanFaxDataAvailable", oldPropAvailable, isCleanFaxDataAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getCleanFaxData()
      {
        return getObject(CLEAN_FAX_DATA, Integer.class);
      }

    public void setCleanFaxDataAvailable (final boolean available)
      {
        final Integer oldValue = getCleanFaxData();
        final boolean oldPropAvailable = isCleanFaxDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CLEAN_FAX_DATA))
          {
            setObject(CLEAN_FAX_DATA, null);
          }
        else if (!available)
          {
            removeTag(CLEAN_FAX_DATA);
          }

        propertyChangeSupport.firePropertyChange("cleanFaxDataAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("cleanFaxData", oldValue, getCleanFaxData());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCleanFaxDataAvailable()
      {
        return containsTag(CLEAN_FAX_DATA);
      }

    public void setConsecutiveBadFaxLines (final Long consecutiveBadFaxLines)
      {
        final Long oldValue = getConsecutiveBadFaxLines();
        final boolean oldPropAvailable = isConsecutiveBadFaxLinesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CONSECUTIVE_BAD_FAX_LINES, consecutiveBadFaxLines);
        propertyChangeSupport.firePropertyChange("consecutiveBadFaxLines", oldValue, consecutiveBadFaxLines);
        propertyChangeSupport.firePropertyChange("consecutiveBadFaxLinesAvailable", oldPropAvailable, isConsecutiveBadFaxLinesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getConsecutiveBadFaxLines()
      {
        return getObject(CONSECUTIVE_BAD_FAX_LINES, Long.class);
      }

    public void setConsecutiveBadFaxLinesAvailable (final boolean available)
      {
        final Long oldValue = getConsecutiveBadFaxLines();
        final boolean oldPropAvailable = isConsecutiveBadFaxLinesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CONSECUTIVE_BAD_FAX_LINES))
          {
            setObject(CONSECUTIVE_BAD_FAX_LINES, null);
          }
        else if (!available)
          {
            removeTag(CONSECUTIVE_BAD_FAX_LINES);
          }

        propertyChangeSupport.firePropertyChange("consecutiveBadFaxLinesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("consecutiveBadFaxLines", oldValue, getConsecutiveBadFaxLines());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isConsecutiveBadFaxLinesAvailable()
      {
        return containsTag(CONSECUTIVE_BAD_FAX_LINES);
      }

    public void setSubIFDs (final int[] subIFDs)
      {
        final int[] oldValue = getSubIFDs();
        final boolean oldPropAvailable = isSubIFDsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUB_IFDS, subIFDs);
        propertyChangeSupport.firePropertyChange("subIFDs", oldValue, subIFDs);
        propertyChangeSupport.firePropertyChange("subIFDsAvailable", oldPropAvailable, isSubIFDsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getSubIFDs()
      {
        return getObject(SUB_IFDS, int[].class);
      }

    public void setSubIFDsAvailable (final boolean available)
      {
        final int[] oldValue = getSubIFDs();
        final boolean oldPropAvailable = isSubIFDsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUB_IFDS))
          {
            setObject(SUB_IFDS, null);
          }
        else if (!available)
          {
            removeTag(SUB_IFDS);
          }

        propertyChangeSupport.firePropertyChange("subIFDsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subIFDs", oldValue, getSubIFDs());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubIFDsAvailable()
      {
        return containsTag(SUB_IFDS);
      }

    public void setInkSet (final Integer inkSet)
      {
        final Integer oldValue = getInkSet();
        final boolean oldPropAvailable = isInkSetAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.INK_SET, inkSet);
        propertyChangeSupport.firePropertyChange("inkSet", oldValue, inkSet);
        propertyChangeSupport.firePropertyChange("inkSetAvailable", oldPropAvailable, isInkSetAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getInkSet()
      {
        return getObject(INK_SET, Integer.class);
      }

    public void setInkSetAvailable (final boolean available)
      {
        final Integer oldValue = getInkSet();
        final boolean oldPropAvailable = isInkSetAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(INK_SET))
          {
            setObject(INK_SET, null);
          }
        else if (!available)
          {
            removeTag(INK_SET);
          }

        propertyChangeSupport.firePropertyChange("inkSetAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("inkSet", oldValue, getInkSet());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isInkSetAvailable()
      {
        return containsTag(INK_SET);
      }

    public void setInkNames (final String inkNames)
      {
        final String oldValue = getInkNames();
        final boolean oldPropAvailable = isInkNamesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.INK_NAMES, inkNames);
        propertyChangeSupport.firePropertyChange("inkNames", oldValue, inkNames);
        propertyChangeSupport.firePropertyChange("inkNamesAvailable", oldPropAvailable, isInkNamesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getInkNames()
      {
        return getObject(INK_NAMES, String.class);
      }

    public void setInkNamesAvailable (final boolean available)
      {
        final String oldValue = getInkNames();
        final boolean oldPropAvailable = isInkNamesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(INK_NAMES))
          {
            setObject(INK_NAMES, null);
          }
        else if (!available)
          {
            removeTag(INK_NAMES);
          }

        propertyChangeSupport.firePropertyChange("inkNamesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("inkNames", oldValue, getInkNames());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isInkNamesAvailable()
      {
        return containsTag(INK_NAMES);
      }

    public void setNumberOfInks (final Integer numberOfInks)
      {
        final Integer oldValue = getNumberOfInks();
        final boolean oldPropAvailable = isNumberOfInksAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.NUMBER_OF_INKS, numberOfInks);
        propertyChangeSupport.firePropertyChange("numberOfInks", oldValue, numberOfInks);
        propertyChangeSupport.firePropertyChange("numberOfInksAvailable", oldPropAvailable, isNumberOfInksAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getNumberOfInks()
      {
        return getObject(NUMBER_OF_INKS, Integer.class);
      }

    public void setNumberOfInksAvailable (final boolean available)
      {
        final Integer oldValue = getNumberOfInks();
        final boolean oldPropAvailable = isNumberOfInksAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(NUMBER_OF_INKS))
          {
            setObject(NUMBER_OF_INKS, null);
          }
        else if (!available)
          {
            removeTag(NUMBER_OF_INKS);
          }

        propertyChangeSupport.firePropertyChange("numberOfInksAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("numberOfInks", oldValue, getNumberOfInks());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isNumberOfInksAvailable()
      {
        return containsTag(NUMBER_OF_INKS);
      }

    public void setDotRange (final byte[] dotRange)
      {
        final byte[] oldValue = getDotRange();
        final boolean oldPropAvailable = isDotRangeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DOT_RANGE, dotRange);
        propertyChangeSupport.firePropertyChange("dotRange", oldValue, dotRange);
        propertyChangeSupport.firePropertyChange("dotRangeAvailable", oldPropAvailable, isDotRangeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getDotRange()
      {
        return getObject(DOT_RANGE, byte[].class);
      }

    public void setDotRangeAvailable (final boolean available)
      {
        final byte[] oldValue = getDotRange();
        final boolean oldPropAvailable = isDotRangeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DOT_RANGE))
          {
            setObject(DOT_RANGE, null);
          }
        else if (!available)
          {
            removeTag(DOT_RANGE);
          }

        propertyChangeSupport.firePropertyChange("dotRangeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("dotRange", oldValue, getDotRange());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDotRangeAvailable()
      {
        return containsTag(DOT_RANGE);
      }

    public void setTargetPrinter (final String targetPrinter)
      {
        final String oldValue = getTargetPrinter();
        final boolean oldPropAvailable = isTargetPrinterAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TARGET_PRINTER, targetPrinter);
        propertyChangeSupport.firePropertyChange("targetPrinter", oldValue, targetPrinter);
        propertyChangeSupport.firePropertyChange("targetPrinterAvailable", oldPropAvailable, isTargetPrinterAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getTargetPrinter()
      {
        return getObject(TARGET_PRINTER, String.class);
      }

    public void setTargetPrinterAvailable (final boolean available)
      {
        final String oldValue = getTargetPrinter();
        final boolean oldPropAvailable = isTargetPrinterAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TARGET_PRINTER))
          {
            setObject(TARGET_PRINTER, null);
          }
        else if (!available)
          {
            removeTag(TARGET_PRINTER);
          }

        propertyChangeSupport.firePropertyChange("targetPrinterAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("targetPrinter", oldValue, getTargetPrinter());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTargetPrinterAvailable()
      {
        return containsTag(TARGET_PRINTER);
      }

    public void setExtraSamples (final byte[] extraSamples)
      {
        final byte[] oldValue = getExtraSamples();
        final boolean oldPropAvailable = isExtraSamplesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXTRA_SAMPLES, extraSamples);
        propertyChangeSupport.firePropertyChange("extraSamples", oldValue, extraSamples);
        propertyChangeSupport.firePropertyChange("extraSamplesAvailable", oldPropAvailable, isExtraSamplesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getExtraSamples()
      {
        return getObject(EXTRA_SAMPLES, byte[].class);
      }

    public void setExtraSamplesAvailable (final boolean available)
      {
        final byte[] oldValue = getExtraSamples();
        final boolean oldPropAvailable = isExtraSamplesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXTRA_SAMPLES))
          {
            setObject(EXTRA_SAMPLES, null);
          }
        else if (!available)
          {
            removeTag(EXTRA_SAMPLES);
          }

        propertyChangeSupport.firePropertyChange("extraSamplesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("extraSamples", oldValue, getExtraSamples());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExtraSamplesAvailable()
      {
        return containsTag(EXTRA_SAMPLES);
      }

    public void setSampleFormat (final int[] sampleFormat)
      {
        final int[] oldValue = getSampleFormat();
        final boolean oldPropAvailable = isSampleFormatAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SAMPLE_FORMAT, sampleFormat);
        propertyChangeSupport.firePropertyChange("sampleFormat", oldValue, sampleFormat);
        propertyChangeSupport.firePropertyChange("sampleFormatAvailable", oldPropAvailable, isSampleFormatAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getSampleFormat()
      {
        return getObject(SAMPLE_FORMAT, int[].class);
      }

    public void setSampleFormatAvailable (final boolean available)
      {
        final int[] oldValue = getSampleFormat();
        final boolean oldPropAvailable = isSampleFormatAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SAMPLE_FORMAT))
          {
            setObject(SAMPLE_FORMAT, null);
          }
        else if (!available)
          {
            removeTag(SAMPLE_FORMAT);
          }

        propertyChangeSupport.firePropertyChange("sampleFormatAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("sampleFormat", oldValue, getSampleFormat());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSampleFormatAvailable()
      {
        return containsTag(SAMPLE_FORMAT);
      }

    public void setTransferRange (final int[] transferRange)
      {
        final int[] oldValue = getTransferRange();
        final boolean oldPropAvailable = isTransferRangeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TRANSFER_RANGE, transferRange);
        propertyChangeSupport.firePropertyChange("transferRange", oldValue, transferRange);
        propertyChangeSupport.firePropertyChange("transferRangeAvailable", oldPropAvailable, isTransferRangeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getTransferRange()
      {
        return getObject(TRANSFER_RANGE, int[].class);
      }

    public void setTransferRangeAvailable (final boolean available)
      {
        final int[] oldValue = getTransferRange();
        final boolean oldPropAvailable = isTransferRangeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TRANSFER_RANGE))
          {
            setObject(TRANSFER_RANGE, null);
          }
        else if (!available)
          {
            removeTag(TRANSFER_RANGE);
          }

        propertyChangeSupport.firePropertyChange("transferRangeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("transferRange", oldValue, getTransferRange());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTransferRangeAvailable()
      {
        return containsTag(TRANSFER_RANGE);
      }

    public void setClipPath (final byte[] clipPath)
      {
        final byte[] oldValue = getClipPath();
        final boolean oldPropAvailable = isClipPathAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CLIP_PATH, clipPath);
        propertyChangeSupport.firePropertyChange("clipPath", oldValue, clipPath);
        propertyChangeSupport.firePropertyChange("clipPathAvailable", oldPropAvailable, isClipPathAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getClipPath()
      {
        return getObject(CLIP_PATH, byte[].class);
      }

    public void setClipPathAvailable (final boolean available)
      {
        final byte[] oldValue = getClipPath();
        final boolean oldPropAvailable = isClipPathAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CLIP_PATH))
          {
            setObject(CLIP_PATH, null);
          }
        else if (!available)
          {
            removeTag(CLIP_PATH);
          }

        propertyChangeSupport.firePropertyChange("clipPathAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("clipPath", oldValue, getClipPath());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isClipPathAvailable()
      {
        return containsTag(CLIP_PATH);
      }

    public void setXClipPathUnits (final Long XClipPathUnits)
      {
        final Long oldValue = getXClipPathUnits();
        final boolean oldPropAvailable = isXClipPathUnitsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.X_CLIP_PATH_UNITS, XClipPathUnits);
        propertyChangeSupport.firePropertyChange("XClipPathUnits", oldValue, XClipPathUnits);
        propertyChangeSupport.firePropertyChange("XClipPathUnitsAvailable", oldPropAvailable, isXClipPathUnitsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getXClipPathUnits()
      {
        return getObject(X_CLIP_PATH_UNITS, Long.class);
      }

    public void setXClipPathUnitsAvailable (final boolean available)
      {
        final Long oldValue = getXClipPathUnits();
        final boolean oldPropAvailable = isXClipPathUnitsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(X_CLIP_PATH_UNITS))
          {
            setObject(X_CLIP_PATH_UNITS, null);
          }
        else if (!available)
          {
            removeTag(X_CLIP_PATH_UNITS);
          }

        propertyChangeSupport.firePropertyChange("XClipPathUnitsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("XClipPathUnits", oldValue, getXClipPathUnits());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isXClipPathUnitsAvailable()
      {
        return containsTag(X_CLIP_PATH_UNITS);
      }

    public void setYClipPathUnits (final Long YClipPathUnits)
      {
        final Long oldValue = getYClipPathUnits();
        final boolean oldPropAvailable = isYClipPathUnitsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.Y_CLIP_PATH_UNITS, YClipPathUnits);
        propertyChangeSupport.firePropertyChange("YClipPathUnits", oldValue, YClipPathUnits);
        propertyChangeSupport.firePropertyChange("YClipPathUnitsAvailable", oldPropAvailable, isYClipPathUnitsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getYClipPathUnits()
      {
        return getObject(Y_CLIP_PATH_UNITS, Long.class);
      }

    public void setYClipPathUnitsAvailable (final boolean available)
      {
        final Long oldValue = getYClipPathUnits();
        final boolean oldPropAvailable = isYClipPathUnitsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(Y_CLIP_PATH_UNITS))
          {
            setObject(Y_CLIP_PATH_UNITS, null);
          }
        else if (!available)
          {
            removeTag(Y_CLIP_PATH_UNITS);
          }

        propertyChangeSupport.firePropertyChange("YClipPathUnitsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("YClipPathUnits", oldValue, getYClipPathUnits());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isYClipPathUnitsAvailable()
      {
        return containsTag(Y_CLIP_PATH_UNITS);
      }

    public void setIndexed (final Integer indexed)
      {
        final Integer oldValue = getIndexed();
        final boolean oldPropAvailable = isIndexedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.INDEXED, indexed);
        propertyChangeSupport.firePropertyChange("indexed", oldValue, indexed);
        propertyChangeSupport.firePropertyChange("indexedAvailable", oldPropAvailable, isIndexedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getIndexed()
      {
        return getObject(INDEXED, Integer.class);
      }

    public void setIndexedAvailable (final boolean available)
      {
        final Integer oldValue = getIndexed();
        final boolean oldPropAvailable = isIndexedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(INDEXED))
          {
            setObject(INDEXED, null);
          }
        else if (!available)
          {
            removeTag(INDEXED);
          }

        propertyChangeSupport.firePropertyChange("indexedAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("indexed", oldValue, getIndexed());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isIndexedAvailable()
      {
        return containsTag(INDEXED);
      }

    public void setJPEGTables (final byte[] JPEGTables)
      {
        final byte[] oldValue = getJPEGTables();
        final boolean oldPropAvailable = isJPEGTablesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_TABLES, JPEGTables);
        propertyChangeSupport.firePropertyChange("JPEGTables", oldValue, JPEGTables);
        propertyChangeSupport.firePropertyChange("JPEGTablesAvailable", oldPropAvailable, isJPEGTablesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getJPEGTables()
      {
        return getObject(JPEG_TABLES, byte[].class);
      }

    public void setJPEGTablesAvailable (final boolean available)
      {
        final byte[] oldValue = getJPEGTables();
        final boolean oldPropAvailable = isJPEGTablesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_TABLES))
          {
            setObject(JPEG_TABLES, null);
          }
        else if (!available)
          {
            removeTag(JPEG_TABLES);
          }

        propertyChangeSupport.firePropertyChange("JPEGTablesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGTables", oldValue, getJPEGTables());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGTablesAvailable()
      {
        return containsTag(JPEG_TABLES);
      }

    public void setOPIProxy (final Integer OPIProxy)
      {
        final Integer oldValue = getOPIProxy();
        final boolean oldPropAvailable = isOPIProxyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.OPI_PROXY, OPIProxy);
        propertyChangeSupport.firePropertyChange("OPIProxy", oldValue, OPIProxy);
        propertyChangeSupport.firePropertyChange("OPIProxyAvailable", oldPropAvailable, isOPIProxyAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getOPIProxy()
      {
        return getObject(OPI_PROXY, Integer.class);
      }

    public void setOPIProxyAvailable (final boolean available)
      {
        final Integer oldValue = getOPIProxy();
        final boolean oldPropAvailable = isOPIProxyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OPI_PROXY))
          {
            setObject(OPI_PROXY, null);
          }
        else if (!available)
          {
            removeTag(OPI_PROXY);
          }

        propertyChangeSupport.firePropertyChange("OPIProxyAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("OPIProxy", oldValue, getOPIProxy());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isOPIProxyAvailable()
      {
        return containsTag(OPI_PROXY);
      }

    public void setJPEGProc (final Integer JPEGProc)
      {
        final Integer oldValue = getJPEGProc();
        final boolean oldPropAvailable = isJPEGProcAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_PROC, JPEGProc);
        propertyChangeSupport.firePropertyChange("JPEGProc", oldValue, JPEGProc);
        propertyChangeSupport.firePropertyChange("JPEGProcAvailable", oldPropAvailable, isJPEGProcAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getJPEGProc()
      {
        return getObject(JPEG_PROC, Integer.class);
      }

    public void setJPEGProcAvailable (final boolean available)
      {
        final Integer oldValue = getJPEGProc();
        final boolean oldPropAvailable = isJPEGProcAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_PROC))
          {
            setObject(JPEG_PROC, null);
          }
        else if (!available)
          {
            removeTag(JPEG_PROC);
          }

        propertyChangeSupport.firePropertyChange("JPEGProcAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGProc", oldValue, getJPEGProc());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGProcAvailable()
      {
        return containsTag(JPEG_PROC);
      }

    public void setJPEGInterchangeFormat (final Integer JPEGInterchangeFormat)
      {
        final Integer oldValue = getJPEGInterchangeFormat();
        final boolean oldPropAvailable = isJPEGInterchangeFormatAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_INTERCHANGE_FORMAT, JPEGInterchangeFormat);
        propertyChangeSupport.firePropertyChange("JPEGInterchangeFormat", oldValue, JPEGInterchangeFormat);
        propertyChangeSupport.firePropertyChange("JPEGInterchangeFormatAvailable", oldPropAvailable, isJPEGInterchangeFormatAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getJPEGInterchangeFormat()
      {
        return getObject(JPEG_INTERCHANGE_FORMAT, Integer.class);
      }

    public void setJPEGInterchangeFormatAvailable (final boolean available)
      {
        final Integer oldValue = getJPEGInterchangeFormat();
        final boolean oldPropAvailable = isJPEGInterchangeFormatAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_INTERCHANGE_FORMAT))
          {
            setObject(JPEG_INTERCHANGE_FORMAT, null);
          }
        else if (!available)
          {
            removeTag(JPEG_INTERCHANGE_FORMAT);
          }

        propertyChangeSupport.firePropertyChange("JPEGInterchangeFormatAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGInterchangeFormat", oldValue, getJPEGInterchangeFormat());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGInterchangeFormatAvailable()
      {
        return containsTag(JPEG_INTERCHANGE_FORMAT);
      }

    public void setJPEGInterchangeFormatLength (final Integer JPEGInterchangeFormatLength)
      {
        final Integer oldValue = getJPEGInterchangeFormatLength();
        final boolean oldPropAvailable = isJPEGInterchangeFormatLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_INTERCHANGE_FORMAT_LENGTH, JPEGInterchangeFormatLength);
        propertyChangeSupport.firePropertyChange("JPEGInterchangeFormatLength", oldValue, JPEGInterchangeFormatLength);
        propertyChangeSupport.firePropertyChange("JPEGInterchangeFormatLengthAvailable", oldPropAvailable, isJPEGInterchangeFormatLengthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getJPEGInterchangeFormatLength()
      {
        return getObject(JPEG_INTERCHANGE_FORMAT_LENGTH, Integer.class);
      }

    public void setJPEGInterchangeFormatLengthAvailable (final boolean available)
      {
        final Integer oldValue = getJPEGInterchangeFormatLength();
        final boolean oldPropAvailable = isJPEGInterchangeFormatLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_INTERCHANGE_FORMAT_LENGTH))
          {
            setObject(JPEG_INTERCHANGE_FORMAT_LENGTH, null);
          }
        else if (!available)
          {
            removeTag(JPEG_INTERCHANGE_FORMAT_LENGTH);
          }

        propertyChangeSupport.firePropertyChange("JPEGInterchangeFormatLengthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGInterchangeFormatLength", oldValue, getJPEGInterchangeFormatLength());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGInterchangeFormatLengthAvailable()
      {
        return containsTag(JPEG_INTERCHANGE_FORMAT_LENGTH);
      }

    public void setJPEGRestartInterval (final Integer JPEGRestartInterval)
      {
        final Integer oldValue = getJPEGRestartInterval();
        final boolean oldPropAvailable = isJPEGRestartIntervalAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_RESTART_INTERVAL, JPEGRestartInterval);
        propertyChangeSupport.firePropertyChange("JPEGRestartInterval", oldValue, JPEGRestartInterval);
        propertyChangeSupport.firePropertyChange("JPEGRestartIntervalAvailable", oldPropAvailable, isJPEGRestartIntervalAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getJPEGRestartInterval()
      {
        return getObject(JPEG_RESTART_INTERVAL, Integer.class);
      }

    public void setJPEGRestartIntervalAvailable (final boolean available)
      {
        final Integer oldValue = getJPEGRestartInterval();
        final boolean oldPropAvailable = isJPEGRestartIntervalAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_RESTART_INTERVAL))
          {
            setObject(JPEG_RESTART_INTERVAL, null);
          }
        else if (!available)
          {
            removeTag(JPEG_RESTART_INTERVAL);
          }

        propertyChangeSupport.firePropertyChange("JPEGRestartIntervalAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGRestartInterval", oldValue, getJPEGRestartInterval());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGRestartIntervalAvailable()
      {
        return containsTag(JPEG_RESTART_INTERVAL);
      }

    public void setJPEGLosslessPredictors (final int[] JPEGLosslessPredictors)
      {
        final int[] oldValue = getJPEGLosslessPredictors();
        final boolean oldPropAvailable = isJPEGLosslessPredictorsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_LOSSLESS_PREDICTORS, JPEGLosslessPredictors);
        propertyChangeSupport.firePropertyChange("JPEGLosslessPredictors", oldValue, JPEGLosslessPredictors);
        propertyChangeSupport.firePropertyChange("JPEGLosslessPredictorsAvailable", oldPropAvailable, isJPEGLosslessPredictorsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getJPEGLosslessPredictors()
      {
        return getObject(JPEG_LOSSLESS_PREDICTORS, int[].class);
      }

    public void setJPEGLosslessPredictorsAvailable (final boolean available)
      {
        final int[] oldValue = getJPEGLosslessPredictors();
        final boolean oldPropAvailable = isJPEGLosslessPredictorsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_LOSSLESS_PREDICTORS))
          {
            setObject(JPEG_LOSSLESS_PREDICTORS, null);
          }
        else if (!available)
          {
            removeTag(JPEG_LOSSLESS_PREDICTORS);
          }

        propertyChangeSupport.firePropertyChange("JPEGLosslessPredictorsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGLosslessPredictors", oldValue, getJPEGLosslessPredictors());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGLosslessPredictorsAvailable()
      {
        return containsTag(JPEG_LOSSLESS_PREDICTORS);
      }

    public void setJPEGPointTransforms (final int[] JPEGPointTransforms)
      {
        final int[] oldValue = getJPEGPointTransforms();
        final boolean oldPropAvailable = isJPEGPointTransformsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_POINT_TRANSFORMS, JPEGPointTransforms);
        propertyChangeSupport.firePropertyChange("JPEGPointTransforms", oldValue, JPEGPointTransforms);
        propertyChangeSupport.firePropertyChange("JPEGPointTransformsAvailable", oldPropAvailable, isJPEGPointTransformsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getJPEGPointTransforms()
      {
        return getObject(JPEG_POINT_TRANSFORMS, int[].class);
      }

    public void setJPEGPointTransformsAvailable (final boolean available)
      {
        final int[] oldValue = getJPEGPointTransforms();
        final boolean oldPropAvailable = isJPEGPointTransformsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_POINT_TRANSFORMS))
          {
            setObject(JPEG_POINT_TRANSFORMS, null);
          }
        else if (!available)
          {
            removeTag(JPEG_POINT_TRANSFORMS);
          }

        propertyChangeSupport.firePropertyChange("JPEGPointTransformsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGPointTransforms", oldValue, getJPEGPointTransforms());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGPointTransformsAvailable()
      {
        return containsTag(JPEG_POINT_TRANSFORMS);
      }

    public void setJPEGQTables (final int[] JPEGQTables)
      {
        final int[] oldValue = getJPEGQTables();
        final boolean oldPropAvailable = isJPEGQTablesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_Q_TABLES, JPEGQTables);
        propertyChangeSupport.firePropertyChange("JPEGQTables", oldValue, JPEGQTables);
        propertyChangeSupport.firePropertyChange("JPEGQTablesAvailable", oldPropAvailable, isJPEGQTablesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getJPEGQTables()
      {
        return getObject(JPEG_Q_TABLES, int[].class);
      }

    public void setJPEGQTablesAvailable (final boolean available)
      {
        final int[] oldValue = getJPEGQTables();
        final boolean oldPropAvailable = isJPEGQTablesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_Q_TABLES))
          {
            setObject(JPEG_Q_TABLES, null);
          }
        else if (!available)
          {
            removeTag(JPEG_Q_TABLES);
          }

        propertyChangeSupport.firePropertyChange("JPEGQTablesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGQTables", oldValue, getJPEGQTables());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGQTablesAvailable()
      {
        return containsTag(JPEG_Q_TABLES);
      }

    public void setJPEGDCTables (final int[] JPEGDCTables)
      {
        final int[] oldValue = getJPEGDCTables();
        final boolean oldPropAvailable = isJPEGDCTablesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_DC_TABLES, JPEGDCTables);
        propertyChangeSupport.firePropertyChange("JPEGDCTables", oldValue, JPEGDCTables);
        propertyChangeSupport.firePropertyChange("JPEGDCTablesAvailable", oldPropAvailable, isJPEGDCTablesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getJPEGDCTables()
      {
        return getObject(JPEG_DC_TABLES, int[].class);
      }

    public void setJPEGDCTablesAvailable (final boolean available)
      {
        final int[] oldValue = getJPEGDCTables();
        final boolean oldPropAvailable = isJPEGDCTablesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_DC_TABLES))
          {
            setObject(JPEG_DC_TABLES, null);
          }
        else if (!available)
          {
            removeTag(JPEG_DC_TABLES);
          }

        propertyChangeSupport.firePropertyChange("JPEGDCTablesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGDCTables", oldValue, getJPEGDCTables());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGDCTablesAvailable()
      {
        return containsTag(JPEG_DC_TABLES);
      }

    public void setJPEGACTables (final int[] JPEGACTables)
      {
        final int[] oldValue = getJPEGACTables();
        final boolean oldPropAvailable = isJPEGACTablesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.JPEG_AC_TABLES, JPEGACTables);
        propertyChangeSupport.firePropertyChange("JPEGACTables", oldValue, JPEGACTables);
        propertyChangeSupport.firePropertyChange("JPEGACTablesAvailable", oldPropAvailable, isJPEGACTablesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getJPEGACTables()
      {
        return getObject(JPEG_AC_TABLES, int[].class);
      }

    public void setJPEGACTablesAvailable (final boolean available)
      {
        final int[] oldValue = getJPEGACTables();
        final boolean oldPropAvailable = isJPEGACTablesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JPEG_AC_TABLES))
          {
            setObject(JPEG_AC_TABLES, null);
          }
        else if (!available)
          {
            removeTag(JPEG_AC_TABLES);
          }

        propertyChangeSupport.firePropertyChange("JPEGACTablesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("JPEGACTables", oldValue, getJPEGACTables());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJPEGACTablesAvailable()
      {
        return containsTag(JPEG_AC_TABLES);
      }

    public void setYCbCrCoefficients (final Rational[] YCbCrCoefficients)
      {
        final Rational[] oldValue = getYCbCrCoefficients();
        final boolean oldPropAvailable = isYCbCrCoefficientsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.YCBCR_COEFFICIENTS, YCbCrCoefficients);
        propertyChangeSupport.firePropertyChange("YCbCrCoefficients", oldValue, YCbCrCoefficients);
        propertyChangeSupport.firePropertyChange("YCbCrCoefficientsAvailable", oldPropAvailable, isYCbCrCoefficientsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getYCbCrCoefficients()
      {
        return getObject(YCBCR_COEFFICIENTS, Rational[].class);
      }

    public void setYCbCrCoefficientsAvailable (final boolean available)
      {
        final Rational[] oldValue = getYCbCrCoefficients();
        final boolean oldPropAvailable = isYCbCrCoefficientsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(YCBCR_COEFFICIENTS))
          {
            setObject(YCBCR_COEFFICIENTS, null);
          }
        else if (!available)
          {
            removeTag(YCBCR_COEFFICIENTS);
          }

        propertyChangeSupport.firePropertyChange("YCbCrCoefficientsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("YCbCrCoefficients", oldValue, getYCbCrCoefficients());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isYCbCrCoefficientsAvailable()
      {
        return containsTag(YCBCR_COEFFICIENTS);
      }

    public void setYCbCrSubsampling (final int[] YCbCrSubsampling)
      {
        final int[] oldValue = getYCbCrSubsampling();
        final boolean oldPropAvailable = isYCbCrSubsamplingAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.YCBCR_SUBSAMPLING, YCbCrSubsampling);
        propertyChangeSupport.firePropertyChange("YCbCrSubsampling", oldValue, YCbCrSubsampling);
        propertyChangeSupport.firePropertyChange("YCbCrSubsamplingAvailable", oldPropAvailable, isYCbCrSubsamplingAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getYCbCrSubsampling()
      {
        return getObject(YCBCR_SUBSAMPLING, int[].class);
      }

    public void setYCbCrSubsamplingAvailable (final boolean available)
      {
        final int[] oldValue = getYCbCrSubsampling();
        final boolean oldPropAvailable = isYCbCrSubsamplingAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(YCBCR_SUBSAMPLING))
          {
            setObject(YCBCR_SUBSAMPLING, null);
          }
        else if (!available)
          {
            removeTag(YCBCR_SUBSAMPLING);
          }

        propertyChangeSupport.firePropertyChange("YCbCrSubsamplingAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("YCbCrSubsampling", oldValue, getYCbCrSubsampling());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isYCbCrSubsamplingAvailable()
      {
        return containsTag(YCBCR_SUBSAMPLING);
      }

    public void setYCbCrPositioning (final Integer YCbCrPositioning)
      {
        final Integer oldValue = getYCbCrPositioning();
        final boolean oldPropAvailable = isYCbCrPositioningAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.YCBCR_POSITIONING, YCbCrPositioning);
        propertyChangeSupport.firePropertyChange("YCbCrPositioning", oldValue, YCbCrPositioning);
        propertyChangeSupport.firePropertyChange("YCbCrPositioningAvailable", oldPropAvailable, isYCbCrPositioningAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getYCbCrPositioning()
      {
        return getObject(YCBCR_POSITIONING, Integer.class);
      }

    public void setYCbCrPositioningAvailable (final boolean available)
      {
        final Integer oldValue = getYCbCrPositioning();
        final boolean oldPropAvailable = isYCbCrPositioningAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(YCBCR_POSITIONING))
          {
            setObject(YCBCR_POSITIONING, null);
          }
        else if (!available)
          {
            removeTag(YCBCR_POSITIONING);
          }

        propertyChangeSupport.firePropertyChange("YCbCrPositioningAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("YCbCrPositioning", oldValue, getYCbCrPositioning());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isYCbCrPositioningAvailable()
      {
        return containsTag(YCBCR_POSITIONING);
      }

    public void setReferenceBlackWhite (final Rational[] referenceBlackWhite)
      {
        final Rational[] oldValue = getReferenceBlackWhite();
        final boolean oldPropAvailable = isReferenceBlackWhiteAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.REFERENCE_BLACK_WHITE, referenceBlackWhite);
        propertyChangeSupport.firePropertyChange("referenceBlackWhite", oldValue, referenceBlackWhite);
        propertyChangeSupport.firePropertyChange("referenceBlackWhiteAvailable", oldPropAvailable, isReferenceBlackWhiteAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getReferenceBlackWhite()
      {
        return getObject(REFERENCE_BLACK_WHITE, Rational[].class);
      }

    public void setReferenceBlackWhiteAvailable (final boolean available)
      {
        final Rational[] oldValue = getReferenceBlackWhite();
        final boolean oldPropAvailable = isReferenceBlackWhiteAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(REFERENCE_BLACK_WHITE))
          {
            setObject(REFERENCE_BLACK_WHITE, null);
          }
        else if (!available)
          {
            removeTag(REFERENCE_BLACK_WHITE);
          }

        propertyChangeSupport.firePropertyChange("referenceBlackWhiteAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("referenceBlackWhite", oldValue, getReferenceBlackWhite());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isReferenceBlackWhiteAvailable()
      {
        return containsTag(REFERENCE_BLACK_WHITE);
      }

    public void setXMP (final byte[] XMP)
      {
        final byte[] oldValue = getXMP();
        final boolean oldPropAvailable = isXMPAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.XMP, XMP);
        propertyChangeSupport.firePropertyChange("XMP", oldValue, XMP);
        propertyChangeSupport.firePropertyChange("XMPAvailable", oldPropAvailable, isXMPAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getXMP()
      {
        return getObject(XMP, byte[].class);
      }

    public void setXMPAvailable (final boolean available)
      {
        final byte[] oldValue = getXMP();
        final boolean oldPropAvailable = isXMPAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(XMP))
          {
            setObject(XMP, null);
          }
        else if (!available)
          {
            removeTag(XMP);
          }

        propertyChangeSupport.firePropertyChange("XMPAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("XMP", oldValue, getXMP());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isXMPAvailable()
      {
        return containsTag(XMP);
      }

    public void setImageID (final String imageID)
      {
        final String oldValue = getImageID();
        final boolean oldPropAvailable = isImageIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_ID, imageID);
        propertyChangeSupport.firePropertyChange("imageID", oldValue, imageID);
        propertyChangeSupport.firePropertyChange("imageIDAvailable", oldPropAvailable, isImageIDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getImageID()
      {
        return getObject(IMAGE_ID, String.class);
      }

    public void setImageIDAvailable (final boolean available)
      {
        final String oldValue = getImageID();
        final boolean oldPropAvailable = isImageIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_ID))
          {
            setObject(IMAGE_ID, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_ID);
          }

        propertyChangeSupport.firePropertyChange("imageIDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageID", oldValue, getImageID());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageIDAvailable()
      {
        return containsTag(IMAGE_ID);
      }

    public void setWangAnnotation (final byte[] wangAnnotation)
      {
        final byte[] oldValue = getWangAnnotation();
        final boolean oldPropAvailable = isWangAnnotationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.WANG_ANNOTATION, wangAnnotation);
        propertyChangeSupport.firePropertyChange("wangAnnotation", oldValue, wangAnnotation);
        propertyChangeSupport.firePropertyChange("wangAnnotationAvailable", oldPropAvailable, isWangAnnotationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getWangAnnotation()
      {
        return getObject(WANG_ANNOTATION, byte[].class);
      }

    public void setWangAnnotationAvailable (final boolean available)
      {
        final byte[] oldValue = getWangAnnotation();
        final boolean oldPropAvailable = isWangAnnotationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(WANG_ANNOTATION))
          {
            setObject(WANG_ANNOTATION, null);
          }
        else if (!available)
          {
            removeTag(WANG_ANNOTATION);
          }

        propertyChangeSupport.firePropertyChange("wangAnnotationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("wangAnnotation", oldValue, getWangAnnotation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isWangAnnotationAvailable()
      {
        return containsTag(WANG_ANNOTATION);
      }

    public void setCFARepeatPatternDim (final int[] CFARepeatPatternDim)
      {
        final int[] oldValue = getCFARepeatPatternDim();
        final boolean oldPropAvailable = isCFARepeatPatternDimAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CFA_REPEAT_PATTERN_DIM, CFARepeatPatternDim);
        propertyChangeSupport.firePropertyChange("CFARepeatPatternDim", oldValue, CFARepeatPatternDim);
        propertyChangeSupport.firePropertyChange("CFARepeatPatternDimAvailable", oldPropAvailable, isCFARepeatPatternDimAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getCFARepeatPatternDim()
      {
        return getObject(CFA_REPEAT_PATTERN_DIM, int[].class);
      }

    public void setCFARepeatPatternDimAvailable (final boolean available)
      {
        final int[] oldValue = getCFARepeatPatternDim();
        final boolean oldPropAvailable = isCFARepeatPatternDimAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CFA_REPEAT_PATTERN_DIM))
          {
            setObject(CFA_REPEAT_PATTERN_DIM, null);
          }
        else if (!available)
          {
            removeTag(CFA_REPEAT_PATTERN_DIM);
          }

        propertyChangeSupport.firePropertyChange("CFARepeatPatternDimAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("CFARepeatPatternDim", oldValue, getCFARepeatPatternDim());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCFARepeatPatternDimAvailable()
      {
        return containsTag(CFA_REPEAT_PATTERN_DIM);
      }

    public void setCFAPattern (final byte[] CFAPattern)
      {
        final byte[] oldValue = getCFAPattern();
        final boolean oldPropAvailable = isCFAPatternAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CFA_PATTERN, CFAPattern);
        propertyChangeSupport.firePropertyChange("CFAPattern", oldValue, CFAPattern);
        propertyChangeSupport.firePropertyChange("CFAPatternAvailable", oldPropAvailable, isCFAPatternAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getCFAPattern()
      {
        return getObject(CFA_PATTERN, byte[].class);
      }

    public void setCFAPatternAvailable (final boolean available)
      {
        final byte[] oldValue = getCFAPattern();
        final boolean oldPropAvailable = isCFAPatternAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CFA_PATTERN))
          {
            setObject(CFA_PATTERN, null);
          }
        else if (!available)
          {
            removeTag(CFA_PATTERN);
          }

        propertyChangeSupport.firePropertyChange("CFAPatternAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("CFAPattern", oldValue, getCFAPattern());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCFAPatternAvailable()
      {
        return containsTag(CFA_PATTERN);
      }

    public void setBatteryLevel (final String batteryLevel)
      {
        final String oldValue = getBatteryLevel();
        final boolean oldPropAvailable = isBatteryLevelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BATTERY_LEVEL, batteryLevel);
        propertyChangeSupport.firePropertyChange("batteryLevel", oldValue, batteryLevel);
        propertyChangeSupport.firePropertyChange("batteryLevelAvailable", oldPropAvailable, isBatteryLevelAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getBatteryLevel()
      {
        return getObject(BATTERY_LEVEL, String.class);
      }

    public void setBatteryLevelAvailable (final boolean available)
      {
        final String oldValue = getBatteryLevel();
        final boolean oldPropAvailable = isBatteryLevelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BATTERY_LEVEL))
          {
            setObject(BATTERY_LEVEL, null);
          }
        else if (!available)
          {
            removeTag(BATTERY_LEVEL);
          }

        propertyChangeSupport.firePropertyChange("batteryLevelAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("batteryLevel", oldValue, getBatteryLevel());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBatteryLevelAvailable()
      {
        return containsTag(BATTERY_LEVEL);
      }

    public void setCopyright (final String copyright)
      {
        final String oldValue = getCopyright();
        final boolean oldPropAvailable = isCopyrightAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COPYRIGHT, copyright);
        propertyChangeSupport.firePropertyChange("copyright", oldValue, copyright);
        propertyChangeSupport.firePropertyChange("copyrightAvailable", oldPropAvailable, isCopyrightAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCopyright()
      {
        return getObject(COPYRIGHT, String.class);
      }

    public void setCopyrightAvailable (final boolean available)
      {
        final String oldValue = getCopyright();
        final boolean oldPropAvailable = isCopyrightAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COPYRIGHT))
          {
            setObject(COPYRIGHT, null);
          }
        else if (!available)
          {
            removeTag(COPYRIGHT);
          }

        propertyChangeSupport.firePropertyChange("copyrightAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("copyright", oldValue, getCopyright());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCopyrightAvailable()
      {
        return containsTag(COPYRIGHT);
      }

    public void setExposureTime (final Rational exposureTime)
      {
        final Rational oldValue = getExposureTime();
        final boolean oldPropAvailable = isExposureTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXPOSURE_TIME, exposureTime);
        propertyChangeSupport.firePropertyChange("exposureTime", oldValue, exposureTime);
        propertyChangeSupport.firePropertyChange("exposureTimeAvailable", oldPropAvailable, isExposureTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getExposureTime()
      {
        return getObject(EXPOSURE_TIME, Rational.class);
      }

    public void setExposureTimeAvailable (final boolean available)
      {
        final Rational oldValue = getExposureTime();
        final boolean oldPropAvailable = isExposureTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXPOSURE_TIME))
          {
            setObject(EXPOSURE_TIME, null);
          }
        else if (!available)
          {
            removeTag(EXPOSURE_TIME);
          }

        propertyChangeSupport.firePropertyChange("exposureTimeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("exposureTime", oldValue, getExposureTime());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExposureTimeAvailable()
      {
        return containsTag(EXPOSURE_TIME);
      }

    public void setFNumber (final Rational FNumber)
      {
        final Rational oldValue = getFNumber();
        final boolean oldPropAvailable = isFNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.F_NUMBER, FNumber);
        propertyChangeSupport.firePropertyChange("FNumber", oldValue, FNumber);
        propertyChangeSupport.firePropertyChange("FNumberAvailable", oldPropAvailable, isFNumberAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getFNumber()
      {
        return getObject(F_NUMBER, Rational.class);
      }

    public void setFNumberAvailable (final boolean available)
      {
        final Rational oldValue = getFNumber();
        final boolean oldPropAvailable = isFNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(F_NUMBER))
          {
            setObject(F_NUMBER, null);
          }
        else if (!available)
          {
            removeTag(F_NUMBER);
          }

        propertyChangeSupport.firePropertyChange("FNumberAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("FNumber", oldValue, getFNumber());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFNumberAvailable()
      {
        return containsTag(F_NUMBER);
      }

    public void setIPTCNAA (final String IPTCNAA)
      {
        final String oldValue = getIPTCNAA();
        final boolean oldPropAvailable = isIPTCNAAAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IPTC_NAA, IPTCNAA);
        propertyChangeSupport.firePropertyChange("IPTCNAA", oldValue, IPTCNAA);
        propertyChangeSupport.firePropertyChange("IPTCNAAAvailable", oldPropAvailable, isIPTCNAAAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getIPTCNAA()
      {
        return getObject(IPTC_NAA, String.class);
      }

    public void setIPTCNAAAvailable (final boolean available)
      {
        final String oldValue = getIPTCNAA();
        final boolean oldPropAvailable = isIPTCNAAAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IPTC_NAA))
          {
            setObject(IPTC_NAA, null);
          }
        else if (!available)
          {
            removeTag(IPTC_NAA);
          }

        propertyChangeSupport.firePropertyChange("IPTCNAAAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("IPTCNAA", oldValue, getIPTCNAA());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isIPTCNAAAvailable()
      {
        return containsTag(IPTC_NAA);
      }

    public void setModelPixelScaleTag (final double[] modelPixelScaleTag)
      {
        final double[] oldValue = getModelPixelScaleTag();
        final boolean oldPropAvailable = isModelPixelScaleTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MODEL_PIXEL_SCALE_TAG, modelPixelScaleTag);
        propertyChangeSupport.firePropertyChange("modelPixelScaleTag", oldValue, modelPixelScaleTag);
        propertyChangeSupport.firePropertyChange("modelPixelScaleTagAvailable", oldPropAvailable, isModelPixelScaleTagAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public double[] getModelPixelScaleTag()
      {
        return getObject(MODEL_PIXEL_SCALE_TAG, double[].class);
      }

    public void setModelPixelScaleTagAvailable (final boolean available)
      {
        final double[] oldValue = getModelPixelScaleTag();
        final boolean oldPropAvailable = isModelPixelScaleTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MODEL_PIXEL_SCALE_TAG))
          {
            setObject(MODEL_PIXEL_SCALE_TAG, null);
          }
        else if (!available)
          {
            removeTag(MODEL_PIXEL_SCALE_TAG);
          }

        propertyChangeSupport.firePropertyChange("modelPixelScaleTagAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("modelPixelScaleTag", oldValue, getModelPixelScaleTag());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isModelPixelScaleTagAvailable()
      {
        return containsTag(MODEL_PIXEL_SCALE_TAG);
      }

    public void setIntergraphMatrixTag (final double[] intergraphMatrixTag)
      {
        final double[] oldValue = getIntergraphMatrixTag();
        final boolean oldPropAvailable = isIntergraphMatrixTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.INTERGRAPH_MATRIX_TAG, intergraphMatrixTag);
        propertyChangeSupport.firePropertyChange("intergraphMatrixTag", oldValue, intergraphMatrixTag);
        propertyChangeSupport.firePropertyChange("intergraphMatrixTagAvailable", oldPropAvailable, isIntergraphMatrixTagAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public double[] getIntergraphMatrixTag()
      {
        return getObject(INTERGRAPH_MATRIX_TAG, double[].class);
      }

    public void setIntergraphMatrixTagAvailable (final boolean available)
      {
        final double[] oldValue = getIntergraphMatrixTag();
        final boolean oldPropAvailable = isIntergraphMatrixTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(INTERGRAPH_MATRIX_TAG))
          {
            setObject(INTERGRAPH_MATRIX_TAG, null);
          }
        else if (!available)
          {
            removeTag(INTERGRAPH_MATRIX_TAG);
          }

        propertyChangeSupport.firePropertyChange("intergraphMatrixTagAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("intergraphMatrixTag", oldValue, getIntergraphMatrixTag());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isIntergraphMatrixTagAvailable()
      {
        return containsTag(INTERGRAPH_MATRIX_TAG);
      }

    public void setModelTiepointTag (final double[] modelTiepointTag)
      {
        final double[] oldValue = getModelTiepointTag();
        final boolean oldPropAvailable = isModelTiepointTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MODEL_TIEPOINT_TAG, modelTiepointTag);
        propertyChangeSupport.firePropertyChange("modelTiepointTag", oldValue, modelTiepointTag);
        propertyChangeSupport.firePropertyChange("modelTiepointTagAvailable", oldPropAvailable, isModelTiepointTagAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public double[] getModelTiepointTag()
      {
        return getObject(MODEL_TIEPOINT_TAG, double[].class);
      }

    public void setModelTiepointTagAvailable (final boolean available)
      {
        final double[] oldValue = getModelTiepointTag();
        final boolean oldPropAvailable = isModelTiepointTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MODEL_TIEPOINT_TAG))
          {
            setObject(MODEL_TIEPOINT_TAG, null);
          }
        else if (!available)
          {
            removeTag(MODEL_TIEPOINT_TAG);
          }

        propertyChangeSupport.firePropertyChange("modelTiepointTagAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("modelTiepointTag", oldValue, getModelTiepointTag());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isModelTiepointTagAvailable()
      {
        return containsTag(MODEL_TIEPOINT_TAG);
      }

    public void setSite (final String site)
      {
        final String oldValue = getSite();
        final boolean oldPropAvailable = isSiteAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SITE, site);
        propertyChangeSupport.firePropertyChange("site", oldValue, site);
        propertyChangeSupport.firePropertyChange("siteAvailable", oldPropAvailable, isSiteAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSite()
      {
        return getObject(SITE, String.class);
      }

    public void setSiteAvailable (final boolean available)
      {
        final String oldValue = getSite();
        final boolean oldPropAvailable = isSiteAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SITE))
          {
            setObject(SITE, null);
          }
        else if (!available)
          {
            removeTag(SITE);
          }

        propertyChangeSupport.firePropertyChange("siteAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("site", oldValue, getSite());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSiteAvailable()
      {
        return containsTag(SITE);
      }

    public void setColorSequence (final String colorSequence)
      {
        final String oldValue = getColorSequence();
        final boolean oldPropAvailable = isColorSequenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COLOR_SEQUENCE, colorSequence);
        propertyChangeSupport.firePropertyChange("colorSequence", oldValue, colorSequence);
        propertyChangeSupport.firePropertyChange("colorSequenceAvailable", oldPropAvailable, isColorSequenceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getColorSequence()
      {
        return getObject(COLOR_SEQUENCE, String.class);
      }

    public void setColorSequenceAvailable (final boolean available)
      {
        final String oldValue = getColorSequence();
        final boolean oldPropAvailable = isColorSequenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COLOR_SEQUENCE))
          {
            setObject(COLOR_SEQUENCE, null);
          }
        else if (!available)
          {
            removeTag(COLOR_SEQUENCE);
          }

        propertyChangeSupport.firePropertyChange("colorSequenceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("colorSequence", oldValue, getColorSequence());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isColorSequenceAvailable()
      {
        return containsTag(COLOR_SEQUENCE);
      }

    public void setIT8Header (final String IT8Header)
      {
        final String oldValue = getIT8Header();
        final boolean oldPropAvailable = isIT8HeaderAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IT8_HEADER, IT8Header);
        propertyChangeSupport.firePropertyChange("IT8Header", oldValue, IT8Header);
        propertyChangeSupport.firePropertyChange("IT8HeaderAvailable", oldPropAvailable, isIT8HeaderAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getIT8Header()
      {
        return getObject(IT8_HEADER, String.class);
      }

    public void setIT8HeaderAvailable (final boolean available)
      {
        final String oldValue = getIT8Header();
        final boolean oldPropAvailable = isIT8HeaderAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IT8_HEADER))
          {
            setObject(IT8_HEADER, null);
          }
        else if (!available)
          {
            removeTag(IT8_HEADER);
          }

        propertyChangeSupport.firePropertyChange("IT8HeaderAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("IT8Header", oldValue, getIT8Header());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isIT8HeaderAvailable()
      {
        return containsTag(IT8_HEADER);
      }

    public void setRasterPadding (final Integer rasterPadding)
      {
        final Integer oldValue = getRasterPadding();
        final boolean oldPropAvailable = isRasterPaddingAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.RASTER_PADDING, rasterPadding);
        propertyChangeSupport.firePropertyChange("rasterPadding", oldValue, rasterPadding);
        propertyChangeSupport.firePropertyChange("rasterPaddingAvailable", oldPropAvailable, isRasterPaddingAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getRasterPadding()
      {
        return getObject(RASTER_PADDING, Integer.class);
      }

    public void setRasterPaddingAvailable (final boolean available)
      {
        final Integer oldValue = getRasterPadding();
        final boolean oldPropAvailable = isRasterPaddingAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(RASTER_PADDING))
          {
            setObject(RASTER_PADDING, null);
          }
        else if (!available)
          {
            removeTag(RASTER_PADDING);
          }

        propertyChangeSupport.firePropertyChange("rasterPaddingAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("rasterPadding", oldValue, getRasterPadding());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isRasterPaddingAvailable()
      {
        return containsTag(RASTER_PADDING);
      }

    public void setBitsPerRunLength (final Integer bitsPerRunLength)
      {
        final Integer oldValue = getBitsPerRunLength();
        final boolean oldPropAvailable = isBitsPerRunLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BITS_PER_RUN_LENGTH, bitsPerRunLength);
        propertyChangeSupport.firePropertyChange("bitsPerRunLength", oldValue, bitsPerRunLength);
        propertyChangeSupport.firePropertyChange("bitsPerRunLengthAvailable", oldPropAvailable, isBitsPerRunLengthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getBitsPerRunLength()
      {
        return getObject(BITS_PER_RUN_LENGTH, Integer.class);
      }

    public void setBitsPerRunLengthAvailable (final boolean available)
      {
        final Integer oldValue = getBitsPerRunLength();
        final boolean oldPropAvailable = isBitsPerRunLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BITS_PER_RUN_LENGTH))
          {
            setObject(BITS_PER_RUN_LENGTH, null);
          }
        else if (!available)
          {
            removeTag(BITS_PER_RUN_LENGTH);
          }

        propertyChangeSupport.firePropertyChange("bitsPerRunLengthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("bitsPerRunLength", oldValue, getBitsPerRunLength());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBitsPerRunLengthAvailable()
      {
        return containsTag(BITS_PER_RUN_LENGTH);
      }

    public void setBitsPerExtendedRunLength (final Integer bitsPerExtendedRunLength)
      {
        final Integer oldValue = getBitsPerExtendedRunLength();
        final boolean oldPropAvailable = isBitsPerExtendedRunLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BITS_PER_EXTENDED_RUN_LENGTH, bitsPerExtendedRunLength);
        propertyChangeSupport.firePropertyChange("bitsPerExtendedRunLength", oldValue, bitsPerExtendedRunLength);
        propertyChangeSupport.firePropertyChange("bitsPerExtendedRunLengthAvailable", oldPropAvailable, isBitsPerExtendedRunLengthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getBitsPerExtendedRunLength()
      {
        return getObject(BITS_PER_EXTENDED_RUN_LENGTH, Integer.class);
      }

    public void setBitsPerExtendedRunLengthAvailable (final boolean available)
      {
        final Integer oldValue = getBitsPerExtendedRunLength();
        final boolean oldPropAvailable = isBitsPerExtendedRunLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BITS_PER_EXTENDED_RUN_LENGTH))
          {
            setObject(BITS_PER_EXTENDED_RUN_LENGTH, null);
          }
        else if (!available)
          {
            removeTag(BITS_PER_EXTENDED_RUN_LENGTH);
          }

        propertyChangeSupport.firePropertyChange("bitsPerExtendedRunLengthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("bitsPerExtendedRunLength", oldValue, getBitsPerExtendedRunLength());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBitsPerExtendedRunLengthAvailable()
      {
        return containsTag(BITS_PER_EXTENDED_RUN_LENGTH);
      }

    public void setColorTable (final byte[] colorTable)
      {
        final byte[] oldValue = getColorTable();
        final boolean oldPropAvailable = isColorTableAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COLOR_TABLE, colorTable);
        propertyChangeSupport.firePropertyChange("colorTable", oldValue, colorTable);
        propertyChangeSupport.firePropertyChange("colorTableAvailable", oldPropAvailable, isColorTableAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getColorTable()
      {
        return getObject(COLOR_TABLE, byte[].class);
      }

    public void setColorTableAvailable (final boolean available)
      {
        final byte[] oldValue = getColorTable();
        final boolean oldPropAvailable = isColorTableAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COLOR_TABLE))
          {
            setObject(COLOR_TABLE, null);
          }
        else if (!available)
          {
            removeTag(COLOR_TABLE);
          }

        propertyChangeSupport.firePropertyChange("colorTableAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("colorTable", oldValue, getColorTable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isColorTableAvailable()
      {
        return containsTag(COLOR_TABLE);
      }

    public void setImageColorIndicator (final Integer imageColorIndicator)
      {
        final Integer oldValue = getImageColorIndicator();
        final boolean oldPropAvailable = isImageColorIndicatorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_COLOR_INDICATOR, imageColorIndicator);
        propertyChangeSupport.firePropertyChange("imageColorIndicator", oldValue, imageColorIndicator);
        propertyChangeSupport.firePropertyChange("imageColorIndicatorAvailable", oldPropAvailable, isImageColorIndicatorAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getImageColorIndicator()
      {
        return getObject(IMAGE_COLOR_INDICATOR, Integer.class);
      }

    public void setImageColorIndicatorAvailable (final boolean available)
      {
        final Integer oldValue = getImageColorIndicator();
        final boolean oldPropAvailable = isImageColorIndicatorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_COLOR_INDICATOR))
          {
            setObject(IMAGE_COLOR_INDICATOR, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_COLOR_INDICATOR);
          }

        propertyChangeSupport.firePropertyChange("imageColorIndicatorAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageColorIndicator", oldValue, getImageColorIndicator());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageColorIndicatorAvailable()
      {
        return containsTag(IMAGE_COLOR_INDICATOR);
      }

    public void setBackgroundColorIndicator (final Integer backgroundColorIndicator)
      {
        final Integer oldValue = getBackgroundColorIndicator();
        final boolean oldPropAvailable = isBackgroundColorIndicatorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BACKGROUND_COLOR_INDICATOR, backgroundColorIndicator);
        propertyChangeSupport.firePropertyChange("backgroundColorIndicator", oldValue, backgroundColorIndicator);
        propertyChangeSupport.firePropertyChange("backgroundColorIndicatorAvailable", oldPropAvailable, isBackgroundColorIndicatorAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getBackgroundColorIndicator()
      {
        return getObject(BACKGROUND_COLOR_INDICATOR, Integer.class);
      }

    public void setBackgroundColorIndicatorAvailable (final boolean available)
      {
        final Integer oldValue = getBackgroundColorIndicator();
        final boolean oldPropAvailable = isBackgroundColorIndicatorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BACKGROUND_COLOR_INDICATOR))
          {
            setObject(BACKGROUND_COLOR_INDICATOR, null);
          }
        else if (!available)
          {
            removeTag(BACKGROUND_COLOR_INDICATOR);
          }

        propertyChangeSupport.firePropertyChange("backgroundColorIndicatorAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("backgroundColorIndicator", oldValue, getBackgroundColorIndicator());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBackgroundColorIndicatorAvailable()
      {
        return containsTag(BACKGROUND_COLOR_INDICATOR);
      }

    public void setImageColorValue (final Integer imageColorValue)
      {
        final Integer oldValue = getImageColorValue();
        final boolean oldPropAvailable = isImageColorValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_COLOR_VALUE, imageColorValue);
        propertyChangeSupport.firePropertyChange("imageColorValue", oldValue, imageColorValue);
        propertyChangeSupport.firePropertyChange("imageColorValueAvailable", oldPropAvailable, isImageColorValueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getImageColorValue()
      {
        return getObject(IMAGE_COLOR_VALUE, Integer.class);
      }

    public void setImageColorValueAvailable (final boolean available)
      {
        final Integer oldValue = getImageColorValue();
        final boolean oldPropAvailable = isImageColorValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_COLOR_VALUE))
          {
            setObject(IMAGE_COLOR_VALUE, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_COLOR_VALUE);
          }

        propertyChangeSupport.firePropertyChange("imageColorValueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageColorValue", oldValue, getImageColorValue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageColorValueAvailable()
      {
        return containsTag(IMAGE_COLOR_VALUE);
      }

    public void setBackgroundColorValue (final Integer backgroundColorValue)
      {
        final Integer oldValue = getBackgroundColorValue();
        final boolean oldPropAvailable = isBackgroundColorValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BACKGROUND_COLOR_VALUE, backgroundColorValue);
        propertyChangeSupport.firePropertyChange("backgroundColorValue", oldValue, backgroundColorValue);
        propertyChangeSupport.firePropertyChange("backgroundColorValueAvailable", oldPropAvailable, isBackgroundColorValueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getBackgroundColorValue()
      {
        return getObject(BACKGROUND_COLOR_VALUE, Integer.class);
      }

    public void setBackgroundColorValueAvailable (final boolean available)
      {
        final Integer oldValue = getBackgroundColorValue();
        final boolean oldPropAvailable = isBackgroundColorValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BACKGROUND_COLOR_VALUE))
          {
            setObject(BACKGROUND_COLOR_VALUE, null);
          }
        else if (!available)
          {
            removeTag(BACKGROUND_COLOR_VALUE);
          }

        propertyChangeSupport.firePropertyChange("backgroundColorValueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("backgroundColorValue", oldValue, getBackgroundColorValue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBackgroundColorValueAvailable()
      {
        return containsTag(BACKGROUND_COLOR_VALUE);
      }

    public void setPixelIntensityRange (final byte[] pixelIntensityRange)
      {
        final byte[] oldValue = getPixelIntensityRange();
        final boolean oldPropAvailable = isPixelIntensityRangeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PIXEL_INTENSITY_RANGE, pixelIntensityRange);
        propertyChangeSupport.firePropertyChange("pixelIntensityRange", oldValue, pixelIntensityRange);
        propertyChangeSupport.firePropertyChange("pixelIntensityRangeAvailable", oldPropAvailable, isPixelIntensityRangeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getPixelIntensityRange()
      {
        return getObject(PIXEL_INTENSITY_RANGE, byte[].class);
      }

    public void setPixelIntensityRangeAvailable (final boolean available)
      {
        final byte[] oldValue = getPixelIntensityRange();
        final boolean oldPropAvailable = isPixelIntensityRangeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PIXEL_INTENSITY_RANGE))
          {
            setObject(PIXEL_INTENSITY_RANGE, null);
          }
        else if (!available)
          {
            removeTag(PIXEL_INTENSITY_RANGE);
          }

        propertyChangeSupport.firePropertyChange("pixelIntensityRangeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("pixelIntensityRange", oldValue, getPixelIntensityRange());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPixelIntensityRangeAvailable()
      {
        return containsTag(PIXEL_INTENSITY_RANGE);
      }

    public void setTransparencyIndicator (final Integer transparencyIndicator)
      {
        final Integer oldValue = getTransparencyIndicator();
        final boolean oldPropAvailable = isTransparencyIndicatorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TRANSPARENCY_INDICATOR, transparencyIndicator);
        propertyChangeSupport.firePropertyChange("transparencyIndicator", oldValue, transparencyIndicator);
        propertyChangeSupport.firePropertyChange("transparencyIndicatorAvailable", oldPropAvailable, isTransparencyIndicatorAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getTransparencyIndicator()
      {
        return getObject(TRANSPARENCY_INDICATOR, Integer.class);
      }

    public void setTransparencyIndicatorAvailable (final boolean available)
      {
        final Integer oldValue = getTransparencyIndicator();
        final boolean oldPropAvailable = isTransparencyIndicatorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TRANSPARENCY_INDICATOR))
          {
            setObject(TRANSPARENCY_INDICATOR, null);
          }
        else if (!available)
          {
            removeTag(TRANSPARENCY_INDICATOR);
          }

        propertyChangeSupport.firePropertyChange("transparencyIndicatorAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("transparencyIndicator", oldValue, getTransparencyIndicator());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTransparencyIndicatorAvailable()
      {
        return containsTag(TRANSPARENCY_INDICATOR);
      }

    public void setColorCharacterization (final String colorCharacterization)
      {
        final String oldValue = getColorCharacterization();
        final boolean oldPropAvailable = isColorCharacterizationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COLOR_CHARACTERIZATION, colorCharacterization);
        propertyChangeSupport.firePropertyChange("colorCharacterization", oldValue, colorCharacterization);
        propertyChangeSupport.firePropertyChange("colorCharacterizationAvailable", oldPropAvailable, isColorCharacterizationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getColorCharacterization()
      {
        return getObject(COLOR_CHARACTERIZATION, String.class);
      }

    public void setColorCharacterizationAvailable (final boolean available)
      {
        final String oldValue = getColorCharacterization();
        final boolean oldPropAvailable = isColorCharacterizationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COLOR_CHARACTERIZATION))
          {
            setObject(COLOR_CHARACTERIZATION, null);
          }
        else if (!available)
          {
            removeTag(COLOR_CHARACTERIZATION);
          }

        propertyChangeSupport.firePropertyChange("colorCharacterizationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("colorCharacterization", oldValue, getColorCharacterization());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isColorCharacterizationAvailable()
      {
        return containsTag(COLOR_CHARACTERIZATION);
      }

    public void setHCUsage (final Long HCUsage)
      {
        final Long oldValue = getHCUsage();
        final boolean oldPropAvailable = isHCUsageAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.HC_USAGE, HCUsage);
        propertyChangeSupport.firePropertyChange("HCUsage", oldValue, HCUsage);
        propertyChangeSupport.firePropertyChange("HCUsageAvailable", oldPropAvailable, isHCUsageAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getHCUsage()
      {
        return getObject(HC_USAGE, Long.class);
      }

    public void setHCUsageAvailable (final boolean available)
      {
        final Long oldValue = getHCUsage();
        final boolean oldPropAvailable = isHCUsageAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(HC_USAGE))
          {
            setObject(HC_USAGE, null);
          }
        else if (!available)
          {
            removeTag(HC_USAGE);
          }

        propertyChangeSupport.firePropertyChange("HCUsageAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("HCUsage", oldValue, getHCUsage());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isHCUsageAvailable()
      {
        return containsTag(HC_USAGE);
      }

    public void setModelTransformationTag (final double[] modelTransformationTag)
      {
        final double[] oldValue = getModelTransformationTag();
        final boolean oldPropAvailable = isModelTransformationTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MODEL_TRANSFORMATION_TAG, modelTransformationTag);
        propertyChangeSupport.firePropertyChange("modelTransformationTag", oldValue, modelTransformationTag);
        propertyChangeSupport.firePropertyChange("modelTransformationTagAvailable", oldPropAvailable, isModelTransformationTagAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public double[] getModelTransformationTag()
      {
        return getObject(MODEL_TRANSFORMATION_TAG, double[].class);
      }

    public void setModelTransformationTagAvailable (final boolean available)
      {
        final double[] oldValue = getModelTransformationTag();
        final boolean oldPropAvailable = isModelTransformationTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MODEL_TRANSFORMATION_TAG))
          {
            setObject(MODEL_TRANSFORMATION_TAG, null);
          }
        else if (!available)
          {
            removeTag(MODEL_TRANSFORMATION_TAG);
          }

        propertyChangeSupport.firePropertyChange("modelTransformationTagAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("modelTransformationTag", oldValue, getModelTransformationTag());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isModelTransformationTagAvailable()
      {
        return containsTag(MODEL_TRANSFORMATION_TAG);
      }

    public void setPhotoshopImageResources (final Integer photoshopImageResources)
      {
        final Integer oldValue = getPhotoshopImageResources();
        final boolean oldPropAvailable = isPhotoshopImageResourcesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PHOTOSHOP_IMAGE_RESOURCES, photoshopImageResources);
        propertyChangeSupport.firePropertyChange("photoshopImageResources", oldValue, photoshopImageResources);
        propertyChangeSupport.firePropertyChange("photoshopImageResourcesAvailable", oldPropAvailable, isPhotoshopImageResourcesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getPhotoshopImageResources()
      {
        return getObject(PHOTOSHOP_IMAGE_RESOURCES, Integer.class);
      }

    public void setPhotoshopImageResourcesAvailable (final boolean available)
      {
        final Integer oldValue = getPhotoshopImageResources();
        final boolean oldPropAvailable = isPhotoshopImageResourcesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PHOTOSHOP_IMAGE_RESOURCES))
          {
            setObject(PHOTOSHOP_IMAGE_RESOURCES, null);
          }
        else if (!available)
          {
            removeTag(PHOTOSHOP_IMAGE_RESOURCES);
          }

        propertyChangeSupport.firePropertyChange("photoshopImageResourcesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("photoshopImageResources", oldValue, getPhotoshopImageResources());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPhotoshopImageResourcesAvailable()
      {
        return containsTag(PHOTOSHOP_IMAGE_RESOURCES);
      }

    public void setExifIFDPointer (final Long exifIFDPointer)
      {
        final Long oldValue = getExifIFDPointer();
        final boolean oldPropAvailable = isExifIFDPointerAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXIF_IFD_POINTER, exifIFDPointer);
        propertyChangeSupport.firePropertyChange("exifIFDPointer", oldValue, exifIFDPointer);
        propertyChangeSupport.firePropertyChange("exifIFDPointerAvailable", oldPropAvailable, isExifIFDPointerAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getExifIFDPointer()
      {
        return getObject(EXIF_IFD_POINTER, Long.class);
      }

    public void setExifIFDPointerAvailable (final boolean available)
      {
        final Long oldValue = getExifIFDPointer();
        final boolean oldPropAvailable = isExifIFDPointerAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXIF_IFD_POINTER))
          {
            setObject(EXIF_IFD_POINTER, null);
          }
        else if (!available)
          {
            removeTag(EXIF_IFD_POINTER);
          }

        propertyChangeSupport.firePropertyChange("exifIFDPointerAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("exifIFDPointer", oldValue, getExifIFDPointer());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExifIFDPointerAvailable()
      {
        return containsTag(EXIF_IFD_POINTER);
      }

    public void setInterColourProfile (final byte[] interColourProfile)
      {
        final byte[] oldValue = getInterColourProfile();
        final boolean oldPropAvailable = isInterColourProfileAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.INTER_COLOUR_PROFILE, interColourProfile);
        propertyChangeSupport.firePropertyChange("interColourProfile", oldValue, interColourProfile);
        propertyChangeSupport.firePropertyChange("interColourProfileAvailable", oldPropAvailable, isInterColourProfileAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getInterColourProfile()
      {
        return getObject(INTER_COLOUR_PROFILE, byte[].class);
      }

    public void setInterColourProfileAvailable (final boolean available)
      {
        final byte[] oldValue = getInterColourProfile();
        final boolean oldPropAvailable = isInterColourProfileAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(INTER_COLOUR_PROFILE))
          {
            setObject(INTER_COLOUR_PROFILE, null);
          }
        else if (!available)
          {
            removeTag(INTER_COLOUR_PROFILE);
          }

        propertyChangeSupport.firePropertyChange("interColourProfileAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("interColourProfile", oldValue, getInterColourProfile());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isInterColourProfileAvailable()
      {
        return containsTag(INTER_COLOUR_PROFILE);
      }

    public void setGeoKeyDirectoryTag (final int[] geoKeyDirectoryTag)
      {
        final int[] oldValue = getGeoKeyDirectoryTag();
        final boolean oldPropAvailable = isGeoKeyDirectoryTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.GEO_KEY_DIRECTORYTAG, geoKeyDirectoryTag);
        propertyChangeSupport.firePropertyChange("geoKeyDirectoryTag", oldValue, geoKeyDirectoryTag);
        propertyChangeSupport.firePropertyChange("geoKeyDirectoryTagAvailable", oldPropAvailable, isGeoKeyDirectoryTagAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getGeoKeyDirectoryTag()
      {
        return getObject(GEO_KEY_DIRECTORYTAG, int[].class);
      }

    public void setGeoKeyDirectoryTagAvailable (final boolean available)
      {
        final int[] oldValue = getGeoKeyDirectoryTag();
        final boolean oldPropAvailable = isGeoKeyDirectoryTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(GEO_KEY_DIRECTORYTAG))
          {
            setObject(GEO_KEY_DIRECTORYTAG, null);
          }
        else if (!available)
          {
            removeTag(GEO_KEY_DIRECTORYTAG);
          }

        propertyChangeSupport.firePropertyChange("geoKeyDirectoryTagAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("geoKeyDirectoryTag", oldValue, getGeoKeyDirectoryTag());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isGeoKeyDirectoryTagAvailable()
      {
        return containsTag(GEO_KEY_DIRECTORYTAG);
      }

    public void setGeoDoubleParamsTag (final double[] geoDoubleParamsTag)
      {
        final double[] oldValue = getGeoDoubleParamsTag();
        final boolean oldPropAvailable = isGeoDoubleParamsTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.GEO_DOUBLE_PARAMS_TAG, geoDoubleParamsTag);
        propertyChangeSupport.firePropertyChange("geoDoubleParamsTag", oldValue, geoDoubleParamsTag);
        propertyChangeSupport.firePropertyChange("geoDoubleParamsTagAvailable", oldPropAvailable, isGeoDoubleParamsTagAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public double[] getGeoDoubleParamsTag()
      {
        return getObject(GEO_DOUBLE_PARAMS_TAG, double[].class);
      }

    public void setGeoDoubleParamsTagAvailable (final boolean available)
      {
        final double[] oldValue = getGeoDoubleParamsTag();
        final boolean oldPropAvailable = isGeoDoubleParamsTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(GEO_DOUBLE_PARAMS_TAG))
          {
            setObject(GEO_DOUBLE_PARAMS_TAG, null);
          }
        else if (!available)
          {
            removeTag(GEO_DOUBLE_PARAMS_TAG);
          }

        propertyChangeSupport.firePropertyChange("geoDoubleParamsTagAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("geoDoubleParamsTag", oldValue, getGeoDoubleParamsTag());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isGeoDoubleParamsTagAvailable()
      {
        return containsTag(GEO_DOUBLE_PARAMS_TAG);
      }

    public void setGeoAsciiParamsTag (final String geoAsciiParamsTag)
      {
        final String oldValue = getGeoAsciiParamsTag();
        final boolean oldPropAvailable = isGeoAsciiParamsTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.GEO_ASCII_PARAMS_TAG, geoAsciiParamsTag);
        propertyChangeSupport.firePropertyChange("geoAsciiParamsTag", oldValue, geoAsciiParamsTag);
        propertyChangeSupport.firePropertyChange("geoAsciiParamsTagAvailable", oldPropAvailable, isGeoAsciiParamsTagAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getGeoAsciiParamsTag()
      {
        return getObject(GEO_ASCII_PARAMS_TAG, String.class);
      }

    public void setGeoAsciiParamsTagAvailable (final boolean available)
      {
        final String oldValue = getGeoAsciiParamsTag();
        final boolean oldPropAvailable = isGeoAsciiParamsTagAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(GEO_ASCII_PARAMS_TAG))
          {
            setObject(GEO_ASCII_PARAMS_TAG, null);
          }
        else if (!available)
          {
            removeTag(GEO_ASCII_PARAMS_TAG);
          }

        propertyChangeSupport.firePropertyChange("geoAsciiParamsTagAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("geoAsciiParamsTag", oldValue, getGeoAsciiParamsTag());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isGeoAsciiParamsTagAvailable()
      {
        return containsTag(GEO_ASCII_PARAMS_TAG);
      }

    public static enum ExposureProgram
       {
         NOT_DEFINED(0, "not defined"),
         MANUAL(1, "manual"),
         NORMAL_PROGRAM(2, "normal program"),
         APERTURE_PRIORITY(3, "aperture priority"),
         SHUTTER_PRIORITY(4, "shutter priority"),
         CREATIVE_PROGRAM(5, "creative program"),
         ACTION_PROGRAM(6, "action program"),
         PORTRAIT_MODE(7, "portrait mode"),
         LANDSCAPE_MODE(8, "landscape mode"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private ExposureProgram (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static ExposureProgram fromInteger (int value)
           {
             if (value == 0) return NOT_DEFINED;
             if (value == 1) return MANUAL;
             if (value == 2) return NORMAL_PROGRAM;
             if (value == 3) return APERTURE_PRIORITY;
             if (value == 4) return SHUTTER_PRIORITY;
             if (value == 5) return CREATIVE_PROGRAM;
             if (value == 6) return ACTION_PROGRAM;
             if (value == 7) return PORTRAIT_MODE;
             if (value == 8) return LANDSCAPE_MODE;

             return _UNKNOWN;
           }
       }
    public void setExposureProgram (final ExposureProgram exposureProgram)
      {
        final ExposureProgram oldValue = getExposureProgram();
        final boolean oldPropAvailable = isExposureProgramAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXPOSURE_PROGRAM, exposureProgram);
        propertyChangeSupport.firePropertyChange("exposureProgram", oldValue, exposureProgram);
        propertyChangeSupport.firePropertyChange("exposureProgramAvailable", oldPropAvailable, isExposureProgramAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public ExposureProgram getExposureProgram()
      {
        return getObject(EXPOSURE_PROGRAM, ExposureProgram.class);
      }

    public void setExposureProgramAvailable (final boolean available)
      {
        final ExposureProgram oldValue = getExposureProgram();
        final boolean oldPropAvailable = isExposureProgramAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXPOSURE_PROGRAM))
          {
            setObject(EXPOSURE_PROGRAM, null);
          }
        else if (!available)
          {
            removeTag(EXPOSURE_PROGRAM);
          }

        propertyChangeSupport.firePropertyChange("exposureProgramAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("exposureProgram", oldValue, getExposureProgram());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExposureProgramAvailable()
      {
        return containsTag(EXPOSURE_PROGRAM);
      }

    public void setSpectralSensitivity (final String spectralSensitivity)
      {
        final String oldValue = getSpectralSensitivity();
        final boolean oldPropAvailable = isSpectralSensitivityAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SPECTRAL_SENSITIVITY, spectralSensitivity);
        propertyChangeSupport.firePropertyChange("spectralSensitivity", oldValue, spectralSensitivity);
        propertyChangeSupport.firePropertyChange("spectralSensitivityAvailable", oldPropAvailable, isSpectralSensitivityAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSpectralSensitivity()
      {
        return getObject(SPECTRAL_SENSITIVITY, String.class);
      }

    public void setSpectralSensitivityAvailable (final boolean available)
      {
        final String oldValue = getSpectralSensitivity();
        final boolean oldPropAvailable = isSpectralSensitivityAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SPECTRAL_SENSITIVITY))
          {
            setObject(SPECTRAL_SENSITIVITY, null);
          }
        else if (!available)
          {
            removeTag(SPECTRAL_SENSITIVITY);
          }

        propertyChangeSupport.firePropertyChange("spectralSensitivityAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("spectralSensitivity", oldValue, getSpectralSensitivity());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSpectralSensitivityAvailable()
      {
        return containsTag(SPECTRAL_SENSITIVITY);
      }

    public void setGPSInfoIFDPointer (final Long GPSInfoIFDPointer)
      {
        final Long oldValue = getGPSInfoIFDPointer();
        final boolean oldPropAvailable = isGPSInfoIFDPointerAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.GPS_INFO_IFD_POINTER, GPSInfoIFDPointer);
        propertyChangeSupport.firePropertyChange("GPSInfoIFDPointer", oldValue, GPSInfoIFDPointer);
        propertyChangeSupport.firePropertyChange("GPSInfoIFDPointerAvailable", oldPropAvailable, isGPSInfoIFDPointerAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getGPSInfoIFDPointer()
      {
        return getObject(GPS_INFO_IFD_POINTER, Long.class);
      }

    public void setGPSInfoIFDPointerAvailable (final boolean available)
      {
        final Long oldValue = getGPSInfoIFDPointer();
        final boolean oldPropAvailable = isGPSInfoIFDPointerAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(GPS_INFO_IFD_POINTER))
          {
            setObject(GPS_INFO_IFD_POINTER, null);
          }
        else if (!available)
          {
            removeTag(GPS_INFO_IFD_POINTER);
          }

        propertyChangeSupport.firePropertyChange("GPSInfoIFDPointerAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("GPSInfoIFDPointer", oldValue, getGPSInfoIFDPointer());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isGPSInfoIFDPointerAvailable()
      {
        return containsTag(GPS_INFO_IFD_POINTER);
      }

    public void setISOSpeedRatings (final Integer ISOSpeedRatings)
      {
        final Integer oldValue = getISOSpeedRatings();
        final boolean oldPropAvailable = isISOSpeedRatingsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ISO_SPEED_RATINGS, ISOSpeedRatings);
        propertyChangeSupport.firePropertyChange("ISOSpeedRatings", oldValue, ISOSpeedRatings);
        propertyChangeSupport.firePropertyChange("ISOSpeedRatingsAvailable", oldPropAvailable, isISOSpeedRatingsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getISOSpeedRatings()
      {
        return getObject(ISO_SPEED_RATINGS, Integer.class);
      }

    public void setISOSpeedRatingsAvailable (final boolean available)
      {
        final Integer oldValue = getISOSpeedRatings();
        final boolean oldPropAvailable = isISOSpeedRatingsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ISO_SPEED_RATINGS))
          {
            setObject(ISO_SPEED_RATINGS, null);
          }
        else if (!available)
          {
            removeTag(ISO_SPEED_RATINGS);
          }

        propertyChangeSupport.firePropertyChange("ISOSpeedRatingsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("ISOSpeedRatings", oldValue, getISOSpeedRatings());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isISOSpeedRatingsAvailable()
      {
        return containsTag(ISO_SPEED_RATINGS);
      }

    public void setOECF (final byte[] OECF)
      {
        final byte[] oldValue = getOECF();
        final boolean oldPropAvailable = isOECFAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.OECF, OECF);
        propertyChangeSupport.firePropertyChange("OECF", oldValue, OECF);
        propertyChangeSupport.firePropertyChange("OECFAvailable", oldPropAvailable, isOECFAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getOECF()
      {
        return getObject(OECF, byte[].class);
      }

    public void setOECFAvailable (final boolean available)
      {
        final byte[] oldValue = getOECF();
        final boolean oldPropAvailable = isOECFAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OECF))
          {
            setObject(OECF, null);
          }
        else if (!available)
          {
            removeTag(OECF);
          }

        propertyChangeSupport.firePropertyChange("OECFAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("OECF", oldValue, getOECF());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isOECFAvailable()
      {
        return containsTag(OECF);
      }

    public void setInterlace (final Integer interlace)
      {
        final Integer oldValue = getInterlace();
        final boolean oldPropAvailable = isInterlaceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.INTERLACE, interlace);
        propertyChangeSupport.firePropertyChange("interlace", oldValue, interlace);
        propertyChangeSupport.firePropertyChange("interlaceAvailable", oldPropAvailable, isInterlaceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getInterlace()
      {
        return getObject(INTERLACE, Integer.class);
      }

    public void setInterlaceAvailable (final boolean available)
      {
        final Integer oldValue = getInterlace();
        final boolean oldPropAvailable = isInterlaceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(INTERLACE))
          {
            setObject(INTERLACE, null);
          }
        else if (!available)
          {
            removeTag(INTERLACE);
          }

        propertyChangeSupport.firePropertyChange("interlaceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("interlace", oldValue, getInterlace());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isInterlaceAvailable()
      {
        return containsTag(INTERLACE);
      }

    public void setTimeZoneOffset (final int[] timeZoneOffset)
      {
        final int[] oldValue = getTimeZoneOffset();
        final boolean oldPropAvailable = isTimeZoneOffsetAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TIME_ZONE_OFFSET, timeZoneOffset);
        propertyChangeSupport.firePropertyChange("timeZoneOffset", oldValue, timeZoneOffset);
        propertyChangeSupport.firePropertyChange("timeZoneOffsetAvailable", oldPropAvailable, isTimeZoneOffsetAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getTimeZoneOffset()
      {
        return getObject(TIME_ZONE_OFFSET, int[].class);
      }

    public void setTimeZoneOffsetAvailable (final boolean available)
      {
        final int[] oldValue = getTimeZoneOffset();
        final boolean oldPropAvailable = isTimeZoneOffsetAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TIME_ZONE_OFFSET))
          {
            setObject(TIME_ZONE_OFFSET, null);
          }
        else if (!available)
          {
            removeTag(TIME_ZONE_OFFSET);
          }

        propertyChangeSupport.firePropertyChange("timeZoneOffsetAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("timeZoneOffset", oldValue, getTimeZoneOffset());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTimeZoneOffsetAvailable()
      {
        return containsTag(TIME_ZONE_OFFSET);
      }

    public void setSelfTimerMode (final Integer selfTimerMode)
      {
        final Integer oldValue = getSelfTimerMode();
        final boolean oldPropAvailable = isSelfTimerModeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SELF_TIMER_MODE, selfTimerMode);
        propertyChangeSupport.firePropertyChange("selfTimerMode", oldValue, selfTimerMode);
        propertyChangeSupport.firePropertyChange("selfTimerModeAvailable", oldPropAvailable, isSelfTimerModeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getSelfTimerMode()
      {
        return getObject(SELF_TIMER_MODE, Integer.class);
      }

    public void setSelfTimerModeAvailable (final boolean available)
      {
        final Integer oldValue = getSelfTimerMode();
        final boolean oldPropAvailable = isSelfTimerModeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SELF_TIMER_MODE))
          {
            setObject(SELF_TIMER_MODE, null);
          }
        else if (!available)
          {
            removeTag(SELF_TIMER_MODE);
          }

        propertyChangeSupport.firePropertyChange("selfTimerModeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("selfTimerMode", oldValue, getSelfTimerMode());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSelfTimerModeAvailable()
      {
        return containsTag(SELF_TIMER_MODE);
      }

    public void setEXIFVersion (final byte[] EXIFVersion)
      {
        final byte[] oldValue = getEXIFVersion();
        final boolean oldPropAvailable = isEXIFVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXIF_VERSION, EXIFVersion);
        propertyChangeSupport.firePropertyChange("EXIFVersion", oldValue, EXIFVersion);
        propertyChangeSupport.firePropertyChange("EXIFVersionAvailable", oldPropAvailable, isEXIFVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getEXIFVersion()
      {
        return getObject(EXIF_VERSION, byte[].class);
      }

    public void setEXIFVersionAvailable (final boolean available)
      {
        final byte[] oldValue = getEXIFVersion();
        final boolean oldPropAvailable = isEXIFVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXIF_VERSION))
          {
            setObject(EXIF_VERSION, null);
          }
        else if (!available)
          {
            removeTag(EXIF_VERSION);
          }

        propertyChangeSupport.firePropertyChange("EXIFVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("EXIFVersion", oldValue, getEXIFVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isEXIFVersionAvailable()
      {
        return containsTag(EXIF_VERSION);
      }

    public void setDateTimeOriginal (final String dateTimeOriginal)
      {
        final String oldValue = getDateTimeOriginal();
        final boolean oldPropAvailable = isDateTimeOriginalAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DATETIME_ORIGINAL, dateTimeOriginal);
        propertyChangeSupport.firePropertyChange("dateTimeOriginal", oldValue, dateTimeOriginal);
        propertyChangeSupport.firePropertyChange("dateTimeOriginalAvailable", oldPropAvailable, isDateTimeOriginalAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getDateTimeOriginal()
      {
        return getObject(DATETIME_ORIGINAL, String.class);
      }

    public void setDateTimeOriginalAvailable (final boolean available)
      {
        final String oldValue = getDateTimeOriginal();
        final boolean oldPropAvailable = isDateTimeOriginalAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DATETIME_ORIGINAL))
          {
            setObject(DATETIME_ORIGINAL, null);
          }
        else if (!available)
          {
            removeTag(DATETIME_ORIGINAL);
          }

        propertyChangeSupport.firePropertyChange("dateTimeOriginalAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("dateTimeOriginal", oldValue, getDateTimeOriginal());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDateTimeOriginalAvailable()
      {
        return containsTag(DATETIME_ORIGINAL);
      }

    public void setDateTimeDigitized (final String dateTimeDigitized)
      {
        final String oldValue = getDateTimeDigitized();
        final boolean oldPropAvailable = isDateTimeDigitizedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DATETIME_DIGITIZED, dateTimeDigitized);
        propertyChangeSupport.firePropertyChange("dateTimeDigitized", oldValue, dateTimeDigitized);
        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAvailable", oldPropAvailable, isDateTimeDigitizedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getDateTimeDigitized()
      {
        return getObject(DATETIME_DIGITIZED, String.class);
      }

    public void setDateTimeDigitizedAvailable (final boolean available)
      {
        final String oldValue = getDateTimeDigitized();
        final boolean oldPropAvailable = isDateTimeDigitizedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DATETIME_DIGITIZED))
          {
            setObject(DATETIME_DIGITIZED, null);
          }
        else if (!available)
          {
            removeTag(DATETIME_DIGITIZED);
          }

        propertyChangeSupport.firePropertyChange("dateTimeDigitizedAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("dateTimeDigitized", oldValue, getDateTimeDigitized());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDateTimeDigitizedAvailable()
      {
        return containsTag(DATETIME_DIGITIZED);
      }

    public void setComponentConfiguration (final byte[] componentConfiguration)
      {
        final byte[] oldValue = getComponentConfiguration();
        final boolean oldPropAvailable = isComponentConfigurationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COMPONENT_CONFIGURATION, componentConfiguration);
        propertyChangeSupport.firePropertyChange("componentConfiguration", oldValue, componentConfiguration);
        propertyChangeSupport.firePropertyChange("componentConfigurationAvailable", oldPropAvailable, isComponentConfigurationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getComponentConfiguration()
      {
        return getObject(COMPONENT_CONFIGURATION, byte[].class);
      }

    public void setComponentConfigurationAvailable (final boolean available)
      {
        final byte[] oldValue = getComponentConfiguration();
        final boolean oldPropAvailable = isComponentConfigurationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COMPONENT_CONFIGURATION))
          {
            setObject(COMPONENT_CONFIGURATION, null);
          }
        else if (!available)
          {
            removeTag(COMPONENT_CONFIGURATION);
          }

        propertyChangeSupport.firePropertyChange("componentConfigurationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("componentConfiguration", oldValue, getComponentConfiguration());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isComponentConfigurationAvailable()
      {
        return containsTag(COMPONENT_CONFIGURATION);
      }

    public void setCompressedBitsPerPixel (final Rational compressedBitsPerPixel)
      {
        final Rational oldValue = getCompressedBitsPerPixel();
        final boolean oldPropAvailable = isCompressedBitsPerPixelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COMPRESSED_BITS_PER_PIXEL, compressedBitsPerPixel);
        propertyChangeSupport.firePropertyChange("compressedBitsPerPixel", oldValue, compressedBitsPerPixel);
        propertyChangeSupport.firePropertyChange("compressedBitsPerPixelAvailable", oldPropAvailable, isCompressedBitsPerPixelAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getCompressedBitsPerPixel()
      {
        return getObject(COMPRESSED_BITS_PER_PIXEL, Rational.class);
      }

    public void setCompressedBitsPerPixelAvailable (final boolean available)
      {
        final Rational oldValue = getCompressedBitsPerPixel();
        final boolean oldPropAvailable = isCompressedBitsPerPixelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COMPRESSED_BITS_PER_PIXEL))
          {
            setObject(COMPRESSED_BITS_PER_PIXEL, null);
          }
        else if (!available)
          {
            removeTag(COMPRESSED_BITS_PER_PIXEL);
          }

        propertyChangeSupport.firePropertyChange("compressedBitsPerPixelAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("compressedBitsPerPixel", oldValue, getCompressedBitsPerPixel());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCompressedBitsPerPixelAvailable()
      {
        return containsTag(COMPRESSED_BITS_PER_PIXEL);
      }

    public void setShutterSpeedValue (final Rational shutterSpeedValue)
      {
        final Rational oldValue = getShutterSpeedValue();
        final boolean oldPropAvailable = isShutterSpeedValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SHUTTER_SPEEDVALUE, shutterSpeedValue);
        propertyChangeSupport.firePropertyChange("shutterSpeedValue", oldValue, shutterSpeedValue);
        propertyChangeSupport.firePropertyChange("shutterSpeedValueAvailable", oldPropAvailable, isShutterSpeedValueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getShutterSpeedValue()
      {
        return getObject(SHUTTER_SPEEDVALUE, Rational.class);
      }

    public void setShutterSpeedValueAvailable (final boolean available)
      {
        final Rational oldValue = getShutterSpeedValue();
        final boolean oldPropAvailable = isShutterSpeedValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SHUTTER_SPEEDVALUE))
          {
            setObject(SHUTTER_SPEEDVALUE, null);
          }
        else if (!available)
          {
            removeTag(SHUTTER_SPEEDVALUE);
          }

        propertyChangeSupport.firePropertyChange("shutterSpeedValueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("shutterSpeedValue", oldValue, getShutterSpeedValue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isShutterSpeedValueAvailable()
      {
        return containsTag(SHUTTER_SPEEDVALUE);
      }

    public void setApertureValue (final Rational apertureValue)
      {
        final Rational oldValue = getApertureValue();
        final boolean oldPropAvailable = isApertureValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.APERTURE_VALUE, apertureValue);
        propertyChangeSupport.firePropertyChange("apertureValue", oldValue, apertureValue);
        propertyChangeSupport.firePropertyChange("apertureValueAvailable", oldPropAvailable, isApertureValueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getApertureValue()
      {
        return getObject(APERTURE_VALUE, Rational.class);
      }

    public void setApertureValueAvailable (final boolean available)
      {
        final Rational oldValue = getApertureValue();
        final boolean oldPropAvailable = isApertureValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(APERTURE_VALUE))
          {
            setObject(APERTURE_VALUE, null);
          }
        else if (!available)
          {
            removeTag(APERTURE_VALUE);
          }

        propertyChangeSupport.firePropertyChange("apertureValueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("apertureValue", oldValue, getApertureValue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isApertureValueAvailable()
      {
        return containsTag(APERTURE_VALUE);
      }

    public void setBrightnessValue (final Rational brightnessValue)
      {
        final Rational oldValue = getBrightnessValue();
        final boolean oldPropAvailable = isBrightnessValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BRIGHTNESS_VALUE, brightnessValue);
        propertyChangeSupport.firePropertyChange("brightnessValue", oldValue, brightnessValue);
        propertyChangeSupport.firePropertyChange("brightnessValueAvailable", oldPropAvailable, isBrightnessValueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getBrightnessValue()
      {
        return getObject(BRIGHTNESS_VALUE, Rational.class);
      }

    public void setBrightnessValueAvailable (final boolean available)
      {
        final Rational oldValue = getBrightnessValue();
        final boolean oldPropAvailable = isBrightnessValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BRIGHTNESS_VALUE))
          {
            setObject(BRIGHTNESS_VALUE, null);
          }
        else if (!available)
          {
            removeTag(BRIGHTNESS_VALUE);
          }

        propertyChangeSupport.firePropertyChange("brightnessValueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("brightnessValue", oldValue, getBrightnessValue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBrightnessValueAvailable()
      {
        return containsTag(BRIGHTNESS_VALUE);
      }

    public void setExposureBiasValue (final Rational exposureBiasValue)
      {
        final Rational oldValue = getExposureBiasValue();
        final boolean oldPropAvailable = isExposureBiasValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXPOSURE_BIAS_VALUE, exposureBiasValue);
        propertyChangeSupport.firePropertyChange("exposureBiasValue", oldValue, exposureBiasValue);
        propertyChangeSupport.firePropertyChange("exposureBiasValueAvailable", oldPropAvailable, isExposureBiasValueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getExposureBiasValue()
      {
        return getObject(EXPOSURE_BIAS_VALUE, Rational.class);
      }

    public void setExposureBiasValueAvailable (final boolean available)
      {
        final Rational oldValue = getExposureBiasValue();
        final boolean oldPropAvailable = isExposureBiasValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXPOSURE_BIAS_VALUE))
          {
            setObject(EXPOSURE_BIAS_VALUE, null);
          }
        else if (!available)
          {
            removeTag(EXPOSURE_BIAS_VALUE);
          }

        propertyChangeSupport.firePropertyChange("exposureBiasValueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("exposureBiasValue", oldValue, getExposureBiasValue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExposureBiasValueAvailable()
      {
        return containsTag(EXPOSURE_BIAS_VALUE);
      }

    public void setMaxApertureValue (final Rational maxApertureValue)
      {
        final Rational oldValue = getMaxApertureValue();
        final boolean oldPropAvailable = isMaxApertureValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MAX_APERTURE_VALUE, maxApertureValue);
        propertyChangeSupport.firePropertyChange("maxApertureValue", oldValue, maxApertureValue);
        propertyChangeSupport.firePropertyChange("maxApertureValueAvailable", oldPropAvailable, isMaxApertureValueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getMaxApertureValue()
      {
        return getObject(MAX_APERTURE_VALUE, Rational.class);
      }

    public void setMaxApertureValueAvailable (final boolean available)
      {
        final Rational oldValue = getMaxApertureValue();
        final boolean oldPropAvailable = isMaxApertureValueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MAX_APERTURE_VALUE))
          {
            setObject(MAX_APERTURE_VALUE, null);
          }
        else if (!available)
          {
            removeTag(MAX_APERTURE_VALUE);
          }

        propertyChangeSupport.firePropertyChange("maxApertureValueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("maxApertureValue", oldValue, getMaxApertureValue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isMaxApertureValueAvailable()
      {
        return containsTag(MAX_APERTURE_VALUE);
      }

    public void setSubjectDistance (final Rational subjectDistance)
      {
        final Rational oldValue = getSubjectDistance();
        final boolean oldPropAvailable = isSubjectDistanceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUBJECT_DISTANCE, subjectDistance);
        propertyChangeSupport.firePropertyChange("subjectDistance", oldValue, subjectDistance);
        propertyChangeSupport.firePropertyChange("subjectDistanceAvailable", oldPropAvailable, isSubjectDistanceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getSubjectDistance()
      {
        return getObject(SUBJECT_DISTANCE, Rational.class);
      }

    public void setSubjectDistanceAvailable (final boolean available)
      {
        final Rational oldValue = getSubjectDistance();
        final boolean oldPropAvailable = isSubjectDistanceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUBJECT_DISTANCE))
          {
            setObject(SUBJECT_DISTANCE, null);
          }
        else if (!available)
          {
            removeTag(SUBJECT_DISTANCE);
          }

        propertyChangeSupport.firePropertyChange("subjectDistanceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subjectDistance", oldValue, getSubjectDistance());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubjectDistanceAvailable()
      {
        return containsTag(SUBJECT_DISTANCE);
      }

    public static enum MeteringMode
       {
         UNKNOWN(0, "unknown"),
         AVERAGE(1, "average"),
         CENTER_WEIGHTED_AVERAGE(2, "center weighted average"),
         SPOT(3, "spot"),
         MULTISPOT(4, "multispot"),
         PATTERN(5, "pattern"),
         PARTIAL(6, "partial"),
         OTHER(255, "other"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private MeteringMode (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static MeteringMode fromInteger (int value)
           {
             if (value == 0) return UNKNOWN;
             if (value == 1) return AVERAGE;
             if (value == 2) return CENTER_WEIGHTED_AVERAGE;
             if (value == 3) return SPOT;
             if (value == 4) return MULTISPOT;
             if (value == 5) return PATTERN;
             if (value == 6) return PARTIAL;
             if (value == 255) return OTHER;

             return _UNKNOWN;
           }
       }
    public void setMeteringMode (final MeteringMode meteringMode)
      {
        final MeteringMode oldValue = getMeteringMode();
        final boolean oldPropAvailable = isMeteringModeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.METERING_MODE, meteringMode);
        propertyChangeSupport.firePropertyChange("meteringMode", oldValue, meteringMode);
        propertyChangeSupport.firePropertyChange("meteringModeAvailable", oldPropAvailable, isMeteringModeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public MeteringMode getMeteringMode()
      {
        return getObject(METERING_MODE, MeteringMode.class);
      }

    public void setMeteringModeAvailable (final boolean available)
      {
        final MeteringMode oldValue = getMeteringMode();
        final boolean oldPropAvailable = isMeteringModeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(METERING_MODE))
          {
            setObject(METERING_MODE, null);
          }
        else if (!available)
          {
            removeTag(METERING_MODE);
          }

        propertyChangeSupport.firePropertyChange("meteringModeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("meteringMode", oldValue, getMeteringMode());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isMeteringModeAvailable()
      {
        return containsTag(METERING_MODE);
      }

    public static enum LightSource
       {
         UNKNOWN(0, "unknown"),
         DAYLIGHT(1, "Daylight"),
         FLUORESCENT(2, "Fluorescent"),
         TUNGSTEN(3, "Tungsten"),
         FLASH(4, "Flash"),
         FINE_WEATHER(9, "Fine weather"),
         CLOUDY_WEATHER(10, "Cloudy weather"),
         SHADE(11, "Shade"),
         DAYLIGHT_FLUORESCENT(12, "Daylight fluorescent"),
         DAY_WHITE_FLUORESCENT(13, "Day white fluorescent"),
         COOL_WHITE_FLUORESCENT(14, "Cool white fluorescent"),
         WHITE_FLUORESCENT(15, "White fluorescent"),
         STANDARD_LIGHT_A(17, "Standard light A"),
         STANDARD_LIGHT_B(18, "Standard light B"),
         STANDARD_LIGHT_C(19, "Standard light C"),
         D55(20, "D55"),
         D65(21, "D65"),
         D75(22, "D75"),
         D50(23, "D50"),
         ISO_STUDIO_TUNGSTEN(24, "ISO studio tungsten"),
         OTHER_LIGHT_SOURCE(255, "other light source"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private LightSource (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static LightSource fromInteger (int value)
           {
             if (value == 0) return UNKNOWN;
             if (value == 1) return DAYLIGHT;
             if (value == 2) return FLUORESCENT;
             if (value == 3) return TUNGSTEN;
             if (value == 4) return FLASH;
             if (value == 9) return FINE_WEATHER;
             if (value == 10) return CLOUDY_WEATHER;
             if (value == 11) return SHADE;
             if (value == 12) return DAYLIGHT_FLUORESCENT;
             if (value == 13) return DAY_WHITE_FLUORESCENT;
             if (value == 14) return COOL_WHITE_FLUORESCENT;
             if (value == 15) return WHITE_FLUORESCENT;
             if (value == 17) return STANDARD_LIGHT_A;
             if (value == 18) return STANDARD_LIGHT_B;
             if (value == 19) return STANDARD_LIGHT_C;
             if (value == 20) return D55;
             if (value == 21) return D65;
             if (value == 22) return D75;
             if (value == 23) return D50;
             if (value == 24) return ISO_STUDIO_TUNGSTEN;
             if (value == 255) return OTHER_LIGHT_SOURCE;

             return _UNKNOWN;
           }
       }
    public void setLightSource (final LightSource lightSource)
      {
        final LightSource oldValue = getLightSource();
        final boolean oldPropAvailable = isLightSourceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.LIGHT_SOURCE, lightSource);
        propertyChangeSupport.firePropertyChange("lightSource", oldValue, lightSource);
        propertyChangeSupport.firePropertyChange("lightSourceAvailable", oldPropAvailable, isLightSourceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public LightSource getLightSource()
      {
        return getObject(LIGHT_SOURCE, LightSource.class);
      }

    public void setLightSourceAvailable (final boolean available)
      {
        final LightSource oldValue = getLightSource();
        final boolean oldPropAvailable = isLightSourceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(LIGHT_SOURCE))
          {
            setObject(LIGHT_SOURCE, null);
          }
        else if (!available)
          {
            removeTag(LIGHT_SOURCE);
          }

        propertyChangeSupport.firePropertyChange("lightSourceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("lightSource", oldValue, getLightSource());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isLightSourceAvailable()
      {
        return containsTag(LIGHT_SOURCE);
      }

    public void setFlash (final Integer flash)
      {
        final Integer oldValue = getFlash();
        final boolean oldPropAvailable = isFlashAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FLASH, flash);
        propertyChangeSupport.firePropertyChange("flash", oldValue, flash);
        propertyChangeSupport.firePropertyChange("flashAvailable", oldPropAvailable, isFlashAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getFlash()
      {
        return getObject(FLASH, Integer.class);
      }

    public void setFlashAvailable (final boolean available)
      {
        final Integer oldValue = getFlash();
        final boolean oldPropAvailable = isFlashAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FLASH))
          {
            setObject(FLASH, null);
          }
        else if (!available)
          {
            removeTag(FLASH);
          }

        propertyChangeSupport.firePropertyChange("flashAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("flash", oldValue, getFlash());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFlashAvailable()
      {
        return containsTag(FLASH);
      }

    public void setFocalLength (final Rational focalLength)
      {
        final Rational oldValue = getFocalLength();
        final boolean oldPropAvailable = isFocalLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FOCAL_LENGTH, focalLength);
        propertyChangeSupport.firePropertyChange("focalLength", oldValue, focalLength);
        propertyChangeSupport.firePropertyChange("focalLengthAvailable", oldPropAvailable, isFocalLengthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getFocalLength()
      {
        return getObject(FOCAL_LENGTH, Rational.class);
      }

    public void setFocalLengthAvailable (final boolean available)
      {
        final Rational oldValue = getFocalLength();
        final boolean oldPropAvailable = isFocalLengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FOCAL_LENGTH))
          {
            setObject(FOCAL_LENGTH, null);
          }
        else if (!available)
          {
            removeTag(FOCAL_LENGTH);
          }

        propertyChangeSupport.firePropertyChange("focalLengthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("focalLength", oldValue, getFocalLength());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFocalLengthAvailable()
      {
        return containsTag(FOCAL_LENGTH);
      }

    public void setFlashEnergy2 (final Rational[] flashEnergy2)
      {
        final Rational[] oldValue = getFlashEnergy2();
        final boolean oldPropAvailable = isFlashEnergy2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FLASH_ENERGY2, flashEnergy2);
        propertyChangeSupport.firePropertyChange("flashEnergy2", oldValue, flashEnergy2);
        propertyChangeSupport.firePropertyChange("flashEnergy2Available", oldPropAvailable, isFlashEnergy2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getFlashEnergy2()
      {
        return getObject(FLASH_ENERGY2, Rational[].class);
      }

    public void setFlashEnergy2Available (final boolean available)
      {
        final Rational[] oldValue = getFlashEnergy2();
        final boolean oldPropAvailable = isFlashEnergy2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FLASH_ENERGY2))
          {
            setObject(FLASH_ENERGY2, null);
          }
        else if (!available)
          {
            removeTag(FLASH_ENERGY2);
          }

        propertyChangeSupport.firePropertyChange("flashEnergy2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("flashEnergy2", oldValue, getFlashEnergy2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFlashEnergy2Available()
      {
        return containsTag(FLASH_ENERGY2);
      }

    public void setSpatialFrequencyResponse2 (final byte[] spatialFrequencyResponse2)
      {
        final byte[] oldValue = getSpatialFrequencyResponse2();
        final boolean oldPropAvailable = isSpatialFrequencyResponse2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SPATIAL_FREQUENCYRESPONSE2, spatialFrequencyResponse2);
        propertyChangeSupport.firePropertyChange("spatialFrequencyResponse2", oldValue, spatialFrequencyResponse2);
        propertyChangeSupport.firePropertyChange("spatialFrequencyResponse2Available", oldPropAvailable, isSpatialFrequencyResponse2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getSpatialFrequencyResponse2()
      {
        return getObject(SPATIAL_FREQUENCYRESPONSE2, byte[].class);
      }

    public void setSpatialFrequencyResponse2Available (final boolean available)
      {
        final byte[] oldValue = getSpatialFrequencyResponse2();
        final boolean oldPropAvailable = isSpatialFrequencyResponse2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SPATIAL_FREQUENCYRESPONSE2))
          {
            setObject(SPATIAL_FREQUENCYRESPONSE2, null);
          }
        else if (!available)
          {
            removeTag(SPATIAL_FREQUENCYRESPONSE2);
          }

        propertyChangeSupport.firePropertyChange("spatialFrequencyResponse2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("spatialFrequencyResponse2", oldValue, getSpatialFrequencyResponse2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSpatialFrequencyResponse2Available()
      {
        return containsTag(SPATIAL_FREQUENCYRESPONSE2);
      }

    public void setNoise (final byte[] noise)
      {
        final byte[] oldValue = getNoise();
        final boolean oldPropAvailable = isNoiseAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.NOISE, noise);
        propertyChangeSupport.firePropertyChange("noise", oldValue, noise);
        propertyChangeSupport.firePropertyChange("noiseAvailable", oldPropAvailable, isNoiseAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getNoise()
      {
        return getObject(NOISE, byte[].class);
      }

    public void setNoiseAvailable (final boolean available)
      {
        final byte[] oldValue = getNoise();
        final boolean oldPropAvailable = isNoiseAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(NOISE))
          {
            setObject(NOISE, null);
          }
        else if (!available)
          {
            removeTag(NOISE);
          }

        propertyChangeSupport.firePropertyChange("noiseAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("noise", oldValue, getNoise());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isNoiseAvailable()
      {
        return containsTag(NOISE);
      }

    public void setFocalPlaneXResolution2 (final Rational focalPlaneXResolution2)
      {
        final Rational oldValue = getFocalPlaneXResolution2();
        final boolean oldPropAvailable = isFocalPlaneXResolution2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FOCAL_PLANEXRESOLUTION2, focalPlaneXResolution2);
        propertyChangeSupport.firePropertyChange("focalPlaneXResolution2", oldValue, focalPlaneXResolution2);
        propertyChangeSupport.firePropertyChange("focalPlaneXResolution2Available", oldPropAvailable, isFocalPlaneXResolution2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getFocalPlaneXResolution2()
      {
        return getObject(FOCAL_PLANEXRESOLUTION2, Rational.class);
      }

    public void setFocalPlaneXResolution2Available (final boolean available)
      {
        final Rational oldValue = getFocalPlaneXResolution2();
        final boolean oldPropAvailable = isFocalPlaneXResolution2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FOCAL_PLANEXRESOLUTION2))
          {
            setObject(FOCAL_PLANEXRESOLUTION2, null);
          }
        else if (!available)
          {
            removeTag(FOCAL_PLANEXRESOLUTION2);
          }

        propertyChangeSupport.firePropertyChange("focalPlaneXResolution2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("focalPlaneXResolution2", oldValue, getFocalPlaneXResolution2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFocalPlaneXResolution2Available()
      {
        return containsTag(FOCAL_PLANEXRESOLUTION2);
      }

    public void setFocalPlaneYResolution2 (final Rational focalPlaneYResolution2)
      {
        final Rational oldValue = getFocalPlaneYResolution2();
        final boolean oldPropAvailable = isFocalPlaneYResolution2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FOCAL_PLANEYRESOLUTION2, focalPlaneYResolution2);
        propertyChangeSupport.firePropertyChange("focalPlaneYResolution2", oldValue, focalPlaneYResolution2);
        propertyChangeSupport.firePropertyChange("focalPlaneYResolution2Available", oldPropAvailable, isFocalPlaneYResolution2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getFocalPlaneYResolution2()
      {
        return getObject(FOCAL_PLANEYRESOLUTION2, Rational.class);
      }

    public void setFocalPlaneYResolution2Available (final boolean available)
      {
        final Rational oldValue = getFocalPlaneYResolution2();
        final boolean oldPropAvailable = isFocalPlaneYResolution2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FOCAL_PLANEYRESOLUTION2))
          {
            setObject(FOCAL_PLANEYRESOLUTION2, null);
          }
        else if (!available)
          {
            removeTag(FOCAL_PLANEYRESOLUTION2);
          }

        propertyChangeSupport.firePropertyChange("focalPlaneYResolution2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("focalPlaneYResolution2", oldValue, getFocalPlaneYResolution2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFocalPlaneYResolution2Available()
      {
        return containsTag(FOCAL_PLANEYRESOLUTION2);
      }

    public void setFocalPlaneResolutionUnit2 (final Integer focalPlaneResolutionUnit2)
      {
        final Integer oldValue = getFocalPlaneResolutionUnit2();
        final boolean oldPropAvailable = isFocalPlaneResolutionUnit2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FOCAL_PLANERESOLUTIONUNIT2, focalPlaneResolutionUnit2);
        propertyChangeSupport.firePropertyChange("focalPlaneResolutionUnit2", oldValue, focalPlaneResolutionUnit2);
        propertyChangeSupport.firePropertyChange("focalPlaneResolutionUnit2Available", oldPropAvailable, isFocalPlaneResolutionUnit2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getFocalPlaneResolutionUnit2()
      {
        return getObject(FOCAL_PLANERESOLUTIONUNIT2, Integer.class);
      }

    public void setFocalPlaneResolutionUnit2Available (final boolean available)
      {
        final Integer oldValue = getFocalPlaneResolutionUnit2();
        final boolean oldPropAvailable = isFocalPlaneResolutionUnit2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FOCAL_PLANERESOLUTIONUNIT2))
          {
            setObject(FOCAL_PLANERESOLUTIONUNIT2, null);
          }
        else if (!available)
          {
            removeTag(FOCAL_PLANERESOLUTIONUNIT2);
          }

        propertyChangeSupport.firePropertyChange("focalPlaneResolutionUnit2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("focalPlaneResolutionUnit2", oldValue, getFocalPlaneResolutionUnit2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFocalPlaneResolutionUnit2Available()
      {
        return containsTag(FOCAL_PLANERESOLUTIONUNIT2);
      }

    public void setImageNumber (final Long imageNumber)
      {
        final Long oldValue = getImageNumber();
        final boolean oldPropAvailable = isImageNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_NUMBER, imageNumber);
        propertyChangeSupport.firePropertyChange("imageNumber", oldValue, imageNumber);
        propertyChangeSupport.firePropertyChange("imageNumberAvailable", oldPropAvailable, isImageNumberAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getImageNumber()
      {
        return getObject(IMAGE_NUMBER, Long.class);
      }

    public void setImageNumberAvailable (final boolean available)
      {
        final Long oldValue = getImageNumber();
        final boolean oldPropAvailable = isImageNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_NUMBER))
          {
            setObject(IMAGE_NUMBER, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_NUMBER);
          }

        propertyChangeSupport.firePropertyChange("imageNumberAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageNumber", oldValue, getImageNumber());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageNumberAvailable()
      {
        return containsTag(IMAGE_NUMBER);
      }

    public void setSecurityClassification (final String securityClassification)
      {
        final String oldValue = getSecurityClassification();
        final boolean oldPropAvailable = isSecurityClassificationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SECURITY_CLASSIFICATION, securityClassification);
        propertyChangeSupport.firePropertyChange("securityClassification", oldValue, securityClassification);
        propertyChangeSupport.firePropertyChange("securityClassificationAvailable", oldPropAvailable, isSecurityClassificationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSecurityClassification()
      {
        return getObject(SECURITY_CLASSIFICATION, String.class);
      }

    public void setSecurityClassificationAvailable (final boolean available)
      {
        final String oldValue = getSecurityClassification();
        final boolean oldPropAvailable = isSecurityClassificationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SECURITY_CLASSIFICATION))
          {
            setObject(SECURITY_CLASSIFICATION, null);
          }
        else if (!available)
          {
            removeTag(SECURITY_CLASSIFICATION);
          }

        propertyChangeSupport.firePropertyChange("securityClassificationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("securityClassification", oldValue, getSecurityClassification());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSecurityClassificationAvailable()
      {
        return containsTag(SECURITY_CLASSIFICATION);
      }

    public void setImageHistory (final String imageHistory)
      {
        final String oldValue = getImageHistory();
        final boolean oldPropAvailable = isImageHistoryAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_HISTORY, imageHistory);
        propertyChangeSupport.firePropertyChange("imageHistory", oldValue, imageHistory);
        propertyChangeSupport.firePropertyChange("imageHistoryAvailable", oldPropAvailable, isImageHistoryAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getImageHistory()
      {
        return getObject(IMAGE_HISTORY, String.class);
      }

    public void setImageHistoryAvailable (final boolean available)
      {
        final String oldValue = getImageHistory();
        final boolean oldPropAvailable = isImageHistoryAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_HISTORY))
          {
            setObject(IMAGE_HISTORY, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_HISTORY);
          }

        propertyChangeSupport.firePropertyChange("imageHistoryAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageHistory", oldValue, getImageHistory());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageHistoryAvailable()
      {
        return containsTag(IMAGE_HISTORY);
      }

    public void setSubjectArea (final int[] subjectArea)
      {
        final int[] oldValue = getSubjectArea();
        final boolean oldPropAvailable = isSubjectAreaAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUBJECT_AREA, subjectArea);
        propertyChangeSupport.firePropertyChange("subjectArea", oldValue, subjectArea);
        propertyChangeSupport.firePropertyChange("subjectAreaAvailable", oldPropAvailable, isSubjectAreaAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getSubjectArea()
      {
        return getObject(SUBJECT_AREA, int[].class);
      }

    public void setSubjectAreaAvailable (final boolean available)
      {
        final int[] oldValue = getSubjectArea();
        final boolean oldPropAvailable = isSubjectAreaAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUBJECT_AREA))
          {
            setObject(SUBJECT_AREA, null);
          }
        else if (!available)
          {
            removeTag(SUBJECT_AREA);
          }

        propertyChangeSupport.firePropertyChange("subjectAreaAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subjectArea", oldValue, getSubjectArea());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubjectAreaAvailable()
      {
        return containsTag(SUBJECT_AREA);
      }

    public void setExposureIndex2 (final Rational[] exposureIndex2)
      {
        final Rational[] oldValue = getExposureIndex2();
        final boolean oldPropAvailable = isExposureIndex2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXPOSURE_INDEX_2, exposureIndex2);
        propertyChangeSupport.firePropertyChange("exposureIndex2", oldValue, exposureIndex2);
        propertyChangeSupport.firePropertyChange("exposureIndex2Available", oldPropAvailable, isExposureIndex2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getExposureIndex2()
      {
        return getObject(EXPOSURE_INDEX_2, Rational[].class);
      }

    public void setExposureIndex2Available (final boolean available)
      {
        final Rational[] oldValue = getExposureIndex2();
        final boolean oldPropAvailable = isExposureIndex2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXPOSURE_INDEX_2))
          {
            setObject(EXPOSURE_INDEX_2, null);
          }
        else if (!available)
          {
            removeTag(EXPOSURE_INDEX_2);
          }

        propertyChangeSupport.firePropertyChange("exposureIndex2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("exposureIndex2", oldValue, getExposureIndex2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExposureIndex2Available()
      {
        return containsTag(EXPOSURE_INDEX_2);
      }

    public void setTIFF_EPStandardID (final byte[] TIFF_EPStandardID)
      {
        final byte[] oldValue = getTIFF_EPStandardID();
        final boolean oldPropAvailable = isTIFF_EPStandardIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.TIFF_EP_STANDARD_ID, TIFF_EPStandardID);
        propertyChangeSupport.firePropertyChange("TIFF_EPStandardID", oldValue, TIFF_EPStandardID);
        propertyChangeSupport.firePropertyChange("TIFF_EPStandardIDAvailable", oldPropAvailable, isTIFF_EPStandardIDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getTIFF_EPStandardID()
      {
        return getObject(TIFF_EP_STANDARD_ID, byte[].class);
      }

    public void setTIFF_EPStandardIDAvailable (final boolean available)
      {
        final byte[] oldValue = getTIFF_EPStandardID();
        final boolean oldPropAvailable = isTIFF_EPStandardIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TIFF_EP_STANDARD_ID))
          {
            setObject(TIFF_EP_STANDARD_ID, null);
          }
        else if (!available)
          {
            removeTag(TIFF_EP_STANDARD_ID);
          }

        propertyChangeSupport.firePropertyChange("TIFF_EPStandardIDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("TIFF_EPStandardID", oldValue, getTIFF_EPStandardID());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTIFF_EPStandardIDAvailable()
      {
        return containsTag(TIFF_EP_STANDARD_ID);
      }

    public static enum SensingMethod2
       {
         NOT_DEFINED(1, "Not defined"),
         ONE_CHIP_COLOR_AREA_SENSOR(2, "One-chip color area sensor"),
         TWO_CHIP_COLOR_AREA_SENSOR(3, "Two-chip color area sensor"),
         THREE_CHIP_COLOR_AREA_SENSOR(4, "Three-chip color area sensor"),
         COLOR_SEQUENTIAL_AREA_SENSOR(5, "Color sequential area sensor"),
         TRILINEAR_SENSOR(7, "Trilinear sensor"),
         COLOR_SEQUENTIAL_LINEAR_SENSOR(8, "Color sequential linear sensor"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private SensingMethod2 (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static SensingMethod2 fromInteger (int value)
           {
             if (value == 1) return NOT_DEFINED;
             if (value == 2) return ONE_CHIP_COLOR_AREA_SENSOR;
             if (value == 3) return TWO_CHIP_COLOR_AREA_SENSOR;
             if (value == 4) return THREE_CHIP_COLOR_AREA_SENSOR;
             if (value == 5) return COLOR_SEQUENTIAL_AREA_SENSOR;
             if (value == 7) return TRILINEAR_SENSOR;
             if (value == 8) return COLOR_SEQUENTIAL_LINEAR_SENSOR;

             return _UNKNOWN;
           }
       }
    public void setSensingMethod2 (final SensingMethod2 sensingMethod2)
      {
        final SensingMethod2 oldValue = getSensingMethod2();
        final boolean oldPropAvailable = isSensingMethod2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SENSING_METHOD_2, sensingMethod2);
        propertyChangeSupport.firePropertyChange("sensingMethod2", oldValue, sensingMethod2);
        propertyChangeSupport.firePropertyChange("sensingMethod2Available", oldPropAvailable, isSensingMethod2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public SensingMethod2 getSensingMethod2()
      {
        return getObject(SENSING_METHOD_2, SensingMethod2.class);
      }

    public void setSensingMethod2Available (final boolean available)
      {
        final SensingMethod2 oldValue = getSensingMethod2();
        final boolean oldPropAvailable = isSensingMethod2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SENSING_METHOD_2))
          {
            setObject(SENSING_METHOD_2, null);
          }
        else if (!available)
          {
            removeTag(SENSING_METHOD_2);
          }

        propertyChangeSupport.firePropertyChange("sensingMethod2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("sensingMethod2", oldValue, getSensingMethod2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSensingMethod2Available()
      {
        return containsTag(SENSING_METHOD_2);
      }

    public void setMakerNote (final Long makerNote)
      {
        final Long oldValue = getMakerNote();
        final boolean oldPropAvailable = isMakerNoteAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MAKER_NOTE, makerNote);
        propertyChangeSupport.firePropertyChange("makerNote", oldValue, makerNote);
        propertyChangeSupport.firePropertyChange("makerNoteAvailable", oldPropAvailable, isMakerNoteAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getMakerNote()
      {
        return getObject(MAKER_NOTE, Long.class);
      }

    public void setMakerNoteAvailable (final boolean available)
      {
        final Long oldValue = getMakerNote();
        final boolean oldPropAvailable = isMakerNoteAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MAKER_NOTE))
          {
            setObject(MAKER_NOTE, null);
          }
        else if (!available)
          {
            removeTag(MAKER_NOTE);
          }

        propertyChangeSupport.firePropertyChange("makerNoteAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("makerNote", oldValue, getMakerNote());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isMakerNoteAvailable()
      {
        return containsTag(MAKER_NOTE);
      }

    public void setUserComment (final byte[] userComment)
      {
        final byte[] oldValue = getUserComment();
        final boolean oldPropAvailable = isUserCommentAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.USER_COMMENT, userComment);
        propertyChangeSupport.firePropertyChange("userComment", oldValue, userComment);
        propertyChangeSupport.firePropertyChange("userCommentAvailable", oldPropAvailable, isUserCommentAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getUserComment()
      {
        return getObject(USER_COMMENT, byte[].class);
      }

    public void setUserCommentAvailable (final boolean available)
      {
        final byte[] oldValue = getUserComment();
        final boolean oldPropAvailable = isUserCommentAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(USER_COMMENT))
          {
            setObject(USER_COMMENT, null);
          }
        else if (!available)
          {
            removeTag(USER_COMMENT);
          }

        propertyChangeSupport.firePropertyChange("userCommentAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("userComment", oldValue, getUserComment());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isUserCommentAvailable()
      {
        return containsTag(USER_COMMENT);
      }

    public void setSubsecTime (final String subsecTime)
      {
        final String oldValue = getSubsecTime();
        final boolean oldPropAvailable = isSubsecTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUBSEC_TIME, subsecTime);
        propertyChangeSupport.firePropertyChange("subsecTime", oldValue, subsecTime);
        propertyChangeSupport.firePropertyChange("subsecTimeAvailable", oldPropAvailable, isSubsecTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSubsecTime()
      {
        return getObject(SUBSEC_TIME, String.class);
      }

    public void setSubsecTimeAvailable (final boolean available)
      {
        final String oldValue = getSubsecTime();
        final boolean oldPropAvailable = isSubsecTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUBSEC_TIME))
          {
            setObject(SUBSEC_TIME, null);
          }
        else if (!available)
          {
            removeTag(SUBSEC_TIME);
          }

        propertyChangeSupport.firePropertyChange("subsecTimeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subsecTime", oldValue, getSubsecTime());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubsecTimeAvailable()
      {
        return containsTag(SUBSEC_TIME);
      }

    public void setSubsecTimeOriginal (final String subsecTimeOriginal)
      {
        final String oldValue = getSubsecTimeOriginal();
        final boolean oldPropAvailable = isSubsecTimeOriginalAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUBSEC_TIME_ORIGINAL, subsecTimeOriginal);
        propertyChangeSupport.firePropertyChange("subsecTimeOriginal", oldValue, subsecTimeOriginal);
        propertyChangeSupport.firePropertyChange("subsecTimeOriginalAvailable", oldPropAvailable, isSubsecTimeOriginalAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSubsecTimeOriginal()
      {
        return getObject(SUBSEC_TIME_ORIGINAL, String.class);
      }

    public void setSubsecTimeOriginalAvailable (final boolean available)
      {
        final String oldValue = getSubsecTimeOriginal();
        final boolean oldPropAvailable = isSubsecTimeOriginalAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUBSEC_TIME_ORIGINAL))
          {
            setObject(SUBSEC_TIME_ORIGINAL, null);
          }
        else if (!available)
          {
            removeTag(SUBSEC_TIME_ORIGINAL);
          }

        propertyChangeSupport.firePropertyChange("subsecTimeOriginalAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subsecTimeOriginal", oldValue, getSubsecTimeOriginal());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubsecTimeOriginalAvailable()
      {
        return containsTag(SUBSEC_TIME_ORIGINAL);
      }

    public void setSubsecTimeDigitized (final String subsecTimeDigitized)
      {
        final String oldValue = getSubsecTimeDigitized();
        final boolean oldPropAvailable = isSubsecTimeDigitizedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUBSEC_TIME_DIGITIZED, subsecTimeDigitized);
        propertyChangeSupport.firePropertyChange("subsecTimeDigitized", oldValue, subsecTimeDigitized);
        propertyChangeSupport.firePropertyChange("subsecTimeDigitizedAvailable", oldPropAvailable, isSubsecTimeDigitizedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSubsecTimeDigitized()
      {
        return getObject(SUBSEC_TIME_DIGITIZED, String.class);
      }

    public void setSubsecTimeDigitizedAvailable (final boolean available)
      {
        final String oldValue = getSubsecTimeDigitized();
        final boolean oldPropAvailable = isSubsecTimeDigitizedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUBSEC_TIME_DIGITIZED))
          {
            setObject(SUBSEC_TIME_DIGITIZED, null);
          }
        else if (!available)
          {
            removeTag(SUBSEC_TIME_DIGITIZED);
          }

        propertyChangeSupport.firePropertyChange("subsecTimeDigitizedAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subsecTimeDigitized", oldValue, getSubsecTimeDigitized());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubsecTimeDigitizedAvailable()
      {
        return containsTag(SUBSEC_TIME_DIGITIZED);
      }

    public void setImageSourceData (final byte[] imageSourceData)
      {
        final byte[] oldValue = getImageSourceData();
        final boolean oldPropAvailable = isImageSourceDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_SOURCE_DATA, imageSourceData);
        propertyChangeSupport.firePropertyChange("imageSourceData", oldValue, imageSourceData);
        propertyChangeSupport.firePropertyChange("imageSourceDataAvailable", oldPropAvailable, isImageSourceDataAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getImageSourceData()
      {
        return getObject(IMAGE_SOURCE_DATA, byte[].class);
      }

    public void setImageSourceDataAvailable (final boolean available)
      {
        final byte[] oldValue = getImageSourceData();
        final boolean oldPropAvailable = isImageSourceDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_SOURCE_DATA))
          {
            setObject(IMAGE_SOURCE_DATA, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_SOURCE_DATA);
          }

        propertyChangeSupport.firePropertyChange("imageSourceDataAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageSourceData", oldValue, getImageSourceData());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageSourceDataAvailable()
      {
        return containsTag(IMAGE_SOURCE_DATA);
      }

    public void setFlashPixVersion (final byte[] flashPixVersion)
      {
        final byte[] oldValue = getFlashPixVersion();
        final boolean oldPropAvailable = isFlashPixVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FLASHPIX_VERSION, flashPixVersion);
        propertyChangeSupport.firePropertyChange("flashPixVersion", oldValue, flashPixVersion);
        propertyChangeSupport.firePropertyChange("flashPixVersionAvailable", oldPropAvailable, isFlashPixVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getFlashPixVersion()
      {
        return getObject(FLASHPIX_VERSION, byte[].class);
      }

    public void setFlashPixVersionAvailable (final boolean available)
      {
        final byte[] oldValue = getFlashPixVersion();
        final boolean oldPropAvailable = isFlashPixVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FLASHPIX_VERSION))
          {
            setObject(FLASHPIX_VERSION, null);
          }
        else if (!available)
          {
            removeTag(FLASHPIX_VERSION);
          }

        propertyChangeSupport.firePropertyChange("flashPixVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("flashPixVersion", oldValue, getFlashPixVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFlashPixVersionAvailable()
      {
        return containsTag(FLASHPIX_VERSION);
      }

    public static enum ColorSpace
       {
         SRGB(1, "sRGB"),
         UNCALIBRATED(0xFFFF, "Uncalibrated"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private ColorSpace (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static ColorSpace fromInteger (int value)
           {
             if (value == 1) return SRGB;
             if (value == 0xFFFF) return UNCALIBRATED;

             return _UNKNOWN;
           }
       }
    public void setColorSpace (final ColorSpace colorSpace)
      {
        final ColorSpace oldValue = getColorSpace();
        final boolean oldPropAvailable = isColorSpaceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COLOR_SPACE, colorSpace);
        propertyChangeSupport.firePropertyChange("colorSpace", oldValue, colorSpace);
        propertyChangeSupport.firePropertyChange("colorSpaceAvailable", oldPropAvailable, isColorSpaceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public ColorSpace getColorSpace()
      {
        return getObject(COLOR_SPACE, ColorSpace.class);
      }

    public void setColorSpaceAvailable (final boolean available)
      {
        final ColorSpace oldValue = getColorSpace();
        final boolean oldPropAvailable = isColorSpaceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COLOR_SPACE))
          {
            setObject(COLOR_SPACE, null);
          }
        else if (!available)
          {
            removeTag(COLOR_SPACE);
          }

        propertyChangeSupport.firePropertyChange("colorSpaceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("colorSpace", oldValue, getColorSpace());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isColorSpaceAvailable()
      {
        return containsTag(COLOR_SPACE);
      }

    public void setPixelXDimension (final Integer pixelXDimension)
      {
        final Integer oldValue = getPixelXDimension();
        final boolean oldPropAvailable = isPixelXDimensionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PIXEL_X_DIMENSION, pixelXDimension);
        propertyChangeSupport.firePropertyChange("pixelXDimension", oldValue, pixelXDimension);
        propertyChangeSupport.firePropertyChange("pixelXDimensionAvailable", oldPropAvailable, isPixelXDimensionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getPixelXDimension()
      {
        return getObject(PIXEL_X_DIMENSION, Integer.class);
      }

    public void setPixelXDimensionAvailable (final boolean available)
      {
        final Integer oldValue = getPixelXDimension();
        final boolean oldPropAvailable = isPixelXDimensionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PIXEL_X_DIMENSION))
          {
            setObject(PIXEL_X_DIMENSION, null);
          }
        else if (!available)
          {
            removeTag(PIXEL_X_DIMENSION);
          }

        propertyChangeSupport.firePropertyChange("pixelXDimensionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("pixelXDimension", oldValue, getPixelXDimension());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPixelXDimensionAvailable()
      {
        return containsTag(PIXEL_X_DIMENSION);
      }

    public void setPixelYDimension (final Integer pixelYDimension)
      {
        final Integer oldValue = getPixelYDimension();
        final boolean oldPropAvailable = isPixelYDimensionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PIXEL_Y_DIMENSION, pixelYDimension);
        propertyChangeSupport.firePropertyChange("pixelYDimension", oldValue, pixelYDimension);
        propertyChangeSupport.firePropertyChange("pixelYDimensionAvailable", oldPropAvailable, isPixelYDimensionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getPixelYDimension()
      {
        return getObject(PIXEL_Y_DIMENSION, Integer.class);
      }

    public void setPixelYDimensionAvailable (final boolean available)
      {
        final Integer oldValue = getPixelYDimension();
        final boolean oldPropAvailable = isPixelYDimensionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PIXEL_Y_DIMENSION))
          {
            setObject(PIXEL_Y_DIMENSION, null);
          }
        else if (!available)
          {
            removeTag(PIXEL_Y_DIMENSION);
          }

        propertyChangeSupport.firePropertyChange("pixelYDimensionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("pixelYDimension", oldValue, getPixelYDimension());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPixelYDimensionAvailable()
      {
        return containsTag(PIXEL_Y_DIMENSION);
      }

    public void setRelatedSoundFile (final String relatedSoundFile)
      {
        final String oldValue = getRelatedSoundFile();
        final boolean oldPropAvailable = isRelatedSoundFileAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.RELATED_SOUND_FILE, relatedSoundFile);
        propertyChangeSupport.firePropertyChange("relatedSoundFile", oldValue, relatedSoundFile);
        propertyChangeSupport.firePropertyChange("relatedSoundFileAvailable", oldPropAvailable, isRelatedSoundFileAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getRelatedSoundFile()
      {
        return getObject(RELATED_SOUND_FILE, String.class);
      }

    public void setRelatedSoundFileAvailable (final boolean available)
      {
        final String oldValue = getRelatedSoundFile();
        final boolean oldPropAvailable = isRelatedSoundFileAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(RELATED_SOUND_FILE))
          {
            setObject(RELATED_SOUND_FILE, null);
          }
        else if (!available)
          {
            removeTag(RELATED_SOUND_FILE);
          }

        propertyChangeSupport.firePropertyChange("relatedSoundFileAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("relatedSoundFile", oldValue, getRelatedSoundFile());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isRelatedSoundFileAvailable()
      {
        return containsTag(RELATED_SOUND_FILE);
      }

    public void setInteroperabilityIFD (final Long interoperabilityIFD)
      {
        final Long oldValue = getInteroperabilityIFD();
        final boolean oldPropAvailable = isInteroperabilityIFDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.INTEROPERABILITY_IFD, interoperabilityIFD);
        propertyChangeSupport.firePropertyChange("interoperabilityIFD", oldValue, interoperabilityIFD);
        propertyChangeSupport.firePropertyChange("interoperabilityIFDAvailable", oldPropAvailable, isInteroperabilityIFDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getInteroperabilityIFD()
      {
        return getObject(INTEROPERABILITY_IFD, Long.class);
      }

    public void setInteroperabilityIFDAvailable (final boolean available)
      {
        final Long oldValue = getInteroperabilityIFD();
        final boolean oldPropAvailable = isInteroperabilityIFDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(INTEROPERABILITY_IFD))
          {
            setObject(INTEROPERABILITY_IFD, null);
          }
        else if (!available)
          {
            removeTag(INTEROPERABILITY_IFD);
          }

        propertyChangeSupport.firePropertyChange("interoperabilityIFDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("interoperabilityIFD", oldValue, getInteroperabilityIFD());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isInteroperabilityIFDAvailable()
      {
        return containsTag(INTEROPERABILITY_IFD);
      }

    public void setFlashEnergy (final Rational flashEnergy)
      {
        final Rational oldValue = getFlashEnergy();
        final boolean oldPropAvailable = isFlashEnergyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FLASH_ENERGY, flashEnergy);
        propertyChangeSupport.firePropertyChange("flashEnergy", oldValue, flashEnergy);
        propertyChangeSupport.firePropertyChange("flashEnergyAvailable", oldPropAvailable, isFlashEnergyAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getFlashEnergy()
      {
        return getObject(FLASH_ENERGY, Rational.class);
      }

    public void setFlashEnergyAvailable (final boolean available)
      {
        final Rational oldValue = getFlashEnergy();
        final boolean oldPropAvailable = isFlashEnergyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FLASH_ENERGY))
          {
            setObject(FLASH_ENERGY, null);
          }
        else if (!available)
          {
            removeTag(FLASH_ENERGY);
          }

        propertyChangeSupport.firePropertyChange("flashEnergyAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("flashEnergy", oldValue, getFlashEnergy());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFlashEnergyAvailable()
      {
        return containsTag(FLASH_ENERGY);
      }

    public void setSpatialFrequencyResponse (final byte[] spatialFrequencyResponse)
      {
        final byte[] oldValue = getSpatialFrequencyResponse();
        final boolean oldPropAvailable = isSpatialFrequencyResponseAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SPATIAL_FREQUENCY_RESPONSE, spatialFrequencyResponse);
        propertyChangeSupport.firePropertyChange("spatialFrequencyResponse", oldValue, spatialFrequencyResponse);
        propertyChangeSupport.firePropertyChange("spatialFrequencyResponseAvailable", oldPropAvailable, isSpatialFrequencyResponseAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getSpatialFrequencyResponse()
      {
        return getObject(SPATIAL_FREQUENCY_RESPONSE, byte[].class);
      }

    public void setSpatialFrequencyResponseAvailable (final boolean available)
      {
        final byte[] oldValue = getSpatialFrequencyResponse();
        final boolean oldPropAvailable = isSpatialFrequencyResponseAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SPATIAL_FREQUENCY_RESPONSE))
          {
            setObject(SPATIAL_FREQUENCY_RESPONSE, null);
          }
        else if (!available)
          {
            removeTag(SPATIAL_FREQUENCY_RESPONSE);
          }

        propertyChangeSupport.firePropertyChange("spatialFrequencyResponseAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("spatialFrequencyResponse", oldValue, getSpatialFrequencyResponse());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSpatialFrequencyResponseAvailable()
      {
        return containsTag(SPATIAL_FREQUENCY_RESPONSE);
      }

    public void setFocalPlaneXResolution (final Rational focalPlaneXResolution)
      {
        final Rational oldValue = getFocalPlaneXResolution();
        final boolean oldPropAvailable = isFocalPlaneXResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FOCAL_PLANE_X_RESOLUTION, focalPlaneXResolution);
        propertyChangeSupport.firePropertyChange("focalPlaneXResolution", oldValue, focalPlaneXResolution);
        propertyChangeSupport.firePropertyChange("focalPlaneXResolutionAvailable", oldPropAvailable, isFocalPlaneXResolutionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getFocalPlaneXResolution()
      {
        return getObject(FOCAL_PLANE_X_RESOLUTION, Rational.class);
      }

    public void setFocalPlaneXResolutionAvailable (final boolean available)
      {
        final Rational oldValue = getFocalPlaneXResolution();
        final boolean oldPropAvailable = isFocalPlaneXResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FOCAL_PLANE_X_RESOLUTION))
          {
            setObject(FOCAL_PLANE_X_RESOLUTION, null);
          }
        else if (!available)
          {
            removeTag(FOCAL_PLANE_X_RESOLUTION);
          }

        propertyChangeSupport.firePropertyChange("focalPlaneXResolutionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("focalPlaneXResolution", oldValue, getFocalPlaneXResolution());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFocalPlaneXResolutionAvailable()
      {
        return containsTag(FOCAL_PLANE_X_RESOLUTION);
      }

    public void setFocalPlaneYResolution (final Rational focalPlaneYResolution)
      {
        final Rational oldValue = getFocalPlaneYResolution();
        final boolean oldPropAvailable = isFocalPlaneYResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FOCAL_PLANE_Y_RESOLUTION, focalPlaneYResolution);
        propertyChangeSupport.firePropertyChange("focalPlaneYResolution", oldValue, focalPlaneYResolution);
        propertyChangeSupport.firePropertyChange("focalPlaneYResolutionAvailable", oldPropAvailable, isFocalPlaneYResolutionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getFocalPlaneYResolution()
      {
        return getObject(FOCAL_PLANE_Y_RESOLUTION, Rational.class);
      }

    public void setFocalPlaneYResolutionAvailable (final boolean available)
      {
        final Rational oldValue = getFocalPlaneYResolution();
        final boolean oldPropAvailable = isFocalPlaneYResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FOCAL_PLANE_Y_RESOLUTION))
          {
            setObject(FOCAL_PLANE_Y_RESOLUTION, null);
          }
        else if (!available)
          {
            removeTag(FOCAL_PLANE_Y_RESOLUTION);
          }

        propertyChangeSupport.firePropertyChange("focalPlaneYResolutionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("focalPlaneYResolution", oldValue, getFocalPlaneYResolution());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFocalPlaneYResolutionAvailable()
      {
        return containsTag(FOCAL_PLANE_Y_RESOLUTION);
      }

    public void setFocalPlaneResolutionUnit (final Integer focalPlaneResolutionUnit)
      {
        final Integer oldValue = getFocalPlaneResolutionUnit();
        final boolean oldPropAvailable = isFocalPlaneResolutionUnitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FOCAL_PLANE_RESOLUTIONUNIT, focalPlaneResolutionUnit);
        propertyChangeSupport.firePropertyChange("focalPlaneResolutionUnit", oldValue, focalPlaneResolutionUnit);
        propertyChangeSupport.firePropertyChange("focalPlaneResolutionUnitAvailable", oldPropAvailable, isFocalPlaneResolutionUnitAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getFocalPlaneResolutionUnit()
      {
        return getObject(FOCAL_PLANE_RESOLUTIONUNIT, Integer.class);
      }

    public void setFocalPlaneResolutionUnitAvailable (final boolean available)
      {
        final Integer oldValue = getFocalPlaneResolutionUnit();
        final boolean oldPropAvailable = isFocalPlaneResolutionUnitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FOCAL_PLANE_RESOLUTIONUNIT))
          {
            setObject(FOCAL_PLANE_RESOLUTIONUNIT, null);
          }
        else if (!available)
          {
            removeTag(FOCAL_PLANE_RESOLUTIONUNIT);
          }

        propertyChangeSupport.firePropertyChange("focalPlaneResolutionUnitAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("focalPlaneResolutionUnit", oldValue, getFocalPlaneResolutionUnit());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFocalPlaneResolutionUnitAvailable()
      {
        return containsTag(FOCAL_PLANE_RESOLUTIONUNIT);
      }

    public void setSubjectLocation (final int[] subjectLocation)
      {
        final int[] oldValue = getSubjectLocation();
        final boolean oldPropAvailable = isSubjectLocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUBJECT_LOCATION, subjectLocation);
        propertyChangeSupport.firePropertyChange("subjectLocation", oldValue, subjectLocation);
        propertyChangeSupport.firePropertyChange("subjectLocationAvailable", oldPropAvailable, isSubjectLocationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getSubjectLocation()
      {
        return getObject(SUBJECT_LOCATION, int[].class);
      }

    public void setSubjectLocationAvailable (final boolean available)
      {
        final int[] oldValue = getSubjectLocation();
        final boolean oldPropAvailable = isSubjectLocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUBJECT_LOCATION))
          {
            setObject(SUBJECT_LOCATION, null);
          }
        else if (!available)
          {
            removeTag(SUBJECT_LOCATION);
          }

        propertyChangeSupport.firePropertyChange("subjectLocationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subjectLocation", oldValue, getSubjectLocation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubjectLocationAvailable()
      {
        return containsTag(SUBJECT_LOCATION);
      }

    public void setExposureIndex (final Rational exposureIndex)
      {
        final Rational oldValue = getExposureIndex();
        final boolean oldPropAvailable = isExposureIndexAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXPOSURE_INDEX, exposureIndex);
        propertyChangeSupport.firePropertyChange("exposureIndex", oldValue, exposureIndex);
        propertyChangeSupport.firePropertyChange("exposureIndexAvailable", oldPropAvailable, isExposureIndexAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getExposureIndex()
      {
        return getObject(EXPOSURE_INDEX, Rational.class);
      }

    public void setExposureIndexAvailable (final boolean available)
      {
        final Rational oldValue = getExposureIndex();
        final boolean oldPropAvailable = isExposureIndexAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXPOSURE_INDEX))
          {
            setObject(EXPOSURE_INDEX, null);
          }
        else if (!available)
          {
            removeTag(EXPOSURE_INDEX);
          }

        propertyChangeSupport.firePropertyChange("exposureIndexAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("exposureIndex", oldValue, getExposureIndex());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExposureIndexAvailable()
      {
        return containsTag(EXPOSURE_INDEX);
      }

    public static enum SensingMethod
       {
         NOT_DEFINED(1, "not defined"),
         ONE_CHIP_COLOR_AREA_SENSOR(2, "one chip color area sensor"),
         TWO_CHIP_COLOR_AREA_SENSOR(3, "Two chip color area sensor"),
         THREE_CHIP_COLOR_AREA_SENSOR(4, "Three chip color area sensor"),
         COLOR_SEQUENTIAL_AREA_SENSOR(5, "Color sequential area sensor"),
         TRILINEAR_SENSOR(7, "Trilinear sensor"),
         COLOR_SEQUENTIAL_LINEAR_SENSOR(8, "Color sequential linear sensor"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private SensingMethod (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static SensingMethod fromInteger (int value)
           {
             if (value == 1) return NOT_DEFINED;
             if (value == 2) return ONE_CHIP_COLOR_AREA_SENSOR;
             if (value == 3) return TWO_CHIP_COLOR_AREA_SENSOR;
             if (value == 4) return THREE_CHIP_COLOR_AREA_SENSOR;
             if (value == 5) return COLOR_SEQUENTIAL_AREA_SENSOR;
             if (value == 7) return TRILINEAR_SENSOR;
             if (value == 8) return COLOR_SEQUENTIAL_LINEAR_SENSOR;

             return _UNKNOWN;
           }
       }
    public void setSensingMethod (final SensingMethod sensingMethod)
      {
        final SensingMethod oldValue = getSensingMethod();
        final boolean oldPropAvailable = isSensingMethodAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SENSING_METHOD, sensingMethod);
        propertyChangeSupport.firePropertyChange("sensingMethod", oldValue, sensingMethod);
        propertyChangeSupport.firePropertyChange("sensingMethodAvailable", oldPropAvailable, isSensingMethodAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public SensingMethod getSensingMethod()
      {
        return getObject(SENSING_METHOD, SensingMethod.class);
      }

    public void setSensingMethodAvailable (final boolean available)
      {
        final SensingMethod oldValue = getSensingMethod();
        final boolean oldPropAvailable = isSensingMethodAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SENSING_METHOD))
          {
            setObject(SENSING_METHOD, null);
          }
        else if (!available)
          {
            removeTag(SENSING_METHOD);
          }

        propertyChangeSupport.firePropertyChange("sensingMethodAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("sensingMethod", oldValue, getSensingMethod());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSensingMethodAvailable()
      {
        return containsTag(SENSING_METHOD);
      }

    public static enum FileSource
       {
         DSC(3, "dsc"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private FileSource (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static FileSource fromInteger (int value)
           {
             if (value == 3) return DSC;

             return _UNKNOWN;
           }
       }
    public void setFileSource (final FileSource fileSource)
      {
        final FileSource oldValue = getFileSource();
        final boolean oldPropAvailable = isFileSourceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FILE_SOURCE, fileSource);
        propertyChangeSupport.firePropertyChange("fileSource", oldValue, fileSource);
        propertyChangeSupport.firePropertyChange("fileSourceAvailable", oldPropAvailable, isFileSourceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public FileSource getFileSource()
      {
        return getObject(FILE_SOURCE, FileSource.class);
      }

    public void setFileSourceAvailable (final boolean available)
      {
        final FileSource oldValue = getFileSource();
        final boolean oldPropAvailable = isFileSourceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FILE_SOURCE))
          {
            setObject(FILE_SOURCE, null);
          }
        else if (!available)
          {
            removeTag(FILE_SOURCE);
          }

        propertyChangeSupport.firePropertyChange("fileSourceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("fileSource", oldValue, getFileSource());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFileSourceAvailable()
      {
        return containsTag(FILE_SOURCE);
      }

    public static enum SceneType
       {
         DIRECTLY_PHOTOGRAPHED_IMAGE(1, "Directly photographed image"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private SceneType (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static SceneType fromInteger (int value)
           {
             if (value == 1) return DIRECTLY_PHOTOGRAPHED_IMAGE;

             return _UNKNOWN;
           }
       }
    public void setSceneType (final SceneType sceneType)
      {
        final SceneType oldValue = getSceneType();
        final boolean oldPropAvailable = isSceneTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SCENE_TYPE, sceneType);
        propertyChangeSupport.firePropertyChange("sceneType", oldValue, sceneType);
        propertyChangeSupport.firePropertyChange("sceneTypeAvailable", oldPropAvailable, isSceneTypeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public SceneType getSceneType()
      {
        return getObject(SCENE_TYPE, SceneType.class);
      }

    public void setSceneTypeAvailable (final boolean available)
      {
        final SceneType oldValue = getSceneType();
        final boolean oldPropAvailable = isSceneTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SCENE_TYPE))
          {
            setObject(SCENE_TYPE, null);
          }
        else if (!available)
          {
            removeTag(SCENE_TYPE);
          }

        propertyChangeSupport.firePropertyChange("sceneTypeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("sceneType", oldValue, getSceneType());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSceneTypeAvailable()
      {
        return containsTag(SCENE_TYPE);
      }

    public void setEXIFCFAPattern (final byte[] EXIFCFAPattern)
      {
        final byte[] oldValue = getEXIFCFAPattern();
        final boolean oldPropAvailable = isEXIFCFAPatternAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXIF_CFA_PATTERN, EXIFCFAPattern);
        propertyChangeSupport.firePropertyChange("EXIFCFAPattern", oldValue, EXIFCFAPattern);
        propertyChangeSupport.firePropertyChange("EXIFCFAPatternAvailable", oldPropAvailable, isEXIFCFAPatternAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getEXIFCFAPattern()
      {
        return getObject(EXIF_CFA_PATTERN, byte[].class);
      }

    public void setEXIFCFAPatternAvailable (final boolean available)
      {
        final byte[] oldValue = getEXIFCFAPattern();
        final boolean oldPropAvailable = isEXIFCFAPatternAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXIF_CFA_PATTERN))
          {
            setObject(EXIF_CFA_PATTERN, null);
          }
        else if (!available)
          {
            removeTag(EXIF_CFA_PATTERN);
          }

        propertyChangeSupport.firePropertyChange("EXIFCFAPatternAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("EXIFCFAPattern", oldValue, getEXIFCFAPattern());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isEXIFCFAPatternAvailable()
      {
        return containsTag(EXIF_CFA_PATTERN);
      }

    public static enum CustomRendered
       {
         NORMAL_PROCESS(0, "Normal process"),
         CUSTOM_PROCESS(1, "Custom process"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private CustomRendered (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static CustomRendered fromInteger (int value)
           {
             if (value == 0) return NORMAL_PROCESS;
             if (value == 1) return CUSTOM_PROCESS;

             return _UNKNOWN;
           }
       }
    public void setCustomRendered (final CustomRendered customRendered)
      {
        final CustomRendered oldValue = getCustomRendered();
        final boolean oldPropAvailable = isCustomRenderedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CUSTOM_RENDERED, customRendered);
        propertyChangeSupport.firePropertyChange("customRendered", oldValue, customRendered);
        propertyChangeSupport.firePropertyChange("customRenderedAvailable", oldPropAvailable, isCustomRenderedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public CustomRendered getCustomRendered()
      {
        return getObject(CUSTOM_RENDERED, CustomRendered.class);
      }

    public void setCustomRenderedAvailable (final boolean available)
      {
        final CustomRendered oldValue = getCustomRendered();
        final boolean oldPropAvailable = isCustomRenderedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CUSTOM_RENDERED))
          {
            setObject(CUSTOM_RENDERED, null);
          }
        else if (!available)
          {
            removeTag(CUSTOM_RENDERED);
          }

        propertyChangeSupport.firePropertyChange("customRenderedAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("customRendered", oldValue, getCustomRendered());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCustomRenderedAvailable()
      {
        return containsTag(CUSTOM_RENDERED);
      }

    public static enum ExposureMode
       {
         AUTO(0, "auto"),
         MANUAL(1, "manual"),
         BRACKET(2, "bracket"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private ExposureMode (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static ExposureMode fromInteger (int value)
           {
             if (value == 0) return AUTO;
             if (value == 1) return MANUAL;
             if (value == 2) return BRACKET;

             return _UNKNOWN;
           }
       }
    public void setExposureMode (final ExposureMode exposureMode)
      {
        final ExposureMode oldValue = getExposureMode();
        final boolean oldPropAvailable = isExposureModeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXPOSURE_MODE, exposureMode);
        propertyChangeSupport.firePropertyChange("exposureMode", oldValue, exposureMode);
        propertyChangeSupport.firePropertyChange("exposureModeAvailable", oldPropAvailable, isExposureModeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public ExposureMode getExposureMode()
      {
        return getObject(EXPOSURE_MODE, ExposureMode.class);
      }

    public void setExposureModeAvailable (final boolean available)
      {
        final ExposureMode oldValue = getExposureMode();
        final boolean oldPropAvailable = isExposureModeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXPOSURE_MODE))
          {
            setObject(EXPOSURE_MODE, null);
          }
        else if (!available)
          {
            removeTag(EXPOSURE_MODE);
          }

        propertyChangeSupport.firePropertyChange("exposureModeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("exposureMode", oldValue, getExposureMode());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExposureModeAvailable()
      {
        return containsTag(EXPOSURE_MODE);
      }

    public static enum WhiteBalance
       {
         AUTO(0, "auto"),
         MANUAL(1, "manual"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private WhiteBalance (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static WhiteBalance fromInteger (int value)
           {
             if (value == 0) return AUTO;
             if (value == 1) return MANUAL;

             return _UNKNOWN;
           }
       }
    public void setWhiteBalance (final WhiteBalance whiteBalance)
      {
        final WhiteBalance oldValue = getWhiteBalance();
        final boolean oldPropAvailable = isWhiteBalanceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.WHITE_BALANCE, whiteBalance);
        propertyChangeSupport.firePropertyChange("whiteBalance", oldValue, whiteBalance);
        propertyChangeSupport.firePropertyChange("whiteBalanceAvailable", oldPropAvailable, isWhiteBalanceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public WhiteBalance getWhiteBalance()
      {
        return getObject(WHITE_BALANCE, WhiteBalance.class);
      }

    public void setWhiteBalanceAvailable (final boolean available)
      {
        final WhiteBalance oldValue = getWhiteBalance();
        final boolean oldPropAvailable = isWhiteBalanceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(WHITE_BALANCE))
          {
            setObject(WHITE_BALANCE, null);
          }
        else if (!available)
          {
            removeTag(WHITE_BALANCE);
          }

        propertyChangeSupport.firePropertyChange("whiteBalanceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("whiteBalance", oldValue, getWhiteBalance());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isWhiteBalanceAvailable()
      {
        return containsTag(WHITE_BALANCE);
      }

    public void setDigitalZoomRatio (final Rational digitalZoomRatio)
      {
        final Rational oldValue = getDigitalZoomRatio();
        final boolean oldPropAvailable = isDigitalZoomRatioAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DIGITAL_ZOOM_RATIO, digitalZoomRatio);
        propertyChangeSupport.firePropertyChange("digitalZoomRatio", oldValue, digitalZoomRatio);
        propertyChangeSupport.firePropertyChange("digitalZoomRatioAvailable", oldPropAvailable, isDigitalZoomRatioAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getDigitalZoomRatio()
      {
        return getObject(DIGITAL_ZOOM_RATIO, Rational.class);
      }

    public void setDigitalZoomRatioAvailable (final boolean available)
      {
        final Rational oldValue = getDigitalZoomRatio();
        final boolean oldPropAvailable = isDigitalZoomRatioAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DIGITAL_ZOOM_RATIO))
          {
            setObject(DIGITAL_ZOOM_RATIO, null);
          }
        else if (!available)
          {
            removeTag(DIGITAL_ZOOM_RATIO);
          }

        propertyChangeSupport.firePropertyChange("digitalZoomRatioAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("digitalZoomRatio", oldValue, getDigitalZoomRatio());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDigitalZoomRatioAvailable()
      {
        return containsTag(DIGITAL_ZOOM_RATIO);
      }

    public void setFocalLength35mmFilm (final Integer focalLength35mmFilm)
      {
        final Integer oldValue = getFocalLength35mmFilm();
        final boolean oldPropAvailable = isFocalLength35mmFilmAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FOCAL_LENGTH_35MM_FILM, focalLength35mmFilm);
        propertyChangeSupport.firePropertyChange("focalLength35mmFilm", oldValue, focalLength35mmFilm);
        propertyChangeSupport.firePropertyChange("focalLength35mmFilmAvailable", oldPropAvailable, isFocalLength35mmFilmAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getFocalLength35mmFilm()
      {
        return getObject(FOCAL_LENGTH_35MM_FILM, Integer.class);
      }

    public void setFocalLength35mmFilmAvailable (final boolean available)
      {
        final Integer oldValue = getFocalLength35mmFilm();
        final boolean oldPropAvailable = isFocalLength35mmFilmAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FOCAL_LENGTH_35MM_FILM))
          {
            setObject(FOCAL_LENGTH_35MM_FILM, null);
          }
        else if (!available)
          {
            removeTag(FOCAL_LENGTH_35MM_FILM);
          }

        propertyChangeSupport.firePropertyChange("focalLength35mmFilmAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("focalLength35mmFilm", oldValue, getFocalLength35mmFilm());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFocalLength35mmFilmAvailable()
      {
        return containsTag(FOCAL_LENGTH_35MM_FILM);
      }

    public void setSceneCaptureType (final Integer sceneCaptureType)
      {
        final Integer oldValue = getSceneCaptureType();
        final boolean oldPropAvailable = isSceneCaptureTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SCENE_CAPTURE_TYPE, sceneCaptureType);
        propertyChangeSupport.firePropertyChange("sceneCaptureType", oldValue, sceneCaptureType);
        propertyChangeSupport.firePropertyChange("sceneCaptureTypeAvailable", oldPropAvailable, isSceneCaptureTypeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getSceneCaptureType()
      {
        return getObject(SCENE_CAPTURE_TYPE, Integer.class);
      }

    public void setSceneCaptureTypeAvailable (final boolean available)
      {
        final Integer oldValue = getSceneCaptureType();
        final boolean oldPropAvailable = isSceneCaptureTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SCENE_CAPTURE_TYPE))
          {
            setObject(SCENE_CAPTURE_TYPE, null);
          }
        else if (!available)
          {
            removeTag(SCENE_CAPTURE_TYPE);
          }

        propertyChangeSupport.firePropertyChange("sceneCaptureTypeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("sceneCaptureType", oldValue, getSceneCaptureType());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSceneCaptureTypeAvailable()
      {
        return containsTag(SCENE_CAPTURE_TYPE);
      }

    public static enum GainControl
       {
         NONE(0, "None"),
         LOW_GAIN_UP(1, "Low gain up"),
         HIGH_GAIN_UP(2, "High gain up"),
         LOW_GAIN_DOWN(3, "Low gain down"),
         HIGH_GAIN_DOWN(4, "High gain down"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private GainControl (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static GainControl fromInteger (int value)
           {
             if (value == 0) return NONE;
             if (value == 1) return LOW_GAIN_UP;
             if (value == 2) return HIGH_GAIN_UP;
             if (value == 3) return LOW_GAIN_DOWN;
             if (value == 4) return HIGH_GAIN_DOWN;

             return _UNKNOWN;
           }
       }
    public void setGainControl (final GainControl gainControl)
      {
        final GainControl oldValue = getGainControl();
        final boolean oldPropAvailable = isGainControlAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.GAIN_CONTROL, gainControl);
        propertyChangeSupport.firePropertyChange("gainControl", oldValue, gainControl);
        propertyChangeSupport.firePropertyChange("gainControlAvailable", oldPropAvailable, isGainControlAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public GainControl getGainControl()
      {
        return getObject(GAIN_CONTROL, GainControl.class);
      }

    public void setGainControlAvailable (final boolean available)
      {
        final GainControl oldValue = getGainControl();
        final boolean oldPropAvailable = isGainControlAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(GAIN_CONTROL))
          {
            setObject(GAIN_CONTROL, null);
          }
        else if (!available)
          {
            removeTag(GAIN_CONTROL);
          }

        propertyChangeSupport.firePropertyChange("gainControlAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("gainControl", oldValue, getGainControl());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isGainControlAvailable()
      {
        return containsTag(GAIN_CONTROL);
      }

    public static enum Contrast
       {
         NORMAL(0, "normal"),
         SOFT(1, "soft"),
         HARD(2, "hard"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private Contrast (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static Contrast fromInteger (int value)
           {
             if (value == 0) return NORMAL;
             if (value == 1) return SOFT;
             if (value == 2) return HARD;

             return _UNKNOWN;
           }
       }
    public void setContrast (final Contrast contrast)
      {
        final Contrast oldValue = getContrast();
        final boolean oldPropAvailable = isContrastAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CONTRAST, contrast);
        propertyChangeSupport.firePropertyChange("contrast", oldValue, contrast);
        propertyChangeSupport.firePropertyChange("contrastAvailable", oldPropAvailable, isContrastAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Contrast getContrast()
      {
        return getObject(CONTRAST, Contrast.class);
      }

    public void setContrastAvailable (final boolean available)
      {
        final Contrast oldValue = getContrast();
        final boolean oldPropAvailable = isContrastAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CONTRAST))
          {
            setObject(CONTRAST, null);
          }
        else if (!available)
          {
            removeTag(CONTRAST);
          }

        propertyChangeSupport.firePropertyChange("contrastAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("contrast", oldValue, getContrast());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isContrastAvailable()
      {
        return containsTag(CONTRAST);
      }

    public static enum Saturation
       {
         NORMAL(0, "normal"),
         LOW(1, "low"),
         HIGH(2, "high"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private Saturation (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static Saturation fromInteger (int value)
           {
             if (value == 0) return NORMAL;
             if (value == 1) return LOW;
             if (value == 2) return HIGH;

             return _UNKNOWN;
           }
       }
    public void setSaturation (final Saturation saturation)
      {
        final Saturation oldValue = getSaturation();
        final boolean oldPropAvailable = isSaturationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SATURATION, saturation);
        propertyChangeSupport.firePropertyChange("saturation", oldValue, saturation);
        propertyChangeSupport.firePropertyChange("saturationAvailable", oldPropAvailable, isSaturationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Saturation getSaturation()
      {
        return getObject(SATURATION, Saturation.class);
      }

    public void setSaturationAvailable (final boolean available)
      {
        final Saturation oldValue = getSaturation();
        final boolean oldPropAvailable = isSaturationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SATURATION))
          {
            setObject(SATURATION, null);
          }
        else if (!available)
          {
            removeTag(SATURATION);
          }

        propertyChangeSupport.firePropertyChange("saturationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("saturation", oldValue, getSaturation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSaturationAvailable()
      {
        return containsTag(SATURATION);
      }

    public static enum Sharpness
       {
         NORMAL(0, "normal"),
         SOFT(1, "soft"),
         HARD(2, "hard"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private Sharpness (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static Sharpness fromInteger (int value)
           {
             if (value == 0) return NORMAL;
             if (value == 1) return SOFT;
             if (value == 2) return HARD;

             return _UNKNOWN;
           }
       }
    public void setSharpness (final Sharpness sharpness)
      {
        final Sharpness oldValue = getSharpness();
        final boolean oldPropAvailable = isSharpnessAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SHARPNESS, sharpness);
        propertyChangeSupport.firePropertyChange("sharpness", oldValue, sharpness);
        propertyChangeSupport.firePropertyChange("sharpnessAvailable", oldPropAvailable, isSharpnessAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Sharpness getSharpness()
      {
        return getObject(SHARPNESS, Sharpness.class);
      }

    public void setSharpnessAvailable (final boolean available)
      {
        final Sharpness oldValue = getSharpness();
        final boolean oldPropAvailable = isSharpnessAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SHARPNESS))
          {
            setObject(SHARPNESS, null);
          }
        else if (!available)
          {
            removeTag(SHARPNESS);
          }

        propertyChangeSupport.firePropertyChange("sharpnessAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("sharpness", oldValue, getSharpness());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSharpnessAvailable()
      {
        return containsTag(SHARPNESS);
      }

    public void setDeviceSettingDescription (final byte[] deviceSettingDescription)
      {
        final byte[] oldValue = getDeviceSettingDescription();
        final boolean oldPropAvailable = isDeviceSettingDescriptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DEVICE_SETTING_DESCRIPTION, deviceSettingDescription);
        propertyChangeSupport.firePropertyChange("deviceSettingDescription", oldValue, deviceSettingDescription);
        propertyChangeSupport.firePropertyChange("deviceSettingDescriptionAvailable", oldPropAvailable, isDeviceSettingDescriptionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getDeviceSettingDescription()
      {
        return getObject(DEVICE_SETTING_DESCRIPTION, byte[].class);
      }

    public void setDeviceSettingDescriptionAvailable (final boolean available)
      {
        final byte[] oldValue = getDeviceSettingDescription();
        final boolean oldPropAvailable = isDeviceSettingDescriptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DEVICE_SETTING_DESCRIPTION))
          {
            setObject(DEVICE_SETTING_DESCRIPTION, null);
          }
        else if (!available)
          {
            removeTag(DEVICE_SETTING_DESCRIPTION);
          }

        propertyChangeSupport.firePropertyChange("deviceSettingDescriptionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("deviceSettingDescription", oldValue, getDeviceSettingDescription());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDeviceSettingDescriptionAvailable()
      {
        return containsTag(DEVICE_SETTING_DESCRIPTION);
      }

    public void setSubjectDistanceRange (final Integer subjectDistanceRange)
      {
        final Integer oldValue = getSubjectDistanceRange();
        final boolean oldPropAvailable = isSubjectDistanceRangeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUBJECT_DISTANCE_RANGE, subjectDistanceRange);
        propertyChangeSupport.firePropertyChange("subjectDistanceRange", oldValue, subjectDistanceRange);
        propertyChangeSupport.firePropertyChange("subjectDistanceRangeAvailable", oldPropAvailable, isSubjectDistanceRangeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getSubjectDistanceRange()
      {
        return getObject(SUBJECT_DISTANCE_RANGE, Integer.class);
      }

    public void setSubjectDistanceRangeAvailable (final boolean available)
      {
        final Integer oldValue = getSubjectDistanceRange();
        final boolean oldPropAvailable = isSubjectDistanceRangeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUBJECT_DISTANCE_RANGE))
          {
            setObject(SUBJECT_DISTANCE_RANGE, null);
          }
        else if (!available)
          {
            removeTag(SUBJECT_DISTANCE_RANGE);
          }

        propertyChangeSupport.firePropertyChange("subjectDistanceRangeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subjectDistanceRange", oldValue, getSubjectDistanceRange());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubjectDistanceRangeAvailable()
      {
        return containsTag(SUBJECT_DISTANCE_RANGE);
      }

    public void setImageUniqueID (final String imageUniqueID)
      {
        final String oldValue = getImageUniqueID();
        final boolean oldPropAvailable = isImageUniqueIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.IMAGE_UNIQUE_ID, imageUniqueID);
        propertyChangeSupport.firePropertyChange("imageUniqueID", oldValue, imageUniqueID);
        propertyChangeSupport.firePropertyChange("imageUniqueIDAvailable", oldPropAvailable, isImageUniqueIDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getImageUniqueID()
      {
        return getObject(IMAGE_UNIQUE_ID, String.class);
      }

    public void setImageUniqueIDAvailable (final boolean available)
      {
        final String oldValue = getImageUniqueID();
        final boolean oldPropAvailable = isImageUniqueIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_UNIQUE_ID))
          {
            setObject(IMAGE_UNIQUE_ID, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_UNIQUE_ID);
          }

        propertyChangeSupport.firePropertyChange("imageUniqueIDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageUniqueID", oldValue, getImageUniqueID());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageUniqueIDAvailable()
      {
        return containsTag(IMAGE_UNIQUE_ID);
      }

    public void setPhotoshopAnnotations (final Integer photoshopAnnotations)
      {
        final Integer oldValue = getPhotoshopAnnotations();
        final boolean oldPropAvailable = isPhotoshopAnnotationsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PHOTOSHOP_ANNOTATIONS, photoshopAnnotations);
        propertyChangeSupport.firePropertyChange("photoshopAnnotations", oldValue, photoshopAnnotations);
        propertyChangeSupport.firePropertyChange("photoshopAnnotationsAvailable", oldPropAvailable, isPhotoshopAnnotationsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getPhotoshopAnnotations()
      {
        return getObject(PHOTOSHOP_ANNOTATIONS, Integer.class);
      }

    public void setPhotoshopAnnotationsAvailable (final boolean available)
      {
        final Integer oldValue = getPhotoshopAnnotations();
        final boolean oldPropAvailable = isPhotoshopAnnotationsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PHOTOSHOP_ANNOTATIONS))
          {
            setObject(PHOTOSHOP_ANNOTATIONS, null);
          }
        else if (!available)
          {
            removeTag(PHOTOSHOP_ANNOTATIONS);
          }

        propertyChangeSupport.firePropertyChange("photoshopAnnotationsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("photoshopAnnotations", oldValue, getPhotoshopAnnotations());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPhotoshopAnnotationsAvailable()
      {
        return containsTag(PHOTOSHOP_ANNOTATIONS);
      }

    public void setThumbnail (final byte[] thumbnail)
      {
        final byte[] oldValue = getThumbnail();
        final boolean oldPropAvailable = isThumbnailAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.THUMBNAIL, thumbnail);
        propertyChangeSupport.firePropertyChange("thumbnail", oldValue, thumbnail);
        propertyChangeSupport.firePropertyChange("thumbnailAvailable", oldPropAvailable, isThumbnailAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getThumbnail()
      {
        return getObject(THUMBNAIL, byte[].class);
      }

    public void setThumbnailAvailable (final boolean available)
      {
        final byte[] oldValue = getThumbnail();
        final boolean oldPropAvailable = isThumbnailAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(THUMBNAIL))
          {
            setObject(THUMBNAIL, null);
          }
        else if (!available)
          {
            removeTag(THUMBNAIL);
          }

        propertyChangeSupport.firePropertyChange("thumbnailAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("thumbnail", oldValue, getThumbnail());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isThumbnailAvailable()
      {
        return containsTag(THUMBNAIL);
      }

    public void setDNGVersion (final byte[] DNGVersion)
      {
        final byte[] oldValue = getDNGVersion();
        final boolean oldPropAvailable = isDNGVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DNG_VERSION, DNGVersion);
        propertyChangeSupport.firePropertyChange("DNGVersion", oldValue, DNGVersion);
        propertyChangeSupport.firePropertyChange("DNGVersionAvailable", oldPropAvailable, isDNGVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getDNGVersion()
      {
        return getObject(DNG_VERSION, byte[].class);
      }

    public void setDNGVersionAvailable (final boolean available)
      {
        final byte[] oldValue = getDNGVersion();
        final boolean oldPropAvailable = isDNGVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DNG_VERSION))
          {
            setObject(DNG_VERSION, null);
          }
        else if (!available)
          {
            removeTag(DNG_VERSION);
          }

        propertyChangeSupport.firePropertyChange("DNGVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("DNGVersion", oldValue, getDNGVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDNGVersionAvailable()
      {
        return containsTag(DNG_VERSION);
      }

    public void setDNGBackwardVersion (final byte[] DNGBackwardVersion)
      {
        final byte[] oldValue = getDNGBackwardVersion();
        final boolean oldPropAvailable = isDNGBackwardVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DNG_BACKWARD_VERSION, DNGBackwardVersion);
        propertyChangeSupport.firePropertyChange("DNGBackwardVersion", oldValue, DNGBackwardVersion);
        propertyChangeSupport.firePropertyChange("DNGBackwardVersionAvailable", oldPropAvailable, isDNGBackwardVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getDNGBackwardVersion()
      {
        return getObject(DNG_BACKWARD_VERSION, byte[].class);
      }

    public void setDNGBackwardVersionAvailable (final boolean available)
      {
        final byte[] oldValue = getDNGBackwardVersion();
        final boolean oldPropAvailable = isDNGBackwardVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DNG_BACKWARD_VERSION))
          {
            setObject(DNG_BACKWARD_VERSION, null);
          }
        else if (!available)
          {
            removeTag(DNG_BACKWARD_VERSION);
          }

        propertyChangeSupport.firePropertyChange("DNGBackwardVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("DNGBackwardVersion", oldValue, getDNGBackwardVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDNGBackwardVersionAvailable()
      {
        return containsTag(DNG_BACKWARD_VERSION);
      }

    public void setUniqueCameraModel (final String uniqueCameraModel)
      {
        final String oldValue = getUniqueCameraModel();
        final boolean oldPropAvailable = isUniqueCameraModelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.UNIQUE_CAMERA_MODEL, uniqueCameraModel);
        propertyChangeSupport.firePropertyChange("uniqueCameraModel", oldValue, uniqueCameraModel);
        propertyChangeSupport.firePropertyChange("uniqueCameraModelAvailable", oldPropAvailable, isUniqueCameraModelAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getUniqueCameraModel()
      {
        return getObject(UNIQUE_CAMERA_MODEL, String.class);
      }

    public void setUniqueCameraModelAvailable (final boolean available)
      {
        final String oldValue = getUniqueCameraModel();
        final boolean oldPropAvailable = isUniqueCameraModelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(UNIQUE_CAMERA_MODEL))
          {
            setObject(UNIQUE_CAMERA_MODEL, null);
          }
        else if (!available)
          {
            removeTag(UNIQUE_CAMERA_MODEL);
          }

        propertyChangeSupport.firePropertyChange("uniqueCameraModelAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("uniqueCameraModel", oldValue, getUniqueCameraModel());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isUniqueCameraModelAvailable()
      {
        return containsTag(UNIQUE_CAMERA_MODEL);
      }

    public void setLocalizedCameraModel (final String localizedCameraModel)
      {
        final String oldValue = getLocalizedCameraModel();
        final boolean oldPropAvailable = isLocalizedCameraModelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.LOCALIZED_CAMERA_MODEL, localizedCameraModel);
        propertyChangeSupport.firePropertyChange("localizedCameraModel", oldValue, localizedCameraModel);
        propertyChangeSupport.firePropertyChange("localizedCameraModelAvailable", oldPropAvailable, isLocalizedCameraModelAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getLocalizedCameraModel()
      {
        return getObject(LOCALIZED_CAMERA_MODEL, String.class);
      }

    public void setLocalizedCameraModelAvailable (final boolean available)
      {
        final String oldValue = getLocalizedCameraModel();
        final boolean oldPropAvailable = isLocalizedCameraModelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(LOCALIZED_CAMERA_MODEL))
          {
            setObject(LOCALIZED_CAMERA_MODEL, null);
          }
        else if (!available)
          {
            removeTag(LOCALIZED_CAMERA_MODEL);
          }

        propertyChangeSupport.firePropertyChange("localizedCameraModelAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("localizedCameraModel", oldValue, getLocalizedCameraModel());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isLocalizedCameraModelAvailable()
      {
        return containsTag(LOCALIZED_CAMERA_MODEL);
      }

    public void setCFAPlaneColor (final byte[] CFAPlaneColor)
      {
        final byte[] oldValue = getCFAPlaneColor();
        final boolean oldPropAvailable = isCFAPlaneColorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CFA_PLANE_COLOR, CFAPlaneColor);
        propertyChangeSupport.firePropertyChange("CFAPlaneColor", oldValue, CFAPlaneColor);
        propertyChangeSupport.firePropertyChange("CFAPlaneColorAvailable", oldPropAvailable, isCFAPlaneColorAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getCFAPlaneColor()
      {
        return getObject(CFA_PLANE_COLOR, byte[].class);
      }

    public void setCFAPlaneColorAvailable (final boolean available)
      {
        final byte[] oldValue = getCFAPlaneColor();
        final boolean oldPropAvailable = isCFAPlaneColorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CFA_PLANE_COLOR))
          {
            setObject(CFA_PLANE_COLOR, null);
          }
        else if (!available)
          {
            removeTag(CFA_PLANE_COLOR);
          }

        propertyChangeSupport.firePropertyChange("CFAPlaneColorAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("CFAPlaneColor", oldValue, getCFAPlaneColor());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCFAPlaneColorAvailable()
      {
        return containsTag(CFA_PLANE_COLOR);
      }

    public void setCFALayout (final Integer CFALayout)
      {
        final Integer oldValue = getCFALayout();
        final boolean oldPropAvailable = isCFALayoutAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CFA_LAYOUT, CFALayout);
        propertyChangeSupport.firePropertyChange("CFALayout", oldValue, CFALayout);
        propertyChangeSupport.firePropertyChange("CFALayoutAvailable", oldPropAvailable, isCFALayoutAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getCFALayout()
      {
        return getObject(CFA_LAYOUT, Integer.class);
      }

    public void setCFALayoutAvailable (final boolean available)
      {
        final Integer oldValue = getCFALayout();
        final boolean oldPropAvailable = isCFALayoutAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CFA_LAYOUT))
          {
            setObject(CFA_LAYOUT, null);
          }
        else if (!available)
          {
            removeTag(CFA_LAYOUT);
          }

        propertyChangeSupport.firePropertyChange("CFALayoutAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("CFALayout", oldValue, getCFALayout());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCFALayoutAvailable()
      {
        return containsTag(CFA_LAYOUT);
      }

    public void setLinearizationTable (final int[] linearizationTable)
      {
        final int[] oldValue = getLinearizationTable();
        final boolean oldPropAvailable = isLinearizationTableAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.LINEARIZATION_TABLE, linearizationTable);
        propertyChangeSupport.firePropertyChange("linearizationTable", oldValue, linearizationTable);
        propertyChangeSupport.firePropertyChange("linearizationTableAvailable", oldPropAvailable, isLinearizationTableAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getLinearizationTable()
      {
        return getObject(LINEARIZATION_TABLE, int[].class);
      }

    public void setLinearizationTableAvailable (final boolean available)
      {
        final int[] oldValue = getLinearizationTable();
        final boolean oldPropAvailable = isLinearizationTableAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(LINEARIZATION_TABLE))
          {
            setObject(LINEARIZATION_TABLE, null);
          }
        else if (!available)
          {
            removeTag(LINEARIZATION_TABLE);
          }

        propertyChangeSupport.firePropertyChange("linearizationTableAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("linearizationTable", oldValue, getLinearizationTable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isLinearizationTableAvailable()
      {
        return containsTag(LINEARIZATION_TABLE);
      }

    public void setBlackLevelRepeatDim (final int[] blackLevelRepeatDim)
      {
        final int[] oldValue = getBlackLevelRepeatDim();
        final boolean oldPropAvailable = isBlackLevelRepeatDimAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BLACK_LEVEL_REPEAT_DIM, blackLevelRepeatDim);
        propertyChangeSupport.firePropertyChange("blackLevelRepeatDim", oldValue, blackLevelRepeatDim);
        propertyChangeSupport.firePropertyChange("blackLevelRepeatDimAvailable", oldPropAvailable, isBlackLevelRepeatDimAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getBlackLevelRepeatDim()
      {
        return getObject(BLACK_LEVEL_REPEAT_DIM, int[].class);
      }

    public void setBlackLevelRepeatDimAvailable (final boolean available)
      {
        final int[] oldValue = getBlackLevelRepeatDim();
        final boolean oldPropAvailable = isBlackLevelRepeatDimAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BLACK_LEVEL_REPEAT_DIM))
          {
            setObject(BLACK_LEVEL_REPEAT_DIM, null);
          }
        else if (!available)
          {
            removeTag(BLACK_LEVEL_REPEAT_DIM);
          }

        propertyChangeSupport.firePropertyChange("blackLevelRepeatDimAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("blackLevelRepeatDim", oldValue, getBlackLevelRepeatDim());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBlackLevelRepeatDimAvailable()
      {
        return containsTag(BLACK_LEVEL_REPEAT_DIM);
      }

    public void setBlackLevel (final Rational[] blackLevel)
      {
        final Rational[] oldValue = getBlackLevel();
        final boolean oldPropAvailable = isBlackLevelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BLACK_LEVEL, blackLevel);
        propertyChangeSupport.firePropertyChange("blackLevel", oldValue, blackLevel);
        propertyChangeSupport.firePropertyChange("blackLevelAvailable", oldPropAvailable, isBlackLevelAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getBlackLevel()
      {
        return getObject(BLACK_LEVEL, Rational[].class);
      }

    public void setBlackLevelAvailable (final boolean available)
      {
        final Rational[] oldValue = getBlackLevel();
        final boolean oldPropAvailable = isBlackLevelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BLACK_LEVEL))
          {
            setObject(BLACK_LEVEL, null);
          }
        else if (!available)
          {
            removeTag(BLACK_LEVEL);
          }

        propertyChangeSupport.firePropertyChange("blackLevelAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("blackLevel", oldValue, getBlackLevel());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBlackLevelAvailable()
      {
        return containsTag(BLACK_LEVEL);
      }

    public void setBlackLevelDeltaH (final Rational[] blackLevelDeltaH)
      {
        final Rational[] oldValue = getBlackLevelDeltaH();
        final boolean oldPropAvailable = isBlackLevelDeltaHAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BLACK_LEVEL_DELTA_H, blackLevelDeltaH);
        propertyChangeSupport.firePropertyChange("blackLevelDeltaH", oldValue, blackLevelDeltaH);
        propertyChangeSupport.firePropertyChange("blackLevelDeltaHAvailable", oldPropAvailable, isBlackLevelDeltaHAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getBlackLevelDeltaH()
      {
        return getObject(BLACK_LEVEL_DELTA_H, Rational[].class);
      }

    public void setBlackLevelDeltaHAvailable (final boolean available)
      {
        final Rational[] oldValue = getBlackLevelDeltaH();
        final boolean oldPropAvailable = isBlackLevelDeltaHAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BLACK_LEVEL_DELTA_H))
          {
            setObject(BLACK_LEVEL_DELTA_H, null);
          }
        else if (!available)
          {
            removeTag(BLACK_LEVEL_DELTA_H);
          }

        propertyChangeSupport.firePropertyChange("blackLevelDeltaHAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("blackLevelDeltaH", oldValue, getBlackLevelDeltaH());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBlackLevelDeltaHAvailable()
      {
        return containsTag(BLACK_LEVEL_DELTA_H);
      }

    public void setBlackLevelDeltaV (final Rational[] blackLevelDeltaV)
      {
        final Rational[] oldValue = getBlackLevelDeltaV();
        final boolean oldPropAvailable = isBlackLevelDeltaVAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BLACK_LEVEL_DELTA_V, blackLevelDeltaV);
        propertyChangeSupport.firePropertyChange("blackLevelDeltaV", oldValue, blackLevelDeltaV);
        propertyChangeSupport.firePropertyChange("blackLevelDeltaVAvailable", oldPropAvailable, isBlackLevelDeltaVAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getBlackLevelDeltaV()
      {
        return getObject(BLACK_LEVEL_DELTA_V, Rational[].class);
      }

    public void setBlackLevelDeltaVAvailable (final boolean available)
      {
        final Rational[] oldValue = getBlackLevelDeltaV();
        final boolean oldPropAvailable = isBlackLevelDeltaVAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BLACK_LEVEL_DELTA_V))
          {
            setObject(BLACK_LEVEL_DELTA_V, null);
          }
        else if (!available)
          {
            removeTag(BLACK_LEVEL_DELTA_V);
          }

        propertyChangeSupport.firePropertyChange("blackLevelDeltaVAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("blackLevelDeltaV", oldValue, getBlackLevelDeltaV());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBlackLevelDeltaVAvailable()
      {
        return containsTag(BLACK_LEVEL_DELTA_V);
      }

    public void setWhiteLevel (final int[] whiteLevel)
      {
        final int[] oldValue = getWhiteLevel();
        final boolean oldPropAvailable = isWhiteLevelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.WHITE_LEVEL, whiteLevel);
        propertyChangeSupport.firePropertyChange("whiteLevel", oldValue, whiteLevel);
        propertyChangeSupport.firePropertyChange("whiteLevelAvailable", oldPropAvailable, isWhiteLevelAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getWhiteLevel()
      {
        return getObject(WHITE_LEVEL, int[].class);
      }

    public void setWhiteLevelAvailable (final boolean available)
      {
        final int[] oldValue = getWhiteLevel();
        final boolean oldPropAvailable = isWhiteLevelAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(WHITE_LEVEL))
          {
            setObject(WHITE_LEVEL, null);
          }
        else if (!available)
          {
            removeTag(WHITE_LEVEL);
          }

        propertyChangeSupport.firePropertyChange("whiteLevelAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("whiteLevel", oldValue, getWhiteLevel());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isWhiteLevelAvailable()
      {
        return containsTag(WHITE_LEVEL);
      }

    public void setDefaultScale (final Rational[] defaultScale)
      {
        final Rational[] oldValue = getDefaultScale();
        final boolean oldPropAvailable = isDefaultScaleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DEFAULT_SCALE, defaultScale);
        propertyChangeSupport.firePropertyChange("defaultScale", oldValue, defaultScale);
        propertyChangeSupport.firePropertyChange("defaultScaleAvailable", oldPropAvailable, isDefaultScaleAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getDefaultScale()
      {
        return getObject(DEFAULT_SCALE, Rational[].class);
      }

    public void setDefaultScaleAvailable (final boolean available)
      {
        final Rational[] oldValue = getDefaultScale();
        final boolean oldPropAvailable = isDefaultScaleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DEFAULT_SCALE))
          {
            setObject(DEFAULT_SCALE, null);
          }
        else if (!available)
          {
            removeTag(DEFAULT_SCALE);
          }

        propertyChangeSupport.firePropertyChange("defaultScaleAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("defaultScale", oldValue, getDefaultScale());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDefaultScaleAvailable()
      {
        return containsTag(DEFAULT_SCALE);
      }

    public void setBestQualityScale (final Rational bestQualityScale)
      {
        final Rational oldValue = getBestQualityScale();
        final boolean oldPropAvailable = isBestQualityScaleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BEST_QUALITY_SCALE, bestQualityScale);
        propertyChangeSupport.firePropertyChange("bestQualityScale", oldValue, bestQualityScale);
        propertyChangeSupport.firePropertyChange("bestQualityScaleAvailable", oldPropAvailable, isBestQualityScaleAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getBestQualityScale()
      {
        return getObject(BEST_QUALITY_SCALE, Rational.class);
      }

    public void setBestQualityScaleAvailable (final boolean available)
      {
        final Rational oldValue = getBestQualityScale();
        final boolean oldPropAvailable = isBestQualityScaleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BEST_QUALITY_SCALE))
          {
            setObject(BEST_QUALITY_SCALE, null);
          }
        else if (!available)
          {
            removeTag(BEST_QUALITY_SCALE);
          }

        propertyChangeSupport.firePropertyChange("bestQualityScaleAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("bestQualityScale", oldValue, getBestQualityScale());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBestQualityScaleAvailable()
      {
        return containsTag(BEST_QUALITY_SCALE);
      }

    public void setDefaultCropOrigin (final Rational[] defaultCropOrigin)
      {
        final Rational[] oldValue = getDefaultCropOrigin();
        final boolean oldPropAvailable = isDefaultCropOriginAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DEFAULT_CROP_ORIGIN, defaultCropOrigin);
        propertyChangeSupport.firePropertyChange("defaultCropOrigin", oldValue, defaultCropOrigin);
        propertyChangeSupport.firePropertyChange("defaultCropOriginAvailable", oldPropAvailable, isDefaultCropOriginAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getDefaultCropOrigin()
      {
        return getObject(DEFAULT_CROP_ORIGIN, Rational[].class);
      }

    public void setDefaultCropOriginAvailable (final boolean available)
      {
        final Rational[] oldValue = getDefaultCropOrigin();
        final boolean oldPropAvailable = isDefaultCropOriginAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DEFAULT_CROP_ORIGIN))
          {
            setObject(DEFAULT_CROP_ORIGIN, null);
          }
        else if (!available)
          {
            removeTag(DEFAULT_CROP_ORIGIN);
          }

        propertyChangeSupport.firePropertyChange("defaultCropOriginAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("defaultCropOrigin", oldValue, getDefaultCropOrigin());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDefaultCropOriginAvailable()
      {
        return containsTag(DEFAULT_CROP_ORIGIN);
      }

    public void setDefaultCropSize (final Rational[] defaultCropSize)
      {
        final Rational[] oldValue = getDefaultCropSize();
        final boolean oldPropAvailable = isDefaultCropSizeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DEFAULT_CROP_SIZE, defaultCropSize);
        propertyChangeSupport.firePropertyChange("defaultCropSize", oldValue, defaultCropSize);
        propertyChangeSupport.firePropertyChange("defaultCropSizeAvailable", oldPropAvailable, isDefaultCropSizeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getDefaultCropSize()
      {
        return getObject(DEFAULT_CROP_SIZE, Rational[].class);
      }

    public void setDefaultCropSizeAvailable (final boolean available)
      {
        final Rational[] oldValue = getDefaultCropSize();
        final boolean oldPropAvailable = isDefaultCropSizeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DEFAULT_CROP_SIZE))
          {
            setObject(DEFAULT_CROP_SIZE, null);
          }
        else if (!available)
          {
            removeTag(DEFAULT_CROP_SIZE);
          }

        propertyChangeSupport.firePropertyChange("defaultCropSizeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("defaultCropSize", oldValue, getDefaultCropSize());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDefaultCropSizeAvailable()
      {
        return containsTag(DEFAULT_CROP_SIZE);
      }

    public static enum CalibrationIlluminant1
       {
         UNKNOWN(0, "unknown"),
         DAYLIGHT(1, "Daylight"),
         FLUORESCENT(2, "Fluorescent"),
         TUNGSTEN(3, "Tungsten"),
         FLASH(4, "Flash"),
         FINE_WEATHER(9, "Fine weather"),
         CLOUDY_WEATHER(10, "Cloudy weather"),
         SHADE(11, "Shade"),
         DAYLIGHT_FLUORESCENT(12, "Daylight fluorescent"),
         DAY_WHITE_FLUORESCENT(13, "Day white fluorescent"),
         COOL_WHITE_FLUORESCENT(14, "Cool white fluorescent"),
         WHITE_FLUORESCENT(15, "White fluorescent"),
         STANDARD_LIGHT_A(17, "Standard light A"),
         STANDARD_LIGHT_B(18, "Standard light B"),
         STANDARD_LIGHT_C(19, "Standard light C"),
         D55(20, "D55"),
         D65(21, "D65"),
         D75(22, "D75"),
         D50(23, "D50"),
         ISO_STUDIO_TUNGSTEN(24, "ISO studio tungsten"),
         OTHER_LIGHT_SOURCE(255, "other light source"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private CalibrationIlluminant1 (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static CalibrationIlluminant1 fromInteger (int value)
           {
             if (value == 0) return UNKNOWN;
             if (value == 1) return DAYLIGHT;
             if (value == 2) return FLUORESCENT;
             if (value == 3) return TUNGSTEN;
             if (value == 4) return FLASH;
             if (value == 9) return FINE_WEATHER;
             if (value == 10) return CLOUDY_WEATHER;
             if (value == 11) return SHADE;
             if (value == 12) return DAYLIGHT_FLUORESCENT;
             if (value == 13) return DAY_WHITE_FLUORESCENT;
             if (value == 14) return COOL_WHITE_FLUORESCENT;
             if (value == 15) return WHITE_FLUORESCENT;
             if (value == 17) return STANDARD_LIGHT_A;
             if (value == 18) return STANDARD_LIGHT_B;
             if (value == 19) return STANDARD_LIGHT_C;
             if (value == 20) return D55;
             if (value == 21) return D65;
             if (value == 22) return D75;
             if (value == 23) return D50;
             if (value == 24) return ISO_STUDIO_TUNGSTEN;
             if (value == 255) return OTHER_LIGHT_SOURCE;

             return _UNKNOWN;
           }
       }
    public void setCalibrationIlluminant1 (final CalibrationIlluminant1 calibrationIlluminant1)
      {
        final CalibrationIlluminant1 oldValue = getCalibrationIlluminant1();
        final boolean oldPropAvailable = isCalibrationIlluminant1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CALIBRATION_ILLUMINANT_1, calibrationIlluminant1);
        propertyChangeSupport.firePropertyChange("calibrationIlluminant1", oldValue, calibrationIlluminant1);
        propertyChangeSupport.firePropertyChange("calibrationIlluminant1Available", oldPropAvailable, isCalibrationIlluminant1Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public CalibrationIlluminant1 getCalibrationIlluminant1()
      {
        return getObject(CALIBRATION_ILLUMINANT_1, CalibrationIlluminant1.class);
      }

    public void setCalibrationIlluminant1Available (final boolean available)
      {
        final CalibrationIlluminant1 oldValue = getCalibrationIlluminant1();
        final boolean oldPropAvailable = isCalibrationIlluminant1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CALIBRATION_ILLUMINANT_1))
          {
            setObject(CALIBRATION_ILLUMINANT_1, null);
          }
        else if (!available)
          {
            removeTag(CALIBRATION_ILLUMINANT_1);
          }

        propertyChangeSupport.firePropertyChange("calibrationIlluminant1Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("calibrationIlluminant1", oldValue, getCalibrationIlluminant1());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCalibrationIlluminant1Available()
      {
        return containsTag(CALIBRATION_ILLUMINANT_1);
      }

    public static enum CalibrationIlluminant2
       {
         UNKNOWN(0, "unknown"),
         DAYLIGHT(1, "Daylight"),
         FLUORESCENT(2, "Fluorescent"),
         TUNGSTEN(3, "Tungsten"),
         FLASH(4, "Flash"),
         FINE_WEATHER(9, "Fine weather"),
         CLOUDY_WEATHER(10, "Cloudy weather"),
         SHADE(11, "Shade"),
         DAYLIGHT_FLUORESCENT(12, "Daylight fluorescent"),
         DAY_WHITE_FLUORESCENT(13, "Day white fluorescent"),
         COOL_WHITE_FLUORESCENT(14, "Cool white fluorescent"),
         WHITE_FLUORESCENT(15, "White fluorescent"),
         STANDARD_LIGHT_A(17, "Standard light A"),
         STANDARD_LIGHT_B(18, "Standard light B"),
         STANDARD_LIGHT_C(19, "Standard light C"),
         D55(20, "D55"),
         D65(21, "D65"),
         D75(22, "D75"),
         D50(23, "D50"),
         ISO_STUDIO_TUNGSTEN(24, "ISO studio tungsten"),
         OTHER_LIGHT_SOURCE(255, "other light source"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private CalibrationIlluminant2 (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static CalibrationIlluminant2 fromInteger (int value)
           {
             if (value == 0) return UNKNOWN;
             if (value == 1) return DAYLIGHT;
             if (value == 2) return FLUORESCENT;
             if (value == 3) return TUNGSTEN;
             if (value == 4) return FLASH;
             if (value == 9) return FINE_WEATHER;
             if (value == 10) return CLOUDY_WEATHER;
             if (value == 11) return SHADE;
             if (value == 12) return DAYLIGHT_FLUORESCENT;
             if (value == 13) return DAY_WHITE_FLUORESCENT;
             if (value == 14) return COOL_WHITE_FLUORESCENT;
             if (value == 15) return WHITE_FLUORESCENT;
             if (value == 17) return STANDARD_LIGHT_A;
             if (value == 18) return STANDARD_LIGHT_B;
             if (value == 19) return STANDARD_LIGHT_C;
             if (value == 20) return D55;
             if (value == 21) return D65;
             if (value == 22) return D75;
             if (value == 23) return D50;
             if (value == 24) return ISO_STUDIO_TUNGSTEN;
             if (value == 255) return OTHER_LIGHT_SOURCE;

             return _UNKNOWN;
           }
       }
    public void setCalibrationIlluminant2 (final CalibrationIlluminant2 calibrationIlluminant2)
      {
        final CalibrationIlluminant2 oldValue = getCalibrationIlluminant2();
        final boolean oldPropAvailable = isCalibrationIlluminant2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CALIBRATION_ILLUMINANT_2, calibrationIlluminant2);
        propertyChangeSupport.firePropertyChange("calibrationIlluminant2", oldValue, calibrationIlluminant2);
        propertyChangeSupport.firePropertyChange("calibrationIlluminant2Available", oldPropAvailable, isCalibrationIlluminant2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public CalibrationIlluminant2 getCalibrationIlluminant2()
      {
        return getObject(CALIBRATION_ILLUMINANT_2, CalibrationIlluminant2.class);
      }

    public void setCalibrationIlluminant2Available (final boolean available)
      {
        final CalibrationIlluminant2 oldValue = getCalibrationIlluminant2();
        final boolean oldPropAvailable = isCalibrationIlluminant2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CALIBRATION_ILLUMINANT_2))
          {
            setObject(CALIBRATION_ILLUMINANT_2, null);
          }
        else if (!available)
          {
            removeTag(CALIBRATION_ILLUMINANT_2);
          }

        propertyChangeSupport.firePropertyChange("calibrationIlluminant2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("calibrationIlluminant2", oldValue, getCalibrationIlluminant2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCalibrationIlluminant2Available()
      {
        return containsTag(CALIBRATION_ILLUMINANT_2);
      }

    public void setColorMatrix1 (final Rational[] colorMatrix1)
      {
        final Rational[] oldValue = getColorMatrix1();
        final boolean oldPropAvailable = isColorMatrix1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COLOR_MATRIX_1, colorMatrix1);
        propertyChangeSupport.firePropertyChange("colorMatrix1", oldValue, colorMatrix1);
        propertyChangeSupport.firePropertyChange("colorMatrix1Available", oldPropAvailable, isColorMatrix1Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getColorMatrix1()
      {
        return getObject(COLOR_MATRIX_1, Rational[].class);
      }

    public void setColorMatrix1Available (final boolean available)
      {
        final Rational[] oldValue = getColorMatrix1();
        final boolean oldPropAvailable = isColorMatrix1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COLOR_MATRIX_1))
          {
            setObject(COLOR_MATRIX_1, null);
          }
        else if (!available)
          {
            removeTag(COLOR_MATRIX_1);
          }

        propertyChangeSupport.firePropertyChange("colorMatrix1Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("colorMatrix1", oldValue, getColorMatrix1());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isColorMatrix1Available()
      {
        return containsTag(COLOR_MATRIX_1);
      }

    public void setColorMatrix2 (final Rational[] colorMatrix2)
      {
        final Rational[] oldValue = getColorMatrix2();
        final boolean oldPropAvailable = isColorMatrix2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COLOR_MATRIX_2, colorMatrix2);
        propertyChangeSupport.firePropertyChange("colorMatrix2", oldValue, colorMatrix2);
        propertyChangeSupport.firePropertyChange("colorMatrix2Available", oldPropAvailable, isColorMatrix2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getColorMatrix2()
      {
        return getObject(COLOR_MATRIX_2, Rational[].class);
      }

    public void setColorMatrix2Available (final boolean available)
      {
        final Rational[] oldValue = getColorMatrix2();
        final boolean oldPropAvailable = isColorMatrix2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COLOR_MATRIX_2))
          {
            setObject(COLOR_MATRIX_2, null);
          }
        else if (!available)
          {
            removeTag(COLOR_MATRIX_2);
          }

        propertyChangeSupport.firePropertyChange("colorMatrix2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("colorMatrix2", oldValue, getColorMatrix2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isColorMatrix2Available()
      {
        return containsTag(COLOR_MATRIX_2);
      }

    public void setCameraCalibration1 (final Rational[] cameraCalibration1)
      {
        final Rational[] oldValue = getCameraCalibration1();
        final boolean oldPropAvailable = isCameraCalibration1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CAMERA_CALIBRATION_1, cameraCalibration1);
        propertyChangeSupport.firePropertyChange("cameraCalibration1", oldValue, cameraCalibration1);
        propertyChangeSupport.firePropertyChange("cameraCalibration1Available", oldPropAvailable, isCameraCalibration1Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getCameraCalibration1()
      {
        return getObject(CAMERA_CALIBRATION_1, Rational[].class);
      }

    public void setCameraCalibration1Available (final boolean available)
      {
        final Rational[] oldValue = getCameraCalibration1();
        final boolean oldPropAvailable = isCameraCalibration1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CAMERA_CALIBRATION_1))
          {
            setObject(CAMERA_CALIBRATION_1, null);
          }
        else if (!available)
          {
            removeTag(CAMERA_CALIBRATION_1);
          }

        propertyChangeSupport.firePropertyChange("cameraCalibration1Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("cameraCalibration1", oldValue, getCameraCalibration1());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCameraCalibration1Available()
      {
        return containsTag(CAMERA_CALIBRATION_1);
      }

    public void setCameraCalibration2 (final Rational[] cameraCalibration2)
      {
        final Rational[] oldValue = getCameraCalibration2();
        final boolean oldPropAvailable = isCameraCalibration2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CAMERA_CALIBRATION_2, cameraCalibration2);
        propertyChangeSupport.firePropertyChange("cameraCalibration2", oldValue, cameraCalibration2);
        propertyChangeSupport.firePropertyChange("cameraCalibration2Available", oldPropAvailable, isCameraCalibration2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getCameraCalibration2()
      {
        return getObject(CAMERA_CALIBRATION_2, Rational[].class);
      }

    public void setCameraCalibration2Available (final boolean available)
      {
        final Rational[] oldValue = getCameraCalibration2();
        final boolean oldPropAvailable = isCameraCalibration2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CAMERA_CALIBRATION_2))
          {
            setObject(CAMERA_CALIBRATION_2, null);
          }
        else if (!available)
          {
            removeTag(CAMERA_CALIBRATION_2);
          }

        propertyChangeSupport.firePropertyChange("cameraCalibration2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("cameraCalibration2", oldValue, getCameraCalibration2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCameraCalibration2Available()
      {
        return containsTag(CAMERA_CALIBRATION_2);
      }

    public void setReductionMatrix1 (final Rational[] reductionMatrix1)
      {
        final Rational[] oldValue = getReductionMatrix1();
        final boolean oldPropAvailable = isReductionMatrix1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.REDUCTION_MATRIX_1, reductionMatrix1);
        propertyChangeSupport.firePropertyChange("reductionMatrix1", oldValue, reductionMatrix1);
        propertyChangeSupport.firePropertyChange("reductionMatrix1Available", oldPropAvailable, isReductionMatrix1Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getReductionMatrix1()
      {
        return getObject(REDUCTION_MATRIX_1, Rational[].class);
      }

    public void setReductionMatrix1Available (final boolean available)
      {
        final Rational[] oldValue = getReductionMatrix1();
        final boolean oldPropAvailable = isReductionMatrix1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(REDUCTION_MATRIX_1))
          {
            setObject(REDUCTION_MATRIX_1, null);
          }
        else if (!available)
          {
            removeTag(REDUCTION_MATRIX_1);
          }

        propertyChangeSupport.firePropertyChange("reductionMatrix1Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("reductionMatrix1", oldValue, getReductionMatrix1());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isReductionMatrix1Available()
      {
        return containsTag(REDUCTION_MATRIX_1);
      }

    public void setReductionMatrix2 (final Rational[] reductionMatrix2)
      {
        final Rational[] oldValue = getReductionMatrix2();
        final boolean oldPropAvailable = isReductionMatrix2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.REDUCTION_MATRIX_2, reductionMatrix2);
        propertyChangeSupport.firePropertyChange("reductionMatrix2", oldValue, reductionMatrix2);
        propertyChangeSupport.firePropertyChange("reductionMatrix2Available", oldPropAvailable, isReductionMatrix2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getReductionMatrix2()
      {
        return getObject(REDUCTION_MATRIX_2, Rational[].class);
      }

    public void setReductionMatrix2Available (final boolean available)
      {
        final Rational[] oldValue = getReductionMatrix2();
        final boolean oldPropAvailable = isReductionMatrix2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(REDUCTION_MATRIX_2))
          {
            setObject(REDUCTION_MATRIX_2, null);
          }
        else if (!available)
          {
            removeTag(REDUCTION_MATRIX_2);
          }

        propertyChangeSupport.firePropertyChange("reductionMatrix2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("reductionMatrix2", oldValue, getReductionMatrix2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isReductionMatrix2Available()
      {
        return containsTag(REDUCTION_MATRIX_2);
      }

    public void setAnalogBalance (final Rational[] analogBalance)
      {
        final Rational[] oldValue = getAnalogBalance();
        final boolean oldPropAvailable = isAnalogBalanceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ANALOG_BALANCE, analogBalance);
        propertyChangeSupport.firePropertyChange("analogBalance", oldValue, analogBalance);
        propertyChangeSupport.firePropertyChange("analogBalanceAvailable", oldPropAvailable, isAnalogBalanceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getAnalogBalance()
      {
        return getObject(ANALOG_BALANCE, Rational[].class);
      }

    public void setAnalogBalanceAvailable (final boolean available)
      {
        final Rational[] oldValue = getAnalogBalance();
        final boolean oldPropAvailable = isAnalogBalanceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ANALOG_BALANCE))
          {
            setObject(ANALOG_BALANCE, null);
          }
        else if (!available)
          {
            removeTag(ANALOG_BALANCE);
          }

        propertyChangeSupport.firePropertyChange("analogBalanceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("analogBalance", oldValue, getAnalogBalance());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAnalogBalanceAvailable()
      {
        return containsTag(ANALOG_BALANCE);
      }

    public void setAsShotNeutral (final Rational[] asShotNeutral)
      {
        final Rational[] oldValue = getAsShotNeutral();
        final boolean oldPropAvailable = isAsShotNeutralAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.AS_SHOT_NEUTRAL, asShotNeutral);
        propertyChangeSupport.firePropertyChange("asShotNeutral", oldValue, asShotNeutral);
        propertyChangeSupport.firePropertyChange("asShotNeutralAvailable", oldPropAvailable, isAsShotNeutralAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getAsShotNeutral()
      {
        return getObject(AS_SHOT_NEUTRAL, Rational[].class);
      }

    public void setAsShotNeutralAvailable (final boolean available)
      {
        final Rational[] oldValue = getAsShotNeutral();
        final boolean oldPropAvailable = isAsShotNeutralAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AS_SHOT_NEUTRAL))
          {
            setObject(AS_SHOT_NEUTRAL, null);
          }
        else if (!available)
          {
            removeTag(AS_SHOT_NEUTRAL);
          }

        propertyChangeSupport.firePropertyChange("asShotNeutralAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("asShotNeutral", oldValue, getAsShotNeutral());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAsShotNeutralAvailable()
      {
        return containsTag(AS_SHOT_NEUTRAL);
      }

    public void setAsShotWhiteXY (final Rational[] asShotWhiteXY)
      {
        final Rational[] oldValue = getAsShotWhiteXY();
        final boolean oldPropAvailable = isAsShotWhiteXYAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.AS_SHOT_WHITE_XY, asShotWhiteXY);
        propertyChangeSupport.firePropertyChange("asShotWhiteXY", oldValue, asShotWhiteXY);
        propertyChangeSupport.firePropertyChange("asShotWhiteXYAvailable", oldPropAvailable, isAsShotWhiteXYAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getAsShotWhiteXY()
      {
        return getObject(AS_SHOT_WHITE_XY, Rational[].class);
      }

    public void setAsShotWhiteXYAvailable (final boolean available)
      {
        final Rational[] oldValue = getAsShotWhiteXY();
        final boolean oldPropAvailable = isAsShotWhiteXYAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AS_SHOT_WHITE_XY))
          {
            setObject(AS_SHOT_WHITE_XY, null);
          }
        else if (!available)
          {
            removeTag(AS_SHOT_WHITE_XY);
          }

        propertyChangeSupport.firePropertyChange("asShotWhiteXYAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("asShotWhiteXY", oldValue, getAsShotWhiteXY());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAsShotWhiteXYAvailable()
      {
        return containsTag(AS_SHOT_WHITE_XY);
      }

    public void setBaselineExposure (final Rational baselineExposure)
      {
        final Rational oldValue = getBaselineExposure();
        final boolean oldPropAvailable = isBaselineExposureAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BASELINE_EXPOSURE, baselineExposure);
        propertyChangeSupport.firePropertyChange("baselineExposure", oldValue, baselineExposure);
        propertyChangeSupport.firePropertyChange("baselineExposureAvailable", oldPropAvailable, isBaselineExposureAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getBaselineExposure()
      {
        return getObject(BASELINE_EXPOSURE, Rational.class);
      }

    public void setBaselineExposureAvailable (final boolean available)
      {
        final Rational oldValue = getBaselineExposure();
        final boolean oldPropAvailable = isBaselineExposureAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BASELINE_EXPOSURE))
          {
            setObject(BASELINE_EXPOSURE, null);
          }
        else if (!available)
          {
            removeTag(BASELINE_EXPOSURE);
          }

        propertyChangeSupport.firePropertyChange("baselineExposureAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("baselineExposure", oldValue, getBaselineExposure());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBaselineExposureAvailable()
      {
        return containsTag(BASELINE_EXPOSURE);
      }

    public void setBaselineNoise (final Rational baselineNoise)
      {
        final Rational oldValue = getBaselineNoise();
        final boolean oldPropAvailable = isBaselineNoiseAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BASELINE_NOISE, baselineNoise);
        propertyChangeSupport.firePropertyChange("baselineNoise", oldValue, baselineNoise);
        propertyChangeSupport.firePropertyChange("baselineNoiseAvailable", oldPropAvailable, isBaselineNoiseAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getBaselineNoise()
      {
        return getObject(BASELINE_NOISE, Rational.class);
      }

    public void setBaselineNoiseAvailable (final boolean available)
      {
        final Rational oldValue = getBaselineNoise();
        final boolean oldPropAvailable = isBaselineNoiseAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BASELINE_NOISE))
          {
            setObject(BASELINE_NOISE, null);
          }
        else if (!available)
          {
            removeTag(BASELINE_NOISE);
          }

        propertyChangeSupport.firePropertyChange("baselineNoiseAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("baselineNoise", oldValue, getBaselineNoise());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBaselineNoiseAvailable()
      {
        return containsTag(BASELINE_NOISE);
      }

    public void setBaselineSharpness (final Rational baselineSharpness)
      {
        final Rational oldValue = getBaselineSharpness();
        final boolean oldPropAvailable = isBaselineSharpnessAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BASELINE_SHARPNESS, baselineSharpness);
        propertyChangeSupport.firePropertyChange("baselineSharpness", oldValue, baselineSharpness);
        propertyChangeSupport.firePropertyChange("baselineSharpnessAvailable", oldPropAvailable, isBaselineSharpnessAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getBaselineSharpness()
      {
        return getObject(BASELINE_SHARPNESS, Rational.class);
      }

    public void setBaselineSharpnessAvailable (final boolean available)
      {
        final Rational oldValue = getBaselineSharpness();
        final boolean oldPropAvailable = isBaselineSharpnessAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BASELINE_SHARPNESS))
          {
            setObject(BASELINE_SHARPNESS, null);
          }
        else if (!available)
          {
            removeTag(BASELINE_SHARPNESS);
          }

        propertyChangeSupport.firePropertyChange("baselineSharpnessAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("baselineSharpness", oldValue, getBaselineSharpness());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBaselineSharpnessAvailable()
      {
        return containsTag(BASELINE_SHARPNESS);
      }

    public void setBayerGreenSplit (final Long bayerGreenSplit)
      {
        final Long oldValue = getBayerGreenSplit();
        final boolean oldPropAvailable = isBayerGreenSplitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.BAYER_GREEN_SPLIT, bayerGreenSplit);
        propertyChangeSupport.firePropertyChange("bayerGreenSplit", oldValue, bayerGreenSplit);
        propertyChangeSupport.firePropertyChange("bayerGreenSplitAvailable", oldPropAvailable, isBayerGreenSplitAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getBayerGreenSplit()
      {
        return getObject(BAYER_GREEN_SPLIT, Long.class);
      }

    public void setBayerGreenSplitAvailable (final boolean available)
      {
        final Long oldValue = getBayerGreenSplit();
        final boolean oldPropAvailable = isBayerGreenSplitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BAYER_GREEN_SPLIT))
          {
            setObject(BAYER_GREEN_SPLIT, null);
          }
        else if (!available)
          {
            removeTag(BAYER_GREEN_SPLIT);
          }

        propertyChangeSupport.firePropertyChange("bayerGreenSplitAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("bayerGreenSplit", oldValue, getBayerGreenSplit());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBayerGreenSplitAvailable()
      {
        return containsTag(BAYER_GREEN_SPLIT);
      }

    public void setLinearResponseLimit (final Rational linearResponseLimit)
      {
        final Rational oldValue = getLinearResponseLimit();
        final boolean oldPropAvailable = isLinearResponseLimitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.LINEAR_RESPONSE_LIMIT, linearResponseLimit);
        propertyChangeSupport.firePropertyChange("linearResponseLimit", oldValue, linearResponseLimit);
        propertyChangeSupport.firePropertyChange("linearResponseLimitAvailable", oldPropAvailable, isLinearResponseLimitAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getLinearResponseLimit()
      {
        return getObject(LINEAR_RESPONSE_LIMIT, Rational.class);
      }

    public void setLinearResponseLimitAvailable (final boolean available)
      {
        final Rational oldValue = getLinearResponseLimit();
        final boolean oldPropAvailable = isLinearResponseLimitAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(LINEAR_RESPONSE_LIMIT))
          {
            setObject(LINEAR_RESPONSE_LIMIT, null);
          }
        else if (!available)
          {
            removeTag(LINEAR_RESPONSE_LIMIT);
          }

        propertyChangeSupport.firePropertyChange("linearResponseLimitAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("linearResponseLimit", oldValue, getLinearResponseLimit());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isLinearResponseLimitAvailable()
      {
        return containsTag(LINEAR_RESPONSE_LIMIT);
      }

    public void setCameraSerialNumber (final String cameraSerialNumber)
      {
        final String oldValue = getCameraSerialNumber();
        final boolean oldPropAvailable = isCameraSerialNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CAMERA_SERIAL_NUMBER, cameraSerialNumber);
        propertyChangeSupport.firePropertyChange("cameraSerialNumber", oldValue, cameraSerialNumber);
        propertyChangeSupport.firePropertyChange("cameraSerialNumberAvailable", oldPropAvailable, isCameraSerialNumberAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCameraSerialNumber()
      {
        return getObject(CAMERA_SERIAL_NUMBER, String.class);
      }

    public void setCameraSerialNumberAvailable (final boolean available)
      {
        final String oldValue = getCameraSerialNumber();
        final boolean oldPropAvailable = isCameraSerialNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CAMERA_SERIAL_NUMBER))
          {
            setObject(CAMERA_SERIAL_NUMBER, null);
          }
        else if (!available)
          {
            removeTag(CAMERA_SERIAL_NUMBER);
          }

        propertyChangeSupport.firePropertyChange("cameraSerialNumberAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("cameraSerialNumber", oldValue, getCameraSerialNumber());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCameraSerialNumberAvailable()
      {
        return containsTag(CAMERA_SERIAL_NUMBER);
      }

    public void setLensInfo (final Rational[] lensInfo)
      {
        final Rational[] oldValue = getLensInfo();
        final boolean oldPropAvailable = isLensInfoAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.LENS_INFO, lensInfo);
        propertyChangeSupport.firePropertyChange("lensInfo", oldValue, lensInfo);
        propertyChangeSupport.firePropertyChange("lensInfoAvailable", oldPropAvailable, isLensInfoAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getLensInfo()
      {
        return getObject(LENS_INFO, Rational[].class);
      }

    public void setLensInfoAvailable (final boolean available)
      {
        final Rational[] oldValue = getLensInfo();
        final boolean oldPropAvailable = isLensInfoAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(LENS_INFO))
          {
            setObject(LENS_INFO, null);
          }
        else if (!available)
          {
            removeTag(LENS_INFO);
          }

        propertyChangeSupport.firePropertyChange("lensInfoAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("lensInfo", oldValue, getLensInfo());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isLensInfoAvailable()
      {
        return containsTag(LENS_INFO);
      }

    public void setChromaBlurRadius (final Rational chromaBlurRadius)
      {
        final Rational oldValue = getChromaBlurRadius();
        final boolean oldPropAvailable = isChromaBlurRadiusAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CHROMA_BLUR_RADIUS, chromaBlurRadius);
        propertyChangeSupport.firePropertyChange("chromaBlurRadius", oldValue, chromaBlurRadius);
        propertyChangeSupport.firePropertyChange("chromaBlurRadiusAvailable", oldPropAvailable, isChromaBlurRadiusAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getChromaBlurRadius()
      {
        return getObject(CHROMA_BLUR_RADIUS, Rational.class);
      }

    public void setChromaBlurRadiusAvailable (final boolean available)
      {
        final Rational oldValue = getChromaBlurRadius();
        final boolean oldPropAvailable = isChromaBlurRadiusAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CHROMA_BLUR_RADIUS))
          {
            setObject(CHROMA_BLUR_RADIUS, null);
          }
        else if (!available)
          {
            removeTag(CHROMA_BLUR_RADIUS);
          }

        propertyChangeSupport.firePropertyChange("chromaBlurRadiusAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("chromaBlurRadius", oldValue, getChromaBlurRadius());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isChromaBlurRadiusAvailable()
      {
        return containsTag(CHROMA_BLUR_RADIUS);
      }

    public void setAntiAliasStrength (final Rational antiAliasStrength)
      {
        final Rational oldValue = getAntiAliasStrength();
        final boolean oldPropAvailable = isAntiAliasStrengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ANTI_ALIAS_STRENGTH, antiAliasStrength);
        propertyChangeSupport.firePropertyChange("antiAliasStrength", oldValue, antiAliasStrength);
        propertyChangeSupport.firePropertyChange("antiAliasStrengthAvailable", oldPropAvailable, isAntiAliasStrengthAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getAntiAliasStrength()
      {
        return getObject(ANTI_ALIAS_STRENGTH, Rational.class);
      }

    public void setAntiAliasStrengthAvailable (final boolean available)
      {
        final Rational oldValue = getAntiAliasStrength();
        final boolean oldPropAvailable = isAntiAliasStrengthAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ANTI_ALIAS_STRENGTH))
          {
            setObject(ANTI_ALIAS_STRENGTH, null);
          }
        else if (!available)
          {
            removeTag(ANTI_ALIAS_STRENGTH);
          }

        propertyChangeSupport.firePropertyChange("antiAliasStrengthAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("antiAliasStrength", oldValue, getAntiAliasStrength());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAntiAliasStrengthAvailable()
      {
        return containsTag(ANTI_ALIAS_STRENGTH);
      }

    public void setDNGPrivateData (final byte[] DNGPrivateData)
      {
        final byte[] oldValue = getDNGPrivateData();
        final boolean oldPropAvailable = isDNGPrivateDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.DNG_PRIVATE_DATA, DNGPrivateData);
        propertyChangeSupport.firePropertyChange("DNGPrivateData", oldValue, DNGPrivateData);
        propertyChangeSupport.firePropertyChange("DNGPrivateDataAvailable", oldPropAvailable, isDNGPrivateDataAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getDNGPrivateData()
      {
        return getObject(DNG_PRIVATE_DATA, byte[].class);
      }

    public void setDNGPrivateDataAvailable (final boolean available)
      {
        final byte[] oldValue = getDNGPrivateData();
        final boolean oldPropAvailable = isDNGPrivateDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DNG_PRIVATE_DATA))
          {
            setObject(DNG_PRIVATE_DATA, null);
          }
        else if (!available)
          {
            removeTag(DNG_PRIVATE_DATA);
          }

        propertyChangeSupport.firePropertyChange("DNGPrivateDataAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("DNGPrivateData", oldValue, getDNGPrivateData());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDNGPrivateDataAvailable()
      {
        return containsTag(DNG_PRIVATE_DATA);
      }

    public void setMakerNoteSafety (final Integer makerNoteSafety)
      {
        final Integer oldValue = getMakerNoteSafety();
        final boolean oldPropAvailable = isMakerNoteSafetyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MAKER_NOTE_SAFETY, makerNoteSafety);
        propertyChangeSupport.firePropertyChange("makerNoteSafety", oldValue, makerNoteSafety);
        propertyChangeSupport.firePropertyChange("makerNoteSafetyAvailable", oldPropAvailable, isMakerNoteSafetyAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getMakerNoteSafety()
      {
        return getObject(MAKER_NOTE_SAFETY, Integer.class);
      }

    public void setMakerNoteSafetyAvailable (final boolean available)
      {
        final Integer oldValue = getMakerNoteSafety();
        final boolean oldPropAvailable = isMakerNoteSafetyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MAKER_NOTE_SAFETY))
          {
            setObject(MAKER_NOTE_SAFETY, null);
          }
        else if (!available)
          {
            removeTag(MAKER_NOTE_SAFETY);
          }

        propertyChangeSupport.firePropertyChange("makerNoteSafetyAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("makerNoteSafety", oldValue, getMakerNoteSafety());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isMakerNoteSafetyAvailable()
      {
        return containsTag(MAKER_NOTE_SAFETY);
      }

    public void setShadowScale (final Rational shadowScale)
      {
        final Rational oldValue = getShadowScale();
        final boolean oldPropAvailable = isShadowScaleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SHADOW_SCALE, shadowScale);
        propertyChangeSupport.firePropertyChange("shadowScale", oldValue, shadowScale);
        propertyChangeSupport.firePropertyChange("shadowScaleAvailable", oldPropAvailable, isShadowScaleAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getShadowScale()
      {
        return getObject(SHADOW_SCALE, Rational.class);
      }

    public void setShadowScaleAvailable (final boolean available)
      {
        final Rational oldValue = getShadowScale();
        final boolean oldPropAvailable = isShadowScaleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SHADOW_SCALE))
          {
            setObject(SHADOW_SCALE, null);
          }
        else if (!available)
          {
            removeTag(SHADOW_SCALE);
          }

        propertyChangeSupport.firePropertyChange("shadowScaleAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("shadowScale", oldValue, getShadowScale());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isShadowScaleAvailable()
      {
        return containsTag(SHADOW_SCALE);
      }

    public void setRawDataUniqueID (final byte[] rawDataUniqueID)
      {
        final byte[] oldValue = getRawDataUniqueID();
        final boolean oldPropAvailable = isRawDataUniqueIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.RAW_DATA_UNIQUE_ID, rawDataUniqueID);
        propertyChangeSupport.firePropertyChange("rawDataUniqueID", oldValue, rawDataUniqueID);
        propertyChangeSupport.firePropertyChange("rawDataUniqueIDAvailable", oldPropAvailable, isRawDataUniqueIDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getRawDataUniqueID()
      {
        return getObject(RAW_DATA_UNIQUE_ID, byte[].class);
      }

    public void setRawDataUniqueIDAvailable (final boolean available)
      {
        final byte[] oldValue = getRawDataUniqueID();
        final boolean oldPropAvailable = isRawDataUniqueIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(RAW_DATA_UNIQUE_ID))
          {
            setObject(RAW_DATA_UNIQUE_ID, null);
          }
        else if (!available)
          {
            removeTag(RAW_DATA_UNIQUE_ID);
          }

        propertyChangeSupport.firePropertyChange("rawDataUniqueIDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("rawDataUniqueID", oldValue, getRawDataUniqueID());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isRawDataUniqueIDAvailable()
      {
        return containsTag(RAW_DATA_UNIQUE_ID);
      }

    public void setOriginalRawFileName (final String originalRawFileName)
      {
        final String oldValue = getOriginalRawFileName();
        final boolean oldPropAvailable = isOriginalRawFileNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ORIGINAL_RAW_FILE_NAME, originalRawFileName);
        propertyChangeSupport.firePropertyChange("originalRawFileName", oldValue, originalRawFileName);
        propertyChangeSupport.firePropertyChange("originalRawFileNameAvailable", oldPropAvailable, isOriginalRawFileNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getOriginalRawFileName()
      {
        return getObject(ORIGINAL_RAW_FILE_NAME, String.class);
      }

    public void setOriginalRawFileNameAvailable (final boolean available)
      {
        final String oldValue = getOriginalRawFileName();
        final boolean oldPropAvailable = isOriginalRawFileNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ORIGINAL_RAW_FILE_NAME))
          {
            setObject(ORIGINAL_RAW_FILE_NAME, null);
          }
        else if (!available)
          {
            removeTag(ORIGINAL_RAW_FILE_NAME);
          }

        propertyChangeSupport.firePropertyChange("originalRawFileNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("originalRawFileName", oldValue, getOriginalRawFileName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isOriginalRawFileNameAvailable()
      {
        return containsTag(ORIGINAL_RAW_FILE_NAME);
      }

    public void setOriginalRawFileData (final byte[] originalRawFileData)
      {
        final byte[] oldValue = getOriginalRawFileData();
        final boolean oldPropAvailable = isOriginalRawFileDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ORIGINAL_RAW_FILE_DATA, originalRawFileData);
        propertyChangeSupport.firePropertyChange("originalRawFileData", oldValue, originalRawFileData);
        propertyChangeSupport.firePropertyChange("originalRawFileDataAvailable", oldPropAvailable, isOriginalRawFileDataAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getOriginalRawFileData()
      {
        return getObject(ORIGINAL_RAW_FILE_DATA, byte[].class);
      }

    public void setOriginalRawFileDataAvailable (final boolean available)
      {
        final byte[] oldValue = getOriginalRawFileData();
        final boolean oldPropAvailable = isOriginalRawFileDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ORIGINAL_RAW_FILE_DATA))
          {
            setObject(ORIGINAL_RAW_FILE_DATA, null);
          }
        else if (!available)
          {
            removeTag(ORIGINAL_RAW_FILE_DATA);
          }

        propertyChangeSupport.firePropertyChange("originalRawFileDataAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("originalRawFileData", oldValue, getOriginalRawFileData());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isOriginalRawFileDataAvailable()
      {
        return containsTag(ORIGINAL_RAW_FILE_DATA);
      }

    public void setActiveArea (final int[] activeArea)
      {
        final int[] oldValue = getActiveArea();
        final boolean oldPropAvailable = isActiveAreaAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ACTIVE_AREA, activeArea);
        propertyChangeSupport.firePropertyChange("activeArea", oldValue, activeArea);
        propertyChangeSupport.firePropertyChange("activeAreaAvailable", oldPropAvailable, isActiveAreaAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getActiveArea()
      {
        return getObject(ACTIVE_AREA, int[].class);
      }

    public void setActiveAreaAvailable (final boolean available)
      {
        final int[] oldValue = getActiveArea();
        final boolean oldPropAvailable = isActiveAreaAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ACTIVE_AREA))
          {
            setObject(ACTIVE_AREA, null);
          }
        else if (!available)
          {
            removeTag(ACTIVE_AREA);
          }

        propertyChangeSupport.firePropertyChange("activeAreaAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("activeArea", oldValue, getActiveArea());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isActiveAreaAvailable()
      {
        return containsTag(ACTIVE_AREA);
      }

    public void setMaskedAreas (final int[] maskedAreas)
      {
        final int[] oldValue = getMaskedAreas();
        final boolean oldPropAvailable = isMaskedAreasAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.MASKED_AREAS, maskedAreas);
        propertyChangeSupport.firePropertyChange("maskedAreas", oldValue, maskedAreas);
        propertyChangeSupport.firePropertyChange("maskedAreasAvailable", oldPropAvailable, isMaskedAreasAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getMaskedAreas()
      {
        return getObject(MASKED_AREAS, int[].class);
      }

    public void setMaskedAreasAvailable (final boolean available)
      {
        final int[] oldValue = getMaskedAreas();
        final boolean oldPropAvailable = isMaskedAreasAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MASKED_AREAS))
          {
            setObject(MASKED_AREAS, null);
          }
        else if (!available)
          {
            removeTag(MASKED_AREAS);
          }

        propertyChangeSupport.firePropertyChange("maskedAreasAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("maskedAreas", oldValue, getMaskedAreas());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isMaskedAreasAvailable()
      {
        return containsTag(MASKED_AREAS);
      }

    public void setAsShotICCProfile (final byte[] asShotICCProfile)
      {
        final byte[] oldValue = getAsShotICCProfile();
        final boolean oldPropAvailable = isAsShotICCProfileAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.AS_SHOT_ICC_PROFILE, asShotICCProfile);
        propertyChangeSupport.firePropertyChange("asShotICCProfile", oldValue, asShotICCProfile);
        propertyChangeSupport.firePropertyChange("asShotICCProfileAvailable", oldPropAvailable, isAsShotICCProfileAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getAsShotICCProfile()
      {
        return getObject(AS_SHOT_ICC_PROFILE, byte[].class);
      }

    public void setAsShotICCProfileAvailable (final boolean available)
      {
        final byte[] oldValue = getAsShotICCProfile();
        final boolean oldPropAvailable = isAsShotICCProfileAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AS_SHOT_ICC_PROFILE))
          {
            setObject(AS_SHOT_ICC_PROFILE, null);
          }
        else if (!available)
          {
            removeTag(AS_SHOT_ICC_PROFILE);
          }

        propertyChangeSupport.firePropertyChange("asShotICCProfileAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("asShotICCProfile", oldValue, getAsShotICCProfile());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAsShotICCProfileAvailable()
      {
        return containsTag(AS_SHOT_ICC_PROFILE);
      }

    public void setAsShotPreProfileMatrix (final Rational[] asShotPreProfileMatrix)
      {
        final Rational[] oldValue = getAsShotPreProfileMatrix();
        final boolean oldPropAvailable = isAsShotPreProfileMatrixAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.AS_SHOT_PRE_PROFILE_MATRIX, asShotPreProfileMatrix);
        propertyChangeSupport.firePropertyChange("asShotPreProfileMatrix", oldValue, asShotPreProfileMatrix);
        propertyChangeSupport.firePropertyChange("asShotPreProfileMatrixAvailable", oldPropAvailable, isAsShotPreProfileMatrixAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getAsShotPreProfileMatrix()
      {
        return getObject(AS_SHOT_PRE_PROFILE_MATRIX, Rational[].class);
      }

    public void setAsShotPreProfileMatrixAvailable (final boolean available)
      {
        final Rational[] oldValue = getAsShotPreProfileMatrix();
        final boolean oldPropAvailable = isAsShotPreProfileMatrixAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AS_SHOT_PRE_PROFILE_MATRIX))
          {
            setObject(AS_SHOT_PRE_PROFILE_MATRIX, null);
          }
        else if (!available)
          {
            removeTag(AS_SHOT_PRE_PROFILE_MATRIX);
          }

        propertyChangeSupport.firePropertyChange("asShotPreProfileMatrixAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("asShotPreProfileMatrix", oldValue, getAsShotPreProfileMatrix());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAsShotPreProfileMatrixAvailable()
      {
        return containsTag(AS_SHOT_PRE_PROFILE_MATRIX);
      }

    public void setCurrentICCProfile (final byte[] currentICCProfile)
      {
        final byte[] oldValue = getCurrentICCProfile();
        final boolean oldPropAvailable = isCurrentICCProfileAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CURRENT_ICC_PROFILE, currentICCProfile);
        propertyChangeSupport.firePropertyChange("currentICCProfile", oldValue, currentICCProfile);
        propertyChangeSupport.firePropertyChange("currentICCProfileAvailable", oldPropAvailable, isCurrentICCProfileAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getCurrentICCProfile()
      {
        return getObject(CURRENT_ICC_PROFILE, byte[].class);
      }

    public void setCurrentICCProfileAvailable (final boolean available)
      {
        final byte[] oldValue = getCurrentICCProfile();
        final boolean oldPropAvailable = isCurrentICCProfileAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CURRENT_ICC_PROFILE))
          {
            setObject(CURRENT_ICC_PROFILE, null);
          }
        else if (!available)
          {
            removeTag(CURRENT_ICC_PROFILE);
          }

        propertyChangeSupport.firePropertyChange("currentICCProfileAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("currentICCProfile", oldValue, getCurrentICCProfile());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCurrentICCProfileAvailable()
      {
        return containsTag(CURRENT_ICC_PROFILE);
      }

    public void setCurrentPreProfileMatrix (final Rational[] currentPreProfileMatrix)
      {
        final Rational[] oldValue = getCurrentPreProfileMatrix();
        final boolean oldPropAvailable = isCurrentPreProfileMatrixAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CURRENT_PRE_PROFILE_MATRIX, currentPreProfileMatrix);
        propertyChangeSupport.firePropertyChange("currentPreProfileMatrix", oldValue, currentPreProfileMatrix);
        propertyChangeSupport.firePropertyChange("currentPreProfileMatrixAvailable", oldPropAvailable, isCurrentPreProfileMatrixAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getCurrentPreProfileMatrix()
      {
        return getObject(CURRENT_PRE_PROFILE_MATRIX, Rational[].class);
      }

    public void setCurrentPreProfileMatrixAvailable (final boolean available)
      {
        final Rational[] oldValue = getCurrentPreProfileMatrix();
        final boolean oldPropAvailable = isCurrentPreProfileMatrixAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CURRENT_PRE_PROFILE_MATRIX))
          {
            setObject(CURRENT_PRE_PROFILE_MATRIX, null);
          }
        else if (!available)
          {
            removeTag(CURRENT_PRE_PROFILE_MATRIX);
          }

        propertyChangeSupport.firePropertyChange("currentPreProfileMatrixAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("currentPreProfileMatrix", oldValue, getCurrentPreProfileMatrix());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCurrentPreProfileMatrixAvailable()
      {
        return containsTag(CURRENT_PRE_PROFILE_MATRIX);
      }

    public void setColorimetricReference (final Integer colorimetricReference)
      {
        final Integer oldValue = getColorimetricReference();
        final boolean oldPropAvailable = isColorimetricReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.COLORIMETRIC_REFERENCE, colorimetricReference);
        propertyChangeSupport.firePropertyChange("colorimetricReference", oldValue, colorimetricReference);
        propertyChangeSupport.firePropertyChange("colorimetricReferenceAvailable", oldPropAvailable, isColorimetricReferenceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getColorimetricReference()
      {
        return getObject(COLORIMETRIC_REFERENCE, Integer.class);
      }

    public void setColorimetricReferenceAvailable (final boolean available)
      {
        final Integer oldValue = getColorimetricReference();
        final boolean oldPropAvailable = isColorimetricReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COLORIMETRIC_REFERENCE))
          {
            setObject(COLORIMETRIC_REFERENCE, null);
          }
        else if (!available)
          {
            removeTag(COLORIMETRIC_REFERENCE);
          }

        propertyChangeSupport.firePropertyChange("colorimetricReferenceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("colorimetricReference", oldValue, getColorimetricReference());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isColorimetricReferenceAvailable()
      {
        return containsTag(COLORIMETRIC_REFERENCE);
      }

    public void setCameraCalibrationSignature (final String cameraCalibrationSignature)
      {
        final String oldValue = getCameraCalibrationSignature();
        final boolean oldPropAvailable = isCameraCalibrationSignatureAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.CAMERA_CALIBRATION_SIGNATURE, cameraCalibrationSignature);
        propertyChangeSupport.firePropertyChange("cameraCalibrationSignature", oldValue, cameraCalibrationSignature);
        propertyChangeSupport.firePropertyChange("cameraCalibrationSignatureAvailable", oldPropAvailable, isCameraCalibrationSignatureAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCameraCalibrationSignature()
      {
        return getObject(CAMERA_CALIBRATION_SIGNATURE, String.class);
      }

    public void setCameraCalibrationSignatureAvailable (final boolean available)
      {
        final String oldValue = getCameraCalibrationSignature();
        final boolean oldPropAvailable = isCameraCalibrationSignatureAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CAMERA_CALIBRATION_SIGNATURE))
          {
            setObject(CAMERA_CALIBRATION_SIGNATURE, null);
          }
        else if (!available)
          {
            removeTag(CAMERA_CALIBRATION_SIGNATURE);
          }

        propertyChangeSupport.firePropertyChange("cameraCalibrationSignatureAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("cameraCalibrationSignature", oldValue, getCameraCalibrationSignature());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCameraCalibrationSignatureAvailable()
      {
        return containsTag(CAMERA_CALIBRATION_SIGNATURE);
      }

    public void setProfileCalibrationSignature (final String profileCalibrationSignature)
      {
        final String oldValue = getProfileCalibrationSignature();
        final boolean oldPropAvailable = isProfileCalibrationSignatureAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_CALIBRATION_SIGNATURE, profileCalibrationSignature);
        propertyChangeSupport.firePropertyChange("profileCalibrationSignature", oldValue, profileCalibrationSignature);
        propertyChangeSupport.firePropertyChange("profileCalibrationSignatureAvailable", oldPropAvailable, isProfileCalibrationSignatureAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getProfileCalibrationSignature()
      {
        return getObject(PROFILE_CALIBRATION_SIGNATURE, String.class);
      }

    public void setProfileCalibrationSignatureAvailable (final boolean available)
      {
        final String oldValue = getProfileCalibrationSignature();
        final boolean oldPropAvailable = isProfileCalibrationSignatureAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_CALIBRATION_SIGNATURE))
          {
            setObject(PROFILE_CALIBRATION_SIGNATURE, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_CALIBRATION_SIGNATURE);
          }

        propertyChangeSupport.firePropertyChange("profileCalibrationSignatureAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileCalibrationSignature", oldValue, getProfileCalibrationSignature());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileCalibrationSignatureAvailable()
      {
        return containsTag(PROFILE_CALIBRATION_SIGNATURE);
      }

    public void setExtraCameraProfiles (final int[] extraCameraProfiles)
      {
        final int[] oldValue = getExtraCameraProfiles();
        final boolean oldPropAvailable = isExtraCameraProfilesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.EXTRA_CAMERA_PROFILES, extraCameraProfiles);
        propertyChangeSupport.firePropertyChange("extraCameraProfiles", oldValue, extraCameraProfiles);
        propertyChangeSupport.firePropertyChange("extraCameraProfilesAvailable", oldPropAvailable, isExtraCameraProfilesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getExtraCameraProfiles()
      {
        return getObject(EXTRA_CAMERA_PROFILES, int[].class);
      }

    public void setExtraCameraProfilesAvailable (final boolean available)
      {
        final int[] oldValue = getExtraCameraProfiles();
        final boolean oldPropAvailable = isExtraCameraProfilesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXTRA_CAMERA_PROFILES))
          {
            setObject(EXTRA_CAMERA_PROFILES, null);
          }
        else if (!available)
          {
            removeTag(EXTRA_CAMERA_PROFILES);
          }

        propertyChangeSupport.firePropertyChange("extraCameraProfilesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("extraCameraProfiles", oldValue, getExtraCameraProfiles());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExtraCameraProfilesAvailable()
      {
        return containsTag(EXTRA_CAMERA_PROFILES);
      }

    public void setAsShotProfileName (final String asShotProfileName)
      {
        final String oldValue = getAsShotProfileName();
        final boolean oldPropAvailable = isAsShotProfileNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.AS_SHOT_PROFILE_NAME, asShotProfileName);
        propertyChangeSupport.firePropertyChange("asShotProfileName", oldValue, asShotProfileName);
        propertyChangeSupport.firePropertyChange("asShotProfileNameAvailable", oldPropAvailable, isAsShotProfileNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAsShotProfileName()
      {
        return getObject(AS_SHOT_PROFILE_NAME, String.class);
      }

    public void setAsShotProfileNameAvailable (final boolean available)
      {
        final String oldValue = getAsShotProfileName();
        final boolean oldPropAvailable = isAsShotProfileNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AS_SHOT_PROFILE_NAME))
          {
            setObject(AS_SHOT_PROFILE_NAME, null);
          }
        else if (!available)
          {
            removeTag(AS_SHOT_PROFILE_NAME);
          }

        propertyChangeSupport.firePropertyChange("asShotProfileNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("asShotProfileName", oldValue, getAsShotProfileName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAsShotProfileNameAvailable()
      {
        return containsTag(AS_SHOT_PROFILE_NAME);
      }

    public void setNoiseResolutionApplied (final Rational noiseResolutionApplied)
      {
        final Rational oldValue = getNoiseResolutionApplied();
        final boolean oldPropAvailable = isNoiseResolutionAppliedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.NOISE_RESOLUTION_APPLIED, noiseResolutionApplied);
        propertyChangeSupport.firePropertyChange("noiseResolutionApplied", oldValue, noiseResolutionApplied);
        propertyChangeSupport.firePropertyChange("noiseResolutionAppliedAvailable", oldPropAvailable, isNoiseResolutionAppliedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational getNoiseResolutionApplied()
      {
        return getObject(NOISE_RESOLUTION_APPLIED, Rational.class);
      }

    public void setNoiseResolutionAppliedAvailable (final boolean available)
      {
        final Rational oldValue = getNoiseResolutionApplied();
        final boolean oldPropAvailable = isNoiseResolutionAppliedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(NOISE_RESOLUTION_APPLIED))
          {
            setObject(NOISE_RESOLUTION_APPLIED, null);
          }
        else if (!available)
          {
            removeTag(NOISE_RESOLUTION_APPLIED);
          }

        propertyChangeSupport.firePropertyChange("noiseResolutionAppliedAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("noiseResolutionApplied", oldValue, getNoiseResolutionApplied());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isNoiseResolutionAppliedAvailable()
      {
        return containsTag(NOISE_RESOLUTION_APPLIED);
      }

    public void setProfileName (final String profileName)
      {
        final String oldValue = getProfileName();
        final boolean oldPropAvailable = isProfileNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_NAME, profileName);
        propertyChangeSupport.firePropertyChange("profileName", oldValue, profileName);
        propertyChangeSupport.firePropertyChange("profileNameAvailable", oldPropAvailable, isProfileNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getProfileName()
      {
        return getObject(PROFILE_NAME, String.class);
      }

    public void setProfileNameAvailable (final boolean available)
      {
        final String oldValue = getProfileName();
        final boolean oldPropAvailable = isProfileNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_NAME))
          {
            setObject(PROFILE_NAME, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_NAME);
          }

        propertyChangeSupport.firePropertyChange("profileNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileName", oldValue, getProfileName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileNameAvailable()
      {
        return containsTag(PROFILE_NAME);
      }

    public void setProfileHueSatMapDims (final int[] profileHueSatMapDims)
      {
        final int[] oldValue = getProfileHueSatMapDims();
        final boolean oldPropAvailable = isProfileHueSatMapDimsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_HUE_SAT_MAP_DIMS, profileHueSatMapDims);
        propertyChangeSupport.firePropertyChange("profileHueSatMapDims", oldValue, profileHueSatMapDims);
        propertyChangeSupport.firePropertyChange("profileHueSatMapDimsAvailable", oldPropAvailable, isProfileHueSatMapDimsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getProfileHueSatMapDims()
      {
        return getObject(PROFILE_HUE_SAT_MAP_DIMS, int[].class);
      }

    public void setProfileHueSatMapDimsAvailable (final boolean available)
      {
        final int[] oldValue = getProfileHueSatMapDims();
        final boolean oldPropAvailable = isProfileHueSatMapDimsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_HUE_SAT_MAP_DIMS))
          {
            setObject(PROFILE_HUE_SAT_MAP_DIMS, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_HUE_SAT_MAP_DIMS);
          }

        propertyChangeSupport.firePropertyChange("profileHueSatMapDimsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileHueSatMapDims", oldValue, getProfileHueSatMapDims());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileHueSatMapDimsAvailable()
      {
        return containsTag(PROFILE_HUE_SAT_MAP_DIMS);
      }

    public void setProfileHueSatMapData1 (final Float[] profileHueSatMapData1)
      {
        final Float[] oldValue = getProfileHueSatMapData1();
        final boolean oldPropAvailable = isProfileHueSatMapData1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_HUE_SAT_MAP_DATA_1, profileHueSatMapData1);
        propertyChangeSupport.firePropertyChange("profileHueSatMapData1", oldValue, profileHueSatMapData1);
        propertyChangeSupport.firePropertyChange("profileHueSatMapData1Available", oldPropAvailable, isProfileHueSatMapData1Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Float[] getProfileHueSatMapData1()
      {
        return getObject(PROFILE_HUE_SAT_MAP_DATA_1, Float[].class);
      }

    public void setProfileHueSatMapData1Available (final boolean available)
      {
        final Float[] oldValue = getProfileHueSatMapData1();
        final boolean oldPropAvailable = isProfileHueSatMapData1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_HUE_SAT_MAP_DATA_1))
          {
            setObject(PROFILE_HUE_SAT_MAP_DATA_1, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_HUE_SAT_MAP_DATA_1);
          }

        propertyChangeSupport.firePropertyChange("profileHueSatMapData1Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileHueSatMapData1", oldValue, getProfileHueSatMapData1());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileHueSatMapData1Available()
      {
        return containsTag(PROFILE_HUE_SAT_MAP_DATA_1);
      }

    public void setProfileHueSatMapData2 (final Float[] profileHueSatMapData2)
      {
        final Float[] oldValue = getProfileHueSatMapData2();
        final boolean oldPropAvailable = isProfileHueSatMapData2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_HUE_SAT_MAP_DATA_2, profileHueSatMapData2);
        propertyChangeSupport.firePropertyChange("profileHueSatMapData2", oldValue, profileHueSatMapData2);
        propertyChangeSupport.firePropertyChange("profileHueSatMapData2Available", oldPropAvailable, isProfileHueSatMapData2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Float[] getProfileHueSatMapData2()
      {
        return getObject(PROFILE_HUE_SAT_MAP_DATA_2, Float[].class);
      }

    public void setProfileHueSatMapData2Available (final boolean available)
      {
        final Float[] oldValue = getProfileHueSatMapData2();
        final boolean oldPropAvailable = isProfileHueSatMapData2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_HUE_SAT_MAP_DATA_2))
          {
            setObject(PROFILE_HUE_SAT_MAP_DATA_2, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_HUE_SAT_MAP_DATA_2);
          }

        propertyChangeSupport.firePropertyChange("profileHueSatMapData2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileHueSatMapData2", oldValue, getProfileHueSatMapData2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileHueSatMapData2Available()
      {
        return containsTag(PROFILE_HUE_SAT_MAP_DATA_2);
      }

    public void setProfileToneCurve (final Float[] profileToneCurve)
      {
        final Float[] oldValue = getProfileToneCurve();
        final boolean oldPropAvailable = isProfileToneCurveAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_TONE_CURVE, profileToneCurve);
        propertyChangeSupport.firePropertyChange("profileToneCurve", oldValue, profileToneCurve);
        propertyChangeSupport.firePropertyChange("profileToneCurveAvailable", oldPropAvailable, isProfileToneCurveAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Float[] getProfileToneCurve()
      {
        return getObject(PROFILE_TONE_CURVE, Float[].class);
      }

    public void setProfileToneCurveAvailable (final boolean available)
      {
        final Float[] oldValue = getProfileToneCurve();
        final boolean oldPropAvailable = isProfileToneCurveAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_TONE_CURVE))
          {
            setObject(PROFILE_TONE_CURVE, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_TONE_CURVE);
          }

        propertyChangeSupport.firePropertyChange("profileToneCurveAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileToneCurve", oldValue, getProfileToneCurve());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileToneCurveAvailable()
      {
        return containsTag(PROFILE_TONE_CURVE);
      }

    public static enum ProfileEmbedPolicy
       {
         ALLOW_COPYING(0, "allow copying"),
         EMBED_IF_USED(1, "embed if used"),
         EMBED_NEVER(2, "embed never"),
         NO_RESTRICTIONS(3, "no restrictions"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private ProfileEmbedPolicy (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static ProfileEmbedPolicy fromInteger (int value)
           {
             if (value == 0) return ALLOW_COPYING;
             if (value == 1) return EMBED_IF_USED;
             if (value == 2) return EMBED_NEVER;
             if (value == 3) return NO_RESTRICTIONS;

             return _UNKNOWN;
           }
       }
    public void setProfileEmbedPolicy (final ProfileEmbedPolicy profileEmbedPolicy)
      {
        final ProfileEmbedPolicy oldValue = getProfileEmbedPolicy();
        final boolean oldPropAvailable = isProfileEmbedPolicyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_EMBED_POLICY, profileEmbedPolicy);
        propertyChangeSupport.firePropertyChange("profileEmbedPolicy", oldValue, profileEmbedPolicy);
        propertyChangeSupport.firePropertyChange("profileEmbedPolicyAvailable", oldPropAvailable, isProfileEmbedPolicyAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public ProfileEmbedPolicy getProfileEmbedPolicy()
      {
        return getObject(PROFILE_EMBED_POLICY, ProfileEmbedPolicy.class);
      }

    public void setProfileEmbedPolicyAvailable (final boolean available)
      {
        final ProfileEmbedPolicy oldValue = getProfileEmbedPolicy();
        final boolean oldPropAvailable = isProfileEmbedPolicyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_EMBED_POLICY))
          {
            setObject(PROFILE_EMBED_POLICY, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_EMBED_POLICY);
          }

        propertyChangeSupport.firePropertyChange("profileEmbedPolicyAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileEmbedPolicy", oldValue, getProfileEmbedPolicy());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileEmbedPolicyAvailable()
      {
        return containsTag(PROFILE_EMBED_POLICY);
      }

    public void setProfileCopyright (final String profileCopyright)
      {
        final String oldValue = getProfileCopyright();
        final boolean oldPropAvailable = isProfileCopyrightAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_COPYRIGHT, profileCopyright);
        propertyChangeSupport.firePropertyChange("profileCopyright", oldValue, profileCopyright);
        propertyChangeSupport.firePropertyChange("profileCopyrightAvailable", oldPropAvailable, isProfileCopyrightAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getProfileCopyright()
      {
        return getObject(PROFILE_COPYRIGHT, String.class);
      }

    public void setProfileCopyrightAvailable (final boolean available)
      {
        final String oldValue = getProfileCopyright();
        final boolean oldPropAvailable = isProfileCopyrightAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_COPYRIGHT))
          {
            setObject(PROFILE_COPYRIGHT, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_COPYRIGHT);
          }

        propertyChangeSupport.firePropertyChange("profileCopyrightAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileCopyright", oldValue, getProfileCopyright());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileCopyrightAvailable()
      {
        return containsTag(PROFILE_COPYRIGHT);
      }

    public void setForwardMatrix1 (final Rational[] forwardMatrix1)
      {
        final Rational[] oldValue = getForwardMatrix1();
        final boolean oldPropAvailable = isForwardMatrix1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FORWARD_MATRIX_1, forwardMatrix1);
        propertyChangeSupport.firePropertyChange("forwardMatrix1", oldValue, forwardMatrix1);
        propertyChangeSupport.firePropertyChange("forwardMatrix1Available", oldPropAvailable, isForwardMatrix1Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getForwardMatrix1()
      {
        return getObject(FORWARD_MATRIX_1, Rational[].class);
      }

    public void setForwardMatrix1Available (final boolean available)
      {
        final Rational[] oldValue = getForwardMatrix1();
        final boolean oldPropAvailable = isForwardMatrix1Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FORWARD_MATRIX_1))
          {
            setObject(FORWARD_MATRIX_1, null);
          }
        else if (!available)
          {
            removeTag(FORWARD_MATRIX_1);
          }

        propertyChangeSupport.firePropertyChange("forwardMatrix1Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("forwardMatrix1", oldValue, getForwardMatrix1());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isForwardMatrix1Available()
      {
        return containsTag(FORWARD_MATRIX_1);
      }

    public void setForwardMatrix2 (final Rational[] forwardMatrix2)
      {
        final Rational[] oldValue = getForwardMatrix2();
        final boolean oldPropAvailable = isForwardMatrix2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.FORWARD_MATRIX_2, forwardMatrix2);
        propertyChangeSupport.firePropertyChange("forwardMatrix2", oldValue, forwardMatrix2);
        propertyChangeSupport.firePropertyChange("forwardMatrix2Available", oldPropAvailable, isForwardMatrix2Available());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Rational[] getForwardMatrix2()
      {
        return getObject(FORWARD_MATRIX_2, Rational[].class);
      }

    public void setForwardMatrix2Available (final boolean available)
      {
        final Rational[] oldValue = getForwardMatrix2();
        final boolean oldPropAvailable = isForwardMatrix2Available();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FORWARD_MATRIX_2))
          {
            setObject(FORWARD_MATRIX_2, null);
          }
        else if (!available)
          {
            removeTag(FORWARD_MATRIX_2);
          }

        propertyChangeSupport.firePropertyChange("forwardMatrix2Available", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("forwardMatrix2", oldValue, getForwardMatrix2());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isForwardMatrix2Available()
      {
        return containsTag(FORWARD_MATRIX_2);
      }

    public void setPreviewApplicationName (final String previewApplicationName)
      {
        final String oldValue = getPreviewApplicationName();
        final boolean oldPropAvailable = isPreviewApplicationNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PREVIEW_APPLICATION_NAME, previewApplicationName);
        propertyChangeSupport.firePropertyChange("previewApplicationName", oldValue, previewApplicationName);
        propertyChangeSupport.firePropertyChange("previewApplicationNameAvailable", oldPropAvailable, isPreviewApplicationNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getPreviewApplicationName()
      {
        return getObject(PREVIEW_APPLICATION_NAME, String.class);
      }

    public void setPreviewApplicationNameAvailable (final boolean available)
      {
        final String oldValue = getPreviewApplicationName();
        final boolean oldPropAvailable = isPreviewApplicationNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PREVIEW_APPLICATION_NAME))
          {
            setObject(PREVIEW_APPLICATION_NAME, null);
          }
        else if (!available)
          {
            removeTag(PREVIEW_APPLICATION_NAME);
          }

        propertyChangeSupport.firePropertyChange("previewApplicationNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("previewApplicationName", oldValue, getPreviewApplicationName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPreviewApplicationNameAvailable()
      {
        return containsTag(PREVIEW_APPLICATION_NAME);
      }

    public void setPreviewApplicationVersion (final String previewApplicationVersion)
      {
        final String oldValue = getPreviewApplicationVersion();
        final boolean oldPropAvailable = isPreviewApplicationVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PREVIEW_APPLICATION_VERSION, previewApplicationVersion);
        propertyChangeSupport.firePropertyChange("previewApplicationVersion", oldValue, previewApplicationVersion);
        propertyChangeSupport.firePropertyChange("previewApplicationVersionAvailable", oldPropAvailable, isPreviewApplicationVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getPreviewApplicationVersion()
      {
        return getObject(PREVIEW_APPLICATION_VERSION, String.class);
      }

    public void setPreviewApplicationVersionAvailable (final boolean available)
      {
        final String oldValue = getPreviewApplicationVersion();
        final boolean oldPropAvailable = isPreviewApplicationVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PREVIEW_APPLICATION_VERSION))
          {
            setObject(PREVIEW_APPLICATION_VERSION, null);
          }
        else if (!available)
          {
            removeTag(PREVIEW_APPLICATION_VERSION);
          }

        propertyChangeSupport.firePropertyChange("previewApplicationVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("previewApplicationVersion", oldValue, getPreviewApplicationVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPreviewApplicationVersionAvailable()
      {
        return containsTag(PREVIEW_APPLICATION_VERSION);
      }

    public void setPreviewSettingsName (final String previewSettingsName)
      {
        final String oldValue = getPreviewSettingsName();
        final boolean oldPropAvailable = isPreviewSettingsNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PREVIEW_SETTINGS_NAME, previewSettingsName);
        propertyChangeSupport.firePropertyChange("previewSettingsName", oldValue, previewSettingsName);
        propertyChangeSupport.firePropertyChange("previewSettingsNameAvailable", oldPropAvailable, isPreviewSettingsNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getPreviewSettingsName()
      {
        return getObject(PREVIEW_SETTINGS_NAME, String.class);
      }

    public void setPreviewSettingsNameAvailable (final boolean available)
      {
        final String oldValue = getPreviewSettingsName();
        final boolean oldPropAvailable = isPreviewSettingsNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PREVIEW_SETTINGS_NAME))
          {
            setObject(PREVIEW_SETTINGS_NAME, null);
          }
        else if (!available)
          {
            removeTag(PREVIEW_SETTINGS_NAME);
          }

        propertyChangeSupport.firePropertyChange("previewSettingsNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("previewSettingsName", oldValue, getPreviewSettingsName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPreviewSettingsNameAvailable()
      {
        return containsTag(PREVIEW_SETTINGS_NAME);
      }

    public void setPreviewIFD (final byte[] previewIFD)
      {
        final byte[] oldValue = getPreviewIFD();
        final boolean oldPropAvailable = isPreviewIFDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PREVIEW_IFD, previewIFD);
        propertyChangeSupport.firePropertyChange("previewIFD", oldValue, previewIFD);
        propertyChangeSupport.firePropertyChange("previewIFDAvailable", oldPropAvailable, isPreviewIFDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getPreviewIFD()
      {
        return getObject(PREVIEW_IFD, byte[].class);
      }

    public void setPreviewIFDAvailable (final boolean available)
      {
        final byte[] oldValue = getPreviewIFD();
        final boolean oldPropAvailable = isPreviewIFDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PREVIEW_IFD))
          {
            setObject(PREVIEW_IFD, null);
          }
        else if (!available)
          {
            removeTag(PREVIEW_IFD);
          }

        propertyChangeSupport.firePropertyChange("previewIFDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("previewIFD", oldValue, getPreviewIFD());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPreviewIFDAvailable()
      {
        return containsTag(PREVIEW_IFD);
      }

    public static enum PreviewColorSpace
       {
         UNKNOWN(0, "Unknown"),
         GRAY_GAMMA_22(1, "Gray Gamma 22"),
         SRGB(2, "sRGB"),
         ADOBE_RGB(3, "Adobe RGB"),
         PROPHOTO_RGB(4, "ProPhoto RGB"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private PreviewColorSpace (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static PreviewColorSpace fromInteger (int value)
           {
             if (value == 0) return UNKNOWN;
             if (value == 1) return GRAY_GAMMA_22;
             if (value == 2) return SRGB;
             if (value == 3) return ADOBE_RGB;
             if (value == 4) return PROPHOTO_RGB;

             return _UNKNOWN;
           }
       }
    public void setPreviewColorSpace (final PreviewColorSpace previewColorSpace)
      {
        final PreviewColorSpace oldValue = getPreviewColorSpace();
        final boolean oldPropAvailable = isPreviewColorSpaceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PREVIEW_COLOR_SPACE, previewColorSpace);
        propertyChangeSupport.firePropertyChange("previewColorSpace", oldValue, previewColorSpace);
        propertyChangeSupport.firePropertyChange("previewColorSpaceAvailable", oldPropAvailable, isPreviewColorSpaceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public PreviewColorSpace getPreviewColorSpace()
      {
        return getObject(PREVIEW_COLOR_SPACE, PreviewColorSpace.class);
      }

    public void setPreviewColorSpaceAvailable (final boolean available)
      {
        final PreviewColorSpace oldValue = getPreviewColorSpace();
        final boolean oldPropAvailable = isPreviewColorSpaceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PREVIEW_COLOR_SPACE))
          {
            setObject(PREVIEW_COLOR_SPACE, null);
          }
        else if (!available)
          {
            removeTag(PREVIEW_COLOR_SPACE);
          }

        propertyChangeSupport.firePropertyChange("previewColorSpaceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("previewColorSpace", oldValue, getPreviewColorSpace());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPreviewColorSpaceAvailable()
      {
        return containsTag(PREVIEW_COLOR_SPACE);
      }

    public void setPreviewDateTime (final String previewDateTime)
      {
        final String oldValue = getPreviewDateTime();
        final boolean oldPropAvailable = isPreviewDateTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PREVIEW_DATE_TIME, previewDateTime);
        propertyChangeSupport.firePropertyChange("previewDateTime", oldValue, previewDateTime);
        propertyChangeSupport.firePropertyChange("previewDateTimeAvailable", oldPropAvailable, isPreviewDateTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getPreviewDateTime()
      {
        return getObject(PREVIEW_DATE_TIME, String.class);
      }

    public void setPreviewDateTimeAvailable (final boolean available)
      {
        final String oldValue = getPreviewDateTime();
        final boolean oldPropAvailable = isPreviewDateTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PREVIEW_DATE_TIME))
          {
            setObject(PREVIEW_DATE_TIME, null);
          }
        else if (!available)
          {
            removeTag(PREVIEW_DATE_TIME);
          }

        propertyChangeSupport.firePropertyChange("previewDateTimeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("previewDateTime", oldValue, getPreviewDateTime());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPreviewDateTimeAvailable()
      {
        return containsTag(PREVIEW_DATE_TIME);
      }

    public void setRawImageDigest (final byte[] rawImageDigest)
      {
        final byte[] oldValue = getRawImageDigest();
        final boolean oldPropAvailable = isRawImageDigestAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.RAW_IMAGE_DIGEST, rawImageDigest);
        propertyChangeSupport.firePropertyChange("rawImageDigest", oldValue, rawImageDigest);
        propertyChangeSupport.firePropertyChange("rawImageDigestAvailable", oldPropAvailable, isRawImageDigestAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getRawImageDigest()
      {
        return getObject(RAW_IMAGE_DIGEST, byte[].class);
      }

    public void setRawImageDigestAvailable (final boolean available)
      {
        final byte[] oldValue = getRawImageDigest();
        final boolean oldPropAvailable = isRawImageDigestAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(RAW_IMAGE_DIGEST))
          {
            setObject(RAW_IMAGE_DIGEST, null);
          }
        else if (!available)
          {
            removeTag(RAW_IMAGE_DIGEST);
          }

        propertyChangeSupport.firePropertyChange("rawImageDigestAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("rawImageDigest", oldValue, getRawImageDigest());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isRawImageDigestAvailable()
      {
        return containsTag(RAW_IMAGE_DIGEST);
      }

    public void setOriginalRawFileDigest (final byte[] originalRawFileDigest)
      {
        final byte[] oldValue = getOriginalRawFileDigest();
        final boolean oldPropAvailable = isOriginalRawFileDigestAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ORIGINAL_RAW_FILE_DIGEST, originalRawFileDigest);
        propertyChangeSupport.firePropertyChange("originalRawFileDigest", oldValue, originalRawFileDigest);
        propertyChangeSupport.firePropertyChange("originalRawFileDigestAvailable", oldPropAvailable, isOriginalRawFileDigestAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getOriginalRawFileDigest()
      {
        return getObject(ORIGINAL_RAW_FILE_DIGEST, byte[].class);
      }

    public void setOriginalRawFileDigestAvailable (final boolean available)
      {
        final byte[] oldValue = getOriginalRawFileDigest();
        final boolean oldPropAvailable = isOriginalRawFileDigestAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ORIGINAL_RAW_FILE_DIGEST))
          {
            setObject(ORIGINAL_RAW_FILE_DIGEST, null);
          }
        else if (!available)
          {
            removeTag(ORIGINAL_RAW_FILE_DIGEST);
          }

        propertyChangeSupport.firePropertyChange("originalRawFileDigestAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("originalRawFileDigest", oldValue, getOriginalRawFileDigest());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isOriginalRawFileDigestAvailable()
      {
        return containsTag(ORIGINAL_RAW_FILE_DIGEST);
      }

    public void setSubTileBlockSize (final int[] subTileBlockSize)
      {
        final int[] oldValue = getSubTileBlockSize();
        final boolean oldPropAvailable = isSubTileBlockSizeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.SUB_TILE_BLOCK_SIZE, subTileBlockSize);
        propertyChangeSupport.firePropertyChange("subTileBlockSize", oldValue, subTileBlockSize);
        propertyChangeSupport.firePropertyChange("subTileBlockSizeAvailable", oldPropAvailable, isSubTileBlockSizeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getSubTileBlockSize()
      {
        return getObject(SUB_TILE_BLOCK_SIZE, int[].class);
      }

    public void setSubTileBlockSizeAvailable (final boolean available)
      {
        final int[] oldValue = getSubTileBlockSize();
        final boolean oldPropAvailable = isSubTileBlockSizeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUB_TILE_BLOCK_SIZE))
          {
            setObject(SUB_TILE_BLOCK_SIZE, null);
          }
        else if (!available)
          {
            removeTag(SUB_TILE_BLOCK_SIZE);
          }

        propertyChangeSupport.firePropertyChange("subTileBlockSizeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subTileBlockSize", oldValue, getSubTileBlockSize());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubTileBlockSizeAvailable()
      {
        return containsTag(SUB_TILE_BLOCK_SIZE);
      }

    public void setRowInterleaveFactor (final Long rowInterleaveFactor)
      {
        final Long oldValue = getRowInterleaveFactor();
        final boolean oldPropAvailable = isRowInterleaveFactorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.ROW_INTERLEAVE_FACTOR, rowInterleaveFactor);
        propertyChangeSupport.firePropertyChange("rowInterleaveFactor", oldValue, rowInterleaveFactor);
        propertyChangeSupport.firePropertyChange("rowInterleaveFactorAvailable", oldPropAvailable, isRowInterleaveFactorAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Long getRowInterleaveFactor()
      {
        return getObject(ROW_INTERLEAVE_FACTOR, Long.class);
      }

    public void setRowInterleaveFactorAvailable (final boolean available)
      {
        final Long oldValue = getRowInterleaveFactor();
        final boolean oldPropAvailable = isRowInterleaveFactorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ROW_INTERLEAVE_FACTOR))
          {
            setObject(ROW_INTERLEAVE_FACTOR, null);
          }
        else if (!available)
          {
            removeTag(ROW_INTERLEAVE_FACTOR);
          }

        propertyChangeSupport.firePropertyChange("rowInterleaveFactorAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("rowInterleaveFactor", oldValue, getRowInterleaveFactor());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isRowInterleaveFactorAvailable()
      {
        return containsTag(ROW_INTERLEAVE_FACTOR);
      }

    public void setProfileLookTableDims (final int[] profileLookTableDims)
      {
        final int[] oldValue = getProfileLookTableDims();
        final boolean oldPropAvailable = isProfileLookTableDimsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_LOOK_TABLE_DIMS, profileLookTableDims);
        propertyChangeSupport.firePropertyChange("profileLookTableDims", oldValue, profileLookTableDims);
        propertyChangeSupport.firePropertyChange("profileLookTableDimsAvailable", oldPropAvailable, isProfileLookTableDimsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public int[] getProfileLookTableDims()
      {
        return getObject(PROFILE_LOOK_TABLE_DIMS, int[].class);
      }

    public void setProfileLookTableDimsAvailable (final boolean available)
      {
        final int[] oldValue = getProfileLookTableDims();
        final boolean oldPropAvailable = isProfileLookTableDimsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_LOOK_TABLE_DIMS))
          {
            setObject(PROFILE_LOOK_TABLE_DIMS, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_LOOK_TABLE_DIMS);
          }

        propertyChangeSupport.firePropertyChange("profileLookTableDimsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileLookTableDims", oldValue, getProfileLookTableDims());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileLookTableDimsAvailable()
      {
        return containsTag(PROFILE_LOOK_TABLE_DIMS);
      }

    public void setProfileLookTableData (final Float[] profileLookTableData)
      {
        final Float[] oldValue = getProfileLookTableData();
        final boolean oldPropAvailable = isProfileLookTableDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(EXIFDirectoryGenerated.PROFILE_LOOK_TABLE_DATA, profileLookTableData);
        propertyChangeSupport.firePropertyChange("profileLookTableData", oldValue, profileLookTableData);
        propertyChangeSupport.firePropertyChange("profileLookTableDataAvailable", oldPropAvailable, isProfileLookTableDataAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Float[] getProfileLookTableData()
      {
        return getObject(PROFILE_LOOK_TABLE_DATA, Float[].class);
      }

    public void setProfileLookTableDataAvailable (final boolean available)
      {
        final Float[] oldValue = getProfileLookTableData();
        final boolean oldPropAvailable = isProfileLookTableDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROFILE_LOOK_TABLE_DATA))
          {
            setObject(PROFILE_LOOK_TABLE_DATA, null);
          }
        else if (!available)
          {
            removeTag(PROFILE_LOOK_TABLE_DATA);
          }

        propertyChangeSupport.firePropertyChange("profileLookTableDataAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("profileLookTableData", oldValue, getProfileLookTableData());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProfileLookTableDataAvailable()
      {
        return containsTag(PROFILE_LOOK_TABLE_DATA);
      }

    public boolean isAvailable()
      {
        return isNewSubFileTypeAvailable()
             | isSubFileTypeAvailable()
             | isImageWidthAvailable()
             | isImageLengthAvailable()
             | isBitsPerSampleAvailable()
             | isCompressionAvailable()
             | isPhotometricInterpretationAvailable()
             | isThresholdingAvailable()
             | isCellWidthAvailable()
             | isCellLengthAvailable()
             | isFillOrderAvailable()
             | isDocumentNameAvailable()
             | isImageDescriptionAvailable()
             | isMakeAvailable()
             | isModelAvailable()
             | isStripOffsetsAvailable()
             | isOrientationAvailable()
             | isSamplesPerPixelAvailable()
             | isRowsPerStripAvailable()
             | isStripByteCountsAvailable()
             | isMinSampleValueAvailable()
             | isMaxSampleValueAvailable()
             | isXResolutionAvailable()
             | isYResolutionAvailable()
             | isPlanarConfigurationAvailable()
             | isPageNameAvailable()
             | isXPositionAvailable()
             | isYPositionAvailable()
             | isFreeOffsetsAvailable()
             | isFreeByteCountsAvailable()
             | isGrayResponseUnitAvailable()
             | isGrayResponseCurveAvailable()
             | isGroup3OptionsAvailable()
             | isGroup4OptionsAvailable()
             | isResolutionUnitAvailable()
             | isPageNumberAvailable()
             | isColorResponseUnitAvailable()
             | isTransferFunctionAvailable()
             | isSoftwareAvailable()
             | isDateTimeAvailable()
             | isArtistAvailable()
             | isHostComputerAvailable()
             | isPredictorAvailable()
             | isWhitePointAvailable()
             | isPrimaryChromaticitiesAvailable()
             | isTileWidthAvailable()
             | isTileLengthAvailable()
             | isTileOffsetsAvailable()
             | isTileByteCountsAvailable()
             | isBadFaxLinesAvailable()
             | isCleanFaxDataAvailable()
             | isConsecutiveBadFaxLinesAvailable()
             | isSubIFDsAvailable()
             | isInkSetAvailable()
             | isInkNamesAvailable()
             | isNumberOfInksAvailable()
             | isDotRangeAvailable()
             | isTargetPrinterAvailable()
             | isExtraSamplesAvailable()
             | isSampleFormatAvailable()
             | isTransferRangeAvailable()
             | isClipPathAvailable()
             | isXClipPathUnitsAvailable()
             | isYClipPathUnitsAvailable()
             | isIndexedAvailable()
             | isJPEGTablesAvailable()
             | isOPIProxyAvailable()
             | isJPEGProcAvailable()
             | isJPEGInterchangeFormatAvailable()
             | isJPEGInterchangeFormatLengthAvailable()
             | isJPEGRestartIntervalAvailable()
             | isJPEGLosslessPredictorsAvailable()
             | isJPEGPointTransformsAvailable()
             | isJPEGQTablesAvailable()
             | isJPEGDCTablesAvailable()
             | isJPEGACTablesAvailable()
             | isYCbCrCoefficientsAvailable()
             | isYCbCrSubsamplingAvailable()
             | isYCbCrPositioningAvailable()
             | isReferenceBlackWhiteAvailable()
             | isXMPAvailable()
             | isImageIDAvailable()
             | isWangAnnotationAvailable()
             | isCFARepeatPatternDimAvailable()
             | isCFAPatternAvailable()
             | isBatteryLevelAvailable()
             | isCopyrightAvailable()
             | isExposureTimeAvailable()
             | isFNumberAvailable()
             | isIPTCNAAAvailable()
             | isModelPixelScaleTagAvailable()
             | isIntergraphMatrixTagAvailable()
             | isModelTiepointTagAvailable()
             | isSiteAvailable()
             | isColorSequenceAvailable()
             | isIT8HeaderAvailable()
             | isRasterPaddingAvailable()
             | isBitsPerRunLengthAvailable()
             | isBitsPerExtendedRunLengthAvailable()
             | isColorTableAvailable()
             | isImageColorIndicatorAvailable()
             | isBackgroundColorIndicatorAvailable()
             | isImageColorValueAvailable()
             | isBackgroundColorValueAvailable()
             | isPixelIntensityRangeAvailable()
             | isTransparencyIndicatorAvailable()
             | isColorCharacterizationAvailable()
             | isHCUsageAvailable()
             | isModelTransformationTagAvailable()
             | isPhotoshopImageResourcesAvailable()
             | isExifIFDPointerAvailable()
             | isInterColourProfileAvailable()
             | isGeoKeyDirectoryTagAvailable()
             | isGeoDoubleParamsTagAvailable()
             | isGeoAsciiParamsTagAvailable()
             | isExposureProgramAvailable()
             | isSpectralSensitivityAvailable()
             | isGPSInfoIFDPointerAvailable()
             | isISOSpeedRatingsAvailable()
             | isOECFAvailable()
             | isInterlaceAvailable()
             | isTimeZoneOffsetAvailable()
             | isSelfTimerModeAvailable()
             | isEXIFVersionAvailable()
             | isDateTimeOriginalAvailable()
             | isDateTimeDigitizedAvailable()
             | isComponentConfigurationAvailable()
             | isCompressedBitsPerPixelAvailable()
             | isShutterSpeedValueAvailable()
             | isApertureValueAvailable()
             | isBrightnessValueAvailable()
             | isExposureBiasValueAvailable()
             | isMaxApertureValueAvailable()
             | isSubjectDistanceAvailable()
             | isMeteringModeAvailable()
             | isLightSourceAvailable()
             | isFlashAvailable()
             | isFocalLengthAvailable()
             | isFlashEnergy2Available()
             | isSpatialFrequencyResponse2Available()
             | isNoiseAvailable()
             | isFocalPlaneXResolution2Available()
             | isFocalPlaneYResolution2Available()
             | isFocalPlaneResolutionUnit2Available()
             | isImageNumberAvailable()
             | isSecurityClassificationAvailable()
             | isImageHistoryAvailable()
             | isSubjectAreaAvailable()
             | isExposureIndex2Available()
             | isTIFF_EPStandardIDAvailable()
             | isSensingMethod2Available()
             | isMakerNoteAvailable()
             | isUserCommentAvailable()
             | isSubsecTimeAvailable()
             | isSubsecTimeOriginalAvailable()
             | isSubsecTimeDigitizedAvailable()
             | isImageSourceDataAvailable()
             | isFlashPixVersionAvailable()
             | isColorSpaceAvailable()
             | isPixelXDimensionAvailable()
             | isPixelYDimensionAvailable()
             | isRelatedSoundFileAvailable()
             | isInteroperabilityIFDAvailable()
             | isFlashEnergyAvailable()
             | isSpatialFrequencyResponseAvailable()
             | isFocalPlaneXResolutionAvailable()
             | isFocalPlaneYResolutionAvailable()
             | isFocalPlaneResolutionUnitAvailable()
             | isSubjectLocationAvailable()
             | isExposureIndexAvailable()
             | isSensingMethodAvailable()
             | isFileSourceAvailable()
             | isSceneTypeAvailable()
             | isEXIFCFAPatternAvailable()
             | isCustomRenderedAvailable()
             | isExposureModeAvailable()
             | isWhiteBalanceAvailable()
             | isDigitalZoomRatioAvailable()
             | isFocalLength35mmFilmAvailable()
             | isSceneCaptureTypeAvailable()
             | isGainControlAvailable()
             | isContrastAvailable()
             | isSaturationAvailable()
             | isSharpnessAvailable()
             | isDeviceSettingDescriptionAvailable()
             | isSubjectDistanceRangeAvailable()
             | isImageUniqueIDAvailable()
             | isPhotoshopAnnotationsAvailable()
             | isThumbnailAvailable()
             | isDNGVersionAvailable()
             | isDNGBackwardVersionAvailable()
             | isUniqueCameraModelAvailable()
             | isLocalizedCameraModelAvailable()
             | isCFAPlaneColorAvailable()
             | isCFALayoutAvailable()
             | isLinearizationTableAvailable()
             | isBlackLevelRepeatDimAvailable()
             | isBlackLevelAvailable()
             | isBlackLevelDeltaHAvailable()
             | isBlackLevelDeltaVAvailable()
             | isWhiteLevelAvailable()
             | isDefaultScaleAvailable()
             | isBestQualityScaleAvailable()
             | isDefaultCropOriginAvailable()
             | isDefaultCropSizeAvailable()
             | isCalibrationIlluminant1Available()
             | isCalibrationIlluminant2Available()
             | isColorMatrix1Available()
             | isColorMatrix2Available()
             | isCameraCalibration1Available()
             | isCameraCalibration2Available()
             | isReductionMatrix1Available()
             | isReductionMatrix2Available()
             | isAnalogBalanceAvailable()
             | isAsShotNeutralAvailable()
             | isAsShotWhiteXYAvailable()
             | isBaselineExposureAvailable()
             | isBaselineNoiseAvailable()
             | isBaselineSharpnessAvailable()
             | isBayerGreenSplitAvailable()
             | isLinearResponseLimitAvailable()
             | isCameraSerialNumberAvailable()
             | isLensInfoAvailable()
             | isChromaBlurRadiusAvailable()
             | isAntiAliasStrengthAvailable()
             | isDNGPrivateDataAvailable()
             | isMakerNoteSafetyAvailable()
             | isShadowScaleAvailable()
             | isRawDataUniqueIDAvailable()
             | isOriginalRawFileNameAvailable()
             | isOriginalRawFileDataAvailable()
             | isActiveAreaAvailable()
             | isMaskedAreasAvailable()
             | isAsShotICCProfileAvailable()
             | isAsShotPreProfileMatrixAvailable()
             | isCurrentICCProfileAvailable()
             | isCurrentPreProfileMatrixAvailable()
             | isColorimetricReferenceAvailable()
             | isCameraCalibrationSignatureAvailable()
             | isProfileCalibrationSignatureAvailable()
             | isExtraCameraProfilesAvailable()
             | isAsShotProfileNameAvailable()
             | isNoiseResolutionAppliedAvailable()
             | isProfileNameAvailable()
             | isProfileHueSatMapDimsAvailable()
             | isProfileHueSatMapData1Available()
             | isProfileHueSatMapData2Available()
             | isProfileToneCurveAvailable()
             | isProfileEmbedPolicyAvailable()
             | isProfileCopyrightAvailable()
             | isForwardMatrix1Available()
             | isForwardMatrix2Available()
             | isPreviewApplicationNameAvailable()
             | isPreviewApplicationVersionAvailable()
             | isPreviewSettingsNameAvailable()
             | isPreviewIFDAvailable()
             | isPreviewColorSpaceAvailable()
             | isPreviewDateTimeAvailable()
             | isRawImageDigestAvailable()
             | isOriginalRawFileDigestAvailable()
             | isSubTileBlockSizeAvailable()
             | isRowInterleaveFactorAvailable()
             | isProfileLookTableDimsAvailable()
             | isProfileLookTableDataAvailable()
;
      }
  }
