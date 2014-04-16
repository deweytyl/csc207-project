package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.Queue;

/**
 * JSONString Class
 * @implements JSONValue
 * 
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
 */

public class JSONString
    implements
      JSONValue
{
  // +--------+----------------------------------------
  // | Fields |
  // +--------+
  
  String contents;
  
  // +--------------+----------------------------------------
  // | Constructors |
  // +--------------+
  
  /**
   * JSONString constructor
   * @param str
   */
  public JSONString(String str)
  {
    this.contents = str;
  } // JSONSring(String)
  
  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+
  
  /**
   * Returns character representation of type of JSONString object
   */
  @Override
  public char type()
  {
    return 's';
  } // type()

  /**
   * Returns value of JSONString object
   */
  @Override
  public Object value()
  {
    return contents;
  } // value() 
  
  /**
   * Given a JSON string return a JSONString object.
   * @param str
   * @return JSONString
   * @throws Exception when str is not correct JSON syntax
   */
  public static JSONString parseString(Queue<Character> charQueue)
      throws Exception
    {
      // Make empty string
      String val = "";
      
      while(charQueue.peek() != null)
        {
          val += charQueue.poll();
        } // while
      
      return new JSONString(val);
    } // parseString(String)
} // class JSONString
