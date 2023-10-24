package com.board.web.model.entity;

import com.board.web.constants.BoardActivationStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class BoardEntity extends AbstractBaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private BoardActivationStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "parentBoard", fetch = FetchType.LAZY)
    private List<PostEntity> posts;

    @PrePersist
    public void onPrevisionPersist() {
        this.status = BoardActivationStatus.NORMAL;
    }

}
