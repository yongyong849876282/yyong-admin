package me.yyong.repository;

import me.yyong.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 披着床单的小王子
 * @date 2018-12-26
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
