package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzki implements Runnable {
    final Bundle zza;
    final zzli zzb;

    public zzki(zzli zzli0, Bundle bundle0) {
        this.zza = bundle0;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override
    public final void run() {
        zzbg zzbg0;
        zzli zzli0 = this.zzb;
        zzli0.zzg();
        zzli0.zzb();
        Bundle bundle0 = this.zza;
        Preconditions.checkNotNull(bundle0);
        String s = Preconditions.checkNotEmpty(bundle0.getString("name"));
        if(!zzli0.zzu.zzB()) {
            zzli0.zzu.zzaV().zzk().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzpk zzpk0 = new zzpk(s, 0L, null, "");
        try {
            zzbg0 = zzli0.zzu.zzk().zzac(bundle0.getString("app_id"), bundle0.getString("expired_event_name"), bundle0.getBundle("expired_event_params"), "", bundle0.getLong("creation_timestamp"), true, true);
        }
        catch(IllegalArgumentException unused_ex) {
            return;
        }
        zzah zzah0 = new zzah(bundle0.getString("app_id"), "", zzpk0, bundle0.getLong("creation_timestamp"), bundle0.getBoolean("active"), bundle0.getString("trigger_event_name"), null, bundle0.getLong("trigger_timeout"), null, bundle0.getLong("time_to_live"), zzbg0);
        zzli0.zzu.zzt().zzp(zzah0);
    }
}

