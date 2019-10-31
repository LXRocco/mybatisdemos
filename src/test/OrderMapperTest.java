import com.mybatis.demos.domain.Order;
import com.mybatis.demos.domain.User;
import com.mybatis.demos.mapper.OrderMapper;
import com.mybatis.demos.qo.OrderParam;
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
 * <p>Title: OrderMapperTest </p>
 * <p>Description:  </p>
 * <p>Github: https://github.com/lxrocco/ </p>
 * <p>Gitee: https://gitee.com/LXRocco/ </p>
 * @author lx
 * @date 2019/10/13 16:31
 * @version 1.0
 */
public class OrderMapperTest {

    private final static String MYBATIS_CONFIG_FILE = "mybatis-config.xml";

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findOrderByParam() throws Exception{

        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        OrderParam orderParam = OrderParam.build();
        orderParam.setOrderNum("O20191013");

        List<Order> orders = orderMapper.findOrderByParam(orderParam);

        sqlSession.close();
        System.out.println(orders);
    }

    @Test
    public void findOrdersAndOrderDetailsByParam() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        List<String> ordernums = new ArrayList<>();
        ordernums.add("O20191013");
        ordernums.add("O23749832");

        OrderParam orderParam = OrderParam.build();
        orderParam.setOrderNums(ordernums);

        List<Order> orders = orderMapper.findOrdersAndOrderDetailsByParam(orderParam);

        sqlSession.close();
        System.out.println(orders.size());
        System.out.println(orders);
    }

    /**
     * 测试延迟加载  mybatis 标签方式 association
     */
    @Test
    public void findOrdersAnduser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.findOrdersAnduser();

//        for (Order order : orders) {
//            User user = order.getUser();
//            System.out.println(user.getUsername());
//        }
        sqlSession.close();
//        System.out.println(orders);
    }
}
