package com.diallo.lab7.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Role> roles = new ArrayList<>();
    public void addRole(Role role) {
        roles.add(role);
    }
    public void removeRole(Role role) {
        roles.remove(role);
    }

    public String [] getRoleNames(){
        return roles.stream()
                .map(Role::getRoleName).toArray(String[]::new);
    }



}
