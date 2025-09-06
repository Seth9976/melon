package com.google.android.gms.internal.cast;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class zzxr extends Enum {
    public static final enum zzxr zza;
    public static final enum zzxr zzb;
    public static final enum zzxr zzc;
    public static final enum zzxr zzd;
    public static final enum zzxr zze;
    public static final enum zzxr zzf;
    public static final enum zzxr zzg;
    public static final enum zzxr zzh;
    public static final enum zzxr zzi;
    public static final enum zzxr zzj;
    private static final zzxr[] zzk;
    private final Class zzl;

    static {
        zzxr.zza = new zzxr("VOID", 0, Void.class, Void.class, null);
        Class class0 = Integer.TYPE;
        zzxr.zzb = new zzxr("INT", 1, class0, Integer.class, 0);
        zzxr.zzc = new zzxr("LONG", 2, Long.TYPE, Long.class, 0L);
        zzxr.zzd = new zzxr("FLOAT", 3, Float.TYPE, Float.class, 0.0f);
        zzxr.zze = new zzxr("DOUBLE", 4, Double.TYPE, Double.class, 0.0);
        zzxr.zzf = new zzxr("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzxr.zzg = new zzxr("STRING", 6, String.class, String.class, "");
        zzxr.zzh = new zzxr("BYTE_STRING", 7, zzwn.class, zzwn.class, zzwn.zzb);
        zzxr.zzi = new zzxr("ENUM", 8, class0, Integer.class, null);
        zzxr.zzj = new zzxr("MESSAGE", 9, Object.class, Object.class, null);
        zzxr.zzk = new zzxr[]{zzxr.zza, zzxr.zzb, zzxr.zzc, zzxr.zzd, zzxr.zze, zzxr.zzf, zzxr.zzg, zzxr.zzh, zzxr.zzi, zzxr.zzj};
    }

    private zzxr(String s, int v, Class class0, Class class1, Object object0) {
        super(s, v);
        this.zzl = class1;
    }

    public static zzxr[] values() {
        return (zzxr[])zzxr.zzk.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}

