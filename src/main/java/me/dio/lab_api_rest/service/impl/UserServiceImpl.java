package me.dio.lab_api_rest.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.lab_api_rest.domain.model.User;
import me.dio.lab_api_rest.domain.repository.UserRepository;
import me.dio.lab_api_rest.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This user ID already exists!");
        }
        return userRepository.save(userToCreate);
    }
    
}
