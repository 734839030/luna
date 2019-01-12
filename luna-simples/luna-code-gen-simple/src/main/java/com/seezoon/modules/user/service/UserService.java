package com.seezoon.modules.user.service;

import org.springframework.stereotype.Service;
import com.seezoon.luna.service.CrudService;
import com.seezoon.modules.user.dao.UserDao;
import com.seezoon.modules.user.entity.User;

/**
 * 用户信息Service
 * Copyright &copy; 2018 powered by huangdf, All rights reserved.
 * @author hdf 2019-1-12 19:43:34
 */
@Service
public class UserService extends CrudService<UserDao, User>{

}
