package ir.maktab.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Loan {
    @Id
    private Integer loanId;

    public static final String TABLE_NAME = "loans";


    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", book=" + book +
                ", user=" + user +
                ", loanStatus=" + loanStatus +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                '}';
    }
}

