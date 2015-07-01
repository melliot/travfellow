package ua.kiev.travfellow.rest.resources;

import org.springframework.hateoas.ResourceSupport;
import ua.kiev.travfellow.entity.UserEntry;

public class UserEntryResource extends ResourceSupport {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntry toUserEntry(UserEntry userEntry){
        UserEntry user = new UserEntry();
        user.setName(name);
        return user;
    }
}
