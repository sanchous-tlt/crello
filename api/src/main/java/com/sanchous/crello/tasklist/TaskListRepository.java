package com.sanchous.crello.tasklist;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alexandr S. Somov
 * Все права принадлежат автору. За использование без ведома и разрешения автора вам будет стыдно.
 */
public interface TaskListRepository extends CrudRepository<TaskList, Long> {

    List<TaskList> findAllByUserId(String userId);

    Optional<TaskList> findByIdAndUserId(Long id, String userId);
}
