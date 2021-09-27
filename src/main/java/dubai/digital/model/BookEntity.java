package dubai.digital.model;

import javax.persistence.*;

@Entity
@Table(name="TBL_BOOKS")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;

	@Column(name="author", nullable=false)
	private String author;

	@Column(name="type")
	private String type;

    @Column(name="price")
    private Double price;

	@Column(name="isbn")
	private String isbn;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "BookEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", author='" + author + '\'' +
				", type='" + type + '\'' +
				", price='" + price + '\'' +
				", isbn='" + isbn + '\'' +
				'}';
	}
}