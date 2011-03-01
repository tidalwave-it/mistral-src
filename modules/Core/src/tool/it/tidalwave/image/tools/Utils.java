package it.tidalwave.image.tools;

public class Utils 
  {
    public static String capitalized (final String tagName) 
      {
        return tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
      }

    public static String uncapitalized (final String tagName) 
      {
        if ((tagName.length() > 1) && Character.isUpperCase(tagName.charAt(1))) // acronyms
          {
            return tagName;
          }
        
        return tagName.substring(0, 1).toLowerCase() + tagName.substring(1);
      }

    public static String strip (final String s) 
      {
        final StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) 
          {
            char c = s.charAt(i);

            if (Character.isJavaIdentifierPart(c)) 
              {
                result.append(c);
              }
          }

        return result.toString();
      }
  }
