package me.yyong.modules.quartz.repository;

import me.yyong.modules.quartz.domain.QuartzJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

/**
 * @author 披着床单的小王子
 * @date 2019-01-07
 */
public interface QuartzJobRepository extends JpaRepository<QuartzJob,Long>, JpaSpecificationExecutor<QuartzJob> {

    /**
     * 查询启用的任务
     * @return List
     */
    List<QuartzJob> findByIsPauseIsFalse();
}
