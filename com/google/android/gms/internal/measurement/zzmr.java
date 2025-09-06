package com.google.android.gms.internal.measurement;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class zzmr extends Enum {
    public static final enum zzmr zza;
    public static final enum zzmr zzb;
    public static final enum zzmr zzc;
    public static final enum zzmr zzd;
    public static final enum zzmr zze;
    public static final enum zzmr zzf;
    public static final enum zzmr zzg;
    public static final enum zzmr zzh;
    public static final enum zzmr zzi;
    public static final enum zzmr zzj;
    private final Class zzk;
    private static final zzmr[] zzl;

    static {
        zzmr.zza = new zzmr("VOID", 0, Void.class, Void.class, null);
        Class class0 = Integer.TYPE;
        zzmr.zzb = new zzmr("INT", 1, class0, Integer.class, 0);
        zzmr.zzc = new zzmr("LONG", 2, Long.TYPE, Long.class, 0L);
        zzmr.zzd = new zzmr("FLOAT", 3, Float.TYPE, Float.class, 0.0f);
        zzmr.zze = new zzmr("DOUBLE", 4, Double.TYPE, Double.class, 0.0);
        zzmr.zzf = new zzmr("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzmr.zzg = new zzmr("STRING", 6, String.class, String.class, "");
        zzmr.zzh = new zzmr("BYTE_STRING", 7, zzlg.class, zzlg.class, zzlg.zzb);
        zzmr.zzi = new zzmr("ENUM", 8, class0, Integer.class, null);
        zzmr.zzj = new zzmr("MESSAGE", 9, Object.class, Object.class, null);
        zzmr.zzl = new zzmr[]{zzmr.zza, zzmr.zzb, zzmr.zzc, zzmr.zzd, zzmr.zze, zzmr.zzf, zzmr.zzg, zzmr.zzh, zzmr.zzi, zzmr.zzj};
    }

    private zzmr(String s, int v, Class class0, Class class1, Object object0) {
        super(s, v);
        this.zzk = class1;
    }

    public static zzmr[] values() {
        return (zzmr[])zzmr.zzl.clone();
    }

    public final Class zza() {
        return this.zzk;
    }
}

