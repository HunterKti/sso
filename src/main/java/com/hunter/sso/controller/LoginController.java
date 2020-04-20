package com.hunter.sso.controller;

import com.hunter.sso.domain.origin.SpUser;
import com.hunter.sso.service.LoginService;
import com.hunter.sso.utils.CookieUtils;
import com.hunter.sso.utils.MapperUtils;
import com.hunter.sso.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 单点登陆
 *
 * @author Hunter
 * @date 2020/4/20
 */
@Controller
@Slf4j
public class LoginController {

    RedisUtil redisUtil;

    LoginService loginService;

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 跳转登陆页面
     *
     * @param url 记住是从什么位置跳转到的 login
     * @return login
     */
    @GetMapping("login")
    public String login(HttpServletRequest request, Model model, String url) {

        String token = CookieUtils.getCookieValue(request, "token");
        if (StringUtils.isNotBlank(token)) {
            String username = redisUtil.get(token);
            if (StringUtils.isNotBlank(username)){
                String json = redisUtil.get(username);
                try {
                    SpUser spUser = MapperUtils.json2pojo(json, SpUser.class);
                    if (null != spUser && StringUtils.isNotBlank(url)) {
                        return "redirect:" + url;
                    }
                    model.addAttribute("user", spUser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (StringUtils.isNotBlank(url)) {
            model.addAttribute("url", url);
        }
        return "login";
    }

    @PostMapping("login")
    public String login(String username, String password, String url, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        SpUser spUser = loginService.login(username, password);
        if (null == spUser) {
            redirectAttributes.addFlashAttribute("message", "用户名密码错误，请重新输入");
        }
        //登陆成功
        else {
            //生成token
            String token = UUID.randomUUID().toString();
            redisUtil.put(token, username, 60 * 60 * 24);
            CookieUtils.setCookie(request, response, "token", token, 60 * 60 * 24);
            if (StringUtils.isNotBlank(url)){
                return "redirect:" + url;
            }
        }
        return "redirect:/login";
    }
}
