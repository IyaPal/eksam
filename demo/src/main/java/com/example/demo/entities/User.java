package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotBlank(message = "Must enter a name")
  private String name;

  @NotBlank(message = "Must enter a task")
  private String task;

  public User() {
  }

  public User(String name, String task) {
    this.name = name;
    this.task = task;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public String getName() {
    return name;
  }

  public String getTask() {
    return task;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", name=" + name + ", task=" + task + '}';
  }
}
