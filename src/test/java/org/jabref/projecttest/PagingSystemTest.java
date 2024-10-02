/* Copyright (C) 2024 <Sirawich Anantapong> - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */
package org.jabref.model.paging;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

class PagingTest {
    //Test case: 5
    //Test Case: testPageContent
    //Goal: Verify that the Page class correctly stores and returns the content, and ensure the content is unchange
    @Test
    public void testPageContent() {
        Collection<String> testContent = Arrays.asList("Moon", "Sun", "Cloud");
        Page<String> page = new Page<>("TestQuery", 1, testContent);

        // This is for checking that the content is correctly returned
        assertEquals(3, page.getContent().size());
        assertTrue(page.getContent().contains("Moon"));
        assertTrue(page.getContent().contains("Sun"));
        assertTrue(page.getContent().contains("Cloud"));

        // make sure that content is unchanged
        assertThrows(UnsupportedOperationException.class, () -> {
            page.getContent().add("Rainbow");
        });
    }

    //Test case: 6
    //Test Case: testEmptyPage
    //Goal: Verify that the Page class correctly handles an empty page (no content) and returns the correct page number and query.
    @Test
    public void testEmptyPage() {
        Page<String> emptyPage = new Page<>("TestQuery", 1);

        // this is for Testing the empty content
        assertTrue(emptyPage.getContent().isEmpty());
        assertEquals(0, emptyPage.getSize());

        // check that page number , query are correctly set
        assertEquals(1, emptyPage.getPageNumber());
        assertEquals("TestQuery", emptyPage.getQuery());
    }

    //Test case: 9
    //Test Case: testNullQuery
    //Goal: Verify that the Page class correctly handles a null query.
    @Test
    public void testNullQuery() {
        Collection<String> testContent = Arrays.asList("Star", "Planet", "Galaxy");
        Page<String> page = new Page<>(null, 2, testContent);

        // This is to verify that content is still handled corect
        assertEquals(3, page.getContent().size());
        assertTrue(page.getContent().contains("Star"));
        assertTrue(page.getContent().contains("Planet"));
        assertTrue(page.getContent().contains("Galaxy"));

        // For ensuring the page number is set correct
        assertEquals(2, page.getPageNumber());

        // check query is null
        assertNull(page.getQuery());
    }
}
