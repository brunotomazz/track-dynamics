package com.trackdynamics.repository;

import com.trackdynamics.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository <Task,Integer> {//Task é o tipo do objeto, Integer é o tipo id.
    @Query("select t from Task t where t.user.name = :name")
    List<Task> findByUserName(String name);

    @Query(value="select * from tasks inner join users on users.id = tasks.id_user where users.name = :name", nativeQuery = true)
    List<Task> findTaskByName(String name);

    Optional<Task> findTaskByTitle(String title);

    List<Task> findByTitleAndDescriptionAndPriority(String title, String description, String priority);

    void deleteByUserId(Integer id);
}
