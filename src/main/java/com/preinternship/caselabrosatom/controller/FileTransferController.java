package com.preinternship.caselabrosatom.controller;

import com.preinternship.caselabrosatom.dto.FileDto;
import com.preinternship.caselabrosatom.dto.IdDto;
import com.preinternship.caselabrosatom.service.FileService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/json")
@AllArgsConstructor
public class FileTransferController {

    FileService fileService;

    @PostMapping("/createFile")
    public long createFile(@RequestBody FileDto fileDto) {
        return fileService.createFile(fileDto);
    }

    @PostMapping("/getFile")
    public ResponseEntity<FileDto> getFile(@RequestBody IdDto id) {
        FileDto fileDto = fileService.getFile(id.getId());
        return ResponseEntity.ok(fileDto);
    }

    @GetMapping("/getFile")
    public ResponseEntity<FileDto> getFile(@Param("id") long id) {
        FileDto fileDto = fileService.getFile(id);
        return ResponseEntity.ok(fileDto);
    }

    @GetMapping("/getAllFiles")
    @Transactional
    public ResponseEntity<List<FileDto>> getAllFiles(@Param("sort") String sort) {
        return ResponseEntity.ok(fileService.getAllFiles(sort));
    }
}
