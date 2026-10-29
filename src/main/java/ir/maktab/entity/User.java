package ir.maktab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    @OneToOne(mappedBy = "user")
    private Wallet wallet;
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;
//    @ManyToMany
//    private List<Book> books;
    @OneToMany(mappedBy = "user")
    private List<Loan> loans;
    private Integer borrowLimit = 2;

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", wallet=" + wallet +
                ", borrowLimit=" + borrowLimit +
                '}';
    }
}
