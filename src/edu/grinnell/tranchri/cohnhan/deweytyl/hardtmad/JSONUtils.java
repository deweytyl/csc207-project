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
 * Character type keys: String: 's' Number: 'n' Object: 'o' Array: 'a' Constant:
 * 'c'
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

  public static Map<String, JSONValue> getObject(JSONValue value)
    throws UnsupportedOperationException
  {
    // TODO Method Stub
    return null;
  } // getObject(JSONValue)

  public static JSONValue[] getArray(JSONValue value)
    throws UnsupportedOperationException
  {
    // TODO Method Stub
    return null;
  } // getArray(JSONValue)

  public static BigDecimal getNumber(JSONValue value)
    throws UnsupportedOperationException
  {
    // TODO Method Stub
    return null;
  } // getNumber(JSONValue)

  public static String getString(JSONValue value)
    throws UnsupportedOperationException
  {
    // TODO Method Stub
    return null;
  } // getString(JSONValue)

  public static BigDecimal parseNumber(String str)
    throws Exception
  {
    if (str.contains("e"))
      {
        parseE(str);
      } // if exp or frac exp

    // Else the number is an int or frac (double)
    return new BigDecimal(str);
  } // parseNumber(String)

  public static BigDecimal parseE(String str)
    throws Exception
  {
    String nums[] = str.split("e");
    if (nums.length != 2)
      {
        throw new Exception("Incorrect JSON syntax");
      } // if
    else
      {
        return new BigDecimal(Math.pow(Double.parseDouble(nums[0]),
                                       Double.parseDouble(nums[1])));
      } // else
  } // parseE(String)

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
    } // JSONPair(String, JSONValue)
  } // class JSONPair

} // class JSONUtils
