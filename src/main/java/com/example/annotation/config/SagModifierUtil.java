package com.example.annotation.config;

import org.springframework.stereotype.Component;

@Component
public class SagModifierUtil {
    public static String getUpdatedSubjectCode(String sagCode) {
        int length = sagCode.length();
        int zeroesToBeAppended = Math.max(0, 8 - length);
        String zeroPadding = "0".repeat(zeroesToBeAppended);
        return "A" + zeroPadding + sagCode;
    }
}
