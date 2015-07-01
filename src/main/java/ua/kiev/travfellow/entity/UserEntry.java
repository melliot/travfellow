package ua.kiev.travfellow.entity;

public class UserEntry {
    public long getId() {
        return id;
    }

    private long id;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
