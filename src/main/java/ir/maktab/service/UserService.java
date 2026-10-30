package ir.maktab.service;

import ir.maktab.entity.User;

public interface UserService {

    void register (String username, String password, String email);

    void deleteAccount (String username);

}
