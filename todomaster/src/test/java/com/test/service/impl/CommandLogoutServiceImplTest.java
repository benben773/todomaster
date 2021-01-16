package com.test.service.impl;

import com.test.bo.CurrentUserBo;
import com.test.bo.Item;
import com.test.service.UserInfoSerivce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CommandLogoutServiceImplTest {
    public static final String todo_config_path = System.getProperty("user.home") + "/.todo-config";
    UserInfoSerivce userInfoSerivce = new UserInfoXmlSerivceImpl();
    TodoJsonFileUtils todoFieUtils = new TodoJsonFileUtils();
    ProcessTxtServiceImpl processTxtService = new ProcessTxtServiceImpl();

    @Nested
    class giveOneUserLogin {
        final static String userWithIndex2 = "2";

        @BeforeEach
        void setUp() throws IOException {
            userInfoSerivce.writeCurrentUserInof(userWithIndex2);
            TodoJsonFileUtils todoFieUtils = new TodoJsonFileUtils();
            todoFieUtils.cleanFile();
        }

        @Test
        void should_get_correct_todos() throws IOException {
            switchloginUser(userWithIndex2);
            ArrayList<CurrentUserBo> currentUserList;
            Item apple = new Item("apple");
            Item banana = new Item("banana");
            Item cat = new Item("cat");
            processTxtService.addUserItem(apple);
            processTxtService.addUserItem(banana);

            switchloginUser("1");
            processTxtService.addUserItem(cat);

            switchloginUser(userWithIndex2);
            File todoFile = new File("C:/data/todoList.json");
            assertEquals(true, todoFile.exists());
            processTxtService.done(1L);
            List<Item> allItems = processTxtService.getUserItems();
            assertThat(allItems).extracting("userIndex").doesNotContain("1");
            assertThat(allItems).extracting("index").contains(1L,2L).doesNotContain(3L);
            assertThat(allItems).extracting("name").contains("apple","banana").doesNotContain("cat");
            assertEquals(2, allItems.size());
        }
    }

    private void switchloginUser(String userWithIndex2) throws IOException {
        ArrayList<CurrentUserBo> currentUserList = new ArrayList<>();
        currentUserList.add(new CurrentUserBo(userWithIndex2));
        todoFieUtils.writeCollectionToFile(currentUserList, todo_config_path);
    }

}