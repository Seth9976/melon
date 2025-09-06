package com.google.android.gms.internal.cast;

public final class zzpp extends zzxi implements zzym {
    private static final zzpp zzb;
    private int zzd;
    private String zze;
    private String zzf;

    static {
        zzpp zzpp0 = new zzpp();
        zzpp.zzb = zzpp0;
        zzxi.zzJ(zzpp.class, zzpp0);
    }

    private zzpp() {
        this.zze = "";
        this.zzf = "";
    }

    public static zzpo zza() {
        return (zzpo)zzpp.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzpp.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzpp();
            }
            case 4: {
                return new zzpo(null);
            }
            case 5: {
                return zzpp.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzpp zzc() {
        return zzpp.zzb;
    }

    public static void zzd(zzpp zzpp0, String s) {
        s.getClass();
        zzpp0.zzd |= 1;
        zzpp0.zze = s;
    }

    public static void zze(zzpp zzpp0, String s) {
        s.getClass();
        zzpp0.zzd |= 2;
        zzpp0.zzf = s;
    }
}

