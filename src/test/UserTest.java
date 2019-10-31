import com.mybatis.demos.dbConfig.MyBatisConnector;
import com.mybatis.demos.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author lx
 * @version 1.0
 * @date 2019/9/26 3:11
 * @descirption
 * @since
 */
public class UserTest {

    @Test
    public void findUserById() throws IOException {
        MyBatisConnector connector = new MyBatisConnector();
        SqlSession sqlSession = connector.openSqlSession();
        User user = sqlSession.selectOne("user.findUserById", 1);
        connector.closeSqlSession(sqlSession, false);
        System.out.println(user);
    }

    /**
     * @param
     * @return
     * @author lx
     * @date 2019/9/26 23:47
     */
    @Test
    public void findUserByName() throws IOException {
        MyBatisConnector connector = new MyBatisConnector();
        SqlSession sqlSession = connector.openSqlSession();
        List<User> users = sqlSession.selectList("user.findUserByName", "小明" + " 'or '1=1");   //sql注入
        connector.closeSqlSession(sqlSession, false);
        System.out.println(users);
    }

    @Test
    public void insertOneUser() throws IOException {
        MyBatisConnector connector = new MyBatisConnector();
        SqlSession sqlSession = connector.openSqlSession();
        User user = User.build();
        user.setUsername("sa2");
        user.setName("sa2");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        int temp = sqlSession.insert("user.insertOneUser", user);
        System.out.println("user id : " + user.getId());
        connector.closeSqlSession(sqlSession, true);
        System.out.println("insert语句返回结果" + temp);

    }

    @Test
    public void deleteUserById() throws IOException{
        MyBatisConnector connector = MyBatisConnector.build();
        SqlSession sqlSession = connector.openSqlSession();
        int result = sqlSession.delete("user.deleteUserById", 1);
        System.out.println("delete result = " + result);
        connector.closeSqlSession(sqlSession, true);
    }

    @Test
    public void updateUserById() throws IOException {
        MyBatisConnector connector = MyBatisConnector.build();
        SqlSession sqlSession = connector.openSqlSession();
        User user = User.build();
        user.setId(10);
        user.setName("sa3");
        int result = sqlSession.update("user.updateUserById", user);
        System.out.println("update result = " + result);
        connector.closeSqlSession(sqlSession, true);
    }
}
