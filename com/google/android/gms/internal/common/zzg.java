package com.google.android.gms.internal.common;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;

public class zzg extends Handler {
    private final Looper zza;

    public zzg() {
        this.zza = Looper.getMainLooper();
    }

    public zzg(Looper looper0) {
        super(looper0);
        this.zza = Looper.getMainLooper();
    }

    public zzg(Looper looper0, Handler.Callback handler$Callback0) {
        super(looper0, handler$Callback0);
        this.zza = Looper.getMainLooper();
    }
}

