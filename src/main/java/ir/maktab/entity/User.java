package ir.maktab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = User.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;

    public static final String TABLE_NAME = "users";

//    @ManyToMany
//    private List<Book> books;
    @OneToMany(mappedBy = "user")
    private List<Loan> loans;

    private Integer borrowLimit = 2;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", borrowLimit=" + borrowLimit +
                '}';
    }
}
