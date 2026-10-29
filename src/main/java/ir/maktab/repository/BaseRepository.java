package ir.maktab.repository;

import ir.maktab.entity.User;
import jakarta.persistence.*;

import java.util.List;

public abstract class BaseRepository<E> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    protected EntityManager entityManager = emf.createEntityManager();

    protected abstract Class<E> getclass ();
    protected abstract String getTableName ();

    public void save(E entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public void update(E entity) {
        entityManager.merge(entity);
    }

    public void remove(E entity) {
        entityManager.remove(entity);
    }

    public E findById(Integer id) {
        E entity = entityManager.find(getclass(), id);
        return entity;
    }

    public List<E> findAll() {
        String jpql ="SELECT u FROM " + getTableName() + " u";
        TypedQuery<E> query = entityManager.createQuery(jpql, getclass());
        return query.getResultList();

    }

}
