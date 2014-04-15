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

}
