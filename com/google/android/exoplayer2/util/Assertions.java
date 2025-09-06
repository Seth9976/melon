package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class Assertions {
    public static void checkArgument(boolean z) {
        if(!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, Object object0) {
        if(!z) {
            throw new IllegalArgumentException(String.valueOf(object0));
        }
    }

    public static int checkIndex(int v, int v1, int v2) {
        if(v < v1 || v >= v2) {
            throw new IndexOutOfBoundsException();
        }
        return v;
    }

    public static void checkMainThread() {
        if(Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Not in applications main thread");
        }
    }

    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException();
        }
        return s;
    }

    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String s, Object object0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException(String.valueOf(object0));
        }
        return s;
    }

    @EnsuresNonNull({"#1"})
    public static Object checkNotNull(Object object0) {
        object0.getClass();
        return object0;
    }

    @EnsuresNonNull({"#1"})
    public static Object checkNotNull(Object object0, Object object1) {
        if(object0 == null) {
            throw new NullPointerException(String.valueOf(object1));
        }
        return object0;
    }

    public static void checkState(boolean z) {
        if(!z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z, Object object0) {
        if(!z) {
            throw new IllegalStateException(String.valueOf(object0));
        }
    }

    @EnsuresNonNull({"#1"})
    public static Object checkStateNotNull(Object object0) {
        if(object0 == null) {
            throw new IllegalStateException();
        }
        return object0;
    }

    @EnsuresNonNull({"#1"})
    public static Object checkStateNotNull(Object object0, Object object1) {
        if(object0 == null) {
            throw new IllegalStateException(String.valueOf(object1));
        }
        return object0;
    }
}

