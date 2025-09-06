package com.google.android.gms.measurement.internal;

public final class zzfw {
    private final String zza;
    private final zzbn zzb;
    private final Object zzc;
    private final Object zzd;
    private static final Object zze;
    private volatile Object zzf;
    private volatile Object zzg;

    static {
        zzfw.zze = new Object();
    }

    public zzfw(String s, Object object0, Object object1, zzbn zzbn0, byte[] arr_b) {
        this.zzd = new Object();
        this.zzf = null;
        this.zzg = null;
        this.zza = s;
        this.zzc = object0;
        this.zzb = zzbn0;
    }

    public final String zza() {
        return this.zza;
    }

    public final Object zzb(Object object0) {
        Object object4;
        synchronized(this.zzd) {
        }
        if(object0 != null) {
            return object0;
        }
        if(zzfr.zza == null) {
            return this.zzc;
        }
        synchronized(zzfw.zze) {
            if(zzae.zza()) {
                return this.zzg == null ? this.zzc : this.zzg;
            }
        }
        try {
            for(Object object3: zzfx.zzbk) {
                zzfw zzfw0 = (zzfw)object3;
                if(zzae.zza()) {
                    throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                }
                try {
                    object4 = null;
                    zzbn zzbn0 = zzfw0.zzb;
                    if(zzbn0 != null) {
                        object4 = zzbn0.zza();
                    }
                }
                catch(IllegalStateException unused_ex) {
                }
                synchronized(zzfw.zze) {
                    zzfw0.zzg = object4;
                }
            }
        }
        catch(SecurityException unused_ex) {
        }
        zzbn zzbn1 = this.zzb;
        if(zzbn1 != null) {
            try {
                return zzbn1.zza();
            }
            catch(SecurityException | IllegalStateException unused_ex) {
            }
        }
        return this.zzc;
    }
}

