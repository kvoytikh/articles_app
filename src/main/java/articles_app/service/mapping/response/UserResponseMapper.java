package articles_app.service.mapping.response;

import articles_app.model.User;
import articles_app.model.dto.response.UserResponseDto;
import articles_app.service.mapping.DtoResponseMapper;

public class UserResponseMapper implements DtoResponseMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User object) {
        return null;
    }
}
