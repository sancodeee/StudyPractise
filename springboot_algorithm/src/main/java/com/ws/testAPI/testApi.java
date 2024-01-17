package com.ws.testAPI;

import com.gitee.huanminabc.utils_tools.null_chain.NULL;
import org.junit.jupiter.api.Test;

public class testApi {

    @Test
    public void test2() {
        User user = new User();
        user.setAge(12);
        user.setAuthor("ssssss");
        Integer i = NULL.of(user).of(User::getAge).get();
        System.out.println(i);
    }

}
