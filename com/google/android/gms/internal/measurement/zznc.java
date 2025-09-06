package com.google.android.gms.internal.measurement;

final class zznc implements zznx {
    private final zznj zza;
    private static final zznj zzb;

    static {
        zznc.zzb = new zzna();
    }

    public zznc() {
        zznb zznb0 = new zznb(new zznj[]{zzlz.zza(), zznc.zzb});
        super();
        this.zza = zznb0;
    }

    @Override  // com.google.android.gms.internal.measurement.zznx
    public final zznw zza(Class class0) {
        zzni zzni0 = this.zza.zzc(class0);
        if(!zzni0.zza()) {
            zznq zznq0 = zznr.zza();
            zzmx zzmx0 = zzmy.zza();
            zzoh zzoh0 = zzny.zzA();
            return zzni0.zzc() - 1 == 1 ? zzno.zzl(class0, zzni0, zznq0, zzmx0, zzoh0, null, zznh.zza()) : zzno.zzl(class0, zzni0, zznq0, zzmx0, zzoh0, zzlt.zza(), zznh.zza());
        }
        return zznp.zzg(zzny.zzA(), zzlt.zza(), zzni0.zzb());
    }
}

