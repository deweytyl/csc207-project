package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

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
  public char type();

  /**
   * Get the wrapped object
   * 
   * @return obj the Java representation of the JSON value
   */
  public Object value();
}
