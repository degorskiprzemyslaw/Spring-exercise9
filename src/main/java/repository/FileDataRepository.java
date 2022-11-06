package repository;

import model.FileData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface FileDataRepository extends CrudRepository<FileData, UUID> {
}
