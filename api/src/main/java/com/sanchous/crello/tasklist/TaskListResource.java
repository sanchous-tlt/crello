package com.sanchous.crello.tasklist;

import com.sanchous.crello.user.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexandr S. Somov
 * Все права принадлежат автору. За использование без ведома и разрешения автора вам будет стыдно.
 */
@RestController
@RequestMapping("/users/{userId}/tasklists")
public class TaskListResource {

    @Autowired
    private TaskListService taskListService;

    @GetMapping
    public ResponseEntity<List<TaskList>> getAllTaskLists(@PathVariable String userId) {
        return new ResponseEntity<>(taskListService.getAllTaskListsByUser(userId), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<TaskList> getTaskList(@PathVariable Long id, @PathVariable String userId) {
        return taskListService.getTaskListByUser(id, userId).isPresent()
                ? new ResponseEntity<>(taskListService.getTaskListByUser(id, userId).get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity createTaskList(@RequestBody TaskList taskList, @PathVariable("userId") User user) {
        taskListService.createTaskList(taskList, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity updateTaskList(@PathVariable Long id, @RequestBody TaskList taskList, @PathVariable("userId") User user) {
        taskList.setId(id);
        taskListService.updateTaskList(taskList, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTaskList(@PathVariable Long id) {
        taskListService.deleteTaskList(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
