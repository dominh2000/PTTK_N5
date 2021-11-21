/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.electronics;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author pc
 */
public class Laptop extends Electronics implements Serializable{
    private String cpu;
    private String gpu;
    private int storageSize;
    private String storageType;
    private float screenSize;
    private String screenResolution;
    private int ramSize;
    private String ramType;
    private String connections;
    private String interfaces;
    private String battery;
    private String os;
    private String speaker;

    public Laptop() {
    }

    public Laptop(String cpu, String gpu, int storageSize, String storageType, float screenSize, String screenResolution, int ramSize, String ramType, String connections, String interfaces, String battery, String os, String speaker, int id, String name, String manufacturer, Date manufactureDate, float weight, String color, int warranty, String dimensions, String countryOrigin) {
        super(id, name, manufacturer, manufactureDate, weight, color, warranty, dimensions, countryOrigin);
        this.cpu = cpu;
        this.gpu = gpu;
        this.storageSize = storageSize;
        this.storageType = storageType;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
        this.ramSize = ramSize;
        this.ramType = ramType;
        this.connections = connections;
        this.interfaces = interfaces;
        this.battery = battery;
        this.os = os;
        this.speaker = speaker;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public String getConnections() {
        return connections;
    }

    public void setConnections(String connections) {
        this.connections = connections;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
    
    
}
