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
    // Test Case: testFileAnnotationTypeParse
    // Goal: Verify that the parse method correctly returns "UNKNOWN" if the type isn't in FileAnnotationType.
    @Test
    public void testFileAnnotationTypeParse() {
        // Test with valid annotation type
        PDAnnotation annotation = Mockito.mock(PDAnnotation.class);
        Mockito.when(annotation.getSubtype()).thenReturn("Text");


        FileAnnotationType result = FileAnnotationType.parse(annotation);
        assertEquals(FileAnnotationType.TEXT, result);

        //Test with unknown annotation type
        PDAnnotation annotationU = Mockito.mock(PDAnnotation.class);
        Mockito.when(annotationU.getSubtype()).thenReturn("img");


        FileAnnotationType resultU = FileAnnotationType.parse(annotationU);
        assertEquals(FileAnnotationType.UNKNOWN, resultU);
    }

    // Test case: 2
    // Test Case: testIsMarkedFileAnnotationType
    // Goal: Verify that the FileAnnotationType correctly identifies marked file annotation types.
    @Test
    public void testIsMarkedFileAnnotationType() {
        //Test with supported marked FileAnnotation type
        String annotationType = "Highlight";

        boolean result = FileAnnotationType.isMarkedFileAnnotationType(annotationType);

        assertTrue(result);

        ////Test with unsupported marked FileAnnotation type
        String annotationTypeU = "LINE";

        boolean resultU = FileAnnotationType.isMarkedFileAnnotationType(annotationTypeU);

        assertFalse(resultU);
    }
}
