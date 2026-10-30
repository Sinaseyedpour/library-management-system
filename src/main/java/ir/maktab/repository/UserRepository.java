package ir.maktab.repository;

import ir.maktab.entity.User;

public class UserRepository extends BaseRepository<User> {

    @Override
    protected Class<User> getclass() {

        return User.class;
    }

    @Override
    protected String getTableName() {

        return User.TABLE_NAME;
    }

    public User findByEmail(String email) {
        return entityManager.createQuery(
                "SELECT u from User u where u.email = ?1", User.class
        ).setParameter(1, email).getSingleResult();
    }
}