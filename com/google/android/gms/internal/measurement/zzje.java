package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzje extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private zzmn zze;
    private String zzf;
    private String zzg;
    private boolean zzh;
    private double zzi;
    private static final zzje zzj;

    static {
        zzje zzje0 = new zzje();
        zzje.zzj = zzje0;
        zzme.zzcp(zzje.class, zzje0);
    }

    private zzje() {
        this.zze = zzme.zzcv();
        this.zzf = "";
        this.zzg = "";
    }

    public final List zza() {
        return this.zze;
    }

    public final String zzb() [...] // 潜在的解密器

    public final boolean zzc() {
        return (this.zzb & 4) != 0;
    }

    public final String zzd() [...] // 潜在的解密器

    public final boolean zze() {
        return (this.zzb & 8) != 0;
    }

    public final boolean zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return (this.zzb & 16) != 0;
    }

    public final double zzh() {
        return this.zzi;
    }

    public static zzje zzi() {
        return zzje.zzj;
    }

    public final int zzj() {
        int v = zzjd.zza(this.zzd);
        return v == 0 ? 1 : v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzje.zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001B\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzb", "zzd", zzjc.zza, "zze", zzje.class, "zzf", "zzg", "zzh", "zzi"});
            }
            case 3: {
                return new zzje();
            }
            case 4: {
                return new zzjb(null);
            }
            case 5: {
                return zzje.zzj;
            }
            default: {
                throw null;
            }
        }
    }
}

