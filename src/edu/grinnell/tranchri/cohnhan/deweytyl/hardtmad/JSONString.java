package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

public class JSONString
    implements
      JSONValue
{
  String contents;
  
  public JSONString(String str)
  {
    this.contents = str;
  } // JSONSring(String)
  
  @Override
  public char type()
  {
    return 's';
  } // type()

  @Override
  public Object value()
  {
    return contents;
  } // value() 
  
  public static JSONString parseString(String str)
      throws Exception
    {
      return new JSONString(str);
    } // parseString(String)
} // class JSONString
