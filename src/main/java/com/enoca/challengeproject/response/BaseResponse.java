package com.enoca.challengeproject.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class BaseResponse {
    private HashMap<String,Object> data = new HashMap<>();
    private String errDesc;
    private boolean success;
}
