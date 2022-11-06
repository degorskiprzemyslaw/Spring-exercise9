package service;

import lombok.extern.slf4j.Slf4j;
import model.FileData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repository.FileDataRepository;

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
}
