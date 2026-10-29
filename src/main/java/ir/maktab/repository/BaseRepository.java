package ir.maktab.repository;

import ir.maktab.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public abstract class BaseRepository<E> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    protected EntityManager entityManager = emf.createEntityManager();

    protected abstract Class<E> getclass ();
    protected abstract String getTableName ();

    void save(E entity) {
        entityManager.persist(entity);
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
