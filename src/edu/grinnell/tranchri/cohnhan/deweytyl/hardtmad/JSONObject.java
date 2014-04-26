package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
  // +--------+----------------------------------------
  // | Fields |
  // +--------+

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

  @Override
  public String toJSONData()
  {
    StringBuilder data = new StringBuilder("{");
    Set<Map.Entry<String, JSONValue>> entrySet = this.members.entrySet();
    if (entrySet == null)
      {
        data.append("}");
        return data.toString();
      }

    for (Map.Entry<String, JSONValue> pair : entrySet)
      {
        data.append(pair.getKey() + ":" + pair.getValue().toJSONData() + ",");
      }
    data.setCharAt(data.length()-1, '}');
    return data.toString();
  }

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
    // Build Map to hold key, value pairs obtained from JSON string
    // retrieved
    Map<String, JSONValue> val = new HashMap<String, JSONValue>();

    // Remove opening brace
    charQueue.poll();
    
    // Until we are at the end of the object
    while (charQueue.peek() != '}')
      {
        // Check to see if there is a comma, ignore it
        if (charQueue.peek() == ',')
          {
            // Remove the comma
            charQueue.poll();
          } // if

        // Deal with the pair
        JSONPair pair = JSONPair.parsePair(charQueue);
        val.put(pair.key, pair.value);
      } // while
    
    // Remove end brace.
    charQueue.poll();

    return new JSONObject(val);
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
     * @param charQueue
     * @return JSONPair
     * @throws Exception
     *           when not correct JSON syntax
     */
    public static JSONPair parsePair(Queue<Character> charQueue)
      throws Exception
    {
      JSONString key = JSONString.parseString(charQueue);
      // If the pair does not contain a colon then it is not
      // valid and throw an exception
      // ****** parseString takes off the colon.
      if (charQueue.poll() != ':')
        {
          throw new Exception(
                              "Improper Object Format: improperly constructed pair");
        } // if
      // Make JSONPair object with key and value
      JSONPair pair =
          new JSONPair(key.toString(), JSONUtils.parseValue(charQueue));
      return pair;
    } // parsePair(String pairStr)
  } // class JSONPair

} // class JSONObject
