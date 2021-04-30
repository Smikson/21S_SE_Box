/******************************************************************************
 *  Author : wdw17a Wyatt Witemeyer, cgg20a Christa Greenwood, mfs18a Megan Skeen
 *  Class  : CS374
 *  Task   : Box Project Testing - BoxMakerTest
 *
 *  Test: mvn test
 *
 *  This is the class that holds the tests for BoxMaker.java
 * 
 *  Tests that true is true
 *
 ******************************************************************************/

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;

import java.io.*;
import java.util.*;

// BoxMakerTest
public class BoxMakerTest {
    BoxMaker bm = new BoxMaker();
    
    // Some existing tests to make sure things are working
    @Test
    public void test_01_shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void test_02_blows_up() {
        new ArrayList<Object>().get(0);
    }

    // Tests for essential, static values in String
    @Test
    public void test_03_inString() {
		// Checks size of template with random length, width, and height values
    	assertTrue(bm.getSVG(2.0,2.0,2.0).contains("<svg height=\"11.00in\" viewBox=\"0.0 0.0 17.0 11.0\" width=\"17.00in\""));
    }

    @Test
    public void test_04_inString() {
		// Checks starting point for base path with random length, width, and height values
    	assertTrue(bm.getSVG(2.0,2.0,2.0).contains("<path d=\"M 0.375 0.375"));
    }
	
	@Test
    public void test_05_inString() {
    	// Checks starting point for wall1 path with random length, width, and height values
    	assertTrue(bm.getSVG(2.0,2.0,2.0).contains("<path d=\"M 5.625 0.25"));
    }
	
	@Test
    public void test_06_inString() {
    	// Checks starting point for wall2 path with random length, width, and height values
    	assertTrue(bm.getSVG(2.0,2.0,2.0).contains("<path d=\"M 10.875 0.25"));
    }
	
	@Test
    public void test_07_inString() {
    	// Checks starting point for wall3 path with random length, width, and height values
    	assertTrue(bm.getSVG(2.0,2.0,2.0).contains("<path d=\"M 0.375 5.5"));
    }
	
	@Test
    public void test_08_inString() {
    	// Checks starting point for wall4 path with random length, width, and height values
    	assertTrue(bm.getSVG(2.0,2.0,2.0).contains("<path d=\"M 5.625 5.5"));
    }
	
	@Test
    public void test_09_inString() {
    	// Checks starting point for top path with random length, width, and height values
    	assertTrue(bm.getSVG(2.0,2.0,2.0).contains("<path d=\"M 10.875 5.625"));
    }

    // Class Extra Unit Tests
    @Test
    public void test_10_unitTest() {
    	// Make sure we're moving somwhere in each path
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getSVG(2.0,2.0,2.0).split("\n");
    	boolean passed = true;
    	for (int i = 0; i < lines.length; i++) {
    		if (lines[i].contains("path d=")) {
    			// If we have a path, and we don't move, fail the test
    			if (!(lines[i].contains("M") || lines[i].contains("m"))) {
    				passed = false;
    			}
    		}
    	}
    	// See if the boolean stayed true
    	assertTrue(passed);
    }

    @Test
    public void test_11_unitTest() {
    	// Test if we are drawing 6 total sides, 6 paths
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getSVG(2.0,2.0,2.0).split("\n");
    	int pathCount = 0;
    	for (int i = 0; i < lines.length; i++) {
    		if (lines[i].contains("path d=")) {
    			pathCount++;
    		}
    	}
    	// Make sure we have 6 paths
    	assertEquals(pathCount, 6);
    }

