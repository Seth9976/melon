package com.google.android.gms.cloudmessaging;

public final class zzl implements Runnable {
    public final zzp zza;

    public zzl(zzp zzp0) {
        this.zza = zzp0;
    }

    @Override
    public final void run() {
        this.zza.zza(2, "Service disconnected");
    }
}

