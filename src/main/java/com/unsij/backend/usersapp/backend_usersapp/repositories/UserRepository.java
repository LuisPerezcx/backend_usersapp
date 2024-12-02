package com.unsij.backend.usersapp.backend_usersapp.repositories;

import com.unsij.backend.usersapp.backend_usersapp.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}