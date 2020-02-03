package com.sanchous.crello.taskjob;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alexandr S. Somov
 * Все права принадлежат автору. За использование без ведома и разрешения автора вам будет стыдно.
 */
public interface TaskJobRepository extends CrudRepository<TaskJob, Long> {

    List<TaskJob> findAllByTaskListId(Long taskListId);

    Optional<TaskJob> findByIdAndTaskListId(Long id, Long taskListId);
}
