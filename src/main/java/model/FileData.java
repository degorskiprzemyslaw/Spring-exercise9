package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "file_name")
    private String fileName;

    private String extension;

    @Column(name = "size_in_kb")
    private String sizeInKb;

    private String content;

    public FileData(String fileName, String extension, String sizeInKb, String content) {
        this.fileName = fileName;
        this.extension = extension;
        this.sizeInKb = sizeInKb;
        this.content = content;
    }
}
