package com.trackdynamics.repository;

import com.trackdynamics.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository <User,Integer> {
    Optional<User> findByEmail(String email); // Query para buscar usuário por email.

    @Query("select u from User u where u.name = :name") // :name é o valor passado para a query.
    List<User> findByName(@Param("name") String name);

    @Query(value="select * from users where last_name = :lastName", nativeQuery = true) // nativeQuery quer dizer que será feita com SQL puro.
    List<User> findByLastName(@Param("lastName") String lastName);


    //Criar método listAll
}
