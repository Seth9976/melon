package com.google.android.gms.internal.cast;

public final class zzso extends zzxi implements zzym {
    private static final zzso zzb;
    private int zzd;
    private int zze;
    private String zzf;

    static {
        zzso zzso0 = new zzso();
        zzso.zzb = zzso0;
        zzxi.zzJ(zzso.class, zzso0);
    }

    private zzso() {
        this.zzf = "";
    }

    public static zzso zza() {
        return zzso.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzso.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzso();
            }
            case 4: {
                return new zzsn(null);
            }
            case 5: {
                return zzso.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

