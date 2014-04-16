package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

/**
 * JSONParser Class
 * 
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
 */

public class JSONParser
{
  // +--------+----------------------------------------------
  // | Fields |
  // +--------+

  String jString;
  JSONValue jValue;

  // +--------------+----------------------------------------
  // | Constructors |
  // +--------------+

  public JSONParser(String input)
  {
    jString = input;
  } // JSONParser (String)

  public JSONParser(JSONValue obj)
  {
    jValue = obj;
  } // JSONParser (JSONValue)

  // +---------------+---------------------------------------
  // | Class Methods |
  // +---------------+

  public Object JSONToJavaObject()
    throws Exception
  {
    this.jValue = JSONUtils.parseValue(jString);
    char type = jValue.type();
    switch (type)
      {
        case 'n':
          return JSONUtils.getNumber(jValue);
        case 's':
          return JSONUtils.getString(jValue);
        case 'c':
          {
            String str = JSONUtils.getString(jValue);
            if (str.equals("true"))
              return true;
            else if (str.equals("false"))
              return false;
            else
              return null;
          } // case 'c'
        case 'a':
          return JSONUtils.getArray(jValue);
        case 'o':
          return JSONUtils.getObject(jValue);
      } // switch

    throw new Exception("Unsupported String" + jString);

  } // JSONToJavaObject()

  public String JavaObjectToStringOfJSON()
    throws Exception
  {
    
    return jString;
  } // JavaObjectToStringOfJSON()

}
