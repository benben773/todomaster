package com.test.service.impl;

import com.test.bo.CurrentUserBo;
import com.test.service.ExecuService;
import com.test.service.UserInfoSerivce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

class ExecuteServiceImplTest {
    UserInfoSerivce userInfoSerivce = new UserInfoXmlSerivceImpl();
    String userWithId2 = "2";
    TodoJsonFileUtils todoFieUtils = new TodoJsonFileUtils();
    public static final String todo_config_path = System.getProperty("user.home") +"/.todo-config";
    @BeforeEach
    void setUp() throws IOException {
        userInfoSerivce.writeCurrentUserInof(userWithId2);
        TodoJsonFileUtils todoFieUtils = new TodoJsonFileUtils();
        todoFieUtils.cleanFile();

        ArrayList<CurrentUserBo> currentUserBos = new ArrayList<>();
        currentUserBos.add(new CurrentUserBo(userWithId2));
        todoFieUtils.writeCollectionToFile(currentUserBos,todo_config_path);

    }

    @ParameterizedTest
    @CsvSource({
            "todo add apple,todo add banana,todo done 1",
            "todo add apple,todo add banana,todo done 2",
            "todo add apple,todo add banana,todo list --all",
//            "todo add apple,todo add banana,todo login -u ls",
            "todo add apple,todo done 1,todo list --all"
    })
    public void should_get_item_done(String arg1,String arg2,String arg3) throws IOException {
        LinkedList<String[] > inputs = new LinkedList<>();
        inputs.add(arg1.split(" "));
        inputs.add(arg2.split(" "));
        inputs.add(arg3.split(" "));
        this.processCommand(inputs);
    }
    @Test
    public void should_show_todo_item() throws IOException {
        LinkedList<String[] > inputs = new LinkedList<>();
        inputs.add("todo add apple".split(" "));
        inputs.add("todo add banana".split(" "));
        inputs.add("todo done 1".split(" "));
        inputs.add("todo list".split(" "));
        this.processCommand(inputs);
    }

    private void processCommand(LinkedList<String[]> inputs) throws IOException {
        ExecuService commandService = new ExecuServiceProxy();
        for (String[] input : inputs) {
            commandService.execute(input);
        }
    }
}