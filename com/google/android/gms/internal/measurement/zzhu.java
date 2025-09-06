package com.google.android.gms.internal.measurement;

public final class zzhu extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private long zze;
    private static final zzhu zzf;

    static {
        zzhu zzhu0 = new zzhu();
        zzhu.zzf = zzhu0;
        zzme.zzcp(zzhu.class, zzhu0);
    }

    private zzhu() {
        this.zzd = "";
    }

    public static zzht zza() {
        return (zzht)zzhu.zzf.zzck();
    }

    public final void zzb(String s) {
        s.getClass();
        this.zzb |= 1;
        this.zzd = s;
    }

    public final void zzc(long v) {
        this.zzb |= 2;
        this.zze = v;
    }

    public static zzhu zzd() {
        return zzhu.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzhu.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
            }
            case 3: {
                return new zzhu();
            }
            case 4: {
                return new zzht(null);
            }
            case 5: {
                return zzhu.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

