package com.kakao.emoticon.cache.util;

import android.text.TextUtils;
import java.util.Collection;

public final class Preconditions {
    public static void checkArgument(boolean z, String s) {
        if(!z) {
            throw new IllegalArgumentException(s);
        }
    }

    public static String checkNotEmpty(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return s;
    }

    public static Collection checkNotEmpty(Collection collection0) {
        if(collection0.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return collection0;
    }

    public static Object checkNotNull(Object object0) {
        return Preconditions.checkNotNull(object0, "Argument must not be null");
    }

    public static Object checkNotNull(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException(s);
        }
        return object0;
    }
}

