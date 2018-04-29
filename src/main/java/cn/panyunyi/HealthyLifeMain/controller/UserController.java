package cn.panyunyi.HealthyLifeMain.controller;

import cn.panyunyi.HealthyLifeMain.entity.MUserEntity;
import cn.panyunyi.HealthyLifeMain.service.UserService;
import cn.panyunyi.HealthyLifeMain.service.UserServiceImpl;
import cn.panyunyi.HealthyLifeMain.util.PrintMessage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.hibernate.mapping.Map;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class UserController {
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public void login(@RequestBody String data, HttpServletResponse response) {
        UserServiceImpl userService = new UserServiceImpl();
        MUserEntity user=JSON.parseObject(data,MUserEntity.class);
        String userName=user.getUserName();
        String userPassword=user.getUserPassword();
        List<MUserEntity> list =userService.login(userName);
        if (list == null) {
            PrintMessage.PrintMessage(response, "false", "false");
        } else {
            if (( list.get(0).getUserPassword()).equals(userPassword)){
                String JsonString = JSON.toJSONString(list.get(0));
                PrintMessage.PrintMessage(response, JsonString, "false");
            } else {
                PrintMessage.PrintMessage(response, "false", "false");
            }
        }
        logger.info("---->>>>----login---->>>>----" + userName+ "+\n");
    }

    @RequestMapping(value = "/loginU")
    public ModelAndView loginU(@RequestParam(required = false, defaultValue = "200") String error, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("-->login-ing--please wait");
        if (error.equals("200"))

            modelAndView.setViewName("signup");
        else {
            logger.info("-->failed");
            PrintMessage.PrintMessage(response, error, error);

            modelAndView.setViewName("signup");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUserMethod(@RequestParam String userName, @RequestParam String passWord, HttpServletResponse response) {
        logger.info("---->>>>----register---->>>>----" + userName + "~~" + passWord + "\n");
        MUserEntity mUserEntity = new MUserEntity();
        mUserEntity.setUserName(userName);
        mUserEntity.setUserPassword(passWord);
        boolean result = userService.register(mUserEntity);
        if (result) {
            PrintMessage.PrintMessage(response, "true", "false");
        } else {
            PrintMessage.PrintMessage(response, "false", "false");
        }

        logger.info("---->>>>----register---->>>>----" + result + "" + userName + "\n");

    }
}