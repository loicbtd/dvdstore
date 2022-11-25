package fr.utbm.dvdstore.domain.entity;

public class Actor implements java.io.Serializable {
    private Integer id;
    private String lastname;
    private String firstname;

    public Actor() {
    }

    public Actor(Integer id, String lastname) {
        this.id = id;
        this.lastname = lastname;
    }

    public Actor(Integer id, String lastname, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Actor{" + "id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + '}';
    }
}
