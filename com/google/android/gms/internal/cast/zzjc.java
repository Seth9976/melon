package com.google.android.gms.internal.cast;

import dalvik.system.VMStack;

public final class zzjc extends zziy {
    private static final boolean zza;
    private static final boolean zzb;
    private static final zzix zzc;

    static {
        zzjc.zza = zzjc.zza.zza();
        zzjc.zzb = false;
        zzjc.zzc = new zzix() {
            @Override  // com.google.android.gms.internal.cast.zzix
            public zzid zza(Class class0, int v) {
                return zzid.zza;
            }

            // 去混淆评级： 中等(70)
            @Override  // com.google.android.gms.internal.cast.zzix
            public String zzb(Class class0) {
                return null;
            }
        };
    }

    @Override  // com.google.android.gms.internal.cast.zziy
    public zzii zze(String s) {
        return zzjg.zzb(s);
    }

    @Override  // com.google.android.gms.internal.cast.zziy
    public zzix zzh() {
        return zzjc.zzc;
    }

    @Override  // com.google.android.gms.internal.cast.zziy
    public zzjm zzj() {
        return zzjh.zzb();
    }

    @Override  // com.google.android.gms.internal.cast.zziy
    public String zzm() {
        return "platform: Android";
    }

    public static Class zzp() {
        return VMStack.getStackClass2();
    }

    public static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static boolean zzr() [...] // 潜在的解密器

    public static boolean zzs() [...] // 潜在的解密器

    public static boolean zzt() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", null);
            return "com.google.android.gms.internal.cast.zzjc$zza".equals(zzjc.zzq());
        }
        catch(Throwable unused_ex) {
            return false;
        }
    }
}

