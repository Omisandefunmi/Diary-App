package org.example.firstMavenProject.data.repository;

import org.example.firstMavenProject.data.model.Entry;

public class RecycleBinImpl implements RecycleBin{
    private Entry[] deletedEntry = new Entry[3];
    private int numberOfEntriesSaved;
    @Override
    public void addDeletedEntry(Entry entry) {
         deletedEntry[numberOfEntriesSaved] = entry;
         numberOfEntriesSaved++;
    }


    @Override
    public Entry retrieveAnEntryBy(String entryTitle) {
        Entry entry;
        for (Entry value : deletedEntry) {
            if (value.getTitle().equalsIgnoreCase(entryTitle)) {
                entry = value;
                return entry;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return numberOfEntriesSaved;
    }
}
