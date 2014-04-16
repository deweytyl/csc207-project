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

  public static JSONPair parsePair(String pairStr)
  {
    String[] strs = pairStr.split(":");
    return new JSONPair(strs[0], parseValue(strs[1]));
  } // parsePair(String pairStr)

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
    BigDecimal num = new BigDecimal(str);

    // Different cases:
    // If the number is an integer, return an Integer object.
    // Can return BigDecimal(str)
    // int frac
    // Can return BigDecimal(str)
    // int exp
    // Write parseE
    // int frac exp
    // Waiting on parseE

    return null;
  } // parseNumber(String)

  public static BigDecimal parseE(String str)
    throws Exception
  {
    double val;
    if (str.contains("e"))
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
      } // if
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
