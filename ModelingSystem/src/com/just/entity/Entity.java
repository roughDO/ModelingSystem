package com.just.entity;


public class Entity implements IEntity{
    private int id;
    private int age;
    private String date;
    private double waterHeight;
    private double waterReserve;
    private double waterInputStream;
    private double waterOutputStream;
    private double waterTempture;
    private double waterPressure;
    private boolean isWaterWarning;
    private double oilHeight;
    private double oilReserve;
    private double oilInputStream;
    private double oilOutputStream;
    private double oilTempture;
    private double oilPressure;
    private boolean oilIsWarning;
    private double voltage;
    private int fanSpeed;
    private String state;// Running Waiting Closing

    public Entity() {
    }

    public Entity(int id, int age, String date, double waterHeight, double waterReserve, double waterInputStream, double waterOutputStream, double waterTempture, double waterPressure, boolean isWaterWarning, double oilHeight, double oilReserve, double oilInputStream, double oilOutputStream, double oilTempture, double oilPressure, boolean oilIsWarning, double voltage, int fanSpeed, String state) {
        this.id = id;
        this.age = age;
        this.date = date;
        this.waterHeight = waterHeight;
        this.waterReserve = waterReserve;
        this.waterInputStream = waterInputStream;
        this.waterOutputStream = waterOutputStream;
        this.waterTempture = waterTempture;
        this.waterPressure = waterPressure;
        this.isWaterWarning = isWaterWarning;
        this.oilHeight = oilHeight;
        this.oilReserve = oilReserve;
        this.oilInputStream = oilInputStream;
        this.oilOutputStream = oilOutputStream;
        this.oilTempture = oilTempture;
        this.oilPressure = oilPressure;
        this.oilIsWarning = oilIsWarning;
        this.voltage = voltage;
        this.fanSpeed = fanSpeed;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWaterHeight() {
        return waterHeight;
    }

    public void setWaterHeight(double waterHeight) {
        this.waterHeight = waterHeight;
    }

    public double getWaterReserve() {
        return waterReserve;
    }

    public void setWaterReserve(double waterReserve) {
        this.waterReserve = waterReserve;
    }

    public double getWaterInputStream() {
        return waterInputStream;
    }

    public void setWaterInputStream(double waterInputStream) {
        this.waterInputStream = waterInputStream;
    }

    public double getWaterOutputStream() {
        return waterOutputStream;
    }

    public void setWaterOutputStream(double waterOutputStream) {
        this.waterOutputStream = waterOutputStream;
    }

    public double getWaterTempture() {
        return waterTempture;
    }

    public void setWaterTempture(double waterTempture) {
        this.waterTempture = waterTempture;
    }

    public double getWaterPressure() {
        return waterPressure;
    }

    public void setWaterPressure(double waterPressure) {
        this.waterPressure = waterPressure;
    }

    public boolean isWaterWarning() {
        return isWaterWarning;
    }

    public void setWaterWarning(boolean waterWarning) {
        isWaterWarning = waterWarning;
    }

    public double getOilHeight() {
        return oilHeight;
    }

    public void setOilHeight(double oilHeight) {
        this.oilHeight = oilHeight;
    }

    public double getOilReserve() {
        return oilReserve;
    }

    public void setOilReserve(double oilReserve) {
        this.oilReserve = oilReserve;
    }

    public double getOilInputStream() {
        return oilInputStream;
    }

    public void setOilInputStream(double oilInputStream) {
        this.oilInputStream = oilInputStream;
    }

    public double getOilOutputStream() {
        return oilOutputStream;
    }

    public void setOilOutputStream(double oilOutputStream) {
        this.oilOutputStream = oilOutputStream;
    }

    public double getOilTempture() {
        return oilTempture;
    }

    public void setOilTempture(double oilTempture) {
        this.oilTempture = oilTempture;
    }

    public double getOilPressure() {
        return oilPressure;
    }

    public void setOilPressure(double oilPressure) {
        this.oilPressure = oilPressure;
    }

    public boolean isOilIsWarning() {
        return oilIsWarning;
    }

    public void setOilIsWarning(boolean oilIsWarning) {
        this.oilIsWarning = oilIsWarning;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "Id=" + id +
                ", Age=" + age +
                ", date=" + date +
                ", waterHeight=" + waterHeight +
                ", waterReserve=" + waterReserve +
                ", waterInputStream=" + waterInputStream +
                ", waterOutputStream=" + waterOutputStream +
                ", waterTempture=" + waterTempture +
                ", waterPressure=" + waterPressure +
                ", isWaterWarning=" + isWaterWarning +
                ", oilHeight=" + oilHeight +
                ", oilReserve=" + oilReserve +
                ", oilInputStream=" + oilInputStream +
                ", oilOutputStream=" + oilOutputStream +
                ", oilTempture=" + oilTempture +
                ", oilPressure=" + oilPressure +
                ", oilIsWarning=" + oilIsWarning +
                ", voltage=" + voltage +
                ", fanSpeed=" + fanSpeed +
                ", state='" + state + '\'' +
                '}';
    }
}
