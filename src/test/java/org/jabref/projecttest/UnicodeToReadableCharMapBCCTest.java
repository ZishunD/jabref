package org.jabref.model.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnicodeToReadableCharMapBCCTest {

    UnicodeToReadableCharMap unicodeMap = new UnicodeToReadableCharMap();

    // Test boundary class for single-character mappings
    @Test
    public void testSingleCharacterMapping() {
        assertEquals("A", unicodeMap.get("\u00C0")); // Boundary start
        assertEquals("N", unicodeMap.get("\u00D1")); // Middle of range
        assertEquals("Y", unicodeMap.get("\u00DD")); // Boundary end
    }

    // Test boundary class for multi-character mappings
    @Test
    public void testMultiCharacterMapping() {
        assertEquals("Ae", unicodeMap.get("\u00C4")); // Boundary start
        assertEquals("Oe", unicodeMap.get("\u00D6")); // Middle of range
        assertEquals("oe", unicodeMap.get("\u0153")); // Boundary end
    }

    // Test boundary class for unmapped Unicode characters
    @Test
    public void testUnmappedCharacters() {
        assertNull(unicodeMap.get("\u2603")); // Unicode snowman (unmapped)
        assertNull(unicodeMap.get("\u1F600")); // Unicode emoji (unmapped)
    }

    // Test boundary class for control/invisible characters
    @Test
    public void testControlCharacters() {
        assertNull(unicodeMap.get("\u0000")); // Null character
        assertNull(unicodeMap.get("\u200B")); // Zero Width Space (unmapped)
    }

    // Test boundary class for edge Unicode characters
    @Test
    public void testBoundaryUnicodeCharacters() {
        assertNull(unicodeMap.get("\u0000")); // Smallest valid Unicode character
        assertNull(unicodeMap.get("\uFFFF")); // Largest valid Unicode character
    }

    // Test for correct behavior on null and empty input
    @Test
    public void testNullAndEmptyStrings() {
        assertNull(unicodeMap.get(null)); // Null input
        assertNull(unicodeMap.get(""));   // Empty string input
    }
}
