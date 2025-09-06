package com.google.android.gms.cast.framework.media.uicontroller;

import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

final class zzi implements SeekBar.OnSeekBarChangeListener {
    final SeekBar zza;
    final UIMediaController zzb;

    public zzi(UIMediaController uIMediaController0, SeekBar seekBar0) {
        this.zza = seekBar0;
        this.zzb = uIMediaController0;
        super();
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        UIMediaController uIMediaController0 = this.zzb;
        RemoteMediaClient remoteMediaClient0 = uIMediaController0.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession() && remoteMediaClient0.zzw()) {
            if(z) {
                zza zza0 = uIMediaController0.zza;
                if(v < zza0.zzd()) {
                    int v1 = zza0.zzd();
                    this.zza.setProgress(v1);
                    uIMediaController0.onSeekBarProgressChanged(seekBar0, v1, true);
                    return;
                }
            }
            if(z) {
                zza zza1 = uIMediaController0.zza;
                if(v > zza1.zzc()) {
                    int v2 = zza1.zzc();
                    this.zza.setProgress(v2);
                    uIMediaController0.onSeekBarProgressChanged(seekBar0, v2, true);
                    return;
                }
            }
        }
        uIMediaController0.onSeekBarProgressChanged(seekBar0, v, z);
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar0) {
        this.zzb.onSeekBarStartTrackingTouch(seekBar0);
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar0) {
        this.zzb.onSeekBarStopTrackingTouch(seekBar0);
    }
}

