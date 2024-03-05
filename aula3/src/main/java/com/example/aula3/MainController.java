package com.example.aula3;

import com.example.aula3.models.Book;
import com.example.aula3.models.BookForm;
import com.example.aula3.readers.BookReader;
import com.example.aula3.writers.BookWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/books")
public class MainController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView bookList(Model model){
        ModelAndView mav = new ModelAndView("../static/frontend/index.html");

        return mav;
    }

    @RequestMapping(value="/bookstore", method = RequestMethod.GET)
    public ModelAndView bookStore() throws Exception{
        ModelAndView mav = new ModelAndView();
        BookReader br = new BookReader();
        JSONArray books= br.getAllBooks();
        mav = new ModelAndView("../static/frontend/bookstore.html");
        mav.addObject("books", books);
        return mav;
    }

    @RequestMapping(value="/user/booklist", method = RequestMethod.GET )
    public ModelAndView bookList() throws Exception{
        ModelAndView mav = new ModelAndView();
        BookReader br = new BookReader();
        JSONArray books= br.getAllBooks();

        mav = new ModelAndView("../static/frontend/booklist.html");
        mav.addObject("books", books);
        return mav;
    }

    @RequestMapping(value="/productpage", method = RequestMethod.GET)
    public ModelAndView productPage(@RequestParam String id) throws Exception{
        ModelAndView mav = new ModelAndView();
        JSONObject selectedBook = new JSONObject();
        BookReader br = new BookReader();
        JSONArray books= br.getAllBooks();
        for(int i = 0; i < books.size(); i++){
            JSONObject book = (JSONObject) books.get(i);
            if( book.get("id").equals(id)){
                selectedBook=(book);
            }
        }

        mav = new ModelAndView("../static/frontend/productpage.html");
        mav.addObject("book", selectedBook);
        return mav;
    }
    @GetMapping("/admin/newbook")
    public ModelAndView insertBook(Model model) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav = new ModelAndView("../static/frontend/newbook.html");
        mav.addObject("book", new BookForm());
        return mav;
    }

    @RequestMapping(value="/admin/newbook", method = RequestMethod.POST)
    public void insertBook(@ModelAttribute("book") BookForm book) throws Exception{
        BookWriter bw = new BookWriter();
        Book newBook = new Book();

        newBook.setTitle(book.getTitle());
        newBook.setAuthor( book.getAuthor());
        newBook.setPublisher(book.getPublisher());
        if(book.getCover().isEmpty()) {
            newBook.setCover("");
        } else if(!book.getCover().getOriginalFilename().endsWith(".jpg")){
            newBook.setCover("");
        } else {

        }


        Boolean success = bw.insertBook(newBook);
        System.out.println(book);
        System.out.println(success);
    }
}
