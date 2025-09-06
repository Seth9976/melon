package com.kakao.emoticon.util;

public class StringUtils {
    public static String EMPTY = "";

    public static boolean isBlank(CharSequence charSequence0) {
        if(charSequence0 != null) {
            int v = charSequence0.length();
            if(v != 0) {
                for(int v1 = 0; v1 < v; ++v1) {
                    if(!Character.isWhitespace(charSequence0.charAt(v1))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence charSequence0) {
        return !StringUtils.isBlank(charSequence0);
    }
}

