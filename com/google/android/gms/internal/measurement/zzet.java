package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzet extends zzeq {
    final Bundle zza;
    final Activity zzb;
    final zzfa zzc;

    public zzet(zzfa zzfa0, Bundle bundle0, Activity activity0) {
        this.zza = bundle0;
        this.zzb = activity0;
        Objects.requireNonNull(zzfa0);
        this.zzc = zzfa0;
        super(zzfa0.zza, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        Bundle bundle1;
        Bundle bundle0 = this.zza;
        if(bundle0 == null) {
            bundle1 = null;
        }
        else {
            bundle1 = new Bundle();
            if(bundle0.containsKey("com.google.app_measurement.screen_service")) {
                Object object0 = bundle0.get("com.google.app_measurement.screen_service");
                if(object0 instanceof Bundle) {
                    bundle1.putBundle("com.google.app_measurement.screen_service", ((Bundle)object0));
                }
            }
        }
        ((zzcr)Preconditions.checkNotNull(this.zzc.zza.zzQ())).onActivityCreatedByScionActivityInfo(zzdf.zza(this.zzb), bundle1, this.zzi);
    }
}

