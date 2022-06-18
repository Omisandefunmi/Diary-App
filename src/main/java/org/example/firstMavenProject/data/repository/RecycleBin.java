package org.example.firstMavenProject.data.repository;

import org.example.firstMavenProject.data.model.Entry;

public interface RecycleBin {
    void addDeletedEntry(Entry entry);
    Entry retrieveAnEntryBy(String entryTitle);

    int count();
}
