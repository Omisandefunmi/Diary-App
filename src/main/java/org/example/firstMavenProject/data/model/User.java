package org.example.firstMavenProject.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @NonNull
    private String name;
    private String userId;
    @NonNull
    private String password;
    private Diary diary;
}
