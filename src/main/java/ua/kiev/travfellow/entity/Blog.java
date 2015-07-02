package ua.kiev.travfellow.entity;

public class Blog {

    public UserEntry getOwner() {
        return owner;
    }

    public void setOwner(UserEntry owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private UserEntry owner;

    private int id;

    private String title;


}
