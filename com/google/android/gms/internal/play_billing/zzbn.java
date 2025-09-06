package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import k8.Y;

class zzbn extends zzbm {
    protected final byte[] zza;

    public zzbn(byte[] arr_b) {
        super(null);
        arr_b.getClass();
        this.zza = arr_b;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbq
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof zzbq)) {
            return false;
        }
        if(this.zzd() != ((zzbq)object0).zzd()) {
            return false;
        }
        if(this.zzd() == 0) {
            return true;
        }
        if(object0 instanceof zzbn) {
            int v = this.zzk();
            int v1 = ((zzbn)object0).zzk();
            if(v != 0 && v1 != 0 && v != v1) {
                return false;
            }
            int v2 = this.zzd();
            if(v2 > ((zzbn)object0).zzd()) {
                throw new IllegalArgumentException("Length too large: " + v2 + this.zzd());
            }
            if(v2 > ((zzbn)object0).zzd()) {
                throw new IllegalArgumentException(Y.h(v2, ((zzbn)object0).zzd(), "Ran off end of other: 0, ", ", "));
            }
            byte[] arr_b = this.zza;
            byte[] arr_b1 = ((zzbn)object0).zza;
            ((zzbn)object0).zzc();
            int v3 = 0;
            for(int v4 = 0; v3 < v2; ++v4) {
                if(arr_b[v3] != arr_b1[v4]) {
                    return false;
                }
                ++v3;
            }
            return true;
        }
        return object0.equals(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbq
    public byte zza(int v) {
        return this.zza[v];
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbq
    public byte zzb(int v) {
        return this.zza[v];
    }

    public int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbq
    public int zzd() {
        return this.zza.length;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbq
    public final int zze(int v, int v1, int v2) {
        return zzda.zzb(v, this.zza, 0, v2);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbq
    public final zzbq zzf(int v, int v1) {
        int v2 = zzbq.zzj(0, v1, this.zzd());
        return v2 == 0 ? zzbq.zzb : new zzbj(this.zza, 0, v2);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbq
    public final String zzg(Charset charset0) {
        int v = this.zzd();
        return new String(this.zza, 0, v, charset0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbq
    public final void zzh(zzbf zzbf0) {
        int v = this.zzd();
        ((zzbv)zzbf0).zzc(this.zza, 0, v);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzi() {
        int v = this.zzd();
        return zzfu.zze(this.zza, 0, v);
    }
}

