package com.zzz.springmaven.controller;

import com.zzz.springmaven.base.AbstractController;
import com.zzz.springmaven.model.so.UserSo;
import com.zzz.springmaven.service.ITestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName TestTestController
 * @description TODO
 * @date 2021/3/1 17:17
 **/
public class TestTestController extends AbstractController {
    @Autowired
    private TestController testController;

    @Autowired
    private ITestService iTestService;

    @Test
    public void testIndex(){
        String index = testController.index();
        System.out.println(index);
    }

    @Test
    public void testService() {
        String index = iTestService.testService();
        System.out.println(index);
    }

    @Test
    public void testCreateUser() {
        UserSo userSo = new UserSo();
        System.out.println(testController.createUser(userSo));

    }


}
