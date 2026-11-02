package com.zl.AiLoveAgent.demo;

/**
 * 阿里云百炼 API Key。
 * 优先环境变量 AI_DASHSCOPE_API_KEY，否则读 application-local.yml。
 */
public interface TestApiKey {

    String API_KEY = LocalSecrets.get("AI_DASHSCOPE_API_KEY", "spring.ai.dashscope.api-key");
}
