package me.yyong.modules.system.service.mapper;

import me.yyong.base.BaseMapper;
import me.yyong.modules.system.domain.Dict;
import me.yyong.modules.system.service.dto.DictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 披着床单的小王子
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDTO, Dict> {

}