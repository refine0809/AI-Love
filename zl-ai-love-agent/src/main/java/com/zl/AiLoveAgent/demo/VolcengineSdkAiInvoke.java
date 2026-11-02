package com.zl.AiLoveAgent.demo;

import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionResult;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;

import java.util.Arrays;
import java.util.List;

/**
 * 火山引擎方舟 SDK 接入：调用豆包等大模型
 * 直接运行本类 main 即可（不依赖 Spring Boot）
 */
public class VolcengineSdkAiInvoke {

    private static final String BASE_URL = "https://ark.cn-beijing.volces.com/api/v3";

    public static ChatCompletionResult callWithMessage() {
        ArkService service = ArkService.builder()
                .apiKey(VolcengineApiKey.API_KEY)
                .baseUrl(BASE_URL)
                .build();
        try {
            List<ChatMessage> messages = Arrays.asList(
                    ChatMessage.builder()
                            .role(ChatMessageRole.SYSTEM)
                            .content("You are a helpful assistant.")
                            .build(),
                    ChatMessage.builder()
                            .role(ChatMessageRole.USER)
                            .content("你好，我是荒天帝石昊")
                            .build()
            );
            ChatCompletionRequest request = ChatCompletionRequest.builder()
                    .model(VolcengineApiKey.MODEL)
                    .messages(messages)
                    .build();
            return service.createChatCompletion(request);
        } finally {
            service.shutdownExecutor();
        }
    }

    public static void main(String[] args) {
        try {
            ChatCompletionResult result = callWithMessage();
            result.getChoices().forEach(choice ->
                    System.out.println(choice.getMessage().getContent()));
        } catch (Exception e) {
            System.err.println("调用火山方舟失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
