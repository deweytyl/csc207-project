package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.ArrayList;

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
    return elements;
  } // value()

  public static JSONArray parseArray(String arrStr)
    throws Exception
  {
    ArrayList<JSONValue> array = new ArrayList<JSONValue>();
    String[] strs = (arrStr.substring(1, arrStr.length() - 1)).split(",");
    for (String str : strs)
      {
        //array.add(JSONUtils.parseValue(str));
      } // for

    //return array;
    
    return new JSONArray(array);
  } // parseArray(String)
} // class JSONArray
