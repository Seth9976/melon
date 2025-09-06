package com.google.android.gms.internal.measurement;

import b3.Z;

public final class zzne {
    private final zznd zza;

    private zzne(zzos zzos0, Object object0, zzos zzos1, Object object1) {
        this.zza = new zznd(zzos0, "", zzos1, "");
    }

    public static zzne zza(zzos zzos0, Object object0, zzos zzos1, Object object1) {
        return new zzne(zzos0, "", zzos1, "");
    }

    public static void zzb(zzll zzll0, zznd zznd0, Object object0, Object object1) {
        zzlv.zzf(zzll0, zznd0.zza, 1, object0);
        zzlv.zzf(zzll0, zznd0.zzc, 2, object1);
    }

    public static int zzc(zznd zznd0, Object object0, Object object1) {
        return zzlv.zzh(zznd0.zza, 1, object0) + zzlv.zzh(zznd0.zzc, 2, object1);
    }

    public final int zzd(int v, Object object0, Object object1) {
        int v1 = zzne.zzc(this.zza, object0, object1);
        return Z.B(v1, v1, zzll.zzz(v << 3));
    }

    public final zznd zze() {
        return this.zza;
    }
}

