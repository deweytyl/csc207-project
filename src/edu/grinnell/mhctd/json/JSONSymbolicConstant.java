package edu.grinnell.mhctd.json;

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
    implements JSONValue
{
  // +--------+----------------------------------------
  // | Fields |
  // +--------+

  /**
   * String to hold a constant.
   */
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
   * @param charQueue
   * @return JSONSymbolicConstantg
   * @throws Exception
   *           when not correct JSON syntax
   */
  public static JSONSymbolicConstant
    parseSymbolicConstant(Queue<Character> charQueue)
      throws Exception
  {
    // Make String
    String val = "";

    // Following code taken from Sam Rebelsky's JSON.java
    // and adapted.
    // Get the first character
    char ch = charQueue.poll();
    // Cases for t,f, and n. Check to make sure that
    // they are actually true, false, and null, throws
    // an exception otherwise.
    switch (ch)
      {
        case 't':
          if ((charQueue.poll() == 'r') && (charQueue.poll() == 'u')
              && (charQueue.poll() == 'e'))
            {
              val = "true";
            } // if
          else
            {
              throw new Exception("Invalid constant starting with t.");
            }
          break;
        case 'f':
          if ((charQueue.poll() == 'a') && (charQueue.poll() == 'l')
              && (charQueue.poll() == 's') && (charQueue.poll() == 'e'))
            {
              val = "false";
            } // if
          else
            {
              throw new Exception("Invalid constant starting with f.");
            }
          break;
        case 'n':
          if ((charQueue.poll() == 'u') && (charQueue.poll() == 'l')
              && (charQueue.poll() == 'l'))
            {
              val = "null";
            } // if
          else
            {
              throw new Exception("Invalid constant starting with n.");
            }
          break;
        default:
          throw new Exception("Invalid constant.");
      } // switch

    return new JSONSymbolicConstant(val);

  } // parseSymbolicConstant(String)
} // JSONSymbolicConstant
