package com.google.android.gms.internal.cast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzxi extends zzwa {
    private static final Map zzb;
    protected zzzi zzc;
    private int zzd;

    static {
        zzxi.zzb = new ConcurrentHashMap();
    }

    public zzxi() {
        this.zzd = -1;
        this.zzc = zzzi.zzc();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        return this.getClass() == object0.getClass() ? zzys.zza().zzb(this.getClass()).zzg(this, ((zzxi)object0)) : false;
    }

    @Override
    public final int hashCode() {
        if(!this.zzM()) {
            int v = this.zza;
            if(v == 0) {
                v = this.zzv();
                this.zza = v;
            }
            return v;
        }
        return this.zzv();
    }

    @Override
    public final String toString() {
        return zzyn.zza(this, super.toString());
    }

    public final zzxi zzA() {
        return (zzxi)this.zzb(4, null, null);
    }

    public static zzxl zzB() {
        return zzxj.zzf();
    }

    public static zzxm zzC() {
        return zzya.zzf();
    }

    public static zzxn zzD() {
        return zzyt.zze();
    }

    public static zzxn zzE(zzxn zzxn0) {
        int v = zzxn0.size();
        return zzxn0.zzd(v + v);
    }

    public static Object zzF(Method method0, Object object0, Object[] arr_object) {
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

    public static Object zzG(zzyl zzyl0, String s, Object[] arr_object) {
        return new zzyu(zzyl0, s, arr_object);
    }

    public final void zzH() {
        zzys.zza().zzb(this.getClass()).zzd(this);
        this.zzI();
    }

    public final void zzI() {
        this.zzd &= 0x7FFFFFFF;
    }

    public static void zzJ(Class class0, zzxi zzxi0) {
        zzxi0.zzI();
        zzxi.zzb.put(class0, zzxi0);
    }

    // 去混淆评级： 低(25)
    public final void zzK(int v) {
        this.zzd |= 0x7FFFFFFF;
    }

    public static boolean zzL(zzxi zzxi0, boolean z) {
        return zzxi.zzd(zzxi0, false);
    }

    public final boolean zzM() {
        return (this.zzd & 0x80000000) != 0;
    }

    @Override  // com.google.android.gms.internal.cast.zzyl
    public final zzyk zzN() {
        return (zzxf)this.zzb(5, null, null);
    }

    @Override  // com.google.android.gms.internal.cast.zzyl
    public final void zzO(zzwu zzwu0) {
        zzys.zza().zzb(this.getClass()).zzf(this, zzwv.zza(zzwu0));
    }

    public abstract Object zzb(int arg1, Object arg2, Object arg3);

    private final int zzc(zzyv zzyv0) {
        return zzys.zza().zzb(this.getClass()).zza(this);
    }

    private static final boolean zzd(zzxi zzxi0, boolean z) {
        int v = (byte)(((Byte)zzxi0.zzb(1, null, null)));
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        boolean z1 = zzys.zza().zzb(zzxi0.getClass()).zzh(zzxi0);
        if(z) {
            zzxi0.zzb(2, (z1 ? zzxi0 : null), null);
        }
        return z1;
    }

    @Override  // com.google.android.gms.internal.cast.zzwa
    public final int zzr(zzyv zzyv0) {
        if(this.zzM()) {
            int v = zzyv0.zza(this);
            if(v < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v);
            }
            return v;
        }
        int v1 = this.zzd & 0x7FFFFFFF;
        if(v1 == 0x7FFFFFFF) {
            int v2 = zzyv0.zza(this);
            if(v2 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v2);
            }
            this.zzd = this.zzd & 0x80000000 | v2;
            return v2;
        }
        return v1;
    }

    @Override  // com.google.android.gms.internal.cast.zzym
    public final zzyl zzu() {
        return (zzxi)this.zzb(6, null, null);
    }

    public final int zzv() {
        return zzys.zza().zzb(this.getClass()).zzb(this);
    }

    @Override  // com.google.android.gms.internal.cast.zzyl
    public final int zzw() {
        if(this.zzM()) {
            int v = this.zzc(null);
            if(v < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v);
            }
            return v;
        }
        int v1 = this.zzd & 0x7FFFFFFF;
        if(v1 != 0x7FFFFFFF) {
            return v1;
        }
        int v2 = this.zzc(null);
        if(v2 < 0) {
            throw new IllegalStateException("serialized size must be non-negative, was " + v2);
        }
        this.zzd = this.zzd & 0x80000000 | v2;
        return v2;
    }

    @Override  // com.google.android.gms.internal.cast.zzym
    public final boolean zzx() {
        return zzxi.zzd(this, true);
    }

    public final zzxf zzy() {
        return (zzxf)this.zzb(5, null, null);
    }

    public static zzxi zzz(Class class0) {
        Map map0 = zzxi.zzb;
        zzxi zzxi0 = (zzxi)map0.get(class0);
        if(zzxi0 == null) {
            try {
                Class.forName(class0.getName(), true, class0.getClassLoader());
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException0);
            }
            zzxi0 = (zzxi)map0.get(class0);
        }
        if(zzxi0 == null) {
            zzxi zzxi1 = (zzxi)((zzxi)zzzo.zze(class0)).zzb(6, null, null);
            if(zzxi1 == null) {
                throw new IllegalStateException();
            }
            map0.put(class0, zzxi1);
            return zzxi1;
        }
        return zzxi0;
    }
}

