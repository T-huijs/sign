package com.hui.model.json;

import com.hui.model.entity.Sign;
import lombok.Data;

import java.util.List;


@Data
public class QuerySignPageJson {

    private List<Sign> signList;


    private Integer signCount;
}
