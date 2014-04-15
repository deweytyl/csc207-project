package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

/**
 * Do whatever you want with either of these classes.
 * 
 * Maybe we could make a JSONValueParser object. Up to us. We should talk about
 * it later, but for now let's just write static methods.
 * 
 * Character type keys: 
 *      String: 's' 
 *      Number: 'n' 
 *      Object: 'o' 
 *      Array: 'a' 
 *      Constant: 'c'
 * 
 * JSONValue interface might be useful
 */
public class JSONUtils
{

  public static JSONValue parseValue(String valStr)
  {
    // TODO Method Stub
    return null;
  } // parseValue(String)

  public static JSONPair parsePair(String pairStr)
  {
    String[] strs = pairStr.split(":");
    return new JSONPair(strs[0], parseValue(strs[1]));
  } // parsePair(String pairStr)

  public static ArrayList<Object> parseArray(String arrStr)
  {
    ArrayList<Object> array = new ArrayList<Object>();
    String[] strs = (arrStr.substring(1, arrStr.length() - 1)).split(",");
    for (String str : strs)
      {
        array.add(parseValue(str));
      } // for

    return array;
  } // parseArray(String)

  public static Map<String, JSONValue> getObject(JSONValue value)
    throws UnsupportedOperationException
  {
    // TODO Method Stub
    return null;
  }
  
  public static JSONValue[] getArray(JSONValue value)
      throws UnsupportedOperationException
    {
      // TODO Method Stub
      return null;
    }
  
  public static BigDecimal getNumber(JSONValue value)
      throws UnsupportedOperationException
    {
      // TODO Method Stub
      return null;
    }
  
  public static String getString(JSONValue value)
      throws UnsupportedOperationException
    {
      // TODO Method Stub
      return null;
    }
  
  static class JSONPair
  {
    /**
     * A String representing the key of this key-value pair
     */
    String key;

    /**
     * The value of this key-value pair
     */
    JSONValue value;

    public JSONPair(String str, JSONValue o)
    {
      key = str;
      value = o;
    }
  }
} // class JSONUtils
