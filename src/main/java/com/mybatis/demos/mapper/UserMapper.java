package com.mybatis.demos.mapper;

import com.mybatis.demos.domain.User;
import com.mybatis.demos.qo.UserParam;

import java.util.List;

/**
 * mapper接口，mybatis3会自动地生成mapper接口实现类代理对象。
 *
 * mapper.xml开发规范：
 *
 *         1、在mapper.xml中，namespace中的值为对应接口相对地址。<mapper namespace="com.mybatis.demos.mapper.UserMapper">
 *         2、mapper.java接口中的方法名和mapper.xml中对应statement的id一致。
 *         3、mapper.java接口中的方法输入参数类型和mapper.xml中对应statement的parameterType指定的类型一致。
 *         4、mapper.java接口中的方法的返回值类型和mapper.xml中对应statement的resultType指定的类型一致。
 *
 *     只有满足以上4点，mybatis才会自动地生成mapper接口实现类代理对象。
 *
 * @author lx
 * @version 1.0
 * @date 2019/10/7 17:04
 */
public interface UserMapper {
    //根据id查找用户
    User findUserById(int id) throws Exception;

    List<User> findUserByName(String name) throws Exception;

    List<User> findUserByParam(UserParam userParam) throws Exception;

    List<User> findByParam(UserParam userParam) throws Exception;
}
