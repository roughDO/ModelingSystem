package com.just.entity;

public class Water implements IEntity{
    private int id;
    private double waterHeight;
    private double waterTemperature;
    private String date;

    public Water() {
    }

    public Water(int id, double waterHeight, double waterTemperature, String date) {
        this.id = id;
        this.waterHeight = waterHeight;
        this.waterTemperature = waterTemperature;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWaterHeight() {
        return waterHeight;
    }

    public void setWaterHeight(double waterHeight) {
        this.waterHeight = waterHeight;
    }

    public double getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Water{" +
                "id=" + id +
                ", waterHeight=" + waterHeight +
                ", waterTemperature=" + waterTemperature +
                ", date='" + date + '\'' +
                '}';
    }
}
