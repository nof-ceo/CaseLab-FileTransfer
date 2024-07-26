package com.preinternship.caselabrosatom.service;

import com.preinternship.caselabrosatom.dto.FileDto;

import java.util.List;

public interface FileService {
    long createFile(FileDto fileDto);
    FileDto getFile(long id);

    List<FileDto> getAllFiles(String sort);

}
