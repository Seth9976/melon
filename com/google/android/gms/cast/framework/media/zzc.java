package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;

public abstract class zzc extends zzb implements zzd {
    public zzc() {
        super("com.google.android.gms.cast.framework.media.IImagePicker");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                MediaMetadata mediaMetadata0 = (MediaMetadata)com.google.android.gms.internal.cast.zzc.zza(parcel0, MediaMetadata.CREATOR);
                int v2 = parcel0.readInt();
                com.google.android.gms.internal.cast.zzc.zzb(parcel0);
                WebImage webImage0 = this.zze(mediaMetadata0, v2);
                parcel1.writeNoException();
                com.google.android.gms.internal.cast.zzc.zzd(parcel1, webImage0);
                return true;
            }
            case 2: {
                IObjectWrapper iObjectWrapper0 = this.zzg();
                parcel1.writeNoException();
                com.google.android.gms.internal.cast.zzc.zze(parcel1, iObjectWrapper0);
                return true;
            }
            case 3: {
                parcel1.writeNoException();
                parcel1.writeInt(12451000);
                return true;
            }
            case 4: {
                MediaMetadata mediaMetadata1 = (MediaMetadata)com.google.android.gms.internal.cast.zzc.zza(parcel0, MediaMetadata.CREATOR);
                ImageHints imageHints0 = (ImageHints)com.google.android.gms.internal.cast.zzc.zza(parcel0, ImageHints.CREATOR);
                com.google.android.gms.internal.cast.zzc.zzb(parcel0);
                WebImage webImage1 = this.zzf(mediaMetadata1, imageHints0);
                parcel1.writeNoException();
                com.google.android.gms.internal.cast.zzc.zzd(parcel1, webImage1);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

