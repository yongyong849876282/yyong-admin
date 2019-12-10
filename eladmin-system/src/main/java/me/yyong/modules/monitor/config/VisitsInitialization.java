package me.yyong.modules.monitor.config;

import me.yyong.modules.monitor.service.VisitsService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化站点统计
 * @author 披着床单的小王子
 */
@Component
public class VisitsInitialization implements ApplicationRunner {

    private final VisitsService visitsService;

    public VisitsInitialization(VisitsService visitsService) {
        this.visitsService = visitsService;
    }

    @Override
    public void run(ApplicationArguments args){
        System.out.println("--------------- 初始化站点统计，如果存在今日统计则跳过 ---------------");
        visitsService.save();
        System.out.println("--------------- 初始化站点统计完成 ---------------");
    }
}