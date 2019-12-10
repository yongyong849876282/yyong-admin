package me.yyong.modules.system.service.dto;

import lombok.Data;
import me.yyong.annotation.Query;

/**
* @author 披着床单的小王子
* @date 2019-04-10
*/
@Data
public class DictDetailQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String label;

    @Query(propName = "name",joinName = "dict")
    private String dictName;
}