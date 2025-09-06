package androidx.media3.session.legacy;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.view.KeyEvent;
import java.util.List;

public final class e implements f {
    public IBinder a;

    @Override  // androidx.media3.session.legacy.f
    public final void A0(d d0) {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel0.writeStrongBinder(((D)d0));
            this.a.transact(3, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final void L(String s, Bundle bundle0, MediaSessionCompat.ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void adjustVolume(int v, int v1) {
        throw null;
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void c(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void fastForward() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(22, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final Bundle getExtras() {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final long getFlags() {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final MediaMetadataCompat getMetadata() {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final String getPackageName() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(6, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1.readString();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final PlaybackStateCompat getPlaybackState() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(28, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1.readInt() == 0 ? null : ((PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel1));
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final List getQueue() {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final CharSequence getQueueTitle() {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final int getRatingType() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(0x20, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1.readInt();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final int getRepeatMode() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(37, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1.readInt();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final int getShuffleMode() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(0x2F, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1.readInt();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final ParcelableVolumeInfo getVolumeAttributes() {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final boolean isCaptioningEnabled() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            boolean z = false;
            this.a.transact(45, parcel0, parcel1, 0);
            parcel1.readException();
            if(parcel1.readInt() != 0) {
                z = true;
            }
            return z;
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final void j0(d d0) {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel0.writeStrongBinder(((D)d0));
            this.a.transact(4, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final void k0(MediaDescriptionCompat mediaDescriptionCompat0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void next() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(20, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final void pause() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(18, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final void play() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(13, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final void playFromMediaId(String s, Bundle bundle0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void playFromSearch(String s, Bundle bundle0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void playFromUri(Uri uri0, Bundle bundle0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void prepare() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(33, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final void prepareFromMediaId(String s, Bundle bundle0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void prepareFromSearch(String s, Bundle bundle0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void prepareFromUri(Uri uri0, Bundle bundle0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void previous() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(21, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final void rewind() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(23, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.legacy.f
    public final void seekTo(long v) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void sendCustomAction(String s, Bundle bundle0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final boolean sendMediaButton(KeyEvent keyEvent0) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void setPlaybackSpeed(float f) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void setRepeatMode(int v) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void setShuffleMode(int v) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void setVolumeTo(int v, int v1) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void skipToQueueItem(long v) {
        throw null;
    }

    @Override  // androidx.media3.session.legacy.f
    public final void stop() {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.a.transact(19, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }
}

