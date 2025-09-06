package com.google.android.gms.internal.cast;

public final class zzsa extends zzxi implements zzym {
    private static final zzsa zzb;
    private int zzd;
    private String zze;
    private String zzf;
    private boolean zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    static {
        zzsa zzsa0 = new zzsa();
        zzsa.zzb = zzsa0;
        zzxi.zzJ(zzsa.class, zzsa0);
    }

    private zzsa() {
        this.zze = "";
        this.zzf = "";
    }

    public static zzsa zza() {
        return zzsa.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzsa.zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzmp.zza(), "zzi", zzmt.zza(), "zzj", zzmr.zza(), "zzk", zzmv.zza()});
            }
            case 3: {
                return new zzsa();
            }
            case 4: {
                return new zzrz(null);
            }
            case 5: {
                return zzsa.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

