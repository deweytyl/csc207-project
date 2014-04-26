package edu.grinnell.mhctd.json;

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
    implements JSONValue
{
  // +--------+----------------------------------------
  // | Fields |
  // +--------+

  /**
   * Array to hold parsed array values from JSON.
   */
  public ArrayList<JSONValue> elements;

  // +--------------+----------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * JSONArray Constructor
   * 
   * @param elts
   *          , an ArrayList of JSONValues
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
    return 'a';
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
    StringBuilder data = new StringBuilder("[");
    if (this.elements.size() == 0)
      {
        data.append(']');
        return data.toString();
      } // if

    for (JSONValue element : elements)
      {
        data.append(element.toJSONData() + ",");
      } // for
    data.setCharAt(data.length() - 1, ']');
    return data.toString();
  }

  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+

  /**
   * Given a JSON string return a JSONArray object.
   * 
   * @param charQueue
   * @return JSONArray
   * @throws Exception
   *           when not correct JSON syntax
   */
  public static JSONArray parseArray(Queue<Character> charQueue)
    throws Exception
  {
    // Make ArrayList of JSONValues
    ArrayList<JSONValue> val = new ArrayList<JSONValue>();

    Character ch;

    // remove opening brace
    charQueue.poll();

    // Until we hit the end of the array...
    while ((ch = charQueue.peek()) != ']')
      {
        // Check to see if the next character is a comma
        if (ch == ',')
          {
            charQueue.poll();
          }// If ch is a comma
        else
          {
            val.add(JSONUtils.parseValue(charQueue));
          } // If it isn't, parse the values in the array and add to val

      } // while not at the end of the array

    // remove final brace
    charQueue.poll();

    return new JSONArray(val);
  } // parseArray(String)

} // class JSONArray
