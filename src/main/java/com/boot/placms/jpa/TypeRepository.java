package com.boot.placms.jpa;


import com.boot.placms.pojo.Type;
import com.boot.placms.util.BaseRepository;

public interface TypeRepository extends BaseRepository<Type,Long> {
    Type findByName(String name);
}
