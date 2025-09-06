package com.google.android.gms.cast.framework;

import androidx.mediarouter.app.MediaRouteButton;
import androidx.mediarouter.app.s;
import com.google.android.gms.tasks.OnSuccessListener;

public final class zzd implements OnSuccessListener {
    public final MediaRouteButton zza;

    public zzd(MediaRouteButton mediaRouteButton0, s s0) {
        this.zza = mediaRouteButton0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        CastButtonFactory.zzd(this.zza, null, ((Void)object0));
    }
}

