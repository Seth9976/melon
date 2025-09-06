package com.google.android.gms.internal.measurement;

public final class zzfn extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private String zze;
    private zzfh zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private static final zzfn zzj;

    static {
        zzfn zzfn0 = new zzfn();
        zzfn.zzj = zzfn0;
        zzme.zzcp(zzfn.class, zzfn0);
    }

    private zzfn() {
        this.zze = "";
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final String zzc() [...] // 潜在的解密器

    public final zzfh zzd() {
        return this.zzf == null ? zzfh.zzi() : this.zzf;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return (this.zzb & 0x20) != 0;
    }

    public final boolean zzh() {
        return this.zzi;
    }

    public static zzfm zzi() {
        return (zzfm)zzfn.zzj.zzck();
    }

    public final void zzj(String s) {
        this.zzb |= 2;
        this.zze = s;
    }

    public static zzfn zzk() {
        return zzfn.zzj;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzfn.zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            }
            case 3: {
                return new zzfn();
            }
            case 4: {
                return new zzfm(null);
            }
            case 5: {
                return zzfn.zzj;
            }
            default: {
                throw null;
            }
        }
    }
}

