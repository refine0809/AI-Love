package com.zl.AiLoveAgent.demo;

/**
 * 火山方舟 API Key / 模型 ID（从环境变量读取，勿把真实密钥写入代码仓库）
 * <ul>
 *   <li>ARK_API_KEY：控制台「API Key 管理」创建</li>
 *   <li>ARK_MODEL：推理接入点 ID（如 ep-xxxx）或模型 ID</li>
 * </ul>
 */
public interface VolcengineApiKey {

    String API_KEY = System.getenv().getOrDefault("ARK_API_KEY", "");

    String MODEL = System.getenv().getOrDefault("ARK_MODEL", "");
}
