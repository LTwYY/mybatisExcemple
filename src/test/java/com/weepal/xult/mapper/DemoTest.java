package com.weepal.xult.mapper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.weepal.xult.po.User;

/**
 * 测试学习案例,用于日后忘记回顾
 * 
 * @author xult
 * @date 2017年3月15日 下午4:14:14
 */
public class DemoTest {
    private static UserMapper userMapper;
    private static SqlSession sqlSession;

    @Test
    public void testfindUserById() throws Exception {
        User user = userMapper.findUserById(1);
        System.out.println(user);
        assertEquals(1, user.getId());
    }

    @Test
    public void testfindUserByUsername() throws Exception {
        List<User> users = userMapper.findUserByUsername("小明");
        System.out.println(users);

    }

    /*
     * @BeforeClass：修饰static的方法，在整个类执行之前执行该方法一次。比如你的测试用例执行前需要一些高开销的资源（连接数据库）可以用@BeforeClass搞定。
     * 值得注意的是如果测试用例类的父类中也存在@BeforeClass修饰的方法，它将在子类的@BeforeClass之前执行。
     * 
     * @AfterClass：同样修饰static的方法，在整个类执行结束前执行一次。如果你用@BeforeClass创建了一些资源现在是时候释放它们了。
     * 
     * @Before：修饰public void的方法，在每个测试用例（方法）执行时都会执行。
     * 
     * @After：修饰public void的方法，在每个测试用例执行结束后执行。
     * Constructor：每个测试用例都会重新创建当前的Class实例，可以看到Constructor执行了两次。
     */

    /**
     * \@Before 在运行测试方法前调用此方法,多用于公用的初始化
     * <p>
     * 在每个测试用例（方法）执行时都会执行
     * 
     * @return
     * @throws IOException
     * @author xult
     * @date 2017年3月15日下午3:54:11
     * @version 1.0
     */
    @BeforeClass
    public static void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    /**
     * \@After运行完测试方法后运行此方法,常用于释放资源,即使测试方法抛出异常
     * <p>
     * 在每个测试用例（方法）执行时都会执行
     * 
     * @author xult
     * @date 2017年3月15日下午4:22:47
     * @version 1.0
     */
    @AfterClass
    public static void clossSource() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
