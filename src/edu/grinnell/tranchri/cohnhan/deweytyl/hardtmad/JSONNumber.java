package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Queue;

/**
 * JSONNumbers Class
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
   * Returns type of JSONNumber object
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
   * @param str
   * @return BigDecimal
   * @throws Exception when str is not correct JSON syntax
   */
  public static JSONNumber parseNumber(Queue<Character> charQueue)
    throws Exception
  {
    // TODO Method Stub
    return null;
  } // parseNumber(String)

} //class JSONNumber
