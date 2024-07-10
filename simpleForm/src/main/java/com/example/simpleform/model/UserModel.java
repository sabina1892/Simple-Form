package com.example.simpleform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users_table")
public class UserModel {
    @Id
    @Column(name="id")
    String id;
    @Column(name="login")
    String login;
    @Column(name="password")
    String password;
    @Column(name="email")
    String email;

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
