package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

/**
 * Utilities for parsing JSON Strings.
 *
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
 */

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
 * 
 */
public class JSONUtils
{

  /**
   * Identity value type and execute corresponding parse method.
   * 
   * @pre valStr is a String
   * @post JSONValue is returned by helper method or exception is thrown.
   */

  // Should return type be void because parse methods return JSONValues?
  public static void parseValue(String valStr)
    throws Exception
  {
    // Case: empty string
    // Do we need to check this?
    if (valStr.length() == 0)
      {
        return;
      }
    char first = valStr.charAt(0);

    // valStr is a number
    if (Character.isDigit(first))
      {
        JSONNumber.parseNumber(valStr);
      } // if

    switch (first)
      {
      // valStr is a string or a pair
        case '\"':
          {
            String[] strs = valStr.split(":");
            if (strs.length == 1)
              {
                JSONString.parseString(valStr);
              } // if
            // Assuming it is a pair, we are worried it could be a string with a
            // \
            // colon in the middle like: \"Hi:Bye\"
            else
              {
                // parse to be implemented in JSONParse class
                // return new JSONPair(strs[0], JSONParse.parse(strs[1]));
              } // else
            break;
          }
        // valStr is an array
        case '[':
          {
            JSONArray.parseArray(valStr);
            break;
          }
        // valStr is an object
        case '{':
          {
            JSONObject.parseObject(valStr);
            break;
          }
        // valStr is a symbolic constant
        case 't':
        case 'f':
        case 'n':
          {
            JSONSymbolicConstant.parseSymbolicConstant(valStr);
            break;
          }
        // valStr is not a supported value type
        default:
          {
            throw new Exception("Unsupported value: " + valStr);
          }
      } // switch
  } // parseValue(String)

  /**
   * { else if (first == '\"') { String[] strs = valStr.split(":"); if
   * (strs.length == 1) { JSONString.parseString(valStr); } // if // Assuming it
   * is a pair, we are worried it could be a string with a \ // colon in the
   * middle like: \"Hi:Bye\" else { // parse to be implemented in JSONParse
   * class // return new JSONPair(strs[0], JSONParse.parse(strs[1])); } // else
   * } // else if else if (first == '[') { JSONArray.parseArray(valStr); } //
   * else if else if (first == '{') { JSONObject.parseObject(valStr); } // else
   * if else if (first == 't' || first == 'f' || first == 'n') {
   * JSONSymbolicConstant.parseSymbolicConstant(valStr); } // else if else {
   * throw new Exception("Unsupported value: " + valStr); } // else
   * 
   * } // parseValue(String)
   */

  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+

  public static Map<String, JSONValue> getObject(JSONValue value)
    throws UnsupportedOperationException
  {
    // TODO Method Stub
    return null;
  } // getObject(JSONValue)

  public static JSONValue[] getArray(JSONValue value)
    throws UnsupportedOperationException
  {
    if (value.type() == 'a')
      {
        return (JSONValue[]) value.value();
      }
    throw new UnsupportedOperationException("JSONValue is of wrong type");
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

  static class JSONPair
      implements
        JSONValue
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

    @Override
    public char type()
    {
      return 'p';
    }

    @Override
    public Object value()
    {
      return value;
    }
  } // class JSONPair

} // class JSONUtils
