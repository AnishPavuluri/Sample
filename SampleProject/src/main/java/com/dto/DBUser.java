package com.dto;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "DB_USER")
public class DBUser extends BaseDto{

	private String userName;
    private String password;

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PrePersist
    @PreUpdate

    public void onSaveOrUpdate(){
        System.out.println("########33333333333######333");
        setLastUpdatedTime(Calendar.getInstance().getTime());
    }

    @Override
    public String toString() {
        return "DBUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
