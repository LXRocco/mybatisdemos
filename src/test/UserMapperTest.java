import com.mybatis.demos.domain.User;
import com.mybatis.demos.mapper.UserMapper;
import com.mybatis.demos.qo.UserParam;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lx
 * @version 1.0
 * @date 2019/10/7 19:52
 */
public class UserMapperTest {

    private final static String MYBATIS_CONFIG_FILE = "mybatis-config.xml";

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(2);

        sqlSession.close();

        System.out.println(user.toString());

    }

    @Test
    public void testFindUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.findUserByName("sa");

        sqlSession.close();

        System.out.println(users);
    }

    @Test
    public void testFindUserByParam() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserParam userParam = new UserParam();

        userParam.setName("sa");
        userParam.setUsername("sa");
        List<User> users = userMapper.findUserByParam(userParam);
        sqlSession.close();
        System.out.println(users);
    }

    @Test
    public void testFindByParam() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserParam userParam = new UserParam();
//        userParam.setName("sa");
//        userParam.setUsername("sa");

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(6);
        ids.add(7);
        userParam.setIds(ids);

        List<String> usernames = new ArrayList<>();
        usernames.add("sa");
        usernames.add("sa2");
        usernames.add("test");
        usernames.add("admin");
        usernames.add("lisa");

        userParam.setUsernames(usernames);
        List<User> users = userMapper.findByParam(userParam);
        sqlSession.close();
        System.out.println(users);
    }


    @Test
    public void testFindUserItemAllByParam() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserParam userParam = new UserParam();
        List<String> usernames = new ArrayList<>();
        usernames.add("sa");
        usernames.add("bob");
        usernames.add("test");
        usernames.add("admin");
        usernames.add("lisa");
        userParam.setUsernames(usernames);
        List<User> users = userMapper.findUserItemAllByParam(userParam);
        sqlSession.close();
        System.out.println(users);
    }

    /**
     * 测试一级缓存
     * 一级缓存是SqlSession级别的，默认不需要配置，但是执行commit操作后，会自动清空SQLSession级别的一级缓存
     */
    @Test
    public void testOneClassCache() throws Exception{

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //第一次查询
        User u1 = userMapper.findUserById(2);
        System.out.println(u1);

//        u1.setUsername(u1.getUsername() + "test");
//        int result = userMapper.updateUserById(u1);
//
//        //执行commit操作，自动清空一级缓存
//        sqlSession.commit();

        //第二次查询
        User u2 = userMapper.findUserById(2);
        System.out.println(u2);

        //测试不同mapper是否也会默认从缓存找
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        User u3 = userMapper1.findUserById(2);
        System.out.println(u3);
        //关闭SqlSession
        sqlSession.close();
    }


    /**
     * 二级缓存测试代码
     * @throws Exception
     */
    @Test
    public void testSecondClassCache() throws Exception{

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2= sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        SqlSession sqlSession4 = sqlSessionFactory.openSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User u1 = userMapper1.findUserById(2); //二级缓存的对象必须是序列化对象

        //只有当sqlSession关闭时，才会写入缓存
        sqlSession1.close();
        System.out.println(u1);

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User u2 = userMapper2.findUserById(2);
        sqlSession2.close();
        System.out.println(u2);

//
//        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
//        User u3 = userMapper3.findUserById(2);
//        u3.setUsername(u3.getUsername());
//        userMapper3.updateUser(u3);
//        sqlSession3.commit();  //commit会fluse缓存，即mybatis会清空缓存
//        sqlSession3.close();
//        System.out.println(u3);


        UserMapper userMapper4 = sqlSession4.getMapper(UserMapper.class);
        User u4 = userMapper4.findUserById(2);
        sqlSession4.close();
        System.out.println(u4);
    }

}
