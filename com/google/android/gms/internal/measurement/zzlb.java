package com.google.android.gms.internal.measurement;

import com.iloen.melon.utils.a;

final class zzlb extends zzlf {
    private final int zzc;

    public zzlb(byte[] arr_b, int v, int v1) {
        super(arr_b);
        zzlg.zzj(0, v1, arr_b.length);
        this.zzc = v1;
    }

    @Override  // com.google.android.gms.internal.measurement.zzlf
    public final byte zza(int v) {
        int v1 = this.zzc;
        if((v1 - (v + 1) | v) < 0) {
            throw v >= 0 ? new ArrayIndexOutOfBoundsException("Index > length: " + v + ", " + v1) : new ArrayIndexOutOfBoundsException(a.k(v, "Index < 0: ", new StringBuilder(String.valueOf(v).length() + 11)));
        }
        return this.zza[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzlf
    public final byte zzb(int v) {
        return this.zza[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzlf
    public final int zzc() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.measurement.zzlf
    public final int zzd() {
        return 0;
    }
}

