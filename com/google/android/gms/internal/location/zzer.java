package com.google.android.gms.internal.location;

import com.iloen.melon.utils.a;
import javax.annotation.CheckForNull;

public final class zzer {
    public static void zza(boolean z) {
        if(!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z, @CheckForNull Object object0) {
        if(!z) {
            throw new IllegalArgumentException(((String)object0));
        }
    }

    public static int zzc(int v, int v1, String s) {
        String s1;
        if(v >= 0 && v < v1) {
            return v;
        }
        if(v >= 0) {
            if(v1 < 0) {
                throw new IllegalArgumentException(a.k(v1, "negative size: ", new StringBuilder(String.valueOf(v1).length() + 15)));
            }
            s1 = zzes.zza("%s (%s) must be less than size (%s)", new Object[]{"index", v, v1});
        }
        else {
            s1 = zzes.zza("%s (%s) must not be negative", new Object[]{"index", v});
        }
        throw new IndexOutOfBoundsException(s1);
    }

    public static int zzd(int v, int v1, String s) {
        if(v < 0 || v > v1) {
            throw new IndexOutOfBoundsException(zzer.zzf(v, v1, "index"));
        }
        return v;
    }

    public static void zze(int v, int v1, int v2) {
        String s;
        if(v >= 0 && v1 >= v && v1 <= v2) {
            return;
        }
        if(v < 0 || v > v2) {
            s = zzer.zzf(v, v2, "start index");
        }
        else if(v1 >= 0 && v1 <= v2) {
            s = zzes.zza("end index (%s) must not be less than start index (%s)", new Object[]{v1, v});
        }
        else {
            s = zzer.zzf(v1, v2, "end index");
        }
        throw new IndexOutOfBoundsException(s);
    }

    private static String zzf(int v, int v1, String s) {
        if(v < 0) {
            return zzes.zza("%s (%s) must not be negative", new Object[]{s, v});
        }
        if(v1 < 0) {
            throw new IllegalArgumentException(a.k(v1, "negative size: ", new StringBuilder(String.valueOf(v1).length() + 15)));
        }
        return zzes.zza("%s (%s) must not be greater than size (%s)", new Object[]{s, v, v1});
    }
}

