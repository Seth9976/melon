package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

final class zzeu {
    private static final Iterator zza;
    private static final Iterable zzb;

    static {
        zzeu.zza = new zzes();
        zzeu.zzb = () -> zzeu.zza;
    }

    public static Iterable zza() {
        return zzeu.zzb;
    }

    // 检测为 Lambda 实现
    public static Iterator zzb() [...]
}

