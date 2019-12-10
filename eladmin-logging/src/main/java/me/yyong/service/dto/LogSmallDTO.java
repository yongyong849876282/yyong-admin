package me.yyong.service.dto;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 披着床单的小王子
 * @date 2019-5-22
 */
@Data
public class LogSmallDTO implements Serializable {

    // 描述
    private String description;

    // 请求ip
    private String requestIp;

    // 请求耗时
    private Long time;

    private String address;

    private String browser;

    // 创建日期
    private Timestamp createTime;
}
