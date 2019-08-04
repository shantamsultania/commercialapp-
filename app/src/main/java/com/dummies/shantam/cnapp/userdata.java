package com.dummies.shantam.cnapp;

public class userdata {
    String regname,regnumber,regemail;

    public  userdata()
    {}
    public userdata(String regname, String regnumber, String regemail) {
        this.regname = regname;
        this.regnumber = regnumber;
        this.regemail = regemail;
    }

    public void setRegname(String regname) {
        this.regname = regname;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public void setRegemail(String regemail) {
        this.regemail = regemail;
    }

    public String getRegname() {
        return regname;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public String getRegemail() {
        return regemail;
    }
}
