package me.yyong.service;

import me.yyong.domain.GenConfig;

/**
 * @author 披着床单的小王子
 * @date 2019-01-14
 */
public interface GenConfigService {

    GenConfig find();

    GenConfig update(GenConfig genConfig);
}
