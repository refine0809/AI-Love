package com.zl.AiLoveAgent.app;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class LoveAppTest {

    @Resource
    private LoveApp loveApp;

    @Test
    void testChat() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是完美世界主角，荒天帝石昊";
        String answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        System.out.println("________________________________________________________");
        // 第二轮
        message = "我想让另一半（云曦）更爱我";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        System.out.println("________________________________________________________");
        // 第三轮
        message = "我的另一半叫什么来着？刚跟你说过，帮我回忆一下";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        System.out.println("________________________________________________________");
    }

    @Test
    void doChatWithReport() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是完美世界主角，荒天帝石昊，我想让另一半（云曦）更爱我，但我不知道该怎么做";
        LoveApp.LoveReport loveReport = loveApp.doChatWithReport(message, chatId);
        Assertions.assertNotNull(loveReport);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(loveReport);
    }
}

