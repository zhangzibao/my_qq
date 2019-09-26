package com.springboot.my_qq.myutils;

import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.*;

public class TestJWT {
    public static void main(String[] args) throws UnsupportedEncodingException, JsonProcessingException {
        String sert = "dsafsdfdsfsdfsdfsdfsadfsd"; // 部分信息只是base64加密 （可以解密）
        System.out.println(Algorithm.HMAC256(sert));
        JSONObject jobj = JSON.parseObject("{\"username\":\"daiyi\",\"name\":\"n\"}");
        String hisen = Jwt.sign(jobj, 60L * 1000L * 60L * 24L * 7L);
        JSONObject unsign = Jwt.unsign(hisen, JSONObject.class);
        assert unsign != null;

        System.out.println(unsign);

    }
}
