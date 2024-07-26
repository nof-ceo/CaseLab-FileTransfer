package com.preinternship.caselabrosatom.dto;

import com.preinternship.caselabrosatom.model.FileModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDto {
    private String data;
    private String title;
    private String creation_date;
    private String description;

    public FileDto(FileModel fileModel) {
        this.data = fileModel.getData();
        this.title = fileModel.getTitle();
        this.creation_date = fileModel.getCreationDate();
        this.description = fileModel.getDescription();
    }
}
