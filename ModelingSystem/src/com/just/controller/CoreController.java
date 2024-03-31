package com.just.controller;

import com.just.dao.Dao;
import com.just.dao.Device1Dao;
import com.just.dao.WaterDao;
import com.just.dao.impl.DaoImpl;
import com.just.dao.impl.Device1DaoImpl;
import com.just.dao.impl.WaterDaoImpl;
import com.just.entity.Device1;
import com.just.entity.Entity;
import com.just.entity.Water;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CoreController {
    private Dao dao = new DaoImpl();
    private WaterDao waterDao = new WaterDaoImpl();
    private final boolean DEBUG = true;
    @RequestMapping("list")
    public String enterList(){
        System.out.println("执行list");
        return "list";
    }
//    public class Data{
//        private Water entity;
//        private List<String> strings = new ArrayList<>();
//        private List<String> columns;
//        private List<String> warningList = new ArrayList<>();
//        private String now;
//        public Data(Water entity, List<String> columns){
//            this.entity = entity;
//            String rawString = this.entity.toString();
//            this.columns = columns;
//            int startIndex = rawString.indexOf("{") + 1; // 获取左括号的索引位置
//            int endIndex = rawString.indexOf("}"); // 获取右括号的索引位置
//            String[] pairs = rawString.substring(startIndex,endIndex).split(",");
//            // 放入更新的数据
//            for (String pair : pairs) {
//                String[] keyValue = pair.split("=");
//                if (keyValue.length == 2) {
//                    String value = keyValue[1];
//                    strings.add(value);
//                }
//            }
//            // 生成警告列表
//            for(String column : columns){
//                if("waterTemperature".equals(column)){
//                    int idx = columns.indexOf(column);
//                    if(Double.parseDouble(strings.get(idx)) > 35.0){
//                        warningList.add("warn");
//                    }else {
//                        warningList.add("safe");
//                    }
//                }else {
//                    warningList.add("safe");
//                }
//            }
//            now = this.entity.getDate();
//        }
//
//        public Water getEntity() {
//            return entity;
//        }
//
//        public void setEntity(Water entity) {
//            this.entity = entity;
//        }
//
//        public List<String> getStrings() {
//            return strings;
//        }
//
//        public void setStrings(List<String> strings) {
//            this.strings = strings;
//        }
//
//        public String getNow() {
//            return now;
//        }
//
//        public void setNow(String now) {
//            this.now = now;
//        }
//
//        public List<String> getColumns() {
//            return columns;
//        }
//
//        public void setColumns(List<String> columns) {
//            this.columns = columns;
//        }
//
//        public List<String> getWarningList() {
//            return warningList;
//        }
//
//        public void setWarningList(List<String> warningList) {
//            this.warningList = warningList;
//        }
//    }
//    @RequestMapping("showList")
//    public String showList(@RequestParam("nums") String nums, @RequestParam("start-time") String start_time, @RequestParam("end-time") String end_time,Model model, HttpSession session){
//        System.out.println("执行showList");
//        if (DEBUG){
//            waterDao.initWater();
//        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//        if(start_time == null || end_time == null || nums == null){
//            LocalDateTime localDateTime = LocalDateTime.now();
//            String now = localDateTime.format(formatter);
//            nums = "1,2,3,4";
//            start_time = "2023-12-10T10:00";
//            end_time = now;
//        }
//        // 获取用户输入的数字（列）
//        nums = nums.replace(" ","");
//        String[] numArr = nums.split(",");
//        // 获取数据
//        List<Water> daoWaters = waterDao.getListWaterFromTime(start_time,end_time);
//        // 获取列名
//        List<String> columns = waterDao.getColumns("water");
//        // 将数据放入内部类
//        List<Data> dataList = new ArrayList<>();
//        for (Water water : daoWaters){
//            dataList.add(new Data(water, columns));
//        }
//        model.addAttribute("columns",columns);
//        model.addAttribute("numArr",numArr);
//        model.addAttribute("dataList",dataList);
//        session.setAttribute("userInput", nums);
//        return "list";
//    }
    public class Device1Data{
        private Device1 device1;
        private List<String> strings = new ArrayList<>();
        private List<String> columns;
        private List<String> warningList = new ArrayList<>();
        private String now;
        public Device1Data(){ }
        public Device1Data(Device1 device1, List<String> columns){
            this.device1 = device1;
            this.columns = columns;
            String rawString = this.device1.toString();
            int startIndex = rawString.indexOf("{") + 1; // 获取左括号的索引位置
            int endIndex = rawString.indexOf("}"); // 获取右括号的索引位置
            String[] pairs = rawString.substring(startIndex,endIndex).split(",");
            // 放入更新的数据
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    String value = keyValue[1];
                    strings.add(value);
                }
            }
            System.out.println(this.strings);
            for(String column : columns){
                if(column.contains("TISA")){
                    int idx = columns.indexOf(column);
//                    System.out.println(strings.get(idx) + column);
                    if(Double.parseDouble(strings.get(idx)) > 100.0){
                        if(Double.parseDouble(strings.get(idx)) > 110.0){
                            warningList.add("danger");
                        }else {
                            warningList.add("warn");
                        }
                    }else {
                        warningList.add("safe");
                    }
                }else if(column.contains("VISA")){
                    int idx = columns.indexOf(column);
//                    System.out.println(strings.get(idx) + column);
                    if(Integer.parseInt(strings.get(idx)) > 45){
                        if(Integer.parseInt(strings.get(idx)) > 70){
                            warningList.add("danger");
                        }else {
                            warningList.add("warn");
                        }
                    }else {
                        warningList.add("safe");
                    }
                }else if(column.contains("ZISA")){
                    int idx = columns.indexOf(column);
//                    System.out.println(strings.get(idx) + column);
                    if(Double.parseDouble(strings.get(idx)) > 0.4 || Double.parseDouble(strings.get(idx)) < -0.4){
                        if(Double.parseDouble(strings.get(idx)) > 0.8 || Double.parseDouble(strings.get(idx)) < -0.8){
                            warningList.add("danger");
                        }else {
                            warningList.add("warn");
                        }
                    }else {
                        warningList.add("safe");
                    }
                }else if(column.contains("KE")){
                    int idx = columns.indexOf(column);
//                    System.out.println(strings.get(idx) + column);
                    if(Integer.parseInt(strings.get(idx)) < 10000 || Integer.parseInt(strings.get(idx)) > 15000){
                        warningList.add("danger");
                    }else {
                        warningList.add("safe");
                    }
                }
            }
            now = this.device1.getDateTime();
        }
        public Device1 getDevice1() {
            return device1;
        }

        public void setDevice1(Device1 device1) {
            this.device1 = device1;
        }

        public List<String> getStrings() {
            return strings;
        }

        public void setStrings(List<String> strings) {
            this.strings = strings;
        }

        public List<String> getColumns() {
            return columns;
        }

        public void setColumns(List<String> columns) {
            this.columns = columns;
        }

        public List<String> getWarningList() {
            return warningList;
        }

        public void setWarningList(List<String> warningList) {
            this.warningList = warningList;
        }

        public String getNow() {
            return now;
        }

        public void setNow(String now) {
            this.now = now;
        }
    }
    private Device1Dao device1Dao = new Device1DaoImpl();
    @RequestMapping("device1")
    public String enterDevice1(){
        return "device1";
    }
    @RequestMapping("showDevice1")
    public String showDevice1(@RequestParam("start-time") String start_time, @RequestParam("end-time") String end_time,Model model, HttpSession session){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        if(start_time == null || end_time == null){
            LocalDateTime localDateTime = LocalDateTime.now();
            String now = localDateTime.format(formatter);
            start_time = "2023-12-10T10:00";
            end_time = now;
        }
        // 获取device1列名
        List<String> device1Columns = device1Dao.getColumns("device1");
//        System.out.println(device1Columns);
        // 获取device1数据
        List<Device1> daoDevice1s = device1Dao.getListDevice1ByTime(start_time, end_time);

        // 数据放入内部类
        List<Device1Data> dataList = new ArrayList<>();
        for(Device1 daoDevice1 : daoDevice1s){
            dataList.add(new Device1Data(daoDevice1,device1Columns));
        }
        model.addAttribute("columns",device1Columns);
        model.addAttribute("dataList",dataList);
        // 暂时找不到直接传入js文件的方法，暂时用这个
        List<List<String>> dataStrings = new ArrayList<>();
        for (Device1Data dv : dataList ){
            dataStrings.add(dv.strings);
        }
        model.addAttribute("dataStrings",dataStrings);
        System.out.println(dataList.get(0).strings);
        return "device1";
    }
}
