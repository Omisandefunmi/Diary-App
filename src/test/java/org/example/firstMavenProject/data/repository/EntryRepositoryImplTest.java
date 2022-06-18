package org.example.firstMavenProject.data.repository;

import org.example.firstMavenProject.data.model.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoryImplTest {
    private EntryRepository entryRepository;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
    private String date = dateTimeFormatter.format(LocalDateTime.now());

    @BeforeEach
    public void alwaysStartWith(){
        entryRepository = new EntryRepositoryImpl();

    }

    @Test
    public void entryRepositoryIsEmptyByDefault(){
        assertEquals(0,entryRepository.getNumberOfEntries());
    }

    @Test
    public void entryRepositoryIsNotEmptyWhenEntryIsAdded(){
        entryRepository.write("my heart", "my heart loves God");
        assertEquals(1, entryRepository.getNumberOfEntries());
    }

    @Test
    public void entryRepositoryCanAddMultipleEntries(){
        entryRepository.write("my heart", "my heart loves God");
        entryRepository.write("my best food", "my best food is Beans");
        assertEquals(2, entryRepository.getNumberOfEntries());
    }

    @Test
    public void entryRepositoryCanFindEntryByTitle(){
        entryRepository.write("my heart", "my heart loves God");
        entryRepository.write("my best food", "my best food is Beans");

        Entry found = entryRepository.findEntryByTitle("my heart");
        assertEquals("Date : "+date+"\n" +
                "Title: my heart\n" +
                "\n" +
                "Body: my heart loves God", found.toString());
    }

    @Test
    public void entryRepositoryCanFindEntryById(){
        entryRepository.write("my heart", "my heart loves God");
        entryRepository.write("my best food", "my best food is Beans");

        Entry found = entryRepository.findEntryById(1);
        assertEquals("Date : "+date+"\n" +
                "Title: my heart\n" +
                "\n" +
                "Body: my heart loves God", found.toString());
    }

    @Test
    public void entryRepositoryCanEditEntry(){
        entryRepository.write("my heart", "my heart loves God");
        entryRepository.write("my best food", "my best food is Beans");

        entryRepository.editEntry(1,"my heart", "my whole heart loves God");
        Entry found = entryRepository.findEntryById(1);
                assertEquals("Date : "+date+"\n" +
                "Title: my heart\n" +
                "\n" +
                "Body: my whole heart loves God", found.toString());
    }

    @Test
    public void testThatEntryRepositoryCanDeleteEntryByEntryNumber(){
        entryRepository.write("my heart", "my heart loves God");
        entryRepository.write("my best food", "my best food is Beans");

        entryRepository.deleteEntryBy(2);
        assertEquals(1, entryRepository.getNumberOfEntries());
    }

    @Test
    public void testThatEntryRepositoryCanDeleteEntryByTitle(){
        entryRepository.write("my heart", "my heart loves God");
        entryRepository.write("my best food", "my best food is Beans");

        entryRepository.deleteEntryByTitle("my best food");
        assertEquals(1, entryRepository.getNumberOfEntries());
    }

    @Test
    public void testThatEntryRepositoryCanDisplayAllEntries(){
        entryRepository.write("my heart", "my heart loves God");
        entryRepository.write("my best food", "my best food is Beans");

        String result = entryRepository.displayAllEntries();
        String expected = "Date : "+date+"\n" +
                "Title: my heart\n" +
                "\n" +
                "Body: my heart loves God\n" +
                "\n" +
                "Date : "+date+"\n" +
                "Title: my best food\n" +
                "\n" +
                "Body: my best food is Beans\n\n";
        assertEquals(expected, result);
    }

}