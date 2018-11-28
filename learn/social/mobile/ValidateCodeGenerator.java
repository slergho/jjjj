package com.example.learn.social.mobile;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码生成器
 */
public interface ValidateCodeGenerator {

    /**
     * 生成校验码
     */
    ValidateCode generate(ServletWebRequest request);
}
