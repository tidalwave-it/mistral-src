package it.tidalwave.image.metadata;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import it.tidalwave.image.Rational;

/* Automatically generated on Thu Jan 01 01:00:00 CET 1970 - DO NOT EDIT! */

public class IPTCDirectoryGenerated extends Directory
  {
    private final static long serialVersionUID = 2056233055989339523L;
    private final static Map<Integer, String> descriptionMapByTag = new HashMap<Integer, String>();

    public IPTCDirectoryGenerated()
      {
      }

    public IPTCDirectoryGenerated (final Date latestModificationTime)
      {
        super(latestModificationTime);
      }

    public final static int APPLICATION_RECORD_VERSION = 0;
    public final static int OBJECT_TYPE_REFERENCE = 3;
    public final static int OBJECT_ATTRIBUTE_REFERENCE = 4;
    public final static int OBJECT_NAME = 5;
    public final static int EDIT_STATUS = 7;
    public final static int EDITORIAL_UPDATE = 8;
    public final static int URGENCY = 10;
    public final static int SUBJECT_REFERENCE = 12;
    public final static int CATEGORY = 15;
    public final static int SUPPLEMENTAL_CATEGORIES = 20;
    public final static int FIXTURE_IDENTIFIER = 22;
    public final static int KEYWORDS = 25;
    public final static int CONTENT_LOCATION_CODE = 26;
    public final static int CONTENT_LOCATION_NAME = 27;
    public final static int RELEASE_DATE = 30;
    public final static int RELEASE_TIME = 35;
    public final static int EXPIRATION_DATE = 37;
    public final static int EXPIRATION_TIME = 38;
    public final static int SPECIAL_INSTRUCTIONS = 40;
    public final static int ACTION_ADVISED = 42;
    public final static int REFERENCE_SERVICE = 45;
    public final static int REFERENCE_DATE = 47;
    public final static int REFERENCE_NUMBER = 50;
    public final static int DATE_CREATED = 55;
    public final static int TIME_CREATED = 60;
    public final static int DIGITAL_CREATION_DATE = 62;
    public final static int DIGITAL_CREATION_TIME = 63;
    public final static int ORIGINATING_PROGRAM = 65;
    public final static int PROGRAM_VERSION = 70;
    public final static int OBJECT_CYCLE = 75;
    public final static int BYLINE = 80;
    public final static int BYLINE_TITLE = 85;
    public final static int CITY = 90;
    public final static int SUBLOCATION = 92;
    public final static int PROVINCESTATE = 95;
    public final static int COUNTRYPRIMARY_LOCATION_CODE = 100;
    public final static int COUNTRYPRIMARY_LOCATION_NAME = 101;
    public final static int ORIGINAL_TRANSMISSION_REFERENCE = 103;
    public final static int HEADLINE = 105;
    public final static int CREDIT = 110;
    public final static int SOURCE = 115;
    public final static int COPYRIGHT_NOTICE = 116;
    public final static int CONTACT = 118;
    public final static int CAPTIONABSTRACT = 120;
    public final static int LOCAL_CAPTION = 121;
    public final static int WRITEREDITOR = 122;
    public final static int RASTERIZED_CAPTION = 125;
    public final static int IMAGE_TYPE = 130;
    public final static int IMAGE_ORIENTATION = 131;
    public final static int LANGUAGE_IDENTIFIER = 135;
    public final static int AUDIO_TYPE = 150;
    public final static int AUDIO_SAMPLING_RATE = 151;
    public final static int AUDIO_SAMPLING_RESOLUTION = 152;
    public final static int AUDIO_DURATION = 153;
    public final static int AUDIO_OUTCUE = 154;
    public final static int JOB_ID = 184;
    public final static int MASTER_DOCUMENT_ID = 185;
    public final static int SHORT_DOCUMENT_ID = 186;
    public final static int UNIQUE_DOCUMENT_ID = 187;
    public final static int OWNER_ID = 188;
    public final static int OBJECT_PREVIEW_FILE_FORMAT = 200;
    public final static int OBJECT_PREVIEW_FILE_VERSION = 201;
    public final static int OBJECT_PREVIEW_DATA = 202;
    public final static int PREFS = 221;
    public final static int CLASSIFY_STATE = 225;
    public final static int SIMILARITY_INDEX = 228;
    public final static int DOCUMENT_NOTES = 230;
    public final static int DOCUMENT_HISTORY = 231;
    public final static int EXIF_CAMERA_INFO = 232;
    public final static int ADOBE_CREATOR_ADDRESS = 100000;
    public final static int ADOBE_CREATOR_CITY = 100001;
    public final static int ADOBE_CREATOR_STATE__PROVINCE = 100002;
    public final static int ADOBE_CREATOR_POSTAL_CODE = 100003;
    public final static int ADOBE_CREATOR_COUNTRY = 100004;
    public final static int ADOBE_CREATOR_PHONE = 100005;
    public final static int ADOBE_CREATOR_EMAIL = 100006;
    public final static int ADOBE_CREATOR_WEBSITE = 100007;
    public final static int ADOBE_IPTC_SUBJECT_CODE = 100010;
    public final static int ADOBE_INTELLECTUAL_GENRE = 100020;
    public final static int ADOBE_SCENE = 100021;
    public final static int ADOBE_LOCATION = 100022;
    public final static int ADOBE_COUNTRY_ISO_CODE = 100023;
    public final static int ADOBE_COPYRIGHT_STATUS = 100030;
    public final static int ADOBE_RIGHT_USAGE_TERMS = 100031;
    public final static int ADOBE_COPYRIGHT_INFO_URL = 100032;

    @Override
    public String getTagName (int tag)
      {
        return (String)descriptionMapByTag.get(tag);
      }
    static
      {
        descriptionMapByTag.put(0, "Application Record Version");
        descriptionMapByTag.put(3, "Object Type Reference");
        descriptionMapByTag.put(4, "Object Attribute Reference");
        descriptionMapByTag.put(5, "Object Name");
        descriptionMapByTag.put(7, "Edit Status");
        descriptionMapByTag.put(8, "Editorial Update");
        descriptionMapByTag.put(10, "Urgency");
        descriptionMapByTag.put(12, "Subject Reference");
        descriptionMapByTag.put(15, "Category");
        descriptionMapByTag.put(20, "Supplemental Categories");
        descriptionMapByTag.put(22, "Fixture Identifier");
        descriptionMapByTag.put(25, "Keywords");
        descriptionMapByTag.put(26, "Content Location Code");
        descriptionMapByTag.put(27, "Content Location Name");
        descriptionMapByTag.put(30, "Release Date");
        descriptionMapByTag.put(35, "Release Time");
        descriptionMapByTag.put(37, "Expiration Date");
        descriptionMapByTag.put(38, "Expiration Time");
        descriptionMapByTag.put(40, "Special Instructions");
        descriptionMapByTag.put(42, "Action Advised");
        descriptionMapByTag.put(45, "Reference Service");
        descriptionMapByTag.put(47, "Reference Date");
        descriptionMapByTag.put(50, "Reference Number");
        descriptionMapByTag.put(55, "Date Created");
        descriptionMapByTag.put(60, "Time Created");
        descriptionMapByTag.put(62, "Digital Creation Date");
        descriptionMapByTag.put(63, "Digital Creation Time");
        descriptionMapByTag.put(65, "Originating Program");
        descriptionMapByTag.put(70, "Program Version");
        descriptionMapByTag.put(75, "Object Cycle");
        descriptionMapByTag.put(80, "By-line");
        descriptionMapByTag.put(85, "By-line Title");
        descriptionMapByTag.put(90, "City");
        descriptionMapByTag.put(92, "Sub-location");
        descriptionMapByTag.put(95, "Province-State");
        descriptionMapByTag.put(100, "Country-Primary Location Code");
        descriptionMapByTag.put(101, "Country-Primary Location Name");
        descriptionMapByTag.put(103, "Original Transmission Reference");
        descriptionMapByTag.put(105, "Headline");
        descriptionMapByTag.put(110, "Credit");
        descriptionMapByTag.put(115, "Source");
        descriptionMapByTag.put(116, "Copyright Notice");
        descriptionMapByTag.put(118, "Contact");
        descriptionMapByTag.put(120, "Caption-Abstract");
        descriptionMapByTag.put(121, "Local Caption");
        descriptionMapByTag.put(122, "Writer-Editor");
        descriptionMapByTag.put(125, "Rasterized Caption");
        descriptionMapByTag.put(130, "Image Type");
        descriptionMapByTag.put(131, "Image Orientation");
        descriptionMapByTag.put(135, "Language Identifier");
        descriptionMapByTag.put(150, "Audio Type");
        descriptionMapByTag.put(151, "Audio Sampling Rate");
        descriptionMapByTag.put(152, "Audio Sampling Resolution");
        descriptionMapByTag.put(153, "Audio Duration");
        descriptionMapByTag.put(154, "Audio Outcue");
        descriptionMapByTag.put(184, "Job ID");
        descriptionMapByTag.put(185, "Master Document ID");
        descriptionMapByTag.put(186, "Short Document ID");
        descriptionMapByTag.put(187, "Unique Document ID");
        descriptionMapByTag.put(188, "Owner ID");
        descriptionMapByTag.put(200, "Object Preview File Format");
        descriptionMapByTag.put(201, "Object Preview File Version");
        descriptionMapByTag.put(202, "Object Preview Data");
        descriptionMapByTag.put(221, "Prefs");
        descriptionMapByTag.put(225, "Classify State");
        descriptionMapByTag.put(228, "Similarity Index");
        descriptionMapByTag.put(230, "Document Notes");
        descriptionMapByTag.put(231, "Document History");
        descriptionMapByTag.put(232, "EXIF Camera Info");
        descriptionMapByTag.put(100000, "Adobe Creator Address");
        descriptionMapByTag.put(100001, "Adobe Creator City");
        descriptionMapByTag.put(100002, "Adobe Creator State  Province");
        descriptionMapByTag.put(100003, "Adobe Creator Postal Code");
        descriptionMapByTag.put(100004, "Adobe Creator Country");
        descriptionMapByTag.put(100005, "Adobe Creator Phone");
        descriptionMapByTag.put(100006, "Adobe Creator Email");
        descriptionMapByTag.put(100007, "Adobe Creator Website");
        descriptionMapByTag.put(100010, "Adobe IPTC Subject Code");
        descriptionMapByTag.put(100020, "Adobe Intellectual Genre");
        descriptionMapByTag.put(100021, "Adobe Scene");
        descriptionMapByTag.put(100022, "Adobe Location");
        descriptionMapByTag.put(100023, "Adobe Country ISO Code");
        descriptionMapByTag.put(100030, "Adobe Copyright Status");
        descriptionMapByTag.put(100031, "Adobe Right Usage Terms");
        descriptionMapByTag.put(100032, "Adobe Copyright Info URL");

      }
    public void setApplicationRecordVersion (final Integer applicationRecordVersion)
      {
        final Integer oldValue = getApplicationRecordVersion();
        final boolean oldPropAvailable = isApplicationRecordVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.APPLICATION_RECORD_VERSION, applicationRecordVersion);
        propertyChangeSupport.firePropertyChange("applicationRecordVersion", oldValue, applicationRecordVersion);
        propertyChangeSupport.firePropertyChange("applicationRecordVersionAvailable", oldPropAvailable, isApplicationRecordVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getApplicationRecordVersion()
      {
        return getObject(APPLICATION_RECORD_VERSION, Integer.class);
      }

    public void setApplicationRecordVersionAvailable (final boolean available)
      {
        final Integer oldValue = getApplicationRecordVersion();
        final boolean oldPropAvailable = isApplicationRecordVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(APPLICATION_RECORD_VERSION))
          {
            setObject(APPLICATION_RECORD_VERSION, null);
          }
        else if (!available)
          {
            removeTag(APPLICATION_RECORD_VERSION);
          }

        propertyChangeSupport.firePropertyChange("applicationRecordVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("applicationRecordVersion", oldValue, getApplicationRecordVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isApplicationRecordVersionAvailable()
      {
        return containsTag(APPLICATION_RECORD_VERSION);
      }

    public void setObjectTypeReference (final String objectTypeReference)
      {
        final String oldValue = getObjectTypeReference();
        final boolean oldPropAvailable = isObjectTypeReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECT_TYPE_REFERENCE, objectTypeReference);
        propertyChangeSupport.firePropertyChange("objectTypeReference", oldValue, objectTypeReference);
        propertyChangeSupport.firePropertyChange("objectTypeReferenceAvailable", oldPropAvailable, isObjectTypeReferenceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getObjectTypeReference()
      {
        return getObject(OBJECT_TYPE_REFERENCE, String.class);
      }

    public void setObjectTypeReferenceAvailable (final boolean available)
      {
        final String oldValue = getObjectTypeReference();
        final boolean oldPropAvailable = isObjectTypeReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECT_TYPE_REFERENCE))
          {
            setObject(OBJECT_TYPE_REFERENCE, null);
          }
        else if (!available)
          {
            removeTag(OBJECT_TYPE_REFERENCE);
          }

        propertyChangeSupport.firePropertyChange("objectTypeReferenceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectTypeReference", oldValue, getObjectTypeReference());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectTypeReferenceAvailable()
      {
        return containsTag(OBJECT_TYPE_REFERENCE);
      }

    public void setObjectAttributeReference (final String objectAttributeReference)
      {
        final String oldValue = getObjectAttributeReference();
        final boolean oldPropAvailable = isObjectAttributeReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECT_ATTRIBUTE_REFERENCE, objectAttributeReference);
        propertyChangeSupport.firePropertyChange("objectAttributeReference", oldValue, objectAttributeReference);
        propertyChangeSupport.firePropertyChange("objectAttributeReferenceAvailable", oldPropAvailable, isObjectAttributeReferenceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getObjectAttributeReference()
      {
        return getObject(OBJECT_ATTRIBUTE_REFERENCE, String.class);
      }

    public void setObjectAttributeReferenceAvailable (final boolean available)
      {
        final String oldValue = getObjectAttributeReference();
        final boolean oldPropAvailable = isObjectAttributeReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECT_ATTRIBUTE_REFERENCE))
          {
            setObject(OBJECT_ATTRIBUTE_REFERENCE, null);
          }
        else if (!available)
          {
            removeTag(OBJECT_ATTRIBUTE_REFERENCE);
          }

        propertyChangeSupport.firePropertyChange("objectAttributeReferenceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectAttributeReference", oldValue, getObjectAttributeReference());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectAttributeReferenceAvailable()
      {
        return containsTag(OBJECT_ATTRIBUTE_REFERENCE);
      }

    public void setObjectName (final String objectName)
      {
        final String oldValue = getObjectName();
        final boolean oldPropAvailable = isObjectNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECT_NAME, objectName);
        propertyChangeSupport.firePropertyChange("objectName", oldValue, objectName);
        propertyChangeSupport.firePropertyChange("objectNameAvailable", oldPropAvailable, isObjectNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getObjectName()
      {
        return getObject(OBJECT_NAME, String.class);
      }

    public void setObjectNameAvailable (final boolean available)
      {
        final String oldValue = getObjectName();
        final boolean oldPropAvailable = isObjectNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECT_NAME))
          {
            setObject(OBJECT_NAME, null);
          }
        else if (!available)
          {
            removeTag(OBJECT_NAME);
          }

        propertyChangeSupport.firePropertyChange("objectNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectName", oldValue, getObjectName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectNameAvailable()
      {
        return containsTag(OBJECT_NAME);
      }

    public void setEditStatus (final String editStatus)
      {
        final String oldValue = getEditStatus();
        final boolean oldPropAvailable = isEditStatusAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.EDIT_STATUS, editStatus);
        propertyChangeSupport.firePropertyChange("editStatus", oldValue, editStatus);
        propertyChangeSupport.firePropertyChange("editStatusAvailable", oldPropAvailable, isEditStatusAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getEditStatus()
      {
        return getObject(EDIT_STATUS, String.class);
      }

    public void setEditStatusAvailable (final boolean available)
      {
        final String oldValue = getEditStatus();
        final boolean oldPropAvailable = isEditStatusAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EDIT_STATUS))
          {
            setObject(EDIT_STATUS, null);
          }
        else if (!available)
          {
            removeTag(EDIT_STATUS);
          }

        propertyChangeSupport.firePropertyChange("editStatusAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("editStatus", oldValue, getEditStatus());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isEditStatusAvailable()
      {
        return containsTag(EDIT_STATUS);
      }

    public void setEditorialUpdate (final String editorialUpdate)
      {
        final String oldValue = getEditorialUpdate();
        final boolean oldPropAvailable = isEditorialUpdateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.EDITORIAL_UPDATE, editorialUpdate);
        propertyChangeSupport.firePropertyChange("editorialUpdate", oldValue, editorialUpdate);
        propertyChangeSupport.firePropertyChange("editorialUpdateAvailable", oldPropAvailable, isEditorialUpdateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getEditorialUpdate()
      {
        return getObject(EDITORIAL_UPDATE, String.class);
      }

    public void setEditorialUpdateAvailable (final boolean available)
      {
        final String oldValue = getEditorialUpdate();
        final boolean oldPropAvailable = isEditorialUpdateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EDITORIAL_UPDATE))
          {
            setObject(EDITORIAL_UPDATE, null);
          }
        else if (!available)
          {
            removeTag(EDITORIAL_UPDATE);
          }

        propertyChangeSupport.firePropertyChange("editorialUpdateAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("editorialUpdate", oldValue, getEditorialUpdate());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isEditorialUpdateAvailable()
      {
        return containsTag(EDITORIAL_UPDATE);
      }

    public void setUrgency (final String urgency)
      {
        final String oldValue = getUrgency();
        final boolean oldPropAvailable = isUrgencyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.URGENCY, urgency);
        propertyChangeSupport.firePropertyChange("urgency", oldValue, urgency);
        propertyChangeSupport.firePropertyChange("urgencyAvailable", oldPropAvailable, isUrgencyAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getUrgency()
      {
        return getObject(URGENCY, String.class);
      }

    public void setUrgencyAvailable (final boolean available)
      {
        final String oldValue = getUrgency();
        final boolean oldPropAvailable = isUrgencyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(URGENCY))
          {
            setObject(URGENCY, null);
          }
        else if (!available)
          {
            removeTag(URGENCY);
          }

        propertyChangeSupport.firePropertyChange("urgencyAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("urgency", oldValue, getUrgency());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isUrgencyAvailable()
      {
        return containsTag(URGENCY);
      }

    public void setSubjectReference (final String subjectReference)
      {
        final String oldValue = getSubjectReference();
        final boolean oldPropAvailable = isSubjectReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.SUBJECT_REFERENCE, subjectReference);
        propertyChangeSupport.firePropertyChange("subjectReference", oldValue, subjectReference);
        propertyChangeSupport.firePropertyChange("subjectReferenceAvailable", oldPropAvailable, isSubjectReferenceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSubjectReference()
      {
        return getObject(SUBJECT_REFERENCE, String.class);
      }

    public void setSubjectReferenceAvailable (final boolean available)
      {
        final String oldValue = getSubjectReference();
        final boolean oldPropAvailable = isSubjectReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUBJECT_REFERENCE))
          {
            setObject(SUBJECT_REFERENCE, null);
          }
        else if (!available)
          {
            removeTag(SUBJECT_REFERENCE);
          }

        propertyChangeSupport.firePropertyChange("subjectReferenceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subjectReference", oldValue, getSubjectReference());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubjectReferenceAvailable()
      {
        return containsTag(SUBJECT_REFERENCE);
      }

    public void setCategory (final String category)
      {
        final String oldValue = getCategory();
        final boolean oldPropAvailable = isCategoryAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.CATEGORY, category);
        propertyChangeSupport.firePropertyChange("category", oldValue, category);
        propertyChangeSupport.firePropertyChange("categoryAvailable", oldPropAvailable, isCategoryAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCategory()
      {
        return getObject(CATEGORY, String.class);
      }

    public void setCategoryAvailable (final boolean available)
      {
        final String oldValue = getCategory();
        final boolean oldPropAvailable = isCategoryAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CATEGORY))
          {
            setObject(CATEGORY, null);
          }
        else if (!available)
          {
            removeTag(CATEGORY);
          }

        propertyChangeSupport.firePropertyChange("categoryAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("category", oldValue, getCategory());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCategoryAvailable()
      {
        return containsTag(CATEGORY);
      }

    public void setSupplementalCategories (final String supplementalCategories)
      {
        final String oldValue = getSupplementalCategories();
        final boolean oldPropAvailable = isSupplementalCategoriesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.SUPPLEMENTAL_CATEGORIES, supplementalCategories);
        propertyChangeSupport.firePropertyChange("supplementalCategories", oldValue, supplementalCategories);
        propertyChangeSupport.firePropertyChange("supplementalCategoriesAvailable", oldPropAvailable, isSupplementalCategoriesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSupplementalCategories()
      {
        return getObject(SUPPLEMENTAL_CATEGORIES, String.class);
      }

    public void setSupplementalCategoriesAvailable (final boolean available)
      {
        final String oldValue = getSupplementalCategories();
        final boolean oldPropAvailable = isSupplementalCategoriesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUPPLEMENTAL_CATEGORIES))
          {
            setObject(SUPPLEMENTAL_CATEGORIES, null);
          }
        else if (!available)
          {
            removeTag(SUPPLEMENTAL_CATEGORIES);
          }

        propertyChangeSupport.firePropertyChange("supplementalCategoriesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("supplementalCategories", oldValue, getSupplementalCategories());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSupplementalCategoriesAvailable()
      {
        return containsTag(SUPPLEMENTAL_CATEGORIES);
      }

    public void setFixtureIdentifier (final String fixtureIdentifier)
      {
        final String oldValue = getFixtureIdentifier();
        final boolean oldPropAvailable = isFixtureIdentifierAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.FIXTURE_IDENTIFIER, fixtureIdentifier);
        propertyChangeSupport.firePropertyChange("fixtureIdentifier", oldValue, fixtureIdentifier);
        propertyChangeSupport.firePropertyChange("fixtureIdentifierAvailable", oldPropAvailable, isFixtureIdentifierAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getFixtureIdentifier()
      {
        return getObject(FIXTURE_IDENTIFIER, String.class);
      }

    public void setFixtureIdentifierAvailable (final boolean available)
      {
        final String oldValue = getFixtureIdentifier();
        final boolean oldPropAvailable = isFixtureIdentifierAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(FIXTURE_IDENTIFIER))
          {
            setObject(FIXTURE_IDENTIFIER, null);
          }
        else if (!available)
          {
            removeTag(FIXTURE_IDENTIFIER);
          }

        propertyChangeSupport.firePropertyChange("fixtureIdentifierAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("fixtureIdentifier", oldValue, getFixtureIdentifier());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isFixtureIdentifierAvailable()
      {
        return containsTag(FIXTURE_IDENTIFIER);
      }

    public void setKeywords (final String keywords)
      {
        final String oldValue = getKeywords();
        final boolean oldPropAvailable = isKeywordsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.KEYWORDS, keywords);
        propertyChangeSupport.firePropertyChange("keywords", oldValue, keywords);
        propertyChangeSupport.firePropertyChange("keywordsAvailable", oldPropAvailable, isKeywordsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getKeywords()
      {
        return getObject(KEYWORDS, String.class);
      }

    public void setKeywordsAvailable (final boolean available)
      {
        final String oldValue = getKeywords();
        final boolean oldPropAvailable = isKeywordsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(KEYWORDS))
          {
            setObject(KEYWORDS, null);
          }
        else if (!available)
          {
            removeTag(KEYWORDS);
          }

        propertyChangeSupport.firePropertyChange("keywordsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("keywords", oldValue, getKeywords());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isKeywordsAvailable()
      {
        return containsTag(KEYWORDS);
      }

    public void setContentLocationCode (final String contentLocationCode)
      {
        final String oldValue = getContentLocationCode();
        final boolean oldPropAvailable = isContentLocationCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.CONTENT_LOCATION_CODE, contentLocationCode);
        propertyChangeSupport.firePropertyChange("contentLocationCode", oldValue, contentLocationCode);
        propertyChangeSupport.firePropertyChange("contentLocationCodeAvailable", oldPropAvailable, isContentLocationCodeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getContentLocationCode()
      {
        return getObject(CONTENT_LOCATION_CODE, String.class);
      }

    public void setContentLocationCodeAvailable (final boolean available)
      {
        final String oldValue = getContentLocationCode();
        final boolean oldPropAvailable = isContentLocationCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CONTENT_LOCATION_CODE))
          {
            setObject(CONTENT_LOCATION_CODE, null);
          }
        else if (!available)
          {
            removeTag(CONTENT_LOCATION_CODE);
          }

        propertyChangeSupport.firePropertyChange("contentLocationCodeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("contentLocationCode", oldValue, getContentLocationCode());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isContentLocationCodeAvailable()
      {
        return containsTag(CONTENT_LOCATION_CODE);
      }

    public void setContentLocationName (final String contentLocationName)
      {
        final String oldValue = getContentLocationName();
        final boolean oldPropAvailable = isContentLocationNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.CONTENT_LOCATION_NAME, contentLocationName);
        propertyChangeSupport.firePropertyChange("contentLocationName", oldValue, contentLocationName);
        propertyChangeSupport.firePropertyChange("contentLocationNameAvailable", oldPropAvailable, isContentLocationNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getContentLocationName()
      {
        return getObject(CONTENT_LOCATION_NAME, String.class);
      }

    public void setContentLocationNameAvailable (final boolean available)
      {
        final String oldValue = getContentLocationName();
        final boolean oldPropAvailable = isContentLocationNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CONTENT_LOCATION_NAME))
          {
            setObject(CONTENT_LOCATION_NAME, null);
          }
        else if (!available)
          {
            removeTag(CONTENT_LOCATION_NAME);
          }

        propertyChangeSupport.firePropertyChange("contentLocationNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("contentLocationName", oldValue, getContentLocationName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isContentLocationNameAvailable()
      {
        return containsTag(CONTENT_LOCATION_NAME);
      }

    public void setReleaseDate (final String releaseDate)
      {
        final String oldValue = getReleaseDate();
        final boolean oldPropAvailable = isReleaseDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.RELEASE_DATE, releaseDate);
        propertyChangeSupport.firePropertyChange("releaseDate", oldValue, releaseDate);
        propertyChangeSupport.firePropertyChange("releaseDateAvailable", oldPropAvailable, isReleaseDateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getReleaseDate()
      {
        return getObject(RELEASE_DATE, String.class);
      }

    public void setReleaseDateAvailable (final boolean available)
      {
        final String oldValue = getReleaseDate();
        final boolean oldPropAvailable = isReleaseDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(RELEASE_DATE))
          {
            setObject(RELEASE_DATE, null);
          }
        else if (!available)
          {
            removeTag(RELEASE_DATE);
          }

        propertyChangeSupport.firePropertyChange("releaseDateAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("releaseDate", oldValue, getReleaseDate());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isReleaseDateAvailable()
      {
        return containsTag(RELEASE_DATE);
      }

    public void setReleaseTime (final String releaseTime)
      {
        final String oldValue = getReleaseTime();
        final boolean oldPropAvailable = isReleaseTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.RELEASE_TIME, releaseTime);
        propertyChangeSupport.firePropertyChange("releaseTime", oldValue, releaseTime);
        propertyChangeSupport.firePropertyChange("releaseTimeAvailable", oldPropAvailable, isReleaseTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getReleaseTime()
      {
        return getObject(RELEASE_TIME, String.class);
      }

    public void setReleaseTimeAvailable (final boolean available)
      {
        final String oldValue = getReleaseTime();
        final boolean oldPropAvailable = isReleaseTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(RELEASE_TIME))
          {
            setObject(RELEASE_TIME, null);
          }
        else if (!available)
          {
            removeTag(RELEASE_TIME);
          }

        propertyChangeSupport.firePropertyChange("releaseTimeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("releaseTime", oldValue, getReleaseTime());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isReleaseTimeAvailable()
      {
        return containsTag(RELEASE_TIME);
      }

    public void setExpirationDate (final String expirationDate)
      {
        final String oldValue = getExpirationDate();
        final boolean oldPropAvailable = isExpirationDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.EXPIRATION_DATE, expirationDate);
        propertyChangeSupport.firePropertyChange("expirationDate", oldValue, expirationDate);
        propertyChangeSupport.firePropertyChange("expirationDateAvailable", oldPropAvailable, isExpirationDateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getExpirationDate()
      {
        return getObject(EXPIRATION_DATE, String.class);
      }

    public void setExpirationDateAvailable (final boolean available)
      {
        final String oldValue = getExpirationDate();
        final boolean oldPropAvailable = isExpirationDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXPIRATION_DATE))
          {
            setObject(EXPIRATION_DATE, null);
          }
        else if (!available)
          {
            removeTag(EXPIRATION_DATE);
          }

        propertyChangeSupport.firePropertyChange("expirationDateAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("expirationDate", oldValue, getExpirationDate());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExpirationDateAvailable()
      {
        return containsTag(EXPIRATION_DATE);
      }

    public void setExpirationTime (final String expirationTime)
      {
        final String oldValue = getExpirationTime();
        final boolean oldPropAvailable = isExpirationTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.EXPIRATION_TIME, expirationTime);
        propertyChangeSupport.firePropertyChange("expirationTime", oldValue, expirationTime);
        propertyChangeSupport.firePropertyChange("expirationTimeAvailable", oldPropAvailable, isExpirationTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getExpirationTime()
      {
        return getObject(EXPIRATION_TIME, String.class);
      }

    public void setExpirationTimeAvailable (final boolean available)
      {
        final String oldValue = getExpirationTime();
        final boolean oldPropAvailable = isExpirationTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXPIRATION_TIME))
          {
            setObject(EXPIRATION_TIME, null);
          }
        else if (!available)
          {
            removeTag(EXPIRATION_TIME);
          }

        propertyChangeSupport.firePropertyChange("expirationTimeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("expirationTime", oldValue, getExpirationTime());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isExpirationTimeAvailable()
      {
        return containsTag(EXPIRATION_TIME);
      }

    public void setSpecialInstructions (final String specialInstructions)
      {
        final String oldValue = getSpecialInstructions();
        final boolean oldPropAvailable = isSpecialInstructionsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.SPECIAL_INSTRUCTIONS, specialInstructions);
        propertyChangeSupport.firePropertyChange("specialInstructions", oldValue, specialInstructions);
        propertyChangeSupport.firePropertyChange("specialInstructionsAvailable", oldPropAvailable, isSpecialInstructionsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSpecialInstructions()
      {
        return getObject(SPECIAL_INSTRUCTIONS, String.class);
      }

    public void setSpecialInstructionsAvailable (final boolean available)
      {
        final String oldValue = getSpecialInstructions();
        final boolean oldPropAvailable = isSpecialInstructionsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SPECIAL_INSTRUCTIONS))
          {
            setObject(SPECIAL_INSTRUCTIONS, null);
          }
        else if (!available)
          {
            removeTag(SPECIAL_INSTRUCTIONS);
          }

        propertyChangeSupport.firePropertyChange("specialInstructionsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("specialInstructions", oldValue, getSpecialInstructions());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSpecialInstructionsAvailable()
      {
        return containsTag(SPECIAL_INSTRUCTIONS);
      }

    public static enum ActionAdvised
       {
         OBJECT_KILL(01, "Object Kill"),
         OBJECT_REPLACE(02, "Object Replace"),
         OJBECT_APPEND(03, "Ojbect Append"),
         OBJECT_REFERENCE(04, "Object Reference"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private ActionAdvised (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static ActionAdvised fromInteger (int value)
           {
             if (value == 01) return OBJECT_KILL;
             if (value == 02) return OBJECT_REPLACE;
             if (value == 03) return OJBECT_APPEND;
             if (value == 04) return OBJECT_REFERENCE;

             return _UNKNOWN;
           }
       }
    public void setActionAdvised (final ActionAdvised actionAdvised)
      {
        final ActionAdvised oldValue = getActionAdvised();
        final boolean oldPropAvailable = isActionAdvisedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ACTION_ADVISED, actionAdvised);
        propertyChangeSupport.firePropertyChange("actionAdvised", oldValue, actionAdvised);
        propertyChangeSupport.firePropertyChange("actionAdvisedAvailable", oldPropAvailable, isActionAdvisedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public ActionAdvised getActionAdvised()
      {
        return getObject(ACTION_ADVISED, ActionAdvised.class);
      }

    public void setActionAdvisedAvailable (final boolean available)
      {
        final ActionAdvised oldValue = getActionAdvised();
        final boolean oldPropAvailable = isActionAdvisedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ACTION_ADVISED))
          {
            setObject(ACTION_ADVISED, null);
          }
        else if (!available)
          {
            removeTag(ACTION_ADVISED);
          }

        propertyChangeSupport.firePropertyChange("actionAdvisedAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("actionAdvised", oldValue, getActionAdvised());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isActionAdvisedAvailable()
      {
        return containsTag(ACTION_ADVISED);
      }

    public void setReferenceService (final String referenceService)
      {
        final String oldValue = getReferenceService();
        final boolean oldPropAvailable = isReferenceServiceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.REFERENCE_SERVICE, referenceService);
        propertyChangeSupport.firePropertyChange("referenceService", oldValue, referenceService);
        propertyChangeSupport.firePropertyChange("referenceServiceAvailable", oldPropAvailable, isReferenceServiceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getReferenceService()
      {
        return getObject(REFERENCE_SERVICE, String.class);
      }

    public void setReferenceServiceAvailable (final boolean available)
      {
        final String oldValue = getReferenceService();
        final boolean oldPropAvailable = isReferenceServiceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(REFERENCE_SERVICE))
          {
            setObject(REFERENCE_SERVICE, null);
          }
        else if (!available)
          {
            removeTag(REFERENCE_SERVICE);
          }

        propertyChangeSupport.firePropertyChange("referenceServiceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("referenceService", oldValue, getReferenceService());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isReferenceServiceAvailable()
      {
        return containsTag(REFERENCE_SERVICE);
      }

    public void setReferenceDate (final String referenceDate)
      {
        final String oldValue = getReferenceDate();
        final boolean oldPropAvailable = isReferenceDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.REFERENCE_DATE, referenceDate);
        propertyChangeSupport.firePropertyChange("referenceDate", oldValue, referenceDate);
        propertyChangeSupport.firePropertyChange("referenceDateAvailable", oldPropAvailable, isReferenceDateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getReferenceDate()
      {
        return getObject(REFERENCE_DATE, String.class);
      }

    public void setReferenceDateAvailable (final boolean available)
      {
        final String oldValue = getReferenceDate();
        final boolean oldPropAvailable = isReferenceDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(REFERENCE_DATE))
          {
            setObject(REFERENCE_DATE, null);
          }
        else if (!available)
          {
            removeTag(REFERENCE_DATE);
          }

        propertyChangeSupport.firePropertyChange("referenceDateAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("referenceDate", oldValue, getReferenceDate());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isReferenceDateAvailable()
      {
        return containsTag(REFERENCE_DATE);
      }

    public void setReferenceNumber (final String referenceNumber)
      {
        final String oldValue = getReferenceNumber();
        final boolean oldPropAvailable = isReferenceNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.REFERENCE_NUMBER, referenceNumber);
        propertyChangeSupport.firePropertyChange("referenceNumber", oldValue, referenceNumber);
        propertyChangeSupport.firePropertyChange("referenceNumberAvailable", oldPropAvailable, isReferenceNumberAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getReferenceNumber()
      {
        return getObject(REFERENCE_NUMBER, String.class);
      }

    public void setReferenceNumberAvailable (final boolean available)
      {
        final String oldValue = getReferenceNumber();
        final boolean oldPropAvailable = isReferenceNumberAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(REFERENCE_NUMBER))
          {
            setObject(REFERENCE_NUMBER, null);
          }
        else if (!available)
          {
            removeTag(REFERENCE_NUMBER);
          }

        propertyChangeSupport.firePropertyChange("referenceNumberAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("referenceNumber", oldValue, getReferenceNumber());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isReferenceNumberAvailable()
      {
        return containsTag(REFERENCE_NUMBER);
      }

    public void setDateCreated (final String dateCreated)
      {
        final String oldValue = getDateCreated();
        final boolean oldPropAvailable = isDateCreatedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.DATE_CREATED, dateCreated);
        propertyChangeSupport.firePropertyChange("dateCreated", oldValue, dateCreated);
        propertyChangeSupport.firePropertyChange("dateCreatedAvailable", oldPropAvailable, isDateCreatedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getDateCreated()
      {
        return getObject(DATE_CREATED, String.class);
      }

    public void setDateCreatedAvailable (final boolean available)
      {
        final String oldValue = getDateCreated();
        final boolean oldPropAvailable = isDateCreatedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DATE_CREATED))
          {
            setObject(DATE_CREATED, null);
          }
        else if (!available)
          {
            removeTag(DATE_CREATED);
          }

        propertyChangeSupport.firePropertyChange("dateCreatedAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("dateCreated", oldValue, getDateCreated());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDateCreatedAvailable()
      {
        return containsTag(DATE_CREATED);
      }

    public void setTimeCreated (final String timeCreated)
      {
        final String oldValue = getTimeCreated();
        final boolean oldPropAvailable = isTimeCreatedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.TIME_CREATED, timeCreated);
        propertyChangeSupport.firePropertyChange("timeCreated", oldValue, timeCreated);
        propertyChangeSupport.firePropertyChange("timeCreatedAvailable", oldPropAvailable, isTimeCreatedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getTimeCreated()
      {
        return getObject(TIME_CREATED, String.class);
      }

    public void setTimeCreatedAvailable (final boolean available)
      {
        final String oldValue = getTimeCreated();
        final boolean oldPropAvailable = isTimeCreatedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(TIME_CREATED))
          {
            setObject(TIME_CREATED, null);
          }
        else if (!available)
          {
            removeTag(TIME_CREATED);
          }

        propertyChangeSupport.firePropertyChange("timeCreatedAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("timeCreated", oldValue, getTimeCreated());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isTimeCreatedAvailable()
      {
        return containsTag(TIME_CREATED);
      }

    public void setDigitalCreationDate (final String digitalCreationDate)
      {
        final String oldValue = getDigitalCreationDate();
        final boolean oldPropAvailable = isDigitalCreationDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.DIGITAL_CREATION_DATE, digitalCreationDate);
        propertyChangeSupport.firePropertyChange("digitalCreationDate", oldValue, digitalCreationDate);
        propertyChangeSupport.firePropertyChange("digitalCreationDateAvailable", oldPropAvailable, isDigitalCreationDateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getDigitalCreationDate()
      {
        return getObject(DIGITAL_CREATION_DATE, String.class);
      }

    public void setDigitalCreationDateAvailable (final boolean available)
      {
        final String oldValue = getDigitalCreationDate();
        final boolean oldPropAvailable = isDigitalCreationDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DIGITAL_CREATION_DATE))
          {
            setObject(DIGITAL_CREATION_DATE, null);
          }
        else if (!available)
          {
            removeTag(DIGITAL_CREATION_DATE);
          }

        propertyChangeSupport.firePropertyChange("digitalCreationDateAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("digitalCreationDate", oldValue, getDigitalCreationDate());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDigitalCreationDateAvailable()
      {
        return containsTag(DIGITAL_CREATION_DATE);
      }

    public void setDigitalCreationTime (final String digitalCreationTime)
      {
        final String oldValue = getDigitalCreationTime();
        final boolean oldPropAvailable = isDigitalCreationTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.DIGITAL_CREATION_TIME, digitalCreationTime);
        propertyChangeSupport.firePropertyChange("digitalCreationTime", oldValue, digitalCreationTime);
        propertyChangeSupport.firePropertyChange("digitalCreationTimeAvailable", oldPropAvailable, isDigitalCreationTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getDigitalCreationTime()
      {
        return getObject(DIGITAL_CREATION_TIME, String.class);
      }

    public void setDigitalCreationTimeAvailable (final boolean available)
      {
        final String oldValue = getDigitalCreationTime();
        final boolean oldPropAvailable = isDigitalCreationTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DIGITAL_CREATION_TIME))
          {
            setObject(DIGITAL_CREATION_TIME, null);
          }
        else if (!available)
          {
            removeTag(DIGITAL_CREATION_TIME);
          }

        propertyChangeSupport.firePropertyChange("digitalCreationTimeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("digitalCreationTime", oldValue, getDigitalCreationTime());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDigitalCreationTimeAvailable()
      {
        return containsTag(DIGITAL_CREATION_TIME);
      }

    public void setOriginatingProgram (final String originatingProgram)
      {
        final String oldValue = getOriginatingProgram();
        final boolean oldPropAvailable = isOriginatingProgramAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ORIGINATING_PROGRAM, originatingProgram);
        propertyChangeSupport.firePropertyChange("originatingProgram", oldValue, originatingProgram);
        propertyChangeSupport.firePropertyChange("originatingProgramAvailable", oldPropAvailable, isOriginatingProgramAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getOriginatingProgram()
      {
        return getObject(ORIGINATING_PROGRAM, String.class);
      }

    public void setOriginatingProgramAvailable (final boolean available)
      {
        final String oldValue = getOriginatingProgram();
        final boolean oldPropAvailable = isOriginatingProgramAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ORIGINATING_PROGRAM))
          {
            setObject(ORIGINATING_PROGRAM, null);
          }
        else if (!available)
          {
            removeTag(ORIGINATING_PROGRAM);
          }

        propertyChangeSupport.firePropertyChange("originatingProgramAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("originatingProgram", oldValue, getOriginatingProgram());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isOriginatingProgramAvailable()
      {
        return containsTag(ORIGINATING_PROGRAM);
      }

    public void setProgramVersion (final String programVersion)
      {
        final String oldValue = getProgramVersion();
        final boolean oldPropAvailable = isProgramVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.PROGRAM_VERSION, programVersion);
        propertyChangeSupport.firePropertyChange("programVersion", oldValue, programVersion);
        propertyChangeSupport.firePropertyChange("programVersionAvailable", oldPropAvailable, isProgramVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getProgramVersion()
      {
        return getObject(PROGRAM_VERSION, String.class);
      }

    public void setProgramVersionAvailable (final boolean available)
      {
        final String oldValue = getProgramVersion();
        final boolean oldPropAvailable = isProgramVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROGRAM_VERSION))
          {
            setObject(PROGRAM_VERSION, null);
          }
        else if (!available)
          {
            removeTag(PROGRAM_VERSION);
          }

        propertyChangeSupport.firePropertyChange("programVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("programVersion", oldValue, getProgramVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProgramVersionAvailable()
      {
        return containsTag(PROGRAM_VERSION);
      }

    public void setObjectCycle (final String objectCycle)
      {
        final String oldValue = getObjectCycle();
        final boolean oldPropAvailable = isObjectCycleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECT_CYCLE, objectCycle);
        propertyChangeSupport.firePropertyChange("objectCycle", oldValue, objectCycle);
        propertyChangeSupport.firePropertyChange("objectCycleAvailable", oldPropAvailable, isObjectCycleAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getObjectCycle()
      {
        return getObject(OBJECT_CYCLE, String.class);
      }

    public void setObjectCycleAvailable (final boolean available)
      {
        final String oldValue = getObjectCycle();
        final boolean oldPropAvailable = isObjectCycleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECT_CYCLE))
          {
            setObject(OBJECT_CYCLE, null);
          }
        else if (!available)
          {
            removeTag(OBJECT_CYCLE);
          }

        propertyChangeSupport.firePropertyChange("objectCycleAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectCycle", oldValue, getObjectCycle());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectCycleAvailable()
      {
        return containsTag(OBJECT_CYCLE);
      }

    public void setByline (final String byline)
      {
        final String oldValue = getByline();
        final boolean oldPropAvailable = isBylineAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.BYLINE, byline);
        propertyChangeSupport.firePropertyChange("byline", oldValue, byline);
        propertyChangeSupport.firePropertyChange("bylineAvailable", oldPropAvailable, isBylineAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getByline()
      {
        return getObject(BYLINE, String.class);
      }

    public void setBylineAvailable (final boolean available)
      {
        final String oldValue = getByline();
        final boolean oldPropAvailable = isBylineAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BYLINE))
          {
            setObject(BYLINE, null);
          }
        else if (!available)
          {
            removeTag(BYLINE);
          }

        propertyChangeSupport.firePropertyChange("bylineAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("byline", oldValue, getByline());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBylineAvailable()
      {
        return containsTag(BYLINE);
      }

    public void setBylineTitle (final String bylineTitle)
      {
        final String oldValue = getBylineTitle();
        final boolean oldPropAvailable = isBylineTitleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.BYLINE_TITLE, bylineTitle);
        propertyChangeSupport.firePropertyChange("bylineTitle", oldValue, bylineTitle);
        propertyChangeSupport.firePropertyChange("bylineTitleAvailable", oldPropAvailable, isBylineTitleAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getBylineTitle()
      {
        return getObject(BYLINE_TITLE, String.class);
      }

    public void setBylineTitleAvailable (final boolean available)
      {
        final String oldValue = getBylineTitle();
        final boolean oldPropAvailable = isBylineTitleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BYLINE_TITLE))
          {
            setObject(BYLINE_TITLE, null);
          }
        else if (!available)
          {
            removeTag(BYLINE_TITLE);
          }

        propertyChangeSupport.firePropertyChange("bylineTitleAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("bylineTitle", oldValue, getBylineTitle());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isBylineTitleAvailable()
      {
        return containsTag(BYLINE_TITLE);
      }

    public void setCity (final String city)
      {
        final String oldValue = getCity();
        final boolean oldPropAvailable = isCityAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.CITY, city);
        propertyChangeSupport.firePropertyChange("city", oldValue, city);
        propertyChangeSupport.firePropertyChange("cityAvailable", oldPropAvailable, isCityAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCity()
      {
        return getObject(CITY, String.class);
      }

    public void setCityAvailable (final boolean available)
      {
        final String oldValue = getCity();
        final boolean oldPropAvailable = isCityAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CITY))
          {
            setObject(CITY, null);
          }
        else if (!available)
          {
            removeTag(CITY);
          }

        propertyChangeSupport.firePropertyChange("cityAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("city", oldValue, getCity());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCityAvailable()
      {
        return containsTag(CITY);
      }

    public void setSublocation (final String sublocation)
      {
        final String oldValue = getSublocation();
        final boolean oldPropAvailable = isSublocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.SUBLOCATION, sublocation);
        propertyChangeSupport.firePropertyChange("sublocation", oldValue, sublocation);
        propertyChangeSupport.firePropertyChange("sublocationAvailable", oldPropAvailable, isSublocationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSublocation()
      {
        return getObject(SUBLOCATION, String.class);
      }

    public void setSublocationAvailable (final boolean available)
      {
        final String oldValue = getSublocation();
        final boolean oldPropAvailable = isSublocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUBLOCATION))
          {
            setObject(SUBLOCATION, null);
          }
        else if (!available)
          {
            removeTag(SUBLOCATION);
          }

        propertyChangeSupport.firePropertyChange("sublocationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("sublocation", oldValue, getSublocation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSublocationAvailable()
      {
        return containsTag(SUBLOCATION);
      }

    public void setProvinceState (final String provinceState)
      {
        final String oldValue = getProvinceState();
        final boolean oldPropAvailable = isProvinceStateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.PROVINCESTATE, provinceState);
        propertyChangeSupport.firePropertyChange("provinceState", oldValue, provinceState);
        propertyChangeSupport.firePropertyChange("provinceStateAvailable", oldPropAvailable, isProvinceStateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getProvinceState()
      {
        return getObject(PROVINCESTATE, String.class);
      }

    public void setProvinceStateAvailable (final boolean available)
      {
        final String oldValue = getProvinceState();
        final boolean oldPropAvailable = isProvinceStateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROVINCESTATE))
          {
            setObject(PROVINCESTATE, null);
          }
        else if (!available)
          {
            removeTag(PROVINCESTATE);
          }

        propertyChangeSupport.firePropertyChange("provinceStateAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("provinceState", oldValue, getProvinceState());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProvinceStateAvailable()
      {
        return containsTag(PROVINCESTATE);
      }

    public void setCountryPrimaryLocationCode (final String countryPrimaryLocationCode)
      {
        final String oldValue = getCountryPrimaryLocationCode();
        final boolean oldPropAvailable = isCountryPrimaryLocationCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.COUNTRYPRIMARY_LOCATION_CODE, countryPrimaryLocationCode);
        propertyChangeSupport.firePropertyChange("countryPrimaryLocationCode", oldValue, countryPrimaryLocationCode);
        propertyChangeSupport.firePropertyChange("countryPrimaryLocationCodeAvailable", oldPropAvailable, isCountryPrimaryLocationCodeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCountryPrimaryLocationCode()
      {
        return getObject(COUNTRYPRIMARY_LOCATION_CODE, String.class);
      }

    public void setCountryPrimaryLocationCodeAvailable (final boolean available)
      {
        final String oldValue = getCountryPrimaryLocationCode();
        final boolean oldPropAvailable = isCountryPrimaryLocationCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COUNTRYPRIMARY_LOCATION_CODE))
          {
            setObject(COUNTRYPRIMARY_LOCATION_CODE, null);
          }
        else if (!available)
          {
            removeTag(COUNTRYPRIMARY_LOCATION_CODE);
          }

        propertyChangeSupport.firePropertyChange("countryPrimaryLocationCodeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("countryPrimaryLocationCode", oldValue, getCountryPrimaryLocationCode());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCountryPrimaryLocationCodeAvailable()
      {
        return containsTag(COUNTRYPRIMARY_LOCATION_CODE);
      }

    public void setCountryPrimaryLocationName (final String countryPrimaryLocationName)
      {
        final String oldValue = getCountryPrimaryLocationName();
        final boolean oldPropAvailable = isCountryPrimaryLocationNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.COUNTRYPRIMARY_LOCATION_NAME, countryPrimaryLocationName);
        propertyChangeSupport.firePropertyChange("countryPrimaryLocationName", oldValue, countryPrimaryLocationName);
        propertyChangeSupport.firePropertyChange("countryPrimaryLocationNameAvailable", oldPropAvailable, isCountryPrimaryLocationNameAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCountryPrimaryLocationName()
      {
        return getObject(COUNTRYPRIMARY_LOCATION_NAME, String.class);
      }

    public void setCountryPrimaryLocationNameAvailable (final boolean available)
      {
        final String oldValue = getCountryPrimaryLocationName();
        final boolean oldPropAvailable = isCountryPrimaryLocationNameAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COUNTRYPRIMARY_LOCATION_NAME))
          {
            setObject(COUNTRYPRIMARY_LOCATION_NAME, null);
          }
        else if (!available)
          {
            removeTag(COUNTRYPRIMARY_LOCATION_NAME);
          }

        propertyChangeSupport.firePropertyChange("countryPrimaryLocationNameAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("countryPrimaryLocationName", oldValue, getCountryPrimaryLocationName());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCountryPrimaryLocationNameAvailable()
      {
        return containsTag(COUNTRYPRIMARY_LOCATION_NAME);
      }

    public void setOriginalTransmissionReference (final String originalTransmissionReference)
      {
        final String oldValue = getOriginalTransmissionReference();
        final boolean oldPropAvailable = isOriginalTransmissionReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ORIGINAL_TRANSMISSION_REFERENCE, originalTransmissionReference);
        propertyChangeSupport.firePropertyChange("originalTransmissionReference", oldValue, originalTransmissionReference);
        propertyChangeSupport.firePropertyChange("originalTransmissionReferenceAvailable", oldPropAvailable, isOriginalTransmissionReferenceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getOriginalTransmissionReference()
      {
        return getObject(ORIGINAL_TRANSMISSION_REFERENCE, String.class);
      }

    public void setOriginalTransmissionReferenceAvailable (final boolean available)
      {
        final String oldValue = getOriginalTransmissionReference();
        final boolean oldPropAvailable = isOriginalTransmissionReferenceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ORIGINAL_TRANSMISSION_REFERENCE))
          {
            setObject(ORIGINAL_TRANSMISSION_REFERENCE, null);
          }
        else if (!available)
          {
            removeTag(ORIGINAL_TRANSMISSION_REFERENCE);
          }

        propertyChangeSupport.firePropertyChange("originalTransmissionReferenceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("originalTransmissionReference", oldValue, getOriginalTransmissionReference());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isOriginalTransmissionReferenceAvailable()
      {
        return containsTag(ORIGINAL_TRANSMISSION_REFERENCE);
      }

    public void setHeadline (final String headline)
      {
        final String oldValue = getHeadline();
        final boolean oldPropAvailable = isHeadlineAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.HEADLINE, headline);
        propertyChangeSupport.firePropertyChange("headline", oldValue, headline);
        propertyChangeSupport.firePropertyChange("headlineAvailable", oldPropAvailable, isHeadlineAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getHeadline()
      {
        return getObject(HEADLINE, String.class);
      }

    public void setHeadlineAvailable (final boolean available)
      {
        final String oldValue = getHeadline();
        final boolean oldPropAvailable = isHeadlineAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(HEADLINE))
          {
            setObject(HEADLINE, null);
          }
        else if (!available)
          {
            removeTag(HEADLINE);
          }

        propertyChangeSupport.firePropertyChange("headlineAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("headline", oldValue, getHeadline());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isHeadlineAvailable()
      {
        return containsTag(HEADLINE);
      }

    public void setCredit (final String credit)
      {
        final String oldValue = getCredit();
        final boolean oldPropAvailable = isCreditAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.CREDIT, credit);
        propertyChangeSupport.firePropertyChange("credit", oldValue, credit);
        propertyChangeSupport.firePropertyChange("creditAvailable", oldPropAvailable, isCreditAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCredit()
      {
        return getObject(CREDIT, String.class);
      }

    public void setCreditAvailable (final boolean available)
      {
        final String oldValue = getCredit();
        final boolean oldPropAvailable = isCreditAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CREDIT))
          {
            setObject(CREDIT, null);
          }
        else if (!available)
          {
            removeTag(CREDIT);
          }

        propertyChangeSupport.firePropertyChange("creditAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("credit", oldValue, getCredit());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCreditAvailable()
      {
        return containsTag(CREDIT);
      }

    public void setSource (final String source)
      {
        final String oldValue = getSource();
        final boolean oldPropAvailable = isSourceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.SOURCE, source);
        propertyChangeSupport.firePropertyChange("source", oldValue, source);
        propertyChangeSupport.firePropertyChange("sourceAvailable", oldPropAvailable, isSourceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSource()
      {
        return getObject(SOURCE, String.class);
      }

    public void setSourceAvailable (final boolean available)
      {
        final String oldValue = getSource();
        final boolean oldPropAvailable = isSourceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SOURCE))
          {
            setObject(SOURCE, null);
          }
        else if (!available)
          {
            removeTag(SOURCE);
          }

        propertyChangeSupport.firePropertyChange("sourceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("source", oldValue, getSource());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSourceAvailable()
      {
        return containsTag(SOURCE);
      }

    public void setCopyrightNotice (final String copyrightNotice)
      {
        final String oldValue = getCopyrightNotice();
        final boolean oldPropAvailable = isCopyrightNoticeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.COPYRIGHT_NOTICE, copyrightNotice);
        propertyChangeSupport.firePropertyChange("copyrightNotice", oldValue, copyrightNotice);
        propertyChangeSupport.firePropertyChange("copyrightNoticeAvailable", oldPropAvailable, isCopyrightNoticeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCopyrightNotice()
      {
        return getObject(COPYRIGHT_NOTICE, String.class);
      }

    public void setCopyrightNoticeAvailable (final boolean available)
      {
        final String oldValue = getCopyrightNotice();
        final boolean oldPropAvailable = isCopyrightNoticeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COPYRIGHT_NOTICE))
          {
            setObject(COPYRIGHT_NOTICE, null);
          }
        else if (!available)
          {
            removeTag(COPYRIGHT_NOTICE);
          }

        propertyChangeSupport.firePropertyChange("copyrightNoticeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("copyrightNotice", oldValue, getCopyrightNotice());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCopyrightNoticeAvailable()
      {
        return containsTag(COPYRIGHT_NOTICE);
      }

    public void setContact (final String contact)
      {
        final String oldValue = getContact();
        final boolean oldPropAvailable = isContactAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.CONTACT, contact);
        propertyChangeSupport.firePropertyChange("contact", oldValue, contact);
        propertyChangeSupport.firePropertyChange("contactAvailable", oldPropAvailable, isContactAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getContact()
      {
        return getObject(CONTACT, String.class);
      }

    public void setContactAvailable (final boolean available)
      {
        final String oldValue = getContact();
        final boolean oldPropAvailable = isContactAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CONTACT))
          {
            setObject(CONTACT, null);
          }
        else if (!available)
          {
            removeTag(CONTACT);
          }

        propertyChangeSupport.firePropertyChange("contactAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("contact", oldValue, getContact());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isContactAvailable()
      {
        return containsTag(CONTACT);
      }

    public void setCaptionAbstract (final String captionAbstract)
      {
        final String oldValue = getCaptionAbstract();
        final boolean oldPropAvailable = isCaptionAbstractAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.CAPTIONABSTRACT, captionAbstract);
        propertyChangeSupport.firePropertyChange("captionAbstract", oldValue, captionAbstract);
        propertyChangeSupport.firePropertyChange("captionAbstractAvailable", oldPropAvailable, isCaptionAbstractAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCaptionAbstract()
      {
        return getObject(CAPTIONABSTRACT, String.class);
      }

    public void setCaptionAbstractAvailable (final boolean available)
      {
        final String oldValue = getCaptionAbstract();
        final boolean oldPropAvailable = isCaptionAbstractAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CAPTIONABSTRACT))
          {
            setObject(CAPTIONABSTRACT, null);
          }
        else if (!available)
          {
            removeTag(CAPTIONABSTRACT);
          }

        propertyChangeSupport.firePropertyChange("captionAbstractAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("captionAbstract", oldValue, getCaptionAbstract());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCaptionAbstractAvailable()
      {
        return containsTag(CAPTIONABSTRACT);
      }

    public void setLocalCaption (final String localCaption)
      {
        final String oldValue = getLocalCaption();
        final boolean oldPropAvailable = isLocalCaptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.LOCAL_CAPTION, localCaption);
        propertyChangeSupport.firePropertyChange("localCaption", oldValue, localCaption);
        propertyChangeSupport.firePropertyChange("localCaptionAvailable", oldPropAvailable, isLocalCaptionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getLocalCaption()
      {
        return getObject(LOCAL_CAPTION, String.class);
      }

    public void setLocalCaptionAvailable (final boolean available)
      {
        final String oldValue = getLocalCaption();
        final boolean oldPropAvailable = isLocalCaptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(LOCAL_CAPTION))
          {
            setObject(LOCAL_CAPTION, null);
          }
        else if (!available)
          {
            removeTag(LOCAL_CAPTION);
          }

        propertyChangeSupport.firePropertyChange("localCaptionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("localCaption", oldValue, getLocalCaption());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isLocalCaptionAvailable()
      {
        return containsTag(LOCAL_CAPTION);
      }

    public void setWriterEditor (final String writerEditor)
      {
        final String oldValue = getWriterEditor();
        final boolean oldPropAvailable = isWriterEditorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.WRITEREDITOR, writerEditor);
        propertyChangeSupport.firePropertyChange("writerEditor", oldValue, writerEditor);
        propertyChangeSupport.firePropertyChange("writerEditorAvailable", oldPropAvailable, isWriterEditorAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getWriterEditor()
      {
        return getObject(WRITEREDITOR, String.class);
      }

    public void setWriterEditorAvailable (final boolean available)
      {
        final String oldValue = getWriterEditor();
        final boolean oldPropAvailable = isWriterEditorAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(WRITEREDITOR))
          {
            setObject(WRITEREDITOR, null);
          }
        else if (!available)
          {
            removeTag(WRITEREDITOR);
          }

        propertyChangeSupport.firePropertyChange("writerEditorAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("writerEditor", oldValue, getWriterEditor());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isWriterEditorAvailable()
      {
        return containsTag(WRITEREDITOR);
      }

    public void setRasterizedCaption (final String rasterizedCaption)
      {
        final String oldValue = getRasterizedCaption();
        final boolean oldPropAvailable = isRasterizedCaptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.RASTERIZED_CAPTION, rasterizedCaption);
        propertyChangeSupport.firePropertyChange("rasterizedCaption", oldValue, rasterizedCaption);
        propertyChangeSupport.firePropertyChange("rasterizedCaptionAvailable", oldPropAvailable, isRasterizedCaptionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getRasterizedCaption()
      {
        return getObject(RASTERIZED_CAPTION, String.class);
      }

    public void setRasterizedCaptionAvailable (final boolean available)
      {
        final String oldValue = getRasterizedCaption();
        final boolean oldPropAvailable = isRasterizedCaptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(RASTERIZED_CAPTION))
          {
            setObject(RASTERIZED_CAPTION, null);
          }
        else if (!available)
          {
            removeTag(RASTERIZED_CAPTION);
          }

        propertyChangeSupport.firePropertyChange("rasterizedCaptionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("rasterizedCaption", oldValue, getRasterizedCaption());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isRasterizedCaptionAvailable()
      {
        return containsTag(RASTERIZED_CAPTION);
      }

    public void setImageType (final String imageType)
      {
        final String oldValue = getImageType();
        final boolean oldPropAvailable = isImageTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.IMAGE_TYPE, imageType);
        propertyChangeSupport.firePropertyChange("imageType", oldValue, imageType);
        propertyChangeSupport.firePropertyChange("imageTypeAvailable", oldPropAvailable, isImageTypeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getImageType()
      {
        return getObject(IMAGE_TYPE, String.class);
      }

    public void setImageTypeAvailable (final boolean available)
      {
        final String oldValue = getImageType();
        final boolean oldPropAvailable = isImageTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_TYPE))
          {
            setObject(IMAGE_TYPE, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_TYPE);
          }

        propertyChangeSupport.firePropertyChange("imageTypeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageType", oldValue, getImageType());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageTypeAvailable()
      {
        return containsTag(IMAGE_TYPE);
      }

    public void setImageOrientation (final String imageOrientation)
      {
        final String oldValue = getImageOrientation();
        final boolean oldPropAvailable = isImageOrientationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.IMAGE_ORIENTATION, imageOrientation);
        propertyChangeSupport.firePropertyChange("imageOrientation", oldValue, imageOrientation);
        propertyChangeSupport.firePropertyChange("imageOrientationAvailable", oldPropAvailable, isImageOrientationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getImageOrientation()
      {
        return getObject(IMAGE_ORIENTATION, String.class);
      }

    public void setImageOrientationAvailable (final boolean available)
      {
        final String oldValue = getImageOrientation();
        final boolean oldPropAvailable = isImageOrientationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(IMAGE_ORIENTATION))
          {
            setObject(IMAGE_ORIENTATION, null);
          }
        else if (!available)
          {
            removeTag(IMAGE_ORIENTATION);
          }

        propertyChangeSupport.firePropertyChange("imageOrientationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("imageOrientation", oldValue, getImageOrientation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isImageOrientationAvailable()
      {
        return containsTag(IMAGE_ORIENTATION);
      }

    public void setLanguageIdentifier (final String languageIdentifier)
      {
        final String oldValue = getLanguageIdentifier();
        final boolean oldPropAvailable = isLanguageIdentifierAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.LANGUAGE_IDENTIFIER, languageIdentifier);
        propertyChangeSupport.firePropertyChange("languageIdentifier", oldValue, languageIdentifier);
        propertyChangeSupport.firePropertyChange("languageIdentifierAvailable", oldPropAvailable, isLanguageIdentifierAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getLanguageIdentifier()
      {
        return getObject(LANGUAGE_IDENTIFIER, String.class);
      }

    public void setLanguageIdentifierAvailable (final boolean available)
      {
        final String oldValue = getLanguageIdentifier();
        final boolean oldPropAvailable = isLanguageIdentifierAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(LANGUAGE_IDENTIFIER))
          {
            setObject(LANGUAGE_IDENTIFIER, null);
          }
        else if (!available)
          {
            removeTag(LANGUAGE_IDENTIFIER);
          }

        propertyChangeSupport.firePropertyChange("languageIdentifierAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("languageIdentifier", oldValue, getLanguageIdentifier());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isLanguageIdentifierAvailable()
      {
        return containsTag(LANGUAGE_IDENTIFIER);
      }

    public void setAudioType (final String audioType)
      {
        final String oldValue = getAudioType();
        final boolean oldPropAvailable = isAudioTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.AUDIO_TYPE, audioType);
        propertyChangeSupport.firePropertyChange("audioType", oldValue, audioType);
        propertyChangeSupport.firePropertyChange("audioTypeAvailable", oldPropAvailable, isAudioTypeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAudioType()
      {
        return getObject(AUDIO_TYPE, String.class);
      }

    public void setAudioTypeAvailable (final boolean available)
      {
        final String oldValue = getAudioType();
        final boolean oldPropAvailable = isAudioTypeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AUDIO_TYPE))
          {
            setObject(AUDIO_TYPE, null);
          }
        else if (!available)
          {
            removeTag(AUDIO_TYPE);
          }

        propertyChangeSupport.firePropertyChange("audioTypeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("audioType", oldValue, getAudioType());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAudioTypeAvailable()
      {
        return containsTag(AUDIO_TYPE);
      }

    public void setAudioSamplingRate (final String audioSamplingRate)
      {
        final String oldValue = getAudioSamplingRate();
        final boolean oldPropAvailable = isAudioSamplingRateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.AUDIO_SAMPLING_RATE, audioSamplingRate);
        propertyChangeSupport.firePropertyChange("audioSamplingRate", oldValue, audioSamplingRate);
        propertyChangeSupport.firePropertyChange("audioSamplingRateAvailable", oldPropAvailable, isAudioSamplingRateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAudioSamplingRate()
      {
        return getObject(AUDIO_SAMPLING_RATE, String.class);
      }

    public void setAudioSamplingRateAvailable (final boolean available)
      {
        final String oldValue = getAudioSamplingRate();
        final boolean oldPropAvailable = isAudioSamplingRateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AUDIO_SAMPLING_RATE))
          {
            setObject(AUDIO_SAMPLING_RATE, null);
          }
        else if (!available)
          {
            removeTag(AUDIO_SAMPLING_RATE);
          }

        propertyChangeSupport.firePropertyChange("audioSamplingRateAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("audioSamplingRate", oldValue, getAudioSamplingRate());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAudioSamplingRateAvailable()
      {
        return containsTag(AUDIO_SAMPLING_RATE);
      }

    public void setAudioSamplingResolution (final String audioSamplingResolution)
      {
        final String oldValue = getAudioSamplingResolution();
        final boolean oldPropAvailable = isAudioSamplingResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.AUDIO_SAMPLING_RESOLUTION, audioSamplingResolution);
        propertyChangeSupport.firePropertyChange("audioSamplingResolution", oldValue, audioSamplingResolution);
        propertyChangeSupport.firePropertyChange("audioSamplingResolutionAvailable", oldPropAvailable, isAudioSamplingResolutionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAudioSamplingResolution()
      {
        return getObject(AUDIO_SAMPLING_RESOLUTION, String.class);
      }

    public void setAudioSamplingResolutionAvailable (final boolean available)
      {
        final String oldValue = getAudioSamplingResolution();
        final boolean oldPropAvailable = isAudioSamplingResolutionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AUDIO_SAMPLING_RESOLUTION))
          {
            setObject(AUDIO_SAMPLING_RESOLUTION, null);
          }
        else if (!available)
          {
            removeTag(AUDIO_SAMPLING_RESOLUTION);
          }

        propertyChangeSupport.firePropertyChange("audioSamplingResolutionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("audioSamplingResolution", oldValue, getAudioSamplingResolution());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAudioSamplingResolutionAvailable()
      {
        return containsTag(AUDIO_SAMPLING_RESOLUTION);
      }

    public void setAudioDuration (final String audioDuration)
      {
        final String oldValue = getAudioDuration();
        final boolean oldPropAvailable = isAudioDurationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.AUDIO_DURATION, audioDuration);
        propertyChangeSupport.firePropertyChange("audioDuration", oldValue, audioDuration);
        propertyChangeSupport.firePropertyChange("audioDurationAvailable", oldPropAvailable, isAudioDurationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAudioDuration()
      {
        return getObject(AUDIO_DURATION, String.class);
      }

    public void setAudioDurationAvailable (final boolean available)
      {
        final String oldValue = getAudioDuration();
        final boolean oldPropAvailable = isAudioDurationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AUDIO_DURATION))
          {
            setObject(AUDIO_DURATION, null);
          }
        else if (!available)
          {
            removeTag(AUDIO_DURATION);
          }

        propertyChangeSupport.firePropertyChange("audioDurationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("audioDuration", oldValue, getAudioDuration());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAudioDurationAvailable()
      {
        return containsTag(AUDIO_DURATION);
      }

    public void setAudioOutcue (final String audioOutcue)
      {
        final String oldValue = getAudioOutcue();
        final boolean oldPropAvailable = isAudioOutcueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.AUDIO_OUTCUE, audioOutcue);
        propertyChangeSupport.firePropertyChange("audioOutcue", oldValue, audioOutcue);
        propertyChangeSupport.firePropertyChange("audioOutcueAvailable", oldPropAvailable, isAudioOutcueAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAudioOutcue()
      {
        return getObject(AUDIO_OUTCUE, String.class);
      }

    public void setAudioOutcueAvailable (final boolean available)
      {
        final String oldValue = getAudioOutcue();
        final boolean oldPropAvailable = isAudioOutcueAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(AUDIO_OUTCUE))
          {
            setObject(AUDIO_OUTCUE, null);
          }
        else if (!available)
          {
            removeTag(AUDIO_OUTCUE);
          }

        propertyChangeSupport.firePropertyChange("audioOutcueAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("audioOutcue", oldValue, getAudioOutcue());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAudioOutcueAvailable()
      {
        return containsTag(AUDIO_OUTCUE);
      }

    public void setJobID (final String jobID)
      {
        final String oldValue = getJobID();
        final boolean oldPropAvailable = isJobIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.JOB_ID, jobID);
        propertyChangeSupport.firePropertyChange("jobID", oldValue, jobID);
        propertyChangeSupport.firePropertyChange("jobIDAvailable", oldPropAvailable, isJobIDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getJobID()
      {
        return getObject(JOB_ID, String.class);
      }

    public void setJobIDAvailable (final boolean available)
      {
        final String oldValue = getJobID();
        final boolean oldPropAvailable = isJobIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(JOB_ID))
          {
            setObject(JOB_ID, null);
          }
        else if (!available)
          {
            removeTag(JOB_ID);
          }

        propertyChangeSupport.firePropertyChange("jobIDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("jobID", oldValue, getJobID());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isJobIDAvailable()
      {
        return containsTag(JOB_ID);
      }

    public void setMasterDocumentID (final String masterDocumentID)
      {
        final String oldValue = getMasterDocumentID();
        final boolean oldPropAvailable = isMasterDocumentIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.MASTER_DOCUMENT_ID, masterDocumentID);
        propertyChangeSupport.firePropertyChange("masterDocumentID", oldValue, masterDocumentID);
        propertyChangeSupport.firePropertyChange("masterDocumentIDAvailable", oldPropAvailable, isMasterDocumentIDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getMasterDocumentID()
      {
        return getObject(MASTER_DOCUMENT_ID, String.class);
      }

    public void setMasterDocumentIDAvailable (final boolean available)
      {
        final String oldValue = getMasterDocumentID();
        final boolean oldPropAvailable = isMasterDocumentIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(MASTER_DOCUMENT_ID))
          {
            setObject(MASTER_DOCUMENT_ID, null);
          }
        else if (!available)
          {
            removeTag(MASTER_DOCUMENT_ID);
          }

        propertyChangeSupport.firePropertyChange("masterDocumentIDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("masterDocumentID", oldValue, getMasterDocumentID());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isMasterDocumentIDAvailable()
      {
        return containsTag(MASTER_DOCUMENT_ID);
      }

    public void setShortDocumentID (final String shortDocumentID)
      {
        final String oldValue = getShortDocumentID();
        final boolean oldPropAvailable = isShortDocumentIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.SHORT_DOCUMENT_ID, shortDocumentID);
        propertyChangeSupport.firePropertyChange("shortDocumentID", oldValue, shortDocumentID);
        propertyChangeSupport.firePropertyChange("shortDocumentIDAvailable", oldPropAvailable, isShortDocumentIDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getShortDocumentID()
      {
        return getObject(SHORT_DOCUMENT_ID, String.class);
      }

    public void setShortDocumentIDAvailable (final boolean available)
      {
        final String oldValue = getShortDocumentID();
        final boolean oldPropAvailable = isShortDocumentIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SHORT_DOCUMENT_ID))
          {
            setObject(SHORT_DOCUMENT_ID, null);
          }
        else if (!available)
          {
            removeTag(SHORT_DOCUMENT_ID);
          }

        propertyChangeSupport.firePropertyChange("shortDocumentIDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("shortDocumentID", oldValue, getShortDocumentID());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isShortDocumentIDAvailable()
      {
        return containsTag(SHORT_DOCUMENT_ID);
      }

    public void setUniqueDocumentID (final String uniqueDocumentID)
      {
        final String oldValue = getUniqueDocumentID();
        final boolean oldPropAvailable = isUniqueDocumentIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.UNIQUE_DOCUMENT_ID, uniqueDocumentID);
        propertyChangeSupport.firePropertyChange("uniqueDocumentID", oldValue, uniqueDocumentID);
        propertyChangeSupport.firePropertyChange("uniqueDocumentIDAvailable", oldPropAvailable, isUniqueDocumentIDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getUniqueDocumentID()
      {
        return getObject(UNIQUE_DOCUMENT_ID, String.class);
      }

    public void setUniqueDocumentIDAvailable (final boolean available)
      {
        final String oldValue = getUniqueDocumentID();
        final boolean oldPropAvailable = isUniqueDocumentIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(UNIQUE_DOCUMENT_ID))
          {
            setObject(UNIQUE_DOCUMENT_ID, null);
          }
        else if (!available)
          {
            removeTag(UNIQUE_DOCUMENT_ID);
          }

        propertyChangeSupport.firePropertyChange("uniqueDocumentIDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("uniqueDocumentID", oldValue, getUniqueDocumentID());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isUniqueDocumentIDAvailable()
      {
        return containsTag(UNIQUE_DOCUMENT_ID);
      }

    public void setOwnerID (final String ownerID)
      {
        final String oldValue = getOwnerID();
        final boolean oldPropAvailable = isOwnerIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OWNER_ID, ownerID);
        propertyChangeSupport.firePropertyChange("ownerID", oldValue, ownerID);
        propertyChangeSupport.firePropertyChange("ownerIDAvailable", oldPropAvailable, isOwnerIDAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getOwnerID()
      {
        return getObject(OWNER_ID, String.class);
      }

    public void setOwnerIDAvailable (final boolean available)
      {
        final String oldValue = getOwnerID();
        final boolean oldPropAvailable = isOwnerIDAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OWNER_ID))
          {
            setObject(OWNER_ID, null);
          }
        else if (!available)
          {
            removeTag(OWNER_ID);
          }

        propertyChangeSupport.firePropertyChange("ownerIDAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("ownerID", oldValue, getOwnerID());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isOwnerIDAvailable()
      {
        return containsTag(OWNER_ID);
      }

    public static enum ObjectPreviewFileFormat
       {
         NO_OBJECTDATA(0, "No ObjectData"),
         IPTC_NAA_DIGITAL_NEWSPHOTO_PARAMETER_RECORD(1, "IPTC-NAA Digital Newsphoto Parameter Record"),
         IPTC7901_RECOMMENDED_MESSAGE_FORMAT(2, "IPTC7901 Recommended Message Format"),
         TAGGED_IMAGE_FILE_FORMAT_ADOBE_ALDUS_IMAGE_DATA(3, "Tagged Image File Format Adobe/Aldus Image data)"),
         ILLUSTRATOR_ADOBE_GRAPHICS_DATA(4, "Illustrator Adobe Graphics data)"),
         APPLESINGLE_APPLE_COMPUTER_INC(5, "AppleSingle Apple Computer Inc)"),
         NAA_89_3_ANPA_1312(6, "NAA 89-3 ANPA 1312"),
         MACBINARY_II(7, "MacBinary II"),
         IPTC_UNSTRUCTURED_CHARACTER_ORIENTED_FILE_FORMAT_UCOFF(8, "IPTC Unstructured Character Oriented File Format UCOFF)"),
         UNITED_PRESS_INTERNATIONAL_ANPA_1312_VARIANT(9, "United Press International ANPA 1312 variant"),
         UNITED_PRESS_INTERNATIONAL_DOWN_LOAD_MESSAGE(10, "United Press International Down-Load Message"),
         JPEG_FILE_INTERCHANGE_JFIF(11, "JPEG File Interchange JFIF)"),
         PHOTO_CD_IMAGE_PAC_EASTMAN_KODAK(12, "Photo-CD Image-Pac Eastman Kodak)"),
         BIT_MAPPED_GRAPHICS_FILE_BMP_MICROSOFT(13, "Bit Mapped Graphics File BMP Microsoft)"),
         DIGITAL_AUDIO_FILE_WAV_MICROSOFT__CREATIVE_LABS(14, "Digital Audio File WAV Microsoft  Creative Labs)"),
         AUDIO_PLUS_MOVING_VIDEO_AVI_MICROSOFT(15, "Audio plus Moving Video AVI Microsoft)"),
         PC_DOS_WINDOWS_EXECUTABLE_FILES_COMEXE(16, "PC DOS/Windows Executable Files COMEXE"),
         COMPRESSED_BINARY_FILE_ZIP_PKWARE_INC(17, "Compressed Binary File ZIP PKWare Inc)"),
         AUDIO_INTERCHANGE_FILE_FORMAT_AIFF_APPLE_COMPUTER_INC(18, "Audio Interchange File Format AIFF Apple Computer Inc)"),
         RIFF_WAVE_MICROSOFT_CORPORATION(19, "RIFF Wave Microsoft Corporation)"),
         FREEHAND_MACROMEDIA_ALDUS(20, "Freehand Macromedia/Aldus)"),
         HYPERTEXT_MARKUP_LANGUAGE_HTML_THE_INTERNET_SOCIETY(21, "Hypertext Markup Language HTML The Internet Society)"),
         MPEG_2_AUDIO_LAYER_2_MUSICOM(22, "MPEG 2 Audio Layer 2 Musicom)"),
         MPEG_2_AUDIO_LAYER_3(23, "MPEG 2 Audio Layer 3"),
         PORTABLE_DOCUMENT_FILE_PDF_ADOBE(24, "Portable Document File PDF Adobe"),
         NEWS_INDUSTRY_TEXT_FORMAT_NITF(25, "News Industry Text Format NITF)"),
         TAPE_ARCHIVE_TAR(26, "Tape Archive TAR"),
         TIDNINGARNAS_TELEGRAMBYRA_NITF_VERSION_TTNITF_DTD(27, "Tidningarnas Telegrambyra NITF version TTNITF DTD)"),
         RITZAUS_BUREAU_NITF_VERSION_RBNITF_DTD(28, "Ritzaus Bureau NITF version RBNITF DTD)"),
         COREL_DRAW_CDR(29, "Corel Draw CDR"),
         _UNKNOWN(-1, "_unknown_");
         private final static long serialVersionUID = 3059468666726854749L;
         private int value;
         private String name;

         private ObjectPreviewFileFormat (final int value, final String name)
           {
             this.value = value;
             this.name = name;
           }

         public int getValue()
           {
             return value;
           }

         public static ObjectPreviewFileFormat fromInteger (int value)
           {
             if (value == 0) return NO_OBJECTDATA;
             if (value == 1) return IPTC_NAA_DIGITAL_NEWSPHOTO_PARAMETER_RECORD;
             if (value == 2) return IPTC7901_RECOMMENDED_MESSAGE_FORMAT;
             if (value == 3) return TAGGED_IMAGE_FILE_FORMAT_ADOBE_ALDUS_IMAGE_DATA;
             if (value == 4) return ILLUSTRATOR_ADOBE_GRAPHICS_DATA;
             if (value == 5) return APPLESINGLE_APPLE_COMPUTER_INC;
             if (value == 6) return NAA_89_3_ANPA_1312;
             if (value == 7) return MACBINARY_II;
             if (value == 8) return IPTC_UNSTRUCTURED_CHARACTER_ORIENTED_FILE_FORMAT_UCOFF;
             if (value == 9) return UNITED_PRESS_INTERNATIONAL_ANPA_1312_VARIANT;
             if (value == 10) return UNITED_PRESS_INTERNATIONAL_DOWN_LOAD_MESSAGE;
             if (value == 11) return JPEG_FILE_INTERCHANGE_JFIF;
             if (value == 12) return PHOTO_CD_IMAGE_PAC_EASTMAN_KODAK;
             if (value == 13) return BIT_MAPPED_GRAPHICS_FILE_BMP_MICROSOFT;
             if (value == 14) return DIGITAL_AUDIO_FILE_WAV_MICROSOFT__CREATIVE_LABS;
             if (value == 15) return AUDIO_PLUS_MOVING_VIDEO_AVI_MICROSOFT;
             if (value == 16) return PC_DOS_WINDOWS_EXECUTABLE_FILES_COMEXE;
             if (value == 17) return COMPRESSED_BINARY_FILE_ZIP_PKWARE_INC;
             if (value == 18) return AUDIO_INTERCHANGE_FILE_FORMAT_AIFF_APPLE_COMPUTER_INC;
             if (value == 19) return RIFF_WAVE_MICROSOFT_CORPORATION;
             if (value == 20) return FREEHAND_MACROMEDIA_ALDUS;
             if (value == 21) return HYPERTEXT_MARKUP_LANGUAGE_HTML_THE_INTERNET_SOCIETY;
             if (value == 22) return MPEG_2_AUDIO_LAYER_2_MUSICOM;
             if (value == 23) return MPEG_2_AUDIO_LAYER_3;
             if (value == 24) return PORTABLE_DOCUMENT_FILE_PDF_ADOBE;
             if (value == 25) return NEWS_INDUSTRY_TEXT_FORMAT_NITF;
             if (value == 26) return TAPE_ARCHIVE_TAR;
             if (value == 27) return TIDNINGARNAS_TELEGRAMBYRA_NITF_VERSION_TTNITF_DTD;
             if (value == 28) return RITZAUS_BUREAU_NITF_VERSION_RBNITF_DTD;
             if (value == 29) return COREL_DRAW_CDR;

             return _UNKNOWN;
           }
       }
    public void setObjectPreviewFileFormat (final ObjectPreviewFileFormat objectPreviewFileFormat)
      {
        final ObjectPreviewFileFormat oldValue = getObjectPreviewFileFormat();
        final boolean oldPropAvailable = isObjectPreviewFileFormatAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECT_PREVIEW_FILE_FORMAT, objectPreviewFileFormat);
        propertyChangeSupport.firePropertyChange("objectPreviewFileFormat", oldValue, objectPreviewFileFormat);
        propertyChangeSupport.firePropertyChange("objectPreviewFileFormatAvailable", oldPropAvailable, isObjectPreviewFileFormatAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public ObjectPreviewFileFormat getObjectPreviewFileFormat()
      {
        return getObject(OBJECT_PREVIEW_FILE_FORMAT, ObjectPreviewFileFormat.class);
      }

    public void setObjectPreviewFileFormatAvailable (final boolean available)
      {
        final ObjectPreviewFileFormat oldValue = getObjectPreviewFileFormat();
        final boolean oldPropAvailable = isObjectPreviewFileFormatAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECT_PREVIEW_FILE_FORMAT))
          {
            setObject(OBJECT_PREVIEW_FILE_FORMAT, null);
          }
        else if (!available)
          {
            removeTag(OBJECT_PREVIEW_FILE_FORMAT);
          }

        propertyChangeSupport.firePropertyChange("objectPreviewFileFormatAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectPreviewFileFormat", oldValue, getObjectPreviewFileFormat());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectPreviewFileFormatAvailable()
      {
        return containsTag(OBJECT_PREVIEW_FILE_FORMAT);
      }

    public void setObjectPreviewFileVersion (final Integer objectPreviewFileVersion)
      {
        final Integer oldValue = getObjectPreviewFileVersion();
        final boolean oldPropAvailable = isObjectPreviewFileVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECT_PREVIEW_FILE_VERSION, objectPreviewFileVersion);
        propertyChangeSupport.firePropertyChange("objectPreviewFileVersion", oldValue, objectPreviewFileVersion);
        propertyChangeSupport.firePropertyChange("objectPreviewFileVersionAvailable", oldPropAvailable, isObjectPreviewFileVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getObjectPreviewFileVersion()
      {
        return getObject(OBJECT_PREVIEW_FILE_VERSION, Integer.class);
      }

    public void setObjectPreviewFileVersionAvailable (final boolean available)
      {
        final Integer oldValue = getObjectPreviewFileVersion();
        final boolean oldPropAvailable = isObjectPreviewFileVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECT_PREVIEW_FILE_VERSION))
          {
            setObject(OBJECT_PREVIEW_FILE_VERSION, null);
          }
        else if (!available)
          {
            removeTag(OBJECT_PREVIEW_FILE_VERSION);
          }

        propertyChangeSupport.firePropertyChange("objectPreviewFileVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectPreviewFileVersion", oldValue, getObjectPreviewFileVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectPreviewFileVersionAvailable()
      {
        return containsTag(OBJECT_PREVIEW_FILE_VERSION);
      }

    public void setObjectPreviewData (final String objectPreviewData)
      {
        final String oldValue = getObjectPreviewData();
        final boolean oldPropAvailable = isObjectPreviewDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECT_PREVIEW_DATA, objectPreviewData);
        propertyChangeSupport.firePropertyChange("objectPreviewData", oldValue, objectPreviewData);
        propertyChangeSupport.firePropertyChange("objectPreviewDataAvailable", oldPropAvailable, isObjectPreviewDataAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getObjectPreviewData()
      {
        return getObject(OBJECT_PREVIEW_DATA, String.class);
      }

    public void setObjectPreviewDataAvailable (final boolean available)
      {
        final String oldValue = getObjectPreviewData();
        final boolean oldPropAvailable = isObjectPreviewDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECT_PREVIEW_DATA))
          {
            setObject(OBJECT_PREVIEW_DATA, null);
          }
        else if (!available)
          {
            removeTag(OBJECT_PREVIEW_DATA);
          }

        propertyChangeSupport.firePropertyChange("objectPreviewDataAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectPreviewData", oldValue, getObjectPreviewData());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectPreviewDataAvailable()
      {
        return containsTag(OBJECT_PREVIEW_DATA);
      }

    public void setPrefs (final String prefs)
      {
        final String oldValue = getPrefs();
        final boolean oldPropAvailable = isPrefsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.PREFS, prefs);
        propertyChangeSupport.firePropertyChange("prefs", oldValue, prefs);
        propertyChangeSupport.firePropertyChange("prefsAvailable", oldPropAvailable, isPrefsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getPrefs()
      {
        return getObject(PREFS, String.class);
      }

    public void setPrefsAvailable (final boolean available)
      {
        final String oldValue = getPrefs();
        final boolean oldPropAvailable = isPrefsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PREFS))
          {
            setObject(PREFS, null);
          }
        else if (!available)
          {
            removeTag(PREFS);
          }

        propertyChangeSupport.firePropertyChange("prefsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("prefs", oldValue, getPrefs());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isPrefsAvailable()
      {
        return containsTag(PREFS);
      }

    public void setClassifyState (final String classifyState)
      {
        final String oldValue = getClassifyState();
        final boolean oldPropAvailable = isClassifyStateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.CLASSIFY_STATE, classifyState);
        propertyChangeSupport.firePropertyChange("classifyState", oldValue, classifyState);
        propertyChangeSupport.firePropertyChange("classifyStateAvailable", oldPropAvailable, isClassifyStateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getClassifyState()
      {
        return getObject(CLASSIFY_STATE, String.class);
      }

    public void setClassifyStateAvailable (final boolean available)
      {
        final String oldValue = getClassifyState();
        final boolean oldPropAvailable = isClassifyStateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CLASSIFY_STATE))
          {
            setObject(CLASSIFY_STATE, null);
          }
        else if (!available)
          {
            removeTag(CLASSIFY_STATE);
          }

        propertyChangeSupport.firePropertyChange("classifyStateAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("classifyState", oldValue, getClassifyState());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isClassifyStateAvailable()
      {
        return containsTag(CLASSIFY_STATE);
      }

    public void setSimilarityIndex (final String similarityIndex)
      {
        final String oldValue = getSimilarityIndex();
        final boolean oldPropAvailable = isSimilarityIndexAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.SIMILARITY_INDEX, similarityIndex);
        propertyChangeSupport.firePropertyChange("similarityIndex", oldValue, similarityIndex);
        propertyChangeSupport.firePropertyChange("similarityIndexAvailable", oldPropAvailable, isSimilarityIndexAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSimilarityIndex()
      {
        return getObject(SIMILARITY_INDEX, String.class);
      }

    public void setSimilarityIndexAvailable (final boolean available)
      {
        final String oldValue = getSimilarityIndex();
        final boolean oldPropAvailable = isSimilarityIndexAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SIMILARITY_INDEX))
          {
            setObject(SIMILARITY_INDEX, null);
          }
        else if (!available)
          {
            removeTag(SIMILARITY_INDEX);
          }

        propertyChangeSupport.firePropertyChange("similarityIndexAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("similarityIndex", oldValue, getSimilarityIndex());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSimilarityIndexAvailable()
      {
        return containsTag(SIMILARITY_INDEX);
      }

    public void setDocumentNotes (final String documentNotes)
      {
        final String oldValue = getDocumentNotes();
        final boolean oldPropAvailable = isDocumentNotesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.DOCUMENT_NOTES, documentNotes);
        propertyChangeSupport.firePropertyChange("documentNotes", oldValue, documentNotes);
        propertyChangeSupport.firePropertyChange("documentNotesAvailable", oldPropAvailable, isDocumentNotesAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getDocumentNotes()
      {
        return getObject(DOCUMENT_NOTES, String.class);
      }

    public void setDocumentNotesAvailable (final boolean available)
      {
        final String oldValue = getDocumentNotes();
        final boolean oldPropAvailable = isDocumentNotesAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DOCUMENT_NOTES))
          {
            setObject(DOCUMENT_NOTES, null);
          }
        else if (!available)
          {
            removeTag(DOCUMENT_NOTES);
          }

        propertyChangeSupport.firePropertyChange("documentNotesAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("documentNotes", oldValue, getDocumentNotes());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDocumentNotesAvailable()
      {
        return containsTag(DOCUMENT_NOTES);
      }

    public void setDocumentHistory (final String documentHistory)
      {
        final String oldValue = getDocumentHistory();
        final boolean oldPropAvailable = isDocumentHistoryAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.DOCUMENT_HISTORY, documentHistory);
        propertyChangeSupport.firePropertyChange("documentHistory", oldValue, documentHistory);
        propertyChangeSupport.firePropertyChange("documentHistoryAvailable", oldPropAvailable, isDocumentHistoryAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getDocumentHistory()
      {
        return getObject(DOCUMENT_HISTORY, String.class);
      }

    public void setDocumentHistoryAvailable (final boolean available)
      {
        final String oldValue = getDocumentHistory();
        final boolean oldPropAvailable = isDocumentHistoryAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(DOCUMENT_HISTORY))
          {
            setObject(DOCUMENT_HISTORY, null);
          }
        else if (!available)
          {
            removeTag(DOCUMENT_HISTORY);
          }

        propertyChangeSupport.firePropertyChange("documentHistoryAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("documentHistory", oldValue, getDocumentHistory());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isDocumentHistoryAvailable()
      {
        return containsTag(DOCUMENT_HISTORY);
      }

    public void setEXIFCameraInfo (final String EXIFCameraInfo)
      {
        final String oldValue = getEXIFCameraInfo();
        final boolean oldPropAvailable = isEXIFCameraInfoAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.EXIF_CAMERA_INFO, EXIFCameraInfo);
        propertyChangeSupport.firePropertyChange("EXIFCameraInfo", oldValue, EXIFCameraInfo);
        propertyChangeSupport.firePropertyChange("EXIFCameraInfoAvailable", oldPropAvailable, isEXIFCameraInfoAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getEXIFCameraInfo()
      {
        return getObject(EXIF_CAMERA_INFO, String.class);
      }

    public void setEXIFCameraInfoAvailable (final boolean available)
      {
        final String oldValue = getEXIFCameraInfo();
        final boolean oldPropAvailable = isEXIFCameraInfoAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(EXIF_CAMERA_INFO))
          {
            setObject(EXIF_CAMERA_INFO, null);
          }
        else if (!available)
          {
            removeTag(EXIF_CAMERA_INFO);
          }

        propertyChangeSupport.firePropertyChange("EXIFCameraInfoAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("EXIFCameraInfo", oldValue, getEXIFCameraInfo());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isEXIFCameraInfoAvailable()
      {
        return containsTag(EXIF_CAMERA_INFO);
      }

    public void setAdobeCreatorAddress (final String adobeCreatorAddress)
      {
        final String oldValue = getAdobeCreatorAddress();
        final boolean oldPropAvailable = isAdobeCreatorAddressAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_CREATOR_ADDRESS, adobeCreatorAddress);
        propertyChangeSupport.firePropertyChange("adobeCreatorAddress", oldValue, adobeCreatorAddress);
        propertyChangeSupport.firePropertyChange("adobeCreatorAddressAvailable", oldPropAvailable, isAdobeCreatorAddressAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCreatorAddress()
      {
        return getObject(ADOBE_CREATOR_ADDRESS, String.class);
      }

    public void setAdobeCreatorAddressAvailable (final boolean available)
      {
        final String oldValue = getAdobeCreatorAddress();
        final boolean oldPropAvailable = isAdobeCreatorAddressAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_CREATOR_ADDRESS))
          {
            setObject(ADOBE_CREATOR_ADDRESS, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_CREATOR_ADDRESS);
          }

        propertyChangeSupport.firePropertyChange("adobeCreatorAddressAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCreatorAddress", oldValue, getAdobeCreatorAddress());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCreatorAddressAvailable()
      {
        return containsTag(ADOBE_CREATOR_ADDRESS);
      }

    public void setAdobeCreatorCity (final String adobeCreatorCity)
      {
        final String oldValue = getAdobeCreatorCity();
        final boolean oldPropAvailable = isAdobeCreatorCityAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_CREATOR_CITY, adobeCreatorCity);
        propertyChangeSupport.firePropertyChange("adobeCreatorCity", oldValue, adobeCreatorCity);
        propertyChangeSupport.firePropertyChange("adobeCreatorCityAvailable", oldPropAvailable, isAdobeCreatorCityAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCreatorCity()
      {
        return getObject(ADOBE_CREATOR_CITY, String.class);
      }

    public void setAdobeCreatorCityAvailable (final boolean available)
      {
        final String oldValue = getAdobeCreatorCity();
        final boolean oldPropAvailable = isAdobeCreatorCityAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_CREATOR_CITY))
          {
            setObject(ADOBE_CREATOR_CITY, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_CREATOR_CITY);
          }

        propertyChangeSupport.firePropertyChange("adobeCreatorCityAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCreatorCity", oldValue, getAdobeCreatorCity());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCreatorCityAvailable()
      {
        return containsTag(ADOBE_CREATOR_CITY);
      }

    public void setAdobeCreatorStateProvince (final String adobeCreatorStateProvince)
      {
        final String oldValue = getAdobeCreatorStateProvince();
        final boolean oldPropAvailable = isAdobeCreatorStateProvinceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_CREATOR_STATE__PROVINCE, adobeCreatorStateProvince);
        propertyChangeSupport.firePropertyChange("adobeCreatorStateProvince", oldValue, adobeCreatorStateProvince);
        propertyChangeSupport.firePropertyChange("adobeCreatorStateProvinceAvailable", oldPropAvailable, isAdobeCreatorStateProvinceAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCreatorStateProvince()
      {
        return getObject(ADOBE_CREATOR_STATE__PROVINCE, String.class);
      }

    public void setAdobeCreatorStateProvinceAvailable (final boolean available)
      {
        final String oldValue = getAdobeCreatorStateProvince();
        final boolean oldPropAvailable = isAdobeCreatorStateProvinceAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_CREATOR_STATE__PROVINCE))
          {
            setObject(ADOBE_CREATOR_STATE__PROVINCE, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_CREATOR_STATE__PROVINCE);
          }

        propertyChangeSupport.firePropertyChange("adobeCreatorStateProvinceAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCreatorStateProvince", oldValue, getAdobeCreatorStateProvince());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCreatorStateProvinceAvailable()
      {
        return containsTag(ADOBE_CREATOR_STATE__PROVINCE);
      }

    public void setAdobeCreatorPostalCode (final String adobeCreatorPostalCode)
      {
        final String oldValue = getAdobeCreatorPostalCode();
        final boolean oldPropAvailable = isAdobeCreatorPostalCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_CREATOR_POSTAL_CODE, adobeCreatorPostalCode);
        propertyChangeSupport.firePropertyChange("adobeCreatorPostalCode", oldValue, adobeCreatorPostalCode);
        propertyChangeSupport.firePropertyChange("adobeCreatorPostalCodeAvailable", oldPropAvailable, isAdobeCreatorPostalCodeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCreatorPostalCode()
      {
        return getObject(ADOBE_CREATOR_POSTAL_CODE, String.class);
      }

    public void setAdobeCreatorPostalCodeAvailable (final boolean available)
      {
        final String oldValue = getAdobeCreatorPostalCode();
        final boolean oldPropAvailable = isAdobeCreatorPostalCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_CREATOR_POSTAL_CODE))
          {
            setObject(ADOBE_CREATOR_POSTAL_CODE, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_CREATOR_POSTAL_CODE);
          }

        propertyChangeSupport.firePropertyChange("adobeCreatorPostalCodeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCreatorPostalCode", oldValue, getAdobeCreatorPostalCode());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCreatorPostalCodeAvailable()
      {
        return containsTag(ADOBE_CREATOR_POSTAL_CODE);
      }

    public void setAdobeCreatorCountry (final String adobeCreatorCountry)
      {
        final String oldValue = getAdobeCreatorCountry();
        final boolean oldPropAvailable = isAdobeCreatorCountryAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_CREATOR_COUNTRY, adobeCreatorCountry);
        propertyChangeSupport.firePropertyChange("adobeCreatorCountry", oldValue, adobeCreatorCountry);
        propertyChangeSupport.firePropertyChange("adobeCreatorCountryAvailable", oldPropAvailable, isAdobeCreatorCountryAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCreatorCountry()
      {
        return getObject(ADOBE_CREATOR_COUNTRY, String.class);
      }

    public void setAdobeCreatorCountryAvailable (final boolean available)
      {
        final String oldValue = getAdobeCreatorCountry();
        final boolean oldPropAvailable = isAdobeCreatorCountryAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_CREATOR_COUNTRY))
          {
            setObject(ADOBE_CREATOR_COUNTRY, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_CREATOR_COUNTRY);
          }

        propertyChangeSupport.firePropertyChange("adobeCreatorCountryAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCreatorCountry", oldValue, getAdobeCreatorCountry());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCreatorCountryAvailable()
      {
        return containsTag(ADOBE_CREATOR_COUNTRY);
      }

    public void setAdobeCreatorPhone (final String adobeCreatorPhone)
      {
        final String oldValue = getAdobeCreatorPhone();
        final boolean oldPropAvailable = isAdobeCreatorPhoneAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_CREATOR_PHONE, adobeCreatorPhone);
        propertyChangeSupport.firePropertyChange("adobeCreatorPhone", oldValue, adobeCreatorPhone);
        propertyChangeSupport.firePropertyChange("adobeCreatorPhoneAvailable", oldPropAvailable, isAdobeCreatorPhoneAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCreatorPhone()
      {
        return getObject(ADOBE_CREATOR_PHONE, String.class);
      }

    public void setAdobeCreatorPhoneAvailable (final boolean available)
      {
        final String oldValue = getAdobeCreatorPhone();
        final boolean oldPropAvailable = isAdobeCreatorPhoneAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_CREATOR_PHONE))
          {
            setObject(ADOBE_CREATOR_PHONE, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_CREATOR_PHONE);
          }

        propertyChangeSupport.firePropertyChange("adobeCreatorPhoneAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCreatorPhone", oldValue, getAdobeCreatorPhone());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCreatorPhoneAvailable()
      {
        return containsTag(ADOBE_CREATOR_PHONE);
      }

    public void setAdobeCreatorEmail (final String adobeCreatorEmail)
      {
        final String oldValue = getAdobeCreatorEmail();
        final boolean oldPropAvailable = isAdobeCreatorEmailAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_CREATOR_EMAIL, adobeCreatorEmail);
        propertyChangeSupport.firePropertyChange("adobeCreatorEmail", oldValue, adobeCreatorEmail);
        propertyChangeSupport.firePropertyChange("adobeCreatorEmailAvailable", oldPropAvailable, isAdobeCreatorEmailAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCreatorEmail()
      {
        return getObject(ADOBE_CREATOR_EMAIL, String.class);
      }

    public void setAdobeCreatorEmailAvailable (final boolean available)
      {
        final String oldValue = getAdobeCreatorEmail();
        final boolean oldPropAvailable = isAdobeCreatorEmailAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_CREATOR_EMAIL))
          {
            setObject(ADOBE_CREATOR_EMAIL, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_CREATOR_EMAIL);
          }

        propertyChangeSupport.firePropertyChange("adobeCreatorEmailAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCreatorEmail", oldValue, getAdobeCreatorEmail());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCreatorEmailAvailable()
      {
        return containsTag(ADOBE_CREATOR_EMAIL);
      }

    public void setAdobeCreatorWebsite (final String adobeCreatorWebsite)
      {
        final String oldValue = getAdobeCreatorWebsite();
        final boolean oldPropAvailable = isAdobeCreatorWebsiteAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_CREATOR_WEBSITE, adobeCreatorWebsite);
        propertyChangeSupport.firePropertyChange("adobeCreatorWebsite", oldValue, adobeCreatorWebsite);
        propertyChangeSupport.firePropertyChange("adobeCreatorWebsiteAvailable", oldPropAvailable, isAdobeCreatorWebsiteAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCreatorWebsite()
      {
        return getObject(ADOBE_CREATOR_WEBSITE, String.class);
      }

    public void setAdobeCreatorWebsiteAvailable (final boolean available)
      {
        final String oldValue = getAdobeCreatorWebsite();
        final boolean oldPropAvailable = isAdobeCreatorWebsiteAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_CREATOR_WEBSITE))
          {
            setObject(ADOBE_CREATOR_WEBSITE, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_CREATOR_WEBSITE);
          }

        propertyChangeSupport.firePropertyChange("adobeCreatorWebsiteAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCreatorWebsite", oldValue, getAdobeCreatorWebsite());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCreatorWebsiteAvailable()
      {
        return containsTag(ADOBE_CREATOR_WEBSITE);
      }

    public void setAdobeIPTCSubjectCode (final String adobeIPTCSubjectCode)
      {
        final String oldValue = getAdobeIPTCSubjectCode();
        final boolean oldPropAvailable = isAdobeIPTCSubjectCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_IPTC_SUBJECT_CODE, adobeIPTCSubjectCode);
        propertyChangeSupport.firePropertyChange("adobeIPTCSubjectCode", oldValue, adobeIPTCSubjectCode);
        propertyChangeSupport.firePropertyChange("adobeIPTCSubjectCodeAvailable", oldPropAvailable, isAdobeIPTCSubjectCodeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeIPTCSubjectCode()
      {
        return getObject(ADOBE_IPTC_SUBJECT_CODE, String.class);
      }

    public void setAdobeIPTCSubjectCodeAvailable (final boolean available)
      {
        final String oldValue = getAdobeIPTCSubjectCode();
        final boolean oldPropAvailable = isAdobeIPTCSubjectCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_IPTC_SUBJECT_CODE))
          {
            setObject(ADOBE_IPTC_SUBJECT_CODE, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_IPTC_SUBJECT_CODE);
          }

        propertyChangeSupport.firePropertyChange("adobeIPTCSubjectCodeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeIPTCSubjectCode", oldValue, getAdobeIPTCSubjectCode());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeIPTCSubjectCodeAvailable()
      {
        return containsTag(ADOBE_IPTC_SUBJECT_CODE);
      }

    public void setAdobeIntellectualGenre (final String adobeIntellectualGenre)
      {
        final String oldValue = getAdobeIntellectualGenre();
        final boolean oldPropAvailable = isAdobeIntellectualGenreAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_INTELLECTUAL_GENRE, adobeIntellectualGenre);
        propertyChangeSupport.firePropertyChange("adobeIntellectualGenre", oldValue, adobeIntellectualGenre);
        propertyChangeSupport.firePropertyChange("adobeIntellectualGenreAvailable", oldPropAvailable, isAdobeIntellectualGenreAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeIntellectualGenre()
      {
        return getObject(ADOBE_INTELLECTUAL_GENRE, String.class);
      }

    public void setAdobeIntellectualGenreAvailable (final boolean available)
      {
        final String oldValue = getAdobeIntellectualGenre();
        final boolean oldPropAvailable = isAdobeIntellectualGenreAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_INTELLECTUAL_GENRE))
          {
            setObject(ADOBE_INTELLECTUAL_GENRE, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_INTELLECTUAL_GENRE);
          }

        propertyChangeSupport.firePropertyChange("adobeIntellectualGenreAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeIntellectualGenre", oldValue, getAdobeIntellectualGenre());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeIntellectualGenreAvailable()
      {
        return containsTag(ADOBE_INTELLECTUAL_GENRE);
      }

    public void setAdobeScene (final String adobeScene)
      {
        final String oldValue = getAdobeScene();
        final boolean oldPropAvailable = isAdobeSceneAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_SCENE, adobeScene);
        propertyChangeSupport.firePropertyChange("adobeScene", oldValue, adobeScene);
        propertyChangeSupport.firePropertyChange("adobeSceneAvailable", oldPropAvailable, isAdobeSceneAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeScene()
      {
        return getObject(ADOBE_SCENE, String.class);
      }

    public void setAdobeSceneAvailable (final boolean available)
      {
        final String oldValue = getAdobeScene();
        final boolean oldPropAvailable = isAdobeSceneAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_SCENE))
          {
            setObject(ADOBE_SCENE, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_SCENE);
          }

        propertyChangeSupport.firePropertyChange("adobeSceneAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeScene", oldValue, getAdobeScene());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeSceneAvailable()
      {
        return containsTag(ADOBE_SCENE);
      }

    public void setAdobeLocation (final String adobeLocation)
      {
        final String oldValue = getAdobeLocation();
        final boolean oldPropAvailable = isAdobeLocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_LOCATION, adobeLocation);
        propertyChangeSupport.firePropertyChange("adobeLocation", oldValue, adobeLocation);
        propertyChangeSupport.firePropertyChange("adobeLocationAvailable", oldPropAvailable, isAdobeLocationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeLocation()
      {
        return getObject(ADOBE_LOCATION, String.class);
      }

    public void setAdobeLocationAvailable (final boolean available)
      {
        final String oldValue = getAdobeLocation();
        final boolean oldPropAvailable = isAdobeLocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_LOCATION))
          {
            setObject(ADOBE_LOCATION, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_LOCATION);
          }

        propertyChangeSupport.firePropertyChange("adobeLocationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeLocation", oldValue, getAdobeLocation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeLocationAvailable()
      {
        return containsTag(ADOBE_LOCATION);
      }

    public void setAdobeCountryISOCode (final String adobeCountryISOCode)
      {
        final String oldValue = getAdobeCountryISOCode();
        final boolean oldPropAvailable = isAdobeCountryISOCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_COUNTRY_ISO_CODE, adobeCountryISOCode);
        propertyChangeSupport.firePropertyChange("adobeCountryISOCode", oldValue, adobeCountryISOCode);
        propertyChangeSupport.firePropertyChange("adobeCountryISOCodeAvailable", oldPropAvailable, isAdobeCountryISOCodeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCountryISOCode()
      {
        return getObject(ADOBE_COUNTRY_ISO_CODE, String.class);
      }

    public void setAdobeCountryISOCodeAvailable (final boolean available)
      {
        final String oldValue = getAdobeCountryISOCode();
        final boolean oldPropAvailable = isAdobeCountryISOCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_COUNTRY_ISO_CODE))
          {
            setObject(ADOBE_COUNTRY_ISO_CODE, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_COUNTRY_ISO_CODE);
          }

        propertyChangeSupport.firePropertyChange("adobeCountryISOCodeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCountryISOCode", oldValue, getAdobeCountryISOCode());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCountryISOCodeAvailable()
      {
        return containsTag(ADOBE_COUNTRY_ISO_CODE);
      }

    public void setAdobeCopyrightStatus (final String adobeCopyrightStatus)
      {
        final String oldValue = getAdobeCopyrightStatus();
        final boolean oldPropAvailable = isAdobeCopyrightStatusAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_COPYRIGHT_STATUS, adobeCopyrightStatus);
        propertyChangeSupport.firePropertyChange("adobeCopyrightStatus", oldValue, adobeCopyrightStatus);
        propertyChangeSupport.firePropertyChange("adobeCopyrightStatusAvailable", oldPropAvailable, isAdobeCopyrightStatusAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCopyrightStatus()
      {
        return getObject(ADOBE_COPYRIGHT_STATUS, String.class);
      }

    public void setAdobeCopyrightStatusAvailable (final boolean available)
      {
        final String oldValue = getAdobeCopyrightStatus();
        final boolean oldPropAvailable = isAdobeCopyrightStatusAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_COPYRIGHT_STATUS))
          {
            setObject(ADOBE_COPYRIGHT_STATUS, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_COPYRIGHT_STATUS);
          }

        propertyChangeSupport.firePropertyChange("adobeCopyrightStatusAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCopyrightStatus", oldValue, getAdobeCopyrightStatus());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCopyrightStatusAvailable()
      {
        return containsTag(ADOBE_COPYRIGHT_STATUS);
      }

    public void setAdobeRightUsageTerms (final String adobeRightUsageTerms)
      {
        final String oldValue = getAdobeRightUsageTerms();
        final boolean oldPropAvailable = isAdobeRightUsageTermsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_RIGHT_USAGE_TERMS, adobeRightUsageTerms);
        propertyChangeSupport.firePropertyChange("adobeRightUsageTerms", oldValue, adobeRightUsageTerms);
        propertyChangeSupport.firePropertyChange("adobeRightUsageTermsAvailable", oldPropAvailable, isAdobeRightUsageTermsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeRightUsageTerms()
      {
        return getObject(ADOBE_RIGHT_USAGE_TERMS, String.class);
      }

    public void setAdobeRightUsageTermsAvailable (final boolean available)
      {
        final String oldValue = getAdobeRightUsageTerms();
        final boolean oldPropAvailable = isAdobeRightUsageTermsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_RIGHT_USAGE_TERMS))
          {
            setObject(ADOBE_RIGHT_USAGE_TERMS, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_RIGHT_USAGE_TERMS);
          }

        propertyChangeSupport.firePropertyChange("adobeRightUsageTermsAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeRightUsageTerms", oldValue, getAdobeRightUsageTerms());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeRightUsageTermsAvailable()
      {
        return containsTag(ADOBE_RIGHT_USAGE_TERMS);
      }

    public void setAdobeCopyrightInfoURL (final String adobeCopyrightInfoURL)
      {
        final String oldValue = getAdobeCopyrightInfoURL();
        final boolean oldPropAvailable = isAdobeCopyrightInfoURLAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ADOBE_COPYRIGHT_INFO_URL, adobeCopyrightInfoURL);
        propertyChangeSupport.firePropertyChange("adobeCopyrightInfoURL", oldValue, adobeCopyrightInfoURL);
        propertyChangeSupport.firePropertyChange("adobeCopyrightInfoURLAvailable", oldPropAvailable, isAdobeCopyrightInfoURLAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getAdobeCopyrightInfoURL()
      {
        return getObject(ADOBE_COPYRIGHT_INFO_URL, String.class);
      }

    public void setAdobeCopyrightInfoURLAvailable (final boolean available)
      {
        final String oldValue = getAdobeCopyrightInfoURL();
        final boolean oldPropAvailable = isAdobeCopyrightInfoURLAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(ADOBE_COPYRIGHT_INFO_URL))
          {
            setObject(ADOBE_COPYRIGHT_INFO_URL, null);
          }
        else if (!available)
          {
            removeTag(ADOBE_COPYRIGHT_INFO_URL);
          }

        propertyChangeSupport.firePropertyChange("adobeCopyrightInfoURLAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("adobeCopyrightInfoURL", oldValue, getAdobeCopyrightInfoURL());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isAdobeCopyrightInfoURLAvailable()
      {
        return containsTag(ADOBE_COPYRIGHT_INFO_URL);
      }

    public boolean isAvailable()
      {
        return isApplicationRecordVersionAvailable()
             | isObjectTypeReferenceAvailable()
             | isObjectAttributeReferenceAvailable()
             | isObjectNameAvailable()
             | isEditStatusAvailable()
             | isEditorialUpdateAvailable()
             | isUrgencyAvailable()
             | isSubjectReferenceAvailable()
             | isCategoryAvailable()
             | isSupplementalCategoriesAvailable()
             | isFixtureIdentifierAvailable()
             | isKeywordsAvailable()
             | isContentLocationCodeAvailable()
             | isContentLocationNameAvailable()
             | isReleaseDateAvailable()
             | isReleaseTimeAvailable()
             | isExpirationDateAvailable()
             | isExpirationTimeAvailable()
             | isSpecialInstructionsAvailable()
             | isActionAdvisedAvailable()
             | isReferenceServiceAvailable()
             | isReferenceDateAvailable()
             | isReferenceNumberAvailable()
             | isDateCreatedAvailable()
             | isTimeCreatedAvailable()
             | isDigitalCreationDateAvailable()
             | isDigitalCreationTimeAvailable()
             | isOriginatingProgramAvailable()
             | isProgramVersionAvailable()
             | isObjectCycleAvailable()
             | isBylineAvailable()
             | isBylineTitleAvailable()
             | isCityAvailable()
             | isSublocationAvailable()
             | isProvinceStateAvailable()
             | isCountryPrimaryLocationCodeAvailable()
             | isCountryPrimaryLocationNameAvailable()
             | isOriginalTransmissionReferenceAvailable()
             | isHeadlineAvailable()
             | isCreditAvailable()
             | isSourceAvailable()
             | isCopyrightNoticeAvailable()
             | isContactAvailable()
             | isCaptionAbstractAvailable()
             | isLocalCaptionAvailable()
             | isWriterEditorAvailable()
             | isRasterizedCaptionAvailable()
             | isImageTypeAvailable()
             | isImageOrientationAvailable()
             | isLanguageIdentifierAvailable()
             | isAudioTypeAvailable()
             | isAudioSamplingRateAvailable()
             | isAudioSamplingResolutionAvailable()
             | isAudioDurationAvailable()
             | isAudioOutcueAvailable()
             | isJobIDAvailable()
             | isMasterDocumentIDAvailable()
             | isShortDocumentIDAvailable()
             | isUniqueDocumentIDAvailable()
             | isOwnerIDAvailable()
             | isObjectPreviewFileFormatAvailable()
             | isObjectPreviewFileVersionAvailable()
             | isObjectPreviewDataAvailable()
             | isPrefsAvailable()
             | isClassifyStateAvailable()
             | isSimilarityIndexAvailable()
             | isDocumentNotesAvailable()
             | isDocumentHistoryAvailable()
             | isEXIFCameraInfoAvailable()
             | isAdobeCreatorAddressAvailable()
             | isAdobeCreatorCityAvailable()
             | isAdobeCreatorStateProvinceAvailable()
             | isAdobeCreatorPostalCodeAvailable()
             | isAdobeCreatorCountryAvailable()
             | isAdobeCreatorPhoneAvailable()
             | isAdobeCreatorEmailAvailable()
             | isAdobeCreatorWebsiteAvailable()
             | isAdobeIPTCSubjectCodeAvailable()
             | isAdobeIntellectualGenreAvailable()
             | isAdobeSceneAvailable()
             | isAdobeLocationAvailable()
             | isAdobeCountryISOCodeAvailable()
             | isAdobeCopyrightStatusAvailable()
             | isAdobeRightUsageTermsAvailable()
             | isAdobeCopyrightInfoURLAvailable()
;
      }
  }
