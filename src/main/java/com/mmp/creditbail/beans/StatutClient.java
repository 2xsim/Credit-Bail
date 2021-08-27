package com.mmp.creditbail.beans;


public enum StatutClient {
    INSTOCK("In Stock"),
    OUTOFSTOCK("Out of Stock"), 
    LOWSTOCK("Low Stock");
 
    private String text;
 
    StatutClient(String text) {
        this.text = text;
    }
 
    public String getText() {
        return text;
    }
}
