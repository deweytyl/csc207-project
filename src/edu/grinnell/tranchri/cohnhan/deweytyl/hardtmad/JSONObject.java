package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.Map;
import java.util.Queue;

/**
 * JSONObject Class
 * 
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
   * 
   * @param m
   */
  public JSONObject(Map<String, JSONValue> m)
  {
    members = m;
  } // JSONObject(Map)

  // +---------+-------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Returns character representation of type of JSONObject object
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
   * 
   * @param str
   * @return JSONObject
   * @throws Exception
   *           when str is not correct JSON syntax
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
     * 
     * @param str
     * @param o
     */
    public JSONPair(String str, JSONValue v)
    {
      key = str;
      value = v;
    } // JSONPair(String, JSONValue)

    // +-----------------------+----------------------------------------
    // | Utility Class Methods |
    // +-----------------------+

    /**
     * Given a String return a JSONPair object.
     * 
     * @param pairStr
     * @return JSONPair
     * @throws Exception
     *           when str is not correct JSON syntax
     */
    public static JSONPair parsePair(Queue<Character> charQueue)
      throws Exception
    {
      JSONString key = JSONString.parseString(charQueue);
      if (charQueue.poll() != ':')
        {
          throw new Exception(
                              "Improper Object Format: improperly constructed pair");
        }
      JSONPair pair =
          new JSONPair(key.toString(), JSONUtils.parseValue(charQueue));
      return pair;
    } // parsePair(String pairStr)
  } // class JSONPair

} // class JSONObject
