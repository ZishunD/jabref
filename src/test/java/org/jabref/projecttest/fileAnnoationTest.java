/* Copyright (C) 2024 <ZISHUN GAO> - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */
package org.jabref.projecttest;

import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.junit.jupiter.api.Test;
import org.jabref.model.pdf.FileAnnotationType;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the FileAnnotationType enum, verifying the parsing and identification of different file annotation types.
 */
class FileAnnotationTypeTest {

    // Test case: 1
    // Test Case: testParseHighlight
    // Goal: Verify if
    @Test
    public void testParseHighlight() {
        // Test with valid annotation type while supported
        PDAnnotation annotation = Mockito.mock(PDAnnotation.class);
        Mockito.when(annotation.getSubtype()).thenReturn("HIGHLIGHT");


        FileAnnotationType resultHighlightValid = FileAnnotationType.parse(annotation);
        boolean resultHighlightSupported = FileAnnotationType.isMarkedFileAnnotationType(annotation.getSubtype());
        assertEquals(FileAnnotationType.HIGHLIGHT, resultHighlightValid);
        assertTrue(resultHighlightSupported);
    }

    // Test case: 2
    // Test Case: testParseKnownButUnsupported
    // Goal: verify
    @Test
    public void testParseKnownButUnsupported() {
        // Test with valid annotation type while not supported
        PDAnnotation annotation = Mockito.mock(PDAnnotation.class);
        Mockito.when(annotation.getSubtype()).thenReturn("TEXT");


        FileAnnotationType resultTextValid = FileAnnotationType.parse(annotation);
        boolean resultTextUnsupported = FileAnnotationType.isMarkedFileAnnotationType(annotation.getSubtype());
        assertEquals(FileAnnotationType.TEXT, resultTextValid);
        assertFalse(resultTextUnsupported);
    }

    @Test
    // Test ase: 3
    // Test Case: testParseUnknown
    // Goal:
    public void testParseUnknown() {
        // Test with unknown annotation type
        PDAnnotation annotation = Mockito.mock(PDAnnotation.class);
        Mockito.when(annotation.getSubtype()).thenReturn("IMG");


        FileAnnotationType resultTextValid = FileAnnotationType.parse(annotation);
        boolean resultTextUnsupported = FileAnnotationType.isMarkedFileAnnotationType(annotation.getSubtype());
        assertEquals(FileAnnotationType.UNKNOWN, resultTextValid);
        assertFalse(resultTextUnsupported);
    }
}

