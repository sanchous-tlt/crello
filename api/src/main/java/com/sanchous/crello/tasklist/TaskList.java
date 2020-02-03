package com.sanchous.crello.tasklist;

import com.sanchous.crello.user.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Alexandr S. Somov
 * Все права принадлежат автору. За использование без ведома и разрешения автора вам будет стыдно.
 */
@Entity
@Table(name = "TASKLISTS")
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TASK_LIST_NAME")
    private String taskListName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public TaskList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskListName() {
        return taskListName;
    }

    public void setTaskListName(String taskListName) {
        this.taskListName = taskListName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
