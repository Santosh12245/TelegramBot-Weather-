package com.telegrambot;

import org.springframework.stereotype.Component;

@Component
public class Pojo {
    @Override
    public String toString() {
        return "Pojo{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", name='" + name + '\'' +
                ", cloud=" + cloud +
                '}';
    }

    public  double temp ;
    public  int humidity ;

    public int pressure ;
    public String name ;

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public int cloud ;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Pojo(double temp, int humidity, int pressure, String name, int cloud) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.name = name;
        this.cloud = cloud;
    }

    public Pojo(){

    }

}
