package com.test.service;

import java.util.List;

public interface PrintService {
    void print(List<String> todoItems, Long lastAddIndex);
}
