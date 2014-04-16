package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * JSONObject Class
 * @implements JSONValue
 * 
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
 */

public class JSONObject
    implements
      JSONValue
{
  public Map<String, JSONValue> members;
  
  // +--------------+----------------------------------------
  // | Constructors |
  // +--------------+
  
  /**
   * JSONObject Constructor
   * @param m
   */
  public JSONObject(Map<String, JSONValue> m)
  {
    members = m;
  } // JSONObject(Map)
  
  /**
   * Returns type of JSONObject object
   */
  @Override
  public char type()
  {
    return 'o';
  } // type()

  /**
   * Returns value of JSONObject object
   */
  @Override
  public Object value()
  {
    return members;
  } // value()

  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+
  
  /**
   * Given a JSON string return a JSONObject object.
   * @param str
   * @return 
   * @throws Exception when str is not correct JSON syntax
   */
  public static JSONObject parseObject(Queue<Character> charQueue)
    throws Exception
  {
    // TODO Method Stub
    return null;
  } // parseObject(String)
  
  // +--------------------------+----------------------------------------
  // | Utility Class - JSONPair |
  // +--------------------------+
  /**
   * Nested JSONPair Class
   */
  static class JSONPair
  {
    // +--------+----------------------------------------
    // | Fields |
    // +--------+
    
    /**
     * A String representing the key of this key-value pair
     */
    String key;

    /**
     * The value of this key-value pair
     */
    JSONValue value;

    // +--------------+----------------------------------------
    // | Constructors |
    // +--------------+
    
    /**
     * JSONPair constructor
     * @param str
     * @param o
     */
    public JSONPair(String str, JSONValue o)
    {
      key = str;
      value = o;
    } // JSONPair(String, JSONValue)
    
    // +-----------------------+----------------------------------------
    // | Utility Class Methods |
    // +-----------------------+
    
    /**
     * Given a String return a JSONPair object.
     * @param pairStr
     * @return 
     * @throws Exception when str is not correct JSON syntax
     */
    public static JSONPair parsePair(String pairStr) throws Exception
    {
      String[] strs = pairStr.split(":");
      return new JSONPair(strs[0], JSONUtils.parseValue(strs[1]));
    } // parsePair(String pairStr)
  } // class JSONPair

} // class JSONObject
