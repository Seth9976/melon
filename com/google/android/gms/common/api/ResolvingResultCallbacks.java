package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

public abstract class ResolvingResultCallbacks extends ResultCallbacks {
    private final Activity zza;
    private final int zzb;

    public ResolvingResultCallbacks(Activity activity0, int v) {
        Preconditions.checkNotNull(activity0, "Activity must not be null");
        this.zza = activity0;
        this.zzb = v;
    }

    @Override  // com.google.android.gms.common.api.ResultCallbacks
    @KeepForSdk
    public final void onFailure(Status status0) {
        if(status0.hasResolution()) {
            try {
                status0.startResolutionForResult(this.zza, this.zzb);
            }
            catch(IntentSender.SendIntentException intentSender$SendIntentException0) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", intentSender$SendIntentException0);
                this.onUnresolvableFailure(new Status(8));
            }
            return;
        }
        this.onUnresolvableFailure(status0);
    }

    @Override  // com.google.android.gms.common.api.ResultCallbacks
    public abstract void onSuccess(Result arg1);

    public abstract void onUnresolvableFailure(Status arg1);
}

