package me.yyong.service;

import me.yyong.domain.VerificationCode;
import me.yyong.domain.vo.EmailVo;

/**
 * @author 披着床单的小王子
 * @date 2018-12-26
 */
public interface VerificationCodeService {

    /**
     * 发送邮件验证码
     * @param code 验证码
     * @return EmailVo
     */
    EmailVo sendEmail(VerificationCode code);

    /**
     * 验证
     * @param code 验证码
     */
    void validated(VerificationCode code);
}
