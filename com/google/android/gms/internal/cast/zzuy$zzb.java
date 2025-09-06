package com.google.android.gms.internal.cast;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

final class zzuy.zzb extends zzuy.zza {
    private static final AtomicReferenceFieldUpdater zza;
    private static final AtomicReferenceFieldUpdater zzb;
    private static final AtomicReferenceFieldUpdater zzc;
    private static final AtomicReferenceFieldUpdater zzd;
    private static final AtomicReferenceFieldUpdater zze;

    static {
        zzuy.zzb.zza = AtomicReferenceFieldUpdater.newUpdater(zzuy.zze.class, Thread.class, "thread");
        zzuy.zzb.zzb = AtomicReferenceFieldUpdater.newUpdater(zzuy.zze.class, zzuy.zze.class, "next");
        zzuy.zzb.zzc = AtomicReferenceFieldUpdater.newUpdater(zzuy.class, zzuy.zze.class, "waitersField");
        zzuy.zzb.zzd = AtomicReferenceFieldUpdater.newUpdater(zzuy.class, zzux.zzd.class, "listenersField");
        zzuy.zzb.zze = AtomicReferenceFieldUpdater.newUpdater(zzuy.class, Object.class, "valueField");
    }

    private zzuy.zzb() {
        throw null;
    }

    public zzuy.zzb(zzvc zzvc0) {
        super(null);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final zzux.zzd zza(zzuy zzuy0, zzux.zzd zzux$zzd0) {
        return (zzux.zzd)zzuy.zzb.zzd.getAndSet(zzuy0, zzux$zzd0);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final zzuy.zze zzb(zzuy zzuy0, zzuy.zze zzuy$zze0) {
        return (zzuy.zze)zzuy.zzb.zzc.getAndSet(zzuy0, zzuy$zze0);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final void zzc(zzuy.zze zzuy$zze0, zzuy.zze zzuy$zze1) {
        zzuy.zzb.zzb.lazySet(zzuy$zze0, zzuy$zze1);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final void zzd(zzuy.zze zzuy$zze0, Thread thread0) {
        zzuy.zzb.zza.lazySet(zzuy$zze0, thread0);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final boolean zze(zzuy zzuy0, zzux.zzd zzux$zzd0, zzux.zzd zzux$zzd1) {
        return zzuz.zza(zzuy.zzb.zzd, zzuy0, zzux$zzd0, zzux$zzd1);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final boolean zzf(zzuy zzuy0, Object object0, Object object1) {
        return zzuz.zza(zzuy.zzb.zze, zzuy0, object0, object1);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final boolean zzg(zzuy zzuy0, zzuy.zze zzuy$zze0, zzuy.zze zzuy$zze1) {
        return zzuz.zza(zzuy.zzb.zzc, zzuy0, zzuy$zze0, zzuy$zze1);
    }
}

