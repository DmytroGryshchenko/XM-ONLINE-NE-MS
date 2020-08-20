package com.icthh.xm.tmf.ms.communication.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Client {

    private int uid;
    private String login;
    private String password;

    public Client() {
    }

    public Client(int uid, String login, String password) {
        this.uid = uid;
        this.login = login;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
