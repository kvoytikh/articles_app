package articles_app.service.mapping.request;

import articles_app.model.User;
import articles_app.model.dto.request.UserRequestDto;
import articles_app.service.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements DtoRequestMapper<UserRequestDto, User> {
    @Override
    public User fromDto(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
