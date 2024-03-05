package com.example.aula3.readers;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BookReader {

    public BookReader(){}

    public static JSONArray getAllBooks() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("./src/main/resources/jsonfiles/books.json");

        Object obj = jsonParser.parse(reader);
        JSONArray bookArray = (JSONArray) obj;
        return bookArray;
    }
}
