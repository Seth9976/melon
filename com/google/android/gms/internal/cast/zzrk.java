package com.google.android.gms.internal.cast;

public final class zzrk extends zzxi implements zzym {
    private static final zzrk zzb;
    private int zzd;
    private String zze;
    private boolean zzf;
    private boolean zzg;
    private zzur zzh;
    private boolean zzi;
    private zzxl zzj;
    private long zzk;
    private long zzl;

    static {
        zzrk zzrk0 = new zzrk();
        zzrk.zzb = zzrk0;
        zzxi.zzJ(zzrk.class, zzrk0);
    }

    private zzrk() {
        this.zze = "";
        this.zzj = zzxi.zzB();
    }

    public static zzrk zza() {
        return zzrk.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzrk.zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဉ\u0003\u0004ဇ\u0004\u0005ࠬ\u0006ဇ\u0002\u0007ဂ\u0005\bဂ\u0006", new Object[]{"zzd", "zze", "zzf", "zzh", "zzi", "zzj", zzox.zza(), "zzg", "zzk", "zzl"});
            }
            case 3: {
                return new zzrk();
            }
            case 4: {
                return new zzrj(null);
            }
            case 5: {
                return zzrk.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

