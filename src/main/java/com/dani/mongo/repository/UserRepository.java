package com.dani.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dani.mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
