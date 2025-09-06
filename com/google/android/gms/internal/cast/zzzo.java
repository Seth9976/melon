package com.google.android.gms.internal.cast;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzzo {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzzn zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    static {
        boolean z4;
        boolean z3;
        Class class0 = Class.class;
        Unsafe unsafe0 = zzzo.zzg();
        zzzo.zzc = unsafe0;
        zzzo.zzd = Memory.class;
        Class class1 = Long.TYPE;
        boolean z = zzzo.zzv(class1);
        zzzo.zze = z;
        Class class2 = Integer.TYPE;
        boolean z1 = zzzo.zzv(class2);
        zzzn zzzn0 = null;
        if(unsafe0 != null) {
            if(z) {
                zzzn0 = new zzzm(unsafe0);
            }
            else if(z1) {
                zzzn0 = new zzzl(unsafe0);
            }
        }
        zzzo.zzf = zzzn0;
        Class class3 = Field.class;
        boolean z2 = true;
        Class class4 = Object.class;
        if(zzzn0 == null) {
        label_32:
            z3 = false;
        }
        else {
            try {
                Class class5 = zzzn0.zza.getClass();
                class5.getMethod("objectFieldOffset", class3);
                class5.getMethod("getLong", class4, class1);
                if(zzzo.zzB() == null) {
                    goto label_32;
                }
                else {
                    goto label_30;
                }
            }
            catch(Throwable throwable0) {
                zzzo.zzh(throwable0);
                z3 = false;
            }
            goto label_35;
        label_30:
            z3 = true;
        }
    label_35:
        zzzo.zzg = z3;
        zzzn zzzn1 = zzzo.zzf;
        if(zzzn1 == null) {
            z4 = false;
        }
        else {
            try {
                Class class6 = zzzn1.zza.getClass();
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
                zzzo.zzh(throwable1);
                z4 = false;
            }
        }
        zzzo.zzh = z4;
        zzzo.zza = (long)zzzo.zzz(byte[].class);
        zzzo.zzz(boolean[].class);
        zzzo.zzA(boolean[].class);
        zzzo.zzz(int[].class);
        zzzo.zzA(int[].class);
        zzzo.zzz(long[].class);
        zzzo.zzA(long[].class);
        zzzo.zzz(float[].class);
        zzzo.zzA(float[].class);
        zzzo.zzz(double[].class);
        zzzo.zzA(double[].class);
        zzzo.zzz(Object[].class);
        zzzo.zzA(Object[].class);
        Field field0 = zzzo.zzB();
        if(field0 != null) {
            zzzn zzzn2 = zzzo.zzf;
            if(zzzn2 != null) {
                zzzn2.zza.objectFieldOffset(field0);
            }
        }
        if(ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
            z2 = false;
        }
        zzzo.zzb = z2;
    }

    // 去混淆评级： 低(20)
    private static int zzA(Class class0) {
        return zzzo.zzh ? zzzo.zzf.zza.arrayIndexScale(class0) : -1;
    }

    private static Field zzB() {
        Class class0 = Buffer.class;
        Field field0 = zzzo.zzC(class0, "effectiveDirectAddress");
        if(field0 == null) {
            Field field1 = zzzo.zzC(class0, "address");
            return field1 == null || field1.getType() != Long.TYPE ? null : field1;
        }
        return field0;
    }

    private static Field zzC(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    private static void zzD(Object object0, long v, byte b) {
        int v1 = zzzo.zzf.zza.getInt(object0, -4L & v);
        int v2 = (~((int)v) & 3) << 3;
        zzzo.zzf.zza.putInt(object0, -4L & v, (0xFF & b) << v2 | v1 & ~(0xFF << v2));
    }

    private static void zzE(Object object0, long v, byte b) {
        int v1 = zzzo.zzf.zza.getInt(object0, -4L & v);
        int v2 = (((int)v) & 3) << 3;
        zzzo.zzf.zza.putInt(object0, -4L & v, (0xFF & b) << v2 | v1 & ~(0xFF << v2));
    }

    public static double zza(Object object0, long v) {
        return zzzo.zzf.zza(object0, v);
    }

    public static float zzb(Object object0, long v) {
        return zzzo.zzf.zzb(object0, v);
    }

    public static int zzc(Object object0, long v) {
        return zzzo.zzf.zza.getInt(object0, v);
    }

    public static long zzd(Object object0, long v) {
        return zzzo.zzf.zza.getLong(object0, v);
    }

    public static Object zze(Class class0) {
        try {
            return zzzo.zzc.allocateInstance(class0);
        }
        catch(InstantiationException instantiationException0) {
            throw new IllegalStateException(instantiationException0);
        }
    }

    public static Object zzf(Object object0, long v) {
        return zzzo.zzf.zza.getObject(object0, v);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe)AccessController.doPrivileged(new zzzk());
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static void zzh(Throwable throwable0) {
        Logger.getLogger("com.google.android.gms.internal.cast.zzzo").logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + throwable0.toString());
    }

    public static void zzi(Object object0, long v, boolean z) {
        zzzo.zzD(object0, v, ((byte)z));
    }

    public static void zzj(Object object0, long v, boolean z) {
        zzzo.zzE(object0, v, ((byte)z));
    }

    public static void zzk(Object object0, long v, byte b) {
        zzzo.zzD(object0, v, b);
    }

    public static void zzl(Object object0, long v, byte b) {
        zzzo.zzE(object0, v, b);
    }

    public static void zzm(Object object0, long v, boolean z) {
        zzzo.zzf.zzc(object0, v, z);
    }

    public static void zzn(byte[] arr_b, long v, byte b) {
        zzzo.zzf.zzd(arr_b, zzzo.zza + v, b);
    }

    public static void zzo(Object object0, long v, double f) {
        zzzo.zzf.zze(object0, v, f);
    }

    public static void zzp(Object object0, long v, float f) {
        zzzo.zzf.zzf(object0, v, f);
    }

    public static void zzq(Object object0, long v, int v1) {
        zzzo.zzf.zza.putInt(object0, v, v1);
    }

    public static void zzr(Object object0, long v, long v1) {
        zzzo.zzf.zza.putLong(object0, v, v1);
    }

    public static void zzs(Object object0, long v, Object object1) {
        zzzo.zzf.zza.putObject(object0, v, object1);
    }

    public static boolean zzt(Object object0, long v) {
        return ((byte)(zzzo.zzf.zza.getInt(object0, -4L & v) >>> ((int)((~v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static boolean zzu(Object object0, long v) {
        return ((byte)(zzzo.zzf.zza.getInt(object0, -4L & v) >>> ((int)((v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static boolean zzv(Class class0) {
        try {
            Class class1 = Boolean.TYPE;
            zzzo.zzd.getMethod("peekLong", class0, class1);
            zzzo.zzd.getMethod("pokeLong", class0, Long.TYPE, class1);
            Class class2 = Integer.TYPE;
            zzzo.zzd.getMethod("pokeInt", class0, class2, class1);
            zzzo.zzd.getMethod("peekInt", class0, class1);
            zzzo.zzd.getMethod("pokeByte", class0, Byte.TYPE);
            zzzo.zzd.getMethod("peekByte", class0);
            zzzo.zzd.getMethod("pokeByteArray", class0, byte[].class, class2, class2);
            zzzo.zzd.getMethod("peekByteArray", class0, byte[].class, class2, class2);
            return true;
        }
        catch(Throwable unused_ex) {
            return false;
        }
    }

    public static boolean zzw(Object object0, long v) {
        return zzzo.zzf.zzg(object0, v);
    }

    public static boolean zzx() [...] // 潜在的解密器

    public static boolean zzy() {
        return zzzo.zzg;
    }

    // 去混淆评级： 低(20)
    private static int zzz(Class class0) {
        return zzzo.zzh ? zzzo.zzf.zza.arrayBaseOffset(class0) : -1;
    }
}

