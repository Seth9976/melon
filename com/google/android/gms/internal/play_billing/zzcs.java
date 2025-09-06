package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzcs extends zzay {
    private static final Map zzb;
    protected zzfg zzc;
    private int zzd;

    static {
        zzcs.zzb = new ConcurrentHashMap();
    }

    public zzcs() {
        this.zzd = -1;
        this.zzc = zzfg.zzc();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        return this.getClass() == object0.getClass() ? zzel.zza().zzb(this.getClass()).zzj(this, ((zzcs)object0)) : false;
    }

    @Override
    public final int hashCode() {
        if(!this.zzw()) {
            int v = this.zza;
            if(v == 0) {
                v = this.zzd();
                this.zza = v;
            }
            return v;
        }
        return this.zzd();
    }

    @Override
    public final String toString() {
        return zzee.zza(this, super.toString());
    }

    @Override  // com.google.android.gms.internal.play_billing.zzec
    public final zzeb zzE() {
        return (zzcn)this.zzx(5, null, null);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzec
    public final zzeb zzF() {
        zzeb zzeb0 = (zzcn)this.zzx(5, null, null);
        ((zzcn)zzeb0).zzc(this);
        return zzeb0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzay
    public final int zza(zzeo zzeo0) {
        if(this.zzw()) {
            int v = zzeo0.zza(this);
            if(v < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v);
            }
            return v;
        }
        int v1 = this.zzd & 0x7FFFFFFF;
        if(v1 == 0x7FFFFFFF) {
            int v2 = zzeo0.zza(this);
            if(v2 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v2);
            }
            this.zzd = this.zzd & 0x80000000 | v2;
            return v2;
        }
        return v1;
    }

    public final int zzd() {
        return zzel.zza().zzb(this.getClass()).zzb(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzec
    public final void zze(zzby zzby0) {
        zzel.zza().zzb(this.getClass()).zzi(this, zzbz.zza(zzby0));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzec
    public final int zzf() {
        if(this.zzw()) {
            int v = this.zzy(null);
            if(v < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v);
            }
            return v;
        }
        int v1 = this.zzd & 0x7FFFFFFF;
        if(v1 != 0x7FFFFFFF) {
            return v1;
        }
        int v2 = this.zzy(null);
        if(v2 < 0) {
            throw new IllegalStateException("serialized size must be non-negative, was " + v2);
        }
        this.zzd = this.zzd & 0x80000000 | v2;
        return v2;
    }

    public final zzcn zzg() {
        return (zzcn)this.zzx(5, null, null);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzed
    public final zzec zzh() {
        return (zzcs)this.zzx(6, null, null);
    }

    public final zzcn zzi() {
        zzcn zzcn0 = (zzcn)this.zzx(5, null, null);
        zzcn0.zzc(this);
        return zzcn0;
    }

    public static zzcs zzj(Class class0) {
        Map map0 = zzcs.zzb;
        zzcs zzcs0 = (zzcs)map0.get(class0);
        if(zzcs0 == null) {
            try {
                Class.forName(class0.getName(), true, class0.getClassLoader());
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException0);
            }
            zzcs0 = (zzcs)map0.get(class0);
        }
        if(zzcs0 == null) {
            zzcs zzcs1 = (zzcs)((zzcs)zzfp.zze(class0)).zzx(6, null, null);
            if(zzcs1 == null) {
                throw new IllegalStateException();
            }
            map0.put(class0, zzcs1);
            return zzcs1;
        }
        return zzcs0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzed
    public final boolean zzk() {
        return zzcs.zzv(this, true);
    }

    public final zzcs zzl() {
        return (zzcs)this.zzx(4, null, null);
    }

    public static zzcs zzm(zzcs zzcs0, byte[] arr_b, zzcd zzcd0) {
        zzcs zzcs1 = zzcs.zzz(zzcs0, arr_b, 0, arr_b.length, zzcd0);
        if(zzcs1 != null && !zzcs1.zzk()) {
            zzdc zzdc0 = new zzfe(zzcs1).zza();
            zzdc0.zzf(zzcs1);
            throw zzdc0;
        }
        return zzcs1;
    }

    public static zzcx zzn() {
        return zzct.zzf();
    }

    public static zzcz zzo() {
        return zzem.zze();
    }

    public static Object zzp(Method method0, Object object0, Object[] arr_object) {
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

    public static Object zzq(zzec zzec0, String s, Object[] arr_object) {
        return new zzen(zzec0, s, arr_object);
    }

    public final void zzr() {
        zzel.zza().zzb(this.getClass()).zzf(this);
        this.zzs();
    }

    public final void zzs() {
        this.zzd &= 0x7FFFFFFF;
    }

    public static void zzt(Class class0, zzcs zzcs0) {
        zzcs0.zzs();
        zzcs.zzb.put(class0, zzcs0);
    }

    // 去混淆评级： 低(25)
    public final void zzu(int v) {
        this.zzd |= 0x7FFFFFFF;
    }

    public static final boolean zzv(zzcs zzcs0, boolean z) {
        int v = (byte)(((Byte)zzcs0.zzx(1, null, null)));
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        boolean z1 = zzel.zza().zzb(zzcs0.getClass()).zzk(zzcs0);
        if(z) {
            zzcs0.zzx(2, (z1 ? zzcs0 : null), null);
        }
        return z1;
    }

    public final boolean zzw() {
        return (this.zzd & 0x80000000) != 0;
    }

    public abstract Object zzx(int arg1, Object arg2, Object arg3);

    private final int zzy(zzeo zzeo0) {
        return zzel.zza().zzb(this.getClass()).zza(this);
    }

    private static zzcs zzz(zzcs zzcs0, byte[] arr_b, int v, int v1, zzcd zzcd0) {
        if(v1 == 0) {
            return zzcs0;
        }
        zzcs zzcs1 = zzcs0.zzl();
        try {
            zzeo zzeo0 = zzel.zza().zzb(zzcs1.getClass());
            zzeo0.zzh(zzcs1, arr_b, 0, v1, new zzbc(zzcd0));
            zzeo0.zzf(zzcs1);
            return zzcs1;
        }
        catch(zzdc zzdc0) {
            zzdc0.zzf(zzcs1);
            throw zzdc0;
        }
        catch(zzfe zzfe0) {
            zzdc zzdc1 = zzfe0.zza();
            zzdc1.zzf(zzcs1);
            throw zzdc1;
        }
        catch(IOException iOException0) {
            if(iOException0.getCause() instanceof zzdc) {
                throw (zzdc)iOException0.getCause();
            }
            zzdc zzdc2 = new zzdc(iOException0);
            zzdc2.zzf(zzcs1);
            throw zzdc2;
        }
        catch(IndexOutOfBoundsException unused_ex) {
            zzdc zzdc3 = zzdc.zzg();
            zzdc3.zzf(zzcs1);
            throw zzdc3;
        }
    }
}

