package articles_app.service.mapping.request;

import articles_app.model.Article;
import articles_app.model.dto.request.ArticleRequestDto;
import articles_app.service.UserService;
import articles_app.service.mapping.DtoRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class ArticleRequestMapper implements DtoRequestMapper<ArticleRequestDto, Article> {
    private final UserService userService;

    @Override
    public Article fromDto(ArticleRequestDto dto) {
        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setAuthor(userService.getById(dto.getId()));
        article.setContent(dto.getContent());
        article.setDate(LocalDateTime.now());
        return article;
    }
}
