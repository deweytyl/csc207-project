package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.Queue;

/**
 * JSONString Class
 * 
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
   * 
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
    return this.contents;
  } // value()

  /**
   * Returns a Java String representation of a JSONString object
   */
  @Override
  public String toString()
  {
    return this.contents;
  } // toString()
  
  /**
   * Given a JSON string return a JSONString object.
   * 
   * @param str
   * @return JSONString
   * @throws Exception
   *           when str is not correct JSON syntax
   */
  public static JSONString parseString(Queue<Character> charQueue)
    throws Exception
  {
    // Make empty string
    StringBuilder val = new StringBuilder();

    char ch = charQueue.poll(); // remove stringQuote
    while ((ch = charQueue.poll()) != '\"')
      {
        if (ch == '\\')
          {
            switch (charQueue.peek())
              {
                case '\\':
                case '\"':
                case '/':
                  val.append(charQueue.poll());
                  break;
                case 'b':
                  charQueue.poll();
                  val.append('\b');
                  break;
                case 'f':
                  charQueue.poll();
                  val.append('\f');
                  break;
                case 'n':
                  charQueue.poll();
                  val.append('\n');
                  break;
                case 'r':
                  charQueue.poll();
                  val.append('\r');
                  break;
                case 't':
                  charQueue.poll();
                  val.append('\t');
                  break;
                default:
                  throw new Exception("Invalid Escape Character in String");
              } // switch
          } // if
        else
          {
            val.append(ch);
          }
      } // while

    return new JSONString(val.toString());
  } // parseString(String)
} // class JSONString
