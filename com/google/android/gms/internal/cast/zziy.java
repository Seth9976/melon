package com.google.android.gms.internal.cast;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class zziy {
    private static String zza = "com.google.android.gms.internal.cast.zzjc";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd;

    static {
        zziy.zzd = new String[]{"com.google.android.gms.internal.cast.zzjc", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};
    }

    public static int zza() {
        return zzkc.zza();
    }

    public static long zzb() {
        return zziw.zza.zzc();
    }

    public long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    public static zzii zzd(String s) {
        return zziw.zza.zze(s);
    }

    public abstract zzii zze(String arg1);

    public static zzik zzf() {
        return zziy.zzi().zza();
    }

    public static zzix zzg() {
        return zziw.zza.zzh();
    }

    public abstract zzix zzh();

    public static zzjm zzi() {
        return zziw.zza.zzj();
    }

    public zzjm zzj() {
        return zzjm.zze();
    }

    public static zzjy zzk() {
        return zziy.zzi().zzc();
    }

    // 去混淆评级： 低(20)
    public static String zzl() {
        return "platform: Android";
    }

    public abstract String zzm();

    public static boolean zzn(String s, Level level0, boolean z) {
        zziy.zzi().zzd(s, level0, z);
        return false;
    }

    public static String[] zzo() {
        return zziy.zzd;
    }
}

