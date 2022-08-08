package com.trackdynamics.repository;

import com.trackdynamics.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task,Integer> {//Task é o tipo do objeto, Integer é o tipo id.
    @Query("select t from Task t where t.user.name = :name")
    List<Task> findByUserName(String name);

    //select * from tasks where id_user = 1
}
