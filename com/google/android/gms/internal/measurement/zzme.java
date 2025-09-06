package com.google.android.gms.internal.measurement;

import b3.Z;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzme extends zzkr {
    private int zzb;
    protected zzoi zzc;
    private static final Map zzd;

    static {
        zzme.zzd = new ConcurrentHashMap();
    }

    public zzme() {
        this.zzb = -1;
        this.zzc = zzoi.zza();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        return this.getClass() == object0.getClass() ? zznt.zza().zzb(this.getClass()).zzb(this, ((zzme)object0)) : false;
    }

    @Override
    public final int hashCode() {
        if(!this.zzcf()) {
            int v = this.zza;
            if(v == 0) {
                v = this.zzci();
                this.zza = v;
            }
            return v;
        }
        return this.zzci();
    }

    @Override
    public final String toString() {
        return zznn.zza(this, super.toString());
    }

    private final int zzc(zznw zznw0) {
        return zznt.zza().zzb(this.getClass()).zze(this);
    }

    @Override  // com.google.android.gms.internal.measurement.zznl
    public final void zzcB(zzll zzll0) {
        zznt.zza().zzb(this.getClass()).zzf(this, zzlm.zza(zzll0));
    }

    @Override  // com.google.android.gms.internal.measurement.zznl
    public final zznk zzcC() {
        return (zzma)this.zzl(5, null, null);
    }

    @Override  // com.google.android.gms.internal.measurement.zznm
    public final boolean zzcD() {
        return zzme.zzd(this, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zznm
    public final zznl zzcE() {
        return (zzme)this.zzl(6, null, null);
    }

    @Override  // com.google.android.gms.internal.measurement.zzkr
    public final int zzcd(zznw zznw0) {
        if(this.zzcf()) {
            int v = zznw0.zze(this);
            if(v < 0) {
                throw new IllegalStateException(Z.j(String.valueOf(v).length() + 42, v, "serialized size must be non-negative, was "));
            }
            return v;
        }
        int v1 = this.zzb & 0x7FFFFFFF;
        if(v1 == 0x7FFFFFFF) {
            int v2 = zznw0.zze(this);
            if(v2 < 0) {
                throw new IllegalStateException(Z.j(String.valueOf(v2).length() + 42, v2, "serialized size must be non-negative, was "));
            }
            this.zzb = this.zzb & 0x80000000 | v2;
            return v2;
        }
        return v1;
    }

    public final boolean zzcf() {
        return (this.zzb & 0x80000000) != 0;
    }

    public final void zzcg() {
        this.zzb &= 0x7FFFFFFF;
    }

    public final zzme zzch() {
        return (zzme)this.zzl(4, null, null);
    }

    public final int zzci() {
        return zznt.zza().zzb(this.getClass()).zzc(this);
    }

    public final void zzcj() {
        zznt.zza().zzb(this.getClass()).zzj(this);
        this.zzcg();
    }

    public final zzma zzck() {
        return (zzma)this.zzl(5, null, null);
    }

    public final zzma zzcl() {
        zzma zzma0 = (zzma)this.zzl(5, null, null);
        zzma0.zzbd(this);
        return zzma0;
    }

    // 去混淆评级： 低(25)
    public final void zzcm(int v) {
        this.zzb |= 0x7FFFFFFF;
    }

    @Override  // com.google.android.gms.internal.measurement.zznl
    public final int zzcn() {
        if(this.zzcf()) {
            int v = this.zzc(null);
            if(v < 0) {
                throw new IllegalStateException(Z.j(String.valueOf(v).length() + 42, v, "serialized size must be non-negative, was "));
            }
            return v;
        }
        int v1 = this.zzb & 0x7FFFFFFF;
        if(v1 != 0x7FFFFFFF) {
            return v1;
        }
        int v2 = this.zzc(null);
        if(v2 < 0) {
            throw new IllegalStateException(Z.j(String.valueOf(v2).length() + 42, v2, "serialized size must be non-negative, was "));
        }
        this.zzb = this.zzb & 0x80000000 | v2;
        return v2;
    }

    public static zzme zzco(Class class0) {
        Map map0 = zzme.zzd;
        zzme zzme0 = (zzme)map0.get(class0);
        if(zzme0 == null) {
            try {
                Class.forName(class0.getName(), true, class0.getClassLoader());
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException0);
            }
            zzme0 = (zzme)map0.get(class0);
        }
        if(zzme0 == null) {
            zzme zzme1 = (zzme)((zzme)zzoo.zzc(class0)).zzl(6, null, null);
            if(zzme1 == null) {
                throw new IllegalStateException();
            }
            map0.put(class0, zzme1);
            return zzme1;
        }
        return zzme0;
    }

    public static void zzcp(Class class0, zzme zzme0) {
        zzme0.zzcg();
        zzme.zzd.put(class0, zzme0);
    }

    public static Object zzcq(zznl zznl0, String s, Object[] arr_object) {
        return new zznv(zznl0, s, arr_object);
    }

    public static Object zzcr(Method method0, Object object0, Object[] arr_object) {
        try {
            return method0.invoke(object0, arr_object);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException("Couldn\'t use Java reflection to implement protocol message reflection.", illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            Throwable throwable0 = invocationTargetException0.getCause();
            if(throwable0 instanceof RuntimeException) {
                throw (RuntimeException)throwable0;
            }
            if(throwable0 instanceof Error) {
                throw (Error)throwable0;
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable0);
        }
    }

    public static zzml zzcs() {
        return zzmf.zzd();
    }

    public static zzmm zzct() {
        return zzmz.zze();
    }

    public static zzmm zzcu(zzmm zzmm0) {
        int v = zzmm0.size();
        return zzmm0.zzd(v + v);
    }

    public static zzmn zzcv() {
        return zznu.zzd();
    }

    public static zzmn zzcw(zzmn zzmn0) {
        int v = zzmn0.size();
        return zzmn0.zzg(v + v);
    }

    public static boolean zzcx(zzme zzme0, boolean z) {
        return zzme.zzd(zzme0, false);
    }

    private static final boolean zzd(zzme zzme0, boolean z) {
        int v = (byte)(((Byte)zzme0.zzl(1, null, null)));
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        boolean z1 = zznt.zza().zzb(zzme0.getClass()).zzk(zzme0);
        if(z) {
            zzme0.zzl(2, (z1 ? zzme0 : null), null);
        }
        return z1;
    }

    public abstract Object zzl(int arg1, Object arg2, Object arg3);
}

