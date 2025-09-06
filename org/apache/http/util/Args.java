package org.apache.http.util;

import java.util.Collection;
import va.e;

public class Args {
    public static void check(boolean z, String s) {
        if(!z) {
            throw new IllegalArgumentException(s);
        }
    }

    public static void check(boolean z, String s, Object[] arr_object) {
        if(!z) {
            throw new IllegalArgumentException(String.format(s, arr_object));
        }
    }

    public static CharSequence notBlank(CharSequence charSequence0, String s) {
        if(charSequence0 == null) {
            throw new IllegalArgumentException(s + " may not be null");
        }
        if(TextUtils.isBlank(charSequence0)) {
            throw new IllegalArgumentException(s + " may not be blank");
        }
        return charSequence0;
    }

    public static CharSequence notEmpty(CharSequence charSequence0, String s) {
        if(charSequence0 == null) {
            throw new IllegalArgumentException(e.h(s, " may not be null"));
        }
        if(TextUtils.isEmpty(charSequence0)) {
            throw new IllegalArgumentException(e.h(s, " may not be empty"));
        }
        return charSequence0;
    }

    public static Collection notEmpty(Collection collection0, String s) {
        if(collection0 == null) {
            throw new IllegalArgumentException(s + " may not be null");
        }
        if(collection0.isEmpty()) {
            throw new IllegalArgumentException(s + " may not be empty");
        }
        return collection0;
    }

    public static int notNegative(int v, String s) {
        if(v < 0) {
            throw new IllegalArgumentException(e.h(s, " may not be negative"));
        }
        return v;
    }

    public static long notNegative(long v, String s) {
        if(v < 0L) {
            throw new IllegalArgumentException(s + " may not be negative");
        }
        return v;
    }

    public static Object notNull(Object object0, String s) {
        if(object0 == null) {
            throw new IllegalArgumentException(e.h(s, " may not be null"));
        }
        return object0;
    }

    public static int positive(int v, String s) {
        if(v <= 0) {
            throw new IllegalArgumentException(s + " may not be negative or zero");
        }
        return v;
    }

    public static long positive(long v, String s) {
        if(v <= 0L) {
            throw new IllegalArgumentException(e.h(s, " may not be negative or zero"));
        }
        return v;
    }
}

