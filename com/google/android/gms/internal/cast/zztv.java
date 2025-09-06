package com.google.android.gms.internal.cast;

public final class zztv extends zzxi implements zzym {
    private static final zztv zzb;
    private int zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private boolean zzk;
    private int zzl;

    static {
        zztv zztv0 = new zztv();
        zztv.zzb = zztv0;
        zzxi.zzJ(zztv.class, zztv0);
    }

    private zztv() {
        this.zze = "";
        this.zzf = "";
        this.zzg = "";
        this.zzh = "";
        this.zzi = "";
        this.zzj = "";
    }

    public static zztu zza() {
        return (zztu)zztv.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztv.zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\b᠌\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzld.zza()});
            }
            case 3: {
                return new zztv();
            }
            case 4: {
                return new zztu(null);
            }
            case 5: {
                return zztv.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zztv zzc() {
        return zztv.zzb;
    }

    public static void zzd(zztv zztv0, String s) {
        s.getClass();
        zztv0.zzd |= 8;
        zztv0.zzh = s;
    }

    public static void zze(zztv zztv0, String s) {
        s.getClass();
        zztv0.zzd |= 16;
        zztv0.zzi = s;
    }

    public static void zzf(zztv zztv0, String s) {
        s.getClass();
        zztv0.zzd |= 1;
        zztv0.zze = s;
    }

    public static void zzg(zztv zztv0, String s) {
        s.getClass();
        zztv0.zzd |= 2;
        zztv0.zzf = s;
    }

    public static void zzh(zztv zztv0, String s) {
        s.getClass();
        zztv0.zzd |= 4;
        zztv0.zzg = s;
    }

    public static void zzi(zztv zztv0, String s) {
        s.getClass();
        zztv0.zzd |= 0x20;
        zztv0.zzj = s;
    }

    public static void zzj(zztv zztv0, int v) {
        zztv0.zzl = v - 1;
        zztv0.zzd |= 0x80;
    }
}

