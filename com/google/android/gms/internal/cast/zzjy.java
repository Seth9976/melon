package com.google.android.gms.internal.cast;

import java.util.Collections;
import java.util.Comparator;

public final class zzjy {
    private static final Comparator zza;
    private static final zzjy zzb;
    private final zzjw zzc;

    static {
        zzjy.zza = new zzjr();
        zzjy.zzb = new zzjy(new zzjw(Collections.EMPTY_LIST));
    }

    private zzjy(zzjw zzjw0) {
        this.zzc = zzjw0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzjy && ((zzjy)object0).zzc.equals(this.zzc);
    }

    @Override
    public final int hashCode() {
        return ~this.zzc.hashCode();
    }

    @Override
    public final String toString() {
        return this.zzc.toString();
    }

    public static zzjy zza() {
        return zzjy.zzb;
    }

    public static Comparator zzb() {
        return zzjy.zza;
    }
}

