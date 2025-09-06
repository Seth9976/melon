package com.google.android.gms.internal.cast;

import java.io.Closeable;

public final class zzkc implements Closeable {
    private static final ThreadLocal zza;
    private int zzb;

    static {
        zzkc.zza = new zzkb();
    }

    public zzkc() {
        this.zzb = 0;
    }

    @Override
    public final void close() {
        int v = this.zzb;
        if(v <= 0) {
            throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
        }
        this.zzb = v - 1;
    }

    public static int zza() {
        return ((zzkc)zzkc.zza.get()).zzb;
    }
}

