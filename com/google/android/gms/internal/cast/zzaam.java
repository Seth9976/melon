package com.google.android.gms.internal.cast;

public final class zzaam extends zzxi implements zzym {
    private static final zzaam zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private int zzg;

    static {
        zzaam zzaam0 = new zzaam();
        zzaam.zzb = zzaam0;
        zzxi.zzJ(zzaam.class, zzaam0);
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzaam.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
            }
            case 3: {
                return new zzaam();
            }
            case 4: {
                return new zzaak(null);
            }
            case 5: {
                return zzaam.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzaam zzc() {
        return zzaam.zzb;
    }
}

