package com.sanchous.crello.tasklist;

import com.sanchous.crello.user.User;
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
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    public List<TaskList> getAllTaskListsByUser(String userId) {

        List<TaskList> taskLists = new ArrayList<>();
        taskListRepository.findAllByUserId(userId).forEach(taskLists::add);

        return taskLists;
    }

    public Optional<TaskList> getTaskListByUser(Long id, String userId) {
        return taskListRepository.findByIdAndUserId(id, userId);
    }

    public void createTaskList(TaskList taskList, User user) {
        taskList.setUser(user);
        taskListRepository.save(taskList);
    }

    public void updateTaskList(TaskList taskList, User user) {
        taskList.setUser(user);
        taskListRepository.save(taskList);
    }

    public void deleteTaskList(Long id) {
        taskListRepository.deleteById(id);
    }
}
