package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.ArrayList;

public class JSONArray
    implements
      JSONValue
{
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
  
  public static ArrayList<JSONValue> parseArray(String arrStr)
  {
    ArrayList<JSONValue> array = new ArrayList<JSONValue>();
    String[] strs = (arrStr.substring(1, arrStr.length() - 1)).split(",");
    for (String str : strs)
      {
        array.add(JSONUtils.parseValue(str));
      } // for

    return array;
  } // parseArray(String)
} // class JSONArray
