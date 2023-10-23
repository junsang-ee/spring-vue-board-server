package com.board.web.model.entity;

import com.board.web.constants.BoardActivationStatus;
import com.board.web.constants.PostActivationStatus;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentBoard", nullable = false)
    private BoardEntity parentBoard;
//    @PrePersist
//    public void onPrevisionPersist() {
//        super.setStatus(PostActivationStatus.NORMAL);\
//    }
}