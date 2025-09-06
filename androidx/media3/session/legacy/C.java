package androidx.media3.session.legacy;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

public final class c implements d {
    public IBinder a;

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onExtrasChanged(Bundle bundle0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onQueueChanged(List list0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onQueueTitleChanged(CharSequence charSequence0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onRepeatModeChanged(int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcel0.writeInt(v);
            this.a.transact(9, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onSessionDestroyed() {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            this.a.transact(2, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onShuffleModeChanged(int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcel0.writeInt(v);
            this.a.transact(12, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.d
    public final void r(MediaMetadataCompat mediaMetadataCompat0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if(mediaMetadataCompat0 == null) {
                parcel0.writeInt(0);
            }
            else {
                parcel0.writeInt(1);
                parcel0.writeBundle(mediaMetadataCompat0.a);
            }
            this.a.transact(4, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.d
    public final void t(PlaybackStateCompat playbackStateCompat0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if(playbackStateCompat0 == null) {
                parcel0.writeInt(0);
            }
            else {
                parcel0.writeInt(1);
                playbackStateCompat0.writeToParcel(parcel0, 0);
            }
            this.a.transact(3, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.d
    public final void z(ParcelableVolumeInfo parcelableVolumeInfo0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcel0.writeInt(1);
            parcelableVolumeInfo0.writeToParcel(parcel0, 0);
            this.a.transact(8, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }
}

