package com.trackdynamics.entity;

import com.trackdynamics.repository.TaskRepository;
import com.trackdynamics.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository repository;
    @Autowired
    private UserRepository userRepository;
    private User leonardo = User.builder()
            .name("Leonardo")
            .lastName("da Costa")
            .password("123456").build();

    @BeforeAll
    public void setup() {
        this.leonardo = userRepository.save(leonardo);
    }

    @Test
    void testCreateTask() {
        Task read = Task.builder()
                .title("Ler")
                .user(leonardo).build();

        read = repository.save(read);

        Optional<Task> findTask = repository.findById(read.getId());
        assertThat(findTask.isPresent()).isTrue();
        assertThat(findTask.get().getTitle()).isEqualTo("Ler");
        assertThat(findTask.get().getUser()).isEqualTo(leonardo);
    }

    @Test
    void testeCreateTaskList() {
        Task read = Task.builder()
                .title("Ler")
                .user(leonardo).build();

        read = repository.save(read);

        Task run = Task.builder()
                .title("Correr")
                .user(leonardo).build();

        run = repository.save(run);

        List<Task> createdTasks = Arrays.asList(read,run);
        List<Task> taskList = repository.findAll();
        assertThat(taskList.isEmpty()).isFalse();
        assertThat(taskList).hasSize(createdTasks.size());
    }

    @Test
    void testdeleteTask(){
        Task read = Task.builder()
                .title("Ler")
                .user(leonardo).build();

        read = repository.save(read);
        repository.delete(read);
        Optional<Task> deleteTask = repository.findById(read.getId());
        assertThat(deleteTask.isPresent()).isFalse();
    }

    @Test
    void testupdateTask(){
        Task read = Task.builder()
                .title("Ler")
                .user(leonardo).build();

        read = repository.save(read);
        read.setTitle("Play");
        repository.save(read);

        Optional<Task> testUpdateTask = repository.findById(read.getId());
        assertThat(testUpdateTask.isPresent()).isTrue();
        assertThat(testUpdateTask.get().getTitle()).isEqualTo("Play");
    }
}
