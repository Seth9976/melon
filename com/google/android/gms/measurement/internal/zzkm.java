package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

final class zzkm implements zzpn {
    final zzli zza;

    public zzkm(zzli zzli0) {
        Objects.requireNonNull(zzli0);
        this.zza = zzli0;
        super();
    }

    @Override  // com.google.android.gms.measurement.internal.zzpn
    public final void zza(String s, String s1, Bundle bundle0) {
        if(!TextUtils.isEmpty(s)) {
            this.zza.zzI("auto", "_err", bundle0, s);
            return;
        }
        this.zza.zzB("auto", "_err", bundle0);
    }
}

