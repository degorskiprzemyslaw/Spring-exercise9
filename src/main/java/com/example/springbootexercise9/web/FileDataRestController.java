package com.example.springbootexercise9.web;

import com.example.springbootexercise9.model.FileData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.springbootexercise9.service.FileDataRepositoryService;

import java.io.File;
import java.util.List;
import java.util.UUID;

/*
GET /api/files-data - zwraca wszystkie obiekty FileData z bazy danych jako obiekt (nie lista) JSON
GET /api/files-data/{id} - zwraca obiekt FileData o konkretnym identyfikatorze (lub wyrzuca wyjątek SdaException)
POST /api/files-data - tworzy obiekt FileData i zapisuje go do bazy danych. Zwraca status 201 i w nagłówku Location, URI do jego pobrania.
PUT /api/files-data/{id} - aktualizuje istniejący obiekt FileData zapisany w bazie danych. Zwraca status 204 (lub wyrzuca wyjątek SdaException gdy nie istnieje obiekt o danym id).
DELETE /api/files-data/{id} - usuwa istniejący obiekt FileData zapisany w bazie danych. Zwraca status 204 (lub wyrzuca wyjątek SdaException gdy nie istnieje obiekt o danym id).
*/

@RestController
@RequestMapping("/api/files-data")
public class FileDataRestController {
    private final FileDataRepositoryService service;

    public FileDataRestController(FileDataRepositoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<FileData> getAllFilesData(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FileData getById(@PathVariable("id") UUID id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FileData save(@RequestBody FileData fileData){
        return service.save(fileData);
    }

    @PutMapping("/{id}")
    public FileData update(@PathVariable("id") UUID id, @RequestBody FileData fileData){
        return service.update(id, fileData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id){
        service.delete(id);
    }
}
