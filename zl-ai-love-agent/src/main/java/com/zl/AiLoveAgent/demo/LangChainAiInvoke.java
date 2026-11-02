package com.zl.AiLoveAgent.demo;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;

/**
 * 4. LangChain4j 接入：使用 LangChain4j 社区 DashScope 组件调用百炼大模型
 */
public class LangChainAiInvoke {

    public static void main(String[] args) {
        ChatLanguageModel qwenModel = QwenChatModel.builder()
                .apiKey(TestApiKey.API_KEY)
                .modelName("qwen-max")
                .build();
        String answer = qwenModel.chat("我是荒天帝石昊");
        System.out.println(answer);
    }
}
