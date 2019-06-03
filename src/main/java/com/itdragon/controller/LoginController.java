package com.itdragon.controller;

import com.itdragon.pojo.ItdragonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: itdragon
 * @Date: 2019/5/17 14:00
 * @Description:
 */
@Controller
@RequestMapping("/employees")
public class LoginController {
    Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value="/login", method=RequestMethod.POST)
    @ResponseBody
    public ItdragonResult userLogin(@RequestParam("username") String username,
                                    @RequestParam("password") String password, HttpServletRequest request) {
        ItdragonResult result = new ItdragonResult();
        try {
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//	            token.setRememberMe(true);
                try {
                    currentUser.login(token);    // 执行登录
                    // 获取登录前的最后一个页面
//	                SavedRequest savedRequest = WebUtils.getSavedRequest(request);
//	    			String url = null != savedRequest ?
//	    					(null != savedRequest.getRequestUrl()?savedRequest.getRequestUrl():""):"";
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    result.setStatus(200);
                    result.setData("");
                } catch (AuthenticationException ae) {
                    log.info("^^^^^^^^^^^^^^^^^^^^ ITDragon 登录失败: " + ae.getMessage());
                    ae.printStackTrace();
                    result.setStatus(500);
                    result.setMsg("账号密码不匹配");
                }
            }
            result.setStatus(200);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

}
