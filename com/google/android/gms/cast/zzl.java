package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzae;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzl extends zzae {
    final String zza;

    public zzl(zzm zzm0, GoogleApiClient googleApiClient0, String s) {
        this.zza = s;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.internal.zzae
    public final void doExecute(AnyClient api$AnyClient0) {
        this.zza(((zzx)api$AnyClient0));
    }

    @Override  // com.google.android.gms.cast.internal.zzae
    public final void zza(zzx zzx0) {
        String s = this.zza;
        if(!TextUtils.isEmpty(s)) {
            try {
                zzx0.zzV(s, this);
            }
            catch(IllegalStateException unused_ex) {
                this.zzc(2001);
            }
            return;
        }
        this.setResult(new Status(2001, "IllegalArgument: sessionId cannot be null or empty", null));
    }
}

