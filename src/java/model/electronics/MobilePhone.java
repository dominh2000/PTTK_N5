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
public class MobilePhone extends Electronics implements Serializable{
    private String cpu;
    private String gpu;
    private int storageSize;
    private float screenSize;
    private String screenResolution;
    private int ramSize;
    private String connections;
    private String interfaces;
    private String battery;
    private String os;
    private String frontCamera;
    private String rearCamera;
    private String speaker;

    public MobilePhone() {
    }

    public MobilePhone(String cpu, String gpu, int storageSize, float screenSize, String screenResolution, int ramSize, String connections, String interfaces, String battery, String os, String frontCamera, String rearCamera, String speaker, int id, String name, String manufacturer, Date manufactureDate, float weight, String color, int warranty, String dimensions, String countryOrigin) {
        super(id, name, manufacturer, manufactureDate, weight, color, warranty, dimensions, countryOrigin);
        this.cpu = cpu;
        this.gpu = gpu;
        this.storageSize = storageSize;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
        this.ramSize = ramSize;
        this.connections = connections;
        this.interfaces = interfaces;
        this.battery = battery;
        this.os = os;
        this.frontCamera = frontCamera;
        this.rearCamera = rearCamera;
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

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(String rearCamera) {
        this.rearCamera = rearCamera;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
    
    
}
