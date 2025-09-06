package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzmo {
    static final Charset zza;
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        zzmo.zza = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] arr_b = new byte[0];
        zzmo.zzb = arr_b;
        ByteBuffer.wrap(arr_b);
        zzlh zzlh0 = new zzlh(arr_b, 0, 0, false, null);
        try {
            zzlh0.zza(0);
        }
        catch(zzmq zzmq0) {
            throw new IllegalArgumentException(zzmq0);
        }
    }

    public static Object zza(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException("messageType");
        }
        return object0;
    }

    // 去混淆评级： 低(20)
    public static int zzb(boolean z) {
        return z ? 0x4CF : 0x4D5;
    }

    public static int zzc(int v, byte[] arr_b, int v1, int v2) {
        for(int v3 = 0; v3 < v2; ++v3) {
            v = v * 0x1F + arr_b[v3];
        }
        return v;
    }

    public static boolean zzd(zznl zznl0) {
        if(zznl0 instanceof zzks) {
            throw null;
        }
        return false;
    }
}

