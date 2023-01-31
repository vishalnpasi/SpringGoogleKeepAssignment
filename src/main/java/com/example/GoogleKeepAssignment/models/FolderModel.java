package com.example.GoogleKeepAssignment.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Folder")
@AllArgsConstructor
public class FolderModel {
    @Id
    private String id;
    @NotBlank(message = "Title Shouldn't be null")
    @Size(min = 2 ,message = "Title min length should be 2")
    private String title;
    @NotBlank(message = "Description Shouldn't be null")
    @Size(min=2,message = "Description Shouldn't be null")
    private String Description;
}
