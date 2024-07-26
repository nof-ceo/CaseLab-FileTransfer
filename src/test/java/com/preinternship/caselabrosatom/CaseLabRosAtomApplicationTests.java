package com.preinternship.caselabrosatom;

import com.preinternship.caselabrosatom.dto.FileDto;
import com.preinternship.caselabrosatom.model.FileModel;
import com.preinternship.caselabrosatom.repository.FileTransferRepository;
import com.preinternship.caselabrosatom.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@SpringJUnitConfig
@EnableAutoConfiguration
@Import(CaseLabRosAtomApplicationTests.Config.class)
class CaseLabRosAtomApplicationTests {

    @Autowired
    private FileService fileService;

    @Autowired
    private FileTransferRepository fileTransferRepository;

    @Test
    void testFileCreation() {
        FileDto fileDto = new FileDto("data", "13-02-22", "sd", "s");

        long id = fileService.createFile(fileDto);

        FileModel fileModel = new FileModel(fileDto);
        fileModel.setId(id);

        assertEquals(fileModel, fileTransferRepository.getById(id));
    }

    @Test
    void testGetFile() {
        FileDto fileDto = new FileDto("data", "13-02-22", "sd", "s");

        long id = fileService.createFile(fileDto);

        assertEquals(fileDto, fileService.getFile(id));
    }

    @Test
    void testGetAll() {
        List<FileModel> fileModelList = fileTransferRepository.getAllFilesNoSort().get();
        assertEquals(fileTransferRepository.count(), fileModelList.size());
    }

    @Configuration
    @ComponentScan(basePackages = "com.preinternship.caselabrosatom.service")
    static class Config {
    }
}
