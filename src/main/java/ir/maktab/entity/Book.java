package ir.maktab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String author;
    private Integer ISBN;

    public static final String TABLE_NAME = "book";

    public Book(String title, String author, Integer ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
//    @ManyToMany(mappedBy = "books")
//    private List<User> users;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

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
