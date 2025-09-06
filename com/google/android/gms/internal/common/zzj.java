package com.google.android.gms.internal.common;

public final class zzj {
    public static Object zza(Class class0, String s, zzi[] arr_zzi) {
        return zzj.zzc(class0, "isIsolated", null, false, arr_zzi);
    }

    public static Object zzb(String s, String s1, ClassLoader classLoader0, zzi[] arr_zzi) {
        return zzj.zzc(classLoader0.loadClass("com.google.android.gms.common.security.ProviderInstallerImpl"), "reportRequestStats2", null, false, arr_zzi);
    }

    private static Object zzc(Class class0, String s, Object object0, boolean z, zzi[] arr_zzi) {
        Class[] arr_class = new Class[arr_zzi.length];
        Object[] arr_object = new Object[arr_zzi.length];
        for(int v = 0; v < arr_zzi.length; ++v) {
            zzi zzi0 = arr_zzi[v];
            zzi0.getClass();
            arr_class[v] = zzi0.zzc();
            arr_object[v] = arr_zzi[v].zzd();
        }
        return class0.getDeclaredMethod(s, arr_class).invoke(null, arr_object);
    }
}

