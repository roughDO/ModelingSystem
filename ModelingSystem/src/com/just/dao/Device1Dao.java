package com.just.dao;

import com.just.entity.Device1;

import java.util.List;

public interface Device1Dao {
    public List<Device1> getListDevice1();
    public List<Device1> getListDevice1ByTime(String startTime, String endTime);
    public List<String> getColumns(String formName);
    public void initDevice1();
}
