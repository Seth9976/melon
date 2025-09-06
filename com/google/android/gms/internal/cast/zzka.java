package com.google.android.gms.internal.cast;

public final class zzka {
    public static Object zza(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException(s + " must not be null");
        }
        return object0;
    }

    public static String zzb(String s) {
        if(s.isEmpty()) {
            throw new IllegalArgumentException("identifier must not be empty");
        }
        if(!zzka.zzc(s.charAt(0))) {
            throw new IllegalArgumentException("identifier must start with an ASCII letter: " + s);
        }
        for(int v = 1; v < s.length(); ++v) {
            int v1 = s.charAt(v);
            if(!zzka.zzc(((char)v1)) && (v1 < 0x30 || v1 > 57) && v1 != 0x5F) {
                throw new IllegalArgumentException("identifier must contain only ASCII letters, digits or underscore: " + s);
            }
        }
        return s;
    }

    private static boolean zzc(char c) {
        return c < 97 || c > 0x7A ? c >= 65 && c <= 90 : true;
    }
}

