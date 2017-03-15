package com.weepal.xult.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.weepal.xult.dao.UserMapper;
import com.weepal.xult.po.User;

/**
 * 第一案例.测试
 * 
 * @author xult
 * @date 2017年3月15日 下午2:38:01
 */
public class MyBatisFirst {
    private UserMapper userMapper;
    private SqlSession sqlSession;

    @Test
    public void testfindUserById() throws Exception {
        init();
        User user = userMapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testfindUserByUsername() throws Exception {
        init();
        List<User> users = userMapper.findUserByUsername("小明");
        System.out.println(users);
        sqlSession.close();
    }

    /**
     * 
     * @return
     * @throws IOException 
     * @author xult 
     * @date 2017年3月15日下午3:54:11 
     * @version 1.0 
     */
    private void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        // User user = sqlSession.selectOne("com.weepal.xult.dao.UserMapper.findUserById", 1);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
}
