package dubai.digital.web;

import dubai.digital.exception.RecordNotFoundException;
import dubai.digital.model.BookEntity;
import dubai.digital.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    BookService service;
 
    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        List<BookEntity> list = service.getAllBooks();
 
        return new ResponseEntity<List<BookEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        BookEntity entity = service.getBookById(id);
 
        return new ResponseEntity<BookEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<BookEntity> createOrUpdateEmployee(BookEntity book)
                                                    throws RecordNotFoundException {
        BookEntity updated = service.createOrUpdateBook(book);
        return new ResponseEntity<BookEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteBookById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteBookById(id);
        return HttpStatus.FORBIDDEN;
    }
    
    
    @GetMapping("/checkout/{books}/{promoCode}")
    public ResponseEntity<Double> checkout(@PathVariable("books") Integer[] bookIds,
    											@PathVariable("promoCode") Optional<Double> promoCode)
                                                    throws RecordNotFoundException {
        
    	Double totalAmount = service.checkout(bookIds,promoCode.get());
 
        return new ResponseEntity<Double>(totalAmount, new HttpHeaders(), HttpStatus.OK);
    }
 
}