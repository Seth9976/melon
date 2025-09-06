package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfr extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private String zze;
    private boolean zzf;
    private zzmn zzg;
    private static final zzfr zzh;

    static {
        zzfr zzfr0 = new zzfr();
        zzfr.zzh = zzfr0;
        zzme.zzcp(zzfr.class, zzfr0);
    }

    private zzfr() {
        this.zze = "";
        this.zzg = zzme.zzcv();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zzb() {
        return (this.zzb & 2) != 0;
    }

    public final String zzc() [...] // 潜在的解密器

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzg;
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public static zzfr zzh() {
        return zzfr.zzh;
    }

    public static zzfr zzi() {
        return zzfr.zzh;
    }

    public final int zzj() {
        int v = zzfq.zza(this.zzd);
        return v == 0 ? 1 : v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzfr.zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001A", new Object[]{"zzb", "zzd", zzfp.zza, "zze", "zzf", "zzg"});
            }
            case 3: {
                return new zzfr();
            }
            case 4: {
                return new zzfo(null);
            }
            case 5: {
                return zzfr.zzh;
            }
            default: {
                throw null;
            }
        }
    }
}

