package com.google.android.gms.internal.cast;

import U4.x;

final class zzvs extends zzux.zzf implements Runnable {
    private final Runnable zzd;

    public zzvs(Runnable runnable0) {
        runnable0.getClass();
        this.zzd = runnable0;
    }

    @Override
    public final void run() {
        try {
            this.zzd.run();
        }
        catch(Throwable throwable0) {
            this.zzg(throwable0);
            throw throwable0;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzux
    public final String zzb() {
        return x.k("task=[", this.zzd.toString(), "]");
    }
}

