package com.sanchous.crello.taskjob;

import com.sanchous.crello.tasklist.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alexandr S. Somov
 * Все права принадлежат автору. За использование без ведома и разрешения автора вам будет стыдно.
 */
@Service
public class TaskJobService {

    @Autowired
    private TaskJobRepository taskJobRepository;

    public List<TaskJob> getAllTaskJobsByTaskList(Long taskListId) {

        List<TaskJob> taskJobs = new ArrayList<>();
        taskJobRepository.findAllByTaskListId(taskListId).forEach(taskJobs::add);

        return taskJobs;
    }

    public Optional<TaskJob> getTaskJobByTaskList(Long id, Long taskListId) {
        return taskJobRepository.findByIdAndTaskListId(id, taskListId);
    }

    public void createTaskJob(TaskJob taskJob, TaskList taskList) {
        taskJob.setTaskList(taskList);
        taskJobRepository.save(taskJob);
    }

    public void updateTaskJob(TaskJob taskJob, TaskList taskList) {
        taskJob.setTaskList(taskList);
        taskJobRepository.save(taskJob);
    }

    public void deleteTaskJob(Long id) {
        taskJobRepository.deleteById(id);
    }
}
