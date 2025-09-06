package com.kakao.emoticon.cache;

import java.security.MessageDigest;

public interface Key {
    public static final String STRING_CHARSET_NAME = "UTF-8";

    @Override
    boolean equals(Object arg1);

    @Override
    int hashCode();

    void updateDiskCacheKey(MessageDigest arg1);
}

