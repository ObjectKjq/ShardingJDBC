package com.kdf.shardingjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kdf.shardingjdbc.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Author: 张红尘
 * @Date: 2021-07-20
 * @Version： 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    void addUser(User user);

    List<User> findUsers();
}
