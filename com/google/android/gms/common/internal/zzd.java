package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class zzd extends zzz {
    private BaseGmsClient zza;
    private final int zzb;

    public zzd(BaseGmsClient baseGmsClient0, int v) {
        this.zza = baseGmsClient0;
        this.zzb = v;
    }

    @Override  // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int v, IBinder iBinder0, Bundle bundle0) {
        Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zza.onPostInitHandler(v, iBinder0, bundle0, this.zzb);
        this.zza = null;
    }

    @Override  // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzb(int v, Bundle bundle0) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override  // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzc(int v, IBinder iBinder0, zzj zzj0) {
        BaseGmsClient baseGmsClient0 = this.zza;
        Preconditions.checkNotNull(baseGmsClient0, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.checkNotNull(zzj0);
        baseGmsClient0.zzc(zzj0);
        this.onPostInitComplete(v, iBinder0, zzj0.zza);
    }
}

