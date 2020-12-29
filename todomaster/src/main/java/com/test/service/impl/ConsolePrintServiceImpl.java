package com.test.service.impl;

import com.test.service.PrintService;

import java.util.List;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 2:08
 */
public class ConsolePrintServiceImpl implements PrintService {
    long index = 0L;
    @Override
    public void print(List<String> todoItems, Long lastAddIndex) {
        todoItems.stream().forEach(s -> {
            index++;
            System.out.println(index +".<"+s+">");
        });
        System.out.println("Item <"+lastAddIndex+"> added");
    }
}
