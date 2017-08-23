package com.chatRobot.controller;

import com.chatRobot.model.User;
import com.chatRobot.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();

    }
    @RequestMapping("/aa.do")
    public String ome(Model model){
        User user = this.userService.selectUser(1);
        model.addAttribute("user", user);
        return "home";
    }
    @ResponseBody
    @RequestMapping("/bb.do")
    public User ome(){
        User user = this.userService.selectUser(1);
        return user;
    }
}