package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R.attr;
import com.google.android.gms.cast.framework.R.id;
import com.google.android.gms.cast.framework.R.style;
import com.google.android.gms.cast.framework.R.styleable;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;

public final class zzde extends UIController implements ProgressListener {
    private final TextView zza;
    private final ImageView zzb;
    private final zza zzc;

    public zzde(View view0, zza zza0) {
        TextView textView0 = (TextView)view0.findViewById(id.live_indicator_text);
        this.zza = textView0;
        ImageView imageView0 = (ImageView)view0.findViewById(id.live_indicator_dot);
        this.zzb = imageView0;
        this.zzc = zza0;
        TypedArray typedArray0 = imageView0.getContext().obtainStyledAttributes(null, styleable.CastExpandedController, attr.castExpandedControllerStyle, style.CastExpandedController);
        int v = typedArray0.getResourceId(styleable.CastExpandedController_castLiveIndicatorColor, 0);
        typedArray0.recycle();
        int v1 = imageView0.getContext().getResources().getColor(v);
        imageView0.getDrawable().setColorFilter(v1, PorterDuff.Mode.SRC_IN);
        textView0.setVisibility(8);
        imageView0.setVisibility(8);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$ProgressListener
    public final void onProgressUpdated(long v, long v1) {
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.addProgressListener(this, 1000L);
        }
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.removeProgressListener(this);
        }
        super.onSessionEnded();
        this.zza();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        int v = 8;
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession() && remoteMediaClient0.isLiveStream()) {
            boolean z = remoteMediaClient0.zzw() ? this.zzc.zzm() : remoteMediaClient0.isPlaying();
            this.zza.setVisibility(0);
            ImageView imageView0 = this.zzb;
            if(z) {
                v = 0;
            }
            imageView0.setVisibility(v);
            zzp.zzd(zzpb.zzz);
            return;
        }
        this.zza.setVisibility(8);
        this.zzb.setVisibility(8);
    }
}

