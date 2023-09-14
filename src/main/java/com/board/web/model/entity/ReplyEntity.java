package com.board.web.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reply")
public class ReplyEntity extends AbstractPostEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentPost", nullable = false)
    private PostEntity parentPost;

}
