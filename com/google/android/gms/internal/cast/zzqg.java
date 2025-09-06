package com.google.android.gms.internal.cast;

public final class zzqg extends zzxi implements zzym {
    private static final zzqg zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzqg zzqg0 = new zzqg();
        zzqg.zzb = zzqg0;
        zzxi.zzJ(zzqg.class, zzqg0);
    }

    public static zzqf zza() {
        return (zzqf)zzqg.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqg.zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzd", "zze", zzod.zza(), "zzf", "zzg", "zzh", "zzi"});
            }
            case 3: {
                return new zzqg();
            }
            case 4: {
                return new zzqf(null);
            }
            case 5: {
                return zzqg.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzqg zzc() {
        return zzqg.zzb;
    }

    public static void zzd(zzqg zzqg0, int v) {
        zzqg0.zzd |= 16;
        zzqg0.zzi = v;
    }

    public static void zze(zzqg zzqg0, int v) {
        zzqg0.zzd |= 2;
        zzqg0.zzf = v;
    }

    public static void zzf(zzqg zzqg0, int v) {
        zzqg0.zzd |= 8;
        zzqg0.zzh = v;
    }

    public static void zzg(zzqg zzqg0, int v) {
        zzqg0.zzd |= 4;
        zzqg0.zzg = v;
    }

    public static void zzh(zzqg zzqg0, int v) {
        zzqg0.zze = v - 1;
        zzqg0.zzd |= 1;
    }
}

