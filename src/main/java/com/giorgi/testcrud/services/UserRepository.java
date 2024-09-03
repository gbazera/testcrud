package com.giorgi.testcrud.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.giorgi.testcrud.models.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String>{

  // @Query("{'active': true}")
  // List<UserModel> getUsers();

  public long count();
}
