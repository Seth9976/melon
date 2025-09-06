package com.google.android.gms.cast.framework.media.widget;

import android.view.View.OnClickListener;
import android.view.View;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

final class zzi implements View.OnClickListener {
    final ExpandedControllerActivity zza;

    public zzi(ExpandedControllerActivity expandedControllerActivity0) {
        this.zza = expandedControllerActivity0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        ExpandedControllerActivity expandedControllerActivity0 = this.zza;
        if(expandedControllerActivity0.zzI.isClickable()) {
            RemoteMediaClient remoteMediaClient0 = expandedControllerActivity0.zzj();
            if(remoteMediaClient0 != null) {
                remoteMediaClient0.skipAd();
            }
        }
    }
}

