package com.board.web.repository;

import com.board.web.constants.PostActivationStatus;
import com.board.web.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, String> {
    List<PostEntity> findAllByParentBoardAndStatus(String parentBoard, PostActivationStatus status);
}
