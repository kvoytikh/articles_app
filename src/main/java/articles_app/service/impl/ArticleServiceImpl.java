package articles_app.service.impl;

import articles_app.model.Article;
import articles_app.repository.ArticleRepository;
import articles_app.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = {"coordinates"})
@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Article add(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
}
