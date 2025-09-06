package com.google.android.gms.common.internal;

import A7.d;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;

@KeepForSdk
public final class Asserts {
    private Asserts() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void checkMainThread(String s) {
        if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        String s1 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder stringBuilder0 = new StringBuilder(s1.length() + 93);
        d.u(stringBuilder0, "checkMainThread: current thread ", "Thread[jeb-dexdec-sb-st-1527,5,main]", " IS NOT the main thread ", s1);
        stringBuilder0.append("!");
        Log.e("Asserts", stringBuilder0.toString());
        throw new IllegalStateException(s);
    }

    @KeepForSdk
    public static void checkNotMainThread(String s) {
        if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
            return;
        }
        String s1 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder stringBuilder0 = new StringBuilder(s1.length() + 92);
        d.u(stringBuilder0, "checkNotMainThread: current thread ", "Thread[jeb-dexdec-sb-st-1526,5,main]", " IS the main thread ", s1);
        stringBuilder0.append("!");
        Log.e("Asserts", stringBuilder0.toString());
        throw new IllegalStateException(s);
    }

    @KeepForSdk
    public static void checkNotNull(@Nullable Object object0) {
        if(object0 == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    @KeepForSdk
    public static void checkNotNull(@Nullable Object object0, Object object1) {
        if(object0 == null) {
            throw new IllegalArgumentException(String.valueOf(object1));
        }
    }

    @KeepForSdk
    public static void checkNull(@Nullable Object object0) {
        if(object0 != null) {
            throw new IllegalArgumentException("non-null reference");
        }
    }

    @KeepForSdk
    public static void checkNull(@Nullable Object object0, Object object1) {
        if(object0 != null) {
            throw new IllegalArgumentException(String.valueOf(object1));
        }
    }

    @KeepForSdk
    public static void checkState(boolean z) {
        if(!z) {
            throw new IllegalStateException();
        }
    }

    @KeepForSdk
    public static void checkState(boolean z, Object object0) {
        if(!z) {
            throw new IllegalStateException(String.valueOf(object0));
        }
    }
}

