package com.zl.AiLoveAgent.demo;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.setting.yaml.YamlUtil;

/**
 * 本地密钥读取：优先环境变量，其次 classpath 下的 application-local.yml
 */
final class LocalSecrets {

    private static final Dict LOCAL_YAML = loadLocalYaml();

    private LocalSecrets() {
    }

    static String get(String envKey, String yamlPath) {
        String fromEnv = System.getenv(envKey);
        if (fromEnv != null && !fromEnv.isBlank()) {
            return fromEnv;
        }
        if (LOCAL_YAML == null) {
            return "";
        }
        Object value = LOCAL_YAML.getByPath(yamlPath);
        return value == null ? "" : String.valueOf(value);
    }

    private static Dict loadLocalYaml() {
        try {
            if (ResourceUtil.getResource("application-local.yml") == null) {
                return null;
            }
            return YamlUtil.load(ResourceUtil.getStream("application-local.yml"), Dict.class);
        } catch (Exception ignored) {
            return null;
        }
    }
}
