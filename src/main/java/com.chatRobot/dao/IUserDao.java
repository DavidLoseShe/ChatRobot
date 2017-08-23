package com.chatRobot.dao;

import com.chatRobot.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {

    User selectUser(long id);

}