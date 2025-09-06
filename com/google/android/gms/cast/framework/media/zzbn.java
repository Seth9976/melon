package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

final class zzbn implements DialogInterface.OnClickListener {
    final zzbq zza;
    final zzbq zzb;
    final TracksChooserDialogFragment zzc;

    public zzbn(TracksChooserDialogFragment tracksChooserDialogFragment0, zzbq zzbq0, zzbq zzbq1) {
        this.zza = zzbq0;
        this.zzb = zzbq1;
        this.zzc = tracksChooserDialogFragment0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        TracksChooserDialogFragment.zzc(this.zzc, this.zza, this.zzb);
    }
}

