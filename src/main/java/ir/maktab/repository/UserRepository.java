package ir.maktab.repository;

import ir.maktab.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager entityManager = emf.createEntityManager();

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void remove(User user) {
        entityManager.remove(user);
    }

    public User findById(Integer id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    public List<User> findAll() {
        String jpql ="select u From User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();

    }
}
