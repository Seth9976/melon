package com.google.android.gms.internal.cast;

public final class zzul extends zzxi implements zzym {
    private static final zzul zzb;
    private int zzd;
    private int zze;
    private zzxn zzf;
    private zzxn zzg;
    private int zzh;

    static {
        zzul zzul0 = new zzul();
        zzul.zzb = zzul0;
        zzxi.zzJ(zzul.class, zzul0);
    }

    private zzul() {
        this.zzf = zzxi.zzD();
        this.zzg = zzxi.zzD();
    }

    public static zzul zza() {
        return zzul.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzul.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001B\u0003\u001B\u0004င\u0001", new Object[]{"zzd", "zze", zzor.zza(), "zzf", zzso.class, "zzg", zzso.class, "zzh"});
            }
            case 3: {
                return new zzul();
            }
            case 4: {
                return new zzuk(null);
            }
            case 5: {
                return zzul.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

