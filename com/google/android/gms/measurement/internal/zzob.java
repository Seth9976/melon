package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzcn;

public final class zzob extends zzg {
    protected final zzoa zza;
    protected final zznz zzb;
    protected final zznx zzc;
    private Handler zzd;
    private boolean zze;

    public zzob(zzib zzib0) {
        super(zzib0);
        this.zze = true;
        this.zza = new zzoa(this);
        this.zzb = new zznz(this);
        this.zzc = new zznx(this);
    }

    @Override  // com.google.android.gms.measurement.internal.zzg
    public final boolean zze() {
        return false;
    }

    public final void zzh(boolean z) {
        this.zzg();
        this.zze = z;
    }

    public final boolean zzi() {
        this.zzg();
        return this.zze;
    }

    public final void zzj() {
        this.zzn();
    }

    public final void zzk(long v) {
        this.zzg();
        this.zzn();
        zzib zzib0 = this.zzu;
        zzib0.zzaV().zzk().zzb("Activity resumed, time", v);
        if(!zzib0.zzc().zzp(null, zzfx.zzaU)) {
            if(zzib0.zzc().zzv() || zzib0.zzd().zzn.zza()) {
                this.zzb.zza(v);
            }
        }
        else if(zzib0.zzc().zzv() || this.zze) {
            this.zzb.zza(v);
        }
        this.zzc.zza();
        zzoa zzoa0 = this.zza;
        zzob zzob0 = zzoa0.zza;
        zzob0.zzg();
        if(!zzob0.zzu.zzB()) {
            return;
        }
        zzoa0.zzb(zzob0.zzu.zzaZ().currentTimeMillis(), false);
    }

    public final void zzl(long v) {
        this.zzg();
        this.zzn();
        this.zzu.zzaV().zzk().zzb("Activity paused, time", v);
        this.zzc.zzb(v);
        if(this.zzu.zzc().zzv()) {
            this.zzb.zzb(v);
        }
    }

    public final Handler zzm() {
        return this.zzd;
    }

    private final void zzn() {
        this.zzg();
        if(this.zzd == null) {
            this.zzd = new zzcn(Looper.getMainLooper());
        }
    }
}

