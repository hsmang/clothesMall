package com.clothes.mall.domain.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class CommonResult implements Serializable {

    @ApiModelProperty(value = "응답 성공여부 : true/false")
    private boolean success;

    @ApiModelProperty(value = "응답 코드 번호 :  200 정상, != 200 비정상")
    private int code;

    @ApiModelProperty(value = "응답 메시지")
    private String msg;

}