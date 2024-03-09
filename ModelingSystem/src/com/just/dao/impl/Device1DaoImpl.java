package com.just.dao.impl;

import com.just.dao.Device1Dao;
import com.just.entity.Device1;
import com.just.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Device1DaoImpl implements Device1Dao {
    private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
    private DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    private QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
    @Override
    public List<Device1> getListDevice1(){
        String sql = "select * from device1";
        List<Device1> device1s = null;
        try{
            device1s = runner.query(sql,new BeanListHandler<Device1>(Device1.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return device1s;
    }

    @Override
    public List<Device1> getListDevice1ByTime(String startTime, String endTime) {
        List<Device1> rawDevice1s = getListDevice1();
        List<Device1> device1s = new ArrayList<>();
        LocalDateTime start_Time = LocalDateTime.parse(startTime, formatter2);
        LocalDateTime end_Time = LocalDateTime.parse(endTime, formatter2);
        for (Device1 device1 : rawDevice1s){
            LocalDateTime time = LocalDateTime.parse(device1.getDateTime(),formatter1);
            if(time.isAfter(start_Time) && time.isBefore(end_Time)){
                device1s.add(device1);
            }
        }
        return device1s;
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

    @Override
    public void initDevice1() {

    }
}
