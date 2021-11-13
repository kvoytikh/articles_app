package articles_app.service.impl;

import articles_app.exception.AuthenticationException;
import articles_app.model.User;
import articles_app.service.AuthenticationService;
import articles_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Optional;

@CacheConfig(cacheNames = {"coordinates"})
@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    @Override
    public User login(String login, String password) throws AuthenticationException {
        Optional<User> user = userService.findByLogin(login);
        if (user.isEmpty() || !user.get().getPassword().equals(password)) {
            throw new AuthenticationException("Incorrect password or login");
        }
        return user.get();
    }
}
