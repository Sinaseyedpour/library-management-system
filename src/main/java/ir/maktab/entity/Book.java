package ir.maktab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    private Integer id;
    private String title;
    private String author;
    private Integer ISBN;
//    @ManyToMany(mappedBy = "books")
//    private List<User> users;
    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

    public Book() {
    }

    public Book(Integer id, String title, String author, Integer ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN=" + ISBN +
                '}';
    }
}
