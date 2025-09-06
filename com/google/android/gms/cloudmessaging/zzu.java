package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzu extends zzs {
    public zzu(int v, int v1, Bundle bundle0) {
        super(v, v1, bundle0);
    }

    @Override  // com.google.android.gms.cloudmessaging.zzs
    public final void zza(Bundle bundle0) {
        Bundle bundle1 = bundle0.getBundle("data");
        if(bundle1 == null) {
            bundle1 = Bundle.EMPTY;
        }
        this.zzd(bundle1);
    }

    @Override  // com.google.android.gms.cloudmessaging.zzs
    public final boolean zzb() {
        return false;
    }
}

