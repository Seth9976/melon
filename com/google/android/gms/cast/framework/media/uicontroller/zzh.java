package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.framework.media.widget.zzd;

final class zzh extends zzd {
    final UIMediaController zza;

    public zzh(UIMediaController uIMediaController0) {
        this.zza = uIMediaController0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.zzd
    public final void zza(CastSeekBar castSeekBar0, int v, boolean z) {
        this.zza.zzc(castSeekBar0, v, z);
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.zzd
    public final void zzb(CastSeekBar castSeekBar0) {
        this.zza.zzd(castSeekBar0);
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.zzd
    public final void zzc(CastSeekBar castSeekBar0) {
        this.zza.zze(castSeekBar0);
    }
}

