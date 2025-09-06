package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;
import java.util.Objects;

final class zzhm implements zzr {
    final zzhs zza;

    public zzhm(zzhs zzhs0) {
        Objects.requireNonNull(zzhs0);
        this.zza = zzhs0;
        super();
    }

    @Override  // com.google.android.gms.internal.measurement.zzr
    public final void zza(int v, String s, List list0, boolean z, boolean z1) {
        zzgr zzgr0;
        switch(v - 1) {
            case 0: {
                zzgr0 = this.zza.zzu.zzaV().zzj();
                break;
            }
            case 1: {
                if(z) {
                    zzgr0 = this.zza.zzu.zzaV().zzc();
                }
                else if(z1) {
                    zzgr0 = this.zza.zzu.zzaV().zzb();
                }
                else {
                    zzgr0 = this.zza.zzu.zzaV().zzd();
                }
                break;
            }
            case 3: {
                zzgr0 = this.zza.zzu.zzaV().zzk();
                break;
            }
            default: {
                if(v - 1 != 4) {
                    zzgr0 = this.zza.zzu.zzaV().zzi();
                }
                else if(z) {
                    zzgr0 = this.zza.zzu.zzaV().zzf();
                }
                else if(z1) {
                    zzgr0 = this.zza.zzu.zzaV().zze();
                }
                else {
                    zzgr0 = this.zza.zzu.zzaV().zzh();
                }
            }
        }
        int v1 = list0.size();
        if(v1 != 1) {
            switch(v1) {
                case 2: {
                    zzgr0.zzc(s, list0.get(0), list0.get(1));
                    return;
                }
                case 3: {
                    zzgr0.zzd(s, list0.get(0), list0.get(1), list0.get(2));
                    return;
                }
                default: {
                    zzgr0.zza(s);
                    return;
                }
            }
        }
        zzgr0.zzb(s, list0.get(0));
    }
}

