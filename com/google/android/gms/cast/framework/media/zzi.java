package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzi extends zzc {
    final ImagePicker zza;

    public zzi(ImagePicker imagePicker0, zzj zzj0) {
        this.zza = imagePicker0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zze(MediaMetadata mediaMetadata0, int v) {
        return this.zza.onPickImage(mediaMetadata0, v);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zzf(MediaMetadata mediaMetadata0, ImageHints imageHints0) {
        return this.zza.onPickImage(mediaMetadata0, imageHints0);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzd
    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.zza);
    }
}

