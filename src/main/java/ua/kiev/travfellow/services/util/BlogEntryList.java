package ua.kiev.travfellow.services.util;

import ua.kiev.travfellow.entity.BlogEntry;

import java.util.ArrayList;
import java.util.List;

public class BlogEntryList {
    private List<BlogEntry> entries = new ArrayList<BlogEntry>();

    public List<BlogEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<BlogEntry> entries) {
        this.entries = entries;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    private Long blogId;
}
