package com.preinternship.caselabrosatom.repository;

import com.preinternship.caselabrosatom.model.FileModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileTransferRepository extends JpaRepository<FileModel, Long> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM file ORDER BY creation_date ASC", nativeQuery = true)
    public Optional<List<FileModel>> getAllFilesAsc();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM file ORDER BY creation_date DESC ", nativeQuery = true)
    public Optional<List<FileModel>> getAllFilesDesc();
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM file", nativeQuery = true)
    public Optional<List<FileModel>> getAllFilesNoSort();
}
