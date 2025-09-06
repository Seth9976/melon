package androidx.media3.session.legacy;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.media3.session.W;
import java.lang.ref.WeakReference;
import java.util.List;

public final class D extends Binder implements d {
    public final WeakReference a;
    public static final int b;

    public D(W w0) {
        this.attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        this.a = new WeakReference(w0);
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onExtrasChanged(Bundle bundle0) {
        throw new AssertionError();
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onQueueChanged(List list0) {
        throw new AssertionError();
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onQueueTitleChanged(CharSequence charSequence0) {
        throw new AssertionError();
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onRepeatModeChanged(int v) {
        W w0 = (W)this.a.get();
        if(w0 != null) {
            w0.i(9, v, null);
        }
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onSessionDestroyed() {
        throw new AssertionError();
    }

    @Override  // androidx.media3.session.legacy.d
    public final void onShuffleModeChanged(int v) {
        W w0 = (W)this.a.get();
        if(w0 != null) {
            w0.i(12, v, null);
        }
    }

    @Override  // android.os.Binder
    public final boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v != 0x5F4E5446) {
            WeakReference weakReference0 = this.a;
            Bundle bundle0 = null;
            switch(v) {
                case 1: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    String s = parcel0.readString();
                    if(parcel0.readInt() != 0) {
                        bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                    }
                    W w0 = (W)weakReference0.get();
                    if(w0 != null) {
                        w0.i(1, s, bundle0);
                        return true;
                    }
                    break;
                }
                case 2: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onSessionDestroyed();
                    return true;
                }
                case 3: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(parcel0.readInt() != 0) {
                        bundle0 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel0);
                    }
                    this.t(((PlaybackStateCompat)bundle0));
                    return true;
                }
                case 4: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(parcel0.readInt() != 0) {
                        bundle0 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel0);
                    }
                    this.r(((MediaMetadataCompat)bundle0));
                    return true;
                }
                case 5: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onQueueChanged(parcel0.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                    return true;
                }
                case 6: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(parcel0.readInt() != 0) {
                        bundle0 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
                    }
                    this.onQueueTitleChanged(((CharSequence)bundle0));
                    return true;
                }
                case 7: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(parcel0.readInt() != 0) {
                        bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                    }
                    this.onExtrasChanged(bundle0);
                    return true;
                }
                case 8: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if(parcel0.readInt() != 0) {
                        bundle0 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel0);
                    }
                    this.z(((ParcelableVolumeInfo)bundle0));
                    return true;
                }
                case 9: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onRepeatModeChanged(parcel0.readInt());
                    return true;
                }
                case 10: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.readInt();
                    return true;
                }
                case 11: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    boolean z = parcel0.readInt() != 0;
                    W w1 = (W)weakReference0.get();
                    if(w1 != null) {
                        w1.i(11, Boolean.valueOf(z), null);
                        return true;
                    }
                    break;
                }
                case 12: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onShuffleModeChanged(parcel0.readInt());
                    return true;
                }
                case 13: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    W w2 = (W)weakReference0.get();
                    if(w2 != null) {
                        w2.i(13, null, null);
                        return true;
                    }
                    break;
                }
                default: {
                    return super.onTransact(v, parcel0, parcel1, v1);
                }
            }
            return true;
        }
        parcel1.getClass();
        parcel1.writeString("android.support.v4.media.session.IMediaControllerCallback");
        return true;
    }

    @Override  // androidx.media3.session.legacy.d
    public final void r(MediaMetadataCompat mediaMetadataCompat0) {
        throw new AssertionError();
    }

    @Override  // androidx.media3.session.legacy.d
    public final void t(PlaybackStateCompat playbackStateCompat0) {
        W w0 = (W)this.a.get();
        if(w0 != null) {
            w0.i(2, playbackStateCompat0, null);
        }
    }

    @Override  // androidx.media3.session.legacy.d
    public final void z(ParcelableVolumeInfo parcelableVolumeInfo0) {
        throw new AssertionError();
    }
}

