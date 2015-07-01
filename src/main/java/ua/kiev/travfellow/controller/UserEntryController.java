package ua.kiev.travfellow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kiev.travfellow.entity.UserEntry;
import ua.kiev.travfellow.rest.resources.UserEntryResource;
import ua.kiev.travfellow.rest.resources.asm.UserEntryResourceAsm;
import ua.kiev.travfellow.services.UserEntryService;

@Controller
@RequestMapping("/rest/user")
public class UserEntryController {
    private UserEntryService service;

    public UserEntryController(UserEntryService service)
    {
        this.service = service;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserEntryResource> getUserEntry(
            @PathVariable Long userId)
    {
        UserEntry user = service.find(userId);
        if(user != null){
            UserEntryResource res = new UserEntryResourceAsm().toResource(user);
            return new ResponseEntity<UserEntryResource>(res, HttpStatus.OK);
        }
        return new ResponseEntity<UserEntryResource>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<UserEntryResource> updateUserEntry(
            @PathVariable Long userId)
    {
        UserEntry user = service.find(userId);
        if(user != null){
            UserEntryResource res = new UserEntryResourceAsm().toResource(user);
            return new ResponseEntity<UserEntryResource>(res, HttpStatus.OK);
        }
        return new ResponseEntity<UserEntryResource>(HttpStatus.NOT_FOUND);
    }
}
