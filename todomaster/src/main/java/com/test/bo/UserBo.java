package com.test.bo;

/**
 * @author ：ls05
 * @date ：Created in 2021/1/2 16:14
 */
public class UserBo {
    private String name;
    private String password;
    private String index;

    public UserBo(String name, String password, String index) {
        this.name = name;
        this.password = password;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getIndex() {
        return index;
    }
}
