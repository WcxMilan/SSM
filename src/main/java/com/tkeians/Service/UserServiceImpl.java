package com.tkeians.Service;

import com.tkeians.Dao.IUserDao;
import com.tkeians.Dao.UserDaoImpl;
import com.tkeians.Model.User;

/**
 * Created by _ on 2016/9/26.
 */
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

}
