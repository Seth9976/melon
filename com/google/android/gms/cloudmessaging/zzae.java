package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

final class zzae extends zzf {
    final Rpc zza;

    public zzae(Rpc rpc0, Looper looper0) {
        this.zza = rpc0;
        super(looper0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        Rpc.zzc(this.zza, message0);
    }
}

