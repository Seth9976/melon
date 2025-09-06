package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzex implements Iterator {
    final zzfb zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public zzex(zzfb zzfb0, zzew zzew0) {
        this.zza = zzfb0;
        super();
        this.zzb = -1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean hasNext() {
        return this.zzb + 1 < this.zza.zzb.size() || !this.zza.zzc.isEmpty() && this.zza().hasNext();
    }

    @Override
    public final Object next() {
        this.zzc = true;
        int v = this.zzb + 1;
        this.zzb = v;
        return v < this.zza.zzb.size() ? ((Map.Entry)this.zza.zzb.get(this.zzb)) : this.zza().next();
    }

    @Override
    public final void remove() {
        if(!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzn();
        if(this.zzb < this.zza.zzb.size()) {
            int v = this.zzb;
            this.zzb = v - 1;
            this.zza.zzl(v);
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

