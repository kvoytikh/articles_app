package articles_app.controllers;

import articles_app.model.Article;
import articles_app.model.dto.request.ArticleRequestDto;
import articles_app.service.ArticleService;
import articles_app.service.mapping.request.ArticleRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private static final String SESSION_ATTRIBUTE = "article_id";
    private final ArticleService articleService;
    private final ArticleRequestMapper articleRequestMapper;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("articleForm", new ArticleRequestDto());
        return "articles/add";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute("articleForm") ArticleRequestDto articleRequestDto, BindingResult bindingResult,
                            HttpServletRequest req) {
        if (bindingResult.hasErrors()) {
            return "articles/add";
        }
        HttpSession session = req.getSession();
        Long articleId = (Long) session.getAttribute(SESSION_ATTRIBUTE);
        articleRequestDto.setId(articleId);
        articleService.add(articleRequestMapper.fromDto(articleRequestDto));
        return "redirect:/articles/all";
    }

    @GetMapping("/all")
    public String getAll(HttpServletRequest req) {
        List<Article> allArticles = articleService.getAll();
        req.setAttribute("articles", allArticles);
        return "articles/all";
    }
}
