package com.just.dao.impl;

import com.just.dao.WaterDao;
import com.just.entity.Water;
import com.just.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaterDaoImpl implements WaterDao {
    private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    private QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
    @Override
    public List<Water> getListWater() {
        String sql = "select * from water";
        List<Water> waters = null;
        try {
            waters = runner.query(sql,new BeanListHandler<Water>(Water.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return waters;
    }
    @Override
    public List<Water> getListWaterFromTime(String startTime, String endTime) {
        List<Water> rawWaters = getListWater();
        List<Water> waters = new ArrayList<>();
        LocalDateTime start_Time = LocalDateTime.parse(startTime, formatter2);
        LocalDateTime end_Time = LocalDateTime.parse(endTime, formatter2);
        for (Water water : rawWaters){
            LocalDateTime waterTime = LocalDateTime.parse(water.getDate(), formatter1);
            if(waterTime.isAfter(start_Time) && waterTime.isBefore(end_Time)){
                waters.add(water);
            }
        }
        return waters;
    }

    @Override
    public void initWater() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = localDateTime.format(formatter);
        Random random = new Random();
        double randomNumber1 = 10 + (90 * random.nextDouble()); // 生成10到100之间的随机数
        String formattedNumber1 = String.format("%.2f", randomNumber1);
        double randomNumber2 = 10 + (30 * random.nextDouble()); // 生成10到40之间的随机数
        String formattedNumber2 = String.format("%.1f", randomNumber2);
        String sql = "INSERT INTO water (waterHeight,waterTemperature,date) VALUES ("+formattedNumber1+","+formattedNumber2+",'"+now+"')";
        try{
            runner.update(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getColumns(String formName) {
        String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + formName + "' ORDER BY ORDINAL_POSITION";
        List<String> columnNames = null;
        try {
            columnNames = runner.query(sql, new ColumnListHandler<>());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return columnNames;
    }
}
