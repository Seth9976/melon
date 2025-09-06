package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {
    public static class Default implements IMediaControllerCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onCaptioningEnabledChanged(boolean z) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onEvent(String s, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onExtrasChanged(Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat0) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat0) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onQueueChanged(List list0) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onQueueTitleChanged(CharSequence charSequence0) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onRepeatModeChanged(int v) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onSessionDestroyed() {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onSessionReady() {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onShuffleModeChanged(int v) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onShuffleModeChangedRemoved(boolean z) {
        }

        @Override  // android.support.v4.media.session.IMediaControllerCallback
        public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo0) {
        }
    }

    public static abstract class Stub extends Binder implements IMediaControllerCallback {
        static class Proxy implements IMediaControllerCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.v4.media.session.IMediaControllerCallback";
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeInt(((int)z));
                    this.mRemote.transact(11, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(7, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    _Parcel.writeTypedObject(parcel0, mediaMetadataCompat0, 0);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    _Parcel.writeTypedObject(parcel0, playbackStateCompat0, 0);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List list0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    _Parcel.writeTypedList(parcel0, list0, 0);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(charSequence0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        TextUtils.writeToParcel(charSequence0, parcel0, 0);
                    }
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int v) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeInt(v);
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.mRemote.transact(13, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int v) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeInt(v);
                    this.mRemote.transact(12, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeInt(((int)z));
                    this.mRemote.transact(10, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo0) {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    _Parcel.writeTypedObject(parcel0, parcelableVolumeInfo0, 0);
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onCaptioningEnabledChanged = 11;
        static final int TRANSACTION_onEvent = 1;
        static final int TRANSACTION_onExtrasChanged = 7;
        static final int TRANSACTION_onMetadataChanged = 4;
        static final int TRANSACTION_onPlaybackStateChanged = 3;
        static final int TRANSACTION_onQueueChanged = 5;
        static final int TRANSACTION_onQueueTitleChanged = 6;
        static final int TRANSACTION_onRepeatModeChanged = 9;
        static final int TRANSACTION_onSessionDestroyed = 2;
        static final int TRANSACTION_onSessionReady = 13;
        static final int TRANSACTION_onShuffleModeChanged = 12;
        static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
        static final int TRANSACTION_onVolumeInfoChanged = 8;

        public Stub() {
            this.attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IMediaControllerCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            return iInterface0 != null && iInterface0 instanceof IMediaControllerCallback ? ((IMediaControllerCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            }
            if(v == 0x5F4E5446) {
                parcel1.writeString("android.support.v4.media.session.IMediaControllerCallback");
                return true;
            }
            boolean z = false;
            switch(v) {
                case 1: {
                    this.onEvent(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 2: {
                    this.onSessionDestroyed();
                    return true;
                }
                case 3: {
                    this.onPlaybackStateChanged(((PlaybackStateCompat)_Parcel.readTypedObject(parcel0, PlaybackStateCompat.CREATOR)));
                    return true;
                }
                case 4: {
                    this.onMetadataChanged(((MediaMetadataCompat)_Parcel.readTypedObject(parcel0, MediaMetadataCompat.CREATOR)));
                    return true;
                }
                case 5: {
                    this.onQueueChanged(parcel0.createTypedArrayList(QueueItem.CREATOR));
                    return true;
                }
                case 6: {
                    this.onQueueTitleChanged(((CharSequence)_Parcel.readTypedObject(parcel0, TextUtils.CHAR_SEQUENCE_CREATOR)));
                    return true;
                }
                case 7: {
                    this.onExtrasChanged(((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 8: {
                    this.onVolumeInfoChanged(((ParcelableVolumeInfo)_Parcel.readTypedObject(parcel0, ParcelableVolumeInfo.CREATOR)));
                    return true;
                }
                case 9: {
                    this.onRepeatModeChanged(parcel0.readInt());
                    return true;
                }
                case 10: {
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.onShuffleModeChangedRemoved(z);
                    return true;
                }
                case 11: {
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.onCaptioningEnabledChanged(z);
                    return true;
                }
                case 12: {
                    this.onShuffleModeChanged(parcel0.readInt());
                    return true;
                }
                case 13: {
                    this.onSessionReady();
                    return true;
                }
                default: {
                    return super.onTransact(v, parcel0, parcel1, v1);
                }
            }
        }
    }

    public static class _Parcel {
        private static Object readTypedObject(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
            return parcel0.readInt() == 0 ? null : parcelable$Creator0.createFromParcel(parcel0);
        }

        private static void writeTypedList(Parcel parcel0, List list0, int v) {
            if(list0 == null) {
                parcel0.writeInt(-1);
                return;
            }
            int v1 = list0.size();
            parcel0.writeInt(v1);
            for(int v2 = 0; v2 < v1; ++v2) {
                _Parcel.writeTypedObject(parcel0, ((Parcelable)list0.get(v2)), v);
            }
        }

        private static void writeTypedObject(Parcel parcel0, Parcelable parcelable0, int v) {
            if(parcelable0 != null) {
                parcel0.writeInt(1);
                parcelable0.writeToParcel(parcel0, v);
                return;
            }
            parcel0.writeInt(0);
        }
    }

    public static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";

    void onCaptioningEnabledChanged(boolean arg1);

    void onEvent(String arg1, Bundle arg2);

    void onExtrasChanged(Bundle arg1);

    void onMetadataChanged(MediaMetadataCompat arg1);

    void onPlaybackStateChanged(PlaybackStateCompat arg1);

    void onQueueChanged(List arg1);

    void onQueueTitleChanged(CharSequence arg1);

    void onRepeatModeChanged(int arg1);

    void onSessionDestroyed();

    void onSessionReady();

    void onShuffleModeChanged(int arg1);

    void onShuffleModeChangedRemoved(boolean arg1);

    void onVolumeInfoChanged(ParcelableVolumeInfo arg1);
}

