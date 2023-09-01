package com.board.web.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userName"})
})
@Entity
public class UserEntity extends ModificationTimestampEntity {
    private String userName;

    private String password;

    private String email;

}
