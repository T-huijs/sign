package com.hui.service.impl;

import com.hui.mapper.SignMapper;
import com.hui.model.entity.Sign;

import com.hui.model.form.QuerySignPageForm;

import com.hui.model.form.SignForm;
import com.hui.model.form.ThquerySignPageForm;
import com.hui.model.json.QuerySignPageJson;
import com.hui.model.json.ThquerySignPageJson;
import com.hui.service.SignService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.List;


@Service
public class SignServiceImpl implements SignService {


    @Autowired
    private SignMapper signMapper;

    @Override
    public Boolean signWithStudent(Sign sign) {
        return addSign(sign);
    }


    /**
     * 插入签到记录
     * @param sign
     * @return
     */
    private Boolean addSign(Sign sign){
        return signMapper.addSign(sign) > 0;
    }


    @Override
    public  QuerySignPageJson querySignByStudentNo(QuerySignPageForm querySignPageForm) {
        SignForm signForm = new SignForm();
        BeanUtils.copyProperties(querySignPageForm, signForm);
        List<Sign> signList = querySignList(signForm);
        if(CollectionUtils.isEmpty(signList)){
            return null;
        }
        QuerySignPageJson querySignPageJson = new QuerySignPageJson();

        int count = querySignCount(signForm);
        querySignPageJson.setSignList(signList);
        querySignPageJson.setSignCount(count);
        return querySignPageJson;
    }

    /**
     * 查询签到记录
     * @param signForm
     * @return
     */
    private List<Sign> querySignList(SignForm signForm){
        return signMapper.querySignPage(signForm);
    }

    /**
     * 查询签到条数
     * @param signForm
     * @return
     */
    private Integer querySignCount(SignForm signForm){
        return signMapper.querySignPageCount(signForm);
    }

    @Override
    public ThquerySignPageJson querySignForTeacher(ThquerySignPageForm thquerySignPageForm){
        SignForm signForm = new SignForm();
        BeanUtils.copyProperties(thquerySignPageForm, signForm);
        List<Sign> signList = querySignList(signForm);
        if(CollectionUtils.isEmpty(signList)){
            return null;
        }
        ThquerySignPageJson thquerySignPageJson = new ThquerySignPageJson();
        int count = querySignCount(signForm);
        thquerySignPageJson.setSignList(signList);
        thquerySignPageJson.setSignCount(count);
        return thquerySignPageJson;
    }
}
