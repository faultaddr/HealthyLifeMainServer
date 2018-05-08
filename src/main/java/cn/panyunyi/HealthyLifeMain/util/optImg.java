package cn.panyunyi.HealthyLifeMain.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

/**
 * Created by panyu on 2018/5/9.
 */
public class optImg {
    public static  void main(String args[]){
        try {
            Thumbnails.of("E:\\HealthyLifeMainServer\\HealthyLifeMain\\src\\main\\resources\\static\\img\\main_3.jpg").size(1920, 1080).keepAspectRatio(false).toFile("E:\\HealthyLifeMainServer\\HealthyLifeMain\\src\\main\\resources\\static\\img\\main_3_small.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
