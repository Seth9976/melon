package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zziw extends zzme implements zznm {
    private zzmn zzb;
    private static final zziw zzd;

    static {
        zziw zziw0 = new zziw();
        zziw.zzd = zziw0;
        zzme.zzcp(zziw.class, zziw0);
    }

    private zziw() {
        this.zzb = zzme.zzcv();
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public static zziw zzc() {
        return zziw.zzd;
    }

    public static zziw zzd() {
        return zziw.zzd;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zziw.zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001B", new Object[]{"zzb", zziy.class});
            }
            case 3: {
                return new zziw();
            }
            case 4: {
                return new zziv(null);
            }
            case 5: {
                return zziw.zzd;
            }
            default: {
                throw null;
            }
        }
    }
}

