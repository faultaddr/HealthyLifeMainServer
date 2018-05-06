package cn.panyunyi.HealthyLifeMain.controller;

import cn.panyunyi.HealthyLifeMain.dao.StepRepository;
import cn.panyunyi.HealthyLifeMain.entity.MStepEntity;
import cn.panyunyi.HealthyLifeMain.service.StepServiceImpl;
import cn.panyunyi.HealthyLifeMain.util.PrintMessage;
import com.alibaba.fastjson.JSON;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by panyunyi on 2018/5/2.
 */

@Controller
@EnableAutoConfiguration
public class StepController {

    @Autowired
    private StepRepository stepRepository;
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/GET/Step/id/*")
    public void getStepById(@RequestParam int id, HttpServletResponse response) {
        StepServiceImpl service = new StepServiceImpl();
        List<MStepEntity> mStepEntityList = service.getAllStepById(id + "");
        handlePrintMessage(response, mStepEntityList);

    }

    @RequestMapping(value = "/GET/Step/currentDate/*")
    public void getStepByCurrentDate(@RequestParam String currentDate, HttpServletResponse response) {
        MStepEntity mStepEntity = StepServiceImpl.getInstance().getStepByDate(currentDate);
        handlePrintMessage(response, mStepEntity);
    }

    @RequestMapping(value = "/GET/Step/all")
    public void getAllStepData(HttpServletResponse response) {
        List<MStepEntity> mStepEntityList = StepServiceImpl.getInstance().getAllUserStepData();
        handlePrintMessage(response, mStepEntityList);
    }

    @RequestMapping(value = "/POST/Step/add")
    public void addStepById(@RequestBody MStepEntity mStepEntity, HttpServletResponse response) {
        PrintMessage.PrintMessage(response,(stepRepository.save(mStepEntity)!=null)+"","false");

    }


    private void handlePrintMessage(HttpServletResponse response, Object o) {
        if (o == null) {
            response.setStatus(404);
            PrintMessage.PrintMessage(response, "", "");
        } else {
            String jsonStr = JSON.toJSONString(o);
            PrintMessage.PrintMessage(response, jsonStr, "");
        }
    }
}
