/* Copyright (C) 2024 Sirawich Anantapong, Supitsara Sareecam - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */
package org.jabref.projecttest;
//should be in package org.jabref.model.paging;

import org.jabref.model.paging.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

//This was the old paging test, cannot apply a meaningful ISP, so it is discarded.
class NullQueryTest {

    private Page<String> page;
    private Collection<String> testContent;

    @BeforeEach
    public void pageTestSetUp() {
        testContent = Arrays.asList("Moon", "Sun", "Star");
    }

    //Test Suite 1: getContent
    //Goal: Verify that the Page class correctly stores and returns the content, and ensure the content is unchanged
    @Test
    public void testPageContent() {
        page = new Page<>("TestQuery", 1, testContent);
        // This is for checking that the content is correctly returned
        assertEquals(3, page.getContent().size());
        assertTrue(page.getContent().contains("Moon"));
        assertTrue(page.getContent().contains("Sun"));
        assertTrue(page.getContent().contains("Star"));

        // This make sure that the content is unchanged
        assertThrows(UnsupportedOperationException.class, () -> page.getContent().add("Galaxy"));
    }

    //Test Suite 2: testEmptyPage
    //Goal: Verify that the Page class correctly handles an empty page (no content) and returns the correct page number and query.
    @Test
    public void testEmptyPage() {
        Page<String> emptyPage1 = new Page<>("TestQuery", 1);
        Page<String> emptyPage2 = new Page<>("TestQuery", 0);

        // this is for Testing the empty content
        assertTrue(emptyPage1.getContent().isEmpty());
        assertEquals(0, emptyPage1.getSize());
        assertTrue(emptyPage2.getContent().isEmpty());
        assertEquals(0, emptyPage2.getSize());

        // check that page number , query are correctly set
        assertEquals(1, emptyPage1.getPageNumber());
        assertEquals("TestQuery", emptyPage1.getQuery());
        assertEquals(0, emptyPage2.getPageNumber());
        assertEquals("TestQuery", emptyPage1.getQuery());
    }

    //Test Suite 3: testNullQuery
    //Goal: Verify that the Page class correctly handles a null query.
    @Test
    public void testNullQuery() {
        Page<String> page = new Page<>(null, 2, testContent);
        // This is to verify that content is still handled correctly
        assertEquals(3, page.getContent().size());
        assertTrue(page.getContent().contains("Moon"));
        assertTrue(page.getContent().contains("Sun"));
        assertTrue(page.getContent().contains("Star"));

        // For ensuring the page number is set correct
        assertEquals(2, page.getPageNumber());

        // check query is null
        assertNull(page.getQuery());
    }
}
