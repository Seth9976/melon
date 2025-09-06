package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzyp implements zzyv {
    private final zzyl zza;
    private final zzzh zzb;
    private final boolean zzc;
    private final zzwx zzd;

    private zzyp(zzzh zzzh0, zzwx zzwx0, zzyl zzyl0) {
        this.zzb = zzzh0;
        this.zzc = zzyl0 instanceof zzxg;
        this.zzd = zzwx0;
        this.zza = zzyl0;
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final int zza(Object object0) {
        int v = ((zzxi)object0).zzc.zzb();
        return this.zzc ? v + ((zzxg)object0).zzb.zzc() : v;
    }

    // 去混淆评级： 低(40)
    @Override  // com.google.android.gms.internal.cast.zzyv
    public final int zzb(Object object0) {
        return this.zzc ? ((zzxg)object0).zzb.zza.hashCode() + 0x19A02FB : 0x7BC6F;
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final Object zzc() {
        zzyl zzyl0 = this.zza;
        return zzyl0 instanceof zzxi ? ((zzxi)zzyl0).zzA() : zzyl0.zzN().zzt();
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final void zzd(Object object0) {
        this.zzb.zza(object0);
        this.zzd.zza(object0);
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final void zze(Object object0, Object object1) {
        zzyx.zzo(this.zzb, object0, object1);
        if(this.zzc) {
            zzyx.zzn(this.zzd, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final void zzf(Object object0, zzzt zzzt0) {
        Iterator iterator0 = ((zzxg)object0).zzb.zze();
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            Map.Entry map$Entry0 = (Map.Entry)object1;
            zzxa zzxa0 = (zzxa)map$Entry0.getKey();
            if(zzxa0.zzc() != zzzs.zzi || zzxa0.zze() || zzxa0.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if(map$Entry0 instanceof zzxs) {
                zzzt0.zzv(zzxa0.zza(), ((zzxs)map$Entry0).zza().zzb());
            }
            else {
                zzzt0.zzv(zzxa0.zza(), map$Entry0.getValue());
            }
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final boolean zzg(Object object0, Object object1) {
        if(!((zzxi)object0).zzc.equals(((zzxi)object1).zzc)) {
            return false;
        }
        return this.zzc ? ((zzxg)object0).zzb.equals(((zzxg)object1).zzb) : true;
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final boolean zzh(Object object0) {
        return ((zzxg)object0).zzb.zzh();
    }

    public static zzyp zzi(zzzh zzzh0, zzwx zzwx0, zzyl zzyl0) {
        return new zzyp(zzzh0, zzwx0, zzyl0);
    }
}

