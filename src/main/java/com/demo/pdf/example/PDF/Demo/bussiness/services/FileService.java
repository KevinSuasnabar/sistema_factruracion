package com.demo.pdf.example.PDF.Demo.bussiness.services;

import com.demo.pdf.example.PDF.Demo.bussiness.exceptions.FIleException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileService {

    public byte[] read(String path) throws FIleException {
        try {
            return Files.readAllBytes(new File(path).toPath());
        } catch (IOException ioe) {
            throw new FIleException("Can’t read File");
        }
    }
}
