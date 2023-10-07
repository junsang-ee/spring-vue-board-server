package com.board.web.repository;

import com.board.web.constants.BoardActivationStatus;
import com.board.web.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String> {
    List<BoardEntity> findAllByStatus(BoardActivationStatus status);
}
