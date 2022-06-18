package org.example.firstMavenProject.data.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
@Data
@RequiredArgsConstructor
public class Diary {
    @NonNull
    private final String ownerName;
    private final ArrayList<Entry> entries;
    @NonNull
    private String password;
}
