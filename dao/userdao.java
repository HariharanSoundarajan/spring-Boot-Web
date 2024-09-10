package com.payil.dao;

import org.springframework.data.repository.CrudRepository;

import com.payil.Model.User;

public interface userdao extends CrudRepository<User, Integer> {

}
