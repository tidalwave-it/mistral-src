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

    public final static int RECORD_VERSION = 512;
    public final static int OBJECT_TYPE_REFERENCE = 515;
    public final static int OBJECT_ATTRIBUTE_REFERENCE = 516;
    public final static int OBJECT_NAME = 517;
    public final static int EDIT_STATUS = 519;
    public final static int EDITORIAL_UPDATE = 520;
    public final static int URGENCY = 522;
    public final static int SUBJECT_REFERENCE = 524;
    public final static int CATEGORY = 527;
    public final static int SUPPLEMENTAL_CATEGORIES = 532;
    public final static int FIXTURE_IDENTIFIER = 534;
    public final static int KEYWORDS = 537;
    public final static int CONTENT_LOCATION_CODE = 538;
    public final static int CONTENT_LOCATION_NAME = 539;
    public final static int RELEASE_DATE = 542;
    public final static int RELEASE_TIME = 547;
    public final static int EXPIRATION_DATE = 549;
    public final static int EXPIRATION_TIME = 550;
    public final static int SPECIAL_INSTRUCTIONS = 552;
    public final static int ACTION_ADVISED = 554;
    public final static int REFERENCE_SERVICE = 557;
    public final static int REFERENCE_DATE = 559;
    public final static int REFERENCE_NUMBER = 562;
    public final static int DATE_CREATED = 567;
    public final static int TIME_CREATED = 572;
    public final static int DIGITAL_CREATION_DATE = 574;
    public final static int DIGITAL_CREATION_TIME = 575;
    public final static int ORIGINATING_PROGRAM = 577;
    public final static int OBJECT_CYCLE = 587;
    public final static int PROGRAM_VERSION = 582;
    public final static int BY_LINE = 592;
    public final static int BY_LINE_TITLE = 597;
    public final static int CITY = 602;
    public final static int SUB_LOCATION = 604;
    public final static int PROVINCE_OR_STATE = 607;
    public final static int COUNTRY_CODE = 612;
    public final static int COUNTRY_OR_PRIMARY_LOCATION = 613;
    public final static int ORIGINAL_TRANSMISSION_REFERENCE = 615;
    public final static int HEADLINE = 617;
    public final static int CREDIT = 622;
    public final static int SOURCE = 627;
    public final static int COPYRIGHT_NOTICE = 628;
    public final static int CONTACT = 630;
    public final static int CAPTION = 632;
    public final static int WRITER = 634;
    public final static int RASTERIZED_CAPTION = 637;
    public final static int IMAGE_TYPE = 642;
    public final static int IMAGE_ORIENTATION = 643;
    public final static int LANGUAGE_IDENTIFIER = 647;
    public final static int AUDIO_TYPE = 662;
    public final static int AUDIO_SAMPLING_RATE = 663;
    public final static int AUDIO_SAMPLING_RESOLUTION = 664;
    public final static int AUDIO_DURATION = 665;
    public final static int AUDIO_OUTCUE = 666;
    public final static int OBJECTDATA_PREVIEW_FILE_FORMAT = 712;
    public final static int OBJECTDATA_PREVIEW_FILE_FORMAT_VERSION = 713;
    public final static int OBJECTDATA_PREVIEW_PREVIEW_DATA = 714;

    @Override
    public String getTagName (int tag)
      {
        return (String)descriptionMapByTag.get(tag);
      }
    static
      {
        descriptionMapByTag.put(512, "Record Version");
        descriptionMapByTag.put(515, "Object Type Reference");
        descriptionMapByTag.put(516, "Object Attribute Reference");
        descriptionMapByTag.put(517, "Object Name");
        descriptionMapByTag.put(519, "Edit Status");
        descriptionMapByTag.put(520, "Editorial Update");
        descriptionMapByTag.put(522, "Urgency");
        descriptionMapByTag.put(524, "Subject Reference");
        descriptionMapByTag.put(527, "Category");
        descriptionMapByTag.put(532, "Supplemental Categories");
        descriptionMapByTag.put(534, "Fixture Identifier");
        descriptionMapByTag.put(537, "Keywords");
        descriptionMapByTag.put(538, "Content Location Code");
        descriptionMapByTag.put(539, "Content Location Name");
        descriptionMapByTag.put(542, "Release Date");
        descriptionMapByTag.put(547, "Release Time");
        descriptionMapByTag.put(549, "Expiration Date");
        descriptionMapByTag.put(550, "Expiration Time");
        descriptionMapByTag.put(552, "Special Instructions");
        descriptionMapByTag.put(554, "Action Advised");
        descriptionMapByTag.put(557, "Reference Service");
        descriptionMapByTag.put(559, "Reference Date");
        descriptionMapByTag.put(562, "Reference Number");
        descriptionMapByTag.put(567, "Date Created");
        descriptionMapByTag.put(572, "Time Created");
        descriptionMapByTag.put(574, "Digital Creation Date");
        descriptionMapByTag.put(575, "Digital Creation Time");
        descriptionMapByTag.put(577, "Originating Program");
        descriptionMapByTag.put(587, "Object Cycle");
        descriptionMapByTag.put(582, "Program Version");
        descriptionMapByTag.put(592, "By Line");
        descriptionMapByTag.put(597, "By Line Title");
        descriptionMapByTag.put(602, "City");
        descriptionMapByTag.put(604, "Sub Location");
        descriptionMapByTag.put(607, "Province Or State");
        descriptionMapByTag.put(612, "Country Code");
        descriptionMapByTag.put(613, "Country Or Primary Location");
        descriptionMapByTag.put(615, "Original Transmission Reference");
        descriptionMapByTag.put(617, "Headline");
        descriptionMapByTag.put(622, "Credit");
        descriptionMapByTag.put(627, "Source");
        descriptionMapByTag.put(628, "Copyright Notice");
        descriptionMapByTag.put(630, "Contact");
        descriptionMapByTag.put(632, "Caption");
        descriptionMapByTag.put(634, "Writer");
        descriptionMapByTag.put(637, "Rasterized Caption");
        descriptionMapByTag.put(642, "Image Type");
        descriptionMapByTag.put(643, "Image Orientation");
        descriptionMapByTag.put(647, "Language Identifier");
        descriptionMapByTag.put(662, "Audio Type");
        descriptionMapByTag.put(663, "Audio Sampling Rate");
        descriptionMapByTag.put(664, "Audio Sampling Resolution");
        descriptionMapByTag.put(665, "Audio Duration");
        descriptionMapByTag.put(666, "Audio Outcue");
        descriptionMapByTag.put(712, "ObjectData Preview File Format");
        descriptionMapByTag.put(713, "ObjectData Preview File Format Version");
        descriptionMapByTag.put(714, "ObjectData Preview Preview Data");

      }
    public void setRecordVersion (final Integer recordVersion)
      {
        final Integer oldValue = getRecordVersion();
        final boolean oldPropAvailable = isRecordVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.RECORD_VERSION, recordVersion);
        propertyChangeSupport.firePropertyChange("recordVersion", oldValue, recordVersion);
        propertyChangeSupport.firePropertyChange("recordVersionAvailable", oldPropAvailable, isRecordVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getRecordVersion()
      {
        return getObject(RECORD_VERSION, Integer.class);
      }

    public void setRecordVersionAvailable (final boolean available)
      {
        final Integer oldValue = getRecordVersion();
        final boolean oldPropAvailable = isRecordVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(RECORD_VERSION))
          {
            setObject(RECORD_VERSION, null);
          }
        else if (!available)
          {
            removeTag(RECORD_VERSION);
          }

        propertyChangeSupport.firePropertyChange("recordVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("recordVersion", oldValue, getRecordVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isRecordVersionAvailable()
      {
        return containsTag(RECORD_VERSION);
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

    public void setUrgency (final Integer urgency)
      {
        final Integer oldValue = getUrgency();
        final boolean oldPropAvailable = isUrgencyAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.URGENCY, urgency);
        propertyChangeSupport.firePropertyChange("urgency", oldValue, urgency);
        propertyChangeSupport.firePropertyChange("urgencyAvailable", oldPropAvailable, isUrgencyAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public Integer getUrgency()
      {
        return getObject(URGENCY, Integer.class);
      }

    public void setUrgencyAvailable (final boolean available)
      {
        final Integer oldValue = getUrgency();
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

    public void setKeywords (final String[] keywords)
      {
        final String[] oldValue = getKeywords();
        final boolean oldPropAvailable = isKeywordsAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.KEYWORDS, keywords);
        propertyChangeSupport.firePropertyChange("keywords", oldValue, keywords);
        propertyChangeSupport.firePropertyChange("keywordsAvailable", oldPropAvailable, isKeywordsAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String[] getKeywords()
      {
        return getObject(KEYWORDS, String[].class);
      }

    public void setKeywordsAvailable (final boolean available)
      {
        final String[] oldValue = getKeywords();
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

    public void setReleaseDate (final java.util.Date releaseDate)
      {
        final java.util.Date oldValue = getReleaseDate();
        final boolean oldPropAvailable = isReleaseDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.RELEASE_DATE, releaseDate);
        propertyChangeSupport.firePropertyChange("releaseDate", oldValue, releaseDate);
        propertyChangeSupport.firePropertyChange("releaseDateAvailable", oldPropAvailable, isReleaseDateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public java.util.Date getReleaseDate()
      {
        return getObject(RELEASE_DATE, java.util.Date.class);
      }

    public void setReleaseDateAvailable (final boolean available)
      {
        final java.util.Date oldValue = getReleaseDate();
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

    public void setReleaseTime (final java.util.Date releaseTime)
      {
        final java.util.Date oldValue = getReleaseTime();
        final boolean oldPropAvailable = isReleaseTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.RELEASE_TIME, releaseTime);
        propertyChangeSupport.firePropertyChange("releaseTime", oldValue, releaseTime);
        propertyChangeSupport.firePropertyChange("releaseTimeAvailable", oldPropAvailable, isReleaseTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public java.util.Date getReleaseTime()
      {
        return getObject(RELEASE_TIME, java.util.Date.class);
      }

    public void setReleaseTimeAvailable (final boolean available)
      {
        final java.util.Date oldValue = getReleaseTime();
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

    public void setExpirationDate (final java.util.Date expirationDate)
      {
        final java.util.Date oldValue = getExpirationDate();
        final boolean oldPropAvailable = isExpirationDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.EXPIRATION_DATE, expirationDate);
        propertyChangeSupport.firePropertyChange("expirationDate", oldValue, expirationDate);
        propertyChangeSupport.firePropertyChange("expirationDateAvailable", oldPropAvailable, isExpirationDateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public java.util.Date getExpirationDate()
      {
        return getObject(EXPIRATION_DATE, java.util.Date.class);
      }

    public void setExpirationDateAvailable (final boolean available)
      {
        final java.util.Date oldValue = getExpirationDate();
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

    public void setExpirationTime (final java.util.Date expirationTime)
      {
        final java.util.Date oldValue = getExpirationTime();
        final boolean oldPropAvailable = isExpirationTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.EXPIRATION_TIME, expirationTime);
        propertyChangeSupport.firePropertyChange("expirationTime", oldValue, expirationTime);
        propertyChangeSupport.firePropertyChange("expirationTimeAvailable", oldPropAvailable, isExpirationTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public java.util.Date getExpirationTime()
      {
        return getObject(EXPIRATION_TIME, java.util.Date.class);
      }

    public void setExpirationTimeAvailable (final boolean available)
      {
        final java.util.Date oldValue = getExpirationTime();
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

    public void setActionAdvised (final String actionAdvised)
      {
        final String oldValue = getActionAdvised();
        final boolean oldPropAvailable = isActionAdvisedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.ACTION_ADVISED, actionAdvised);
        propertyChangeSupport.firePropertyChange("actionAdvised", oldValue, actionAdvised);
        propertyChangeSupport.firePropertyChange("actionAdvisedAvailable", oldPropAvailable, isActionAdvisedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getActionAdvised()
      {
        return getObject(ACTION_ADVISED, String.class);
      }

    public void setActionAdvisedAvailable (final boolean available)
      {
        final String oldValue = getActionAdvised();
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

    public void setReferenceDate (final java.util.Date referenceDate)
      {
        final java.util.Date oldValue = getReferenceDate();
        final boolean oldPropAvailable = isReferenceDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.REFERENCE_DATE, referenceDate);
        propertyChangeSupport.firePropertyChange("referenceDate", oldValue, referenceDate);
        propertyChangeSupport.firePropertyChange("referenceDateAvailable", oldPropAvailable, isReferenceDateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public java.util.Date getReferenceDate()
      {
        return getObject(REFERENCE_DATE, java.util.Date.class);
      }

    public void setReferenceDateAvailable (final boolean available)
      {
        final java.util.Date oldValue = getReferenceDate();
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

    public void setDateCreated (final java.util.Date dateCreated)
      {
        final java.util.Date oldValue = getDateCreated();
        final boolean oldPropAvailable = isDateCreatedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.DATE_CREATED, dateCreated);
        propertyChangeSupport.firePropertyChange("dateCreated", oldValue, dateCreated);
        propertyChangeSupport.firePropertyChange("dateCreatedAvailable", oldPropAvailable, isDateCreatedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public java.util.Date getDateCreated()
      {
        return getObject(DATE_CREATED, java.util.Date.class);
      }

    public void setDateCreatedAvailable (final boolean available)
      {
        final java.util.Date oldValue = getDateCreated();
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

    public void setTimeCreated (final java.util.Date timeCreated)
      {
        final java.util.Date oldValue = getTimeCreated();
        final boolean oldPropAvailable = isTimeCreatedAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.TIME_CREATED, timeCreated);
        propertyChangeSupport.firePropertyChange("timeCreated", oldValue, timeCreated);
        propertyChangeSupport.firePropertyChange("timeCreatedAvailable", oldPropAvailable, isTimeCreatedAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public java.util.Date getTimeCreated()
      {
        return getObject(TIME_CREATED, java.util.Date.class);
      }

    public void setTimeCreatedAvailable (final boolean available)
      {
        final java.util.Date oldValue = getTimeCreated();
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

    public void setDigitalCreationDate (final java.util.Date digitalCreationDate)
      {
        final java.util.Date oldValue = getDigitalCreationDate();
        final boolean oldPropAvailable = isDigitalCreationDateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.DIGITAL_CREATION_DATE, digitalCreationDate);
        propertyChangeSupport.firePropertyChange("digitalCreationDate", oldValue, digitalCreationDate);
        propertyChangeSupport.firePropertyChange("digitalCreationDateAvailable", oldPropAvailable, isDigitalCreationDateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public java.util.Date getDigitalCreationDate()
      {
        return getObject(DIGITAL_CREATION_DATE, java.util.Date.class);
      }

    public void setDigitalCreationDateAvailable (final boolean available)
      {
        final java.util.Date oldValue = getDigitalCreationDate();
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

    public void setDigitalCreationTime (final java.util.Date digitalCreationTime)
      {
        final java.util.Date oldValue = getDigitalCreationTime();
        final boolean oldPropAvailable = isDigitalCreationTimeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.DIGITAL_CREATION_TIME, digitalCreationTime);
        propertyChangeSupport.firePropertyChange("digitalCreationTime", oldValue, digitalCreationTime);
        propertyChangeSupport.firePropertyChange("digitalCreationTimeAvailable", oldPropAvailable, isDigitalCreationTimeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public java.util.Date getDigitalCreationTime()
      {
        return getObject(DIGITAL_CREATION_TIME, java.util.Date.class);
      }

    public void setDigitalCreationTimeAvailable (final boolean available)
      {
        final java.util.Date oldValue = getDigitalCreationTime();
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

    public void setByLine (final String byLine)
      {
        final String oldValue = getByLine();
        final boolean oldPropAvailable = isByLineAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.BY_LINE, byLine);
        propertyChangeSupport.firePropertyChange("byLine", oldValue, byLine);
        propertyChangeSupport.firePropertyChange("byLineAvailable", oldPropAvailable, isByLineAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getByLine()
      {
        return getObject(BY_LINE, String.class);
      }

    public void setByLineAvailable (final boolean available)
      {
        final String oldValue = getByLine();
        final boolean oldPropAvailable = isByLineAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BY_LINE))
          {
            setObject(BY_LINE, null);
          }
        else if (!available)
          {
            removeTag(BY_LINE);
          }

        propertyChangeSupport.firePropertyChange("byLineAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("byLine", oldValue, getByLine());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isByLineAvailable()
      {
        return containsTag(BY_LINE);
      }

    public void setByLineTitle (final String byLineTitle)
      {
        final String oldValue = getByLineTitle();
        final boolean oldPropAvailable = isByLineTitleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.BY_LINE_TITLE, byLineTitle);
        propertyChangeSupport.firePropertyChange("byLineTitle", oldValue, byLineTitle);
        propertyChangeSupport.firePropertyChange("byLineTitleAvailable", oldPropAvailable, isByLineTitleAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getByLineTitle()
      {
        return getObject(BY_LINE_TITLE, String.class);
      }

    public void setByLineTitleAvailable (final boolean available)
      {
        final String oldValue = getByLineTitle();
        final boolean oldPropAvailable = isByLineTitleAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(BY_LINE_TITLE))
          {
            setObject(BY_LINE_TITLE, null);
          }
        else if (!available)
          {
            removeTag(BY_LINE_TITLE);
          }

        propertyChangeSupport.firePropertyChange("byLineTitleAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("byLineTitle", oldValue, getByLineTitle());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isByLineTitleAvailable()
      {
        return containsTag(BY_LINE_TITLE);
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

    public void setSubLocation (final String subLocation)
      {
        final String oldValue = getSubLocation();
        final boolean oldPropAvailable = isSubLocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.SUB_LOCATION, subLocation);
        propertyChangeSupport.firePropertyChange("subLocation", oldValue, subLocation);
        propertyChangeSupport.firePropertyChange("subLocationAvailable", oldPropAvailable, isSubLocationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getSubLocation()
      {
        return getObject(SUB_LOCATION, String.class);
      }

    public void setSubLocationAvailable (final boolean available)
      {
        final String oldValue = getSubLocation();
        final boolean oldPropAvailable = isSubLocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(SUB_LOCATION))
          {
            setObject(SUB_LOCATION, null);
          }
        else if (!available)
          {
            removeTag(SUB_LOCATION);
          }

        propertyChangeSupport.firePropertyChange("subLocationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("subLocation", oldValue, getSubLocation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isSubLocationAvailable()
      {
        return containsTag(SUB_LOCATION);
      }

    public void setProvinceOrState (final String provinceOrState)
      {
        final String oldValue = getProvinceOrState();
        final boolean oldPropAvailable = isProvinceOrStateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.PROVINCE_OR_STATE, provinceOrState);
        propertyChangeSupport.firePropertyChange("provinceOrState", oldValue, provinceOrState);
        propertyChangeSupport.firePropertyChange("provinceOrStateAvailable", oldPropAvailable, isProvinceOrStateAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getProvinceOrState()
      {
        return getObject(PROVINCE_OR_STATE, String.class);
      }

    public void setProvinceOrStateAvailable (final boolean available)
      {
        final String oldValue = getProvinceOrState();
        final boolean oldPropAvailable = isProvinceOrStateAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(PROVINCE_OR_STATE))
          {
            setObject(PROVINCE_OR_STATE, null);
          }
        else if (!available)
          {
            removeTag(PROVINCE_OR_STATE);
          }

        propertyChangeSupport.firePropertyChange("provinceOrStateAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("provinceOrState", oldValue, getProvinceOrState());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isProvinceOrStateAvailable()
      {
        return containsTag(PROVINCE_OR_STATE);
      }

    public void setCountryCode (final String countryCode)
      {
        final String oldValue = getCountryCode();
        final boolean oldPropAvailable = isCountryCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.COUNTRY_CODE, countryCode);
        propertyChangeSupport.firePropertyChange("countryCode", oldValue, countryCode);
        propertyChangeSupport.firePropertyChange("countryCodeAvailable", oldPropAvailable, isCountryCodeAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCountryCode()
      {
        return getObject(COUNTRY_CODE, String.class);
      }

    public void setCountryCodeAvailable (final boolean available)
      {
        final String oldValue = getCountryCode();
        final boolean oldPropAvailable = isCountryCodeAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COUNTRY_CODE))
          {
            setObject(COUNTRY_CODE, null);
          }
        else if (!available)
          {
            removeTag(COUNTRY_CODE);
          }

        propertyChangeSupport.firePropertyChange("countryCodeAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("countryCode", oldValue, getCountryCode());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCountryCodeAvailable()
      {
        return containsTag(COUNTRY_CODE);
      }

    public void setCountryOrPrimaryLocation (final String countryOrPrimaryLocation)
      {
        final String oldValue = getCountryOrPrimaryLocation();
        final boolean oldPropAvailable = isCountryOrPrimaryLocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.COUNTRY_OR_PRIMARY_LOCATION, countryOrPrimaryLocation);
        propertyChangeSupport.firePropertyChange("countryOrPrimaryLocation", oldValue, countryOrPrimaryLocation);
        propertyChangeSupport.firePropertyChange("countryOrPrimaryLocationAvailable", oldPropAvailable, isCountryOrPrimaryLocationAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCountryOrPrimaryLocation()
      {
        return getObject(COUNTRY_OR_PRIMARY_LOCATION, String.class);
      }

    public void setCountryOrPrimaryLocationAvailable (final boolean available)
      {
        final String oldValue = getCountryOrPrimaryLocation();
        final boolean oldPropAvailable = isCountryOrPrimaryLocationAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(COUNTRY_OR_PRIMARY_LOCATION))
          {
            setObject(COUNTRY_OR_PRIMARY_LOCATION, null);
          }
        else if (!available)
          {
            removeTag(COUNTRY_OR_PRIMARY_LOCATION);
          }

        propertyChangeSupport.firePropertyChange("countryOrPrimaryLocationAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("countryOrPrimaryLocation", oldValue, getCountryOrPrimaryLocation());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCountryOrPrimaryLocationAvailable()
      {
        return containsTag(COUNTRY_OR_PRIMARY_LOCATION);
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

    public void setCaption (final String caption)
      {
        final String oldValue = getCaption();
        final boolean oldPropAvailable = isCaptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.CAPTION, caption);
        propertyChangeSupport.firePropertyChange("caption", oldValue, caption);
        propertyChangeSupport.firePropertyChange("captionAvailable", oldPropAvailable, isCaptionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getCaption()
      {
        return getObject(CAPTION, String.class);
      }

    public void setCaptionAvailable (final boolean available)
      {
        final String oldValue = getCaption();
        final boolean oldPropAvailable = isCaptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(CAPTION))
          {
            setObject(CAPTION, null);
          }
        else if (!available)
          {
            removeTag(CAPTION);
          }

        propertyChangeSupport.firePropertyChange("captionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("caption", oldValue, getCaption());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isCaptionAvailable()
      {
        return containsTag(CAPTION);
      }

    public void setWriter (final String writer)
      {
        final String oldValue = getWriter();
        final boolean oldPropAvailable = isWriterAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.WRITER, writer);
        propertyChangeSupport.firePropertyChange("writer", oldValue, writer);
        propertyChangeSupport.firePropertyChange("writerAvailable", oldPropAvailable, isWriterAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getWriter()
      {
        return getObject(WRITER, String.class);
      }

    public void setWriterAvailable (final boolean available)
      {
        final String oldValue = getWriter();
        final boolean oldPropAvailable = isWriterAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(WRITER))
          {
            setObject(WRITER, null);
          }
        else if (!available)
          {
            removeTag(WRITER);
          }

        propertyChangeSupport.firePropertyChange("writerAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("writer", oldValue, getWriter());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isWriterAvailable()
      {
        return containsTag(WRITER);
      }

    public void setRasterizedCaption (final byte[] rasterizedCaption)
      {
        final byte[] oldValue = getRasterizedCaption();
        final boolean oldPropAvailable = isRasterizedCaptionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.RASTERIZED_CAPTION, rasterizedCaption);
        propertyChangeSupport.firePropertyChange("rasterizedCaption", oldValue, rasterizedCaption);
        propertyChangeSupport.firePropertyChange("rasterizedCaptionAvailable", oldPropAvailable, isRasterizedCaptionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getRasterizedCaption()
      {
        return getObject(RASTERIZED_CAPTION, byte[].class);
      }

    public void setRasterizedCaptionAvailable (final boolean available)
      {
        final byte[] oldValue = getRasterizedCaption();
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

    public void setObjectDataPreviewFileFormat (final String objectDataPreviewFileFormat)
      {
        final String oldValue = getObjectDataPreviewFileFormat();
        final boolean oldPropAvailable = isObjectDataPreviewFileFormatAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECTDATA_PREVIEW_FILE_FORMAT, objectDataPreviewFileFormat);
        propertyChangeSupport.firePropertyChange("objectDataPreviewFileFormat", oldValue, objectDataPreviewFileFormat);
        propertyChangeSupport.firePropertyChange("objectDataPreviewFileFormatAvailable", oldPropAvailable, isObjectDataPreviewFileFormatAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getObjectDataPreviewFileFormat()
      {
        return getObject(OBJECTDATA_PREVIEW_FILE_FORMAT, String.class);
      }

    public void setObjectDataPreviewFileFormatAvailable (final boolean available)
      {
        final String oldValue = getObjectDataPreviewFileFormat();
        final boolean oldPropAvailable = isObjectDataPreviewFileFormatAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECTDATA_PREVIEW_FILE_FORMAT))
          {
            setObject(OBJECTDATA_PREVIEW_FILE_FORMAT, null);
          }
        else if (!available)
          {
            removeTag(OBJECTDATA_PREVIEW_FILE_FORMAT);
          }

        propertyChangeSupport.firePropertyChange("objectDataPreviewFileFormatAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectDataPreviewFileFormat", oldValue, getObjectDataPreviewFileFormat());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectDataPreviewFileFormatAvailable()
      {
        return containsTag(OBJECTDATA_PREVIEW_FILE_FORMAT);
      }

    public void setObjectDataPreviewFileFormatVersion (final String objectDataPreviewFileFormatVersion)
      {
        final String oldValue = getObjectDataPreviewFileFormatVersion();
        final boolean oldPropAvailable = isObjectDataPreviewFileFormatVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECTDATA_PREVIEW_FILE_FORMAT_VERSION, objectDataPreviewFileFormatVersion);
        propertyChangeSupport.firePropertyChange("objectDataPreviewFileFormatVersion", oldValue, objectDataPreviewFileFormatVersion);
        propertyChangeSupport.firePropertyChange("objectDataPreviewFileFormatVersionAvailable", oldPropAvailable, isObjectDataPreviewFileFormatVersionAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public String getObjectDataPreviewFileFormatVersion()
      {
        return getObject(OBJECTDATA_PREVIEW_FILE_FORMAT_VERSION, String.class);
      }

    public void setObjectDataPreviewFileFormatVersionAvailable (final boolean available)
      {
        final String oldValue = getObjectDataPreviewFileFormatVersion();
        final boolean oldPropAvailable = isObjectDataPreviewFileFormatVersionAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECTDATA_PREVIEW_FILE_FORMAT_VERSION))
          {
            setObject(OBJECTDATA_PREVIEW_FILE_FORMAT_VERSION, null);
          }
        else if (!available)
          {
            removeTag(OBJECTDATA_PREVIEW_FILE_FORMAT_VERSION);
          }

        propertyChangeSupport.firePropertyChange("objectDataPreviewFileFormatVersionAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectDataPreviewFileFormatVersion", oldValue, getObjectDataPreviewFileFormatVersion());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectDataPreviewFileFormatVersionAvailable()
      {
        return containsTag(OBJECTDATA_PREVIEW_FILE_FORMAT_VERSION);
      }

    public void setObjectDataPreviewPreviewData (final byte[] objectDataPreviewPreviewData)
      {
        final byte[] oldValue = getObjectDataPreviewPreviewData();
        final boolean oldPropAvailable = isObjectDataPreviewPreviewDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();
        setObject(IPTCDirectoryGenerated.OBJECTDATA_PREVIEW_PREVIEW_DATA, objectDataPreviewPreviewData);
        propertyChangeSupport.firePropertyChange("objectDataPreviewPreviewData", oldValue, objectDataPreviewPreviewData);
        propertyChangeSupport.firePropertyChange("objectDataPreviewPreviewDataAvailable", oldPropAvailable, isObjectDataPreviewPreviewDataAvailable());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public byte[] getObjectDataPreviewPreviewData()
      {
        return getObject(OBJECTDATA_PREVIEW_PREVIEW_DATA, byte[].class);
      }

    public void setObjectDataPreviewPreviewDataAvailable (final boolean available)
      {
        final byte[] oldValue = getObjectDataPreviewPreviewData();
        final boolean oldPropAvailable = isObjectDataPreviewPreviewDataAvailable();
        final boolean oldAvailable = isAvailable();
        final Date oldLatestModificationTime = getLatestModificationTime();

        if (available && !containsTag(OBJECTDATA_PREVIEW_PREVIEW_DATA))
          {
            setObject(OBJECTDATA_PREVIEW_PREVIEW_DATA, null);
          }
        else if (!available)
          {
            removeTag(OBJECTDATA_PREVIEW_PREVIEW_DATA);
          }

        propertyChangeSupport.firePropertyChange("objectDataPreviewPreviewDataAvailable", oldPropAvailable, available);
        propertyChangeSupport.firePropertyChange("objectDataPreviewPreviewData", oldValue, getObjectDataPreviewPreviewData());
        propertyChangeSupport.firePropertyChange("available", oldAvailable, isAvailable());
        propertyChangeSupport.firePropertyChange("latestModificationTime", oldLatestModificationTime, getLatestModificationTime());
      }

    public boolean isObjectDataPreviewPreviewDataAvailable()
      {
        return containsTag(OBJECTDATA_PREVIEW_PREVIEW_DATA);
      }

    public boolean isAvailable()
      {
        return isRecordVersionAvailable()
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
             | isObjectCycleAvailable()
             | isProgramVersionAvailable()
             | isByLineAvailable()
             | isByLineTitleAvailable()
             | isCityAvailable()
             | isSubLocationAvailable()
             | isProvinceOrStateAvailable()
             | isCountryCodeAvailable()
             | isCountryOrPrimaryLocationAvailable()
             | isOriginalTransmissionReferenceAvailable()
             | isHeadlineAvailable()
             | isCreditAvailable()
             | isSourceAvailable()
             | isCopyrightNoticeAvailable()
             | isContactAvailable()
             | isCaptionAvailable()
             | isWriterAvailable()
             | isRasterizedCaptionAvailable()
             | isImageTypeAvailable()
             | isImageOrientationAvailable()
             | isLanguageIdentifierAvailable()
             | isAudioTypeAvailable()
             | isAudioSamplingRateAvailable()
             | isAudioSamplingResolutionAvailable()
             | isAudioDurationAvailable()
             | isAudioOutcueAvailable()
             | isObjectDataPreviewFileFormatAvailable()
             | isObjectDataPreviewFileFormatVersionAvailable()
             | isObjectDataPreviewPreviewDataAvailable()
;
      }
  }
