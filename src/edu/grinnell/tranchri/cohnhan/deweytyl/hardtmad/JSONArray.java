package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.ArrayList;
import java.util.Queue;

/**
 * JSONArray Class
 * 
 * @implements JSONValue
 * 
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
 */

public class JSONArray
    implements
      JSONValue
{
  // +--------+----------------------------------------
  // | Fields |
  // +--------+

  public ArrayList<JSONValue> elements;

  // +--------------+----------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * JSONArray Constructor
   * 
   * @param elts, an ArrayList of JSONValues
   */
  public JSONArray(ArrayList<JSONValue> elts)
  {
    elements = elts;
  } // JSONArray(ArrayList<JSONValue>)

  // +------------------+----------------------------------------
  // | Instance Methods |
  // +------------------+

  /**
   * Returns character representation of type of JSONArray object
   */
  @Override
  public char type()
  {
    return 'c';
  } // type()

  /**
   * Returns value of JSONArray object
   */
  @Override
  public Object value()
  {
    return elements.toArray();
  } // value()

  @Override
  public String toJSONData()
  {
    // TODO Auto-generated method stub
    return null;
  }
  
  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+
  
  /**
   * Given a JSON string return a JSONArray object.
   * 
   * @param str
   * @return JSONArray
   * @throws Exception
   *           when str is not correct JSON syntax
   */
  public static JSONArray parseArray(Queue<Character> charQueue)
    throws Exception
  {
    // Make ArrayList of JSONValues
    ArrayList<JSONValue> val = new ArrayList<JSONValue>();
    // Until we hit the end of the array...
    while (charQueue.peek() != ']')
      {
      // Check to see if the next character is a comma
        if (charQueue.peek() == ',')
          {
            // Remove the comma
            charQueue.poll();
          } // if
        // Parse the values in the array and add to valg
        val.add(JSONUtils.parseValue(charQueue));
      } // while
    // Remove end brace.
    charQueue.poll();
    return new JSONArray (val);
  } // parseArray(String)

} // class JSONArray
