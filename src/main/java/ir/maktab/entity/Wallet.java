package ir.maktab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    public static final String TABLE_NAME = "wallet";
    @Id
    @GeneratedValue
    private int id;
    private int balance;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", balance=" + balance +
                ", user ID=" + user.getId() +
                '}';
    }
}
