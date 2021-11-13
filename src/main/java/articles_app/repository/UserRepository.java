package articles_app.repository;

import articles_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT DISTINCT u FROM User u WHERE u.email LIKE %?1%")
    User findByUsername(String username);
}