package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import java.util.List;
import java.util.Objects;

final class zzz {
    final zzad zza;
    private zzhs zzb;
    private Long zzc;
    private long zzd;

    public zzz(zzad zzad0, byte[] arr_b) {
        Objects.requireNonNull(zzad0);
        this.zza = zzad0;
        super();
    }

    public final zzhs zza(String s, zzhs zzhs0) {
        List list0 = zzhs0.zza();
        zzad zzad0 = this.zza;
        zzpf zzpf0 = zzad0.zzg;
        zzpf0.zzp();
        Long long0 = (Long)zzpj.zzI(zzhs0, "_eid");
        if(long0 != null) {
            this.zzc = long0;
            this.zzb = zzhs0;
            zzpf0.zzp();
            long v = (long)(((Long)zzpj.zzJ(zzhs0, "_epc", 0L)));
            this.zzd = v;
            if(v <= 0L) {
                zzad0.zzu.zzaV().zzc().zzb("Complex event with zero extra param count. eventName", "");
            }
            else {
                zzpf0.zzj().zzV(s, ((Long)Preconditions.checkNotNull(long0)), this.zzd, zzhs0);
            }
        }
        zzhr zzhr0 = (zzhr)zzhs0.zzcl();
        zzhr0.zzl("");
        zzhr0.zzi();
        zzhr0.zzh(list0);
        return (zzhs)zzhr0.zzbc();
    }
}

