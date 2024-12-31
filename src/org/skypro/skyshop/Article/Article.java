package org.skypro.skyshop.Article;
import org.skypro.skyshop.Search.Searchable;

public final class Article implements Searchable {
    private String title;
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getSearchTerm() {
        return title + "\n" + content;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }
}