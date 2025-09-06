package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;

public final class zzb extends zza implements zzd {
    public zzb(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.media.IImagePicker");
    }

    @Override  // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zze(MediaMetadata mediaMetadata0, int v) {
        throw null;
    }

    @Override  // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zzf(MediaMetadata mediaMetadata0, ImageHints imageHints0) {
        throw null;
    }

    @Override  // com.google.android.gms.cast.framework.media.zzd
    public final IObjectWrapper zzg() {
        Parcel parcel0 = this.zzb(2, this.zza());
        IObjectWrapper iObjectWrapper0 = Stub.asInterface(parcel0.readStrongBinder());
        parcel0.recycle();
        return iObjectWrapper0;
    }
}

