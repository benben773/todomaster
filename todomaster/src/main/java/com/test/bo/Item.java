package com.test.bo;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class Item {
    private boolean isDone = false;
    private long index;

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

    public long getIndex() {
        return this.index ;
    }

    public void setIndex(Long index) {
        this.index = index.longValue();
    }
}
