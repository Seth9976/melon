package com.google.android.gms.internal.play_billing;

final class zzfh extends zzff {
    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final int zza(Object object0) {
        return ((zzfg)object0).zza();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final int zzb(Object object0) {
        return ((zzfg)object0).zzb();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final Object zzc(Object object0) {
        zzfg zzfg0 = ((zzcs)object0).zzc;
        if(zzfg0 == zzfg.zzc()) {
            zzfg0 = zzfg.zzf();
            ((zzcs)object0).zzc = zzfg0;
        }
        return zzfg0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final Object zzd(Object object0) {
        return ((zzcs)object0).zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final Object zze(Object object0, Object object1) {
        if(!zzfg.zzc().equals(object1)) {
            if(zzfg.zzc().equals(object0)) {
                return zzfg.zze(((zzfg)object0), ((zzfg)object1));
            }
            ((zzfg)object0).zzd(((zzfg)object1));
        }
        return object0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final void zzf(Object object0, int v, long v1) {
        ((zzfg)object0).zzj(v << 3, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final void zzg(Object object0) {
        ((zzcs)object0).zzc.zzh();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final void zzh(Object object0, Object object1) {
        ((zzcs)object0).zzc = (zzfg)object1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final void zzi(Object object0, zzfx zzfx0) {
        ((zzfg)object0).zzk(zzfx0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzff
    public final void zzj(Object object0, zzfx zzfx0) {
        ((zzfg)object0).zzl(zzfx0);
    }
}

