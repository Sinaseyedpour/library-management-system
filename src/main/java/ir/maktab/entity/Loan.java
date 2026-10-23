package ir.maktab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Integer userId;
    private Integer bookId;
    private LoanStatus loanStatus;
    private LocalDate borrowDate;
    private LocalDate dueDate;

}

