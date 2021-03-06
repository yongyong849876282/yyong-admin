package me.yyong.modules.system.service;

import me.yyong.modules.system.domain.User;
import me.yyong.modules.system.service.dto.UserDTO;
import me.yyong.modules.system.service.dto.UserQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 披着床单的小王子
 * @date 2018-11-23
 */
public interface UserService {

    UserDTO findById(long id);

    UserDTO create(User resources);

    void update(User resources);

    void delete(Long id);

    UserDTO findByName(String userName);

    void updatePass(String username, String encryptPassword);

    void updateAvatar(MultipartFile file);

    void updateEmail(String username, String email);

    Object queryAll(UserQueryCriteria criteria, Pageable pageable);

    List<UserDTO> queryAll(UserQueryCriteria criteria);

    void download(List<UserDTO> queryAll, HttpServletResponse response) throws IOException;
}
