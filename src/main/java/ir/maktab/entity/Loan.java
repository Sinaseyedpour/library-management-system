package ir.maktab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private Book book;
    @ManyToOne
    private User user;
    private LoanStatus loanStatus;
    private LocalDate borrowDate;
    private LocalDate dueDate;


}

