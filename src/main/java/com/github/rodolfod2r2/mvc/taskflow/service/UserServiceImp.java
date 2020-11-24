package com.github.rodolfod2r2.mvc.taskflow.service;


import com.github.rodolfod2r2.mvc.taskflow.document.User;
import com.github.rodolfod2r2.mvc.taskflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements GenericsInterfaceService<User> {

    @Autowired
    UserRepository userRepository;


    @Override
    public Page<User> findAllPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
