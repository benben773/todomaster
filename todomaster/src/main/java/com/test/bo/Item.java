package com.test.bo;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class Item {
    private boolean isDone = false;
    public String getName() {
        return name;
    }

    private String name;

    public Item(String name) {

        this.name = name;
    }

    public boolean getDoneStatus() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }
}
