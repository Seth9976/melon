package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;

final class zzeb implements OnTokenCanceledListener {
    private final ICancelToken zza;

    public zzeb(ICancelToken iCancelToken0) {
        this.zza = iCancelToken0;
    }

    @Override  // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        try {
            this.zza.cancel();
        }
        catch(RemoteException unused_ex) {
        }
    }
}

