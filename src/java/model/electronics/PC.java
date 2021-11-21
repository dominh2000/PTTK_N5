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
public class PC extends Electronics implements Serializable{
    private String cpu;
    private String gpu;
    private int storageSize;
    private String storageType;
    private int ramSize;
    private String ramType;
    private String connections;
    private String interfaces;
    private String os;

    public PC() {
    }

    public PC(String cpu, String gpu, int storageSize, String storageType, int ramSize, String ramType, String connections, String interfaces, String os, int id, String name, String manufacturer, Date manufactureDate, float weight, String color, int warranty, String dimensions, String countryOrigin) {
        super(id, name, manufacturer, manufactureDate, weight, color, warranty, dimensions, countryOrigin);
        this.cpu = cpu;
        this.gpu = gpu;
        this.storageSize = storageSize;
        this.storageType = storageType;
        this.ramSize = ramSize;
        this.ramType = ramType;
        this.connections = connections;
        this.interfaces = interfaces;
        this.os = os;
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

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
    
    
}
