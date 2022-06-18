package org.example.firstMavenProject.data.repository;

import org.example.firstMavenProject.data.model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository {
    List <Entry> entries = new ArrayList<>();

    @Override
    public Entry findEntryById(int entryId) {
        return entries.get(entryId - 1);
    }

    @Override
    public void write(String title, String body) {
        Entry entry = new Entry(title, body);
        entries.add(entry);
    }

    @Override
    public void deleteEntryBy(int entryNumber) {
        entries.remove(entryNumber - 1);
    }

    @Override
    public String displayAllEntries() {
        if(entries.size() > 0){
            Entry entry;
            StringBuilder allEntries = new StringBuilder();
            for (int i = 0; i < entries.size(); i++) {
                entry = entries.get(i);
                allEntries.append(entry.toString());
                allEntries.append("\n\n");
            }
            return allEntries.toString();
        }
        return null;
    }

    @Override
    public void deleteEntryByTitle(String entryTitle) {
        Entry entry;
        for (int i = 0; i < entries.size(); i++) {
            entry = entries.get(i);
            if(entry.getTitle().equalsIgnoreCase(entryTitle)){
                entries.remove(entry);
                break;}
        }
    }

    @Override
    public void editEntry(int entryId, String newTitle, String newBody) {
        Entry entry = entries.get(entryId - 1);
        entry.setTitle(newTitle);
        entry.setBody(newBody);
    }

    @Override
    public int getNumberOfEntries() {
        return entries.size();
    }

    @Override
    public Entry findEntryByTitle(String title) {
        Entry entry;
        for (Entry value : entries) {
            entry = value;
            if (entry.getTitle().equalsIgnoreCase(title)) {
                return entry;
            }
        }
        return null;
    }
}
