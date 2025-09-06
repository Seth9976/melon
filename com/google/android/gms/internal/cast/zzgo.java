package com.google.android.gms.internal.cast;

public final class zzgo {
    public static int zza(int v, int v1, String s) {
        String s1;
        if(v >= 0 && v < v1) {
            return v;
        }
        if(v >= 0) {
            if(v1 < 0) {
                throw new IllegalArgumentException("negative size: " + v1);
            }
            s1 = zzgq.zza("%s (%s) must be less than size (%s)", new Object[]{"index", v, v1});
        }
        else {
            s1 = zzgq.zza("%s (%s) must not be negative", new Object[]{"index", v});
        }
        throw new IndexOutOfBoundsException(s1);
    }

    public static int zzb(int v, int v1, String s) {
        if(v < 0 || v > v1) {
            throw new IndexOutOfBoundsException(zzgo.zze(v, v1, "index"));
        }
        return v;
    }

    public static Object zzc(Object object0, Object object1) {
        if(object0 == null) {
            throw new NullPointerException(((String)object1));
        }
        return object0;
    }

    public static void zzd(int v, int v1, int v2) {
        String s;
        if(v >= 0 && v1 >= v && v1 <= v2) {
            return;
        }
        if(v < 0 || v > v2) {
            s = zzgo.zze(v, v2, "start index");
        }
        else if(v1 >= 0 && v1 <= v2) {
            s = zzgq.zza("end index (%s) must not be less than start index (%s)", new Object[]{v1, v});
        }
        else {
            s = zzgo.zze(v1, v2, "end index");
        }
        throw new IndexOutOfBoundsException(s);
    }

    private static String zze(int v, int v1, String s) {
        if(v < 0) {
            return zzgq.zza("%s (%s) must not be negative", new Object[]{s, v});
        }
        if(v1 < 0) {
            throw new IllegalArgumentException("negative size: " + v1);
        }
        return zzgq.zza("%s (%s) must not be greater than size (%s)", new Object[]{s, v, v1});
    }
}

