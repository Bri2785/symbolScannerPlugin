package com.unigrative.plugins.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Scanners {

    @XmlElement(name="scanner")
    private ArrayList<Scanner> scanners;

    public ArrayList<Scanner> getScanners() {
        return scanners;
    }

    public void setScanners(ArrayList<Scanner> scanners) {
        this.scanners = scanners;
    }
}
