package com.aleksandrbogomolov.jdbc_training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends NamedEntity {

    private String email;

    private LocalDate createdDate;

    private Set<Role> roles;

    public User(int id, String name, String email, LocalDate createdDate) {
        super(id, name);
        this.email = email;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.getId() +
                ", name=" + this.getName() +
                ", email='" + email +
                ", createdDate=" + createdDate +
                '}';
    }
}
