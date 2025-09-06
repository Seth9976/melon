package com.google.android.gms.measurement.internal;

abstract class zzor extends zzok {
    private boolean zza;

    public zzor(zzpf zzpf0) {
        super(zzpf0);
        this.zzg.zzad();
    }

    public final boolean zzax() {
        return this.zza;
    }

    public final void zzay() {
        if(!this.zzax()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzaz() {
        if(this.zza) {
            throw new IllegalStateException("Can\'t initialize twice");
        }
        this.zzbb();
        this.zzg.zzae();
        this.zza = true;
    }

    public abstract boolean zzbb();
}

