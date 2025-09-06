package com.google.android.gms.internal.cast;

public final class zzpj extends zzxi implements zzym {
    private static final zzpj zzb;
    private int zzd;
    private zzpp zze;
    private zzsc zzf;
    private zzxn zzg;
    private zzxl zzh;

    static {
        zzpj zzpj0 = new zzpj();
        zzpj.zzb = zzpj0;
        zzxi.zzJ(zzpj.class, zzpj0);
    }

    private zzpj() {
        this.zzg = zzxi.zzD();
        this.zzh = zzxi.zzB();
    }

    public static zzpi zza() {
        return (zzpi)zzpj.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzpj.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001B\u0004ࠞ", new Object[]{"zzd", "zze", "zzf", "zzg", zzrw.class, "zzh", zzpb.zzb()});
            }
            case 3: {
                return new zzpj();
            }
            case 4: {
                return new zzpi(null);
            }
            case 5: {
                return zzpj.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzpj zzc() {
        return zzpj.zzb;
    }

    public static void zzd(zzpj zzpj0, Iterable iterable0) {
        zzxl zzxl0 = zzpj0.zzh;
        if(!zzxl0.zzc()) {
            int v = zzxl0.size();
            zzpj0.zzh = zzxl0.zzg(v + v);
        }
        for(Object object0: iterable0) {
            zzpj0.zzh.zzh(((zzpb)object0).zza());
        }
    }

    public static void zze(zzpj zzpj0, zzpp zzpp0) {
        zzpp0.getClass();
        zzpj0.zze = zzpp0;
        zzpj0.zzd |= 1;
    }
}

