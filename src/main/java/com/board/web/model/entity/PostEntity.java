package com.board.web.model.entity;

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

}