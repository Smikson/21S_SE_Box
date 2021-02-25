/******************************************************************************
 *  Authors : wdw17a Wyatt Witemeyer, cgg20a Christa Greenwood, mfs18a Megan Skeen 
 *  Class  : CS374
 *  Task   : Box Project - BoxMaker
 *
 *  Compile: javac BoxMaker.java
 *  Run: java BoxMaker
 *
 *  Prints SVG line that will draw the components of a box to cut.
 *
 *  
 *
 ******************************************************************************/

// Import the input/output library for file writing
import java.io.*;

// BoxMaker
public class BoxMaker {

	public static final String theString = "<?xml version='1.0' encoding='us-ascii'?>\n"
						+ "<svg height=\"81.90mm\" viewBox=\"0.0 0.0 120.10 81.90\" width=\"120.10mm\" xmlns=\"http://www.w3.org/2000/svg\"\n"
						+ "xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
						+ "xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
						+ "xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n"
						+ "<g id=\"square1\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n"
						+ "<path d=\"M 40.0 10.0 h 20.0 v 20.0 h -20.0 v -20.0\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.20\" />\n"
						+ "</g>\n"
						+ "<g id=\"square2\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n"
						+ "<path d=\"M 65.0 10.0 h 20.0 v 20.0 h -20.0 v -20.0\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.20\" />\n"
						+ "</g>\n"
						+ "<g id=\"square3\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n"
						+ "<path d=\"M 90.0 10.0 h 20.0 v 20.0 h -20.0 v -20.0\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.20\" />\n"
						+ "</g>\n"
						+ "<g id=\"square4\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n"
						+ "<path d=\"M 40.0 40.0 h 20.0 v 20.0 h -20.0 v -20.0\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.20\" />\n"
						+ "</g>\n"
						+ "<g id=\"square5\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n"
						+ "<path d=\"M 65.0 40.0 h 20.0 v 20.0 h -20.0 v -20.0\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.20\" />\n"
						+ "</g>\n"
						+ "<g id=\"square6\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n"
						+ "<path d=\"M 90.0 40.0 h 20.0 v 20.0 h -20.0 v -20.0\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.20\" />\n"
						+ "</g>\n"
						+ "</svg>";

    public static void main(String[] args) {
    	// Write the output String to an SVG file (catch any IOExceptions)
    	try {
    		BufferedWriter writer = new BufferedWriter(new FileWriter("output.svg"));
			writer.write(theString);
			writer.close();
		}
		// If we catch an IOException, print an error message
    	catch (IOException e) {
			System.out.println("BoxMaker Error: IOExcpetion caught in writing to SVG output file.");
		}
    }
}
