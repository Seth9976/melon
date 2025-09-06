package com.google.android.gms.internal.cast;

public final class zzsi extends zzxi implements zzym {
    private static final zzsi zzb;
    private int zzd;
    private long zze;
    private zzxm zzf;
    private zzxm zzg;

    static {
        zzsi zzsi0 = new zzsi();
        zzsi.zzb = zzsi0;
        zzxi.zzJ(zzsi.class, zzsi0);
    }

    private zzsi() {
        this.zzf = zzxi.zzC();
        this.zzg = zzxi.zzC();
    }

    public static zzsi zza() {
        return zzsi.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzsi.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001စ\u0000\u0002\u0017\u0003\u0017", new Object[]{"zzd", "zze", "zzf", "zzg"});
            }
            case 3: {
                return new zzsi();
            }
            case 4: {
                return new zzsh(null);
            }
            case 5: {
                return zzsi.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

