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

// Import the input/output library for file writing and util for scanners and other data structures
import java.io.*;
import java.util.*;

// BoxMaker
public class BoxMaker {

	// Function to return the SVG String that needs to be printed -- NOTE: currently does not account for thinkness of wood
	public static String getSVG(double length, double width, double height) {
		// Setup
		String ret = "<?xml version='1.0' encoding='us-ascii'?>\n"
						+ "<svg height=\"11.00in\" viewBox=\"0.0 0.0 17.0 11.0\" width=\"17.00in\" xmlns=\"http://www.w3.org/2000/svg\"\n"
						+ "xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
						+ "xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
						+ "xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n";

		/*// Base of the box
		ret += "<g id=\"base\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 0.25 0.25 h " + length + " v " + width + " h " + -length + " v " + -width + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
		ret += "</g>\n";

		// All four walls of the box (first two will be the length x height, last to will be the width x height (each pair parallel))
		ret += "<g id=\"wall1\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 5.5 0.25 h " + length + " v " + height + " h " + -length + " v " + -height + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
		ret += "</g>\n";
		ret += "<g id=\"wall2\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 10.75 0.25 h " + length + " v " + height + " h " + -length + " v " + -height + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
		ret += "</g>\n";

		ret += "<g id=\"wall3\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 0.25 5.5 h " + width + " v " + height + " h " + -width + " v " + -height + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
		ret += "</g>\n";
		ret += "<g id=\"wall4\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 5.5 5.5 h " + width + " v " + height + " h " + -width + " v " + -height + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
		ret += "</g>\n";

		// Lid of the box (for now same as base of the box)
		ret += "<g id=\"top\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 10.75 5.5 h " + length + " v " + width + " h " + -length + " v " + -width + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
		ret += "</g>\n" + "</svg>";*/
		
		//Prototype box with fingers
		
		double depth = 0.125;
		
		ret += "<g id=\"base\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 0.375 0.375 h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (width-(depth*2))/5 + " h " + depth + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5 + " h " + depth
			   + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5
			   + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + -(width-(depth*2))/5 + " h " + (-depth) + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5 + " h " + (-depth)
			   + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
		   ret += "</g>\n";

		// All four walls of the box (first two will be the length x height, last to will be the width x height (each pair parallel))
		ret += "<g id=\"wall1\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 5.625 0.25 h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5
			   + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5
			   + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
			   ret += "</g>\n";
			   
		ret += "<g id=\"wall2\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 10.875 0.25 h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5
			   + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5
			   + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
			   ret += "</g>\n";

		ret += "<g id=\"wall3\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 0.375 5.5 h " + (width-(depth*2))/5 + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5
			   + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(width-(depth*2))/5 + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5
			   + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
			   ret += "</g>\n";
			   
		ret += "<g id=\"wall4\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 5.625 5.5 h " + (width-(depth*2))/5 + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5
			   + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(width-(depth*2))/5 + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5
			   + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
			   ret += "</g>\n";

		// Lid of the box (for now same as base of the box)
		ret += "<g id=\"top\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 10.875 5.5 h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (width-(depth*2))/5 + " h " + depth + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5 + " h " + depth
			   + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5
			   + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + -(width-(depth*2))/5 + " h " + (-depth) + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5 + " h " + (-depth)
			   + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.001\" />\n";
		   ret += "</g>\n" + "</svg>";

		// Return the resulting String
		return ret;
	}

	// Function to prompt the user for a numeric (double) value -- used to specify dimensions
	public static double promptDimension(Scanner sc, double lowerbound, double upperbound, boolean display) {
		// Loop until valid response is given, store in "choice" to return
		double choice;
		while (true) {
			// Make sure a double is entered in their reply
			if (sc.hasNextDouble()) {
				// Get the double and make sure its in the specified bound
				choice = sc.nextDouble();
				String extra = "";
				extra = sc.nextLine();
				if (choice >= lowerbound && choice <= upperbound && extra.trim().equals("")) {
					break;
				}
				// If the double is not in the specified bound, display as such (when not testing)
				else if (display) {
					System.out.print("Please only a value within the requested bound: ");
				}
			}
			// If an double was not entered, display as such (when not testing)
			else {
				if (display) {
					System.out.print("Please enter a numeric value as a response: ");
				}
				sc.nextLine();
			}
		}
		return choice;
	}
	// By default display the prompt (only don't when testing)
	public static double promptDimension(Scanner sc, double lowerbound, double upperbound) {
		return promptDimension(sc, lowerbound, upperbound, true);
	}

	// Main method, what is run when the program is run
    public static void main(String[] args) {
    	// Scanner to control user input
    	Scanner sc = new Scanner(System.in);

    	/**************** Future: insert prompt for design selection ******************/

    	// Prompt for the length, width, and height dimensions to be used for the box
    	System.out.println("Enter the desired dimensions for your box (in inches), each within 2-5in:");
    	System.out.print("Length: ");
    	double length = promptDimension(sc, 2, 5);
    	System.out.print("Width: ");
    	double width = promptDimension(sc, 2, 5);
    	System.out.print("Height: ");
    	double height = promptDimension(sc, 2, 5);

    	// Display the chosen dimensions so the user can double check what they specified
    	System.out.println("Generating box with size: " + length + "in x " + width + "in x " + height + "in.");

		// Write the output String to an SVG file (catch any IOExceptions)
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.svg"));
			writer.write(getSVG(length, width, height));
			writer.close();
			System.out.println("Done");
		}
		// If we catch an IOException, print an error message
		catch (IOException e) {
			System.out.println("BoxMaker Error: IOExcpetion caught in writing to SVG output file.");
		}

    }
}
