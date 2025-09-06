package com.google.android.gms.internal.cast;

public final class zzgk {
    public static String zza(String s) {
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            if(zzgk.zzb(s.charAt(v1))) {
                char[] arr_c = s.toCharArray();
                while(v1 < v) {
                    int v2 = arr_c[v1];
                    if(zzgk.zzb(((char)v2))) {
                        arr_c[v1] = (char)(v2 ^ 0x20);
                    }
                    ++v1;
                }
                return String.valueOf(arr_c);
            }
        }
        return s;
    }

    public static boolean zzb(char c) {
        return c >= 97 && c <= 0x7A;
    }
}

