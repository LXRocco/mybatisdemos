package com.mybatis.demos.dbConfig;

import com.mybatis.demos.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import sun.security.provider.MD2;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author lx
 * @version 1.0
 * @date 2019/9/26 2:46
 * @since
 */
public class MyBatisConnector {


    private final static String MYBATIS_CONFIG_FILE = "mybatis-config.xml";

    /**
     *
     * @param
     * @return 
     * @author lx
     * @date 2019/10/7 14:34
     */
    public static MyBatisConnector build() {
        return new MyBatisConnector();
    }

    /**
     * 
     * @author lx
     * @param
     * @date 2019/9/26 3:25
     * @return 
     */
    public SqlSession openSqlSession() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }


    /**
     * 
     * @author lx
     * @param 
     * @date 2019/9/26 3:25
     * @return 
     */
    public void closeSqlSession(SqlSession sqlSession, boolean b) {
        if (b) {
            sqlSession.commit();
        }
        sqlSession.close();
    }



}
