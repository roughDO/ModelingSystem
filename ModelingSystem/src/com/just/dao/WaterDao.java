package com.just.dao;

import com.just.entity.Water;

import java.util.List;

public interface WaterDao {
    public List<Water> getListWater();
    public List<Water> getListWaterFromTime(String startTime, String endTime);
    public void initWater();
    public List<String> getColumns(String formName);
}
