/* Copyright (C) <2024> Jedsada Meenoi - All Rights Reserved
 * You may use, distribute and modify this code under the terms of the XYZ license.
*/

package org.jabref.projecttest;

import org.jabref.model.openoffice.style.Citation;
import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**ECC testcase*/
public class CitationTest {
    private List<BibDatabase> Bibdata;

    //Set up Bibdatabase of citation key
    @BeforeEach
    public void setup() {

        BibDatabase database1 = new BibDatabase();
        BibEntry entry1 = new BibEntry("Captain2024");
        database1.insertEntry(entry1);

        BibDatabase database2 = new BibDatabase();
        BibEntry entry2 = new BibEntry("Jay8964");
        database2.insertEntry(entry2);

        Bibdata = Arrays.asList(database1, database2);
    }
    /**Test suite: testConstructorKey*/
    /**Goal: The test checks behavior of the Citation constructor key compare to key inside BibDatabase.*/
    @Test
    public void testConstructorKey() {
        //Address input key
        Citation citation1 = new Citation("Captain2024");
        Citation citation2 = new Citation("Jeremy2003");
        Citation citation3 = new Citation("");

        //Compare given key to exist key in database
        List<Citation> citations = Arrays.asList(citation1, citation2, citation3);
        citations.forEach(citation -> citation.lookupInDatabases(Bibdata));

        assertTrue(citation1.getLookupResult().isPresent());    //Valid key
        assertFalse(citation2.getLookupResult().isPresent());   //Invalid key
        assertFalse(citation3.getLookupResult().isPresent());   //Invalid key (Empty)
    }

}
