package com.board.web.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@MappedSuperclass
public abstract class CustomBaseIdEntity implements Persistable<String> {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name="idGenerator", strategy = "com.board.web.config.CustomBaseIdGenerator")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return id == null;
    }
}
