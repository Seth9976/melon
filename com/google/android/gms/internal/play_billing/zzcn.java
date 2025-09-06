package com.google.android.gms.internal.play_billing;

public class zzcn extends zzax {
    protected zzcs zza;
    private final zzcs zzb;

    public zzcn(zzcs zzcs0) {
        this.zzb = zzcs0;
        if(zzcs0.zzw()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = zzcs0.zzl();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzax
    public final Object clone() {
        return this.zzb();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzax
    public final zzax zza() {
        return this.zzb();
    }

    public final zzcn zzb() {
        zzcn zzcn0 = (zzcn)this.zzb.zzx(5, null, null);
        zzcn0.zza = this.zze();
        return zzcn0;
    }

    public final zzcn zzc(zzcs zzcs0) {
        if(!this.zzb.equals(zzcs0)) {
            if(!this.zza.zzw()) {
                this.zzj();
            }
            zzcn.zzl(this.zza, zzcs0);
        }
        return this;
    }

    public final zzcs zzd() {
        zzcs zzcs0 = this.zze();
        if(!zzcs0.zzk()) {
            throw new zzfe(zzcs0);
        }
        return zzcs0;
    }

    public zzcs zze() {
        if(!this.zza.zzw()) {
            return this.zza;
        }
        this.zza.zzr();
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeb
    public zzec zzf() {
        return this.zzd();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeb
    public zzec zzg() {
        return this.zze();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzed
    public final zzec zzh() {
        throw null;
    }

    public final void zzi() {
        if(!this.zza.zzw()) {
            this.zzj();
        }
    }

    public void zzj() {
        zzcs zzcs0 = this.zzb.zzl();
        zzcn.zzl(zzcs0, this.zza);
        this.zza = zzcs0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzed
    public final boolean zzk() {
        return zzcs.zzv(this.zza, false);
    }

    private static void zzl(Object object0, Object object1) {
        zzel.zza().zzb(object0.getClass()).zzg(object0, object1);
    }
}

