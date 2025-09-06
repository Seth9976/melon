package com.google.android.gms.internal.cast;

import U4.x;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

final class zzvx extends zzve implements RunnableFuture {
    private volatile zzvn zzd;

    public zzvx(Callable callable0) {
        this.zzd = new zzvw(this, callable0);
    }

    @Override
    public final void run() {
        zzvn zzvn0 = this.zzd;
        if(zzvn0 != null) {
            zzvn0.run();
        }
        this.zzd = null;
    }

    @Override  // com.google.android.gms.internal.cast.zzux
    public final String zzb() {
        zzvn zzvn0 = this.zzd;
        return zzvn0 == null ? super.zzb() : x.k("task=[", zzvn0.toString(), "]");
    }

    @Override  // com.google.android.gms.internal.cast.zzux
    public final void zzd() {
        if(this.valueField instanceof zzux.zza && ((zzux.zza)this.valueField).zzc) {
            zzvn zzvn0 = this.zzd;
            if(zzvn0 != null) {
                zzvn0.zze();
            }
        }
        this.zzd = null;
    }

    public static zzvx zzo(Runnable runnable0, Object object0) {
        return new zzvx(Executors.callable(runnable0, object0));
    }
}

