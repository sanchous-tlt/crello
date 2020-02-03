package com.sanchous.crello.taskjob;

import com.sanchous.crello.tasklist.*;
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
@RequestMapping("/users/{userId}/tasklists/{taskListId}/taskjobs")
public class TaskJobResource {

    @Autowired
    private TaskJobService taskJobService;

    @GetMapping
    public ResponseEntity<List<TaskJob>> getAllTaskJobs(@PathVariable Long taskListId) {
        return new ResponseEntity<>(taskJobService.getAllTaskJobsByTaskList(taskListId), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<TaskJob> getTaskJob(@PathVariable Long id, @PathVariable Long taskListId) {
        return taskJobService.getTaskJobByTaskList(id, taskListId).isPresent()
                ? new ResponseEntity<>(taskJobService.getTaskJobByTaskList(id, taskListId).get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity createTaskJob(@RequestBody TaskJob taskJob, @PathVariable("taskListId") TaskList taskList) {
        taskJobService.createTaskJob(taskJob, taskList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity updateTaskJob(@PathVariable Long id, @RequestBody TaskJob taskJob, @PathVariable("taskListId") TaskList taskList) {
        taskJob.setId(id);
        taskJobService.updateTaskJob(taskJob, taskList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTaskJob(@PathVariable Long id) {
        taskJobService.deleteTaskJob(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
