package fr.utbm.dvdstore.domain.entity;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;
    private String username;
    private Boolean enable;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
