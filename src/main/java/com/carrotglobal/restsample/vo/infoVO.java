package com.carrotglobal.restsample.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InfoVO {

    private int idx;

    private String info;

    /* @Override
    public String toString(){
       return "HJLOG to String idx : " + idx + " info : " + info;
    } */

}