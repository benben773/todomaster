package com.test.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.bo.Item;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：ls05
 * @date ：Created in 2021/1/2 9:08
 */
public class TodoJsonFileUtils {
    public static final String filePath = "C:/data/todoList.json";
    public static final String UTF_8 = "UTF-8";
    public static final Item initItem = new Item("");
    public static final Charset CHARSET = Charset.forName(UTF_8);
    ObjectMapper objectMapper = new ObjectMapper();

    public Item getLastItem() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
            return initItem;
        }
        List<String> strings = FileUtils.readLines(file, CHARSET);
        if (strings == null || strings.size() <= 0) {
            return initItem;
        }
        String itemJson = strings.get(strings.size()-1);
        return objectMapper.readValue(itemJson, Item.class);

    }

    public void writeNewItem(Item itemNew) throws IOException {
        File file = new File(filePath);
        ArrayList<String> lines = new ArrayList<>();
        lines.add(objectMapper.writeValueAsString(itemNew));
        FileUtils.writeLines(file,UTF_8,lines,true);
    }

    public List<Item> getAllItems() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        List<String> strings = FileUtils.readLines(file, CHARSET);
        List<Item> items = strings.stream().map(s -> {
            try {
                return objectMapper.readValue(s, Item.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        return items;
    }

    public void writeAllItem(List<Item> items) throws IOException {
        File file = new File(filePath);
        List<String> lines = items.stream().map(item -> {
            try {
                return objectMapper.writeValueAsString(item);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return "";
            }
        }).collect(Collectors.toList());
        FileUtils.writeLines(file,UTF_8,lines,false);
    }

    public void cleanFile() throws IOException {
        File file = new File(filePath);
        FileUtils.forceDelete(file);
    }
}
