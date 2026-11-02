package com.zl.AiLoveAgent.demo;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 3. Spring AI 接入：基于 Spring 生态的 AI 框架调用百炼大模型
 * 取消下方 @Component 注释即可在 Spring Boot 项目启动时执行
 */
@Component
public class SpringAiAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel dashscopeChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage output = dashscopeChatModel.call(new Prompt("你好，我是荒天帝石昊"))
                .getResult()
                .getOutput();
        System.out.println(output.getText());
    }
}
