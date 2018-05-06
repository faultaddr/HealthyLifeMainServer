package cn.panyunyi.HealthyLifeMain.controller;

import cn.panyunyi.HealthyLifeMain.dao.DaoFactory;
import cn.panyunyi.HealthyLifeMain.dao.NewsRepository;
import cn.panyunyi.HealthyLifeMain.entity.MNewsEntity;
import cn.panyunyi.HealthyLifeMain.util.PrintMessage;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panyunyi on 2018/5/4.
 */
@Controller
@EnableAutoConfiguration
public class CommonDataController {
    @Autowired
    private NewsRepository newsRepository;
    @RequestMapping(value = "/GET/news/all" )
    public void getNewsAll(HttpServletResponse response){
        List<MNewsEntity> mNewsEntityList=new ArrayList<>();
        response.setCharacterEncoding("utf-8");
        mNewsEntityList=newsRepository.getAll();

        String jsonStr= JSON.toJSONString(mNewsEntityList);
        PrintMessage.PrintMessage(response,jsonStr,"");
    }

}
