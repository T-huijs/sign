package com.hui.mapper;

import com.hui.model.entity.Sign;
import com.hui.model.form.QuerySignPageForm;
import com.hui.model.form.SignForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SignMapper {

    /**
     * 插入签到记录
     * @param sign
     * @return
     */
    Integer addSign(Sign sign);

    /**
     * 分页查询签到记录
     * @param signForm
     * @return
     */
    List<Sign> querySignPage(SignForm signForm);

    /**
     * 查询签到记录总数
     * @param signForm
     * @return
     */
    Integer querySignPageCount(SignForm signForm);

}
