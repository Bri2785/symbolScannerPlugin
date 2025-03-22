package com.fbi.plugins.unigrative.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Scanners {

    @XmlElement(name="scanner")
    private ArrayList<ScannerObject> scanners;

    public ArrayList<ScannerObject> getScanners() {
        return scanners;
    }

    public void setScanners(ArrayList<ScannerObject> scanners) {
        this.scanners = scanners;
    }
}
