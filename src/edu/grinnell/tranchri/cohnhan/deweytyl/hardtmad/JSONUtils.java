package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Do whatever you want with either of these classes.
 * 
 * Maybe we could make a JSONValueParser object. Up to us. We should talk about
 * it later, but for now let's just write static methods.
 */
public class JSONUtils
{

  public static Object parseValue(String valStr)
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

  /**
   * To be added.
   * 
   * @param str
   * @return BigDecimal
   * @throws Exception
   */
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
