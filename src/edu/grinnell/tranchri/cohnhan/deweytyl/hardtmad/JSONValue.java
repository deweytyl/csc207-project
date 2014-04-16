package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import org.json.simple.JSONArray;  
/**
 * An interface specifying a class which wraps a JSON type and Java object
 * representing a JSON value
 */
public interface JSONValue
{
  /**
   * Returns a character describing the type of the value contained within the
   * JSONValue object based on this table: String: 's' Number: 'n' Object: 'o'
   * Array: 'a' Constant: 'c'
   */

  /**
   * When looking at the JSONValue If the first character is: 
   * { - it is an object 
   * [ - it is an array 
   * " - it is a string 
   * t - it is a constant 
   * f - it is a constant 
   * n - it is a constant 
   * - - it is a number 
   * (any number 0-9) - it is a number
   */
  public char type (String str)
  {
    char objectType;
    char first = str.charAt(0); 
    switch(first) {
      case '"' :
        objectType = 's';
        break;
      case '{':
        objectType = 'o';
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

  /**
   * Get the wrapped object
   * 
   * @return obj the Java representation of the JSON value
   */
  public Object value();

}
