package com.google.android.gms.internal.play_billing;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class zzdd extends Enum {
    public static final enum zzdd zza;
    public static final enum zzdd zzb;
    public static final enum zzdd zzc;
    public static final enum zzdd zzd;
    public static final enum zzdd zze;
    public static final enum zzdd zzf;
    public static final enum zzdd zzg;
    public static final enum zzdd zzh;
    public static final enum zzdd zzi;
    public static final enum zzdd zzj;
    private static final zzdd[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzdd.zza = new zzdd("VOID", 0, Void.class, Void.class, null);
        Class class0 = Integer.TYPE;
        zzdd.zzb = new zzdd("INT", 1, class0, Integer.class, 0);
        zzdd.zzc = new zzdd("LONG", 2, Long.TYPE, Long.class, 0L);
        zzdd.zzd = new zzdd("FLOAT", 3, Float.TYPE, Float.class, 0.0f);
        zzdd.zze = new zzdd("DOUBLE", 4, Double.TYPE, Double.class, 0.0);
        zzdd.zzf = new zzdd("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzdd.zzg = new zzdd("STRING", 6, String.class, String.class, "");
        zzdd.zzh = new zzdd("BYTE_STRING", 7, zzbq.class, zzbq.class, zzbq.zzb);
        zzdd.zzi = new zzdd("ENUM", 8, class0, Integer.class, null);
        zzdd.zzj = new zzdd("MESSAGE", 9, Object.class, Object.class, null);
        zzdd.zzk = new zzdd[]{zzdd.zza, zzdd.zzb, zzdd.zzc, zzdd.zzd, zzdd.zze, zzdd.zzf, zzdd.zzg, zzdd.zzh, zzdd.zzi, zzdd.zzj};
    }

    private zzdd(String s, int v, Class class0, Class class1, Object object0) {
        super(s, v);
        this.zzl = class0;
        this.zzm = class1;
        this.zzn = object0;
    }

    public static zzdd[] values() {
        return (zzdd[])zzdd.zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}

