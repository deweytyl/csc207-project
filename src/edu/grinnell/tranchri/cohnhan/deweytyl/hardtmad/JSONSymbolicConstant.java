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

  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+

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
    return contents;
  } // value()

  /**
   * Given a JSON string return a JSONSymbolicConstant object.
   * 
   * @param str
   * @return JSONSymbolicConstant
   * @throws Exception
   *           when str is not correct JSON syntax
   */
  public static JSONSymbolicConstant
    parseSymbolicConstant(Queue<Character> charQueue)
      throws Exception
  {
    // Make String
    String val = "";
    while (charQueue.peek() != null)
      {
        val += charQueue.poll();
      } // while

    return new JSONSymbolicConstant(val);

    // return new JSONPair(strs[0], JSONUtils.parseValue(strs[1]));

  } // parseSymbolicConstant(String)
} // JSONSymbolicConstant
