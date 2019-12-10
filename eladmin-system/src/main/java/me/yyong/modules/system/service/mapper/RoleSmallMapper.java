package me.yyong.modules.system.service.mapper;

import me.yyong.base.BaseMapper;
import me.yyong.modules.system.domain.Role;
import me.yyong.modules.system.service.dto.RoleSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author 披着床单的小王子
 * @date 2019-5-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends BaseMapper<RoleSmallDTO, Role> {

}
