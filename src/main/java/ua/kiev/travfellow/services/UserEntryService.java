package ua.kiev.travfellow.services;

import ua.kiev.travfellow.entity.Blog;
import ua.kiev.travfellow.entity.UserEntry;

public interface UserEntryService {
    public UserEntry find(Long id);
    public UserEntry delete(Long id);

    public UserEntry update(Long id, UserEntry data);

    public UserEntry createUser(UserEntry data);
    public Blog createBlog(Long userId, Blog Data);
}
