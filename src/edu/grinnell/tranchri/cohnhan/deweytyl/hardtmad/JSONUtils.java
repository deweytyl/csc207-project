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
  

} // class JSONUtils
