package com.zl.awesome.jpa;


import com.zl.awesome.pojo.User;
import com.zl.awesome.util.BaseRepository;

public interface UserRepository extends BaseRepository<User,String> {
    User findByName(String name);
}
