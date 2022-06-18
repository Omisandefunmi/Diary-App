package org.example.firstMavenProject.data.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

@Data
@RequiredArgsConstructor
public class Entry {
    @NonNull
    private String title;
    @NonNull
    private String body;
    private LocalDateTime date = LocalDateTime.now();


    public String getDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");

        return dateTimeFormatter.format(date);
    }

    @Override
    public String toString(){
        return String.format("""
                Date : %s
                Title: %s
                
                Body: %s""", getDate(),getTitle(),getBody());
    }
}
