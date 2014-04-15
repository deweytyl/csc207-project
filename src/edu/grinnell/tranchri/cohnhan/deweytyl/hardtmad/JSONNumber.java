package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.math.BigDecimal;
import java.math.BigInteger;

public class JSONNumber
    extends
      BigDecimal
    implements
      JSONValue
{

  public JSONNumber(BigInteger val)
  {
    super(val);
  }

  @Override
  public char type()
  {
    return 'n';
  }

  @Override
  public Object value()
  {
    return this.doubleValue();
  }

}
