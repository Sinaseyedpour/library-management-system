package ir.maktab.service;

import ir.maktab.entity.User;
import ir.maktab.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void register(String username, String password, String email) {

        if (username == null || password == null || email == null) {
            throw new IllegalArgumentException("info is not valid!");
        }

        User byEmail = userRepository.findByEmail(email);
        if (byEmail != null) {
            throw new IllegalArgumentException("email is not valid!");
        }

        User byUsername = userRepository.findByUsername(username);
        if (byUsername != null) {
            throw new IllegalArgumentException("username already exist!");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        userRepository.save(user);
    }

    @Override
    public void deleteAccount(String username) {

        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) {
            throw new IllegalArgumentException("username is not valid");
        }

        userRepository.remove(byUsername);

    }
}
