package com.test.bo;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class Item {
    private boolean done = false;
    private long index;

    public Item() {
    }

    public String getName() {
        return name;
    }

    private String name;

    public Item(String name) {
        index = 0L;
        this.name = name;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone() {
        done = true;
    }

    public long getIndex() {
        return this.index ;
    }

    public void setIndex(Long index) {
        this.index = index.longValue();
    }
}
