package com.google.android.gms.cast.framework;

import android.view.MenuItem;
import androidx.mediarouter.app.MediaRouteActionProvider;
import androidx.mediarouter.app.s;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zze implements OnSuccessListener {
    public final MediaRouteActionProvider zza;
    public final TaskCompletionSource zzb;
    public final MenuItem zzc;

    public zze(MediaRouteActionProvider mediaRouteActionProvider0, s s0, TaskCompletionSource taskCompletionSource0, MenuItem menuItem0) {
        this.zza = mediaRouteActionProvider0;
        this.zzb = taskCompletionSource0;
        this.zzc = menuItem0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        CastButtonFactory.zza(this.zza, null, this.zzb, this.zzc, ((CastContext)object0));
    }
}

