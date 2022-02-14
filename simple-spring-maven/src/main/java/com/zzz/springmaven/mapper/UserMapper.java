package com.zzz.springmaven.mapper;

import com.zzz.springmaven.model.bo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserMapper extends CrudRepository<User,Long> {
    User queryUserByUsername(String username);
}
