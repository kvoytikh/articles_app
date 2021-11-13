package articles_app.service.impl;

import articles_app.model.User;
import articles_app.repository.UserRepository;
import articles_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import java.util.Optional;

@CacheConfig(cacheNames = {"coordinates"})
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }


    @Override
    public Optional<User> findByLogin(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }
}
