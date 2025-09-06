package org.apache.http.util;

import va.e;

public class Asserts {
    public static void check(boolean z, String s) {
        if(!z) {
            throw new IllegalStateException(s);
        }
    }

    public static void check(boolean z, String s, Object[] arr_object) {
        if(!z) {
            throw new IllegalStateException(String.format(s, arr_object));
        }
    }

    public static void notBlank(CharSequence charSequence0, String s) {
        if(TextUtils.isBlank(charSequence0)) {
            throw new IllegalStateException(s + " is blank");
        }
    }

    public static void notEmpty(CharSequence charSequence0, String s) {
        if(TextUtils.isEmpty(charSequence0)) {
            throw new IllegalStateException(s + " is empty");
        }
    }

    public static void notNull(Object object0, String s) {
        if(object0 == null) {
            throw new IllegalStateException(e.h(s, " is null"));
        }
    }
}

