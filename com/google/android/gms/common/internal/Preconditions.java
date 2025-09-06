package com.google.android.gms.common.internal;

import A7.d;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zze;
import java.util.Objects;

@KeepForSdk
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void checkArgument(boolean z) {
        if(!z) {
            throw new IllegalArgumentException();
        }
    }

    @KeepForSdk
    public static void checkArgument(boolean z, Object object0) {
        if(!z) {
            throw new IllegalArgumentException(String.valueOf(object0));
        }
    }

    @KeepForSdk
    public static void checkArgument(boolean z, String s, Object[] arr_object) {
        if(!z) {
            throw new IllegalArgumentException(String.format(s, arr_object));
        }
    }

    @KeepForSdk
    public static double checkArgumentInRange(double f, double f1, double f2, String s) {
        if(f < f1) {
            throw new IllegalArgumentException(Preconditions.zza("%s is out of range of [%f, %f] (too low)", new Object[]{s, f1, f2}));
        }
        if(f > f2) {
            throw new IllegalArgumentException(Preconditions.zza("%s is out of range of [%f, %f] (too high)", new Object[]{s, f1, f2}));
        }
        return f;
    }

    @KeepForSdk
    public static float checkArgumentInRange(float f, float f1, float f2, String s) {
        if(f < f1) {
            throw new IllegalArgumentException(Preconditions.zza("%s is out of range of [%f, %f] (too low)", new Object[]{s, f1, f2}));
        }
        if(f > f2) {
            throw new IllegalArgumentException(Preconditions.zza("%s is out of range of [%f, %f] (too high)", new Object[]{s, f1, f2}));
        }
        return f;
    }

    @KeepForSdk
    public static int checkArgumentInRange(int v, int v1, int v2, String s) {
        if(v < v1) {
            throw new IllegalArgumentException(Preconditions.zza("%s is out of range of [%d, %d] (too low)", new Object[]{s, v1, v2}));
        }
        if(v > v2) {
            throw new IllegalArgumentException(Preconditions.zza("%s is out of range of [%d, %d] (too high)", new Object[]{s, v1, v2}));
        }
        return v;
    }

    @KeepForSdk
    public static long checkArgumentInRange(long v, long v1, long v2, String s) {
        if(v < v1) {
            throw new IllegalArgumentException(Preconditions.zza("%s is out of range of [%d, %d] (too low)", new Object[]{s, v1, v2}));
        }
        if(v > v2) {
            throw new IllegalArgumentException(Preconditions.zza("%s is out of range of [%d, %d] (too high)", new Object[]{s, v1, v2}));
        }
        return v;
    }

    @KeepForSdk
    public static void checkHandlerThread(Handler handler0) {
        Looper looper0 = Looper.myLooper();
        if(looper0 != handler0.getLooper()) {
            String s = looper0 == null ? "null current looper" : looper0.getThread().getName();
            String s1 = handler0.getLooper().getThread().getName();
            StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(s).length() + (String.valueOf(s1).length() + 35) + 1);
            d.u(stringBuilder0, "Must be called on ", s1, " thread, but got ", s);
            stringBuilder0.append(".");
            throw new IllegalStateException(stringBuilder0.toString());
        }
    }

    @KeepForSdk
    public static void checkHandlerThread(Handler handler0, String s) {
        if(Looper.myLooper() != handler0.getLooper()) {
            throw new IllegalStateException(s);
        }
    }

    @KeepForSdk
    public static void checkMainThread() {
        Preconditions.checkMainThread("Must be called on the main application thread");
    }

    @KeepForSdk
    public static void checkMainThread(String s) {
        if(!zze.zza()) {
            throw new IllegalStateException(s);
        }
    }

    @KeepForSdk
    public static String checkNotEmpty(String s) [...] // 潜在的解密器

    @KeepForSdk
    public static String checkNotEmpty(String s, Object object0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException(String.valueOf(object0));
        }
        return s;
    }

    @KeepForSdk
    public static void checkNotGoogleApiHandlerThread() {
        Preconditions.checkNotGoogleApiHandlerThread("Must not be called on GoogleApiHandler thread.");
    }

    @KeepForSdk
    public static void checkNotGoogleApiHandlerThread(String s) {
        Looper looper0 = Looper.myLooper();
        if(looper0 != null && Objects.equals(looper0.getThread().getName(), "GoogleApiHandler")) {
            throw new IllegalStateException(s);
        }
    }

    @KeepForSdk
    public static void checkNotMainThread() {
        Preconditions.checkNotMainThread("Must not be called on the main application thread");
    }

    @KeepForSdk
    public static void checkNotMainThread(String s) {
        if(zze.zza()) {
            throw new IllegalStateException(s);
        }
    }

    @KeepForSdk
    public static Object checkNotNull(Object object0) {
        if(object0 == null) {
            throw new NullPointerException("null reference");
        }
        return object0;
    }

    @KeepForSdk
    public static Object checkNotNull(Object object0, Object object1) {
        if(object0 == null) {
            throw new NullPointerException(String.valueOf(object1));
        }
        return object0;
    }

    @KeepForSdk
    public static int checkNotZero(int v) {
        if(v == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        return v;
    }

    @KeepForSdk
    public static int checkNotZero(int v, Object object0) {
        if(v == 0) {
            throw new IllegalArgumentException(String.valueOf(object0));
        }
        return v;
    }

    @KeepForSdk
    public static long checkNotZero(long v) {
        if(v == 0L) {
            throw new IllegalArgumentException("Given Long is zero");
        }
        return v;
    }

    @KeepForSdk
    public static long checkNotZero(long v, Object object0) {
        if(v == 0L) {
            throw new IllegalArgumentException(String.valueOf(object0));
        }
        return v;
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

    @KeepForSdk
    public static void checkState(boolean z, String s, Object[] arr_object) {
        if(!z) {
            throw new IllegalStateException(String.format(s, arr_object));
        }
    }

    public static String zza(String s, Object[] arr_object) {
        StringBuilder stringBuilder0 = new StringBuilder(s.length() + 0x30);
        int v = 0;
        int v1;
        for(v1 = 0; v1 < 3; ++v1) {
            int v2 = s.indexOf("%s", v);
            if(v2 == -1) {
                break;
            }
            stringBuilder0.append(s.substring(v, v2));
            stringBuilder0.append(arr_object[v1]);
            v = v2 + 2;
        }
        stringBuilder0.append(s.substring(v));
        if(v1 < 3) {
            stringBuilder0.append(" [");
            int v3 = v1 + 1;
            stringBuilder0.append(arr_object[v1]);
            while(v3 < 3) {
                stringBuilder0.append(", ");
                stringBuilder0.append(arr_object[v3]);
                ++v3;
            }
            stringBuilder0.append("]");
        }
        return stringBuilder0.toString();
    }
}

