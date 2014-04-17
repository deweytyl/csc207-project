package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.Queue;

/**
 * JSONSymbolicConstant Class
 * 
 * @implements JSONValue
 * 
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
 */

public class JSONSymbolicConstant
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
   * JSONSymbolicConstant constructor
   * 
   * @param str
   */
  public JSONSymbolicConstant(String str)
  {
    this.contents = str;
  } // JSONSymbolicConstant

  // +------------------+----------------------------------------
  // | Instance Methods |
  // +------------------+

  /**
   * Returns character representation of type of JSONSymbolicConstant object
   */
  @Override
  public char type()
  {
    return 'c';
  } // type()

  /**
   * Returns value of JSONSymbolicConstant object
   */
  @Override
  public Object value()
  {
    return this.contents;
  } // value()

  /**
   * Returns a JSON representation of this object in a String
   */
  @Override
  public String toJSONData()
  {
    return this.contents;
  }
  
  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+
  
  /**
   * Given a JSON string return a JSONSymbolicConstant object.
   * 
   * @param str
   * @return JSONSymbolicConstantg
   * @throws Exception
   *           when str is not correct JSON syntax
   */
  public static JSONSymbolicConstant
    parseSymbolicConstant(Queue<Character> charQueue)
      throws Exception
  {
    // Make String
    String val = "";
    
    // Until there is nothing left to look at
    while (charQueue.peek() != null)
      {
        // Add the character read to val
        val += charQueue.poll();
      } // while

    return new JSONSymbolicConstant(val);

  } // parseSymbolicConstant(String)
} // JSONSymbolicConstant
