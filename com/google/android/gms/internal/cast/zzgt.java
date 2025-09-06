package com.google.android.gms.internal.cast;

final class zzgt implements zzgr {
    private static final zzgr zza;
    private final zzgv zzb;
    private volatile zzgr zzc;
    private Object zzd;

    static {
        zzgt.zza = new zzgs();
    }

    public zzgt(zzgr zzgr0) {
        this.zzb = new zzgv();
        this.zzc = zzgr0;
    }

    @Override
    public final String toString() {
        zzgr zzgr0 = this.zzc;
        if(zzgr0 == zzgt.zza) {
            zzgr0 = "<supplier that returned " + this.zzd + ">";
        }
        return "Suppliers.memoize(" + zzgr0 + ")";
    }

    @Override  // com.google.android.gms.internal.cast.zzgr
    public final Object zza() {
        zzgr zzgr0 = zzgt.zza;
        if(this.zzc != zzgr0) {
            synchronized(this.zzb) {
                if(this.zzc != zzgr0) {
                    Object object0 = this.zzc.zza();
                    this.zzd = object0;
                    this.zzc = zzgr0;
                    return object0;
                }
            }
        }
        return this.zzd;
    }
}

