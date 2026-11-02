package com.zl.AiLoveAgent.demo;

/**
 * 阿里云百炼 API Key（从环境变量 AI_DASHSCOPE_API_KEY 读取，勿写入仓库）
 */
public interface TestApiKey {

    String API_KEY = System.getenv().getOrDefault("AI_DASHSCOPE_API_KEY", "");
}
