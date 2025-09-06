package com.google.android.gms.internal.common;

import com.iloen.melon.utils.a;

public final class zzt {
    public static void zza(boolean z) {
        if(!z) {
            throw new IllegalStateException();
        }
    }

    public static int zzb(int v, int v1, String s) {
        String s1;
        if(v >= 0 && v < v1) {
            return v;
        }
        if(v >= 0) {
            if(v1 < 0) {
                throw new IllegalArgumentException(a.k(v1, "negative size: ", new StringBuilder(String.valueOf(v1).length() + 15)));
            }
            s1 = zzz.zza("%s (%s) must be less than size (%s)", new Object[]{"index", v, v1});
        }
        else {
            s1 = zzz.zza("%s (%s) must not be negative", new Object[]{"index", v});
        }
        throw new IndexOutOfBoundsException(s1);
    }

    public static int zzc(int v, int v1, String s) {
        if(v < 0 || v > v1) {
            throw new IndexOutOfBoundsException(zzt.zze(v, v1, "index"));
        }
        return v;
    }

    public static void zzd(int v, int v1, int v2) {
        String s;
        if(v >= 0 && v1 >= v && v1 <= v2) {
            return;
        }
        if(v < 0 || v > v2) {
            s = zzt.zze(v, v2, "start index");
        }
        else if(v1 >= 0 && v1 <= v2) {
            s = zzz.zza("end index (%s) must not be less than start index (%s)", new Object[]{v1, v});
        }
        else {
            s = zzt.zze(v1, v2, "end index");
        }
        throw new IndexOutOfBoundsException(s);
    }

    private static String zze(int v, int v1, String s) {
        if(v < 0) {
            return zzz.zza("%s (%s) must not be negative", new Object[]{s, v});
        }
        if(v1 < 0) {
            throw new IllegalArgumentException(a.k(v1, "negative size: ", new StringBuilder(String.valueOf(v1).length() + 15)));
        }
        return zzz.zza("%s (%s) must not be greater than size (%s)", new Object[]{s, v, v1});
    }
}

