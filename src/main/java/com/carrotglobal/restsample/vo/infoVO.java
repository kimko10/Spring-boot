package com.carrotglobal.restsample.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InfoVO {

    private int idx;

    private String info;

    public int getIdx() {
        return idx;
    }

    public String getInfo(){
        return info;
    }

}