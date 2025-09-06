package com.google.android.gms.internal.cast;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzxo {
    static final Charset zza;
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        zzxo.zza = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] arr_b = new byte[0];
        zzxo.zzb = arr_b;
        ByteBuffer.wrap(arr_b);
        zzwo zzwo0 = new zzwo(arr_b, 0, 0, false, null);
        try {
            zzwo0.zza(0);
        }
        catch(zzxq zzxq0) {
            throw new IllegalArgumentException(zzxq0);
        }
    }

    // 去混淆评级： 低(20)
    public static int zza(boolean z) {
        return z ? 0x4CF : 0x4D5;
    }

    public static int zzb(int v, byte[] arr_b, int v1, int v2) {
        for(int v3 = 0; v3 < v2; ++v3) {
            v = v * 0x1F + arr_b[v3];
        }
        return v;
    }

    public static Object zzc(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException("messageType");
        }
        return object0;
    }
}

