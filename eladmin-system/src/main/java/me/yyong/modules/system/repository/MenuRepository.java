package me.yyong.modules.system.repository;

import me.yyong.modules.system.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author 披着床单的小王子
 * @date 2018-12-17
 */
public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor<Menu> {

    Menu findByName(String name);

    Menu findByComponentName(String name);

    List<Menu> findByPid(long pid);

    LinkedHashSet<Menu> findByRoles_IdAndTypeIsNotInOrderBySortAsc(Long id, Integer type);
}
