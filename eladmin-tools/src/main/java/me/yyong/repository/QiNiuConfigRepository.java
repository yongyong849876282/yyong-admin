package me.yyong.repository;

import me.yyong.domain.QiniuConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 披着床单的小王子
 * @date 2018-12-31
 */
public interface QiNiuConfigRepository extends JpaRepository<QiniuConfig,Long> {

    @Modifying
    @Query(value = "update QiniuConfig set type = ?1")
    void update(String type);
}
