package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

public class JSONString
    implements
      JSONValue
{
  String contents;
  
  public JSONString(String str)
  {
    this.contents = str;
  }
  
  @Override
  public char type()
  {
    return 's';
  }

  @Override
  public Object value()
  {
    return contents;
  }

}
