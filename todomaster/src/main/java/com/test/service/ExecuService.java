package com.test.service;

import java.io.IOException;

/**
 * 命令行输入解析打印服务
 * @创建人 ls
 * @创建时间 2020/12/30 2:54
 */
public interface ExecuService {
    /**
     * 命令行输入解析打印服务
     */
    void execute(String[] args) throws IOException;
}
