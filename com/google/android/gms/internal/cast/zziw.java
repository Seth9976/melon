package com.google.android.gms.internal.cast;

import java.lang.reflect.InvocationTargetException;

final class zziw {
    private static final zziy zza;

    static {
        zziw.zza = zziw.zzb(zziy.zzo());
    }

    private static zziy zzb(String[] arr_s) {
        zziy zziy0 = zzjd.zza;
        if(zziy0 != null) {
            return zziy0;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = 0;
        while(v < arr_s.length) {
            String s = arr_s[v];
            try {
                return (zziy)Class.forName(s).getConstructor(null).newInstance(null);
            }
            catch(Throwable throwable0) {
                stringBuilder0.append('\n');
                stringBuilder0.append(s);
                stringBuilder0.append(": ");
                if(throwable0 instanceof InvocationTargetException) {
                    throwable0 = throwable0.getCause();
                }
                stringBuilder0.append(throwable0);
                ++v;
            }
        }
        throw new IllegalStateException(stringBuilder0.insert(0, "No logging platforms found:").toString());
    }
}

