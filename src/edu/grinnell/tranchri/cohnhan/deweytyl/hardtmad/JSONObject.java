package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.util.HashMap;

public class JSONObject
    implements
      JSONValue
{
  public HashMap<String, JSONValue> members;
  
  @Override
  public char type()
  {
    return 'o';
  }

  @Override
  public Object value()
  {
    return members;
  }

}
