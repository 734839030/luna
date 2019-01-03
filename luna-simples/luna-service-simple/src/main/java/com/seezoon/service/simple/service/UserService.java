package com.seezoon.service.simple.service;

import org.springframework.stereotype.Service;

import com.seezoon.luna.service.CrudService;
import com.seezoon.service.simple.dao.UserDao;
import com.seezoon.service.simple.entity.User;

@Service
public class UserService extends CrudService<UserDao,User>{

}
