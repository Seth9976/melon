package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

final class zzpa implements zzpn {
    final zzpf zza;

    public zzpa(zzpf zzpf0) {
        Objects.requireNonNull(zzpf0);
        this.zza = zzpf0;
        super();
    }

    @Override  // com.google.android.gms.measurement.internal.zzpn
    public final void zza(String s, String s1, Bundle bundle0) {
        if(TextUtils.isEmpty(s)) {
            zzpf zzpf0 = this.zza;
            if(zzpf0.zzaw() != null) {
                zzpf0.zzaw().zzaV().zzb().zzb("AppId not known when logging event", s1);
            }
            return;
        }
        this.zza.zzaW().zzj(new zzoz(this, s, s1, bundle0));
    }
}

