package articles_app.service;

import articles_app.model.User;

import java.util.Optional;

public interface UserService {
    User add(User user);
    Optional<User> findByLogin(String username);
    User getById(Long id);
}
