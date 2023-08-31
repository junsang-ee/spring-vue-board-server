package com.board.web.model.entity;

import com.board.web.constants.BoardActivationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class PostEntity extends CreationTimestampEntity{

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private BoardActivationStatus status;

    @PrePersist
    public void onPrevisionPersist() {
        this.status = BoardActivationStatus.NORMAL;
    }
}
