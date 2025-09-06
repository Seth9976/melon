package com.google.android.gms.internal.cast;

public final class zzjz {
    private static final String[] zza;
    private static final zzkd zzb;

    static {
        zzkd zzkd0;
        zzjz.zza = new String[]{"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
        for(int v = 0; true; ++v) {
            if(v >= 2) {
                zzkd0 = new zzke();
                break;
            }
            String s = zzjz.zza[v];
            zzkd0 = null;
            try {
                zzkd0 = (zzkd)Class.forName(s).asSubclass(zzkd.class).getDeclaredConstructor(null).newInstance(null);
            }
            catch(Throwable unused_ex) {
            }
            if(zzkd0 != null) {
                break;
            }
        }
        zzjz.zzb = zzkd0;
    }

    public static StackTraceElement zza(Class class0, int v) {
        zzka.zza(class0, "target");
        return zzjz.zzb.zza(class0, 2);
    }
}

