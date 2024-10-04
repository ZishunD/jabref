package org.jabref.model.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnicodeToReadableCharMapTest {

    @Test
    public void testUnicodeConversion() {
        UnicodeToReadableCharMap unicodeMap = new UnicodeToReadableCharMap();
            // Test cases for Unicode characters that should be converted to readable character in Model/String/UnicodeToReadableCharMap Class
            assertEquals("A", unicodeMap.get("\u00C0")); // À Capitalized Romance font
            assertEquals("Ae", unicodeMap.get("\u00C4")); // Ä Nordic and Europeans font
            assertEquals("ss", unicodeMap.get("\u00DF")); // ß is a DE font
            assertEquals("Y", unicodeMap.get("\u0178")); // Ÿ
            assertEquals("ae", unicodeMap.get("\u00E6")); // æ  English and Nordic character
            assertEquals("O", unicodeMap.get("\u00D3")); // Ó
            assertEquals("ue", unicodeMap.get("\u00FC")); // ü Germanic character
            assertEquals("y", unicodeMap.get("\u00FF")); // ÿ

            // Test cases for characters that should not be converted
            assertNull(unicodeMap.get("A")); // Regular ASCII 'A'
            assertNull(unicodeMap.get("Z")); // Regular ASCII 'Z'
            assertNull(unicodeMap.get("1")); // Digit '1'
            assertNull(unicodeMap.get("@")); // Special symbol '@'

            // Test case for an unmapped Unicode character
            // to use unicode UI in windows platform you can press "windows key" + "." for unicode, emoji interface.
            assertNull(unicodeMap.get("\u2603")); // Unicode snowman '☃' not used in this map but can be put as example
    }


    @Test
    public void testIsUnicode() {
        UnicodeToReadableCharMap unicodeMap = new UnicodeToReadableCharMap();

        // Helper method to check if a string contains Unicode characters
        assertTrue(isUnicode("\u00C0"));  // Unicode 'À'
        assertTrue(isUnicode("\u00FC"));  // Unicode 'ü'
        assertTrue(isUnicode("\u1EF9"));  // Unicode 'ỹ'

        // Test with non-Unicode ASCII characters
        assertFalse(isUnicode("A"));      // Regular ASCII 'A'
        assertFalse(isUnicode("B"));      // Regular ASCII 'B'
        assertFalse(isUnicode("1"));      // Regular digit '1'
        assertFalse(isUnicode("!"));      // Special symbol '!'

        // Non-mapped Unicode characters
        assertTrue(isUnicode("\u2603"));  // Snowman ☃

        // Edge cases: empty string and mixed ASCII-Unicode characters
        assertFalse(isUnicode(""));      // Empty string
        assertTrue(isUnicode("A\u00FC"));  // Mixed ASCII 'A' and Unicode 'ü' <- this one is special
    }

    // A method to check if string contains unicode character
    private boolean isUnicode(String str) {
        //test if this string is whether unicode or not
        for (char c : str.toCharArray()) {
            if (c > 127) {
                return true; /// Non-ASCII character (may not be but likely Unicode)
            }
        }
        return false; // All ASCII characters
    }
}
