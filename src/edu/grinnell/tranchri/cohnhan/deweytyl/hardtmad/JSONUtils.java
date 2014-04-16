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
 * Character type keys: String: 's' Number: 'n' Object: 'o' Array: 'a' Constant:
 * 'c'
 */

public class JSONUtils
{
  /**
   * Converts str to Queue of Characters so it can be parsed by
   * parseValue(Queue<Character> charQueue)
   * 
   * @param str
   * @return JSONValue of appropriate type
   * @throws Exception
   */
  // ************Does this work for the empty string?
  public static JSONValue parseValue(String str)
    throws Exception
  {
    char[] charArray = str.toCharArray();
    Queue<Character> charQueue = new ArrayDeque<Character>(charArray.length);
    for (Character ch : charArray)
      {
        charQueue.add(ch);
      } // for
    return parseValue(charQueue);
  } // parseValue(String)

  /**
   * Identity value type, parse, and return appropriate JSONValue
   * 
   * @param charQueue
   * @return JSONValue of appropriate type
   * @throws Exception
   */
  // ************Does this work for an empty queue?
  // It throws an exception if its empty right?
  public static JSONValue parseValue(Queue<Character> charQueue)
    throws Exception
  {
    // Identify type by peeking at first character.
    Character ch = charQueue.peek();

    if (ch != null)
      {
     // valStr is a number
        if (Character.isDigit(ch))
          {
            return JSONNumber.parseNumber(charQueue);
          }
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

  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+

  /**
   * Converts JSONObject to Java Map<String, JSONValue>
   * 
   * @param value
   * @return Map
   * @throws UnsupportedOperationException
   */
  @SuppressWarnings("unchecked")
  public static Map<String, JSONValue> getObject(JSONValue value)
    throws UnsupportedOperationException
  {
    // Make sure JSONValue is a JSONObject
    if (value.type() == 'o')
      {
        return (Map<String, JSONValue>) value.value();
      } // if
    throw new UnsupportedOperationException();
  } // getObject(JSONValue)

  /**
   * Converts JSONArray to Java Array of JSONValues
   * 
   * @param value
   * @return Array of JSONValues
   * @throws UnsupportedOperationException
   */
  public static JSONValue[] getArray(JSONValue value)
    throws UnsupportedOperationException
  {
    // Make sure JSONValue is a JSONArray
    if (value.type() == 'a')
      {
        return (JSONValue[]) value.value();
      } // if
    throw new UnsupportedOperationException();
  } // getArray(JSONValue)

  /**
   * Converts JSONNumber to Java BigDecimal
   * 
   * @param value
   * @return BigDecimal
   * @throws UnsupportedOperationException
   */
  public static BigDecimal getNumber(JSONValue value)
    throws UnsupportedOperationException
  {
    // Make sure JSONValue is a JSONNumber
    if (value.type() == 'n')
      {
        return (BigDecimal) value.value();
      } // if
    throw new UnsupportedOperationException();
  } // getNumber(JSONValue)

  /**
   * Converts JSONString to Java String
   * 
   * @param value
   * @return String
   * @throws UnsupportedOperationException
   */
  public static String getString(JSONValue value)
    throws UnsupportedOperationException
  {
    // Make sure JSONValue is a JSONString
    if (value.type() == 's')
      {
        return (String) value.value();
      } // if
    throw new UnsupportedOperationException();
  } // getString(JSONValue)

} // class JSONUtils
