/* Copyright (C) <2024> Jedsada Meenoi - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the XYZ license.
 */

package org.jabref.projecttest;

import org.jabref.model.search.SearchQuery;
import org.jabref.model.search.SearchFlags;
import org.junit.jupiter.api.Test;
import java.util.EnumSet;
import java.util.Optional;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

/**Pairwise Test*/
/**Test suite: SearchQueryTest */
/**Goal: Check different type of Query string and determine how it will process based on SearchFlags.*/
public class SearchQueryTest {

    private SearchQuery Query;

    /** Test case 1: Given Query with regular text and without given any search flags
     * Goal: test the situation if given only plain query*/
    @Test
    public void testSimpleTextQueryNoFlags() {

        Query  = new SearchQuery("Destiny", EnumSet.noneOf(SearchFlags.class));
        assertTrue(Query.isValid());    //check if query exist
        assertEquals("Destiny", Query.getSearchExpression()); //return query
    }

    /** Test case 2: Given Query with regular expression and search flags as fulltext search
     * Goal: checks how the query is parsed when both these features are enabled.*/
    @Test
    public void testQueryRegexAllFlags() {

       Query = new SearchQuery("a+b*c?d", EnumSet.of(SearchFlags.REGULAR_EXPRESSION, SearchFlags.FULLTEXT));
        assertTrue(Query.isValid());    //check if query exist

        // The search words should contain the original regex query
        assertTrue(Query.getSearchWords().contains("a+b*c?d"));

        // Get the pattern for the words and ensure it's correctly formed without escaping
        Optional<Pattern> pattern = Query.getPatternForWords();

        assertTrue(pattern.isPresent());

        // Since regular expression is enabled, the characters should not be escaped
        assertEquals("(a+b*c?d)", pattern.get().toString());
    }

    /**Test case 3: Given Empty query string without given any search flags
     * Goal: This tests the case of having no input.*/
    @Test
    public void testInvalidQueryNoFlags() {
        Query = new SearchQuery("", EnumSet.noneOf(SearchFlags.class));
        assertFalse(Query.isValid());   //query is empty

        //Returns nothing
        assertTrue(Query.getSearchWords().isEmpty());
        assertEquals("", Query.getSearchExpression());
    }

    /** Test case 4: Given regular text query with fulltext search flag
     * Goal: This case tests how fulltext search affects the parsing and search behavior.*/
    @Test
    public void testSimpleQueryFlagFulltext() {
        Query = new SearchQuery("space research", EnumSet.of(SearchFlags.FULLTEXT));
        assertTrue(Query.isValid()); //check query exist
        assertEquals("space research", Query.getSearchExpression());    //return relate query in full text
    }

    /** Test case 5: Given wrong regress query with all search flag
     * Goal: Ensures that invalid input is correctly handled and does not result in a valid query*/
    @Test
    public void testInvalidQueryAllFlags() {
        Query = new SearchQuery("John[Halo", EnumSet.of(SearchFlags.REGULAR_EXPRESSION, SearchFlags.FULLTEXT));
        assertFalse(Query.isValid());
        assertNull(Query.getParsedQuery());
    }

    /** Test case 6: Given Query with regular expression but without search flag
     * Goal: tests how special characters are escaped and treated as literal when regular expressions are not used*/
    @Test
    public void testRegexQueryNoFlags() {
        Query = new SearchQuery("a+b*c?d", EnumSet.noneOf(SearchFlags.class));

        assertTrue(Query.isValid()); //check query exist

        // Expecting the special characters to be escaped when regular expression flag is not enabled
        Optional<Pattern> pattern = Query.getPatternForWords();
        assertFalse(pattern.isPresent());

        // The pattern is not present so query should be escaped as following
            String Literal = Pattern.quote("a+b*c?d");
            assertEquals("\\Qa+b*c?d\\E", Literal);
        }

    }

