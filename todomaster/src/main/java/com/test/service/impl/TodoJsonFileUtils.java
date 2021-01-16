package com.test.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.bo.CurrentUserBo;
import com.test.bo.Item;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author ：ls05
 * @date ：Created in 2021/1/2 9:08
 */
public class TodoJsonFileUtils<T> {
    public static final String todo_config_path = System.getProperty("user.home") +"/.todo-config";
    public static final String filePath = System.getProperty("user.home") + "/todoList.json";
    public static final String UTF_8 = "UTF-8";
    public static final Item initItem = new Item("");
    public static final Charset CHARSET = Charset.forName(UTF_8);
    ObjectMapper objectMapper = new ObjectMapper();
    public static final String ERROR_INDEX = "-1";

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

    public void writeAllItem(List<T> items) throws IOException {
        writeCollectionToFile(items, filePath);
    }

    public void writeCollectionToFile(List<T> items, String filePathtemp) throws IOException {
        File file = new File(filePathtemp);
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

    public String getLoginUserIndex() throws IOException {
        File file = new File(todo_config_path);
        if (!file.exists()) {
            return ERROR_INDEX;
        }
        List<String> strings = FileUtils.readLines(file, CHARSET);
        Optional<String> any = strings.stream().map(s -> {
            try {
                return objectMapper.readValue(s, CurrentUserBo.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return new CurrentUserBo(ERROR_INDEX);
            }
        }).map(CurrentUserBo::getIndex).findAny();
        if (any.isPresent()) {
            return any.get();
        } else {
            return ERROR_INDEX;
        }
    }
}
