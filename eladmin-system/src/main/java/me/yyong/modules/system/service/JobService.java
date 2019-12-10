package me.yyong.modules.system.service;

import me.yyong.modules.system.domain.Job;
import me.yyong.modules.system.service.dto.JobDTO;
import me.yyong.modules.system.service.dto.JobQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
* @author 披着床单的小王子
* @date 2019-03-29
*/
public interface JobService {

    JobDTO findById(Long id);

    JobDTO create(Job resources);

    void update(Job resources);

    void delete(Long id);

    Map<String,Object> queryAll(JobQueryCriteria criteria, Pageable pageable);

    List<JobDTO> queryAll(JobQueryCriteria criteria);

    void download(List<JobDTO> queryAll, HttpServletResponse response) throws IOException;
}