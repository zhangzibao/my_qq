package com.springboot.my_qq.model;


import com.alibaba.fastjson.JSONObject;

public class User {
    private Integer id;

    private String uAvatar;

    private String uBirthday;

    private String uName;

    private String uGender;

    private String uEmail;

    private String uPhone;

    private String uAddress;

    private String uAutograph;

    private String uAbout;

    private String uPassword;
    private String OpenId;

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        this.Nickname = nickname == null ? null : nickname.trim();
    }

    private String Nickname;

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        this.OpenId = openId == null ? null : openId.trim();
    }


    public User() {

    }

    public User(JSONObject json) {
        this.uName = json.getString("username");
        this.uPassword = json.getString("password");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuAvatar() {
        return uAvatar;
    }

    public void setuAvatar(String uAvatar) {
        this.uAvatar = uAvatar == null ? null : uAvatar.trim();
    }

    public String getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(String uBirthday) {
        this.uBirthday = uBirthday == null ? null : uBirthday.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender == null ? null : uGender.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress == null ? null : uAddress.trim();
    }

    public String getuAutograph() {
        return uAutograph;
    }

    public void setuAutograph(String uAutograph) {
        this.uAutograph = uAutograph == null ? null : uAutograph.trim();
    }

    public String getuAbout() {
        return uAbout;
    }

    public void setuAbout(String uAbout) {
        this.uAbout = uAbout == null ? null : uAbout.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }
}
