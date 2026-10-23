import ir.maktab.entity.User;
import ir.maktab.repository.UserRepository;
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
//    EntityTransaction transaction = entityManager.getTransaction();
//    transaction.begin();
//    User first = new User(13, "mani", "1234");
//    entityManager.persist(first);
//    User user = entityManager.find(User.class, 12);
//    System.out.println(user);
//    transaction.commit();
    UserRepository userRepository = new UserRepository();
    System.out.println("userRepository.findAll() = " + userRepository.findAll());

}