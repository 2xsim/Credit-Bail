package com.mmp.creditbail.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AutoUpdateView {

    private String time;

    @PostConstruct
    public void init() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
        Date now = new Date();
        time = sdfDate.format(now);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}