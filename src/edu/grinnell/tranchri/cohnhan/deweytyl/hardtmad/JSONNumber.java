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
  
  /**
   * Given a JSON string return a BigDecimal object.
   * @param str
   * @return BigDecimal
   * @throws Exception when str is not correct JSON syntax
   */
  public BigDecimal parseNumber(String str)
    throws Exception
  {
    if (str.contains("e"))
      {
        this.value = parseE(str);
      } // if exp or frac exp

    // The number is an int or frac (double)
    this.value = new BigDecimal(str);
    return this.value;
  } // parseNumber(String)

  /**
   * Parse str around 'e' and find the value of #e# and return
   * BigDecimal object with that value.
   * @param str
   * @return BigDecimal
   * @throws Exception if incorrect JSON syntax
   */
  public static BigDecimal parseE(String str)
    throws Exception
  {
    String nums[] = str.split("e");
    if (nums.length != 2)
      {
        throw new Exception("Incorrect JSON syntax");
      } // if
    else
      {
        return new BigDecimal(Math.pow(Double.parseDouble(nums[0]),
                                       Double.parseDouble(nums[1])));
      } // else
  } // parseE(String)

} //class JSONNumber
