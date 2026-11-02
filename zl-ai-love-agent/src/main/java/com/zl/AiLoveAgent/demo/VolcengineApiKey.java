package com.zl.AiLoveAgent.demo;

/**
 * 火山方舟 API Key / 模型 ID。
 * 优先环境变量 ARK_API_KEY / ARK_MODEL，否则读 application-local.yml。
 */
public interface VolcengineApiKey {

    String API_KEY = LocalSecrets.get("ARK_API_KEY", "ark.api-key");

    String MODEL = LocalSecrets.get("ARK_MODEL", "ark.model");
}
