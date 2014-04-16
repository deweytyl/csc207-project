package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.Queue;

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

  public static JSONSymbolicConstant parseSymbolicConstant(Queue<Character> charQueue)
    throws Exception
  {
    // TODO Method Stub
    return null;
  } // parseSymbolicConstant(String)
} // JSONSymbolicConstant
