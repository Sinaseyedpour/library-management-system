package ir.maktab.service;

import ir.maktab.entity.Book;
import ir.maktab.entity.Loan;
import ir.maktab.entity.LoanStatus;
import ir.maktab.entity.User;
import ir.maktab.repository.BookRepository;
import ir.maktab.repository.LoanRepository;
import ir.maktab.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

public class LoanServiceImpl implements LoanService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;


    public LoanServiceImpl(UserRepository userRepository, BookRepository bookRepository, LoanRepository loanRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    public List<Loan> findLoansByStatus(LoanStatus status) {
        return loanRepository.findLoansByStatus(status);
    }

    @Override
    public boolean lendBook(String username, Integer bookId) {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) {
            throw new IllegalArgumentException("not found username");
        }
        Book byId = bookRepository.findById(bookId);
        if (byId == null) {
            throw new IllegalArgumentException("not found bookId");
        }
        Loan activeLoanByBookId = loanRepository.findActiveLoanByBookId(bookId);
        if (activeLoanByBookId != null) {
            throw new IllegalArgumentException("book is not available");
        }
        long l = loanRepository.countActiveLoansByMemberId(byUsername.getId());
        if (l >= byUsername.getBorrowLimit()) {
            throw new IllegalArgumentException("user has reached borrowLimit");
        }
        Loan loan = new Loan(byId, byUsername, LoanStatus.ACTIVE, LocalDate.now());
        loanRepository.save(loan);
        return true;
    }
}