package com.hui.mapper;

import com.hui.model.entity.User;
import com.hui.model.form.LoginForm;
import com.hui.model.form.RegisterForm;
import com.hui.model.json.LoginJson;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 查询指定账号在表中的条数；
     * @param registerForm
     * @return
     */
    Integer queryCountByAccount(RegisterForm registerForm);

    /**
     * 添加账号
     * @param user
     * @return
     */
    Integer addUser(User user);

    LoginJson getUserByAccount(LoginForm loginForm);


}
