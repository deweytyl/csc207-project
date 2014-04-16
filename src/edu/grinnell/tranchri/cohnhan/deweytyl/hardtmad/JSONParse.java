package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

/**
 * Do whatever you want with either of these classes.
 */
public class JSONParse
{
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
  
}
