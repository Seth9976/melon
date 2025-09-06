package com.google.android.gms.measurement.internal;

abstract class zzg extends zzf {
    private boolean zza;

    public zzg(zzib zzib0) {
        super(zzib0);
        this.zzu.zzF();
    }

    public final boolean zza() {
        return this.zza;
    }

    public final void zzb() {
        if(!this.zza()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzc() {
        if(this.zza) {
            throw new IllegalStateException("Can\'t initialize twice");
        }
        if(!this.zze()) {
            this.zzu.zzG();
            this.zza = true;
        }
    }

    public final void zzd() {
        if(this.zza) {
            throw new IllegalStateException("Can\'t initialize twice");
        }
        this.zzf();
        this.zzu.zzG();
        this.zza = true;
    }

    public abstract boolean zze();

    public void zzf() {
    }
}

