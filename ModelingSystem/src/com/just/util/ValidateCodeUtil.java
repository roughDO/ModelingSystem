package com.just.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;

public class ValidateCodeUtil {

    public static HashMap<String, Object> getImage(){
        //创建内存画板对象
        BufferedImage image = new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = image.getGraphics();
        Random r = new Random();
        //给画笔指定颜色
        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        //为画板填充颜色
        g.fillRect(0,0,100,30);
        //生成随机字符串
        String number = getNum(4);
        //修改画笔颜色，设置字体
        g.setColor(new Color(0,0,0));
        g.setFont(new Font(null,Font.BOLD,24));
        //绘制字符串
        g.drawString(number,15,25);
        //绘制干扰线
        for (int i=0;i<8;i++){
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(100),r.nextInt(30),r.nextInt(100),r.nextInt(30));
        }
        //压缩图片发到客户端 放到jsp中执行
        //将图片和随机字符串返回
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("number",number);
        map.put("image",image);
        return map;


    }
    public static String getNum(int size){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        for(int i=0;i<size;i++){
            sb.append(str.charAt(r.nextInt(str.length())));
        }
        return sb.toString();
    }

}
