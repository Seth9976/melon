package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

final class zzbm implements DialogInterface.OnClickListener {
    final TracksChooserDialogFragment zza;

    public zzbm(TracksChooserDialogFragment tracksChooserDialogFragment0) {
        this.zza = tracksChooserDialogFragment0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        TracksChooserDialogFragment tracksChooserDialogFragment0 = this.zza;
        if(tracksChooserDialogFragment0.zze != null) {
            tracksChooserDialogFragment0.zze.cancel();
            TracksChooserDialogFragment.zzb(tracksChooserDialogFragment0, null);
        }
    }
}

