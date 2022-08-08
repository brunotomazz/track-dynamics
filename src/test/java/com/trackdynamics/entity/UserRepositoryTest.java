package com.trackdynamics.entity;

import com.trackdynamics.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired // fazer uma injeção de dependenias(busca tudo que precisa pra classe funcionar)
    private UserRepository repository;

    @Test
    @DisplayName("Quando buscar um usuário no banco, ele deve existir e ter o nome igual ao objeto salvo")
    void testCreateUser(){
        User leonardo = User.builder()
                .name("Leonardo")
                .lastName("da Costa")
                .password("123456").build();

        User bruno = User.builder()
                .name("Bruno")
                .lastName("Tomaz")
                .password("123456").build();

        leonardo = repository.save(leonardo); // criando e salvando um usuário.
        bruno = repository.save(bruno);

        Optional<User> findBruno = repository.findById(bruno.getId());
        assertThat(findBruno.isPresent()).isTrue();
        assertThat(findBruno.get().getName()).isEqualTo("Bruno");

        Optional<User> findLeonardo = repository.findById(leonardo.getId()); // busca variável
        assertThat(findLeonardo.isPresent()).isTrue(); // verifica se está presente no db
        assertThat(findLeonardo.get().getName()).isEqualTo("Leonardo"); // verifica se o nome da busca é igual ao que foi salvo
    }

    @Test
    void testdeleteUser(){
        User bruno = User.builder()
                .name("Bruno")
                .lastName("Tomaz")
                .password("123456").build();

        bruno = repository.save(bruno);
        repository.delete(bruno);

        Optional<User> testDeleteUser = repository.findById(bruno.getId());
        assertThat(testDeleteUser.isPresent()).isFalse();
    }

    @Test
    void testUpdateUser(){
        User felipe = User.builder()
                .name("Felipe")
                .lastName("Neves")
                .password("123456").build();

        felipe = repository.save(felipe);
        felipe.setName("Agnaldo");
        felipe = repository.save(felipe);

        Optional<User> testUpdateUser = repository.findById(felipe.getId());
        assertThat(testUpdateUser.isPresent()).isTrue();
        assertThat(testUpdateUser.get().getName()).isEqualTo("Agnaldo");
    }

    @Test
    void testFindByEmail(){
        User leonardo = User.builder()
                .name("Leonardo")
                .lastName("da Costa")
                .password("123456")
                .email("leonardo.costaa2@gmail.com").build();

        repository.save(leonardo); // criando e salvando um usuário.
        Optional<User> findLeonardo = repository.findByEmail("leonardo.costaa2@gmail.com");
        assertThat(findLeonardo.isPresent()).isTrue();
        assertThat(findLeonardo.get().getEmail()).isEqualTo("leonardo.costaa2@gmail.com");
    }

    @Test
    void testFindByName(){
        User leonardo = User.builder()
                .name("Leonardo")
                .lastName("da Costa")
                .password("123456")
                .email("leonardo.costaa2@gmail.com").build();

        repository.save(leonardo); // criando e salvando um usuário.
        List<User> findName = repository.findByName("Leonardo");
        assertThat(findName.isEmpty()).isFalse();
        assertThat(findName.get(0).getName()).isEqualTo("Leonardo");
        assertThat(findName).extracting("name").contains("Leonardo");
    }

    @Test
    void testFindLastName(){
        User leonardo = User.builder()
                .name("Leonardo")
                .lastName("da Costa")
                .password("123456")
                .email("leonardo.costaa2@gmail.com").build();

        repository.save(leonardo); // criando e salvando um usuário.
        List<User> findLastName = repository.findByLastName("da Costa");// lista de usuários filtrada por sobrenome
        assertThat(findLastName.isEmpty()).isFalse(); // checa se a condição "lista vazia" é falsa.
        assertThat(findLastName.get(0).getLastName()).isEqualTo("da Costa");// checa se o sobrenome é "da Costa"
    }
}
