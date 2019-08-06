package com.unigrative.plugins.common;

public enum ScannerModuleEnum {

    SALES_ORDER("Sales Order"),
    SHIPPING("Shipping");

    private String value;

    ScannerModuleEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
