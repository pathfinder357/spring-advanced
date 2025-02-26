package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    /* N+1 문제 Todo 엔티티 와 User 엔티티과 연관돼어 있으므로 Todo
    조회를 하면서 각 Todo에 대한 User 개별 조회하면 N+1 문제 발생
            */

    @EntityGraph(attributePaths = "user") // User 엔티티를 함께 조회
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);


    @Query("SELECT t FROM Todo t " +
            "LEFT JOIN FETCH t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);

    int countById(Long todoId);
}
