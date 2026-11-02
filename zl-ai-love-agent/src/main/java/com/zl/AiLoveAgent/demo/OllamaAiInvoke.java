package com.zl.AiLoveAgent.demo;

import org.springframework.boot.CommandLineRunner;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.messages.AssistantMessage;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Component;

// 取消注释即可在 Spring Boot 启动时执行；跑 LoveApp 测试时请保持注释，避免干扰
// @Component
public class OllamaAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel ollamaChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage output = ollamaChatModel.call(new Prompt("你好，我是荒天帝石昊"))
                .getResult()
                .getOutput();
        System.out.println(output.getText());
    }
}

