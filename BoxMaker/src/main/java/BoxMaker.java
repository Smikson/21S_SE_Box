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

	// Function to return the SVG String that needs to be printed
	public static String getSVG(double length, double width, double height) {
		// If a single dimension is above 5 inches, use the relative SVG
		if (length > 5 || width > 5 || height > 5) {
			return getRelativeSVG(length, width, height);
		}

		// Setup
		String ret = "<?xml version='1.0' encoding='us-ascii'?>\n"
						+ "<svg height=\"11.00in\" viewBox=\"0.0 0.0 17.0 11.0\" width=\"17.00in\" xmlns=\"http://www.w3.org/2000/svg\"\n"
						+ "xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
						+ "xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
						+ "xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n";
		
		// Prototype box with fingers
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
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
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
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
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
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
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
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
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
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
			   ret += "</g>\n";

		// Lid of the box (for now same as base of the box)
		ret += "<g id=\"top\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M 10.875 5.625 h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (width-(depth*2))/5 + " h " + depth + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5 + " h " + depth
			   + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5
			   + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + -(width-(depth*2))/5 + " h " + (-depth) + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5 + " h " + (-depth)
			   + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
		   ret += "</g>\n" + "</svg>";

		// Return the resulting String
		return ret;
	}

	// Function to return the SVG String that needs to be printed when above 5 inches -- relative spacing
	public static String getRelativeSVG(double length, double width, double height) {
		
		// Setup
		String ret = "<?xml version='1.0' encoding='us-ascii'?>\n"
						+ "<svg height=\"55.00in\" viewBox=\"0.0 0.0 85.0 55.0\" width=\"85.00in\" xmlns=\"http://www.w3.org/2000/svg\"\n"
						+ "xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
						+ "xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
						+ "xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n";
		
		// Prototype box with fingers
		double depth = 0.125;
		double x = 0.375;
		double y = 0.375;
		
		ret += "<g id=\"base\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M " + x + " " + y + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (width-(depth*2))/5 + " h " + depth + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5 + " h " + depth
			   + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5
			   + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + -(width-(depth*2))/5 + " h " + (-depth) + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5 + " h " + (-depth)
			   + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
			   ret += "</g>\n";

		// All four walls of the box (first two will be the length x height, last to will be the width x height (each pair parallel))
		x += length + 0.5;
		y = 0.25;
		ret += "<g id=\"wall1\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M " + x + " " + y + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5
			   + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5
			   + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
			   ret += "</g>\n";
		
		x += length + 0.5;
		ret += "<g id=\"wall2\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M " + x + " " + y + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5
			   + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5
			   + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
			   ret += "</g>\n";

		x = 0.375;
		y = 0.25 + (width > height? width : height) + 0.5;
		ret += "<g id=\"wall3\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M " + x + " " + y + " h " + (width-(depth*2))/5 + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5
			   + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(width-(depth*2))/5 + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5
			   + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
			   ret += "</g>\n";
		
		x += width + 0.5;
		ret += "<g id=\"wall4\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M " + x + " " + y + " h " + (width-(depth*2))/5 + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5
			   + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(width-(depth*2))/5 + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5
			   + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
			   ret += "</g>\n";

		// Lid of the box (for now same as base of the box)
		x += width + 0.5;
		y = 0.375 + (width > height? width : height) + 0.5;
		ret += "<g id=\"top\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
		ret += "<path d=\"M " + x + " " + y + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (width-(depth*2))/5 + " h " + depth + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5 + " h " + depth
			   + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5
			   + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + -(width-(depth*2))/5 + " h " + (-depth) + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5 + " h " + (-depth)
			   + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5
			   + "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
		   	   ret += "</g>\n" + "</svg>";

		// Return the resulting String
		return ret;
	}
	
	// Function to return the SVG String with the box inserts that need to be printed.
	public static String getInsertSVG(double length, double width, double height, double rows, double columns) {
		
		// Setup
		double depth = 0.125;
		double widthInserts = columns-1;
		double lengthInserts = rows-1;
		double xPoint = 0.25;
		double yPoint = 0.25;
		
		String ret = "<?xml version='1.0' encoding='us-ascii'?>\n";
						
		// If a single dimension is above 5 inches, use the large SVG template
		if (length > 5 || width > 5 || height > 5) {
			ret += "<svg height=\"55.00in\" viewBox=\"0.0 0.0 85.0 55.0\" width=\"85.00in\" xmlns=\"http://www.w3.org/2000/svg\"\n"
						+ "xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
						+ "xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
						+ "xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n";
		}
		else{
			ret += "<svg height=\"11.00in\" viewBox=\"0.0 0.0 23.0 11.0\" width=\"23.00in\" xmlns=\"http://www.w3.org/2000/svg\"\n"
						+ "xmlns:cc=\"http://creativecommons.org/ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
						+ "xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
						+ "xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n";
		}

		// Inserts to make columns
		for (int w=1; w<columns; w++)
		{
			ret += "<g id=\"base\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
			ret += "<path d=\"M " + xPoint + " " + yPoint + " h " + (width-(depth*2)) + " v " + (height-(depth*2));
			
			for (int i=1; i<rows; i++)
			{
				ret += " h " + -((width-(depth*2)-(lengthInserts*depth))/rows)
					+ " v " + -((height-(depth*2))/2) + " h " + -depth + " v " + ((height-(depth*2))/2);
			}
		    
			ret += " h " + -((width-(depth*2)-(lengthInserts*depth))/rows) + " v " + -(height-(depth*2))
				+ "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
			ret += "</g>\n";
			
			xPoint += width+0.25;
		}

		xPoint = 0.25;
		yPoint = height+0.5;

		// Inserts to make rows
		for (int l=1; l<rows; l++)
		{
			// Length insert
			ret += "<g id=\"base\" style=\"fill:none;stroke-linecap:round;stroke-linejoin:round;\">\n";
			ret += "<path d=\"M " + xPoint + " " + yPoint;
			
			for (int i=1; i<columns; i++)
			{
				ret += " h " + ((length-(depth*2)-(widthInserts*depth))/columns)
					+ " v " + ((height-(depth*2))/2) + " h " + depth + " v " + -((height-(depth*2))/2);
			}
				
			ret += " h " + ((length-(depth*2)-(widthInserts*depth))/columns) + " v " + (height-(depth*2))
				+ " h " + -(length-(depth*2)) + " v " + -(height-(depth*2))
				+ "\" stroke=\"rgb(0,0,0)\" stroke-width=\"0.0000138889\" />\n";
			ret += "</g>\n";
			
			xPoint += length+0.25;
		}
	
		ret += "</svg>";

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

	// Function to prompt the user for an int value -- used to specify number of rows/cols for inserts
	public static int promptInteger(Scanner sc, int lowerbound, int upperbound, boolean display) {
		// Loop until valid response is given, store in "choice" to return
		int choice;
		while (true) {
			// Make sure an int is entered in their reply
			if (sc.hasNextInt()) {
				// Get the int and make sure its in the specified bound
				choice = sc.nextInt();
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
					System.out.print("Please enter an integer value as a response: ");
				}
				sc.nextLine();
			}
		}
		return choice;
	}
	// By default display the prompt (only don't when testing)
	public static int promptInteger(Scanner sc, int lowerbound, int upperbound) {
		return promptInteger(sc, lowerbound, upperbound, true);
	}

	// Function to prompt the user if they want box inserts
	public static boolean promptInserts(Scanner sc, boolean display) {
		// Loop until Y or N is entered
		while (true) {
			// Get the response, upper case it so it doesn't matter if entered as lower or upper
			if (display) {
				System.out.print("Response: ");
			}
			String response = sc.nextLine().toUpperCase();

			// If yes, return true
			if (response.equals("Y")) {
				return true;
			}
			// If no, return false
			else if (response.equals("N")) {
				return false;
			}
			// Otherwise, it is an invalid response, get the prompt again
			else {
				if (display) {
					System.out.println("Invalid response. Please respond with only \"Y\" or \"N\"");
				}
			}
		}
	}
	// By default display the prompt (only don't when testing)
	public static boolean promptInserts(Scanner sc) {
		return promptInserts(sc, true);
	}

	// Main method, what is run when the program is run
    public static void main(String[] args) {
    	// Scanner to control user input
    	Scanner sc = new Scanner(System.in);

    	// Prompt for the length, width, and height dimensions to be used for the box
    	System.out.println("Enter the desired dimensions for your box (in inches), each within 2-25in:");
    	System.out.print("Length: ");
    	double length = promptDimension(sc, 2, 25);
    	System.out.print("Width: ");
    	double width = promptDimension(sc, 2, 25);
    	System.out.print("Height: ");
    	double height = promptDimension(sc, 2, 25);

    	// Prompt the user for if they want box inserts
		System.out.println("Do you want inserts (will show up in inserts.svg)? [Y/N]");
		boolean inserts = promptInserts(sc);

		double insertHeight = 0;
		double rows = 0;
		double cols = 0;
		if (inserts) {
			// Prompt for the insert height desired
			System.out.println("What height would you like the inserts to be? 1-"+height+"in:");
			System.out.print("Insert Height: ");
			insertHeight = promptDimension(sc, 1, height);

			// Prompt for the number of rows
			System.out.println("How many rows of sections do you want? 1-5:");
			System.out.print("Rows: ");
			rows = promptInteger(sc, 1, 5);

			// Prompt for the number of columns
			System.out.println("How many columns of sections do you want? 1-5:");
			System.out.print("Columns: ");
			cols = promptInteger(sc, 1, 5);
		}

    	// Display the chosen dimensions so the user can double check what they specified
    	System.out.println("Generating box with size: " + length + "in x " + width + "in x " + height + "in.");
    	if (inserts) {
    		System.out.println("Additionally generating " + insertHeight + "in tall inserts to create " + rows + " x " + cols + " sections in the box.");
    	}

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
		
		// Write the insert String to a new SVG files (catch any IOExceptions)
		try {
			BufferedWriter written = new BufferedWriter(new FileWriter("insert.svg"));
			written.write(getInsertSVG(length, width, insertHeight, rows, cols));
			written.close();
			System.out.println("Done");
		}
		// If we catch an IOException, print an error message
		catch (IOException e) {
			System.out.println("BoxMaker Error: IOExcpetion caught in writing to SVG output file.");	
		}

    }
}
