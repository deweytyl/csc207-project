package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.util.Queue;

/**
 * JSONNumbers Class
 * 
 * @implements JSONValue
 * 
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
 */

public class JSONNumber
    implements
      JSONValue
{
  // +--------+----------------------------------------
  // | Fields |
  // +--------+

  public BigDecimal value;

  // +--------------+----------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * JSONNumber constructor
   * 
   * @param num
   */
  public JSONNumber(BigDecimal num)
  {
    value = num;
  } // JSONNumber(BigInteger)

  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+

  /**
   * Returns character representation of type of JSONNumber object
   */
  @Override
  public char type()
  {
    return 'n';
  } // type()

  /**
   * Returns value of JSONNumber object
   */
  @Override
  public Object value()
  {
    return this.value;
  } // value()

  /**
   * Given a JSON string return a JSONNumber object.
   * 
   * @param str
   * @return JSONNumber
   * @throws Exception
   *           when str is not correct JSON syntax
   */
  @SuppressWarnings("null")
  public static JSONNumber parseNumber(Queue<Character> charQueue)
    throws Exception
  {
    // Make StringBuilder of number which will store the number
    StringBuilder baseStr = new StringBuilder();
    Character ch;
    // Until we hit a terminating character
    while (((ch = charQueue.peek()) != 'e') ||
           (ch != 'E') || (ch != ',') ||
           (ch != ']') || (ch != '}') || (ch != null))
      {
        // Add onto baseStr
        baseStr.append(charQueue.poll());
      } // while
    
    // Make new BigDecimal of the number obtained from JSON
    BigDecimal base = new BigDecimal(baseStr.toString());
    
    // Handle exponents
    if ((ch == 'e') || (ch == 'E'))
      {
        // Make StringBuilder to hold the exponent value
        StringBuilder exptStr = new StringBuilder();
        // Until we hit a terminating character
        while (((ch = charQueue.peek()) != ',') ||
           (ch != ']') || (ch != '}') || (ch != null))
          {
            // Add onto final exponent number
            exptStr.append(ch);
          } // while
        // Make exptStr into an Integer
        int expt = Integer.parseInt(exptStr.toString());
        // Get the exponent value
        return new JSONNumber(base.scaleByPowerOfTen(expt));
      } // if number has an exponent
    return new JSONNumber(base);

  } // parseNumber(String)
} // class JSONNumber
