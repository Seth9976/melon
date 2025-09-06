package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final class zzpb {
    zzid zza;
    List zzb;
    List zzc;
    long zzd;
    final zzpf zze;

    public zzpb(zzpf zzpf0, byte[] arr_b) {
        Objects.requireNonNull(zzpf0);
        this.zze = zzpf0;
        super();
    }

    public final boolean zza(long v, zzhs zzhs0) {
        Preconditions.checkNotNull(zzhs0);
        if(this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if(this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if(!this.zzc.isEmpty() && zzpb.zzb(((zzhs)this.zzc.get(0))) != zzpb.zzb(zzhs0)) {
            return false;
        }
        long v1 = this.zzd + ((long)zzhs0.zzcn());
        zzpf zzpf0 = this.zze;
        if(!zzpf0.zzd().zzp(null, zzfx.zzbe)) {
            zzpf0.zzd();
            if(v1 >= ((long)zzal.zzG())) {
                return false;
            }
        }
        else if(!this.zzc.isEmpty()) {
            zzpf0.zzd();
            if(v1 >= ((long)zzal.zzG())) {
                return false;
            }
        }
        this.zzd = v1;
        this.zzc.add(zzhs0);
        this.zzb.add(v);
        int v2 = this.zzc.size();
        zzpf0.zzd();
        return v2 < Math.max(1, ((int)(((Integer)zzfx.zzj.zzb(null)))));
    }

    private static final long zzb(zzhs zzhs0) {
        return zzhs0.zzf() / 1000L / 60L / 60L;
    }
}

