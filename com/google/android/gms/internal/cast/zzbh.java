package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.tasks.OnSuccessListener;

public final class zzbh implements OnSuccessListener {
    public final zzbn zza;

    public zzbh(zzbn zzbn0) {
        this.zza = zzbn0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        zzbn.zzc(this.zza, ((SessionState)object0));
    }
}

