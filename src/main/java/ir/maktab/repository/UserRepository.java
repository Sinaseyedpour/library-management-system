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
}
