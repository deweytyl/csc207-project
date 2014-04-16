package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

public class JSONSymbolicConstant
    implements
      JSONValue
{
  String contents;

  public JSONSymbolicConstant(String str)
  {
    this.contents = str;
  } // JSONSymbolicConstant

  @Override
  public char type()
  {
    return 'c';
  } // type()

  @Override
  public Object value()
  {
    return contents;
  } // value()

  public static JSONSymbolicConstant parseSymbolicConstant(String str)
    throws Exception
  {
    return new JSONSymbolicConstant(str);
  } // parseSymbolicConstant(String)
} // JSONSymbolicConstant
