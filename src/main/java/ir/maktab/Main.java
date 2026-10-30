import ir.maktab.entity.*;
import ir.maktab.repository.BookRepository;
import ir.maktab.repository.LoanRepository;
import ir.maktab.repository.UserRepository;
import ir.maktab.service.LoanServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

void main() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();
//    entityManager.persist();
//    entityManager.find();
//    entityManager.merge();
//    entityManager.remove();
//    entityManager.contains();
//    User first = new User(13, "mani", "1234");
//    entityManager.persist(first);
//    User user = entityManager.find(User.class, 12);
//    System.out.println(user);
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
//    UserRepository userRepository = new UserRepository();
//    System.out.println("userRepository.findAll() = " + userRepository.findAll())
//    User user = new User(10, "sina", "1234");
//    Wallet wallet = new Wallet(12, 0, user);
//    user.setWallet(wallet);
//    entityManager.persist(user);
//    entityManager.persist(wallet);
//    User findUser = entityManager.find(User.class, 10);
//    System.out.println(findUser);

    User user = new User("sina", "1234");
    Book book = new Book("it", "sina", 1234);
    Loan loan = new Loan(book, user, LoanStatus.ACTIVE, LocalDate.now());
    UserRepository userRepository = new UserRepository();
    BookRepository bookRepository = new BookRepository();
    LoanRepository loanRepository = new LoanRepository();
    userRepository.save(user);
    bookRepository.save(book);
    loanRepository.save(loan);

    LoanServiceImpl loanServiceImpl = new LoanServiceImpl(userRepository, bookRepository, loanRepository);
    System.out.println("loanService.findLoansByStatus(LoanStatus.ACTIVE) = " + loanServiceImpl.findLoansByStatus(LoanStatus.ACTIVE));
    transaction.commit();
}