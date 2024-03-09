package com.just.dao;

import com.just.entity.Entity;

import java.util.List;

public interface Dao {
    public List<Entity> getListEntities();
    public List<Entity> getListEntitiesFromTime(String startTime,String endTime);
    public void initEntities();
    public List<String> getColumns(String formName);
}
