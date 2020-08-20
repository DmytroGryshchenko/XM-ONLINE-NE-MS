package com.icthh.xm.tmf.ms.communication.domain;

public class VodData {

    private String vod;
    private String hd;

    public VodData(String vod, String hd) {
        this.vod = vod;
        this.hd = hd;
    }

    public VodData() {
    }

    public String getVod() {
        return vod;
    }

    public void setVod(String vod) {
        this.vod = vod;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }
}
