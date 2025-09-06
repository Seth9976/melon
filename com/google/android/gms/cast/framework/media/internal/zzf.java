package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzf extends zza implements zzh {
    public zzf(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
    }

    @Override  // com.google.android.gms.cast.framework.media.internal.zzh
    public final Bitmap zze(Uri uri0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, uri0);
        Parcel parcel1 = this.zzb(1, parcel0);
        Bitmap bitmap0 = (Bitmap)zzc.zza(parcel1, Bitmap.CREATOR);
        parcel1.recycle();
        return bitmap0;
    }
}

