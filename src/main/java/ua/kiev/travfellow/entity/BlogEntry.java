package ua.kiev.travfellow.entity;

public class BlogEntry {
    private Long id;

    private String title;

    public String getTitle() {
        return title;
    }

    private Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}