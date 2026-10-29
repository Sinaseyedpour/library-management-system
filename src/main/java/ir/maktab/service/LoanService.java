package ir.maktab.service;

import ir.maktab.entity.Loan;
import ir.maktab.entity.LoanStatus;
import ir.maktab.repository.BookRepository;
import ir.maktab.repository.LoanRepository;
import ir.maktab.repository.UserRepository;

import java.util.List;

public class LoanService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;


    public LoanService(UserRepository userRepository, BookRepository bookRepository, LoanRepository loanRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    public List<Loan> findLoansByStatus(LoanStatus status) {
        return loanRepository.findLoansByStatus(status);
    }

    public Loan findActiveLoanByBookId(Long bookId) {

        return loanRepository.findActiveLoanByBookId(bookId);
    }
}
