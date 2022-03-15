package com.xuexiang.server.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 用户数据库表
 *
 * @author xuexiang
 * @since 2020/8/31 12:22 AM
 */
@Entity
public class User {
    public static final String KEY_ID = "Id";
    public static final String KEY_LOGIN_NAME = "loginName";
    public static final String KEY_PASSWORD = "password";

    @Id(autoincrement = true)
    @Unique
    private Long Id;

    @Unique
    private String loginName;

    private String password;

    private String name;

    private int gender;

    private int age;

    private String phone;


    public User() {
    }

    @Generated(hash = 397181959)
    public User(Long Id, String loginName, String password, String name, int gender,
            int age, String phone) {
        this.Id = Id;
        this.loginName = loginName;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }

    public Long getId() {
        return Id;
    }

    public User setId(long id) {
        Id = id;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public User setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getGender() {
        return gender;
    }

    public User setGender(int gender) {
        this.gender = gender;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getGenderName() {
        if (gender == 0) {
            return "男";
        } else if (gender == 1) {
            return "女";
        } else {
            return "未知";
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
}