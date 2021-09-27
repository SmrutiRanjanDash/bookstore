package dubai.digital.service;

import dubai.digital.exception.RecordNotFoundException;
import dubai.digital.model.BookEntity;
import dubai.digital.repository.BookRepository;
import dubai.digital.utils.BookTypeEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

	@Autowired
	BookRepository repository;

	public List<BookEntity> getAllBooks() {
		List<BookEntity> bookList = repository.findAll();

		if (bookList.size() > 0) {
			return bookList;
		} else {
			return new ArrayList<BookEntity>();
		}
	}

	public BookEntity getBookById(Long id) throws RecordNotFoundException {
		Optional<BookEntity> book = repository.findById(id);

		if (book.isPresent()) {
			return book.get();
		} else {
			throw new RecordNotFoundException("No book record exist for given id");
		}
	}

	public BookEntity createOrUpdateBook(BookEntity entity) throws RecordNotFoundException {
		Optional<BookEntity> book = repository.findById(entity.getId());

		if (book.isPresent()) {
			BookEntity newEntity = book.get();
			newEntity.setName(entity.getName());
			newEntity.setDescription(entity.getDescription());
			newEntity.setAuthor(entity.getAuthor());
			newEntity.setType(entity.getType());
			newEntity.setPrice(entity.getPrice());
			newEntity.setIsbn(entity.getIsbn());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deleteBookById(Long id) throws RecordNotFoundException {
		Optional<BookEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No book record exist for given id");
		}
	}

	public double checkout(Integer[] bookIds, Double promoCode) throws RecordNotFoundException {

		List<BookEntity> bookList = repository.getBooksByIds(bookIds);

		Optional<Double> totalPrice = bookList.stream()
				.map(book -> totalPriceAfterDiscount(book.getPrice(), promoCode)).reduce(Double::sum);

		return totalPrice.get();
	}

	public double totalPriceAfterDiscount(double price, Double promoCode) {

		double priceAfterDisc = price - (price * promoCode / 100.0);
System.out.println(priceAfterDisc);
		return priceAfterDisc;

	}
}