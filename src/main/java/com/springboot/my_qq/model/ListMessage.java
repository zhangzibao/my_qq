package com.springboot.my_qq.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ListMessage {
    private Date addTime;
    private Boolean isreceive;
    private String messageContent;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Boolean getIsreceive() {
        return isreceive;
    }

    public void setIsreceive(Boolean isreceive) {
        this.isreceive = isreceive;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }
}
