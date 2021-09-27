package dubai.digital.repository;

import dubai.digital.model.BookEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository
        extends JpaRepository<BookEntity, Long> {
 
	@Query(value="SELECT * FROM TBL_BOOKS WHERE id in (:bookIds)",nativeQuery=true)
	List<BookEntity> getBooksByIds(@Param("bookIds") Integer []bookIds);
}