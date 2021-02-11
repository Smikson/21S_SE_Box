/******************************************************************************
 *  Author : wdw17a Wyatt Witemeyer, cgg20a Christa Greenwood, 
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

import java.util.ArrayList;

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

    @Test
    public void test_03_inString() {
    	assertTrue(bm.theString.contains("M 40.0 10.0"));
    }
	
	@Test
    public void test_04_inString() {
    	assertTrue(bm.theString.contains("M 65.0 10.0"));
    }
	
	@Test
    public void test_05_inString() {
    	assertTrue(bm.theString.contains("M 90.0 10.0"));
    }
	
	@Test
    public void test_06_inString() {
    	assertTrue(bm.theString.contains("M 40.0 40.0"));
    }
	
	@Test
    public void test_07_inString() {
    	assertTrue(bm.theString.contains("M 65.0 40.0"));
    }
	
	@Test
    public void test_08_inString() {
    	assertTrue(bm.theString.contains("M 90.0 40.0"));
    }
}
