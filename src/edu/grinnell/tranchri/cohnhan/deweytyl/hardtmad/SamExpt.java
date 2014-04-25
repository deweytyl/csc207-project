package edu.grinnell.tranchri.cohnhan.deweytyl.hardtmad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * A simple interactive experiment.  Reads a JSON string, parses it,
 * and then prints it out in multiple ways.
 *
 * @author Samuel A. Rebelsky
 */
public class SamExpt
{
  public static void main(String[] args)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
    
    while (true)
      {
        pen.print("Enter JSON: ");
        pen.flush();
        JSONValue thing = JSONUtils.parseValue(eyes.readLine());
        pen.println("toString(): " + thing.toString());
        pen.println("toJSONString(): " + thing.toJSONData());
      }
  } // main(String[])
} // SamExpt
