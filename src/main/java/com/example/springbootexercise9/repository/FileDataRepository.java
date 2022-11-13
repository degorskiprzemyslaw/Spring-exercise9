package com.example.springbootexercise9.repository;

import com.example.springbootexercise9.model.FileData;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface FileDataRepository extends CrudRepository<FileData, UUID> {
}
