package ua.kiev.travfellow.entity;

public class UserEntry {
    public long getId() {
        return id;
    }

    private long id;
    private String name;
    private String pasword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
