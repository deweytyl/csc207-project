package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Queue;

public class JSONNumber
    implements
      JSONValue
{
  public BigDecimal value;
  
  public JSONNumber(BigDecimal num)
  {
    value = num;
  } // JSONNumber(BigInteger)

  @Override
  public char type()
  {
    return 'n';
  } // type()

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
