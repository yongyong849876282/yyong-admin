package me.yyong.modules.system.service.impl;

import me.yyong.modules.system.domain.Role;
import me.yyong.exception.EntityExistException;
import me.yyong.modules.system.repository.RoleRepository;
import me.yyong.modules.system.service.RoleService;
import me.yyong.modules.system.service.dto.RoleDTO;
import me.yyong.modules.system.service.dto.RoleQueryCriteria;
import me.yyong.modules.system.service.dto.RoleSmallDTO;
import me.yyong.modules.system.service.mapper.RoleMapper;
import me.yyong.modules.system.service.mapper.RoleSmallMapper;
import me.yyong.utils.FileUtil;
import me.yyong.utils.PageUtil;
import me.yyong.utils.QueryHelp;
import me.yyong.utils.ValidationUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Zheng Jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "role")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    private final RoleSmallMapper roleSmallMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper, RoleSmallMapper roleSmallMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.roleSmallMapper = roleSmallMapper;
    }

    @Override
    @Cacheable
    public Object queryAll(Pageable pageable) {
        return roleMapper.toDto(roleRepository.findAll(pageable).getContent());
    }

    @Override
    @Cacheable
    public List<RoleDTO> queryAll(RoleQueryCriteria criteria) {
        return roleMapper.toDto(roleRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Cacheable
    public Object queryAll(RoleQueryCriteria criteria, Pageable pageable) {
        Page<Role> page = roleRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(roleMapper::toDto));
    }

    @Override
    @Cacheable(key = "#p0")
    public RoleDTO findById(long id) {
        Role role = roleRepository.findById(id).orElseGet(Role::new);
        ValidationUtil.isNull(role.getId(),"Role","id",id);
        return roleMapper.toDto(role);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public RoleDTO create(Role resources) {
        if(roleRepository.findByName(resources.getName()) != null){
            throw new EntityExistException(Role.class,"username",resources.getName());
        }
        return roleMapper.toDto(roleRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Role resources) {
        Role role = roleRepository.findById(resources.getId()).orElseGet(Role::new);
        ValidationUtil.isNull(role.getId(),"Role","id",resources.getId());

        Role role1 = roleRepository.findByName(resources.getName());

        if(role1 != null && !role1.getId().equals(role.getId())){
            throw new EntityExistException(Role.class,"username",resources.getName());
        }

        role.setName(resources.getName());
        role.setRemark(resources.getRemark());
        role.setDataScope(resources.getDataScope());
        role.setDepts(resources.getDepts());
        role.setLevel(resources.getLevel());
        roleRepository.save(role);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void updateMenu(Role resources, RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        role.setMenus(resources.getMenus());
        roleRepository.save(role);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void untiedMenu(Long id) {
        roleRepository.untiedMenu(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    @Cacheable(key = "'findByUsers_Id:' + #p0")
    public List<RoleSmallDTO> findByUsers_Id(Long id) {
        return roleSmallMapper.toDto(new ArrayList<>(roleRepository.findByUsers_Id(id)));
    }

    @Override
    @Cacheable
    public Integer findByRoles(Set<Role> roles) {
        Set<RoleDTO> roleDTOS = new HashSet<>();
        for (Role role : roles) {
            roleDTOS.add(findById(role.getId()));
        }
        return Collections.min(roleDTOS.stream().map(RoleDTO::getLevel).collect(Collectors.toList()));
    }

    @Override
    public void download(List<RoleDTO> roles, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (RoleDTO role : roles) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("角色名称", role.getName());
            map.put("默认权限", role.getPermission());
            map.put("角色级别", role.getLevel());
            map.put("描述", role.getRemark());
            map.put("创建日期", role.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
