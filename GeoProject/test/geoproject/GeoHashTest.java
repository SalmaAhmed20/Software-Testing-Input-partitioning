
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoproject;

import geoproject.Coverage;
import geoproject.CoverageLongs;
import geoproject.Direction;
import geoproject.GeoHash;
import geoproject.LatLong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.*;
import org.junit.rules.ErrorCollector;
import static org.junit.Assert.*;

/**
 * @author KGJQ6312
 */
public class GeoHashTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    public GeoHashTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of adjacentHash method, of class GeoHash.
     */
    @Test
    public void testAdjacentHash_String_Direction() {

        System.out.println("Base test case adjacentHash");
        String hash = "gbs5";
        Direction direction = Direction.BOTTOM;
        String expResult = "gbs4";
        String result = GeoHash.adjacentHash(hash, direction);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("adjacentHash-Test-1 -alphanumeric - change direction to LEFT");
        direction = Direction.LEFT;
        expResult = "gbeg";
        result = GeoHash.adjacentHash(hash, direction);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("adjacentHash-Test-2 -alphanumeric - change direction to RIGHT");
        direction = Direction.RIGHT;
        expResult = "gbs7";
        result = GeoHash.adjacentHash(hash, direction);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("adjacentHash-Test-3 -alphanumeric - change direction to TOP");
        direction = Direction.TOP;
        expResult = "gbsh";
        result = GeoHash.adjacentHash(hash, direction);
        System.out.println(result);
        assertEquals(expResult, result);
        try {
            System.out.println("------------------------------");
            System.out.println("adjacentHash-Test 4--->special characters -bottom");
            hash = "/s*d@";
            direction = Direction.BOTTOM;
            expResult = "s9";
            result = GeoHash.adjacentHash(hash, direction);
            System.out.println(result);
            assertEquals(result, expResult);
        } catch (Throwable t) {
            System.out.println("Error Special");
            collector.addError(t);
            // do something
        }

        System.out.println("------------------------------");
        System.out.println("adjacentHash-Test-2 - numeric characters - bottom");
        hash = "555";
        direction = Direction.BOTTOM;
        expResult = "54g";
        result = GeoHash.adjacentHash(hash, direction);
        System.out.println(result);
        assertEquals(expResult, result);
        try {
            System.out.println("------------------------------");
            System.out.println("adjacentHash-Test-3-empty -bottom");
            hash = "";
            expResult = "";
            result = GeoHash.adjacentHash(hash, direction);
            System.out.println(result);
            assertNull(result);
        } catch (Throwable t) {
            System.out.println("Error Empty");
            collector.addError(t);
            // do something
        }
        try {
            System.out.println("------------------------------");
            System.out.println("adjacentHash-Test-4 space separated -bottom ");
            hash = "55 5";
            direction = Direction.BOTTOM;
            expResult = "54g";
            result = GeoHash.adjacentHash(hash, direction);
            System.out.println(result);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error  space separated");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        System.out.println("adjacentHash-Test-5 - all lower character-bottom");
        hash = "hehe";
        direction = Direction.BOTTOM;
        expResult = "hehd";
        result = GeoHash.adjacentHash(hash, direction);
        System.out.println(result);
        assertEquals(expResult, result);
        try {

            System.out.println("------------------------------");
            System.out.println("adjacentHash-Test-6 -all upper character-bottom");
            hash = "HEHE";
            direction = Direction.BOTTOM;
            expResult = "hehd";
            result = GeoHash.adjacentHash(hash, direction);
            System.out.println(result);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error All Upper");
            collector.addError(t);
            // do something
        }

    }

    @Test
    public void testAdjacentHash_3args() {
        String hash = "gbs5";
        Direction direction = Direction.BOTTOM;
        String expResult = "gbs4";
        System.out.println("Base test case adjacentHashStep");
        int step = 1;
        String result = GeoHash.adjacentHash(hash, direction, step);
        System.out.println(result);
        assertEquals(expResult, result);

        System.out.println("------------------------------");
        System.out.println("adjacentHashStep-Test-1 -alphanumeric - change direction to LEFT - Step 1");
        direction = Direction.LEFT;
        expResult = "gbeg";
        step = 1;
        result = GeoHash.adjacentHash(hash, direction, step);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("adjacentHashStep-Test-2 -alphanumeric - change direction to RIGHT - Step 1");
        direction = Direction.RIGHT;
        expResult = "gbs7";
        step = 1;
        result = GeoHash.adjacentHash(hash, direction, step);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("adjacentHashStep-Test-3 -alphanumeric - change direction to TOP - Step 1");
        direction = Direction.TOP;
        expResult = "gbsh";
        step = 1;
        result = GeoHash.adjacentHash(hash, direction, step);
        System.out.println(result);
        assertEquals(expResult, result);
        try {
            System.out.println("------------------------------");
            System.out.println("adjacentHashStep-Test-4--->special characters -bottom - Step 1");
            hash = "/s*d@";
            direction = Direction.BOTTOM;
            expResult = "s9";
            step = 1;
            result = GeoHash.adjacentHash(hash, direction, step);
            System.out.println(result);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error Special");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        hash = "555";
        direction = Direction.BOTTOM;
        expResult = "54g";
        result = GeoHash.adjacentHash(hash, direction);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("adjacentHashStep-Test-2 - numeric characters - bottom- Step 1");
        step = 1;
        result = GeoHash.adjacentHash(hash, direction, step);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("adjacentHashStep-Test-3-empty -bottom- Step 1");
            hash = "";
            direction = Direction.BOTTOM;
            expResult = "";
            step = 1;
            result = GeoHash.adjacentHash(hash, direction, step);
            System.out.println(result);
            assertEquals(expResult, result);
            System.out.println("------------------------------");
        } catch (Throwable t) {
            System.out.println("Error Empty");
            collector.addError(t);
            // do something
        }
        try {

            System.out.println("adjacentHashStep-Test-4 space separated -bottom- Step 1");
            hash = "55 5";
            direction = Direction.BOTTOM;
            expResult = "54g";
            step = 1;
            result = GeoHash.adjacentHash(hash, direction, step);
            System.out.println(result);
            assertEquals(expResult, result);
            System.out.println("------------------------------");
        } catch (Throwable t) {
            System.out.println("Error Special");
            collector.addError(t);
            // do something
        }
        System.out.println("adjacentHashStep-Test-5 - all lower character-bottom- Step 1");
        hash = "hehe";
        direction = Direction.BOTTOM;
        expResult = "hehd";
        step = 1;
        result = GeoHash.adjacentHash(hash, direction, step);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("adjacentHashStep-Test-6 -all upper character-bottom- Step 1");
        hash = "HEHE";
        direction = Direction.BOTTOM;
        expResult = "hehd";
        step = 1;
        result = GeoHash.adjacentHash(hash, direction, step);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("adjacentHashStep--alphanumeric -  bottom- Step 0");
        hash = "gbs5";
        direction = Direction.BOTTOM;
        expResult = "gbs5";
        step = 0;
        result = GeoHash.adjacentHash(hash, direction, step);
        System.out.println(result);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("adjacentHashStep--alphanumeric -  bottom- Step -1");
        hash = "gbs5";
        direction = Direction.BOTTOM;
        expResult = "gbsh";
        step = -1;
        result = GeoHash.adjacentHash(hash, direction, step);
        System.out.println(result);
        assertEquals(expResult, result);
//        System.out.println("------------------------------");

    }


    @Test
    public void testRight() {
        System.out.println("right");
        System.out.println("Test 1-alphanumeric");
        String hash = "gbs5";
        String expResult = "gbs7";
        String result = GeoHash.right(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("Test 2-All lower");
        hash = "hehe";
        expResult = "hehg";
        result = GeoHash.right(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("Test 3-All Upper");
            hash = "HEHE";
            expResult = "hehg";
            result = GeoHash.right(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error All Upper");
            collector.addError(t);
            // do something
        }
        try {
            System.out.println("------------------------------");
            System.out.println("Test 4-special characters");
            hash = "/s*d@";
            expResult = "sf";
            result = GeoHash.right(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error Special");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        System.out.println("Test 5-numeric characters");
        hash = "555";
        expResult = "55h";
        result = GeoHash.right(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("Test 6-Space-separated characters");
            hash = "55 5";
            expResult = "55h";
            result = GeoHash.right(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error Space-separated characters");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        try {
            System.out.println("Test 7-empty characters");
            hash = "";
            expResult = "";
            result = GeoHash.right(hash);
            assertEquals(expResult, result);
            System.out.println("------------------------------");
        } catch (Throwable t) {
            System.out.println("Error empty characters");
            collector.addError(t);
            // do something
        }

    }

    /**
     * Test of left method, of class GeoHash.
     */
    @Test
    public void testLeft() {
        System.out.println("left");
        System.out.println("Test 1-alphanumeric");
        String hash = "gbs5";
        String expResult = "gbeg";
        String result = GeoHash.left(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("Test 2-All lower");
        hash = "hehe";
        expResult = "heh7";
        result = GeoHash.left(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("Test 3-All Upper");
        hash = "HEHE";
        expResult = "heh7";
        result = GeoHash.left(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("------------------------------");
            System.out.println("Test 4-special characters");
            hash = "/s*d@";
            expResult = "sf";
            result = GeoHash.left(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error Special");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        System.out.println("Test 5-numeric characters");
        hash = "555";
        expResult = "554";
        result = GeoHash.left(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("Test 6-Space-separated characters");
            hash = "55 5";
            expResult = "55h";
            result = GeoHash.left(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error Space-separated characters");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        try {
            System.out.println("Test 7-empty characters");
            hash = "";
            expResult = "";
            result = GeoHash.left(hash);
            assertEquals(expResult, result);
            System.out.println("------------------------------");
        } catch (Throwable t) {
            System.out.println("Error empty characters");
            collector.addError(t);
            // do something
        }
    }

    /**
     * Test of top method, of class GeoHash.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        System.out.println("Test 1-alphanumeric");
        String hash = "gbs5";
        String expResult = "gbsh";
        String result = GeoHash.top(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("Test 2-All lower");
        hash = "hehe";
        expResult = "hehs";
        result = GeoHash.top(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("Test 3-All Upper");
        hash = "HEHE";
        expResult = "hehs";
        result = GeoHash.top(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("Test 4-special characters");
            hash = "/s*d@";
            expResult = "se";
            result = GeoHash.top(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error special characters");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        System.out.println("Test 5-numeric characters");
        hash = "555";
        expResult = "557";
        result = GeoHash.top(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("Test 6-Space-separated characters");
            hash = "55 5";
            expResult = "557";
            result = GeoHash.top(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error Space-separated characters");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        try {
            System.out.println("Test 7-empty characters");
            hash = "";
            expResult = "";
            result = GeoHash.top(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error empty characters");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
    }

    /**
     * Test of bottom method, of class GeoHash.
     */
    @Test
    public void testBottom() {
        System.out.println("bottom");
        System.out.println("Test 1-alphanumeric");
        String hash = "gbs5";
        String expResult = "gbs4";
        String result = GeoHash.bottom(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("Test 2-All lower");
        hash = "hehe";
        expResult = "hehd";
        result = GeoHash.bottom(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("Test 3-All Upper");
        hash = "HEHE";
        expResult = "hehd";
        result = GeoHash.bottom(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("Test 4-special characters");
            hash = "/s*d@";
            expResult = "s9";
            result = GeoHash.bottom(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error special characters");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        System.out.println("Test 5-numeric characters");
        hash = "555";
        expResult = "54g";
        result = GeoHash.bottom(hash);
        assertEquals(expResult, result);

        System.out.println("------------------------------");
        System.out.println("Test 6-Space-separated characters");
        try {
            hash = "55 5";
            expResult = "54g";
            result = GeoHash.bottom(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error pace-separated characters");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
        System.out.println("Test 7-empty characters");
        try {
            hash = "";
            expResult = "";
            result = GeoHash.bottom(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error empty characters");
            collector.addError(t);
            // do something
        }
        System.out.println("------------------------------");
    }

    /**
     * Test of neighbours method, of class GeoHash.
     */
    @Test
    public void testNeighbours() {

        System.out.println("neighbours");
        System.out.println("Test 1-alphanumeric");
        String hash = "gbs5";
        List<String> expResult = new ArrayList<String>();

        expResult.add("gbeg");
        expResult.add("gbs7");
        expResult.add("gbsh");
        expResult.add("gbs4");
        expResult.add("gbeu");
        expResult.add("gbef");
        expResult.add("gbsk");
        expResult.add("gbs6");
        List<String> result = GeoHash.neighbours(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        System.out.println("Test 2-All lower");
        hash = "hehe";
        expResult = new ArrayList<String>();
        expResult.add("heh7");
        expResult.add("hehg");
        expResult.add("hehs");
        expResult.add("hehd");
        expResult.add("hehk");
        expResult.add("heh6");
        expResult.add("hehu");
        expResult.add("hehf");
        result = GeoHash.neighbours(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("Test 3-All Upper");
            hash = "HEHE";
            expResult = new ArrayList<String>();
            expResult.add("hehk");
            expResult.add("hehs");
            expResult.add("hehu");
            expResult.add("heh7");
            expResult.add("hehg");
            expResult.add("heh6");
            expResult.add("hehd");
            expResult.add("hehf");
            result = GeoHash.neighbours(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error All upper");
            collector.addError(t);
            // do something
        }
        try {
            System.out.println("------------------------------");
            System.out.println("Test 4-special characters");
            hash = "/s*d@";
            expResult = new ArrayList<String>();
            expResult.add("s7");
            expResult.add("se");
            expResult.add("sg");
            expResult.add("s6");
            expResult.add("sf");
            expResult.add("s3");
            expResult.add("s9");
            expResult.add("sc");
            result = GeoHash.neighbours(hash);
            assertEquals(expResult, result);
            System.out.println("------------------------------");
        } catch (Throwable t) {
            System.out.println("Error Special");
            collector.addError(t);
            // do something
        }

        System.out.println("Test 5-numeric characters");
        hash = "555";
        expResult = new ArrayList<String>();
        expResult.add("554");
        expResult.add("55h");
        expResult.add("557");
        expResult.add("54g");
        expResult.add("556");
        expResult.add("54f");
        expResult.add("55k");
        expResult.add("54u");
        result = GeoHash.neighbours(hash);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
        try {
            System.out.println("Test 6-Space-separated characters");
            hash = "55 5";
            expResult = new ArrayList<String>();
            expResult.add("554");
            expResult.add("55h");
            expResult.add("557");
            expResult.add("54g");
            expResult.add("556");
            expResult.add("54f");
            expResult.add("55k");
            expResult.add("54u");
            result = GeoHash.neighbours(hash);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error Space-separated");
            collector.addError(t);
            // do something
        }

        try {

            System.out.println("------------------------------");
            System.out.println("Test 7-empty characters");
            hash = "";
            expResult = new ArrayList<String>();
            result = GeoHash.neighbours(hash);
            assertEquals(expResult, result);
            System.out.println("------------------------------");
        } catch (Throwable t) {
            System.out.println("Error Empty");
            collector.addError(t);
            // do something
        }

    }

    /**
     * Test of encodeHash method, of class GeoHash.
     */
    @Test
    public void testEncodeHash_double_double() {
        System.out.println("encodeHash");
        System.out.println("Base test -- lat->60 -- long-> 80.0 ");
        double latitude = 60.0;
        double longitude = 80.0;
        String expResult = "vf8vk6wjr4et";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
        System.out.println("-------------------------------");
        try {
            System.out.println("Test-1 -- lat->60 -- long-> -181 ");
            longitude = -180.5;
            expResult = null;
            result = GeoHash.encodeHash(latitude, longitude);
            assertEquals(null, result);
        } catch (Throwable t) {
            System.out.println("longitude out of range [-180,180]");
            collector.addError(t);
        }

        System.out.println("-------------------------------");
        System.out.println("Test-2 -- lat->60.0 -- long-> -180.0 ");
        longitude = -180.0;
        expResult = "b48j248j248j";
        result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
        System.out.println("-------------------------------");
        System.out.println("Test-3 -- lat->60 -- long-> 180.0 ");
        longitude = 180.0;
        expResult = "zfxvrfxvrfxv";
        result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
        System.out.println("-------------------------------");
        try {
            System.out.println("Test-4 -- lat->60 -- long-> 181 ");
            longitude = 181;
            expResult = null;
            result = GeoHash.encodeHash(latitude, longitude);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("longitude out of range [-180,180]");
            collector.addError(t);
        }
        try {

            System.out.println("-------------------------------");
            System.out.println("Test-5 -- lat->-91 -- long-> 80.0 ");
            latitude = -91;
            longitude = 80.0;
            expResult = null;
            result = GeoHash.encodeHash(latitude, longitude);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            assertTrue(t.getMessage().contains("must be between -90 and 90"));

        }
        System.out.println("-------------------------------");
        System.out.println("Test-6 -- lat-> -90.0 -- long-> 80.0 ");
        latitude = -90.0;
        longitude = 80.0;
        expResult = "jb0bh2n0p058";
        result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
        System.out.println("-------------------------------");
        System.out.println("Test-7 -- lat->90.0 -- long-> 80.0 ");
        latitude = 90.0;
        longitude = 80.0;
        expResult = "vzbzurypzpgx";
        result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
        System.out.println("-------------------------------");
        try {
            System.out.println("Test-8 -- lat->91 -- long-> 80.0 ");
            latitude = 91;
            longitude = 80.0;
            expResult = null;
            result = GeoHash.encodeHash(latitude, longitude);
            assertEquals(expResult, result);
            System.out.println("-------------------------------");
        } catch (Throwable t) {
            assertTrue(t.getMessage().contains("must be between -90 and 90"));
        }
    }

    /**
     * Test of encodeHash method, of class GeoHash.
     */
    @Test
    public void testEncodeHash_LatLong_int() {
        System.out.println("encodeHash");
        System.out.println("test 1 lat 60 long 80 length 5");
        int length = 5;
        String expResult = "vf8vk";
        String result = GeoHash.encodeHash(new LatLong(60, 80), length);
        assertEquals(expResult, result);
        System.out.println("test 2 lat 60 long -181 length 5");
        try {
            expResult = null;
            result = GeoHash.encodeHash(new LatLong(60, -181), length);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error");
            collector.addError(t);
            // do something
        }

        System.out.println("test 2 lat 60 long -180 length 5");
        expResult = "b48j2";
        result = GeoHash.encodeHash(new LatLong(60, -180), length);
        assertEquals(expResult, result);
        System.out.println("test 3 lat 60 long 180 length 5");
        expResult = "zfxvr";
        result = GeoHash.encodeHash(new LatLong(60, 180), length);
        assertEquals(expResult, result);
        System.out.println("test 4 lat 60 long 181 length 5");
        try {
            expResult = null;
            result = GeoHash.encodeHash(new LatLong(60, 181), length);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error");
            collector.addError(t);
            // do something
        }
        try {
            System.out.println("test 5 lat 60 long 80 length -1");
            length = -1;
            expResult = null;
            result = GeoHash.encodeHash(new LatLong(60, 80), length);
            assertEquals(expResult, result);
        } catch (Throwable t) {

            System.out.println("Error");
            collector.addError(t);
            // do something
        }
        try {
            System.out.println("test 6 lat 60 long 80 length 0");
            length = 0;
            expResult = null;
            result = GeoHash.encodeHash(new LatLong(60, 80), length);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error");
            collector.addError(t);
            // do something
        }
        try {
            System.out.println("test 7 lat 60 long 80 length 12");
            length = 12;
            expResult = "vf8vk6wjr";
            result = GeoHash.encodeHash(new LatLong(60, 80), length);
            assertEquals(expResult, result.substring(0, 9));
        } catch (Throwable t) {
            System.out.println("Error");
            collector.addError(t);
            // do something
        }
        System.out.println("test 8 lat 60 long 80 length 13");
        try {
            length = 13;
            expResult = "vf8vk6wjr";
            result = GeoHash.encodeHash(new LatLong(60, 80), length);
            assertEquals(expResult, result.substring(0, 9));
        } catch (Throwable t) {
            System.out.println("Error");
            collector.addError(t);
            // do something
        }
        System.out.println("test 9 lat 90 long 80 length 5");
        length = 5;
        expResult = "vzbzu";
        result = GeoHash.encodeHash(new LatLong(90, 80), length);
        assertEquals(expResult, result);
        System.out.println("test 10 lat -90 long 80 length 5");
        length = 5;
        expResult = "jb0bh";
        result = GeoHash.encodeHash(new LatLong(-90, 80), length);
        assertEquals(expResult, result);
        try {
            System.out.println("test 9 lat 91 long 80 length 5");
            length = 5;
            expResult = "";
            result = GeoHash.encodeHash(new LatLong(91, 80), length);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            assertTrue(t.getMessage().contains("must be between -90 and 90"));
            // do something
        }
        try {
            System.out.println("test 10 lat -91 long 80 length 5");
            length = 5;
            expResult = "";
            result = GeoHash.encodeHash(new LatLong(-91, 80), length);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            assertTrue(t.getMessage().contains("must be between -90 and 90"));
            // do something
        }

    }

    /**
     * Test of encodeHash method, of class GeoHash.
     */
    @Test
    public void testEncodeHash_LatLong() {
        System.out.println("encodeHash");
        System.out.println("test 1 lat 60 long 80");

        String expResult = "vf8vk6wjr";
        String result = GeoHash.encodeHash(new LatLong(60, 80));
        assertEquals(expResult, result.substring(0, 9));
//        System.out.println("test 2 lat 60 long -181 ");
//        expResult = null;
//        result = GeoHash.encodeHash(new LatLong(60,-181));
//        assertEquals(expResult, result);
        System.out.println("test 2 lat 60 long -180 ");
        expResult = "b48j248j2";
        result = GeoHash.encodeHash(new LatLong(60, -180));
        assertEquals(expResult, result.substring(0, 9));
        System.out.println("test 3 lat 60 long 180 ");
        expResult = "zfxvrfxvr";
        result = GeoHash.encodeHash(new LatLong(60, 180));
        assertEquals(expResult, result.substring(0, 9));

        System.out.println("test 4 lat 90 long 80 ");

        expResult = "vzbzurypz";
        result = GeoHash.encodeHash(new LatLong(90, 80));
        assertEquals(expResult, result.substring(0, 9));
        System.out.println("test 5 lat -90 long 80 ");
        expResult = "jb0bh2n0p";
        result = GeoHash.encodeHash(new LatLong(-90, 80));
        assertEquals(expResult, result.substring(0, 9));
//        System.out.println("test 6 lat 91 long 80 ");
//        expResult = "";
//        result = GeoHash.encodeHash(new LatLong(91,80));
//        assertEquals(expResult, result.substring(0,9));
//        System.out.println("test 7 lat -91 long 80 ");
//        expResult = "";
//        result = GeoHash.encodeHash(new LatLong(-91,80));
//        assertEquals(expResult, result.substring(0,9));

    }

    /**
     * Test of encodeHash method, of class GeoHash.
     */
    @Test
    public void testEncodeHash_3args() {
        System.out.println("test 1 lat 60 long 80 length 5");
        int length = 5;
        String expResult = "vf8vk";
        String result = GeoHash.encodeHash(60, 80, length);
        assertEquals(expResult, result);
        try {
            System.out.println("test 2 lat 60 long -181 length 5");
            expResult = null;
            result = GeoHash.encodeHash(new LatLong(60, -181), length);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error");
            collector.addError(t);
            // do something
        }
        System.out.println("test 2 lat 60 long -180 length 5");
        expResult = "b48j2";
        result = GeoHash.encodeHash(60, -180, length);
        assertEquals(expResult, result);
        System.out.println("test 3 lat 60 long 180 length 5");
        expResult = "zfxvr";
        result = GeoHash.encodeHash(60, 180, length);
        assertEquals(expResult, result);
        try {
            System.out.println("test 4 lat 60 long 181 length 5");
            expResult = null;
            result = GeoHash.encodeHash(60, 181, length);
            assertEquals(expResult, result);
        } catch (Throwable t) {
            System.out.println("Error");
            collector.addError(t);
            // do something
        }
        System.out.println("test 5 lat 60 long 80 length -1");
        length = -1;
        try {
            GeoHash.encodeHash(60, 80, length);
        } catch (IllegalArgumentException re) {
            assertTrue(re.getMessage().contains("length must be between 1 and 12"));
        }
        System.out.println("test 6 lat 60 long 80 length 0");
        try {
            GeoHash.encodeHash(60, 80, 0);
        } catch (IllegalArgumentException re) {
            assertTrue(re.getMessage().contains("length must be between 1 and 12"));
        }
        System.out.println("test 7 lat 60 long 80 length 12");
        length = 12;
        expResult = "vf8vk6wjr";
        result = GeoHash.encodeHash(60, 80, length);
        assertEquals(expResult, result.substring(0, 9));
        try {
            GeoHash.encodeHash(60, 80, 13);
        } catch (IllegalArgumentException re) {
            assertTrue(re.getMessage().contains("length must be between 1 and 12"));
        }
        System.out.println("test 9 lat 90 long 80 length 5");
        length = 5;
        expResult = "vzbzu";
        result = GeoHash.encodeHash(90, 80, length);
        assertEquals(expResult, result);
        System.out.println("test 10 lat -90 long 80 length 5");
        expResult = "jb0bh";
        result = GeoHash.encodeHash(-90, 80, length);
        assertEquals(expResult, result);
        System.out.println("test 9 lat 91 long 80 length 5");
        try {
            GeoHash.encodeHash(91, 80, length);

        } catch (IllegalArgumentException re) {
            assertTrue(re.getMessage().contains("latitude must be between -90 and 90"));
        }
        System.out.println("test 10 lat -91 long 80 length 5");
        try {
            GeoHash.encodeHash(-91, 80, length);

        } catch (IllegalArgumentException re) {
            assertTrue(re.getMessage().contains("latitude must be between -90 and 90"));
        }

    }

    /**
     * Test of decodeHash method, of class GeoHash.
     */
    @Test
    public void testDecodeHash() {
        System.out.println("decodeHash");
        System.out.println("alphanumeric");
        String geohash = "gbs5";
        LatLong result = GeoHash.decodeHash(geohash);
        double lat = 48.42;
        double lon = -5.45;
        assertEquals(lat, Math.floor(result.getLat() * 100) / 100, 1);
        assertEquals(lon, Math.floor(result.getLon() * 100) / 100, 1);
        System.out.println("all lower");
        geohash = "gbs";
        result = GeoHash.decodeHash(geohash);
        lat = 48.5;
        lon = -4.9;
        assertEquals(lat, Math.floor(result.getLat() * 100) / 100, 1);
        assertEquals(lon, Math.floor(result.getLon() * 100) / 100, 1);
//        System.out.println("all Upper");
//        geohash = "GBS";
//        result = GeoHash.decodeHash(geohash);
//        lat= 48.5;
//        lon=-4.9;
//        assertEquals(lat, Math.floor(result.getLat() * 100) / 100,1);
//        assertEquals (lon,Math.floor(result.getLon() * 100) / 100,1);
        System.out.println("Numeric");
        geohash = "555";
        result = GeoHash.decodeHash(geohash);
        lat = -72.4;
        lon = -40.1;
        assertEquals(lat, Math.floor(result.getLat() * 100) / 100, 1);
        assertEquals(lon, Math.floor(result.getLon() * 100) / 100, 1);
//        System.out.println("Special Character");
//        geohash = "/s*d@";
//        result = GeoHash.decodeHash(geohash);
//        lat= 14.1;
//        lon=28;
//        assertEquals(lat, Math.floor(result.getLat() * 100) / 100,1);
//        assertEquals (lon,Math.floor(result.getLon() * 100) / 100,1);
//        System.out.println("space separeted");
//        geohash = "cc c";
//        result = GeoHash.decodeHash(geohash);
//        lat= 55.5;
//        lon=-99.1;
//        assertEquals(lat, Math.floor(result.getLat() * 100) / 100,1);
//        assertEquals (lon,Math.floor(result.getLon() * 100) / 100,1);
        System.out.println("Empty");
        geohash = "";
        result = GeoHash.decodeHash(geohash);
        lat = 0;
        lon = 0;
        assertEquals(lat, Math.floor(result.getLat() * 100) / 100, 1);
        assertEquals(lon, Math.floor(result.getLon() * 100) / 100, 1);
        System.out.println("Test to see boundary of lat 90 ");
        geohash = "vrfxvrfx";
        result = GeoHash.decodeHash(geohash);
        lat = 90;
        lon = 60;
        assertEquals(lat, Math.floor(result.getLat() * 100) / 100, 1);
        assertEquals(lon, Math.floor(result.getLon() * 100) / 100, 1);
        System.out.println("Test to see boundary of lat -90 ");
        geohash = "j248j248";
        result = GeoHash.decodeHash(geohash);
        lat = -90;
        lon = 60;
        assertEquals(lat, Math.floor(result.getLat() * 100) / 100, 1);
        assertEquals(lon, Math.floor(result.getLon() * 100) / 100, 1);
        System.out.println("Test to see boundary of long 180 ");
        geohash = "pvrfxvrf";
        result = GeoHash.decodeHash(geohash);
        lat = -60;
        lon = 180;
        assertEquals(lat, Math.floor(result.getLat() * 100) / 100, 1);
        assertEquals(lon, Math.floor(result.getLon() * 100) / 100, 1);
        System.out.println("Test to see boundary of long -180 ");
        geohash = "0j248j24";
        result = GeoHash.decodeHash(geohash);
        lat = -60;
        lon = -180;
        assertEquals(lat, Math.floor(result.getLat() * 100) / 100, 1);
        assertEquals(lon, Math.floor(result.getLon() * 100) / 100, 1);

    }

    /**
     * Test of hashLengthToCoverBoundingBox method, of class GeoHash.
     */


    /**
     * Test of hashContains method, of class GeoHash.
     */
    @Test
    public void testHashContains() {
        System.out.println("hashContains");
//        System.out.println("All Upper ");
//        String hash = "CCC";
//        double lat = 55.5;
//        double lon = -99.1;
//        boolean expResult = true;
//        boolean result = GeoHash.hashContains(hash, lat, lon);
//        assertEquals(expResult, result);
        System.out.println("All lower ");
        var hash = "ccc";
        var lat = 55.5;
        var lon = -99.1;
        var expResult = true;
        var result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
        System.out.println("Numeric ");
        hash = "555";
        lat = -72.51;
        lon = -40.61;
        expResult = true;
        result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
//        System.out.println("special character ");
//        hash = "/s*d@";
//        lat = 14.1;
//        lon = 28;
//        expResult = true;
//        result = GeoHash.hashContains(hash, lat, lon);
//        assertEquals(expResult, result);
        System.out.println("Empty ");
        hash = "";
        lat = 0;
        lon = 0;
        expResult = true;
        result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
//        System.out.println("Space separated ");
//        hash = "cc c";
//        lat = 55.5;
//        lon = -99.1;
//        expResult = true;
//        result = GeoHash.hashContains(hash, lat, lon);
//        assertEquals(expResult, result);
        System.out.println("invalid ");
        hash = "ccc";
        lat = 14.8;
        lon = -64;
        expResult = false;
        result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
        System.out.println("boundary test-1 --hash --> 'vrfx' lat->90.0 -- long-> 60.0 ");
        hash = "vrfx";
        lat = 90.0;
        lon = 60.0;
        expResult = true;
        result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
        System.out.println("--------------------------------");
        System.out.println("boundary test-2 --hash --> 'j248' lat->-90.0 -- long-> 60.0 ");
        hash = "j248";
        lat = -90.0;
        lon = 60.0;
        expResult = true;
        result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
        System.out.println("--------------------------------");
        System.out.println("boundary test-3 --hash --> 'zfxv' lat->60.0 -- long-> 180.0 ");
        hash = "zfxv";
        lat = 60.0;
        lon = 180.0;
        expResult = true;
        result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
        System.out.println("--------------------------------");
        System.out.println("boundary test-4 --hash --> 'b48j' lat->60.0 -- long-> -180.0 ");
        hash = "b48j";
        lat = 60.0;
        lon = -180.0;
        expResult = true;
        result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
        System.out.println("--------------------------------");


    }


    /**
     * Test of heightDegrees method, of class GeoHash.
     */
    @Test
    public void testHeightDegrees() {
        System.out.println("heightDegrees");
        System.out.println("Test-1 -n --> 1 ");
        int n = 1;
        double expResult = (5000.0 / 40000) * 360;
        double result = GeoHash.heightDegrees(n);
        assertEquals(expResult, result, 1.0);
//        System.out.println("---------------------------- ");
//        System.out.println("Test-3 -n --> 0 ");
//        n = 0;
//        expResult = 180.0;
//        result = GeoHash.heightDegrees(n);
//        assertEquals(expResult, result, 1.0);
        System.out.println("---------------------------- ");
        System.out.println("Test-4 -n --> 6 ");
        n = 6;
        expResult = (0.61 / 40000) * 360;
        result = GeoHash.heightDegrees(n);
        assertEquals(expResult, result, 1.0);
        System.out.println("---------------------------- ");
        System.out.println("Test-5 -n --> 12 ");
        n = 12;
        expResult = (0.0000186 / 40000) * 360;
        result = GeoHash.heightDegrees(n);
        assertEquals(expResult, result, 1.0);
        System.out.println("---------------------------- ");
//        System.out.println("Test-6 -n --> 13 ");
//        n = 13;
//        expResult = 0;
//        result = GeoHash.heightDegrees(n);
//        assertEquals(expResult, result, 1.0);
//        System.out.println("---------------------------- ");
    }

    /**
     * Test of widthDegrees method, of class GeoHash.
     */
    @Test
    public void testWidthDegrees() {
        System.out.println("widthDegrees");
        System.out.println("Test-1 -n --> 1 ");
        int n = 1;
        double expResult = (5000.0 / 40000) * 360;
        double result = GeoHash.widthDegrees(n);
        assertEquals(expResult, result, 1);
//        System.out.println("---------------------------- ");
//        System.out.println("Test-2 -n --> 0 ");
//        n = 0;
//        expResult = 0.0;
//        result = GeoHash.widthDegrees(n);
//        assertEquals(expResult, result, 1);
        System.out.println("---------------------------- ");
        System.out.println("Test-4 -n --> 6 ");
        n = 6;
        expResult = (1.22 / 40000) * 360;
        result = GeoHash.widthDegrees(n);
        assertEquals(expResult, result, 1);
        System.out.println("---------------------------- ");
        System.out.println("Test-4 -n --> 12 ");
        n = 12;
        expResult = (0.0000372 / 40000) * 360;
        result = GeoHash.widthDegrees(n);
        assertEquals(expResult, result, 1);
//        System.out.println("---------------------------- ");
//        System.out.println("Test-4 -n --> 13 ");
//        n = 13;
//        expResult =0;
//        result = GeoHash.widthDegrees(n);
//        assertEquals(expResult,result,1);
    }

    /**
     * Test of gridAsString method, of class GeoHash.
     */
    @Test
    public void testGridAsString_3args() {
        System.out.println("gridAsString");
        System.out.println("Base Test");
        String hash = "hehe";
        int size = 1;
        Set<String> highlightThese = new java.util.HashSet<>(Collections.emptySet());
        highlightThese.add("hehe");
        String expResult = "hehk hehs hehu \n" +
                "heh7 HEHE hehg \n" +
                "heh6 hehd hehf";
        String result = GeoHash.gridAsString(hash, size, highlightThese);
        System.out.println(result);
        assertEquals(expResult, result.strip());
    }

    /**
     * Test of gridAsString method, of class GeoHash.
     */
    @Test
    public void testGridAsString_5args() {
        System.out.println("gridAsString");
        String hash = "hehe";
        int fromRight = 1;
        int fromBottom = 1;
        int toRight = 1;
        int toBottom = 1;
        String expResult = "hehf";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        System.out.println(result);
        assertEquals(expResult, result.strip());
    }

    /**
     * Test of gridAsString method, of class GeoHash.
     */
    @Test
    public void testGridAsString_6args() {
        System.out.println("gridAsString");
        Set<String> highlightThese = new java.util.HashSet<>(Collections.emptySet());
        highlightThese.add("hehf");
        String hash = "hehe";
        int fromRight = 1;
        int fromBottom = 1;
        int toRight = 1;
        int toBottom = 1;
        String expResult = "HEHF";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom, highlightThese);
        System.out.println(result);
        assertEquals(expResult, result.strip());
    }

}
