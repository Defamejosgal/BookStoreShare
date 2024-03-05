package com.example.aula3.writers;
import com.example.aula3.models.Book;
import com.example.aula3.readers.BookReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unchecked")
public class BookWriter {

    public BookWriter(){}

    public boolean insertBook(Book book) throws IOException, ParseException {
        Boolean success = false;
        JSONObject JSONBook = new JSONObject();
        JSONBook.put("title", book.getTitle());
        JSONBook.put("author", book.getAuthor());
        JSONBook.put("publisher", book.getPublisher());
        //To do latter
        JSONBook.put("cover", "");

        BookReader br = new BookReader();
        JSONArray books= br.getAllBooks();
        books.add(JSONBook);
        try(FileWriter file = new FileWriter("./src/main/resources/jsonfiles/books.json")) {
        file.write(books.toJSONString());
        file.flush();
        success = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return success;
    }
}

