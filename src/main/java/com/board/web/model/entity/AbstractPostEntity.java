package com.board.web.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractPostEntity extends AbstractBaseEntity {
    private String content;
}
