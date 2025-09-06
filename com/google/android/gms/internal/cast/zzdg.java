package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R.attr;
import com.google.android.gms.cast.framework.R.id;
import com.google.android.gms.cast.framework.R.style;
import com.google.android.gms.cast.framework.R.styleable;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.zza;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

public final class zzdg extends zzda {
    private final RelativeLayout zza;
    private final TextView zzb;
    private final CastSeekBar zzc;
    private final zza zzd;

    public zzdg(RelativeLayout relativeLayout0, CastSeekBar castSeekBar0, zza zza0) {
        this.zza = relativeLayout0;
        TextView textView0 = (TextView)relativeLayout0.findViewById(id.tooltip);
        this.zzb = textView0;
        this.zzc = castSeekBar0;
        this.zzd = zza0;
        TypedArray typedArray0 = textView0.getContext().obtainStyledAttributes(null, styleable.CastExpandedController, attr.castExpandedControllerStyle, style.CastExpandedController);
        int v = typedArray0.getResourceId(styleable.CastExpandedController_castSeekBarTooltipBackgroundColor, 0);
        typedArray0.recycle();
        int v1 = textView0.getContext().getResources().getColor(v);
        textView0.getBackground().setColorFilter(v1, PorterDuff.Mode.SRC_IN);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zzd();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        this.zzd();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        super.onSessionEnded();
        this.zzd();
    }

    @Override  // com.google.android.gms.internal.cast.zzda
    public final void zza(boolean z) {
        super.zza(z);
        this.zzd();
    }

    @Override  // com.google.android.gms.internal.cast.zzda
    public final void zzb(long v) {
        this.zzd();
    }

    public final void zzd() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession() && !this.zzc()) {
            this.zza.setVisibility(0);
            long v = (long)this.zzc.getProgress();
            long v1 = this.zzd.zze();
            String s = this.zzd.zzl(v1 + v);
            this.zzb.setText(s);
            int v2 = this.zzc.getMeasuredWidth() - this.zzc.getPaddingLeft() - this.zzc.getPaddingRight();
            int v3 = View.MeasureSpec.makeMeasureSpec(v2, 0x80000000);
            this.zzb.measure(v3, 0);
            int v4 = this.zzb.getMeasuredWidth();
            int v5 = Math.min(Math.max(0, ((int)(((double)this.zzc.getProgress()) / ((double)this.zzc.getMaxProgress()) * ((double)v2))) - v4 / 2), v2 - v4);
            RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = (RelativeLayout.LayoutParams)this.zzb.getLayoutParams();
            relativeLayout$LayoutParams0.leftMargin = v5;
            this.zzb.setLayoutParams(relativeLayout$LayoutParams0);
            return;
        }
        this.zza.setVisibility(8);
    }
}

