package me.yyong.modules.quartz.task;

import me.yyong.modules.monitor.service.VisitsService;
import org.springframework.stereotype.Component;

/**
 * @author 披着床单的小王子
 * @date 2018-12-25
 */
@Component
public class VisitsTask {

    private final VisitsService visitsService;

    public VisitsTask(VisitsService visitsService) {
        this.visitsService = visitsService;
    }

    public void run(){
        visitsService.save();
    }
}
