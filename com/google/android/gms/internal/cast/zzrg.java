package com.google.android.gms.internal.cast;

public final class zzrg extends zzxi implements zzym {
    private static final zzrg zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private zzxn zzh;

    static {
        zzrg zzrg0 = new zzrg();
        zzrg.zzb = zzrg0;
        zzxi.zzJ(zzrg.class, zzrg0);
    }

    private zzrg() {
        this.zzh = zzxi.zzD();
    }

    public static zzrg zza() {
        return zzrg.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzrg.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004\u001B", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzrf.class});
            }
            case 3: {
                return new zzrg();
            }
            case 4: {
                return new zzrd(null);
            }
            case 5: {
                return zzrg.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

