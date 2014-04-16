package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

/**
 * Do whatever you want with either of these classes.
 */
public class JSONParse
{
<<<<<<< HEAD
  public static JSONValue parse(Object obj)
  {
    return null; // STUB
  } // parse(Object)
=======
  public char type (String str)
  {
    char objectType = 0;
    char first = str.charAt(0); 
    switch(first) {
      case '"' :
        objectType = 's';
        break;
      case '{':
        objectType = 'o';
        break;
      case '[':
        objectType = 'a';
        break;
      case 't':
      case 'f':
      case 'n':
        objectType = 'c';
        break; 
      case '-':
      case '0':
      case '1':
      case '2':
      case '4':
      case '5':
      case '6':
      case '7':  
      case '8':
      case '9':
        objectType = 'n'; 
        break;
        
        
    }
    return objectType; 
  }

  public Object value; 
  
>>>>>>> a6894353485b41cc756153df62e6be7d26fb7287
} // class JSONParse
