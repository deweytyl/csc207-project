package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.ArrayList;
import java.util.Queue;

/**
 * JSONArray Class
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
   * @param str
   * @return JSONArray
   * @throws Exception when str is not correct JSON syntax
   */
  public static JSONArray parseArray(Queue<Character> charQueue)
    throws Exception
  {
 // Make String
    ArrayList<JSONValue> val;
    while (charQueue.peek() != null)
      {
        //recursively handle stuff in the array here...?
        //val.add(charQueue.poll());
      } // while
    
    //return new JSONArray (val);
    
    return null;

  } // parseArray(String)
} // class JSONArray
