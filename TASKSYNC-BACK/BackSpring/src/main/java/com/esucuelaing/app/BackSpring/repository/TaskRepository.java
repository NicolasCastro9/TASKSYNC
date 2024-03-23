package com.esucuelaing.app.BackSpring.repository;

import com.esucuelaing.app.BackSpring.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, Integer> {

}
