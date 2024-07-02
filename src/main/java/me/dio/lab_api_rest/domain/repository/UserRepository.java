package me.dio.lab_api_rest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.lab_api_rest.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
