package ir.maktab.service;

public interface UserService {

    void register(String username, String password, String email);

    void deleteAccount(String username);

}
