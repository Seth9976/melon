package android.support.v4.media.session;

import P4.a;
import P4.d;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaController.TransportControls;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImplApi26;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MediaControllerCompat {
    public static abstract class Callback implements IBinder.DeathRecipient {
        static class MediaControllerCallbackApi21 extends MediaController.Callback {
            private final WeakReference mCallback;

            public MediaControllerCallbackApi21(Callback mediaControllerCompat$Callback0) {
                this.mCallback = new WeakReference(mediaControllerCompat$Callback0);
            }

            @Override  // android.media.session.MediaController$Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo mediaController$PlaybackInfo0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.onAudioInfoChanged(new PlaybackInfo(mediaController$PlaybackInfo0.getPlaybackType(), new AudioAttributesCompat(new AudioAttributesImplApi26(mediaController$PlaybackInfo0.getAudioAttributes(), 0)), mediaController$PlaybackInfo0.getVolumeControl(), mediaController$PlaybackInfo0.getMaxVolume(), mediaController$PlaybackInfo0.getCurrentVolume()));  // 初始化器: Landroidx/media/AudioAttributesImplApi21;-><init>(Landroid/media/AudioAttributes;I)V
                }
            }

            @Override  // android.media.session.MediaController$Callback
            public void onExtrasChanged(Bundle bundle0) {
                MediaSessionCompat.ensureClassLoader(bundle0);
                boolean z = ((Callback)this.mCallback.get()) == null;
            }

            @Override  // android.media.session.MediaController$Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(mediaMetadata0));
                }
            }

            @Override  // android.media.session.MediaController$Callback
            public void onPlaybackStateChanged(PlaybackState playbackState0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null && mediaControllerCompat$Callback0.mIControllerCallback == null) {
                    mediaControllerCompat$Callback0.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(playbackState0));
                }
            }

            @Override  // android.media.session.MediaController$Callback
            public void onQueueChanged(List list0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.onQueueChanged(QueueItem.fromQueueItemList(list0));
                }
            }

            @Override  // android.media.session.MediaController$Callback
            public void onQueueTitleChanged(CharSequence charSequence0) {
                boolean z = ((Callback)this.mCallback.get()) == null;
            }

            @Override  // android.media.session.MediaController$Callback
            public void onSessionDestroyed() {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.onSessionDestroyed();
                }
            }

            @Override  // android.media.session.MediaController$Callback
            public void onSessionEvent(String s, Bundle bundle0) {
                MediaSessionCompat.ensureClassLoader(bundle0);
                boolean z = ((Callback)this.mCallback.get()) == null;
            }
        }

        class MessageHandler extends Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_SESSION_READY = 13;
            private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_REPEAT_MODE = 9;
            private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
            private static final int MSG_UPDATE_VOLUME = 4;
            boolean mRegistered;

            public MessageHandler(Looper looper0) {
                super(looper0);
                this.mRegistered = false;
            }

            @Override  // android.os.Handler
            public void handleMessage(Message message0) {
                if(this.mRegistered) {
                    switch(message0.what) {
                        case 1: {
                            MediaSessionCompat.ensureClassLoader(message0.getData());
                            return;
                        }
                        case 2: {
                            Callback.this.onPlaybackStateChanged(((PlaybackStateCompat)message0.obj));
                            return;
                        }
                        case 3: {
                            Callback.this.onMetadataChanged(((MediaMetadataCompat)message0.obj));
                            return;
                        }
                        case 4: {
                            return;
                        }
                        case 5: {
                            return;
                        }
                        case 6: {
                            return;
                        }
                        case 7: {
                            MediaSessionCompat.ensureClassLoader(((Bundle)message0.obj));
                            return;
                        }
                        case 8: {
                            Callback.this.onSessionDestroyed();
                            return;
                        }
                        case 9: {
                            return;
                        }
                        case 11: {
                            return;
                        }
                        case 12: {
                            return;
                        }
                        case 13: {
                        }
                    }
                }
            }
        }

        static class StubCompat extends Stub {
            private final WeakReference mCallback;

            public StubCompat(Callback mediaControllerCompat$Callback0) {
                this.mCallback = new WeakReference(mediaControllerCompat$Callback0);
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(11, Boolean.valueOf(z), null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String s, Bundle bundle0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(1, s, bundle0);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(7, bundle0, null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(3, mediaMetadataCompat0, null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(2, playbackStateCompat0, null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List list0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(5, list0, null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(6, charSequence0, null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int v) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(9, v, null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(8, null, null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(13, null, null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int v) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(12, v, null);
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z) {
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo0) {
                Callback mediaControllerCompat$Callback0 = (Callback)this.mCallback.get();
                if(mediaControllerCompat$Callback0 != null) {
                    mediaControllerCompat$Callback0.postToHandler(4, (parcelableVolumeInfo0 == null ? null : new PlaybackInfo(parcelableVolumeInfo0.volumeType, parcelableVolumeInfo0.audioStream, parcelableVolumeInfo0.controlType, parcelableVolumeInfo0.maxVolume, parcelableVolumeInfo0.currentVolume)), null);
                }
            }
        }

        final MediaController.Callback mCallbackFwk;
        MessageHandler mHandler;
        IMediaControllerCallback mIControllerCallback;

        public Callback() {
            this.mCallbackFwk = new MediaControllerCallbackApi21(this);
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            this.postToHandler(8, null, null);
        }

        public IMediaControllerCallback getIControllerCallback() {
            return this.mIControllerCallback;
        }

        public void onAudioInfoChanged(PlaybackInfo mediaControllerCompat$PlaybackInfo0) {
        }

        public void onCaptioningEnabledChanged(boolean z) {
        }

        public void onExtrasChanged(Bundle bundle0) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat0) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat0) {
        }

        public void onQueueChanged(List list0) {
        }

        public void onQueueTitleChanged(CharSequence charSequence0) {
        }

        public void onRepeatModeChanged(int v) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String s, Bundle bundle0) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int v) {
        }

        public void postToHandler(int v, Object object0, Bundle bundle0) {
            MessageHandler mediaControllerCompat$Callback$MessageHandler0 = this.mHandler;
            if(mediaControllerCompat$Callback$MessageHandler0 != null) {
                Message message0 = mediaControllerCompat$Callback$MessageHandler0.obtainMessage(v, object0);
                message0.setData(bundle0);
                message0.sendToTarget();
            }
        }

        public void setHandler(Handler handler0) {
            if(handler0 == null) {
                MessageHandler mediaControllerCompat$Callback$MessageHandler0 = this.mHandler;
                if(mediaControllerCompat$Callback$MessageHandler0 != null) {
                    mediaControllerCompat$Callback$MessageHandler0.mRegistered = false;
                    mediaControllerCompat$Callback$MessageHandler0.removeCallbacksAndMessages(null);
                    this.mHandler = null;
                }
                return;
            }
            MessageHandler mediaControllerCompat$Callback$MessageHandler1 = new MessageHandler(this, handler0.getLooper());
            this.mHandler = mediaControllerCompat$Callback$MessageHandler1;
            mediaControllerCompat$Callback$MessageHandler1.mRegistered = true;
        }
    }

    interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat arg1);

        void addQueueItem(MediaDescriptionCompat arg1, int arg2);

        void adjustVolume(int arg1, int arg2);

        boolean dispatchMediaButtonEvent(KeyEvent arg1);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        Bundle getSessionInfo();

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(Callback arg1, Handler arg2);

        void removeQueueItem(MediaDescriptionCompat arg1);

        void sendCommand(String arg1, Bundle arg2, ResultReceiver arg3);

        void setVolumeTo(int arg1, int arg2);

        void unregisterCallback(Callback arg1);
    }

    static class MediaControllerImplApi21 implements MediaControllerImpl {
        static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference mMediaControllerImpl;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi210) {
                super(null);
                this.mMediaControllerImpl = new WeakReference(mediaControllerCompat$MediaControllerImplApi210);
            }

            @Override  // android.os.ResultReceiver
            public void onReceiveResult(int v, Bundle bundle0) {
                MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi210 = (MediaControllerImplApi21)this.mMediaControllerImpl.get();
                if(mediaControllerCompat$MediaControllerImplApi210 != null && bundle0 != null) {
                    synchronized(mediaControllerCompat$MediaControllerImplApi210.mLock) {
                        IMediaSession iMediaSession0 = android.support.v4.media.session.IMediaSession.Stub.asInterface(bundle0.getBinder("android.support.v4.media.session.EXTRA_BINDER"));
                        mediaControllerCompat$MediaControllerImplApi210.mSessionToken.setExtraBinder(iMediaSession0);
                        d d0 = a.s(bundle0);
                        mediaControllerCompat$MediaControllerImplApi210.mSessionToken.setSession2Token(d0);
                        mediaControllerCompat$MediaControllerImplApi210.processPendingCallbacksLocked();
                    }
                }
            }
        }

        static class ExtraCallback extends StubCompat {
            public ExtraCallback(Callback mediaControllerCompat$Callback0) {
                super(mediaControllerCompat$Callback0);
            }

            @Override  // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat
            public void onExtrasChanged(Bundle bundle0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat
            public void onQueueChanged(List list0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat
            public void onQueueTitleChanged(CharSequence charSequence0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat
            public void onSessionDestroyed() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo0) {
                throw new AssertionError();
            }
        }

        private HashMap mCallbackMap;
        protected final MediaController mControllerFwk;
        final Object mLock;
        private final List mPendingCallbacks;
        protected Bundle mSessionInfo;
        final Token mSessionToken;

        public MediaControllerImplApi21(Context context0, Token mediaSessionCompat$Token0) {
            this.mLock = new Object();
            this.mPendingCallbacks = new ArrayList();
            this.mCallbackMap = new HashMap();
            this.mSessionToken = mediaSessionCompat$Token0;
            this.mControllerFwk = new MediaController(context0, ((MediaSession.Token)mediaSessionCompat$Token0.getToken()));
            if(mediaSessionCompat$Token0.getExtraBinder() == null) {
                this.requestExtraBinder();
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
            if((this.getFlags() & 4L) == 0L) {
                throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
            }
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat0);
            this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", bundle0, null);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
            if((this.getFlags() & 4L) == 0L) {
                throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
            }
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat0);
            bundle0.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", v);
            this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle0, null);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void adjustVolume(int v, int v1) {
            this.mControllerFwk.adjustVolume(v, v1);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent0) {
            return this.mControllerFwk.dispatchMediaButtonEvent(keyEvent0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public Bundle getExtras() {
            return this.mControllerFwk.getExtras();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public long getFlags() {
            return this.mControllerFwk.getFlags();
        }

        public static MediaControllerCompat getMediaController(Activity activity0) {
            MediaController mediaController0 = activity0.getMediaController();
            return mediaController0 == null ? null : new MediaControllerCompat(activity0, Token.fromToken(mediaController0.getSessionToken()));
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public Object getMediaController() {
            return this.mControllerFwk;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            MediaMetadata mediaMetadata0 = this.mControllerFwk.getMetadata();
            return mediaMetadata0 == null ? null : MediaMetadataCompat.fromMediaMetadata(mediaMetadata0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public String getPackageName() {
            return this.mControllerFwk.getPackageName();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            MediaController.PlaybackInfo mediaController$PlaybackInfo0 = this.mControllerFwk.getPlaybackInfo();
            return mediaController$PlaybackInfo0 == null ? null : new PlaybackInfo(mediaController$PlaybackInfo0.getPlaybackType(), new AudioAttributesCompat(new AudioAttributesImplApi26(mediaController$PlaybackInfo0.getAudioAttributes(), 0)), mediaController$PlaybackInfo0.getVolumeControl(), mediaController$PlaybackInfo0.getMaxVolume(), mediaController$PlaybackInfo0.getCurrentVolume());  // 初始化器: Landroidx/media/AudioAttributesImplApi21;-><init>(Landroid/media/AudioAttributes;I)V
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            if(this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getPlaybackState();
                }
                catch(RemoteException remoteException0) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", remoteException0);
                }
            }
            PlaybackState playbackState0 = this.mControllerFwk.getPlaybackState();
            return playbackState0 == null ? null : PlaybackStateCompat.fromPlaybackState(playbackState0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public List getQueue() {
            List list0 = this.mControllerFwk.getQueue();
            return list0 == null ? null : QueueItem.fromQueueItemList(list0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public CharSequence getQueueTitle() {
            return this.mControllerFwk.getQueueTitle();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public int getRatingType() {
            return this.mControllerFwk.getRatingType();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public int getRepeatMode() {
            if(this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getRepeatMode();
                }
                catch(RemoteException remoteException0) {
                    Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", remoteException0);
                }
            }
            return -1;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public PendingIntent getSessionActivity() {
            return this.mControllerFwk.getSessionActivity();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public Bundle getSessionInfo() {
            if(this.mSessionInfo != null) {
                return new Bundle(this.mSessionInfo);
            }
            if(this.mSessionToken.getExtraBinder() != null) {
                try {
                    this.mSessionInfo = this.mSessionToken.getExtraBinder().getSessionInfo();
                }
                catch(RemoteException remoteException0) {
                    Log.e("MediaControllerCompat", "Dead object in getSessionInfo.", remoteException0);
                    this.mSessionInfo = Bundle.EMPTY;
                }
            }
            Bundle bundle0 = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
            this.mSessionInfo = bundle0;
            return bundle0 == null ? Bundle.EMPTY : new Bundle(this.mSessionInfo);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public int getShuffleMode() {
            if(this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().getShuffleMode();
                }
                catch(RemoteException remoteException0) {
                    Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", remoteException0);
                }
            }
            return -1;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public TransportControls getTransportControls() {
            MediaController.TransportControls mediaController$TransportControls0 = this.mControllerFwk.getTransportControls();
            return Build.VERSION.SDK_INT >= 29 ? new TransportControlsApi29(mediaController$TransportControls0) : new TransportControlsApi24(mediaController$TransportControls0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public boolean isCaptioningEnabled() {
            if(this.mSessionToken.getExtraBinder() != null) {
                try {
                    return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
                }
                catch(RemoteException remoteException0) {
                    Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", remoteException0);
                }
            }
            return false;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public boolean isSessionReady() {
            return this.mSessionToken.getExtraBinder() != null;
        }

        public void processPendingCallbacksLocked() {
            if(this.mSessionToken.getExtraBinder() == null) {
                return;
            }
            for(Object object0: this.mPendingCallbacks) {
                ExtraCallback mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0 = new ExtraCallback(((Callback)object0));
                this.mCallbackMap.put(((Callback)object0), mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0);
                ((Callback)object0).mIControllerCallback = mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0;
                try {
                    this.mSessionToken.getExtraBinder().registerCallbackListener(mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0);
                }
                catch(RemoteException remoteException0) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", remoteException0);
                    break;
                }
                ((Callback)object0).postToHandler(13, null, null);
            }
            this.mPendingCallbacks.clear();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public final void registerCallback(Callback mediaControllerCompat$Callback0, Handler handler0) {
            this.mControllerFwk.registerCallback(mediaControllerCompat$Callback0.mCallbackFwk, handler0);
            synchronized(this.mLock) {
                if(this.mSessionToken.getExtraBinder() == null) {
                    mediaControllerCompat$Callback0.mIControllerCallback = null;
                    this.mPendingCallbacks.add(mediaControllerCompat$Callback0);
                }
                else {
                    ExtraCallback mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0 = new ExtraCallback(mediaControllerCompat$Callback0);
                    this.mCallbackMap.put(mediaControllerCompat$Callback0, mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0);
                    mediaControllerCompat$Callback0.mIControllerCallback = mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0;
                    try {
                        this.mSessionToken.getExtraBinder().registerCallbackListener(mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0);
                        mediaControllerCompat$Callback0.postToHandler(13, null, null);
                    }
                    catch(RemoteException remoteException0) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", remoteException0);
                    }
                }
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
            if((this.getFlags() & 4L) == 0L) {
                throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
            }
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", mediaDescriptionCompat0);
            this.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle0, null);
        }

        private void requestExtraBinder() {
            this.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void sendCommand(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
            this.mControllerFwk.sendCommand(s, bundle0, resultReceiver0);
        }

        public static void setMediaController(Activity activity0, MediaControllerCompat mediaControllerCompat0) {
            activity0.setMediaController((mediaControllerCompat0 == null ? null : new MediaController(activity0, ((MediaSession.Token)mediaControllerCompat0.getSessionToken().getToken()))));
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void setVolumeTo(int v, int v1) {
            this.mControllerFwk.setVolumeTo(v, v1);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public final void unregisterCallback(Callback mediaControllerCompat$Callback0) {
            this.mControllerFwk.unregisterCallback(mediaControllerCompat$Callback0.mCallbackFwk);
            synchronized(this.mLock) {
                if(this.mSessionToken.getExtraBinder() == null) {
                    this.mPendingCallbacks.remove(mediaControllerCompat$Callback0);
                }
                else {
                    try {
                        ExtraCallback mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0 = (ExtraCallback)this.mCallbackMap.remove(mediaControllerCompat$Callback0);
                        if(mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0 != null) {
                            mediaControllerCompat$Callback0.mIControllerCallback = null;
                            this.mSessionToken.getExtraBinder().unregisterCallbackListener(mediaControllerCompat$MediaControllerImplApi21$ExtraCallback0);
                        }
                    }
                    catch(RemoteException remoteException0) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", remoteException0);
                    }
                }
            }
        }
    }

    static class MediaControllerImplApi29 extends MediaControllerImplApi21 {
        public MediaControllerImplApi29(Context context0, Token mediaSessionCompat$Token0) {
            super(context0, mediaSessionCompat$Token0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21
        public Bundle getSessionInfo() {
            if(this.mSessionInfo != null) {
                return new Bundle(this.mSessionInfo);
            }
            Bundle bundle0 = this.mControllerFwk.getSessionInfo();
            this.mSessionInfo = bundle0;
            Bundle bundle1 = MediaSessionCompat.unparcelWithClassLoader(bundle0);
            this.mSessionInfo = bundle1;
            return bundle1 == null ? Bundle.EMPTY : new Bundle(this.mSessionInfo);
        }
    }

    static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private Bundle mSessionInfo;
        private TransportControls mTransportControls;

        public MediaControllerImplBase(Token mediaSessionCompat$Token0) {
            this.mBinder = android.support.v4.media.session.IMediaSession.Stub.asInterface(((IBinder)mediaSessionCompat$Token0.getToken()));
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
            try {
                if((this.mBinder.getFlags() & 4L) == 0L) {
                    throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
                }
                this.mBinder.addQueueItem(mediaDescriptionCompat0);
                return;
            }
            catch(RemoteException remoteException0) {
            }
            Log.e("MediaControllerCompat", "Dead object in addQueueItem.", remoteException0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
            try {
                if((this.mBinder.getFlags() & 4L) == 0L) {
                    throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
                }
                this.mBinder.addQueueItemAt(mediaDescriptionCompat0, v);
                return;
            }
            catch(RemoteException remoteException0) {
            }
            Log.e("MediaControllerCompat", "Dead object in addQueueItemAt.", remoteException0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void adjustVolume(int v, int v1) {
            try {
                this.mBinder.adjustVolume(v, v1, null);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in adjustVolume.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent0) {
            if(keyEvent0 == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.mBinder.sendMediaButton(keyEvent0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", remoteException0);
            }
            return false;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public Bundle getExtras() {
            try {
                return this.mBinder.getExtras();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getExtras.", remoteException0);
                return null;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public long getFlags() {
            try {
                return this.mBinder.getFlags();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getFlags.", remoteException0);
                return 0L;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public Object getMediaController() {
            return null;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            try {
                return this.mBinder.getMetadata();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata.", remoteException0);
                return null;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public String getPackageName() {
            try {
                return this.mBinder.getPackageName();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName.", remoteException0);
                return null;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            try {
                ParcelableVolumeInfo parcelableVolumeInfo0 = this.mBinder.getVolumeAttributes();
                return new PlaybackInfo(parcelableVolumeInfo0.volumeType, parcelableVolumeInfo0.audioStream, parcelableVolumeInfo0.controlType, parcelableVolumeInfo0.maxVolume, parcelableVolumeInfo0.currentVolume);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo.", remoteException0);
                return null;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.mBinder.getPlaybackState();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", remoteException0);
                return null;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public List getQueue() {
            try {
                return this.mBinder.getQueue();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getQueue.", remoteException0);
                return null;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public CharSequence getQueueTitle() {
            try {
                return this.mBinder.getQueueTitle();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle.", remoteException0);
                return null;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public int getRatingType() {
            try {
                return this.mBinder.getRatingType();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType.", remoteException0);
                return 0;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public int getRepeatMode() {
            try {
                return this.mBinder.getRepeatMode();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", remoteException0);
                return -1;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public PendingIntent getSessionActivity() {
            try {
                return this.mBinder.getLaunchPendingIntent();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", remoteException0);
                return null;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public Bundle getSessionInfo() {
            try {
                this.mSessionInfo = this.mBinder.getSessionInfo();
            }
            catch(RemoteException remoteException0) {
                Log.d("MediaControllerCompat", "Dead object in getSessionInfo.", remoteException0);
            }
            Bundle bundle0 = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
            this.mSessionInfo = bundle0;
            return bundle0 == null ? Bundle.EMPTY : new Bundle(this.mSessionInfo);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public int getShuffleMode() {
            try {
                return this.mBinder.getShuffleMode();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", remoteException0);
                return -1;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public TransportControls getTransportControls() {
            if(this.mTransportControls == null) {
                this.mTransportControls = new TransportControlsBase(this.mBinder);
            }
            return this.mTransportControls;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public boolean isCaptioningEnabled() {
            try {
                return this.mBinder.isCaptioningEnabled();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", remoteException0);
                return false;
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public boolean isSessionReady() {
            return true;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void registerCallback(Callback mediaControllerCompat$Callback0, Handler handler0) {
            if(mediaControllerCompat$Callback0 == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.mBinder.asBinder().linkToDeath(mediaControllerCompat$Callback0, 0);
                this.mBinder.registerCallbackListener(mediaControllerCompat$Callback0.mIControllerCallback);
                mediaControllerCompat$Callback0.postToHandler(13, null, null);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", remoteException0);
                mediaControllerCompat$Callback0.postToHandler(8, null, null);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
            try {
                if((this.mBinder.getFlags() & 4L) == 0L) {
                    throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
                }
                this.mBinder.removeQueueItem(mediaDescriptionCompat0);
                return;
            }
            catch(RemoteException remoteException0) {
            }
            Log.e("MediaControllerCompat", "Dead object in removeQueueItem.", remoteException0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void sendCommand(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
            try {
                this.mBinder.sendCommand(s, bundle0, (resultReceiver0 == null ? null : new ResultReceiverWrapper(resultReceiver0)));
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void setVolumeTo(int v, int v1) {
            try {
                this.mBinder.setVolumeTo(v, v1, null);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in setVolumeTo.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl
        public void unregisterCallback(Callback mediaControllerCompat$Callback0) {
            if(mediaControllerCompat$Callback0 == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.mBinder.unregisterCallbackListener(mediaControllerCompat$Callback0.mIControllerCallback);
                this.mBinder.asBinder().unlinkToDeath(mediaControllerCompat$Callback0, 0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", remoteException0);
            }
        }
    }

    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final AudioAttributesCompat mAudioAttrsCompat;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        public PlaybackInfo(int v, int v1, int v2, int v3, int v4) {
            AudioAttributes.Builder audioAttributes$Builder0 = new AudioAttributes.Builder();
            audioAttributes$Builder0.setLegacyStreamType(v1);
            this(v, new AudioAttributesCompat(new AudioAttributesImplApi26(audioAttributes$Builder0.build(), 0)), v2, v3, v4);  // 初始化器: Landroidx/media/AudioAttributesImplApi21;-><init>(Landroid/media/AudioAttributes;I)V
        }

        public PlaybackInfo(int v, AudioAttributesCompat audioAttributesCompat0, int v1, int v2, int v3) {
            this.mPlaybackType = v;
            this.mAudioAttrsCompat = audioAttributesCompat0;
            this.mVolumeControl = v1;
            this.mMaxVolume = v2;
            this.mCurrentVolume = v3;
        }

        public AudioAttributesCompat getAudioAttributes() {
            return this.mAudioAttrsCompat;
        }

        @Deprecated
        public int getAudioStream() {
            return this.mAudioAttrsCompat.a.a();
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }
    }

    public static abstract class TransportControls {
        @Deprecated
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String arg1, Bundle arg2);

        public abstract void playFromSearch(String arg1, Bundle arg2);

        public abstract void playFromUri(Uri arg1, Bundle arg2);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String arg1, Bundle arg2);

        public abstract void prepareFromSearch(String arg1, Bundle arg2);

        public abstract void prepareFromUri(Uri arg1, Bundle arg2);

        public abstract void rewind();

        public abstract void seekTo(long arg1);

        public abstract void sendCustomAction(CustomAction arg1, Bundle arg2);

        public abstract void sendCustomAction(String arg1, Bundle arg2);

        public abstract void setCaptioningEnabled(boolean arg1);

        public void setPlaybackSpeed(float f) {
        }

        public abstract void setRating(RatingCompat arg1);

        public abstract void setRating(RatingCompat arg1, Bundle arg2);

        public abstract void setRepeatMode(int arg1);

        public abstract void setShuffleMode(int arg1);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long arg1);

        public abstract void stop();
    }

    static class TransportControlsApi21 extends TransportControls {
        protected final MediaController.TransportControls mControlsFwk;

        public TransportControlsApi21(MediaController.TransportControls mediaController$TransportControls0) {
            this.mControlsFwk = mediaController$TransportControls0;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void fastForward() {
            this.mControlsFwk.fastForward();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void pause() {
            this.mControlsFwk.pause();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void play() {
            this.mControlsFwk.play();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void playFromMediaId(String s, Bundle bundle0) {
            this.mControlsFwk.playFromMediaId(s, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void playFromSearch(String s, Bundle bundle0) {
            this.mControlsFwk.playFromSearch(s, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void playFromUri(Uri uri0, Bundle bundle0) {
            if(uri0 == null || Uri.EMPTY.equals(uri0)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle1 = new Bundle();
            bundle1.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri0);
            bundle1.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle0);
            this.sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle1);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void prepare() {
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void prepareFromMediaId(String s, Bundle bundle0) {
            Bundle bundle1 = new Bundle();
            bundle1.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", s);
            bundle1.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle0);
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle1);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void prepareFromSearch(String s, Bundle bundle0) {
            Bundle bundle1 = new Bundle();
            bundle1.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", s);
            bundle1.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle0);
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle1);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void prepareFromUri(Uri uri0, Bundle bundle0) {
            Bundle bundle1 = new Bundle();
            bundle1.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri0);
            bundle1.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle0);
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle1);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void rewind() {
            this.mControlsFwk.rewind();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void seekTo(long v) {
            this.mControlsFwk.seekTo(v);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void sendCustomAction(CustomAction playbackStateCompat$CustomAction0, Bundle bundle0) {
            MediaControllerCompat.validateCustomAction(playbackStateCompat$CustomAction0.getAction(), bundle0);
            this.mControlsFwk.sendCustomAction(playbackStateCompat$CustomAction0.getAction(), bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void sendCustomAction(String s, Bundle bundle0) {
            MediaControllerCompat.validateCustomAction(s, bundle0);
            this.mControlsFwk.sendCustomAction(s, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setCaptioningEnabled(boolean z) {
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", z);
            this.sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setPlaybackSpeed(float f) {
            if(f == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            Bundle bundle0 = new Bundle();
            bundle0.putFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", f);
            this.sendCustomAction("android.support.v4.media.session.action.SET_PLAYBACK_SPEED", bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setRating(RatingCompat ratingCompat0) {
            Rating rating0 = ratingCompat0 == null ? null : ((Rating)ratingCompat0.getRating());
            this.mControlsFwk.setRating(rating0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setRating(RatingCompat ratingCompat0, Bundle bundle0) {
            Bundle bundle1 = new Bundle();
            bundle1.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", ratingCompat0);
            bundle1.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle0);
            this.sendCustomAction("android.support.v4.media.session.action.SET_RATING", bundle1);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setRepeatMode(int v) {
            Bundle bundle0 = new Bundle();
            bundle0.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", v);
            this.sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setShuffleMode(int v) {
            Bundle bundle0 = new Bundle();
            bundle0.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", v);
            this.sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void skipToNext() {
            this.mControlsFwk.skipToNext();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void skipToPrevious() {
            this.mControlsFwk.skipToPrevious();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void skipToQueueItem(long v) {
            this.mControlsFwk.skipToQueueItem(v);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void stop() {
            this.mControlsFwk.stop();
        }
    }

    static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(MediaController.TransportControls mediaController$TransportControls0) {
            super(mediaController$TransportControls0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21
        public void playFromUri(Uri uri0, Bundle bundle0) {
            this.mControlsFwk.playFromUri(uri0, bundle0);
        }
    }

    static class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(MediaController.TransportControls mediaController$TransportControls0) {
            super(mediaController$TransportControls0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21
        public void prepare() {
            this.mControlsFwk.prepare();
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21
        public void prepareFromMediaId(String s, Bundle bundle0) {
            this.mControlsFwk.prepareFromMediaId(s, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21
        public void prepareFromSearch(String s, Bundle bundle0) {
            this.mControlsFwk.prepareFromSearch(s, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21
        public void prepareFromUri(Uri uri0, Bundle bundle0) {
            this.mControlsFwk.prepareFromUri(uri0, bundle0);
        }
    }

    static class TransportControlsApi29 extends TransportControlsApi24 {
        public TransportControlsApi29(MediaController.TransportControls mediaController$TransportControls0) {
            super(mediaController$TransportControls0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21
        public void setPlaybackSpeed(float f) {
            if(f == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            this.mControlsFwk.setPlaybackSpeed(f);
        }
    }

    static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession iMediaSession0) {
            this.mBinder = iMediaSession0;
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void fastForward() {
            try {
                this.mBinder.fastForward();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in fastForward.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void pause() {
            try {
                this.mBinder.pause();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in pause.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void play() {
            try {
                this.mBinder.play();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in play.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void playFromMediaId(String s, Bundle bundle0) {
            try {
                this.mBinder.playFromMediaId(s, bundle0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in playFromMediaId.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void playFromSearch(String s, Bundle bundle0) {
            try {
                this.mBinder.playFromSearch(s, bundle0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in playFromSearch.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void playFromUri(Uri uri0, Bundle bundle0) {
            try {
                this.mBinder.playFromUri(uri0, bundle0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in playFromUri.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void prepare() {
            try {
                this.mBinder.prepare();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in prepare.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void prepareFromMediaId(String s, Bundle bundle0) {
            try {
                this.mBinder.prepareFromMediaId(s, bundle0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void prepareFromSearch(String s, Bundle bundle0) {
            try {
                this.mBinder.prepareFromSearch(s, bundle0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromSearch.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void prepareFromUri(Uri uri0, Bundle bundle0) {
            try {
                this.mBinder.prepareFromUri(uri0, bundle0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromUri.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void rewind() {
            try {
                this.mBinder.rewind();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in rewind.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void seekTo(long v) {
            try {
                this.mBinder.seekTo(v);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in seekTo.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void sendCustomAction(CustomAction playbackStateCompat$CustomAction0, Bundle bundle0) {
            this.sendCustomAction(playbackStateCompat$CustomAction0.getAction(), bundle0);
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void sendCustomAction(String s, Bundle bundle0) {
            MediaControllerCompat.validateCustomAction(s, bundle0);
            try {
                this.mBinder.sendCustomAction(s, bundle0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in sendCustomAction.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setCaptioningEnabled(boolean z) {
            try {
                this.mBinder.setCaptioningEnabled(z);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in setCaptioningEnabled.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setPlaybackSpeed(float f) {
            if(f == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            try {
                this.mBinder.setPlaybackSpeed(f);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in setPlaybackSpeed.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setRating(RatingCompat ratingCompat0) {
            try {
                this.mBinder.rate(ratingCompat0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setRating(RatingCompat ratingCompat0, Bundle bundle0) {
            try {
                this.mBinder.rateWithExtras(ratingCompat0, bundle0);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setRepeatMode(int v) {
            try {
                this.mBinder.setRepeatMode(v);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in setRepeatMode.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void setShuffleMode(int v) {
            try {
                this.mBinder.setShuffleMode(v);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in setShuffleMode.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void skipToNext() {
            try {
                this.mBinder.next();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void skipToPrevious() {
            try {
                this.mBinder.previous();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void skipToQueueItem(long v) {
            try {
                this.mBinder.skipToQueueItem(v);
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in skipToQueueItem.", remoteException0);
            }
        }

        @Override  // android.support.v4.media.session.MediaControllerCompat$TransportControls
        public void stop() {
            try {
                this.mBinder.stop();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in stop.", remoteException0);
            }
        }
    }

    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final Set mRegisteredCallbacks;
    private final Token mToken;

    public MediaControllerCompat(Context context0, Token mediaSessionCompat$Token0) {
        if(mediaSessionCompat$Token0 == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.mRegisteredCallbacks = Collections.synchronizedSet(new HashSet());
        this.mToken = mediaSessionCompat$Token0;
        if(Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new MediaControllerImplApi29(context0, mediaSessionCompat$Token0);
            return;
        }
        this.mImpl = new MediaControllerImplApi21(context0, mediaSessionCompat$Token0);
    }

    public MediaControllerCompat(Context context0, MediaSessionCompat mediaSessionCompat0) {
        this(context0, mediaSessionCompat0.getSessionToken());
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
        this.mImpl.addQueueItem(mediaDescriptionCompat0);
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
        this.mImpl.addQueueItem(mediaDescriptionCompat0, v);
    }

    public void adjustVolume(int v, int v1) {
        this.mImpl.adjustVolume(v, v1);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent0) {
        if(keyEvent0 == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return this.mImpl.dispatchMediaButtonEvent(keyEvent0);
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public static MediaControllerCompat getMediaController(Activity activity0) {
        Object object0 = activity0.getWindow().getDecorView().getTag(0x7F0A07EF);  // id:media_controller_compat_view_tag
        return object0 instanceof MediaControllerCompat ? ((MediaControllerCompat)object0) : MediaControllerImplApi21.getMediaController(activity0);
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public List getQueue() {
        return this.mImpl.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public d getSession2Token() {
        return this.mToken.getSession2Token();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public Bundle getSessionInfo() {
        return this.mImpl.getSessionInfo();
    }

    public Token getSessionToken() {
        return this.mToken;
    }

    public int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public boolean isSessionReady() {
        return this.mImpl.isSessionReady();
    }

    public void registerCallback(Callback mediaControllerCompat$Callback0) {
        this.registerCallback(mediaControllerCompat$Callback0, null);
    }

    public void registerCallback(Callback mediaControllerCompat$Callback0, Handler handler0) {
        if(mediaControllerCompat$Callback0 == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if(!this.mRegisteredCallbacks.add(mediaControllerCompat$Callback0)) {
            Log.w("MediaControllerCompat", "the callback has already been registered");
            return;
        }
        if(handler0 == null) {
            handler0 = new Handler();
        }
        mediaControllerCompat$Callback0.setHandler(handler0);
        this.mImpl.registerCallback(mediaControllerCompat$Callback0, handler0);
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
        this.mImpl.removeQueueItem(mediaDescriptionCompat0);
    }

    @Deprecated
    public void removeQueueItemAt(int v) {
        List list0 = this.getQueue();
        if(list0 != null && v >= 0 && v < list0.size()) {
            QueueItem mediaSessionCompat$QueueItem0 = (QueueItem)list0.get(v);
            if(mediaSessionCompat$QueueItem0 != null) {
                this.removeQueueItem(mediaSessionCompat$QueueItem0.getDescription());
            }
        }
    }

    public void sendCommand(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("command must neither be null nor empty");
        }
        this.mImpl.sendCommand(s, bundle0, resultReceiver0);
    }

    public static void setMediaController(Activity activity0, MediaControllerCompat mediaControllerCompat0) {
        activity0.getWindow().getDecorView().setTag(0x7F0A07EF, mediaControllerCompat0);  // id:media_controller_compat_view_tag
        MediaControllerImplApi21.setMediaController(activity0, mediaControllerCompat0);
    }

    public void setVolumeTo(int v, int v1) {
        this.mImpl.setVolumeTo(v, v1);
    }

    public void unregisterCallback(Callback mediaControllerCompat$Callback0) {
        if(mediaControllerCompat$Callback0 == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if(!this.mRegisteredCallbacks.remove(mediaControllerCompat$Callback0)) {
            Log.w("MediaControllerCompat", "the callback has never been registered");
            return;
        }
        try {
            this.mImpl.unregisterCallback(mediaControllerCompat$Callback0);
        }
        finally {
            mediaControllerCompat$Callback0.setHandler(null);
        }
    }

    public static void validateCustomAction(String s, Bundle bundle0) {
        if(s != null && (s.equals("android.support.v4.media.session.action.FOLLOW") || s.equals("android.support.v4.media.session.action.UNFOLLOW")) && (bundle0 == null || !bundle0.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE"))) {
            throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + s + ".");
        }
    }
}

