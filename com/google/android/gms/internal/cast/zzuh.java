package com.google.android.gms.internal.cast;

public final class zzuh extends zzxi implements zzym {
    private static final zzuh zzb;
    private int zzd;
    private String zze;

    static {
        zzuh zzuh0 = new zzuh();
        zzuh.zzb = zzuh0;
        zzxi.zzJ(zzuh.class, zzuh0);
    }

    private zzuh() {
        this.zze = "";
    }

    public static zzuh zza() {
        return zzuh.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzuh.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
            }
            case 3: {
                return new zzuh();
            }
            case 4: {
                return new zzug(null);
            }
            case 5: {
                return zzuh.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

