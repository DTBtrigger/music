package com.music.demo.login.controller;

import com.music.demo.common.result.HttpResult;
import com.music.demo.login.service.ISendMailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Tag(name = "邮箱接口")
@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class SendController {

    public final ISendMailService iSendMailService;

    @Operation(summary = "测试邮箱发送验证码")
    @GetMapping("/send")
    public HttpResult<String> sendCode(String to){
        Random random = new Random();
        int code = random.nextInt(90000 + 10000);

        iSendMailService.sendMail(to,"验证邮箱",String.valueOf(code));
        return HttpResult.success("发送成功");
    }

}
