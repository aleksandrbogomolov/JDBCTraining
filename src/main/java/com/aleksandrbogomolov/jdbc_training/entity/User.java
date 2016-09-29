package com.aleksandrbogomolov.jdbc_training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends NamedEntity {

    private String email;

    private Role role;

    private LocalDateTime createdDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.getId() +
                ", name=" + this.getName() +
                ", email='" + email +
                ", role=" + role +
                ", createdDate=" + createdDate +
                '}';
    }
}
