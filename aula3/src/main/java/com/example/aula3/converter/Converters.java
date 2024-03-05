package com.example.aula3.converter;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Converters {


    public Converters(){}
    public File convertToFile(MultipartFile multipartfile, String filename)  throws IOException{
        File tempFile = new File(filename);
        try(FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartfile.getBytes());
            fos.close();
        }
        return tempFile;
    }


}
