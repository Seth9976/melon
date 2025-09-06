package com.google.android.gms.internal.cast;

import android.app.Activity;
import com.google.android.gms.cast.framework.internal.featurehighlight.zzg;
import com.google.android.gms.cast.framework.internal.featurehighlight.zzh;
import com.google.android.gms.cast.framework.zzbf;

final class zzar implements zzg {
    final Activity zza;
    final zzh zzb;
    final zzas zzc;

    public zzar(zzas zzas0, Activity activity0, zzh zzh0) {
        this.zza = activity0;
        this.zzb = zzh0;
        this.zzc = zzas0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.internal.featurehighlight.zzg
    public final void zza() {
        if(!zzas.zzc(this.zzc)) {
            return;
        }
        zzbf.zza(this.zza);
        zzaq zzaq0 = new zzaq(this, this.zza);
        this.zzb.zzh(zzaq0);
    }

    @Override  // com.google.android.gms.cast.framework.internal.featurehighlight.zzg
    public final void zzb() {
        if(!this.zzc.zzf) {
            return;
        }
        zzbf.zza(this.zza);
        zzap zzap0 = new zzap(this, this.zza);
        this.zzb.zzg(zzap0);
    }
}

