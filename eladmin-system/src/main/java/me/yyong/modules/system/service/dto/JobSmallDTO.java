package me.yyong.modules.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
* @author 披着床单的小王子
* @date 2019-6-10 16:32:18
*/
@Data
@NoArgsConstructor
public class JobSmallDTO implements Serializable {

    private Long id;

    private String name;
}