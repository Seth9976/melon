package com.google.android.gms.internal.location;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class zzeo {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    private static final StringBuilder zzc;

    static {
        Locale locale0 = Locale.ROOT;
        zzeo.zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale0);
        zzeo.zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale0);
        zzeo.zzc = new StringBuilder(33);
    }

    public static String zza(long v) {
        if(v >= 0L) {
            Date date0 = new Date(v);
            return zzeo.zza.format(date0);
        }
        return Long.toString(v);
    }

    public static String zzb(long v) {
        synchronized(zzeo.zzc) {
            zzeo.zzc.setLength(0);
            zzeo.zzc(v, zzeo.zzc);
            return "";
        }
    }

    public static StringBuilder zzc(long v, StringBuilder stringBuilder0) {
        int v1 = Long.compare(v, 0L);
        if(v1 == 0) {
            stringBuilder0.append("0s");
            return stringBuilder0;
        }
        stringBuilder0.ensureCapacity(stringBuilder0.length() + 27);
        int v2 = 0;
        if(v1 < 0) {
            stringBuilder0.append("-");
            if(v == 0x8000000000000000L) {
                v2 = 1;
                v = 0x7FFFFFFFFFFFFFFFL;
            }
            else {
                v = -v;
            }
        }
        if(v >= 86400000L) {
            stringBuilder0.append(v / 86400000L);
            stringBuilder0.append("d");
            v %= 86400000L;
        }
        if(1 == v2) {
            v = 0x18C5C00L;
        }
        if(v >= 3600000L) {
            stringBuilder0.append(v / 3600000L);
            stringBuilder0.append("h");
            v %= 3600000L;
        }
        if(v >= 60000L) {
            stringBuilder0.append(v / 60000L);
            stringBuilder0.append("m");
            v %= 60000L;
        }
        if(v >= 1000L) {
            stringBuilder0.append(v / 1000L);
            stringBuilder0.append("s");
            v %= 1000L;
        }
        if(v > 0L) {
            stringBuilder0.append(v);
            stringBuilder0.append("ms");
        }
        return stringBuilder0;
    }
}

