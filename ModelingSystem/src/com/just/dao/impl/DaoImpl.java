package com.just.dao.impl;

import com.just.dao.Dao;
import com.just.entity.Entity;
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

public class DaoImpl implements Dao {
    private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    private QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
    @Override
    public List<Entity> getListEntities() {
        String sql = "select * from entity";
        List<Entity> entities = null;
        try {
            entities = runner.query(sql,new BeanListHandler<Entity>(Entity.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public List<Entity> getListEntitiesFromTime(String startTime, String endTime) {
        List<Entity> rawEntities = getListEntities();
        List<Entity> entities = new ArrayList<>();
        LocalDateTime start_Time = LocalDateTime.parse(startTime, formatter2);
        LocalDateTime end_Time = LocalDateTime.parse(endTime, formatter2);
        for(Entity entity : rawEntities){
            LocalDateTime entityTime = LocalDateTime.parse(entity.getDate(), formatter1);
            if(entityTime.isAfter(start_Time) && entityTime.isBefore(end_Time)){
                entities.add(entity);
            }
        }
        return entities;
    }

    @Override
    public void initEntities(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = localDateTime.format(formatter);
        // String sql = "INSERT INTO entity (age,date,waterWeight,waterReserve,waterInputStream,waterOutputStream,waterTempture,waterPressure,isWaterWarning,oilHeight,oilReserve,oilInputStream,oilOutputStream,oilTempture,oilPressure,oilIsWarning,voltage,fanSpeed,state) VALUES("+1+","+"2023-11-29"+","+20.0+","+20.0+","+20.0+","+20.0+","+20.0+","+20.0+","+0+","+20.0+","+20.0+","+20.0+","+20.0+","+20.0+","+20.0+","+0+","+15.00+","+3000+","+"Waiting"+")";
        String sql = "INSERT INTO entity (age,date,waterHeight,waterReserve,waterInputStream,waterOutputStream,waterTempture,waterPressure,isWaterWarning,oilHeight,oilReserve,oilInputStream,oilOutputStream,oilTempture,oilPressure,oilIsWarning,voltage,fanSpeed,state) VALUES (1,'"+now+"',20.0,20.0,20.0,20.0,20.0,20.0,0,20.0,20.0,20.0,20.0,20.0,20.0,0,15.00,3000,'Waiting')";
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
