package com.carrotglobal.restsample.dto;

import lombok.Data;

@Data
public class InfoDTO {

    private int idx;
    private String info;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}