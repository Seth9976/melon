package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzja extends zzme implements zznm {
    private int zzb;
    private zzmn zzd;
    private zziw zze;
    private static final zzja zzf;

    static {
        zzja zzja0 = new zzja();
        zzja.zzf = zzja0;
        zzme.zzcp(zzja.class, zzja0);
    }

    private zzja() {
        this.zzd = zzme.zzcv();
    }

    public final List zza() {
        return this.zzd;
    }

    public final zziw zzb() {
        return this.zze == null ? zziw.zzc() : this.zze;
    }

    public static zzja zzc() {
        return zzja.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzja.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001B\u0002ဉ\u0000", new Object[]{"zzb", "zzd", zzje.class, "zze"});
            }
            case 3: {
                return new zzja();
            }
            case 4: {
                return new zziz(null);
            }
            case 5: {
                return zzja.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

