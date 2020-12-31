package com.test.service;

import com.test.bo.Item;

import java.util.List;

/**
 * @创建人 ls
 * @创建时间 2020/12/30 8:36
 *
 */

public interface PreparePrintService {

    List<Item> getTodoItems(List<Item> items);
}
