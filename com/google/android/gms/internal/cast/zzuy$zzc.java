package com.google.android.gms.internal.cast;

final class zzuy.zzc extends zzuy.zza {
    private zzuy.zzc() {
        throw null;
    }

    public zzuy.zzc(zzvc zzvc0) {
        super(null);
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final zzux.zzd zza(zzuy zzuy0, zzux.zzd zzux$zzd0) {
        zzux.zzd zzux$zzd1;
        synchronized(zzuy0) {
            zzux$zzd1 = zzuy0.listenersField;
            if(zzux$zzd1 != zzux$zzd0) {
                zzuy0.listenersField = zzux$zzd0;
            }
        }
        return zzux$zzd1;
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final zzuy.zze zzb(zzuy zzuy0, zzuy.zze zzuy$zze0) {
        zzuy.zze zzuy$zze1;
        synchronized(zzuy0) {
            zzuy$zze1 = zzuy0.waitersField;
            if(zzuy$zze1 != zzuy$zze0) {
                zzuy0.waitersField = zzuy$zze0;
            }
        }
        return zzuy$zze1;
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final void zzc(zzuy.zze zzuy$zze0, zzuy.zze zzuy$zze1) {
        zzuy$zze0.next = zzuy$zze1;
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final void zzd(zzuy.zze zzuy$zze0, Thread thread0) {
        zzuy$zze0.thread = thread0;
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final boolean zze(zzuy zzuy0, zzux.zzd zzux$zzd0, zzux.zzd zzux$zzd1) {
        synchronized(zzuy0) {
            if(zzuy0.listenersField == zzux$zzd0) {
                zzuy0.listenersField = zzux$zzd1;
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final boolean zzf(zzuy zzuy0, Object object0, Object object1) {
        synchronized(zzuy0) {
            if(zzuy0.valueField == object0) {
                zzuy0.valueField = object1;
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.cast.zzuy$zza
    public final boolean zzg(zzuy zzuy0, zzuy.zze zzuy$zze0, zzuy.zze zzuy$zze1) {
        synchronized(zzuy0) {
            if(zzuy0.waitersField == zzuy$zze0) {
                zzuy0.waitersField = zzuy$zze1;
                return true;
            }
        }
        return false;
    }
}

