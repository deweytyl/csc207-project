package edu.grinnell.mhctd.json;

/**
 * An interface specifying a class which wraps a JSON type and Java object
 * representing a JSON value
 * 
 * @author Hannah Cohn
 * @author Ty Dewey
 * @author Madeleine Hardt
 * @author Christine Tran
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
  public char type (); 

  /**
   * Get the wrapped object
   * 
   * @return obj the Java representation of the JSON value
   */
  public Object value();
  
  /**
   * 
   * @return str, a JSON representation of this object.
   */
  public String toJSONData();

} // interface JSONValue
