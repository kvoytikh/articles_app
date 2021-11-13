package articles_app.service;

import articles_app.model.Article;

import java.util.List;

public interface ArticleService {
    Article add(Article article);
    List<Article> getAll();
}
