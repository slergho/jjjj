package com.example.login.utils;

import org.apache.commons.lang3.StringUtils;

public class StringsUtils {

    public static boolean isNotNull(String string){
        return StringUtils.isNotEmpty(string)&&!"null".equals(string);
    }
}
