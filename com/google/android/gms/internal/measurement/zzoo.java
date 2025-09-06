package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzoo {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzon zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    static {
        boolean z4;
        boolean z3;
        Class class0 = Class.class;
        Unsafe unsafe0 = zzoo.zzq();
        zzoo.zzc = unsafe0;
        zzoo.zzd = Memory.class;
        Class class1 = Long.TYPE;
        boolean z = zzoo.zzr(class1);
        zzoo.zze = z;
        Class class2 = Integer.TYPE;
        boolean z1 = zzoo.zzr(class2);
        zzon zzon0 = null;
        if(unsafe0 != null) {
            if(z) {
                zzon0 = new zzom(unsafe0);
            }
            else if(z1) {
                zzon0 = new zzol(unsafe0);
            }
        }
        zzoo.zzf = zzon0;
        Class class3 = Field.class;
        boolean z2 = true;
        Class class4 = Object.class;
        if(zzon0 == null) {
        label_32:
            z3 = false;
        }
        else {
            try {
                Class class5 = zzon0.zza.getClass();
                class5.getMethod("objectFieldOffset", class3);
                class5.getMethod("getLong", class4, class1);
                if(zzoo.zzB() == null) {
                    goto label_32;
                }
                else {
                    goto label_30;
                }
            }
            catch(Throwable throwable0) {
                zzoo.zzy(throwable0);
                z3 = false;
            }
            goto label_35;
        label_30:
            z3 = true;
        }
    label_35:
        zzoo.zzg = z3;
        zzon zzon1 = zzoo.zzf;
        if(zzon1 == null) {
            z4 = false;
        }
        else {
            try {
                Class class6 = zzon1.zza.getClass();
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
                zzoo.zzy(throwable1);
                z4 = false;
            }
        }
        zzoo.zzh = z4;
        zzoo.zza = (long)zzoo.zzz(byte[].class);
        zzoo.zzz(boolean[].class);
        zzoo.zzA(boolean[].class);
        zzoo.zzz(int[].class);
        zzoo.zzA(int[].class);
        zzoo.zzz(long[].class);
        zzoo.zzA(long[].class);
        zzoo.zzz(float[].class);
        zzoo.zzA(float[].class);
        zzoo.zzz(double[].class);
        zzoo.zzA(double[].class);
        zzoo.zzz(Object[].class);
        zzoo.zzA(Object[].class);
        Field field0 = zzoo.zzB();
        if(field0 != null) {
            zzon zzon2 = zzoo.zzf;
            if(zzon2 != null) {
                zzon2.zza.objectFieldOffset(field0);
            }
        }
        if(ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
            z2 = false;
        }
        zzoo.zzb = z2;
    }

    // 去混淆评级： 低(20)
    private static int zzA(Class class0) {
        return zzoo.zzh ? zzoo.zzf.zza.arrayIndexScale(class0) : -1;
    }

    private static Field zzB() {
        Class class0 = Buffer.class;
        Field field0 = zzoo.zzC(class0, "effectiveDirectAddress");
        if(field0 == null) {
            Field field1 = zzoo.zzC(class0, "address");
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
        int v1 = zzoo.zzf.zza.getInt(object0, -4L & v);
        int v2 = (~((int)v) & 3) << 3;
        zzoo.zzf.zza.putInt(object0, -4L & v, (0xFF & b) << v2 | v1 & ~(0xFF << v2));
    }

    private static void zzE(Object object0, long v, byte b) {
        int v1 = zzoo.zzf.zza.getInt(object0, -4L & v);
        int v2 = (((int)v) & 3) << 3;
        zzoo.zzf.zza.putInt(object0, -4L & v, (0xFF & b) << v2 | v1 & ~(0xFF << v2));
    }

    public static boolean zza() [...] // 潜在的解密器

    public static boolean zzb() {
        return zzoo.zzg;
    }

    public static Object zzc(Class class0) {
        try {
            return zzoo.zzc.allocateInstance(class0);
        }
        catch(InstantiationException instantiationException0) {
            throw new IllegalStateException(instantiationException0);
        }
    }

    public static int zzd(Object object0, long v) {
        return zzoo.zzf.zza.getInt(object0, v);
    }

    public static void zze(Object object0, long v, int v1) {
        zzoo.zzf.zza.putInt(object0, v, v1);
    }

    public static long zzf(Object object0, long v) {
        return zzoo.zzf.zza.getLong(object0, v);
    }

    public static void zzg(Object object0, long v, long v1) {
        zzoo.zzf.zza.putLong(object0, v, v1);
    }

    public static boolean zzh(Object object0, long v) {
        return zzoo.zzf.zzb(object0, v);
    }

    public static void zzi(Object object0, long v, boolean z) {
        zzoo.zzf.zzc(object0, v, z);
    }

    public static float zzj(Object object0, long v) {
        return zzoo.zzf.zzd(object0, v);
    }

    public static void zzk(Object object0, long v, float f) {
        zzoo.zzf.zze(object0, v, f);
    }

    public static double zzl(Object object0, long v) {
        return zzoo.zzf.zzf(object0, v);
    }

    public static void zzm(Object object0, long v, double f) {
        zzoo.zzf.zzg(object0, v, f);
    }

    public static Object zzn(Object object0, long v) {
        return zzoo.zzf.zza.getObject(object0, v);
    }

    public static void zzo(Object object0, long v, Object object1) {
        zzoo.zzf.zza.putObject(object0, v, object1);
    }

    public static void zzp(byte[] arr_b, long v, byte b) {
        zzoo.zzf.zza(arr_b, zzoo.zza + v, b);
    }

    public static Unsafe zzq() {
        try {
            return (Unsafe)AccessController.doPrivileged(new zzok());
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static boolean zzr(Class class0) {
        try {
            Class class1 = Boolean.TYPE;
            zzoo.zzd.getMethod("peekLong", class0, class1);
            zzoo.zzd.getMethod("pokeLong", class0, Long.TYPE, class1);
            Class class2 = Integer.TYPE;
            zzoo.zzd.getMethod("pokeInt", class0, class2, class1);
            zzoo.zzd.getMethod("peekInt", class0, class1);
            zzoo.zzd.getMethod("pokeByte", class0, Byte.TYPE);
            zzoo.zzd.getMethod("peekByte", class0);
            zzoo.zzd.getMethod("pokeByteArray", class0, byte[].class, class2, class2);
            zzoo.zzd.getMethod("peekByteArray", class0, byte[].class, class2, class2);
            return true;
        }
        catch(Throwable unused_ex) {
            return false;
        }
    }

    public static void zzs(Object object0, long v, byte b) {
        zzoo.zzD(object0, v, b);
    }

    public static void zzt(Object object0, long v, byte b) {
        zzoo.zzE(object0, v, b);
    }

    public static boolean zzu(Object object0, long v) {
        return ((byte)(zzoo.zzf.zza.getInt(object0, -4L & v) >>> ((int)((~v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static boolean zzv(Object object0, long v) {
        return ((byte)(zzoo.zzf.zza.getInt(object0, -4L & v) >>> ((int)((v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static void zzw(Object object0, long v, boolean z) {
        zzoo.zzD(object0, v, ((byte)z));
    }

    public static void zzx(Object object0, long v, boolean z) {
        zzoo.zzE(object0, v, ((byte)z));
    }

    public static void zzy(Throwable throwable0) {
        Logger.getLogger("com.google.android.gms.internal.measurement.zzoo").logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + throwable0.toString());
    }

    // 去混淆评级： 低(20)
    private static int zzz(Class class0) {
        return zzoo.zzh ? zzoo.zzf.zza.arrayBaseOffset(class0) : -1;
    }
}

