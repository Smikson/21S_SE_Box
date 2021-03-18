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

    // Five more tests to check the new user input function works as intended
    @Test
    public void test_12_userInput() {
    	// Test we return true when the user's response is Y (without printing the prompts)
    	String response = "Y";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	assertTrue(bm.filePrompt(false));
    }

    @Test
    public void test_13_userInput() {
    	// Test we return false when the user's response is N
    	String response = "N";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	assertTrue(!bm.filePrompt(false));
    }

    @Test
    public void test_14_userInput() {
    	// Test we return true when the user's response is garbage for two lines then Y
    	String response = "gar\nbage\nY";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	assertTrue(bm.filePrompt(false));
    }

    @Test
    public void test_15_userInput() {
    	// Test we return false when the user's response is garbage for two lines then N
    	String response = "gar\nbage\nN";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	assertTrue(!bm.filePrompt(false));
    }

    @Test
    public void test_16_userInput() {
    	// Test we return true when the user's response is lowercase y
    	String response = "y";
    	System.setIn(new ByteArrayInputStream(response.getBytes()));
    	assertTrue(bm.filePrompt(false));
    }
}