package com.unigrative.plugins.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Scanner {

    //@XmlElement
    private int scannerID;
    //@XmlElement
    private long serialnumber;
    //@XmlElement
    private String GUID;
    //@XmlElement
    private int VID;
    //@XmlElement
    private int PID;
    //@XmlElement
    private String modelnumber;
    //@XmlElement
    private String DoM;
    //@XmlElement
    private String firmware;
    //@XmlElement
    private String type;

    public int getScannerID() {
        return scannerID;
    }


    public void setScannerID(int scannerID) {
        this.scannerID = scannerID;
    }

    public long getSerialnumber() {
        return serialnumber;
    }


    public void setSerialnumber(long serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getGUID() {
        return GUID;
    }


    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public int getVID() {
        return VID;
    }

    public void setVID(int VID) {
        this.VID = VID;
    }

    public int getPID() {
        return PID;
    }


    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getModelnumber() {
        return modelnumber;
    }


    public void setModelnumber(String modelnumber) {
        this.modelnumber = modelnumber;
    }

    public String getDoM() {
        return DoM;
    }


    public void setDoM(String doM) {
        DoM = doM;
    }

    public String getFirmware() {
        return firmware;
    }


    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }
}
