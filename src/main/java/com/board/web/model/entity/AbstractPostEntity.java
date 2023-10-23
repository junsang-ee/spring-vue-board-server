package com.board.web.model.entity;

import com.board.web.constants.PostActivationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractPostEntity extends AbstractBaseEntity {
    private String content;

    @Enumerated(EnumType.STRING)
    private PostActivationStatus status;

    @PrePersist
    public void onPrevisionPersist() {
        this.status = PostActivationStatus.NORMAL;
    }
}
