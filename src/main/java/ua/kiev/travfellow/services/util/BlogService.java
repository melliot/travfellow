package ua.kiev.travfellow.services.util;

import ua.kiev.travfellow.entity.Blog;
import ua.kiev.travfellow.entity.BlogEntry;

public interface BlogService {

    public BlogEntry createBlogEntry(Long blogId, BlogEntry data);

    public BlogList findAllBlogs();
    public BlogEntryList findAllBlogEntries(Long blodId);
    public Blog findBlod(Long id);
}
