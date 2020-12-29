package com.test.service;

import java.util.List;

public interface PrintService {
    void prinAdd(List<String> todoItems, Long lastAddIndex);

    void prinDone(long doneIndex);
}
