package com.google.android.gms.internal.measurement;

public final class zzfh extends zzme implements zznm {
    private int zzb;
    private zzfr zzd;
    private zzfl zze;
    private boolean zzf;
    private String zzg;
    private static final zzfh zzh;

    static {
        zzfh zzfh0 = new zzfh();
        zzfh.zzh = zzfh0;
        zzme.zzcp(zzfh.class, zzfh0);
    }

    private zzfh() {
        this.zzg = "";
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final zzfr zzb() {
        return this.zzd == null ? zzfr.zzh() : this.zzd;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final zzfl zzd() {
        return this.zze == null ? zzfl.zzj() : this.zze;
    }

    public final boolean zze() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final String zzh() [...] // 潜在的解密器

    public static zzfh zzi() {
        return zzfh.zzh;
    }

    public final void zzj(String s) {
        this.zzb |= 8;
        this.zzg = s;
    }

    public static zzfh zzk() {
        return zzfh.zzh;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzfh.zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
            }
            case 3: {
                return new zzfh();
            }
            case 4: {
                return new zzfg(null);
            }
            case 5: {
                return zzfh.zzh;
            }
            default: {
                throw null;
            }
        }
    }
}

