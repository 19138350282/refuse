package com.example.refuse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.refuse.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper

public interface UserMapper extends BaseMapper {
    User queryById(String openid);

    void insert(User user);

    void updateUser(User user);
}
