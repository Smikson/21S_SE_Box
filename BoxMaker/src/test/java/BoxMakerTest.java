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

    // Tests to check that the String contains our strict paths
    @Test
    public void test_03_inString() {
    	assertTrue(bm.getSVG().contains("<svg height=\"81.90mm\" viewBox=\"0.0 0.0 120.10 81.90\" width=\"120.10mm\""));
    }

    @Test
    public void test_04_inString() {
    	assertTrue(bm.getSVG().contains("path d=\"M 40.0 10.0 h 20.0 v 20.0 h -20.0 v -20.0\""));
    }
	
	@Test
    public void test_05_inString() {
    	assertTrue(bm.getSVG().contains("path d=\"M 65.0 10.0 h 20.0 v 20.0 h -20.0 v -20.0\""));
    }
	
	@Test
    public void test_06_inString() {
    	assertTrue(bm.getSVG().contains("path d=\"M 90.0 10.0 h 20.0 v 20.0 h -20.0 v -20.0\""));
    }
	
	@Test
    public void test_07_inString() {
    	assertTrue(bm.getSVG().contains("path d=\"M 40.0 40.0 h 20.0 v 20.0 h -20.0 v -20.0\""));
    }
	
	@Test
    public void test_08_inString() {
    	assertTrue(bm.getSVG().contains("path d=\"M 65.0 40.0 h 20.0 v 20.0 h -20.0 v -20.0\""));
    }
	
	@Test
    public void test_09_inString() {
    	assertTrue(bm.getSVG().contains("path d=\"M 90.0 40.0 h 20.0 v 20.0 h -20.0 v -20.0\""));
    }

    // Class Extra Unit Tests
    @Test
    public void test_10_unitTest() {
    	// Make sure we're moving somwhere in each path
    	String lines[];
    	lines = bm.getSVG().split("\n");
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
    	lines = bm.getSVG().split("\n");
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
}