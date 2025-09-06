package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Objects;

final class zzob implements Iterator {
    final zzod zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public zzob(zzod zzod0, byte[] arr_b) {
        Objects.requireNonNull(zzod0);
        this.zza = zzod0;
        super();
        this.zzb = -1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean hasNext() {
        return this.zzb + 1 < this.zza.zzj() || !this.zza.zzk().isEmpty() && this.zza().hasNext();
    }

    @Override
    public final Object next() {
        this.zzc = true;
        int v = this.zzb + 1;
        this.zzb = v;
        zzod zzod0 = this.zza;
        return v < zzod0.zzj() ? ((zzoa)zzod0.zzi()[v]) : this.zza().next();
    }

    @Override
    public final void remove() {
        if(!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzod zzod0 = this.zza;
        zzod0.zzh();
        int v = this.zzb;
        if(v < zzod0.zzj()) {
            this.zzb = v - 1;
            zzod0.zzg(v);
            return;
        }
        this.zza().remove();
    }

    private final Iterator zza() {
        if(this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }
}

