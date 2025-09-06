package com.google.android.gms.internal.cast;

public final class zzub extends zzxi implements zzym {
    private static final zzub zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        zzub zzub0 = new zzub();
        zzub.zzb = zzub0;
        zzxi.zzJ(zzub.class, zzub0);
    }

    public static zzub zza() {
        return zzub.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzub.zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            }
            case 3: {
                return new zzub();
            }
            case 4: {
                return new zzua(null);
            }
            case 5: {
                return zzub.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

