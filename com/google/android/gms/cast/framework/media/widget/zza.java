package com.google.android.gms.cast.framework.media.widget;

public final class zza implements Runnable {
    public final CastSeekBar zza;

    public zza(CastSeekBar castSeekBar0) {
        this.zza = castSeekBar0;
    }

    @Override
    public final void run() {
        this.zza.sendAccessibilityEvent(4);
    }
}

