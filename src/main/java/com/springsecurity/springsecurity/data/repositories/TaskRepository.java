package com.springsecurity.springsecurity.data.repositories;

import com.springsecurity.springsecurity.data.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tasks")
public interface TaskRepository  extends JpaRepository<Task, Integer> {

}
