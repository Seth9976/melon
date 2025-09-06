package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzx extends zzy {
    private final Callable zze;

    public zzx(Callable callable0, byte[] arr_b) {
        super(false, 1, 5, null, null, -1L, null);
        this.zze = callable0;
    }

    @Override  // com.google.android.gms.common.zzy
    public final String zza() {
        try {
            return (String)this.zze.call();
        }
        catch(Exception exception0) {
            throw new RuntimeException(exception0);
        }
    }
}

