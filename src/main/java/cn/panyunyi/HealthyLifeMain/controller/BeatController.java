package cn.panyunyi.HealthyLifeMain.controller;

import cn.panyunyi.HealthyLifeMain.dao.BeatRepository;
import cn.panyunyi.HealthyLifeMain.entity.MBeatEntity;
import cn.panyunyi.HealthyLifeMain.service.BeatServiceImpl;
import cn.panyunyi.HealthyLifeMain.util.PrintMessage;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by panyunyi on 2018/5/3.
 */

@Controller
@EnableAutoConfiguration
public class BeatController {
    @Autowired
    private BeatRepository beatRepository;
    @RequestMapping(value = "/GET/Beat/id/*")
    public void getBeatsById(@RequestParam int id, HttpServletResponse response) {
        BeatServiceImpl service = BeatServiceImpl.getInstance();
        Object o;
        if ((o = service.getBeatsById(id + "")) == null) {
            PrintMessage.PrintMessage(response, "", "");
        } else {
            response.setStatus(200);
            String jsonStr = JSON.toJSONString(o);
            PrintMessage.PrintMessage(response, jsonStr, "");
        }
    }

    @RequestMapping(value = "/GET/Beat/date/*")
    public void getBeatsByDate(@RequestParam String currentDate, HttpServletResponse response) {

    }

    @RequestMapping(value = "/POST/Beat/add")
    public void addBeats(@RequestBody MBeatEntity mBeatEntity, HttpServletResponse response) {
        beatRepository.save(mBeatEntity);

        /*if (!BeatServiceImpl.getInstance().addBeats(entity1)) {
            PrintMessage.PrintMessage(response, "true", "true");
        } else {
            PrintMessage.PrintMessage(response, "false", "false");
        }*/

    }

}
