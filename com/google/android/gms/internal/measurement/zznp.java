package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class zznp implements zznw {
    private final zznl zza;
    private final zzoh zzb;
    private final boolean zzc;
    private final zzlr zzd;

    private zznp(zzoh zzoh0, zzlr zzlr0, zznl zznl0) {
        this.zzb = zzoh0;
        this.zzc = zznl0 instanceof zzmb;
        this.zzd = zzlr0;
        this.zza = zznl0;
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final Object zza() {
        zznl zznl0 = this.zza;
        return zznl0 instanceof zzme ? ((zzme)zznl0).zzch() : zznl0.zzcC().zzbf();
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final boolean zzb(Object object0, Object object1) {
        if(!((zzme)object0).zzc.equals(((zzme)object1).zzc)) {
            return false;
        }
        return this.zzc ? ((zzmb)object0).zzb.equals(((zzmb)object1).zzb) : true;
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final int zzc(Object object0) {
        int v = ((zzme)object0).zzc.hashCode();
        return this.zzc ? v * 53 + ((zzmb)object0).zzb.zza.hashCode() : v;
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final void zzd(Object object0, Object object1) {
        zzny.zzD(this.zzb, object0, object1);
        if(this.zzc) {
            zzny.zzC(this.zzd, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final int zze(Object object0) {
        int v = ((zzme)object0).zzc.zzh();
        return this.zzc ? v + ((zzmb)object0).zzb.zzg() : v;
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final void zzf(Object object0, zzou zzou0) {
        Iterator iterator0 = ((zzmb)object0).zzb.zzc();
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            Map.Entry map$Entry0 = (Map.Entry)object1;
            zzlu zzlu0 = (zzlu)map$Entry0.getKey();
            if(zzlu0.zzc() != zzot.zzi || zzlu0.zzd() || zzlu0.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if(map$Entry0 instanceof zzms) {
                zzou0.zzv(zzlu0.zza(), ((zzms)map$Entry0).zza().zzc());
            }
            else {
                zzou0.zzv(zzlu0.zza(), map$Entry0.getValue());
            }
        }
        ((zzme)object0).zzc.zzf(zzou0);
    }

    public static zznp zzg(zzoh zzoh0, zzlr zzlr0, zznl zznl0) {
        return new zznp(zzoh0, zzlr0, zznl0);
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final void zzi(Object object0, byte[] arr_b, int v, int v1, zzkv zzkv0) {
        if(((zzme)object0).zzc == zzoi.zza()) {
            ((zzme)object0).zzc = zzoi.zzb();
        }
        zzmb zzmb0 = (zzmb)object0;
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final void zzj(Object object0) {
        this.zzb.zzb(object0);
        this.zzd.zza(object0);
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final boolean zzk(Object object0) {
        return ((zzmb)object0).zzb.zze();
    }
}

