package com.test.bo;

/**
 * @author ：ls05
 * @date ：Created in 2021/1/2 19:34
 */
public class CurrentUserBo {
    private long index;
    private String  userId;

    public CurrentUserBo() {
    }

    public CurrentUserBo(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
