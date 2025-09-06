package com.google.android.gms.cast.framework;

import androidx.mediarouter.app.MediaRouteButton;
import androidx.mediarouter.app.s;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zza implements OnSuccessListener {
    public final MediaRouteButton zza;
    public final TaskCompletionSource zzb;

    public zza(MediaRouteButton mediaRouteButton0, s s0, TaskCompletionSource taskCompletionSource0) {
        this.zza = mediaRouteButton0;
        this.zzb = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        CastButtonFactory.zzb(this.zza, null, this.zzb, ((CastContext)object0));
    }
}

