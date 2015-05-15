package server.entities;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Paul on 02/05/2015.
 */
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String address;
    private Integer cnp;
    private Integer icn;
    private Role role;
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = address;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    public int getIcn() {
        return icn;
    }

    public void setIcn(int icn) {
        this.icn = icn;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
