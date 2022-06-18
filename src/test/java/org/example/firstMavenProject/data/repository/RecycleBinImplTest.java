package org.example.firstMavenProject.data.repository;

import org.example.firstMavenProject.data.model.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecycleBinImplTest {
    private RecycleBin recycleBin;

    @BeforeEach
    public void alwaysStartWith(){
        recycleBin = new RecycleBinImpl();
    }

    @Test
    public void testThatRecycleBinIsEmpty(){
        assertEquals(0, recycleBin.count());
    }

    @Test
    public void testThatRecycleBinCanAddEntry(){
        Entry entry = new Entry("Stockholm", "syndrome");
        recycleBin.addDeletedEntry(entry);
        assertEquals(1, recycleBin.count());
    }

    @Test
    public void testThatRecycleBinCanRetrieveDeletedEntry(){
        Entry entry = new Entry("Stockholm", "syndrome");
        recycleBin.addDeletedEntry(entry);
        assertNotNull(recycleBin.retrieveAnEntryBy("Stockholm"));
    }
//
//    @Test
//    public void testThatRecycleBinCanTakeIn
}