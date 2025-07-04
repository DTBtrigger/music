package com.music.demo.login.service.impl;

import cn.hutool.crypto.SmUtil;
import com.alibaba.nacos.shaded.io.grpc.Status;
import com.music.demo.common.exception.user.UserCredentialsException;
import com.music.demo.common.exception.user.UsernameEmptyException;
import com.music.demo.common.util.ULID;
import com.music.demo.domain.entity.User;
import com.music.demo.login.mapper.UserMapper;
import com.music.demo.login.service.IRegistryService;
import com.music.demo.login.service.ISendMailService;
import com.music.demo.login.util.BloomFilterUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class IRegistryServiceImpl implements IRegistryService {

    private final UserMapper mapper;
    private final ULID ulid;
    private final ISendMailService iSendMailService;
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public List<User> findAll() {
        return mapper.selectList(null);
    }

    @Override
    public void registry(User user, String code) {


        String username = user.getUsername();
        boolean isExist = BloomFilterUtil.getInstance().contains(username);
        if (isExist) throw new UserCredentialsException("注册失败，用户名已存在");
        if (Objects.isNull(user.getPassword()) || user.getPassword().isEmpty()) {
            throw new UsernameEmptyException("注册失败，密码不能为空");
        }
        if ( !stringRedisTemplate.opsForValue().get(user.getEmail()).equals(code)) {
            throw new UserCredentialsException("输入的验证码不正确，注册失败");
        }

//
//        Random random = new Random();
//        int code = random.nextInt(90000 + 10000);
//        iSendMailService.sendMail(user.getEmail(),"验证邮箱",String.valueOf(code));

        String newP = SmUtil.sm3(user.getPassword());
        user.setPassword(newP);

        user.setId(ulid.nextULID());
        user.setUpdateby("admin");
        user.setRole(User.USER);
        user.setUpdateTime(new Date());
//        user.setEnable(false);

        mapper.insert(user);
        BloomFilterUtil.getInstance().add(user.getUsername());
    }


}
