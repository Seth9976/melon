package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public interface IMediaSession extends IInterface {
    public static class Default implements IMediaSession {
        @Override  // android.support.v4.media.session.IMediaSession
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void adjustVolume(int v, int v1, String s) {
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void fastForward() {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public Bundle getExtras() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public long getFlags() {
            return 0L;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public PendingIntent getLaunchPendingIntent() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public MediaMetadataCompat getMetadata() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public String getPackageName() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public PlaybackStateCompat getPlaybackState() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public List getQueue() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public CharSequence getQueueTitle() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public int getRatingType() {
            return 0;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public int getRepeatMode() {
            return 0;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public Bundle getSessionInfo() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public int getShuffleMode() {
            return 0;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public String getTag() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public ParcelableVolumeInfo getVolumeAttributes() {
            return null;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public boolean isCaptioningEnabled() {
            return false;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public boolean isShuffleModeEnabledRemoved() {
            return false;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public boolean isTransportControlEnabled() {
            return false;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void next() {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void pause() {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void play() {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void playFromMediaId(String s, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void playFromSearch(String s, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void playFromUri(Uri uri0, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void prepare() {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void prepareFromMediaId(String s, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void prepareFromSearch(String s, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void prepareFromUri(Uri uri0, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void previous() {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void rate(RatingCompat ratingCompat0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void rateWithExtras(RatingCompat ratingCompat0, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void removeQueueItemAt(int v) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void rewind() {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void seekTo(long v) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void sendCommand(String s, Bundle bundle0, ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void sendCustomAction(String s, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public boolean sendMediaButton(KeyEvent keyEvent0) {
            return false;
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void setCaptioningEnabled(boolean z) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void setPlaybackSpeed(float f) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void setRepeatMode(int v) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void setShuffleMode(int v) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void setShuffleModeEnabledRemoved(boolean z) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void setVolumeTo(int v, int v1, String s) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void skipToQueueItem(long v) {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void stop() {
        }

        @Override  // android.support.v4.media.session.IMediaSession
        public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
        }
    }

    public static abstract class Stub extends Binder implements IMediaSession {
        static class Proxy implements IMediaSession {
            private IBinder mRemote;

            public Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    _Parcel.writeTypedObject(parcel0, mediaDescriptionCompat0, 0);
                    this.mRemote.transact(41, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    _Parcel.writeTypedObject(parcel0, mediaDescriptionCompat0, 0);
                    parcel0.writeInt(v);
                    this.mRemote.transact(42, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int v, int v1, String s) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    parcel0.writeInt(v1);
                    parcel0.writeString(s);
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void fastForward() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(22, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(0x1F, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (Bundle)_Parcel.readTypedObject(parcel1, Bundle.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readLong();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.support.v4.media.session.IMediaSession";
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (PendingIntent)_Parcel.readTypedObject(parcel1, PendingIntent.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(27, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (MediaMetadataCompat)_Parcel.readTypedObject(parcel1, MediaMetadataCompat.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(28, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (PlaybackStateCompat)_Parcel.readTypedObject(parcel1, PlaybackStateCompat.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public List getQueue() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(29, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createTypedArrayList(QueueItem.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(30, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (CharSequence)_Parcel.readTypedObject(parcel1, TextUtils.CHAR_SEQUENCE_CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(0x20, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(37, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public Bundle getSessionInfo() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(50, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (Bundle)_Parcel.readTypedObject(parcel1, Bundle.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(0x2F, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getTag() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                    return (ParcelableVolumeInfo)_Parcel.readTypedObject(parcel1, ParcelableVolumeInfo.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    this.mRemote.transact(45, parcel0, parcel1, 0);
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

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    this.mRemote.transact(38, parcel0, parcel1, 0);
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

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    this.mRemote.transact(5, parcel0, parcel1, 0);
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

            @Override  // android.support.v4.media.session.IMediaSession
            public void next() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(20, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void pause() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void play() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(14, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    _Parcel.writeTypedObject(parcel0, uri0, 0);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepare() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(33, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(34, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(35, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    _Parcel.writeTypedObject(parcel0, uri0, 0);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(36, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void previous() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(21, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    _Parcel.writeTypedObject(parcel0, ratingCompat0, 0);
                    this.mRemote.transact(25, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat0, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    _Parcel.writeTypedObject(parcel0, ratingCompat0, 0);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(51, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeStrongInterface(iMediaControllerCallback0);
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    _Parcel.writeTypedObject(parcel0, mediaDescriptionCompat0, 0);
                    this.mRemote.transact(43, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    this.mRemote.transact(44, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rewind() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(23, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void seekTo(long v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeLong(v);
                    this.mRemote.transact(24, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCommand(String s, Bundle bundle0, ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    _Parcel.writeTypedObject(parcel0, mediaSessionCompat$ResultReceiverWrapper0, 0);
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String s, Bundle bundle0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    _Parcel.writeTypedObject(parcel0, bundle0, 0);
                    this.mRemote.transact(26, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    _Parcel.writeTypedObject(parcel0, keyEvent0, 0);
                    this.mRemote.transact(2, parcel0, parcel1, 0);
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

            @Override  // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(((int)z));
                    this.mRemote.transact(46, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setPlaybackSpeed(float f) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeFloat(f);
                    this.mRemote.transact(49, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    this.mRemote.transact(39, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    this.mRemote.transact(0x30, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(((int)z));
                    this.mRemote.transact(40, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int v, int v1, String s) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    parcel0.writeInt(v1);
                    parcel0.writeString(s);
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long v) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeLong(v);
                    this.mRemote.transact(17, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void stop() {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(19, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeStrongInterface(iMediaControllerCallback0);
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_addQueueItem = 41;
        static final int TRANSACTION_addQueueItemAt = 42;
        static final int TRANSACTION_adjustVolume = 11;
        static final int TRANSACTION_fastForward = 22;
        static final int TRANSACTION_getExtras = 0x1F;
        static final int TRANSACTION_getFlags = 9;
        static final int TRANSACTION_getLaunchPendingIntent = 8;
        static final int TRANSACTION_getMetadata = 27;
        static final int TRANSACTION_getPackageName = 6;
        static final int TRANSACTION_getPlaybackState = 28;
        static final int TRANSACTION_getQueue = 29;
        static final int TRANSACTION_getQueueTitle = 30;
        static final int TRANSACTION_getRatingType = 0x20;
        static final int TRANSACTION_getRepeatMode = 37;
        static final int TRANSACTION_getSessionInfo = 50;
        static final int TRANSACTION_getShuffleMode = 0x2F;
        static final int TRANSACTION_getTag = 7;
        static final int TRANSACTION_getVolumeAttributes = 10;
        static final int TRANSACTION_isCaptioningEnabled = 45;
        static final int TRANSACTION_isShuffleModeEnabledRemoved = 38;
        static final int TRANSACTION_isTransportControlEnabled = 5;
        static final int TRANSACTION_next = 20;
        static final int TRANSACTION_pause = 18;
        static final int TRANSACTION_play = 13;
        static final int TRANSACTION_playFromMediaId = 14;
        static final int TRANSACTION_playFromSearch = 15;
        static final int TRANSACTION_playFromUri = 16;
        static final int TRANSACTION_prepare = 33;
        static final int TRANSACTION_prepareFromMediaId = 34;
        static final int TRANSACTION_prepareFromSearch = 35;
        static final int TRANSACTION_prepareFromUri = 36;
        static final int TRANSACTION_previous = 21;
        static final int TRANSACTION_rate = 25;
        static final int TRANSACTION_rateWithExtras = 51;
        static final int TRANSACTION_registerCallbackListener = 3;
        static final int TRANSACTION_removeQueueItem = 43;
        static final int TRANSACTION_removeQueueItemAt = 44;
        static final int TRANSACTION_rewind = 23;
        static final int TRANSACTION_seekTo = 24;
        static final int TRANSACTION_sendCommand = 1;
        static final int TRANSACTION_sendCustomAction = 26;
        static final int TRANSACTION_sendMediaButton = 2;
        static final int TRANSACTION_setCaptioningEnabled = 46;
        static final int TRANSACTION_setPlaybackSpeed = 49;
        static final int TRANSACTION_setRepeatMode = 39;
        static final int TRANSACTION_setShuffleMode = 0x30;
        static final int TRANSACTION_setShuffleModeEnabledRemoved = 40;
        static final int TRANSACTION_setVolumeTo = 12;
        static final int TRANSACTION_skipToQueueItem = 17;
        static final int TRANSACTION_stop = 19;
        static final int TRANSACTION_unregisterCallbackListener = 4;

        public Stub() {
            this.attachInterface(this, "android.support.v4.media.session.IMediaSession");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IMediaSession asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return iInterface0 != null && iInterface0 instanceof IMediaSession ? ((IMediaSession)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v >= 1 && v <= 0xFFFFFF) {
                parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
            }
            if(v == 0x5F4E5446) {
                parcel1.writeString("android.support.v4.media.session.IMediaSession");
                return true;
            }
            boolean z = false;
            switch(v) {
                case 1: {
                    this.sendCommand(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)), ((ResultReceiverWrapper)_Parcel.readTypedObject(parcel0, ResultReceiverWrapper.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 2: {
                    boolean z1 = this.sendMediaButton(((KeyEvent)_Parcel.readTypedObject(parcel0, KeyEvent.CREATOR)));
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z1));
                    return true;
                }
                case 3: {
                    this.registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    parcel1.writeNoException();
                    return true;
                }
                case 4: {
                    this.unregisterCallbackListener(android.support.v4.media.session.IMediaControllerCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    parcel1.writeNoException();
                    return true;
                }
                case 5: {
                    boolean z2 = this.isTransportControlEnabled();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z2));
                    return true;
                }
                case 6: {
                    String s = this.getPackageName();
                    parcel1.writeNoException();
                    parcel1.writeString(s);
                    return true;
                }
                case 7: {
                    String s1 = this.getTag();
                    parcel1.writeNoException();
                    parcel1.writeString(s1);
                    return true;
                }
                case 8: {
                    PendingIntent pendingIntent0 = this.getLaunchPendingIntent();
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, pendingIntent0, 1);
                    return true;
                }
                case 9: {
                    long v2 = this.getFlags();
                    parcel1.writeNoException();
                    parcel1.writeLong(v2);
                    return true;
                }
                case 10: {
                    ParcelableVolumeInfo parcelableVolumeInfo0 = this.getVolumeAttributes();
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, parcelableVolumeInfo0, 1);
                    return true;
                }
                case 11: {
                    this.adjustVolume(parcel0.readInt(), parcel0.readInt(), parcel0.readString());
                    parcel1.writeNoException();
                    return true;
                }
                case 12: {
                    this.setVolumeTo(parcel0.readInt(), parcel0.readInt(), parcel0.readString());
                    parcel1.writeNoException();
                    return true;
                }
                case 13: {
                    this.play();
                    parcel1.writeNoException();
                    return true;
                }
                case 14: {
                    this.playFromMediaId(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 15: {
                    this.playFromSearch(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 16: {
                    this.playFromUri(((Uri)_Parcel.readTypedObject(parcel0, Uri.CREATOR)), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 17: {
                    this.skipToQueueItem(parcel0.readLong());
                    parcel1.writeNoException();
                    return true;
                }
                case 18: {
                    this.pause();
                    parcel1.writeNoException();
                    return true;
                }
                case 19: {
                    this.stop();
                    parcel1.writeNoException();
                    return true;
                }
                case 20: {
                    this.next();
                    parcel1.writeNoException();
                    return true;
                }
                case 21: {
                    this.previous();
                    parcel1.writeNoException();
                    return true;
                }
                case 22: {
                    this.fastForward();
                    parcel1.writeNoException();
                    return true;
                }
                case 23: {
                    this.rewind();
                    parcel1.writeNoException();
                    return true;
                }
                case 24: {
                    this.seekTo(parcel0.readLong());
                    parcel1.writeNoException();
                    return true;
                }
                case 25: {
                    this.rate(((RatingCompat)_Parcel.readTypedObject(parcel0, RatingCompat.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 26: {
                    this.sendCustomAction(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 27: {
                    MediaMetadataCompat mediaMetadataCompat0 = this.getMetadata();
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, mediaMetadataCompat0, 1);
                    return true;
                }
                case 28: {
                    PlaybackStateCompat playbackStateCompat0 = this.getPlaybackState();
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, playbackStateCompat0, 1);
                    return true;
                }
                case 29: {
                    List list0 = this.getQueue();
                    parcel1.writeNoException();
                    _Parcel.writeTypedList(parcel1, list0, 1);
                    return true;
                }
                case 30: {
                    CharSequence charSequence0 = this.getQueueTitle();
                    parcel1.writeNoException();
                    if(charSequence0 != null) {
                        parcel1.writeInt(1);
                        TextUtils.writeToParcel(charSequence0, parcel1, 1);
                        return true;
                    }
                    parcel1.writeInt(0);
                    return true;
                }
                case 0x1F: {
                    Bundle bundle0 = this.getExtras();
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, bundle0, 1);
                    return true;
                }
                case 0x20: {
                    int v3 = this.getRatingType();
                    parcel1.writeNoException();
                    parcel1.writeInt(v3);
                    return true;
                }
                case 33: {
                    this.prepare();
                    parcel1.writeNoException();
                    return true;
                }
                case 34: {
                    this.prepareFromMediaId(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 35: {
                    this.prepareFromSearch(parcel0.readString(), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 36: {
                    this.prepareFromUri(((Uri)_Parcel.readTypedObject(parcel0, Uri.CREATOR)), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 37: {
                    int v4 = this.getRepeatMode();
                    parcel1.writeNoException();
                    parcel1.writeInt(v4);
                    return true;
                }
                case 38: {
                    boolean z3 = this.isShuffleModeEnabledRemoved();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z3));
                    return true;
                }
                case 39: {
                    this.setRepeatMode(parcel0.readInt());
                    parcel1.writeNoException();
                    return true;
                }
                case 40: {
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.setShuffleModeEnabledRemoved(z);
                    parcel1.writeNoException();
                    return true;
                }
                case 41: {
                    this.addQueueItem(((MediaDescriptionCompat)_Parcel.readTypedObject(parcel0, MediaDescriptionCompat.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 42: {
                    this.addQueueItemAt(((MediaDescriptionCompat)_Parcel.readTypedObject(parcel0, MediaDescriptionCompat.CREATOR)), parcel0.readInt());
                    parcel1.writeNoException();
                    return true;
                }
                case 43: {
                    this.removeQueueItem(((MediaDescriptionCompat)_Parcel.readTypedObject(parcel0, MediaDescriptionCompat.CREATOR)));
                    parcel1.writeNoException();
                    return true;
                }
                case 44: {
                    this.removeQueueItemAt(parcel0.readInt());
                    parcel1.writeNoException();
                    return true;
                }
                case 45: {
                    boolean z4 = this.isCaptioningEnabled();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z4));
                    return true;
                }
                case 46: {
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.setCaptioningEnabled(z);
                    parcel1.writeNoException();
                    return true;
                }
                case 0x2F: {
                    int v5 = this.getShuffleMode();
                    parcel1.writeNoException();
                    parcel1.writeInt(v5);
                    return true;
                }
                case 0x30: {
                    this.setShuffleMode(parcel0.readInt());
                    parcel1.writeNoException();
                    return true;
                }
                case 49: {
                    this.setPlaybackSpeed(parcel0.readFloat());
                    parcel1.writeNoException();
                    return true;
                }
                case 50: {
                    Bundle bundle1 = this.getSessionInfo();
                    parcel1.writeNoException();
                    _Parcel.writeTypedObject(parcel1, bundle1, 1);
                    return true;
                }
                case 51: {
                    this.rateWithExtras(((RatingCompat)_Parcel.readTypedObject(parcel0, RatingCompat.CREATOR)), ((Bundle)_Parcel.readTypedObject(parcel0, Bundle.CREATOR)));
                    parcel1.writeNoException();
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

    public static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";

    void addQueueItem(MediaDescriptionCompat arg1);

    void addQueueItemAt(MediaDescriptionCompat arg1, int arg2);

    void adjustVolume(int arg1, int arg2, String arg3);

    void fastForward();

    Bundle getExtras();

    long getFlags();

    PendingIntent getLaunchPendingIntent();

    MediaMetadataCompat getMetadata();

    String getPackageName();

    PlaybackStateCompat getPlaybackState();

    List getQueue();

    CharSequence getQueueTitle();

    int getRatingType();

    int getRepeatMode();

    Bundle getSessionInfo();

    int getShuffleMode();

    String getTag();

    ParcelableVolumeInfo getVolumeAttributes();

    boolean isCaptioningEnabled();

    boolean isShuffleModeEnabledRemoved();

    boolean isTransportControlEnabled();

    void next();

    void pause();

    void play();

    void playFromMediaId(String arg1, Bundle arg2);

    void playFromSearch(String arg1, Bundle arg2);

    void playFromUri(Uri arg1, Bundle arg2);

    void prepare();

    void prepareFromMediaId(String arg1, Bundle arg2);

    void prepareFromSearch(String arg1, Bundle arg2);

    void prepareFromUri(Uri arg1, Bundle arg2);

    void previous();

    void rate(RatingCompat arg1);

    void rateWithExtras(RatingCompat arg1, Bundle arg2);

    void registerCallbackListener(IMediaControllerCallback arg1);

    void removeQueueItem(MediaDescriptionCompat arg1);

    void removeQueueItemAt(int arg1);

    void rewind();

    void seekTo(long arg1);

    void sendCommand(String arg1, Bundle arg2, ResultReceiverWrapper arg3);

    void sendCustomAction(String arg1, Bundle arg2);

    boolean sendMediaButton(KeyEvent arg1);

    void setCaptioningEnabled(boolean arg1);

    void setPlaybackSpeed(float arg1);

    void setRepeatMode(int arg1);

    void setShuffleMode(int arg1);

    void setShuffleModeEnabledRemoved(boolean arg1);

    void setVolumeTo(int arg1, int arg2, String arg3);

    void skipToQueueItem(long arg1);

    void stop();

    void unregisterCallbackListener(IMediaControllerCallback arg1);
}

