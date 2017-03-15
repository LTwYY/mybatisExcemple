package com.weepal.xult.po;

import java.util.Date;

/**
 * 用户类
 * 
 * @author xult
 * @date 2017年3月15日 下午2:17:52
 */
public class User {
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(final String name) {
        this.username = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(username);
        builder.append(", sex=");
        builder.append(sex);
        builder.append(", birthday=");
        builder.append(birthday);
        builder.append(", address=");
        builder.append(address);
        builder.append("]");
        return builder.toString();
    }
}
