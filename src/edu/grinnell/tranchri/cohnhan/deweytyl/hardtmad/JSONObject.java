package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.Map;

public class JSONObject
    implements
      JSONValue
{
  public Map<String, JSONValue> members;
  
  public JSONObject(Map<String, JSONValue> m)
  {
    members = m;
  } // JSONObject(Map)
  
  @Override
  public char type()
  {
    return 'o';
  } // type()

  @Override
  public Object value()
  {
    return members;
  } // value()

} // class JSONObject
