package com.google.android.gms.internal.cast;

final class zzyd implements zzyw {
    private static final zzyj zza;
    private final zzyj zzb;

    static {
        zzyd.zza = new zzyb();
    }

    public zzyd() {
        zzyc zzyc0 = new zzyc(new zzyj[]{zzxe.zza(), zzyd.zza});
        super();
        this.zzb = zzyc0;
    }

    @Override  // com.google.android.gms.internal.cast.zzyw
    public final zzyv zza(Class class0) {
        zzyi zzyi0 = this.zzb.zzb(class0);
        if(!zzyi0.zzb()) {
            zzyq zzyq0 = zzyr.zza();
            zzxy zzxy0 = zzxz.zza();
            zzzh zzzh0 = zzyx.zzm();
            return zzyi0.zzc() - 1 == 1 ? zzyo.zzi(class0, zzyi0, zzyq0, zzxy0, zzzh0, null, zzyh.zza()) : zzyo.zzi(class0, zzyi0, zzyq0, zzxy0, zzzh0, zzwz.zza(), zzyh.zza());
        }
        return zzyp.zzi(zzyx.zzm(), zzwz.zza(), zzyi0.zza());
    }
}

