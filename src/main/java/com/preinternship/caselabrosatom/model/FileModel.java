package com.preinternship.caselabrosatom.model;

import com.preinternship.caselabrosatom.dto.FileDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "file")
@NoArgsConstructor
public class FileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String data;
    private String title;
    private String creationDate;
    private String description;

    public FileModel(FileDto fileDto) {
        this.data = fileDto.getData();
        this.title = fileDto.getTitle();
        this.creationDate = fileDto.getCreation_date();
        this.description = fileDto.getDescription();
    }
}