    // Tests to check the user input function works as intended when using System.in for user input
    @Test
    public void test_12_userInput() {
    	// Test we return the correct dimension from user input (without printing the prompts)
    	String response = "3.7\n";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	Scanner sc = new Scanner(System.in);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 3.7, 0.0001); // It should be the same, use 0.0001 as precision check
    	sc.close();
    }

    @Test
    public void test_13_userInput() {
    	// Test that we are also accurate within the 0.0001 on unneccesarily long inputs
    	String response = "3.123456789123456789123456789\n";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	Scanner sc = new Scanner(System.in);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 3.123456789123456789123456789, 0.0001);
    	sc.close();
    }

    @Test
    public void test_14_userInput() {
    	// Test to make sure we still get the number regardless of white space
    	String response = "\t 7.5\n";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	Scanner sc = new Scanner(System.in);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 7.5, 0.0001);
    	sc.close();
    }

    @Test
    public void test_15_userInput() {
    	// If the user enters garbage before the number, it should not take it, instead prompting again (getting the second number)
    	String response = "garbage 3.7\n7.5\n";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	Scanner sc = new Scanner(System.in);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 7.5, 0.0001);
    	sc.close();
    }

    @Test
    public void test_16_userInput() {
    	// If the user enters garbage after the number, it should not take it, instead prompting again (getting the second number)
    	String response = "3.7 garbage\n7.5\n";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	Scanner sc = new Scanner(System.in);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 7.5, 0.0001);
    	sc.close();
    }

    // More tests for user input focusing on edge-case functionality
    @Test
    public void test_17_userInput() {
    	// If two numbers are entered on separate lines (even with whitespace, make sure we just get the first
    	String response = " \t3.7 \t\n \t7.5 \t\n";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	Scanner sc = new Scanner(System.in);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 3.7, 0.0001);
    	sc.close();
    }

    @Test
    public void test_18_userInput() {
    	// If two numbers are entered on the same line, the line is ignored, prompting again
    	String response = "3.7 7.5\n8.6\n";
    	Scanner sc = new Scanner(response);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 8.6, 0.0001);
    	sc.close();
    }

    @Test
    public void test_19_userInput() {
    	// If a number entered is below the range, the line is ignored, prompting again
    	String response = "2.7\n7.5\n";
    	Scanner sc = new Scanner(response);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 7.5, 0.0001);
    	sc.close();
    }

    @Test
    public void test_20_userInput() {
    	// If a number entered is above the range, the line is ignored, prompting again
    	String response = "11.7\n7.5\n";
    	Scanner sc = new Scanner(response);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 7.5, 0.0001);
    	sc.close();
    }

    @Test
    public void test_21_userInput() {
    	// Make sure we will continually prompt until a good value is entered
    	String response = "2.7\n11.7\ngar\nbage\ngarbage\n-17.9\n9999999.9999999\n3.7\n";
    	Scanner sc = new Scanner(response);
    	assertEquals(bm.promptDimension(sc, 3, 10, false), 3.7, 0.0001);
    	sc.close();
    }

    // Tests for the getSVG with specified length width and height values
   @Test
    public void test_22_inString() {
    	// Using 2.0 x 2.5 x 3.0 dimensions, check that the base of the box has the correct values
    	double length = 2.0;
    	double width = 2.5;
    	double height = 3.0;
		double depth = 0.125;
		assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 0.375 0.375 h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (width-(depth*2))/5 + " h " + depth + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5 + " h " + depth
			   + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5
			   + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + -(width-(depth*2))/5 + " h " + (-depth) + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5 + " h " + (-depth)
			   + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5
			   + "\""));
    }

    @Test
    public void test_23_inString() {
    	// Using 2.0 x 2.5 x 3.0 dimensions, check that wall1 on the length of the box has the correct values
    	double length = 2.0;
    	double width = 2.5;
    	double height = 3.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 5.625 0.25 h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5
			   + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5
			   + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\""));
    }

    @Test
    public void test_24_inString() {
    	// Using 2.0 x 2.5 x 3.0 dimensions, check that wall2 on the length of the box has the correct values
    	double length = 2.0;
    	double width = 2.5;
    	double height = 3.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 10.875 0.25 h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5
			   + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5
			   + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\""));
    }

    @Test
    public void test_25_inString() {
    	// Using 2.0 x 2.5 x 3.0 dimensions, check that wall3 of the width of the box has the correct values
    	double length = 2.0;
    	double width = 2.5;
    	double height = 3.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 0.375 5.5 h " + (width-(depth*2))/5 + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5
			   + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(width-(depth*2))/5 + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5
			   + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\""));
    }

    @Test
    public void test_26_inString() {
    	// Using 2.0 x 2.5 x 3.0 dimensions, check that wall4 of the width of the box has the correct values
    	double length = 2.0;
    	double width = 2.5;
    	double height = 3.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 5.625 5.5 h " + (width-(depth*2))/5 + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5
			   + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(width-(depth*2))/5 + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5
			   + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\""));
    }

    @Test
    public void test_27_inString() {
    	// Using 2.0 x 2.5 x 3.0 dimensions, check that the top of the box has the correct values
    	double length = 2.0;
    	double width = 2.5;
    	double height = 3.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 10.875 5.625 h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (width-(depth*2))/5 + " h " + depth + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5 + " h " + depth
			   + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5
			   + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + -(width-(depth*2))/5 + " h " + (-depth) + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5 + " h " + (-depth)
			   + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5
			   + "\""));
    }

    // Make sure to doesn't just work with 2, 2.5, and 3. Test a second set of values
    @Test
    public void test_28_inString() {
    	// Using 3.7 x 4.25 x 5.0 dimensions, check that the base of the box has the correct values
    	double length = 3.7;
    	double width = 4.25;
    	double height = 5.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 0.375 0.375 h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (width-(depth*2))/5 + " h " + depth + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5 + " h " + depth
			   + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5
			   + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + -(width-(depth*2))/5 + " h " + (-depth) + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5 + " h " + (-depth)
			   + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5
			   + "\""));
    }

    @Test
    public void test_29_inString() {
    	// Using 3.7 x 4.25 x 5.0 dimensions, check that wall1 on the length of the box has the correct values
    	double length = 3.7;
    	double width = 4.25;
    	double height = 5.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 5.625 0.25 h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5
			   + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5
			   + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\""));
    }

    @Test
    public void test_30_inString() {
    	// Using 3.7 x 4.25 x 5.0 dimensions, check that wall2 on the length of the box has the correct values
    	double length = 3.7;
    	double width = 4.25;
    	double height = 5.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 10.875 0.25 h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5
			   + " v " + depth + " h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5
			   + " v " + (-depth) + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\""));
    }

    @Test
    public void test_31_inString() {
    	// Using 3.7 x 4.25 x 5.0 dimensions, check that wall3 of the width of the box has the correct values
    	double length = 3.7;
    	double width = 4.25;
    	double height = 5.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 0.375 5.5 h " + (width-(depth*2))/5 + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5
			   + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(width-(depth*2))/5 + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5
			   + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\""));
    }

    @Test
    public void test_32_inString() {
    	// Using 3.7 x 4.25 x 5.0 dimensions, check that wall4 of the width of the box has the correct values
    	double length = 3.7;
    	double width = 4.25;
    	double height = 5.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 5.625 5.5 h " + (width-(depth*2))/5 + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5
			   + " v " + depth + " h " + (width-(depth*2))/5 + " v " + (-depth) + " h " + (width-(depth*2))/5 + depth
			   + " v " + height/6 + " h " + (-depth) + " v " + height/6 + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6 
			   + " h " + depth + " v " + height/6 + " h " + (-depth) + " v " + height/6
			   + " h " + -(width-(depth*2))/5 + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5
			   + " v " + (-depth) + " h " + -(width-(depth*2))/5 + " v " + depth + " h " + -(width-(depth*2))/5 + (-depth)
			   + " v " + (-height/6) + " h " + depth + " v " + (-height/6) + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6) 
			   + " h " + (-depth) + " v " + (-height/6) + " h " + depth + " v " + (-height/6)
			   + "\""));
    }

    @Test
    public void test_33_inString() {
    	// Using 3.7 x 4.25 x 5.0 dimensions, check that the top of the box has the correct values
    	double length = 3.7;
    	double width = 4.25;
    	double height = 5.0;
		double depth = 0.125;
    	assertTrue(bm.getSVG(length, width, height).contains("path d=\"M 10.875 5.625 h " + (length-(depth*2))/5 + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (-depth) + " h " + (length-(depth*2))/5 + " v " + depth + " h " + (length-(depth*2))/5
			   + " v " + (width-(depth*2))/5 + " h " + depth + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5 + " h " + depth
			   + " v " + (width-(depth*2))/5 + " h " + (-depth) + " v " + (width-(depth*2))/5
			   + " h " + -(length-(depth*2))/5 + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + depth + " h " + -(length-(depth*2))/5 + " v " + (-depth) + " h " + -(length-(depth*2))/5
			   + " v " + -(width-(depth*2))/5 + " h " + (-depth) + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5 + " h " + (-depth)
			   + " v " + -(width-(depth*2))/5 + " h " + depth + " v " + -(width-(depth*2))/5
			   + "\""));
    }

    // Tests to make sure our stroke width is correct for each side of the box
    @Test
    public void test_34_inString() {
    	// Test if the base has the correct stroke width
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getSVG(2.0,2.0,2.0).split("\n");
    	boolean passed = false;
    	for (int i = 0; i < lines.length; i++) {
    		// If it is the base, make sure its stroke length is 0.0000138889, the number of inches in 0.001pt (required for laser to cut)
    		if (lines[i].contains("path d=\"M 0.375 0.375")) {
    			passed = lines[i].contains("stroke-width=\"0.0000138889\"");
    		}
    	}
    	// Make sure we passed
    	assertTrue(passed);
    }

    @Test
    public void test_35_inString() {
    	// Test if wall1 has the correct stroke width
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getSVG(2.0,2.0,2.0).split("\n");
    	boolean passed = false;
    	for (int i = 0; i < lines.length; i++) {
    		// If it is the wall1, make sure its stroke length is 0.0000138889, the number of inches in 0.001pt (required for laser to cut)
    		if (lines[i].contains("path d=\"M 5.625 0.25")) {
    			passed = lines[i].contains("stroke-width=\"0.0000138889\"");
    		}
    	}
    	// Make sure we passed
    	assertTrue(passed);
    }

    @Test
    public void test_36_inString() {
    	// Test if wall2 has the correct stroke width
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getSVG(2.0,2.0,2.0).split("\n");
    	boolean passed = false;
    	for (int i = 0; i < lines.length; i++) {
    		// If it is the wall2, make sure its stroke length is 0.0000138889, the number of inches in 0.001pt (required for laser to cut)
    		if (lines[i].contains("path d=\"M 10.875 0.25")) {
    			passed = lines[i].contains("stroke-width=\"0.0000138889\"");
    		}
    	}
    	// Make sure we passed
    	assertTrue(passed);
    }

    @Test
    public void test_37_inString() {
    	// Test if wall3 has the correct stroke width
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getSVG(2.0,2.0,2.0).split("\n");
    	boolean passed = false;
    	for (int i = 0; i < lines.length; i++) {
    		// If it is the wall3, make sure its stroke length is 0.0000138889, the number of inches in 0.001pt (required for laser to cut)
    		if (lines[i].contains("path d=\"M 0.375 5.5")) {
    			passed = lines[i].contains("stroke-width=\"0.0000138889\"");
    		}
    	}
    	// Make sure we passed
    	assertTrue(passed);
    }

    @Test
    public void test_38_inString() {
    	// Test if wall4 has the correct stroke width
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getSVG(2.0,2.0,2.0).split("\n");
    	boolean passed = false;
    	for (int i = 0; i < lines.length; i++) {
    		// If it is the wall4, make sure its stroke length is 0.0000138889, the number of inches in 0.001pt (required for laser to cut)
    		if (lines[i].contains("path d=\"M 5.625 5.5")) {
    			passed = lines[i].contains("stroke-width=\"0.0000138889\"");
    		}
    	}
    	// Make sure we passed
    	assertTrue(passed);
    }

    @Test
    public void test_39_inString() {
    	// Test if the top of the box has the correct stroke width
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getSVG(2.0,2.0,2.0).split("\n");
    	boolean passed = false;
    	for (int i = 0; i < lines.length; i++) {
    		// If it is the top, make sure its stroke length is 0.0000138889, the number of inches in 0.001pt (required for laser to cut)
    		if (lines[i].contains("path d=\"M 10.875 5.625")) {
    			passed = lines[i].contains("stroke-width=\"0.0000138889\"");
    		}
    	}
    	// Make sure we passed
    	assertTrue(passed);
    }

    // Five more tests to check the pompt for inserts function works as intended
    @Test
    public void test_40_userInput() {
    	// Test we return true when the user's response is Y (without printing the prompts)
    	String response = "Y";
    	Scanner sc = new Scanner(response);
    	assertTrue(bm.promptInserts(sc, false));
    }

    @Test
    public void test_41_userInput() {
    	// Test we return false when the user's response is N
    	String response = "N";
    	Scanner sc = new Scanner(response);
    	assertTrue(!bm.promptInserts(sc, false));
    }

    @Test
    public void test_42_userInput() {
    	// Test we return true when the user's response is garbage for two lines then Y
    	String response = "gar\nbage\nY";
    	Scanner sc = new Scanner(response);
    	assertTrue(bm.promptInserts(sc, false));
    }

    @Test
    public void test_43_userInput() {
    	// Test we return false when the user's response is garbage for two lines then N
    	String response = "gar\nbage\nN";
    	Scanner sc = new Scanner(response);
    	assertTrue(!bm.promptInserts(sc, false));
    }

    @Test
    public void test_44_userInput() {
    	// Test we return true when the user's response is lowercase y
    	String response = "y";
    	Scanner sc = new Scanner(response);
    	assertTrue(bm.promptInserts(sc, false));
    }

    // Tests for inserts SVG
    @Test
    public void test_45_inInsertSVG() {
    	// Make sure the regular version of the inserts has the correct setup
    	assertTrue(bm.getInsertSVG(3, 4, 5, 2, 2).contains("<svg height=\"11.00in\" viewBox=\"0.0 0.0 23.0 11.0\" width=\"23.00in\" xmlns=\"http://www.w3.org/2000/svg\"\n"));
    }

    @Test
    public void test_46_inInsertSVG() {
    	// Make sure the inserts have the correct number of paths
    	int rows = 2;
    	int cols = 2;
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getInsertSVG(2.0,2.0,2.0, rows, cols).split("\n");
    	int pathCount = 0;
    	for (int i = 0; i < lines.length; i++) {
    		if (lines[i].contains("path d=")) {
    			pathCount++;
    		}
    	}
    	// Make sure we have (rows-1) + (cols-1) paths
    	assertEquals(pathCount, (rows-1) + (cols-1));
    }

    @Test
    public void test_47_inInsertSVG() {
    	// Make sure the inserts have the correct number of paths with different rows/cols values
    	int rows = 3;
    	int cols = 4;
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getInsertSVG(2.0,2.0,2.0, rows, cols).split("\n");
    	int pathCount = 0;
    	for (int i = 0; i < lines.length; i++) {
    		if (lines[i].contains("path d=")) {
    			pathCount++;
    		}
    	}
    	// Make sure we have (rows-1) + (cols-1) paths
    	assertEquals(pathCount, (rows-1) + (cols-1));
    }

    @Test
    public void test_48_inInsertSVG() {
    	// Make sure the inserts have the correct number of paths with different rows/cols values
    	int rows = 7;
    	int cols = 10;
    	String lines[];
		// Inputs random length, width, and height values
    	lines = bm.getInsertSVG(2.0,2.0,2.0, rows, cols).split("\n");
    	int pathCount = 0;
    	for (int i = 0; i < lines.length; i++) {
    		if (lines[i].contains("path d=")) {
    			pathCount++;
    		}
    	}
    	// Make sure we have (rows-1) + (cols-1) paths
    	assertEquals(pathCount, (rows-1) + (cols-1));
    }

    // Tests for the new integer user input (used for the inserts SVG)
    @Test
    public void test_49_userIntInput() {
    	// If a number entered is above the range, the line is ignored, prompting again
    	String response = "11\n7\n";
    	Scanner sc = new Scanner(response);
    	assertEquals(bm.promptInteger(sc, 3, 10, false), 7);
    	sc.close();
    }

    @Test
    public void test_50_userIntInput() {
    	// Make sure we will continually prompt until a good value is entered
    	String response = "2\n11\ngar\nbage\ngarbage\n-17\n9999999\n3\n";
    	Scanner sc = new Scanner(response);
    	assertEquals(bm.promptInteger(sc, 3, 10, false), 3);
    	sc.close();
    }
}