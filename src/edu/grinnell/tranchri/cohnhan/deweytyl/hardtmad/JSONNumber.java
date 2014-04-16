package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.math.BigInteger;

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

} //class JSONNumber
