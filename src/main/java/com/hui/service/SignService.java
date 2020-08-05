package com.hui.service;

import com.hui.model.entity.Sign;
import com.hui.model.form.QuerySignPageForm;
import com.hui.model.form.ThquerySignPageForm;
import com.hui.model.json.QuerySignPageJson;
import com.hui.model.json.ThquerySignPageJson;

import java.util.List;

public interface SignService {

    /**
     * 签到
     * @param sign
     * @return
     */
    Boolean signWithStudent(Sign sign);

    /**
     * 查询签到记录
     */
    QuerySignPageJson querySignByStudentNo(QuerySignPageForm querySignPageForm);



    ThquerySignPageJson querySignForTeacher(ThquerySignPageForm thquerySignPageForm);


}
