package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.PreparePrintService;
import com.test.service.ProcessItemservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class PrepareServiceImpl implements PreparePrintService {

    @Override
    public List<Item> getTodoItems(List<Item> items) {
        List<Item> collect = items.stream().filter(o -> {
            return !o.getDoneStatus();
        }).collect(Collectors.toList());
        return collect;
    }
}
