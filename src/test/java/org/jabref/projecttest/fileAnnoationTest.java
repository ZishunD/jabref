/* Copyright (C) 2024 <ZISHUN GAO> - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */
package org.jabref.projecttest;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.jabref.model.pdf.FileAnnotationType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Test suite for the FileAnnotationType class.
 */
class FileAnnotationTypeTest {

    // Test case: 1
    // Test Case: testFileAnnotationTypeParseValid
    // Goal: Verify that the FileAnnotationType correctly parses a valid annotation subtype.
    @Test
    void testFileAnnotationTypeParseValid() {
        // Arrange
        PDAnnotation annotation = Mockito.mock(PDAnnotation.class);
        Mockito.when(annotation.getSubtype()).thenReturn("Text");

        // Act
        FileAnnotationType result = FileAnnotationType.parse(annotation);

        // Assert
        assertEquals(FileAnnotationType.TEXT, result);
    }

    // Test case: 2
    // Test Case: testFileAnnotationTypeParseUnknown
    // Goal: Verify that the FileAnnotationType handles unknown annotation subtypes correctly.
    @Test
    void testFileAnnotationTypeParseUnknown() {
        // Arrange
        PDAnnotation annotation = Mockito.mock(PDAnnotation.class);
        Mockito.when(annotation.getSubtype()).thenReturn("InvalidSubtype");

        // Act
        FileAnnotationType result = FileAnnotationType.parse(annotation);

        // Assert
        assertEquals(FileAnnotationType.UNKNOWN, result);
        // Verify logging behavior (consider adding a logger mock for verification)
    }

    // Test case: 3
    // Test Case: testFileAnnotationTypeIsMarkedFileAnnotationTypeTrue
    // Goal: Verify that the FileAnnotationType correctly identifies marked file annotation types.
    @Test
    void testFileAnnotationTypeIsMarkedFileAnnotationTypeTrue() {
        // Arrange
        String annotationType = "Highlight";

        // Act
        boolean result = FileAnnotationType.isMarkedFileAnnotationType(annotationType);

        // Assert
        assertTrue(result);
    }

    // Test case: 4
    // Test Case: testFileAnnotationTypeIsMarkedFileAnnotationTypeFalse
    // Goal: Verify that the FileAnnotationType correctly identifies non-marked file annotation types.
    @Test
    void testFileAnnotationTypeIsMarkedFileAnnotationTypeFalse() {
        // Arrange
        String annotationType = "Text";

        // Act
        boolean result = FileAnnotationType.isMarkedFileAnnotationType(annotationType);

        // Assert
        assertFalse(result);
    }

    // Test case: 5
    // Test Case: testFileAnnotationTypeToString
    // Goal: Verify the string representation of the FileAnnotationType.
    @Test
    void testFileAnnotationTypeToString() {
        // Arrange
        FileAnnotationType annotationType = FileAnnotationType.TEXT;

        // Act
        String result = annotationType.toString();

        // Assert
        assertEquals("Text", result);
    }
}
