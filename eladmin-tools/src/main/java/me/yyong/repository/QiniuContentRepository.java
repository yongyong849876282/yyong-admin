package me.yyong.repository;

import me.yyong.domain.QiniuContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 披着床单的小王子
 * @date 2018-12-31
 */
public interface QiniuContentRepository extends JpaRepository<QiniuContent,Long>, JpaSpecificationExecutor<QiniuContent> {

    /**
     * 根据key查询
     * @param key 文件名
     * @return QiniuContent
     */
    QiniuContent findByKey(String key);
}
