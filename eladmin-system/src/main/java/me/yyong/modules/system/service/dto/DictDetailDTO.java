package me.yyong.modules.system.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author 披着床单的小王子
* @date 2019-04-10
*/
@Getter
@Setter
public class DictDetailDTO implements Serializable {

    private Long id;

    private String label;

    private String value;

    private String sort;

    private Timestamp createTime;
}