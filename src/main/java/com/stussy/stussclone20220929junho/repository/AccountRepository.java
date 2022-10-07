package com.stussy.stussclone20220929junho.repository;

import com.stussy.stussclone20220929junho.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    public int save(User user);
    public User findUserByEmail(String Email);
}
