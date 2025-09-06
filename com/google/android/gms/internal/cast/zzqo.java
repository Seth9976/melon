package com.google.android.gms.internal.cast;

public final class zzqo extends zzxi implements zzym {
    private static final zzqo zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzqo zzqo0 = new zzqo();
        zzqo.zzb = zzqo0;
        zzxi.zzJ(zzqo.class, zzqo0);
    }

    public static zzqn zza() {
        return (zzqn)zzqo.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqo.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", zzoj.zza(), "zzf", "zzg", "zzh"});
            }
            case 3: {
                return new zzqo();
            }
            case 4: {
                return new zzqn(null);
            }
            case 5: {
                return zzqo.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzqo zzc() {
        return zzqo.zzb;
    }

    public static void zzd(zzqo zzqo0, int v) {
        zzqo0.zzd |= 2;
        zzqo0.zzf = v;
    }

    public static void zze(zzqo zzqo0, int v) {
        zzqo0.zzd |= 4;
        zzqo0.zzg = v;
    }

    public static void zzf(zzqo zzqo0, int v) {
        zzqo0.zzd |= 8;
        zzqo0.zzh = v;
    }

    public static void zzg(zzqo zzqo0, int v) {
        zzqo0.zze = v - 1;
        zzqo0.zzd |= 1;
    }
}

