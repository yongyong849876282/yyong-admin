package me.yyong.modules.system.service.mapper;

import me.yyong.base.BaseMapper;
import me.yyong.modules.system.domain.Dept;
import me.yyong.modules.system.service.dto.DeptDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 披着床单的小王子
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends BaseMapper<DeptDTO, Dept> {

}