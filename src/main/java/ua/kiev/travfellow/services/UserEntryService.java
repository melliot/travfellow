package ua.kiev.travfellow.services;

import ua.kiev.travfellow.entity.UserEntry;

public interface UserEntryService {
    public UserEntry find(Long id);
    public UserEntry delete(Long id);

    public UserEntry update(Long id, UserEntry data);
}
