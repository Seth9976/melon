package com.google.android.gms.internal.play_billing;

final class zzgn implements zzcw {
    static final zzcw zza;

    static {
        zzgn.zza = new zzgn();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcw
    public final boolean zza(int v) {
        switch(v) {
            case 0: {
                return zzgo.zza != null;
            }
            case 1: {
                return zzgo.zzb != null;
            }
            case 2: {
                return zzgo.zzc != null;
            }
            case 3: {
                return zzgo.zzd != null;
            }
            default: {
                return false;
            }
        }
    }
}

