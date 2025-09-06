package com.google.android.gms.internal.cast;

public final class zzsc extends zzxi implements zzym {
    private static final zzsc zzb;
    private int zzd;
    private String zze;
    private String zzf;

    static {
        zzsc zzsc0 = new zzsc();
        zzsc.zzb = zzsc0;
        zzxi.zzJ(zzsc.class, zzsc0);
    }

    private zzsc() {
        this.zze = "";
        this.zzf = "";
    }

    public static zzsc zza() {
        return zzsc.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzsc.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzsc();
            }
            case 4: {
                return new zzsb(null);
            }
            case 5: {
                return zzsc.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

