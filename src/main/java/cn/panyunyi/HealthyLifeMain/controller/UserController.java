package cn.panyunyi.HealthyLifeMain.controller;

import cn.panyunyi.HealthyLifeMain.dao.UserRepository;
import cn.panyunyi.HealthyLifeMain.entity.MUserEntity;
import cn.panyunyi.HealthyLifeMain.service.UserServiceImpl;
import cn.panyunyi.HealthyLifeMain.util.PrintMessage;
import com.alibaba.fastjson.JSON;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
@EnableAutoConfiguration
public class UserController {
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public void login(@RequestBody String data, HttpServletResponse response) {
        MUserEntity user = JSON.parseObject(data, MUserEntity.class);
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        MUserEntity userEntity = userRepository.findMUserEntityByUserNameAndUserPassword(userName, userPassword);
        if (userEntity == null) {
            PrintMessage.PrintMessage(response, "false", "false");
        } else {
            String returnValue = JSON.toJSONString(userEntity);
            PrintMessage.PrintMessage(response, returnValue, "false");
        }
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUserMethod(@RequestParam String userName, @RequestParam String passWord, HttpServletResponse response) {
        logger.info("---->>>>----register---->>>>----" + userName + "~~" + passWord + "\n");
        MUserEntity mUserEntity = new MUserEntity();
        mUserEntity.setUserName(userName);
        mUserEntity.setUserPassword(passWord);
        MUserEntity entity = userRepository.save(mUserEntity);
        String returnValue = JSON.toJSONString(entity);
        PrintMessage.PrintMessage(response, returnValue, returnValue);

    }
}