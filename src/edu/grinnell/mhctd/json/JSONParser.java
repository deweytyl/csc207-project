package edu.grinnell.mhctd.json;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;

/**
 * JSONParser Class
 * 
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
 */

public class JSONParser
{
  // +--------+----------------------------------------------
  // | Fields |
  // +--------+

  /**
   * String to hold JSON.
   */
  String jString;

  /**
   * Hold JSON value.
   */
  JSONValue jValue;

  /**
   * Java object to be returned.
   */
  Object javaObject;

  // +--------------+----------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * JSONParser constructor
   * @param input
   */
  public JSONParser(String input)
  {
    jString = input;
  } // JSONParser (String)

  /**
   * JSONParser constructor
   * @param obj
   */
  public JSONParser(Object obj)
  {
    javaObject = obj;
  } // JSONParser (JSONValue)

  // +------------------+---------------------------------------
  // | Instance Methods |
  // +------------------+

  /**
   * Convert JSON to Java object.
   * @return
   * @throws Exception
   */

  public Object JSONToJavaObject()
    throws Exception
  {
    this.jValue = JSONUtils.parseValue(jString);
    char type = jValue.type();
    switch (type)
      {
        case 'n':
          return JSONUtils.getNumber(jValue);
        case 's':
          return JSONUtils.getString(jValue);
        case 'c':
          {
            String str = JSONUtils.getString(jValue);
            // Handle symbolic constants
            if (str.equals("true"))
              return true;
            else if (str.equals("false"))
              return false;
            else
              return null;
          } // case 'c'
        case 'a':
          return JSONUtils.getArray(jValue);
        case 'o':
          return JSONUtils.getObject(jValue);
      } // switch

    throw new Exception("Unsupported String" + jString);

  } // JSONToJavaObject()

  /**
   * Take Java object and convert to JSON string.
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public String JavaObjectToStringOfJSON()
    throws Exception
  {
    // If the Object is a number
    if (javaObject instanceof BigDecimal)
      {
        jString = javaObject.toString();
      } // if

    // If the Object is a String
    else if (javaObject instanceof java.lang.String)
      {
        jString = "\"" + javaObject.toString() + "\"";
      } // else if

    // If the Object is a symbolic constant
    else if (javaObject instanceof Boolean || javaObject == null)
      {
        jString = javaObject.toString();
      } // else if

    // If the Object is a Pair (key-value pair)
    else if (javaObject instanceof Map.Entry)
      {
        JSONParser parser =
            new JSONParser(((Map.Entry<String, Object>) javaObject).getValue());
        jString =
            "\"" + ((Map.Entry<String, Object>) javaObject).getKey().toString()
                + "\" : " + parser.JavaObjectToStringOfJSON();
      } // else if

    // If the Object is an Array
    else if (javaObject instanceof Array)
      {
        jString = "";
        Object instance;
        int i = 0;
        while ((instance = Array.get(javaObject, i)) != null)
          {
            JSONParser parser = new JSONParser(instance);
            jString += parser.JavaObjectToStringOfJSON();
            i++;
          } // while
      } // else if

    // If the Object is any other type
    else
      {
        jString = "{";
        int i = 0;
        Field[] fields = javaObject.getClass().getFields();
        Field field;
        while ((field = fields[i]) != null)
          {
            JSONParser parser = new JSONParser(field.get(javaObject));
            if (i != 0)
              {
                jString += ", ";
              } // if
            jString +=
                "\"" + field.getName() + "\" : "
                    + parser.JavaObjectToStringOfJSON();
            i++;
          } // while
        jString += "}";
      } // else

    // If the Object is a number
    if (this.javaObject instanceof BigDecimal)
      {
        jString = ((BigDecimal) this.javaObject).toString();
      } // if

    // If the Object is a String
    else if (this.javaObject instanceof String)
      {
        // TODO SubMethod Stub
      } // else if

    // If the Object is a symbolic constant
    else if (javaObject instanceof Boolean || javaObject == null)
      {
        jString = javaObject.toString();
      } // else if

    // If the Object is a Pair (key-value pair)
    else if (javaObject instanceof Map.Entry)
      {
        JSONParser parser =
            new JSONParser(((Map.Entry<String, Object>) javaObject).getValue());
        jString =
            "\"" + ((Map.Entry<String, Object>) javaObject).getKey().toString()
                + "\" : " + parser.JavaObjectToStringOfJSON();
      } // else if

    // If the Object is an Array
    else if (javaObject instanceof Array)
      {
        jString = "";
        Object instance;
        int i = 0;
        while ((instance = Array.get(javaObject, i)) != null)
          {
            JSONParser parser = new JSONParser(instance);
            jString += parser.JavaObjectToStringOfJSON();
            i++;
          } // while
      } // else if

    // If the Object is any other type
    else
      {
        jString = "{";
        int i = 0;
        Field[] fields = javaObject.getClass().getFields();
        Field field;
        while ((field = fields[i]) != null)
          {
            JSONParser parser = new JSONParser(field.get(javaObject));
            if (i != 0)
              {
                jString += ", ";
              } // if
            jString +=
                "\"" + field.getName() + "\" : "
                    + parser.JavaObjectToStringOfJSON();
            i++;
          } // while
        jString += "}";
      } // else

    return jString;
  } // JavaObjectToStringOfJSON()

} // class JSONParser
