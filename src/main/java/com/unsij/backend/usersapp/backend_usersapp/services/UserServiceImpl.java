package com.unsij.backend.usersapp.backend_usersapp.services;

import com.unsij.backend.usersapp.backend_usersapp.models.entities.User;
import com.unsij.backend.usersapp.backend_usersapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly=true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Optional<User> update(User user, Long id) {
        Optional<User> userOptional = this.findById(id);
        User userResult = null;
        if(userOptional.isPresent()){
            User userDB = userOptional.orElseThrow();
            userDB.setUsername(user.getUsername());
            userDB.setEmail(user.getEmail());
            userResult =  this.save(userDB);
        }
        return Optional.ofNullable(userResult);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
