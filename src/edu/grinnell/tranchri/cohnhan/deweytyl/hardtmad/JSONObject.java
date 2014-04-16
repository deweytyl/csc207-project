package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class JSONObject
    implements
      JSONValue
{
  public Map<String, JSONValue> members;
  
  public JSONObject(Map<String, JSONValue> m)
  {
    members = m;
  } // JSONObject(Map)
  
  @Override
  public char type()
  {
    return 'o';
  } // type()

  @Override
  public Object value()
  {
    return members;
  } // value()

  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+
  
  public static JSONObject parseObject(Queue<Character> charQueue)
    throws Exception
  {
    // TODO Method Stub
    return null;
  } // parseObject(String)
  
  // +--------------------------+----------------------------------------
  // | Utility Class - JSONPair |
  // +--------------------------+
  
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
    
    public JSONPair(String str, JSONValue o)
    {
      key = str;
      value = o;
    } // JSONPair(String, JSONValue)
    
    // +-----------------------+----------------------------------------
    // | Utility Class Methods |
    // +-----------------------+
    
    public static JSONPair parsePair(String pairStr) throws Exception
    {
      String[] strs = pairStr.split(":");
      return new JSONPair(strs[0], JSONUtils.parseValue(strs[1]));
    } // parsePair(String pairStr)
  } // class JSONPair

} // class JSONObject
