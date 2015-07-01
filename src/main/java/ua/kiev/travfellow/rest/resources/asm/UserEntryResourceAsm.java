package ua.kiev.travfellow.rest.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import ua.kiev.travfellow.controller.UserEntryController;
import ua.kiev.travfellow.entity.UserEntry;
import ua.kiev.travfellow.rest.resources.UserEntryResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class UserEntryResourceAsm extends ResourceAssemblerSupport<UserEntry, UserEntryResource> {

    public UserEntryResourceAsm()
    {
        super(UserEntryController.class, UserEntryResource.class);
    }

    @Override
    public UserEntryResource toResource(UserEntry userEntry) {
        UserEntryResource user = new UserEntryResource();
        user.setName(userEntry.getName());
        Link link = linkTo(UserEntryController.class).slash(userEntry.getId()).withSelfRel();
        user.add(link);

        return user;
    }
}
