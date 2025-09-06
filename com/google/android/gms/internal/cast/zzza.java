package com.google.android.gms.internal.cast;

import java.util.Iterator;

final class zzza implements Iterator {
    final zzzd zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public zzza(zzzd zzzd0, zzzc zzzc0) {
        this.zza = zzzd0;
        super();
        this.zzb = -1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean hasNext() {
        return this.zzb + 1 < this.zza.zzb || !this.zza.zzc.isEmpty() && this.zza().hasNext();
    }

    @Override
    public final Object next() {
        this.zzc = true;
        int v = this.zzb + 1;
        this.zzb = v;
        zzzd zzzd0 = this.zza;
        return v < zzzd0.zzb ? ((zzyz)zzzd0.zza[v]) : this.zza().next();
    }

    @Override
    public final void remove() {
        if(!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzzd zzzd0 = this.zza;
        zzzd0.zzo();
        int v = this.zzb;
        if(v < zzzd0.zzb) {
            this.zzb = v - 1;
            zzzd0.zzm(v);
            return;
        }
        this.zza().remove();
    }

    private final Iterator zza() {
        if(this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }
}

