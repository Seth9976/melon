package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzkh implements Runnable {
    final Bundle zza;
    final zzli zzb;

    public zzkh(zzli zzli0, Bundle bundle0) {
        this.zza = bundle0;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override
    public final void run() {
        zzbg zzbg2;
        zzbg zzbg1;
        zzbg zzbg0;
        zzli zzli0 = this.zzb;
        zzli0.zzg();
        zzli0.zzb();
        Bundle bundle0 = this.zza;
        Preconditions.checkNotNull(bundle0);
        String s = bundle0.getString("name");
        String s1 = bundle0.getString("origin");
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotEmpty(s1);
        Preconditions.checkNotNull(bundle0.get("value"));
        if(!zzli0.zzu.zzB()) {
            zzli0.zzu.zzaV().zzk().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzpk zzpk0 = new zzpk(s, bundle0.getLong("triggered_timestamp"), bundle0.get("value"), s1);
        try {
            zzbg0 = zzli0.zzu.zzk().zzac(bundle0.getString("app_id"), bundle0.getString("triggered_event_name"), bundle0.getBundle("triggered_event_params"), s1, 0L, true, true);
            zzbg1 = zzli0.zzu.zzk().zzac(bundle0.getString("app_id"), bundle0.getString("timed_out_event_name"), bundle0.getBundle("timed_out_event_params"), s1, 0L, true, true);
            zzbg2 = zzli0.zzu.zzk().zzac(bundle0.getString("app_id"), bundle0.getString("expired_event_name"), bundle0.getBundle("expired_event_params"), s1, 0L, true, true);
        }
        catch(IllegalArgumentException unused_ex) {
            return;
        }
        zzah zzah0 = new zzah(bundle0.getString("app_id"), s1, zzpk0, bundle0.getLong("creation_timestamp"), false, bundle0.getString("trigger_event_name"), zzbg1, bundle0.getLong("trigger_timeout"), zzbg0, bundle0.getLong("time_to_live"), zzbg2);
        zzli0.zzu.zzt().zzp(zzah0);
    }
}

