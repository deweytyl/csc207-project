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

  // +---------+----------------------------------------
  // | Methods |
  // +---------+

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

  @Override
  public String toJSONData()
  {
    return this.value.toString();
  }
  
  // +-----------------------+----------------------------------------
  // | Utility Class Methods |
  // +-----------------------+
  
  /**
   * Given a JSON string return a JSONNumber object.
   * 
   * @param str
   * @return JSONNumber
   * @throws Exception
   *           when str is not correct JSON syntax
   */
  public static JSONNumber parseNumber(Queue<Character> charQueue)
    throws Exception
  {
    // Make String of number
    StringBuilder baseStr = new StringBuilder();
    Character ch;
    while (((ch = charQueue.peek()) != 'e') ||
           (ch != 'E') || (ch != ',') ||
           (ch != ']') || (ch != '}') || (ch != null))
      {
        baseStr.append(charQueue.poll());
      } // while
    
    BigDecimal base = new BigDecimal(baseStr.toString());
    
    if ((ch == 'e') || (ch == 'E'))
      {
        StringBuilder exptStr = new StringBuilder();
        while (((ch = charQueue.peek()) != ',') ||
           (ch != ']') || (ch != '}') || (ch != null))
          {
            exptStr.append(ch);
          } // while
        
        int expt = Integer.parseInt(exptStr.toString());
        return new JSONNumber(base.scaleByPowerOfTen(expt));
      } // if number has an exponent
    return new JSONNumber(base);

    // throw new Exception("Incorrect representation");

  } // parseNumber(String)
} // class JSONNumber
