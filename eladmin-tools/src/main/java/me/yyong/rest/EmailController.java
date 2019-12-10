package me.yyong.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.yyong.aop.log.Log;
import me.yyong.domain.EmailConfig;
import me.yyong.domain.vo.EmailVo;
import me.yyong.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 发送邮件
 * @author 王勇
 * @date 2018/01/28 9:55:53
 */
@RestController
@RequestMapping("api/email")
@Api(tags = "工具：邮件管理")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity get(){
        return new ResponseEntity<>(emailService.find(),HttpStatus.OK);
    }

    @Log("配置邮件")
    @PutMapping
    @ApiOperation("配置邮件")
    public ResponseEntity emailConfig(@Validated @RequestBody EmailConfig emailConfig){

        EmailConfig one = emailService.find();
        emailService.update(emailConfig,one);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("发送邮件")
    @PostMapping
    @ApiOperation("发送邮件")
    public ResponseEntity send(@Validated @RequestBody EmailVo emailVo) throws Exception {
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }
}
