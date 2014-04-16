package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.Queue;

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
  
  public static JSONString parseString(Queue<Character> charQueue)
      throws Exception
    {
      // TODO Method Stub
      return null;
    } // parseString(String)
} // class JSONString
