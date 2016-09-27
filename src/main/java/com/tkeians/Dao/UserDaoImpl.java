package com.tkeians.Dao;

import com.tkeians.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by _ on 2016/9/26.
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory sessionFactory;
    private SqlSession session;

    public UserDaoImpl() {
        String resource = "conf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 此函数名与 userMapper.xml 中设置的 id 相同
    public User findUserById(int id) {
        String statement = "userMapper.findUserById";
        User user = session.selectOne(statement, id);
        return user;
    }

}
