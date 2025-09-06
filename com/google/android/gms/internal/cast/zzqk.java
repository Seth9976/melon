package com.google.android.gms.internal.cast;

public final class zzqk extends zzxi implements zzym {
    private static final zzqk zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;

    static {
        zzqk zzqk0 = new zzqk();
        zzqk.zzb = zzqk0;
        zzxi.zzJ(zzqk.class, zzqk0);
    }

    public static zzqj zza() {
        return (zzqj)zzqk.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqk.zzb, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003\u0006ဂ\u0004", new Object[]{"zzd", "zze", zzoh.zza(), "zzf", "zzg", "zzh", "zzi"});
            }
            case 3: {
                return new zzqk();
            }
            case 4: {
                return new zzqj(null);
            }
            case 5: {
                return zzqk.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzqk zzc() {
        return zzqk.zzb;
    }

    public static void zzd(zzqk zzqk0, boolean z) {
        zzqk0.zzd |= 8;
        zzqk0.zzh = z;
    }

    public static void zze(zzqk zzqk0, int v) {
        zzqk0.zzd |= 4;
        zzqk0.zzg = v;
    }

    public static void zzf(zzqk zzqk0, long v) {
        zzqk0.zzd |= 16;
        zzqk0.zzi = v;
    }

    public static void zzg(zzqk zzqk0, int v) {
        zzqk0.zzd |= 2;
        zzqk0.zzf = v;
    }

    public static void zzh(zzqk zzqk0, int v) {
        zzqk0.zze = v - 1;
        zzqk0.zzd |= 1;
    }
}

