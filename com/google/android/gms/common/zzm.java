package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzm extends zzj {
    private WeakReference zza;
    private static final WeakReference zzb;

    static {
        zzm.zzb = new WeakReference(null);
    }

    public zzm(byte[] arr_b) {
        super(arr_b);
        this.zza = zzm.zzb;
    }

    public abstract byte[] zzb();

    @Override  // com.google.android.gms.common.zzj
    public final byte[] zzc() {
        synchronized(this) {
            byte[] arr_b = (byte[])this.zza.get();
            if(arr_b == null) {
                arr_b = this.zzb();
                this.zza = new WeakReference(arr_b);
            }
            return arr_b;
        }
    }
}

