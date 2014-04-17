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
   * @param elts
   */
  public JSONArray(ArrayList<JSONValue> elts)
  {
    elements = elts;
  } // JSONArray(ArrayList<JSONValue>)

  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+

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
    while (charQueue.peek() != ']')
      {
      //****Not sure if this is the right place to check
      //    for commas because I'm not sure how parseValue
      //    will handle the comma...will it crash?
        if (charQueue.peek() != ',')
          {
            // Remove the comma
            charQueue.poll();
          } // if
        val.add(JSONUtils.parseValue(charQueue));
      } // while
    
    return new JSONArray (val);
  } // parseArray(String)
} // class JSONArray
