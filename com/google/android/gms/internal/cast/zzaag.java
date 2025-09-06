package com.google.android.gms.internal.cast;

public final class zzaag extends zzxi implements zzym {
    private static final zzaag zzb;
    private zzxn zzd;
    private zzxn zze;
    private zzxn zzf;
    private zzxn zzg;

    static {
        zzaag zzaag0 = new zzaag();
        zzaag.zzb = zzaag0;
        zzxi.zzJ(zzaag.class, zzaag0);
    }

    private zzaag() {
        this.zzd = zzxi.zzD();
        this.zze = zzxi.zzD();
        this.zzf = zzxi.zzD();
        this.zzg = zzxi.zzD();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzaag.zzb, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u001B\u0002\u001B\u0003\u001B\u0004\u001B", new Object[]{"zzd", zzaad.class, "zze", zzzy.class, "zzf", zzaad.class, "zzg", zzzy.class});
            }
            case 3: {
                return new zzaag();
            }
            case 4: {
                return new zzaae(null);
            }
            case 5: {
                return zzaag.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzaag zzc() {
        return zzaag.zzb;
    }
}

