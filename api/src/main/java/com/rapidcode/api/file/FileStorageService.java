package com.rapidcode.api.file;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.currentTimeMillis;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileStorageService {

    @Value("${application.file.uploads.base-path}")
    private String fileUploadBasePath;

    @Value("${application.file.uploads.temp-file-path}")
    private String tempUploadBasePath;

    public FileUploadResponse saveFile(@Nonnull MultipartFile sourceFile) {
        return uploadFile(sourceFile);
    }

    private FileUploadResponse uploadFile(@Nonnull MultipartFile sourceFile) {
        final String finalUploadPath = Paths.get(fileUploadBasePath, tempUploadBasePath).toString();
        File targetFolder = new File(finalUploadPath);

        if (!targetFolder.exists()) {
            boolean folderCreated = targetFolder.mkdirs();
            if (!folderCreated) {
                log.warn("Failed to create the target folder: " + targetFolder);
                return null;
            }
        }
        final String fileExtension = getFileExtension(sourceFile.getOriginalFilename());
        String targetFileName = currentTimeMillis() + "." + fileExtension;
        Path targetPath = Paths.get(finalUploadPath, targetFileName);
        try {
            Files.write(targetPath, sourceFile.getBytes());
            log.info("File saved to: " + targetPath);
            return new FileUploadResponse(targetPath.getFileName().toString(), targetPath.toString().replace(File.separatorChar, '/'));
        } catch (IOException e) {
            log.error("File was not saved", e);
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }
}
