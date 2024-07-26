package com.preinternship.caselabrosatom.service;

import com.preinternship.caselabrosatom.dto.FileDto;
import com.preinternship.caselabrosatom.exception.FileNotFoundException;
import com.preinternship.caselabrosatom.model.FileModel;
import com.preinternship.caselabrosatom.repository.FileTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    private final FileTransferRepository fileTransferRepository;

    @Autowired
    public FileServiceImpl(FileTransferRepository fileTransferRepository) {
        this.fileTransferRepository = fileTransferRepository;
    }

    @Override
    public long createFile(FileDto fileDto) {
        FileModel fileModel = new FileModel(fileDto);

        FileModel savedFile = fileTransferRepository.save(fileModel);

        return savedFile.getId();
    }

    @Override
    public FileDto getFile(long id) {
        Optional<FileModel> file = fileTransferRepository.findById(id);

        if (file.isPresent()) {
            FileModel existFile = file.get();

            FileDto fileDto = new FileDto(existFile);
            return fileDto;
        } else
            throw new FileNotFoundException("File has been not founded");
    }

    @Override
    public List<FileDto> getAllFiles(String sort) {
        List<FileDto> fileDtoList = new ArrayList<>();
        List<FileModel> fileModelList = new ArrayList<>();

        if(fileTransferRepository.count() > 0) {
            if (sort.equalsIgnoreCase("asc")) {
                fileModelList = fileTransferRepository.getAllFilesAsc().get();
            } else if (sort.equalsIgnoreCase("desc"))
                fileModelList = fileTransferRepository.getAllFilesDesc().get();
            else
                fileModelList = fileTransferRepository.getAllFilesNoSort().get();

            for (FileModel fileModel : fileModelList) {
                FileDto fileDto = new FileDto(fileModel);
                fileDtoList.add(fileDto);
            }


            return fileDtoList;
        } else {
            throw new FileNotFoundException("File has been not founded");
        }
    }
}
