package V8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeValidatorTest {

    @Test
    void testIsValide() {
//        assertTrue(RangeValidator.isValide(1));
//        assertTrue(RangeValidator.isValide(100));
//        assertFalse(RangeValidator.isValide(0));
//        assertFalse(RangeValidator.isValide(101));
//        assertEquals(true, RangeValidator.isValide(1));
//        assertEquals(true, RangeValidator.isValide(100));
//        assertEquals(false, RangeValidator.isValide(0));
//        assertEquals(false, RangeValidator.isValide(101));

        //Given: Stelle die Vorbedingung her
        // Straßenkarte, Standpunkt, Ziel
        //When: Stelle Bedingung her
        // Stau auf B6
        //Then: Führe Berechnung aus + Ergebnis
        // Navigiere drum herum
        // --> hier kommen die assertions hin

        RangeValidator.isValide(1);
    }

    @Test
    void testIsValide2() {
        RangeValidator.isValide(100);
    }

    @Test
    void testIsValide3() {
        RangeValidator.isValide(0);
    }
    @Test
    void testIsValide4() {
        RangeValidator.isValide(101);
    }
}
