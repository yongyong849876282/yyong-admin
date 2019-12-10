package me.yyong.repository;

import me.yyong.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 披着床单的小王子
 * @date 2018-12-31
 */
public interface AlipayRepository extends JpaRepository<AlipayConfig,Long> {
}
