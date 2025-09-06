package com.google.android.gms.internal.cast;

public final class zzud extends zzxi implements zzym {
    private static final zzud zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private zzxn zzg;
    private zzxn zzh;
    private zzxn zzi;

    static {
        zzud zzud0 = new zzud();
        zzud.zzb = zzud0;
        zzxi.zzJ(zzud.class, zzud0);
    }

    private zzud() {
        this.zzg = zzxi.zzD();
        this.zzh = zzxi.zzD();
        this.zzi = zzxi.zzD();
    }

    public static zzud zza() {
        return zzud.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzud.zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003\u001B\u0004\u001B\u0005\u001B", new Object[]{"zzd", "zze", zznx.zza(), "zzf", "zzg", zztv.class, "zzh", zzqg.class, "zzi", zzub.class});
            }
            case 3: {
                return new zzud();
            }
            case 4: {
                return new zzuc(null);
            }
            case 5: {
                return zzud.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

