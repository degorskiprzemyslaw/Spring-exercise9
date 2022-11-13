package com.example.springbootexercise9.service;

import com.example.springbootexercise9.model.FileData;
import com.example.springbootexercise9.repository.FileDataRepository;
import com.example.springbootexercise9.web.SdaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Slf4j
public class FileDataRepositoryService implements CommandLineRunner {

    private final FileDataRepository repository;

    public FileDataRepositoryService(FileDataRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        repository.save(new FileData("obrazek", ".jpg","56765","example1"));
        repository.save(new FileData("wiadomosc", ".doc","67","example2"));
        repository.save(new FileData("dokument", ".pdf","10988","example3"));

        repository.findAll().forEach(fd -> log.info(fd.toString()));
    }

    public List<FileData> findAll(){
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public FileData findById(UUID id){
        return repository.findById(id).orElseThrow( () -> new SdaException("File with id " + id + " not found"));
    }

    public FileData save(FileData fileData) {
        return repository.save(fileData);
    }

    public FileData update(UUID id, FileData fileData) {
        FileData current = findById(id);
        if(fileData.getFileName() == null){
            fileData.setFileName(current.getFileName());
        }
        if(fileData.getExtension() == null){
            fileData.setExtension(current.getExtension());
        }
        if(fileData.getSizeInKb() == null){
            fileData.setSizeInKb(current.getSizeInKb());
        }
        if(fileData.getContent() == null){
            fileData.setContent(fileData.getContent());
        }

        return repository.save(fileData);
    }

    public void delete(UUID id) {
        repository.findById(id).orElseThrow(() -> new SdaException("File with id " + id + " not found"));
        repository.deleteById(id);
    }
}
