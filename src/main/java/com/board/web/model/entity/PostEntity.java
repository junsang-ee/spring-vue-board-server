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
public class PostEntity extends AbstractPostEntity {

    private String title;

    @Enumerated(EnumType.STRING)
    private BoardActivationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentBoard", nullable = false)
    private BoardEntity parentBoard;
    @PrePersist
    public void onPrevisionPersist() {
        this.status = BoardActivationStatus.NORMAL;
    }
}