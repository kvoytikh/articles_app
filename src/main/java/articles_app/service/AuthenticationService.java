package articles_app.service;

import articles_app.exception.AuthenticationException;
import articles_app.model.User;

public interface AuthenticationService {
    User login(String login, String password) throws AuthenticationException;
}
