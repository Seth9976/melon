package com.google.android.gms.internal.cast;

public final class zztr extends zzxi implements zzym {
    private static final zztr zzb;
    private int zzd;
    private String zze;
    private zzxn zzf;
    private zzxn zzg;
    private boolean zzh;

    static {
        zztr zztr0 = new zztr();
        zztr.zzb = zztr0;
        zzxi.zzJ(zztr.class, zztr0);
    }

    private zztr() {
        this.zze = "";
        this.zzf = zzxi.zzD();
        this.zzg = zzxi.zzD();
    }

    public static zztr zza() {
        return zztr.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztr.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001B\u0003\u001B\u0004ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzrq.class, "zzg", zzrc.class, "zzh"});
            }
            case 3: {
                return new zztr();
            }
            case 4: {
                return new zztq(null);
            }
            case 5: {
                return zztr.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

