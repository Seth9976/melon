package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzr extends zzs {
    public zzr(int v, int v1, Bundle bundle0) {
        super(v, v1, bundle0);
    }

    @Override  // com.google.android.gms.cloudmessaging.zzs
    public final void zza(Bundle bundle0) {
        if(bundle0.getBoolean("ack", false)) {
            this.zzd(null);
            return;
        }
        this.zzc(new zzt(4, "Invalid response to one way request", null));
    }

    @Override  // com.google.android.gms.cloudmessaging.zzs
    public final boolean zzb() {
        return true;
    }
}

