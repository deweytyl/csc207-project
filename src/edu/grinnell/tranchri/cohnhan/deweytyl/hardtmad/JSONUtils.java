package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

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
  public static JSONValue parseValue(String str)
    throws Exception
  {
    char[] charArray = str.toCharArray();
    Queue<Character> charQueue = new ArrayDeque<Character>(charArray.length);
    for (Character ch : charArray)
      {
        charQueue.add(ch);
      }
    return parseValue(charQueue);
  }

  public static JSONValue parseValue(Queue<Character> charQueue)
    throws Exception
  {
    Character ch = charQueue.peek();

    if (ch != null)
      {
        switch (ch)
          {
          // valStr is a string or a pair
            case '\"':
              return JSONString.parseString(charQueue);
            // valStr is an array
            case '[':
              return JSONArray.parseArray(charQueue);
              // valStr is an object
            case '{':
              return JSONObject.parseObject(charQueue);
              // valStr is a symbolic constant
            case 't':
            case 'f':
            case 'n':
              return JSONSymbolicConstant.parseSymbolicConstant(charQueue);
              // valStr is not a supported value type
            default:
              throw new Exception("Unsupported value: " + charQueue);
          } // switch
      } // if
    
    throw new Exception("No Input");
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

  @SuppressWarnings("unchecked")
  public static Map<String, JSONValue> getObject(JSONValue value)
    throws UnsupportedOperationException
  {
    if (value.type() == 'o')
      {
        return (Map<String,JSONValue>) value.value();
      }
    throw new UnsupportedOperationException();
  } // getObject(JSONValue)

  public static JSONValue[] getArray(JSONValue value)
    throws UnsupportedOperationException
  {
    if (value.type() == 'a')
      {
        return (JSONValue[]) value.value();
      }
    throw new UnsupportedOperationException();
  } // getArray(JSONValue)

  public static BigDecimal getNumber(JSONValue value)
    throws UnsupportedOperationException
  {
   if (value.type() == 'n')
     {
       return (BigDecimal) value.value();
     }
   throw new UnsupportedOperationException();
  } // getNumber(JSONValue)

  public static String getString(JSONValue value)
    throws UnsupportedOperationException
  {
    if (value.type() == 's')
      {
        return (String) value.value();
      }
    throw new UnsupportedOperationException();
  } // getString(JSONValue)
  
} // class JSONUtils
