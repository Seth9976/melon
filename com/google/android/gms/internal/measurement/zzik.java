package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzik extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private zzmm zze;
    private static final zzik zzf;

    static {
        zzik zzik0 = new zzik();
        zzik.zzf = zzik0;
        zzme.zzcp(zzik.class, zzik0);
    }

    private zzik() {
        this.zze = zzme.zzct();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final long zze(int v) {
        return this.zze.zzc(v);
    }

    public static zzij zzf() {
        return (zzij)zzik.zzf.zzck();
    }

    public final void zzg(int v) {
        this.zzb |= 1;
        this.zzd = v;
    }

    public final void zzh(Iterable iterable0) {
        zzmm zzmm0 = this.zze;
        if(!zzmm0.zza()) {
            this.zze = zzme.zzcu(zzmm0);
        }
        zzkr.zzce(iterable0, this.zze);
    }

    public static zzik zzi() {
        return zzik.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzik.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
            }
            case 3: {
                return new zzik();
            }
            case 4: {
                return new zzij(null);
            }
            case 5: {
                return zzik.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

