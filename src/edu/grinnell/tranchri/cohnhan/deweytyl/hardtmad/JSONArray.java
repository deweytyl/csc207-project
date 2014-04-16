package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.ArrayList;

public class JSONArray
    extends
      ArrayList<JSONValue>
    implements
      JSONValue

{
  @Override
  public char type()
  {
    return 'c';
  }

  @Override
  public Object value()
  {
    return this.toArray();
  }
  
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
}
