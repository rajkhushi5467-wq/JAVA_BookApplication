package com.example.BookApplication.Controller;


import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")

//http://localhost:8080/book/v1/addBook

public class BookController {

   private final BookService bookService;
   @Autowired
   public BookController(BookService bookService){
       this.bookService = bookService;
   }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
     Book savedBook =  bookService.addBook(book);
     return ResponseEntity.ok(savedBook);
    }
    //http://localhost:8080/book/v1/getBook/
   @GetMapping("/getBook/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable("name") String name){
     final Book bookByName = bookService.getBookByName(name);
     return ResponseEntity.ok(bookByName);
    }

    //update
    //http://localhost:8080/book/v1/updateBook
    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updateBook = bookService.updateBook(book);
        return ResponseEntity.ok(updateBook);


    }

    //delete
    //http://localhost:8080/book/v1/deleteBook/
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
         bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }


}
