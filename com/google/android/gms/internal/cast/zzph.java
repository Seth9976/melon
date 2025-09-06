package com.google.android.gms.internal.cast;

public final class zzph extends zzxi implements zzym {
    private static final zzph zzb;
    private int zzd;
    private String zze;
    private String zzf;
    private zzxl zzg;

    static {
        zzph zzph0 = new zzph();
        zzph.zzb = zzph0;
        zzxi.zzJ(zzph.class, zzph0);
    }

    private zzph() {
        this.zze = "";
        this.zzf = "";
        this.zzg = zzxi.zzB();
    }

    public static zzph zza() {
        return zzph.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzph.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ࠞ", new Object[]{"zzd", "zze", "zzf", "zzg", zzpb.zzb()});
            }
            case 3: {
                return new zzph();
            }
            case 4: {
                return new zzpg(null);
            }
            case 5: {
                return zzph.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

