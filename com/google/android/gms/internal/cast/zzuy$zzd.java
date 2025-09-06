package com.google.android.gms.internal.cast;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

final class zzuy.zzd extends zzuy.zza {
    static final Unsafe zza;
    static final long zzb;
    static final long zzc;
    static final long zzd;
    static final long zze;
    static final long zzf;
    public static final int zzg;

    static {
        Unsafe unsafe0;
        Class class0;
        try {
            class0 = zzuy.zze.class;
            unsafe0 = Unsafe.getUnsafe();
        }
        catch(SecurityException unused_ex) {
            try {
                unsafe0 = (Unsafe)AccessController.doPrivileged(new zzvb());
            }
            catch(PrivilegedActionException privilegedActionException0) {
                throw new RuntimeException("Could not initialize intrinsics", privilegedActionException0.getCause());
            }
        }
        try {
            zzuy.zzd.zzc = unsafe0.objectFieldOffset(zzuy.class.getDeclaredField("waitersField"));
            zzuy.zzd.zzb = unsafe0.objectFieldOffset(zzuy.class.getDeclaredField("listenersField"));
            zzuy.zzd.zzd = unsafe0.objectFieldOffset(zzuy.class.getDeclaredField("valueField"));
            zzuy.zzd.zze = unsafe0.objectFieldOffset(class0.getDeclaredField("thread"));
            zzuy.zzd.zzf = unsafe0.objectFieldOffset(class0.getDeclaredField("next"));
            zzuy.zzd.zza = unsafe0;
        }
        catch(NoSuchFieldException noSuchFieldException0) {
            throw new RuntimeException(noSuchFieldException0);
        }
    }

    private zzuy.zzd() {
        throw null;
    }

    public zzuy.zzd(zzvc zzvc0) {
        super(null);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final zzux.zzd zza(zzuy zzuy0, zzux.zzd zzux$zzd0) {
        zzux.zzd zzux$zzd1;
        do {
            zzux$zzd1 = zzuy0.listenersField;
        }
        while(zzux$zzd0 != zzux$zzd1 && !this.zze(zzuy0, zzux$zzd1, zzux$zzd0));
        return zzux$zzd1;
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final zzuy.zze zzb(zzuy zzuy0, zzuy.zze zzuy$zze0) {
        zzuy.zze zzuy$zze1;
        do {
            zzuy$zze1 = zzuy0.waitersField;
        }
        while(zzuy$zze0 != zzuy$zze1 && !this.zzg(zzuy0, zzuy$zze1, zzuy$zze0));
        return zzuy$zze1;
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final void zzc(zzuy.zze zzuy$zze0, zzuy.zze zzuy$zze1) {
        zzuy.zzd.zza.putObject(zzuy$zze0, zzuy.zzd.zzf, zzuy$zze1);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final void zzd(zzuy.zze zzuy$zze0, Thread thread0) {
        zzuy.zzd.zza.putObject(zzuy$zze0, zzuy.zzd.zze, thread0);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final boolean zze(zzuy zzuy0, zzux.zzd zzux$zzd0, zzux.zzd zzux$zzd1) {
        return zzva.zza(zzuy.zzd.zza, zzuy0, zzuy.zzd.zzb, zzux$zzd0, zzux$zzd1);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final boolean zzf(zzuy zzuy0, Object object0, Object object1) {
        return zzva.zza(zzuy.zzd.zza, zzuy0, zzuy.zzd.zzd, object0, object1);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final boolean zzg(zzuy zzuy0, zzuy.zze zzuy$zze0, zzuy.zze zzuy$zze1) {
        return zzva.zza(zzuy.zzd.zza, zzuy0, zzuy.zzd.zzc, zzuy$zze0, zzuy$zze1);
    }
}

