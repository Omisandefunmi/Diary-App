package org.example.firstMavenProject.data.repository;

import org.example.firstMavenProject.data.model.Entry;

public interface EntryRepository {
    Entry findEntryById(int entryId);
    void write(String title, String body);
    void deleteEntryBy(int entryNumber);
    String displayAllEntries();
    void deleteEntryByTitle(String entryTitle);
    void editEntry(int entryId, String newTitle, String newBody);

    int getNumberOfEntries();

    Entry findEntryByTitle(String title);
}
