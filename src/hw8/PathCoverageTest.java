package hw8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathCoverageTest {

    @Test
    void intToRomanIfBiggerThan900() {
        assertEquals("Keine römische Zahl", PathCoverage.intToRoman(-5));
        assertEquals("M", PathCoverage.intToRoman(1000));
        assertEquals("CM", PathCoverage.intToRoman(900));
        assertEquals("D", PathCoverage.intToRoman(500));
        assertEquals("CD", PathCoverage.intToRoman(400));
        assertEquals("C", PathCoverage.intToRoman(100));
    }
    @Test
    void intToRomanIfBiggerThan500() {
        assertEquals("D", PathCoverage.intToRoman(500));
        assertEquals("CD", PathCoverage.intToRoman(400));
        assertEquals("C", PathCoverage.intToRoman(100));
    }
    @Test
    void intToRomanIfBiggerThan400() {
        assertEquals("CD", PathCoverage.intToRoman(400));
        assertEquals("C", PathCoverage.intToRoman(100));
    }
    @Test
    void intToRomanIfBiggerThan100() {
        assertEquals("C", PathCoverage.intToRoman(100));
    }
    @Test
    void intToRomanIfSmallerThan0() {
        assertEquals("Keine römische Zahl", PathCoverage.intToRoman(-5));
    }
}
