package ua.kiev.travfellow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.kiev.travfellow.entity.BlogEntry;
import ua.kiev.travfellow.rest.resources.BlogEntryResource;
import ua.kiev.travfellow.rest.resources.asm.BlogEntryResourceAsm;
import ua.kiev.travfellow.services.BlogEntryService;

@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {
    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service)
    {
        this.service = service;
    }

    @RequestMapping(value="/{blogEntryId}",
            method = RequestMethod.GET)
    public ResponseEntity<BlogEntryResource> getBlogEntry(
            @PathVariable Long blogEntryId) {
        BlogEntry entry = service.find(blogEntryId);
        if(entry != null)
        {
            BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);
            return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{blogEntryId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<BlogEntryResource> deleteBlogEntry(
            @PathVariable Long blogEntryId) {
        BlogEntry entry = service.delete(blogEntryId);

        if(entry != null)
        {
            BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);
            return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{blogEntryId}",
            method = RequestMethod.PUT)
    public ResponseEntity<BlogEntryResource> updateBlogEntry(
            @PathVariable Long blogEntryId, @RequestBody BlogEntryResource sentBlogEntry) {
        BlogEntry updatedEntry = service.update(blogEntryId, sentBlogEntry.toBlogEntry());
        if(updatedEntry != null)
        {
            BlogEntryResource res = new BlogEntryResourceAsm().toResource(updatedEntry);
            return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
        }
    }
}