package com.google.android.gms.cast.framework.media;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

public final class zzk implements ResultCallback {
    public final MediaQueue zza;

    public zzk(MediaQueue mediaQueue0) {
        this.zza = mediaQueue0;
    }

    @Override  // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result0) {
        this.zza.zzm(((MediaChannelResult)result0));
    }
}

