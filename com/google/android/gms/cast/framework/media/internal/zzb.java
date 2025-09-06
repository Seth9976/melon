package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.common.internal.Preconditions;

public final class zzb {
    private final Context zza;
    private final ImageHints zzb;
    private Uri zzc;
    private zze zzd;
    private Bitmap zze;
    private boolean zzf;
    private zza zzg;

    public zzb(Context context0) {
        this(context0, new ImageHints(-1, 0, 0));
    }

    public zzb(Context context0, ImageHints imageHints0) {
        this.zza = context0;
        this.zzb = imageHints0;
        this.zze();
    }

    public final void zza() {
        this.zze();
        this.zzg = null;
    }

    public final void zzb(Bitmap bitmap0) {
        this.zze = bitmap0;
        this.zzf = true;
        zza zza0 = this.zzg;
        if(zza0 != null) {
            zza0.zza(bitmap0);
        }
        this.zzd = null;
    }

    public final void zzc(zza zza0) {
        this.zzg = zza0;
    }

    public final boolean zzd(Uri uri0) {
        if(uri0 == null) {
            this.zze();
            return true;
        }
        if(!uri0.equals(this.zzc)) {
            this.zze();
            this.zzc = uri0;
            ImageHints imageHints0 = this.zzb;
            this.zzd = imageHints0.getWidthInPixels() == 0 || imageHints0.getHeightInPixels() == 0 ? new zze(this.zza, 0, 0, false, 0x200000L, 5, 333, 10000, this) : new zze(this.zza, imageHints0.getWidthInPixels(), imageHints0.getHeightInPixels(), false, 0x200000L, 5, 333, 10000, this);
            zze zze0 = (zze)Preconditions.checkNotNull(this.zzd);
            Uri[] arr_uri = {((Uri)Preconditions.checkNotNull(this.zzc))};
            zze0.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, arr_uri);
            return false;
        }
        return this.zzf;
    }

    private final void zze() {
        zze zze0 = this.zzd;
        if(zze0 != null) {
            zze0.cancel(true);
            this.zzd = null;
        }
        this.zzc = null;
        this.zze = null;
        this.zzf = false;
    }
}

