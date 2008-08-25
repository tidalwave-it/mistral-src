package it.tidalwave.image.tools;

public class TIFFEnumValueName 
  {
    private String value;
    private String name;

    public TIFFEnumValueName (final String value, String name) 
      {
        this.value = value;
        this.name = name;
      }

    public String getValue() 
      {
        return value;
      }

    public String getName() 
      {
        return name;
      }

    public String getIdentifierName() 
      {
        if (name != null)
          {
            return name.replace(' ', '_').replace('-', '_').toUpperCase();
          }
        
        return "";
      }

    @Override
    public String toString() 
      {
        return value + "=" + name;
      }
  }
