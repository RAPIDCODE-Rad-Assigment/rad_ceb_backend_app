package com.rapidcode.api.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private final FileStorageService fileStorageService;

    @Autowired
    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }


    @PostMapping(value ="/upload", consumes = "multipart/form-data")
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("file") MultipartFile file
    ) {
        FileUploadResponse response = fileStorageService.saveFile(file);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(500).body(null);
        }
    }


}
