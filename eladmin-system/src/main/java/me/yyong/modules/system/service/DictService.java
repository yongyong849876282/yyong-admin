package me.yyong.modules.system.service;

import me.yyong.modules.system.domain.Dict;
import me.yyong.modules.system.service.dto.DictDTO;
import me.yyong.modules.system.service.dto.DictQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
* @author 披着床单的小王子
* @date 2019-04-10
*/
public interface DictService {

    Map<String,Object> queryAll(DictQueryCriteria dict, Pageable pageable);

    List<DictDTO> queryAll(DictQueryCriteria dict);

    DictDTO findById(Long id);

    DictDTO create(Dict resources);

    void update(Dict resources);

    void delete(Long id);

    void download(List<DictDTO> queryAll, HttpServletResponse response) throws IOException;
}