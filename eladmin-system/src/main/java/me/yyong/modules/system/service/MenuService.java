package me.yyong.modules.system.service;

import me.yyong.modules.system.domain.Menu;
import me.yyong.modules.system.service.dto.MenuDTO;
import me.yyong.modules.system.service.dto.MenuQueryCriteria;
import me.yyong.modules.system.service.dto.RoleSmallDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 披着床单的小王子
 * @date 2018-12-17
 */
public interface MenuService {

    List<MenuDTO> queryAll(MenuQueryCriteria criteria);

    MenuDTO findById(long id);

    MenuDTO create(Menu resources);

    void update(Menu resources);

    Set<Menu> getDeleteMenus(List<Menu> menuList, Set<Menu> menuSet);

    Object getMenuTree(List<Menu> menus);

    List<Menu> findByPid(long pid);

    Map<String,Object> buildTree(List<MenuDTO> menuDTOS);

    List<MenuDTO> findByRoles(List<RoleSmallDTO> roles);

    Object buildMenus(List<MenuDTO> byRoles);

    Menu findOne(Long id);

    void delete(Set<Menu> menuSet);

    void download(List<MenuDTO> queryAll, HttpServletResponse response) throws IOException;
}
