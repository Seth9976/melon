package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzhj {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc;
    private static final boolean zzd;
    private static final zzhi zze;
    private static final boolean zzf;
    private static final boolean zzg;

    static {
        boolean z4;
        boolean z3;
        Class class0 = Class.class;
        Unsafe unsafe0 = zzhj.zzg();
        zzhj.zzb = unsafe0;
        zzhj.zzc = Memory.class;
        Class class1 = Long.TYPE;
        boolean z = zzhj.zzs(class1);
        zzhj.zzd = z;
        Class class2 = Integer.TYPE;
        boolean z1 = zzhj.zzs(class2);
        zzhi zzhi0 = null;
        if(unsafe0 != null) {
            if(z) {
                zzhi0 = new zzhh(unsafe0);
            }
            else if(z1) {
                zzhi0 = new zzhg(unsafe0);
            }
        }
        zzhj.zze = zzhi0;
        Class class3 = Field.class;
        boolean z2 = true;
        Class class4 = Object.class;
        if(zzhi0 == null) {
        label_32:
            z3 = false;
        }
        else {
            try {
                Class class5 = zzhi0.zza.getClass();
                class5.getMethod("objectFieldOffset", class3);
                class5.getMethod("getLong", class4, class1);
                if(zzhj.zzy() == null) {
                    goto label_32;
                }
                else {
                    goto label_30;
                }
            }
            catch(Throwable throwable0) {
                zzhj.zzh(throwable0);
                z3 = false;
            }
            goto label_35;
        label_30:
            z3 = true;
        }
    label_35:
        zzhj.zzf = z3;
        zzhi zzhi1 = zzhj.zze;
        if(zzhi1 == null) {
            z4 = false;
        }
        else {
            try {
                Class class6 = zzhi1.zza.getClass();
                class6.getMethod("objectFieldOffset", class3);
                class6.getMethod("arrayBaseOffset", class0);
                class6.getMethod("arrayIndexScale", class0);
                class6.getMethod("getInt", class4, class1);
                class6.getMethod("putInt", class4, class1, class2);
                class6.getMethod("getLong", class4, class1);
                class6.getMethod("putLong", class4, class1, class1);
                class6.getMethod("getObject", class4, class1);
                class6.getMethod("putObject", class4, class1, class4);
                z4 = true;
            }
            catch(Throwable throwable1) {
                zzhj.zzh(throwable1);
                z4 = false;
            }
        }
        zzhj.zzg = z4;
        zzhj.zzw(byte[].class);
        zzhj.zzw(boolean[].class);
        zzhj.zzx(boolean[].class);
        zzhj.zzw(int[].class);
        zzhj.zzx(int[].class);
        zzhj.zzw(long[].class);
        zzhj.zzx(long[].class);
        zzhj.zzw(float[].class);
        zzhj.zzx(float[].class);
        zzhj.zzw(double[].class);
        zzhj.zzx(double[].class);
        zzhj.zzw(Object[].class);
        zzhj.zzx(Object[].class);
        Field field0 = zzhj.zzy();
        if(field0 != null) {
            zzhi zzhi2 = zzhj.zze;
            if(zzhi2 != null) {
                zzhi2.zza.objectFieldOffset(field0);
            }
        }
        if(ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
            z2 = false;
        }
        zzhj.zza = z2;
    }

    public static double zza(Object object0, long v) {
        return zzhj.zze.zza(object0, v);
    }

    public static float zzb(Object object0, long v) {
        return zzhj.zze.zzb(object0, v);
    }

    public static int zzc(Object object0, long v) {
        return zzhj.zze.zza.getInt(object0, v);
    }

    public static long zzd(Object object0, long v) {
        return zzhj.zze.zza.getLong(object0, v);
    }

    public static Object zze(Class class0) {
        try {
            return zzhj.zzb.allocateInstance(class0);
        }
        catch(InstantiationException instantiationException0) {
            throw new IllegalStateException(instantiationException0);
        }
    }

    public static Object zzf(Object object0, long v) {
        return zzhj.zze.zza.getObject(object0, v);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe)AccessController.doPrivileged(new zzhf());
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static void zzh(Throwable throwable0) {
        Logger.getLogger("com.google.android.gms.internal.auth.zzhj").logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + throwable0.toString());
    }

    public static void zzi(Object object0, long v, boolean z) {
        int v1 = zzhj.zze.zza.getInt(object0, -4L & v);
        int v2 = (~((int)v) & 3) << 3;
        zzhj.zze.zza.putInt(object0, -4L & v, ((int)z) << v2 | ~(0xFF << v2) & v1);
    }

    public static void zzj(Object object0, long v, boolean z) {
        int v1 = zzhj.zze.zza.getInt(object0, -4L & v);
        int v2 = (((int)v) & 3) << 3;
        zzhj.zze.zza.putInt(object0, -4L & v, ((int)z) << v2 | ~(0xFF << v2) & v1);
    }

    public static void zzk(Object object0, long v, boolean z) {
        zzhj.zze.zzc(object0, v, z);
    }

    public static void zzl(Object object0, long v, double f) {
        zzhj.zze.zzd(object0, v, f);
    }

    public static void zzm(Object object0, long v, float f) {
        zzhj.zze.zze(object0, v, f);
    }

    public static void zzn(Object object0, long v, int v1) {
        zzhj.zze.zza.putInt(object0, v, v1);
    }

    public static void zzo(Object object0, long v, long v1) {
        zzhj.zze.zza.putLong(object0, v, v1);
    }

    public static void zzp(Object object0, long v, Object object1) {
        zzhj.zze.zza.putObject(object0, v, object1);
    }

    public static boolean zzq(Object object0, long v) {
        return ((byte)(zzhj.zze.zza.getInt(object0, -4L & v) >>> ((int)((~v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static boolean zzr(Object object0, long v) {
        return ((byte)(zzhj.zze.zza.getInt(object0, -4L & v) >>> ((int)((v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static boolean zzs(Class class0) {
        try {
            Class class1 = Boolean.TYPE;
            zzhj.zzc.getMethod("peekLong", class0, class1);
            zzhj.zzc.getMethod("pokeLong", class0, Long.TYPE, class1);
            Class class2 = Integer.TYPE;
            zzhj.zzc.getMethod("pokeInt", class0, class2, class1);
            zzhj.zzc.getMethod("peekInt", class0, class1);
            zzhj.zzc.getMethod("pokeByte", class0, Byte.TYPE);
            zzhj.zzc.getMethod("peekByte", class0);
            zzhj.zzc.getMethod("pokeByteArray", class0, byte[].class, class2, class2);
            zzhj.zzc.getMethod("peekByteArray", class0, byte[].class, class2, class2);
            return true;
        }
        catch(Throwable unused_ex) {
            return false;
        }
    }

    public static boolean zzt(Object object0, long v) {
        return zzhj.zze.zzf(object0, v);
    }

    public static boolean zzu() {
        return zzhj.zzg;
    }

    public static boolean zzv() {
        return zzhj.zzf;
    }

    // 去混淆评级： 低(20)
    private static int zzw(Class class0) {
        return zzhj.zzg ? zzhj.zze.zza.arrayBaseOffset(class0) : -1;
    }

    // 去混淆评级： 低(20)
    private static int zzx(Class class0) {
        return zzhj.zzg ? zzhj.zze.zza.arrayIndexScale(class0) : -1;
    }

    private static Field zzy() {
        Class class0 = Buffer.class;
        Field field0 = zzhj.zzz(class0, "effectiveDirectAddress");
        if(field0 == null) {
            Field field1 = zzhj.zzz(class0, "address");
            return field1 == null || field1.getType() != Long.TYPE ? null : field1;
        }
        return field0;
    }

    private static Field zzz(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }
}

