package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzeg implements zzeo {
    private final zzec zza;
    private final zzff zzb;
    private final boolean zzc;
    private final zzce zzd;

    private zzeg(zzff zzff0, zzce zzce0, zzec zzec0) {
        this.zzb = zzff0;
        this.zzc = zzce0.zzf(zzec0);
        this.zzd = zzce0;
        this.zza = zzec0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final int zza(Object object0) {
        Object object1 = this.zzb.zzd(object0);
        int v = this.zzb.zzb(object1);
        return this.zzc ? v + this.zzd.zzb(object0).zzc() : v;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final int zzb(Object object0) {
        int v = this.zzb.zzd(object0).hashCode();
        return this.zzc ? v * 53 + this.zzd.zzb(object0).zza.hashCode() : v;
    }

    public static zzeg zzc(zzff zzff0, zzce zzce0, zzec zzec0) {
        return new zzeg(zzff0, zzce0, zzec0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final Object zze() {
        zzec zzec0 = this.zza;
        return zzec0 instanceof zzcs ? ((zzcs)zzec0).zzl() : zzec0.zzE().zzg();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final void zzf(Object object0) {
        this.zzb.zzg(object0);
        this.zzd.zzd(object0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final void zzg(Object object0, Object object1) {
        zzeq.zzq(this.zzb, object0, object1);
        if(this.zzc) {
            zzeq.zzp(this.zzd, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final void zzh(Object object0, byte[] arr_b, int v, int v1, zzbc zzbc0) {
        if(((zzcs)object0).zzc == zzfg.zzc()) {
            ((zzcs)object0).zzc = zzfg.zzf();
        }
        zzco zzco0 = (zzco)object0;
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final void zzi(Object object0, zzfx zzfx0) {
        Iterator iterator0 = this.zzd.zzb(object0).zzf();
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            Map.Entry map$Entry0 = (Map.Entry)object1;
            zzch zzch0 = (zzch)map$Entry0.getKey();
            if(zzch0.zze() != zzfw.zzi || zzch0.zzg() || zzch0.zzf()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if(map$Entry0 instanceof zzdf) {
                zzfx0.zzw(zzch0.zza(), ((zzdf)map$Entry0).zza().zzb());
            }
            else {
                zzfx0.zzw(zzch0.zza(), map$Entry0.getValue());
            }
        }
        Object object2 = this.zzb.zzd(object0);
        this.zzb.zzi(object2, zzfx0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzj(Object object0, Object object1) {
        if(!this.zzb.zzd(object0).equals(this.zzb.zzd(object1))) {
            return false;
        }
        return this.zzc ? this.zzd.zzb(object0).equals(this.zzd.zzb(object1)) : true;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzk(Object object0) {
        return this.zzd.zzb(object0).zzj();
    }
}

