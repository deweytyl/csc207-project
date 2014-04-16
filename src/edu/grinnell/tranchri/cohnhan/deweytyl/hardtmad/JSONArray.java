package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.ArrayList;
import java.util.Queue;

public class JSONArray
    implements
      JSONValue
{
  public JSONArray(ArrayList<JSONValue> elts)
  {
    elements = elts;
  } // JSONArray(ArrayList<JSONValue>)

  public ArrayList<JSONValue> elements;

  @Override
  public char type()
  {
    return 'c';
  } // type()

  @Override
  public Object value()
  {
    return elements.toArray();
  } // value()

  public static JSONArray parseArray(Queue<Character> charQueue)
    throws Exception
  {
    // TODO Method Stub
    return null;
  } // parseArray(String)
} // class JSONArray
