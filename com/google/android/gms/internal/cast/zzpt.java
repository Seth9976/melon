package com.google.android.gms.internal.cast;

public final class zzpt extends zzxi implements zzym {
    private static final zzpt zzb;
    private int zzd;
    private zzrc zze;
    private boolean zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private zztl zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private boolean zzs;

    static {
        zzpt zzpt0 = new zzpt();
        zzpt.zzb = zzpt0;
        zzxi.zzJ(zzpt.class, zzpt0);
    }

    public static zzps zza() {
        return (zzps)zzpt.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzpt.zzb, "\u0001\u000F\u0000\u0001\u0001\u000F\u000F\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003စ\u0002\u0004ဆ\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007င\u0006\bင\u0007\tဉ\b\n᠌\t\u000Bင\n\fဇ\u000B\rင\f\u000Eင\r\u000Fဇ\u000E", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzkx.zza(), "zzj", zzkv.zza(), "zzk", "zzl", "zzm", "zzn", zzlz.zza(), "zzo", "zzp", "zzq", "zzr", "zzs"});
            }
            case 3: {
                return new zzpt();
            }
            case 4: {
                return new zzps(null);
            }
            case 5: {
                return zzpt.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzps zzc(zzpt zzpt0) {
        zzxf zzxf0 = zzpt.zzb.zzy();
        zzxf0.zzq(zzpt0);
        return (zzps)zzxf0;
    }

    public static zzpt zzd() {
        return zzpt.zzb;
    }

    public static zzpt zze() {
        return zzpt.zzb;
    }

    public static void zzf(zzpt zzpt0, zzrc zzrc0) {
        zzrc0.getClass();
        zzpt0.zze = zzrc0;
        zzpt0.zzd |= 1;
    }

    public static void zzg(zzpt zzpt0, int v) {
        zzpt0.zzd |= 0x400;
        zzpt0.zzo = v;
    }

    public static void zzh(zzpt zzpt0, int v) {
        zzpt0.zzd |= 0x80;
        zzpt0.zzl = v;
    }

    public static void zzi(zzpt zzpt0, boolean z) {
        zzpt0.zzd |= 0x800;
        zzpt0.zzp = z;
    }

    public static void zzj(zzpt zzpt0, boolean z) {
        zzpt0.zzd |= 0x4000;
        zzpt0.zzs = z;
    }

    public static void zzk(zzpt zzpt0, boolean z) {
        zzpt0.zzd |= 2;
        zzpt0.zzf = z;
    }

    public static void zzl(zzpt zzpt0, int v) {
        zzpt0.zzd |= 0x40;
        zzpt0.zzk = v;
    }

    public static void zzm(zzpt zzpt0, long v) {
        zzpt0.zzd |= 4;
        zzpt0.zzg = v;
    }

    public static void zzn(zzpt zzpt0, int v) {
        zzpt0.zzd |= 0x2000;
        zzpt0.zzr = v;
    }

    public static void zzo(zzpt zzpt0, int v) {
        zzpt0.zzd |= 0x1000;
        zzpt0.zzq = v;
    }
}

