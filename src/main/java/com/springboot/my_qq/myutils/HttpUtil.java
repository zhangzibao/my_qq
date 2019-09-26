package com.springboot.my_qq.myutils;


import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.scheduling.support.SimpleTriggerContext;

/**
 * @author 马弦
 * @date 2017年10月23日 下午2:49
 * HttpClient工具类
 */
public class HttpUtil {

    private static Logger logger = Logger.getLogger(HttpUtil.class);

    public static String doPost(String url, JSONObject params) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Content-Type", "Text");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params.toJSONString(), charSet);
        System.out.println(entity);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {

            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                return EntityUtils.toString(responseEntity, "utf-8");
            } else {
                logger.error("请求返回:" + state + "(" + url + ")");
            }
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

