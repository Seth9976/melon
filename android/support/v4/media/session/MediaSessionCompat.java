package android.support.v4.media.session;

import P4.a;
import P4.d;
import Qc.l;
import X2.q;
import X2.r;
import X2.w;
import X2.x;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.RemoteControlClient.OnMetadataUpdateListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.media.RemoteControlClient;
import android.media.VolumeProvider;
import android.media.session.MediaSession.Callback;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat.Builder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import l4.c;

public class MediaSessionCompat {
    public static abstract class Callback {
        class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            public CallbackHandler(Looper looper0) {
                super(looper0);
            }

            @Override  // android.os.Handler
            public void handleMessage(Message message0) {
                CallbackHandler mediaSessionCompat$Callback$CallbackHandler0;
                MediaSessionImpl mediaSessionCompat$MediaSessionImpl0;
                if(message0.what == 1) {
                    synchronized(Callback.this.mLock) {
                        mediaSessionCompat$MediaSessionImpl0 = (MediaSessionImpl)Callback.this.mSessionImpl.get();
                        mediaSessionCompat$Callback$CallbackHandler0 = Callback.this.mCallbackHandler;
                    }
                    if(mediaSessionCompat$MediaSessionImpl0 != null && Callback.this == mediaSessionCompat$MediaSessionImpl0.getCallback() && mediaSessionCompat$Callback$CallbackHandler0 != null) {
                        mediaSessionCompat$MediaSessionImpl0.setCurrentControllerInfo(((q)message0.obj));
                        Callback.this.handleMediaPlayPauseIfPendingOnHandler(mediaSessionCompat$MediaSessionImpl0, mediaSessionCompat$Callback$CallbackHandler0);
                        mediaSessionCompat$MediaSessionImpl0.setCurrentControllerInfo(null);
                    }
                }
            }
        }

        class MediaSessionCallbackApi21 extends MediaSession.Callback {
            private void clearCurrentControllerInfo(MediaSessionImpl mediaSessionCompat$MediaSessionImpl0) {
                mediaSessionCompat$MediaSessionImpl0.setCurrentControllerInfo(null);
            }

            private MediaSessionImplApi21 getSessionImplIfCallbackIsSet() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210;
                synchronized(Callback.this.mLock) {
                    mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)Callback.this.mSessionImpl.get();
                }
                if(mediaSessionCompat$MediaSessionImplApi210 != null) {
                    Callback mediaSessionCompat$Callback0 = mediaSessionCompat$MediaSessionImplApi210.getCallback();
                    return Callback.this == mediaSessionCompat$Callback0 ? mediaSessionCompat$MediaSessionImplApi210 : null;
                }
                return null;
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onCommand(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                IBinder iBinder0 = null;
                MediaSessionCompat.ensureClassLoader(bundle0);
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                try {
                    if(s.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        Bundle bundle1 = new Bundle();
                        Token mediaSessionCompat$Token0 = mediaSessionCompat$MediaSessionImplApi210.getSessionToken();
                        IMediaSession iMediaSession0 = mediaSessionCompat$Token0.getExtraBinder();
                        if(iMediaSession0 != null) {
                            iBinder0 = iMediaSession0.asBinder();
                        }
                        bundle1.putBinder("android.support.v4.media.session.EXTRA_BINDER", iBinder0);
                        a.x(bundle1, mediaSessionCompat$Token0.getSession2Token());
                        resultReceiver0.send(0, bundle1);
                    }
                    else if(s.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        MediaDescriptionCompat mediaDescriptionCompat2 = (MediaDescriptionCompat)bundle0.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
                    }
                    else if(s.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        MediaDescriptionCompat mediaDescriptionCompat0 = (MediaDescriptionCompat)bundle0.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
                        bundle0.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX");
                    }
                    else if(s.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        MediaDescriptionCompat mediaDescriptionCompat1 = (MediaDescriptionCompat)bundle0.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
                        Callback.this.onRemoveQueueItem(mediaDescriptionCompat1);
                    }
                    else if(s.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT") && mediaSessionCompat$MediaSessionImplApi210.mQueue != null) {
                        int v = bundle0.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                        if(v >= 0 && v < mediaSessionCompat$MediaSessionImplApi210.mQueue.size()) {
                            iBinder0 = (QueueItem)mediaSessionCompat$MediaSessionImplApi210.mQueue.get(v);
                        }
                        if(iBinder0 != null) {
                            Callback.this.onRemoveQueueItem(((QueueItem)iBinder0).getDescription());
                        }
                    }
                }
                catch(BadParcelableException unused_ex) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onCustomAction(String s, Bundle bundle0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle0);
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                try {
                    if(s.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                        Uri uri0 = (Uri)bundle0.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        MediaSessionCompat.ensureClassLoader(bundle0.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                    }
                    else if(!s.equals("android.support.v4.media.session.action.PREPARE")) {
                        if(s.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                            bundle0.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                            MediaSessionCompat.ensureClassLoader(bundle0.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                        }
                        else if(s.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                            bundle0.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                            MediaSessionCompat.ensureClassLoader(bundle0.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                        }
                        else if(s.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                            Uri uri1 = (Uri)bundle0.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                            MediaSessionCompat.ensureClassLoader(bundle0.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                        }
                        else if(s.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                            bundle0.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                        }
                        else if(s.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                            bundle0.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE");
                        }
                        else if(s.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                            bundle0.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE");
                        }
                        else if(s.equals("android.support.v4.media.session.action.SET_RATING")) {
                            RatingCompat ratingCompat0 = (RatingCompat)bundle0.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                            MediaSessionCompat.ensureClassLoader(bundle0.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                        }
                        else if(s.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                            bundle0.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f);
                        }
                        else {
                            Callback.this.onCustomAction(s, bundle0);
                        }
                    }
                }
                catch(BadParcelableException unused_ex) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onFastForward() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public boolean onMediaButtonEvent(Intent intent0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return false;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                boolean z = Callback.this.onMediaButtonEvent(intent0);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                return z || super.onMediaButtonEvent(intent0);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onPause() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                Callback.this.onPause();
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onPlay() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                Callback.this.onPlay();
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onPlayFromMediaId(String s, Bundle bundle0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle0);
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onPlayFromSearch(String s, Bundle bundle0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle0);
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onPlayFromUri(Uri uri0, Bundle bundle0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle0);
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onPrepare() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onPrepareFromMediaId(String s, Bundle bundle0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle0);
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onPrepareFromSearch(String s, Bundle bundle0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle0);
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onPrepareFromUri(Uri uri0, Bundle bundle0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle0);
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onRewind() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onSeekTo(long v) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                Callback.this.onSeekTo(v);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onSetPlaybackSpeed(float f) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onSetRating(Rating rating0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                RatingCompat.fromRating(rating0);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onSkipToNext() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                Callback.this.onSkipToNext();
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onSkipToPrevious() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                Callback.this.onSkipToPrevious();
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onSkipToQueueItem(long v) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.media.session.MediaSession$Callback
            public void onStop() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = this.getSessionImplIfCallbackIsSet();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                this.setCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
                this.clearCurrentControllerInfo(mediaSessionCompat$MediaSessionImplApi210);
            }

            private void setCurrentControllerInfo(MediaSessionImpl mediaSessionCompat$MediaSessionImpl0) {
                if(Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String s = mediaSessionCompat$MediaSessionImpl0.getCallingPackage();
                if(TextUtils.isEmpty(s)) {
                    s = "android.media.session.MediaController";
                }
                mediaSessionCompat$MediaSessionImpl0.setCurrentControllerInfo(new q(s, -1, -1));
            }
        }

        final MediaSession.Callback mCallbackFwk;
        CallbackHandler mCallbackHandler;
        final Object mLock;
        private boolean mMediaPlayPausePendingOnHandler;
        WeakReference mSessionImpl;

        public Callback() {
            this.mLock = new Object();
            this.mCallbackFwk = new MediaSessionCallbackApi21(this);
            this.mSessionImpl = new WeakReference(null);
        }

        public void handleMediaPlayPauseIfPendingOnHandler(MediaSessionImpl mediaSessionCompat$MediaSessionImpl0, Handler handler0) {
            if(this.mMediaPlayPausePendingOnHandler) {
                boolean z = false;
                this.mMediaPlayPausePendingOnHandler = false;
                handler0.removeMessages(1);
                PlaybackStateCompat playbackStateCompat0 = mediaSessionCompat$MediaSessionImpl0.getPlaybackState();
                long v = playbackStateCompat0 == null ? 0L : playbackStateCompat0.getActions();
                boolean z1 = playbackStateCompat0 != null && playbackStateCompat0.getState() == 3;
                if((v & 0x202L) != 0L) {
                    z = true;
                }
                if(z1 && z) {
                    this.onPause();
                    return;
                }
                if(!z1 && (0x204L & v) != 0L) {
                    this.onPlay();
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
        }

        public void onCommand(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
        }

        public void onCustomAction(String s, Bundle bundle0) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent0) {
            CallbackHandler mediaSessionCompat$Callback$CallbackHandler0;
            MediaSessionImpl mediaSessionCompat$MediaSessionImpl0;
            if(Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized(this.mLock) {
                mediaSessionCompat$MediaSessionImpl0 = (MediaSessionImpl)this.mSessionImpl.get();
                mediaSessionCompat$Callback$CallbackHandler0 = this.mCallbackHandler;
            }
            if(mediaSessionCompat$MediaSessionImpl0 != null && mediaSessionCompat$Callback$CallbackHandler0 != null) {
                KeyEvent keyEvent0 = (KeyEvent)intent0.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if(keyEvent0 != null && keyEvent0.getAction() == 0) {
                    q q0 = mediaSessionCompat$MediaSessionImpl0.getCurrentControllerInfo();
                    switch(keyEvent0.getKeyCode()) {
                        case 0x4F: 
                        case 85: {
                            if(keyEvent0.getRepeatCount() == 0) {
                                if(!this.mMediaPlayPausePendingOnHandler) {
                                    this.mMediaPlayPausePendingOnHandler = true;
                                    mediaSessionCompat$Callback$CallbackHandler0.sendMessageDelayed(mediaSessionCompat$Callback$CallbackHandler0.obtainMessage(1, q0), 300L);
                                    return true;
                                }
                                mediaSessionCompat$Callback$CallbackHandler0.removeMessages(1);
                                this.mMediaPlayPausePendingOnHandler = false;
                                PlaybackStateCompat playbackStateCompat0 = mediaSessionCompat$MediaSessionImpl0.getPlaybackState();
                                if(((playbackStateCompat0 == null ? 0L : playbackStateCompat0.getActions()) & 0x20L) != 0L) {
                                    this.onSkipToNext();
                                    return true;
                                }
                            }
                            else {
                                this.handleMediaPlayPauseIfPendingOnHandler(mediaSessionCompat$MediaSessionImpl0, mediaSessionCompat$Callback$CallbackHandler0);
                            }
                            return true;
                        }
                        default: {
                            this.handleMediaPlayPauseIfPendingOnHandler(mediaSessionCompat$MediaSessionImpl0, mediaSessionCompat$Callback$CallbackHandler0);
                            return false;
                        }
                    }
                }
            }
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String s, Bundle bundle0) {
        }

        public void onPlayFromSearch(String s, Bundle bundle0) {
        }

        public void onPlayFromUri(Uri uri0, Bundle bundle0) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String s, Bundle bundle0) {
        }

        public void onPrepareFromSearch(String s, Bundle bundle0) {
        }

        public void onPrepareFromUri(Uri uri0, Bundle bundle0) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int v) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long v) {
        }

        public void onSetCaptioningEnabled(boolean z) {
        }

        public void onSetPlaybackSpeed(float f) {
        }

        public void onSetRating(RatingCompat ratingCompat0) {
        }

        public void onSetRating(RatingCompat ratingCompat0, Bundle bundle0) {
        }

        public void onSetRepeatMode(int v) {
        }

        public void onSetShuffleMode(int v) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long v) {
        }

        public void onStop() {
        }

        public void setSessionImpl(MediaSessionImpl mediaSessionCompat$MediaSessionImpl0, Handler handler0) {
            synchronized(this.mLock) {
                this.mSessionImpl = new WeakReference(mediaSessionCompat$MediaSessionImpl0);
                CallbackHandler mediaSessionCompat$Callback$CallbackHandler0 = this.mCallbackHandler;
                CallbackHandler mediaSessionCompat$Callback$CallbackHandler1 = null;
                if(mediaSessionCompat$Callback$CallbackHandler0 != null) {
                    mediaSessionCompat$Callback$CallbackHandler0.removeCallbacksAndMessages(null);
                }
                if(mediaSessionCompat$MediaSessionImpl0 != null && handler0 != null) {
                    mediaSessionCompat$Callback$CallbackHandler1 = new CallbackHandler(this, handler0.getLooper());
                }
                this.mCallbackHandler = mediaSessionCompat$Callback$CallbackHandler1;
            }
        }
    }

    interface MediaSessionImpl {
        Callback getCallback();

        String getCallingPackage();

        q getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String arg1, Bundle arg2);

        void setActive(boolean arg1);

        void setCallback(Callback arg1, Handler arg2);

        void setCaptioningEnabled(boolean arg1);

        void setCurrentControllerInfo(q arg1);

        void setExtras(Bundle arg1);

        void setFlags(int arg1);

        void setMediaButtonReceiver(PendingIntent arg1);

        void setMetadata(MediaMetadataCompat arg1);

        void setPlaybackState(PlaybackStateCompat arg1);

        void setPlaybackToLocal(int arg1);

        void setPlaybackToRemote(x arg1);

        void setQueue(List arg1);

        void setQueueTitle(CharSequence arg1);

        void setRatingType(int arg1);

        void setRegistrationCallback(RegistrationCallback arg1, Handler arg2);

        void setRepeatMode(int arg1);

        void setSessionActivity(PendingIntent arg1);

        void setShuffleMode(int arg1);
    }

    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        public MediaSessionImplApi18(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0, d d0, Bundle bundle0) {
            super(context0, s, componentName0, pendingIntent0, d0, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long v) {
            int v1 = super.getRccTransportControlFlagsFromActions(v);
            return (v & 0x100L) == 0L ? v1 : v1 | 0x100;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent0, ComponentName componentName0) {
            if(MediaSessionImplApi18.sIsMbrPendingIntentSupported) {
                try {
                    this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent0);
                }
                catch(NullPointerException unused_ex) {
                    Log.w("MediaSessionCompat", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    MediaSessionImplApi18.sIsMbrPendingIntentSupported = false;
                }
            }
            if(!MediaSessionImplApi18.sIsMbrPendingIntentSupported) {
                super.registerMediaButtonEventReceiver(pendingIntent0, componentName0);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
            super.setCallback(mediaSessionCompat$Callback0, handler0);
            if(mediaSessionCompat$Callback0 == null) {
                this.mRcc.setPlaybackPositionUpdateListener(null);
                return;
            }
            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.1 mediaSessionCompat$MediaSessionImplApi18$10 = new RemoteControlClient.OnPlaybackPositionUpdateListener() {
                @Override  // android.media.RemoteControlClient$OnPlaybackPositionUpdateListener
                public void onPlaybackPositionUpdate(long v) {
                    MediaSessionImplApi18.this.postToHandler(18, -1, -1, v, null);
                }
            };
            this.mRcc.setPlaybackPositionUpdateListener(mediaSessionCompat$MediaSessionImplApi18$10);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        public void setRccState(PlaybackStateCompat playbackStateCompat0) {
            long v = 0L;
            long v1 = playbackStateCompat0.getPosition();
            float f = playbackStateCompat0.getPlaybackSpeed();
            long v2 = playbackStateCompat0.getLastPositionUpdateTime();
            long v3 = SystemClock.elapsedRealtime();
            if(playbackStateCompat0.getState() == 3 && v1 > 0L) {
                if(v2 > 0L) {
                    v = v3 - v2;
                    if(f > 0.0f && f != 1.0f) {
                        v = (long)(((float)v) * f);
                    }
                }
                v1 += v;
            }
            this.mRcc.setPlaybackState(this.getRccStateFromState(playbackStateCompat0.getState()), v1, f);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent0, ComponentName componentName0) {
            if(MediaSessionImplApi18.sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent0);
                return;
            }
            super.unregisterMediaButtonEventReceiver(pendingIntent0, componentName0);
        }
    }

    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        public MediaSessionImplApi19(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0, d d0, Bundle bundle0) {
            super(context0, s, componentName0, pendingIntent0, d0, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle0) {
            RemoteControlClient.MetadataEditor remoteControlClient$MetadataEditor0 = super.buildRccMetadata(bundle0);
            if(Long.compare((this.mState == null ? 0L : this.mState.getActions()) & 0x80L, 0L) != 0) {
                remoteControlClient$MetadataEditor0.addEditableKey(0x10000001);
            }
            if(bundle0 != null) {
                if(bundle0.containsKey("android.media.metadata.YEAR")) {
                    remoteControlClient$MetadataEditor0.putLong(8, bundle0.getLong("android.media.metadata.YEAR"));
                }
                if(bundle0.containsKey("android.media.metadata.RATING")) {
                    remoteControlClient$MetadataEditor0.putObject(101, bundle0.getParcelable("android.media.metadata.RATING"));
                }
                if(bundle0.containsKey("android.media.metadata.USER_RATING")) {
                    remoteControlClient$MetadataEditor0.putObject(0x10000001, bundle0.getParcelable("android.media.metadata.USER_RATING"));
                }
            }
            return remoteControlClient$MetadataEditor0;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18
        public int getRccTransportControlFlagsFromActions(long v) {
            int v1 = super.getRccTransportControlFlagsFromActions(v);
            return (v & 0x80L) == 0L ? v1 : v1 | 0x200;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18
        public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
            super.setCallback(mediaSessionCompat$Callback0, handler0);
            if(mediaSessionCompat$Callback0 == null) {
                this.mRcc.setMetadataUpdateListener(null);
                return;
            }
            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi19.1 mediaSessionCompat$MediaSessionImplApi19$10 = new RemoteControlClient.OnMetadataUpdateListener() {
                @Override  // android.media.RemoteControlClient$OnMetadataUpdateListener
                public void onMetadataUpdate(int v, Object object0) {
                    if(v == 0x10000001 && object0 instanceof Rating) {
                        RatingCompat ratingCompat0 = RatingCompat.fromRating(object0);
                        MediaSessionImplApi19.this.postToHandler(19, -1, -1, ratingCompat0, null);
                    }
                }
            };
            this.mRcc.setMetadataUpdateListener(mediaSessionCompat$MediaSessionImplApi19$10);
        }
    }

    static class MediaSessionImplApi21 implements MediaSessionImpl {
        static class ExtraSession extends Stub {
            private final AtomicReference mMediaSessionImplRef;

            public ExtraSession(MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210) {
                this.mMediaSessionImplRef = new AtomicReference(mediaSessionCompat$MediaSessionImplApi210);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int v, int v1, String s) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void fastForward() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplApi210 == null ? null : MediaSessionCompat.getStateWithUpdatedPosition(mediaSessionCompat$MediaSessionImplApi210.mPlaybackState, mediaSessionCompat$MediaSessionImplApi210.mMetadata);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public List getQueue() {
                return null;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplApi210 == null ? 0 : mediaSessionCompat$MediaSessionImplApi210.mRatingType;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplApi210 == null ? -1 : mediaSessionCompat$MediaSessionImplApi210.mRepeatMode;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public Bundle getSessionInfo() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplApi210.mSessionInfo == null ? null : new Bundle(mediaSessionCompat$MediaSessionImplApi210.mSessionInfo);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplApi210 == null ? -1 : mediaSessionCompat$MediaSessionImplApi210.mShuffleMode;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getTag() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplApi210 != null && mediaSessionCompat$MediaSessionImplApi210.mCaptioningEnabled;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void next() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void pause() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void play() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String s, Bundle bundle0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String s, Bundle bundle0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri0, Bundle bundle0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepare() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String s, Bundle bundle0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String s, Bundle bundle0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri0, Bundle bundle0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void previous() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat0, Bundle bundle0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)this.mMediaSessionImplRef.get();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                int v = Binder.getCallingPid();
                int v1 = Binder.getCallingUid();
                q q0 = new q("android.media.session.MediaController", v, v1);
                mediaSessionCompat$MediaSessionImplApi210.mExtraControllerCallbacks.register(iMediaControllerCallback0, q0);
                synchronized(mediaSessionCompat$MediaSessionImplApi210.mLock) {
                    RegistrationCallbackHandler mediaSessionCompat$RegistrationCallbackHandler0 = mediaSessionCompat$MediaSessionImplApi210.mRegistrationCallbackHandler;
                    if(mediaSessionCompat$RegistrationCallbackHandler0 != null) {
                        mediaSessionCompat$RegistrationCallbackHandler0.postCallbackRegistered(v, v1);
                    }
                }
            }

            public void release() {
                this.mMediaSessionImplRef.set(null);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int v) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rewind() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void seekTo(long v) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCommand(String s, Bundle bundle0, ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String s, Bundle bundle0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setPlaybackSpeed(float f) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int v) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int v) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) {
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int v, int v1, String s) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long v) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void stop() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)this.mMediaSessionImplRef.get();
                if(mediaSessionCompat$MediaSessionImplApi210 == null) {
                    return;
                }
                mediaSessionCompat$MediaSessionImplApi210.mExtraControllerCallbacks.unregister(iMediaControllerCallback0);
                int v = Binder.getCallingPid();
                int v1 = Binder.getCallingUid();
                synchronized(mediaSessionCompat$MediaSessionImplApi210.mLock) {
                    RegistrationCallbackHandler mediaSessionCompat$RegistrationCallbackHandler0 = mediaSessionCompat$MediaSessionImplApi210.mRegistrationCallbackHandler;
                    if(mediaSessionCompat$RegistrationCallbackHandler0 != null) {
                        mediaSessionCompat$RegistrationCallbackHandler0.postCallbackUnregistered(v, v1);
                    }
                }
            }
        }

        Callback mCallback;
        boolean mCaptioningEnabled;
        boolean mDestroyed;
        final RemoteCallbackList mExtraControllerCallbacks;
        final ExtraSession mExtraSession;
        final Object mLock;
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List mQueue;
        int mRatingType;
        RegistrationCallbackHandler mRegistrationCallbackHandler;
        q mRemoteUserInfo;
        int mRepeatMode;
        final MediaSession mSessionFwk;
        Bundle mSessionInfo;
        int mShuffleMode;
        final Token mToken;

        public MediaSessionImplApi21(Context context0, String s, d d0, Bundle bundle0) {
            this.mLock = new Object();
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            MediaSession mediaSession0 = this.createFwkMediaSession(context0, s, bundle0);
            this.mSessionFwk = mediaSession0;
            ExtraSession mediaSessionCompat$MediaSessionImplApi21$ExtraSession0 = new ExtraSession(this);
            this.mExtraSession = mediaSessionCompat$MediaSessionImplApi21$ExtraSession0;
            this.mToken = new Token(mediaSession0.getSessionToken(), mediaSessionCompat$MediaSessionImplApi21$ExtraSession0, d0);
            this.mSessionInfo = bundle0;
            this.setFlags(3);
        }

        public MediaSessionImplApi21(Object object0) {
            this.mLock = new Object();
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            if(!(object0 instanceof MediaSession)) {
                throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
            }
            this.mSessionFwk = (MediaSession)object0;
            ExtraSession mediaSessionCompat$MediaSessionImplApi21$ExtraSession0 = new ExtraSession(this);
            this.mExtraSession = mediaSessionCompat$MediaSessionImplApi21$ExtraSession0;
            this.mToken = new Token(((MediaSession)object0).getSessionToken(), mediaSessionCompat$MediaSessionImplApi21$ExtraSession0);
            this.mSessionInfo = null;
            this.setFlags(3);
        }

        public MediaSession createFwkMediaSession(Context context0, String s, Bundle bundle0) {
            return new MediaSession(context0, s);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Callback getCallback() {
            synchronized(this.mLock) {
            }
            return this.mCallback;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public String getCallingPackage() {
            try {
                return (String)this.mSessionFwk.getClass().getMethod("getCallingPackage", null).invoke(this.mSessionFwk, null);
            }
            catch(Exception exception0) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", exception0);
                return null;
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public q getCurrentControllerInfo() {
            synchronized(this.mLock) {
            }
            return this.mRemoteUserInfo;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Object getMediaSession() {
            return this.mSessionFwk;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public boolean isActive() {
            return this.mSessionFwk.isActive();
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void release() {
            this.mDestroyed = true;
            this.mExtraControllerCallbacks.kill();
            if(Build.VERSION.SDK_INT == 27) {
                try {
                    Field field0 = this.mSessionFwk.getClass().getDeclaredField("mCallback");
                    field0.setAccessible(true);
                    Handler handler0 = (Handler)field0.get(this.mSessionFwk);
                    if(handler0 != null) {
                        handler0.removeCallbacksAndMessages(null);
                    }
                }
                catch(Exception exception0) {
                    Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", exception0);
                }
            }
            this.mSessionFwk.setCallback(null);
            this.mExtraSession.release();
            this.mSessionFwk.release();
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void sendSessionEvent(String s, Bundle bundle0) {
            this.mSessionFwk.sendSessionEvent(s, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setActive(boolean z) {
            this.mSessionFwk.setActive(z);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
            synchronized(this.mLock) {
                this.mCallback = mediaSessionCompat$Callback0;
                this.mSessionFwk.setCallback((mediaSessionCompat$Callback0 == null ? null : mediaSessionCompat$Callback0.mCallbackFwk), handler0);
                if(mediaSessionCompat$Callback0 != null) {
                    mediaSessionCompat$Callback0.setSessionImpl(this, handler0);
                }
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            if(this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                Object object0 = this.mLock;
                synchronized(object0) {
                    for(int v1 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                        IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(v1);
                        try {
                            iMediaControllerCallback0.onCaptioningEnabledChanged(z);
                        }
                        catch(RemoteException unused_ex) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCurrentControllerInfo(q q0) {
            synchronized(this.mLock) {
                this.mRemoteUserInfo = q0;
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setExtras(Bundle bundle0) {
            this.mSessionFwk.setExtras(bundle0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        @SuppressLint({"WrongConstant"})
        public void setFlags(int v) {
            this.mSessionFwk.setFlags(v | 3);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent pendingIntent0) {
            this.mSessionFwk.setMediaButtonReceiver(pendingIntent0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat0) {
            this.mMetadata = mediaMetadataCompat0;
            MediaMetadata mediaMetadata0 = mediaMetadataCompat0 == null ? null : ((MediaMetadata)mediaMetadataCompat0.getMediaMetadata());
            this.mSessionFwk.setMetadata(mediaMetadata0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat0) {
            this.mPlaybackState = playbackStateCompat0;
            synchronized(this.mLock) {
                for(int v1 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onPlaybackStateChanged(playbackStateCompat0);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
            PlaybackState playbackState0 = playbackStateCompat0 == null ? null : ((PlaybackState)playbackStateCompat0.getPlaybackState());
            this.mSessionFwk.setPlaybackState(playbackState0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackToLocal(int v) {
            AudioAttributes.Builder audioAttributes$Builder0 = new AudioAttributes.Builder();
            audioAttributes$Builder0.setLegacyStreamType(v);
            AudioAttributes audioAttributes0 = audioAttributes$Builder0.build();
            this.mSessionFwk.setPlaybackToLocal(audioAttributes0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackToRemote(x x0) {
            VolumeProvider volumeProvider0 = x0.a();
            this.mSessionFwk.setPlaybackToRemote(volumeProvider0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setQueue(List list0) {
            this.mQueue = list0;
            if(list0 == null) {
                this.mSessionFwk.setQueue(null);
                return;
            }
            ArrayList arrayList0 = new ArrayList(list0.size());
            for(Object object0: list0) {
                arrayList0.add(((MediaSession.QueueItem)((QueueItem)object0).getQueueItem()));
            }
            this.mSessionFwk.setQueue(arrayList0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setQueueTitle(CharSequence charSequence0) {
            this.mSessionFwk.setQueueTitle(charSequence0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRatingType(int v) {
            this.mRatingType = v;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRegistrationCallback(RegistrationCallback mediaSessionCompat$RegistrationCallback0, Handler handler0) {
            synchronized(this.mLock) {
                RegistrationCallbackHandler mediaSessionCompat$RegistrationCallbackHandler0 = this.mRegistrationCallbackHandler;
                if(mediaSessionCompat$RegistrationCallbackHandler0 != null) {
                    mediaSessionCompat$RegistrationCallbackHandler0.removeCallbacksAndMessages(null);
                }
                this.mRegistrationCallbackHandler = mediaSessionCompat$RegistrationCallback0 == null ? null : new RegistrationCallbackHandler(handler0.getLooper(), mediaSessionCompat$RegistrationCallback0);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRepeatMode(int v) {
            if(this.mRepeatMode != v) {
                this.mRepeatMode = v;
                Object object0 = this.mLock;
                synchronized(object0) {
                    for(int v2 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v2 >= 0; --v2) {
                        IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(v2);
                        try {
                            iMediaControllerCallback0.onRepeatModeChanged(v);
                        }
                        catch(RemoteException unused_ex) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setSessionActivity(PendingIntent pendingIntent0) {
            this.mSessionFwk.setSessionActivity(pendingIntent0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setShuffleMode(int v) {
            if(this.mShuffleMode != v) {
                this.mShuffleMode = v;
                Object object0 = this.mLock;
                synchronized(object0) {
                    for(int v2 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v2 >= 0; --v2) {
                        IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(v2);
                        try {
                            iMediaControllerCallback0.onShuffleModeChanged(v);
                        }
                        catch(RemoteException unused_ex) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }
    }

    static class MediaSessionImplApi22 extends MediaSessionImplApi21 {
        public MediaSessionImplApi22(Context context0, String s, d d0, Bundle bundle0) {
            super(context0, s, d0, bundle0);
        }

        public MediaSessionImplApi22(Object object0) {
            super(object0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
        public void setRatingType(int v) {
            this.mSessionFwk.setRatingType(v);
        }
    }

    static class MediaSessionImplApi28 extends MediaSessionImplApi22 {
        public MediaSessionImplApi28(Context context0, String s, d d0, Bundle bundle0) {
            super(context0, s, d0, bundle0);
        }

        public MediaSessionImplApi28(Object object0) {
            super(object0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
        public final q getCurrentControllerInfo() {
            MediaSessionManager.RemoteUserInfo mediaSessionManager$RemoteUserInfo0 = this.mSessionFwk.getCurrentControllerInfo();
            q q0 = new q();  // 初始化器: Ljava/lang/Object;-><init>()V
            String s = mediaSessionManager$RemoteUserInfo0.getPackageName();
            if(s == null) {
                throw new NullPointerException("package shouldn\'t be null");
            }
            if(TextUtils.isEmpty(s)) {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            q0.a = new r(mediaSessionManager$RemoteUserInfo0.getPackageName(), mediaSessionManager$RemoteUserInfo0.getPid(), mediaSessionManager$RemoteUserInfo0.getUid());  // 初始化器: LX2/s;-><init>(Ljava/lang/String;II)V
            return q0;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
        public void setCurrentControllerInfo(q q0) {
        }
    }

    static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
        public MediaSessionImplApi29(Context context0, String s, d d0, Bundle bundle0) {
            super(context0, s, d0, bundle0);
        }

        public MediaSessionImplApi29(Object object0) {
            super(object0);
            this.mSessionInfo = ((MediaSession)object0).getController().getSessionInfo();
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
        public MediaSession createFwkMediaSession(Context context0, String s, Bundle bundle0) {
            return l.f(context0, s, bundle0);
        }
    }

    static class MediaSessionImplBase implements MediaSessionImpl {
        static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
                this.command = s;
                this.extras = bundle0;
                this.stub = resultReceiver0;
            }
        }

        static class MediaSessionStub extends Stub {
            private final AtomicReference mMediaSessionImplRef;
            private final String mPackageName;
            private final String mTag;

            public MediaSessionStub(MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0, String s, String s1) {
                this.mMediaSessionImplRef = new AtomicReference(mediaSessionCompat$MediaSessionImplBase0);
                this.mPackageName = s;
                this.mTag = s1;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                this.postToHandler(25, mediaDescriptionCompat0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
                this.postToHandler(26, mediaDescriptionCompat0, v, null);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int v, int v1, String s) {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                if(mediaSessionCompat$MediaSessionImplBase0 != null) {
                    mediaSessionCompat$MediaSessionImplBase0.adjustVolume(v, v1);
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void fastForward() {
                this.postToHandler(16);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? null : mediaSessionCompat$MediaSessionImplBase0.mExtras;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? 0L : ((long)mediaSessionCompat$MediaSessionImplBase0.mFlags);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? null : mediaSessionCompat$MediaSessionImplBase0.mSessionActivity;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? null : mediaSessionCompat$MediaSessionImplBase0.mMetadata;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                return this.mPackageName;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? null : MediaSessionCompat.getStateWithUpdatedPosition(mediaSessionCompat$MediaSessionImplBase0.mState, mediaSessionCompat$MediaSessionImplBase0.mMetadata);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public List getQueue() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? null : mediaSessionCompat$MediaSessionImplBase0.mQueue;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? null : mediaSessionCompat$MediaSessionImplBase0.mQueueTitle;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? 0 : mediaSessionCompat$MediaSessionImplBase0.mRatingType;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? -1 : mediaSessionCompat$MediaSessionImplBase0.mRepeatMode;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public Bundle getSessionInfo() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null || mediaSessionCompat$MediaSessionImplBase0.mSessionInfo == null ? null : new Bundle(mediaSessionCompat$MediaSessionImplBase0.mSessionInfo);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 == null ? -1 : mediaSessionCompat$MediaSessionImplBase0.mShuffleMode;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getTag() {
                return this.mTag;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                int v3;
                int v2;
                int v1;
                int v5;
                int v4;
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                if(mediaSessionCompat$MediaSessionImplBase0 == null) {
                    return null;
                }
                synchronized(mediaSessionCompat$MediaSessionImplBase0.mLock) {
                    v1 = mediaSessionCompat$MediaSessionImplBase0.mVolumeType;
                    v2 = mediaSessionCompat$MediaSessionImplBase0.mLocalStream;
                    x x0 = mediaSessionCompat$MediaSessionImplBase0.mVolumeProvider;
                    v3 = 2;
                    if(v1 == 2) {
                        v3 = x0.a;
                        v4 = x0.b;
                        v5 = x0.d;
                    }
                    else {
                        int v6 = mediaSessionCompat$MediaSessionImplBase0.mAudioManager.getStreamMaxVolume(v2);
                        v5 = mediaSessionCompat$MediaSessionImplBase0.mAudioManager.getStreamVolume(v2);
                        v4 = v6;
                    }
                }
                return new ParcelableVolumeInfo(v1, v2, v3, v4, v5);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                return mediaSessionCompat$MediaSessionImplBase0 != null && mediaSessionCompat$MediaSessionImplBase0.mCaptioningEnabled;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                return true;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void next() {
                this.postToHandler(14);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void pause() {
                this.postToHandler(12);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void play() {
                this.postToHandler(7);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String s, Bundle bundle0) {
                this.postToHandler(8, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String s, Bundle bundle0) {
                this.postToHandler(9, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri0, Bundle bundle0) {
                this.postToHandler(10, uri0, bundle0);
            }

            public void postToHandler(int v) {
                this.postToHandler(v, null, 0, null);
            }

            public void postToHandler(int v, int v1) {
                this.postToHandler(v, null, v1, null);
            }

            public void postToHandler(int v, Object object0) {
                this.postToHandler(v, object0, 0, null);
            }

            public void postToHandler(int v, Object object0, int v1, Bundle bundle0) {
                Object object1 = this.mMediaSessionImplRef.get();
                if(((MediaSessionImplBase)object1) != null) {
                    ((MediaSessionImplBase)object1).postToHandler(v, v1, 0, object0, bundle0);
                }
            }

            public void postToHandler(int v, Object object0, Bundle bundle0) {
                this.postToHandler(v, object0, 0, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepare() {
                this.postToHandler(3);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String s, Bundle bundle0) {
                this.postToHandler(4, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String s, Bundle bundle0) {
                this.postToHandler(5, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri0, Bundle bundle0) {
                this.postToHandler(6, uri0, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void previous() {
                this.postToHandler(15);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat0) {
                this.postToHandler(19, ratingCompat0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat0, Bundle bundle0) {
                this.postToHandler(0x1F, ratingCompat0, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                if(mediaSessionCompat$MediaSessionImplBase0 == null) {
                    try {
                        iMediaControllerCallback0.onSessionDestroyed();
                    }
                    catch(Exception unused_ex) {
                    }
                    return;
                }
                int v = Binder.getCallingPid();
                int v1 = Binder.getCallingUid();
                q q0 = new q(mediaSessionCompat$MediaSessionImplBase0.getPackageNameForUid(v1), v, v1);
                mediaSessionCompat$MediaSessionImplBase0.mControllerCallbacks.register(iMediaControllerCallback0, q0);
                synchronized(mediaSessionCompat$MediaSessionImplBase0.mLock) {
                    RegistrationCallbackHandler mediaSessionCompat$RegistrationCallbackHandler0 = mediaSessionCompat$MediaSessionImplBase0.mRegistrationCallbackHandler;
                    if(mediaSessionCompat$RegistrationCallbackHandler0 != null) {
                        mediaSessionCompat$RegistrationCallbackHandler0.postCallbackRegistered(v, v1);
                    }
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                this.postToHandler(27, mediaDescriptionCompat0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int v) {
                this.postToHandler(28, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rewind() {
                this.postToHandler(17);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void seekTo(long v) {
                this.postToHandler(18, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCommand(String s, Bundle bundle0, ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper0) {
                this.postToHandler(1, new Command(s, bundle0, (mediaSessionCompat$ResultReceiverWrapper0 == null ? null : mediaSessionCompat$ResultReceiverWrapper0.mResultReceiver)));
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String s, Bundle bundle0) {
                this.postToHandler(20, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent0) {
                this.postToHandler(21, keyEvent0);
                return true;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) {
                this.postToHandler(29, Boolean.valueOf(z));
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setPlaybackSpeed(float f) {
                this.postToHandler(0x20, f);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int v) {
                this.postToHandler(23, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int v) {
                this.postToHandler(30, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) {
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int v, int v1, String s) {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                if(mediaSessionCompat$MediaSessionImplBase0 != null) {
                    mediaSessionCompat$MediaSessionImplBase0.setVolumeTo(v, v1);
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long v) {
                this.postToHandler(11, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void stop() {
                this.postToHandler(13);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                MediaSessionImplBase mediaSessionCompat$MediaSessionImplBase0 = (MediaSessionImplBase)this.mMediaSessionImplRef.get();
                if(mediaSessionCompat$MediaSessionImplBase0 == null) {
                    return;
                }
                mediaSessionCompat$MediaSessionImplBase0.mControllerCallbacks.unregister(iMediaControllerCallback0);
                int v = Binder.getCallingPid();
                int v1 = Binder.getCallingUid();
                synchronized(mediaSessionCompat$MediaSessionImplBase0.mLock) {
                    RegistrationCallbackHandler mediaSessionCompat$RegistrationCallbackHandler0 = mediaSessionCompat$MediaSessionImplBase0.mRegistrationCallbackHandler;
                    if(mediaSessionCompat$RegistrationCallbackHandler0 != null) {
                        mediaSessionCompat$RegistrationCallbackHandler0.postCallbackUnregistered(v, v1);
                    }
                }
            }
        }

        class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 0x7F;
            private static final int KEYCODE_MEDIA_PLAY = 0x7E;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 0x1F;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_PLAYBACK_SPEED = 0x20;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(Looper looper0) {
                super(looper0);
            }

            @Override  // android.os.Handler
            public void handleMessage(Message message0) {
                Callback mediaSessionCompat$Callback0 = MediaSessionImplBase.this.mCallback;
                if(mediaSessionCompat$Callback0 == null) {
                    return;
                }
                Bundle bundle0 = message0.getData();
                MediaSessionCompat.ensureClassLoader(bundle0);
                q q0 = new q(bundle0.getString("data_calling_pkg"), bundle0.getInt("data_calling_pid"), bundle0.getInt("data_calling_uid"));
                MediaSessionImplBase.this.setCurrentControllerInfo(q0);
                Bundle bundle1 = bundle0.getBundle("data_extras");
                MediaSessionCompat.ensureClassLoader(bundle1);
                try {
                    switch(message0.what) {
                        case 2: {
                            MediaSessionImplBase.this.adjustVolume(message0.arg1, 0);
                            break;
                        }
                        case 7: {
                            mediaSessionCompat$Callback0.onPlay();
                            break;
                        }
                        case 12: {
                            mediaSessionCompat$Callback0.onPause();
                            break;
                        }
                        case 14: {
                            mediaSessionCompat$Callback0.onSkipToNext();
                            break;
                        }
                        case 15: {
                            mediaSessionCompat$Callback0.onSkipToPrevious();
                            break;
                        }
                        case 18: {
                            mediaSessionCompat$Callback0.onSeekTo(((long)(((Long)message0.obj))));
                            break;
                        }
                        case 20: {
                            mediaSessionCompat$Callback0.onCustomAction(((String)message0.obj), bundle1);
                            break;
                        }
                        case 21: {
                            KeyEvent keyEvent0 = (KeyEvent)message0.obj;
                            Intent intent0 = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent0.putExtra("android.intent.extra.KEY_EVENT", keyEvent0);
                            if(!mediaSessionCompat$Callback0.onMediaButtonEvent(intent0)) {
                                this.onMediaButtonEvent(keyEvent0, mediaSessionCompat$Callback0);
                            }
                            break;
                        }
                        case 22: {
                            MediaSessionImplBase.this.setVolumeTo(message0.arg1, 0);
                            break;
                        }
                        case 27: {
                            mediaSessionCompat$Callback0.onRemoveQueueItem(((MediaDescriptionCompat)message0.obj));
                            break;
                        }
                        case 28: {
                            List list0 = MediaSessionImplBase.this.mQueue;
                            if(list0 != null) {
                                QueueItem mediaSessionCompat$QueueItem0 = message0.arg1 < 0 || message0.arg1 >= list0.size() ? null : ((QueueItem)MediaSessionImplBase.this.mQueue.get(message0.arg1));
                                if(mediaSessionCompat$QueueItem0 != null) {
                                    mediaSessionCompat$Callback0.onRemoveQueueItem(mediaSessionCompat$QueueItem0.getDescription());
                                }
                            }
                        }
                    }
                }
                finally {
                    MediaSessionImplBase.this.setCurrentControllerInfo(null);
                }
            }

            private void onMediaButtonEvent(KeyEvent keyEvent0, Callback mediaSessionCompat$Callback0) {
                if(keyEvent0 != null && keyEvent0.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat0 = MediaSessionImplBase.this.mState;
                    long v = playbackStateCompat0 == null ? 0L : playbackStateCompat0.getActions();
                    switch(keyEvent0.getKeyCode()) {
                        case 0x4F: 
                        case 85: {
                            Log.w("MediaSessionCompat", "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                            return;
                        }
                        case 86: {
                            if((v & 1L) != 0L) {
                                return;
                            }
                            break;
                        }
                        case 87: {
                            if((v & 0x20L) != 0L) {
                                mediaSessionCompat$Callback0.onSkipToNext();
                                return;
                            }
                            break;
                        }
                        case 88: {
                            if((v & 16L) != 0L) {
                                mediaSessionCompat$Callback0.onSkipToPrevious();
                                return;
                            }
                            break;
                        }
                        case 89: {
                            if((v & 8L) != 0L) {
                                return;
                            }
                            break;
                        }
                        case 90: {
                            if((v & 0x40L) != 0L) {
                                return;
                            }
                            break;
                        }
                        case 0x7E: {
                            if((v & 4L) != 0L) {
                                mediaSessionCompat$Callback0.onPlay();
                                return;
                            }
                            break;
                        }
                        case 0x7F: {
                            if((v & 2L) != 0L) {
                                mediaSessionCompat$Callback0.onPause();
                                return;
                            }
                            break;
                        }
                    }
                }
            }
        }

        static final int RCC_PLAYSTATE_NONE;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        final RemoteCallbackList mControllerCallbacks;
        boolean mDestroyed;
        Bundle mExtras;
        int mFlags;
        private MessageHandler mHandler;
        boolean mIsActive;
        int mLocalStream;
        final Object mLock;
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        List mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        RegistrationCallbackHandler mRegistrationCallbackHandler;
        private q mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        final Bundle mSessionInfo;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        private final Token mToken;
        private w mVolumeCallback;
        x mVolumeProvider;
        int mVolumeType;

        public MediaSessionImplBase(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0, d d0, Bundle bundle0) {
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mFlags = 3;
            this.mVolumeCallback = new w() {
                @Override  // X2.w
                public void onVolumeChanged(x x0) {
                    if(MediaSessionImplBase.this.mVolumeProvider != x0) {
                        return;
                    }
                    ParcelableVolumeInfo parcelableVolumeInfo0 = new ParcelableVolumeInfo(MediaSessionImplBase.this.mVolumeType, MediaSessionImplBase.this.mLocalStream, x0.a, x0.b, x0.d);
                    MediaSessionImplBase.this.sendVolumeInfoChanged(parcelableVolumeInfo0);
                }
            };
            if(componentName0 == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
            }
            this.mContext = context0;
            this.mSessionInfo = bundle0;
            this.mAudioManager = (AudioManager)context0.getSystemService("audio");
            this.mMediaButtonReceiverComponentName = componentName0;
            this.mMediaButtonReceiverIntent = pendingIntent0;
            MediaSessionStub mediaSessionCompat$MediaSessionImplBase$MediaSessionStub0 = new MediaSessionStub(this, "com.iloen.melon", s);
            this.mStub = mediaSessionCompat$MediaSessionImplBase$MediaSessionStub0;
            this.mToken = new Token(mediaSessionCompat$MediaSessionImplBase$MediaSessionStub0, null, d0);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(pendingIntent0);
        }

        public void adjustVolume(int v, int v1) {
            if(this.mVolumeType == 2) {
                x x0 = this.mVolumeProvider;
                if(x0 != null) {
                    c c0 = new c(((l4.d)x0), v, 1);
                    ((l4.d)x0).g.c.a.post(c0);
                }
                return;
            }
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, v, v1);
        }

        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle0) {
            RemoteControlClient.MetadataEditor remoteControlClient$MetadataEditor0 = this.mRcc.editMetadata(true);
            if(bundle0 != null) {
                if(bundle0.containsKey("android.media.metadata.ART")) {
                    Bitmap bitmap0 = (Bitmap)bundle0.getParcelable("android.media.metadata.ART");
                    if(bitmap0 != null) {
                        bitmap0 = bitmap0.copy(bitmap0.getConfig(), false);
                    }
                    remoteControlClient$MetadataEditor0.putBitmap(100, bitmap0);
                }
                else if(bundle0.containsKey("android.media.metadata.ALBUM_ART")) {
                    Bitmap bitmap1 = (Bitmap)bundle0.getParcelable("android.media.metadata.ALBUM_ART");
                    if(bitmap1 != null) {
                        bitmap1 = bitmap1.copy(bitmap1.getConfig(), false);
                    }
                    remoteControlClient$MetadataEditor0.putBitmap(100, bitmap1);
                }
                if(bundle0.containsKey("android.media.metadata.ALBUM")) {
                    remoteControlClient$MetadataEditor0.putString(1, bundle0.getString("android.media.metadata.ALBUM"));
                }
                if(bundle0.containsKey("android.media.metadata.ALBUM_ARTIST")) {
                    remoteControlClient$MetadataEditor0.putString(13, bundle0.getString("android.media.metadata.ALBUM_ARTIST"));
                }
                if(bundle0.containsKey("android.media.metadata.ARTIST")) {
                    remoteControlClient$MetadataEditor0.putString(2, bundle0.getString("android.media.metadata.ARTIST"));
                }
                if(bundle0.containsKey("android.media.metadata.AUTHOR")) {
                    remoteControlClient$MetadataEditor0.putString(3, bundle0.getString("android.media.metadata.AUTHOR"));
                }
                if(bundle0.containsKey("android.media.metadata.COMPILATION")) {
                    remoteControlClient$MetadataEditor0.putString(15, bundle0.getString("android.media.metadata.COMPILATION"));
                }
                if(bundle0.containsKey("android.media.metadata.COMPOSER")) {
                    remoteControlClient$MetadataEditor0.putString(4, bundle0.getString("android.media.metadata.COMPOSER"));
                }
                if(bundle0.containsKey("android.media.metadata.DATE")) {
                    remoteControlClient$MetadataEditor0.putString(5, bundle0.getString("android.media.metadata.DATE"));
                }
                if(bundle0.containsKey("android.media.metadata.DISC_NUMBER")) {
                    remoteControlClient$MetadataEditor0.putLong(14, bundle0.getLong("android.media.metadata.DISC_NUMBER"));
                }
                if(bundle0.containsKey("android.media.metadata.DURATION")) {
                    remoteControlClient$MetadataEditor0.putLong(9, bundle0.getLong("android.media.metadata.DURATION"));
                }
                if(bundle0.containsKey("android.media.metadata.GENRE")) {
                    remoteControlClient$MetadataEditor0.putString(6, bundle0.getString("android.media.metadata.GENRE"));
                }
                if(bundle0.containsKey("android.media.metadata.TITLE")) {
                    remoteControlClient$MetadataEditor0.putString(7, bundle0.getString("android.media.metadata.TITLE"));
                }
                if(bundle0.containsKey("android.media.metadata.TRACK_NUMBER")) {
                    remoteControlClient$MetadataEditor0.putLong(0, bundle0.getLong("android.media.metadata.TRACK_NUMBER"));
                }
                if(bundle0.containsKey("android.media.metadata.WRITER")) {
                    remoteControlClient$MetadataEditor0.putString(11, bundle0.getString("android.media.metadata.WRITER"));
                }
            }
            return remoteControlClient$MetadataEditor0;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Callback getCallback() {
            synchronized(this.mLock) {
            }
            return this.mCallback;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public String getCallingPackage() {
            return null;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public q getCurrentControllerInfo() {
            synchronized(this.mLock) {
            }
            return this.mRemoteUserInfo;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Object getMediaSession() {
            return null;
        }

        public String getPackageNameForUid(int v) {
            String s = this.mContext.getPackageManager().getNameForUid(v);
            return TextUtils.isEmpty(s) ? "android.media.session.MediaController" : s;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            synchronized(this.mLock) {
            }
            return this.mState;
        }

        public int getRccStateFromState(int v) {
            switch(v) {
                case 0: {
                    return 0;
                }
                case 1: {
                    return 1;
                }
                case 2: {
                    return 2;
                }
                case 3: {
                    return 3;
                }
                case 4: {
                    return 4;
                }
                case 5: {
                    return 5;
                }
                case 7: {
                    return 9;
                }
                case 6: 
                case 8: {
                    return 8;
                }
                case 9: {
                    return 7;
                }
                case 10: 
                case 11: {
                    return 6;
                }
                default: {
                    return -1;
                }
            }
        }

        public int getRccTransportControlFlagsFromActions(long v) {
            int v1 = (1L & v) == 0L ? 0 : 0x20;
            if((2L & v) != 0L) {
                v1 |= 16;
            }
            if((4L & v) != 0L) {
                v1 |= 4;
            }
            if((8L & v) != 0L) {
                v1 |= 2;
            }
            if((16L & v) != 0L) {
                v1 |= 1;
            }
            if((0x20L & v) != 0L) {
                v1 |= 0x80;
            }
            if((0x40L & v) != 0L) {
                v1 |= 0x40;
            }
            return (v & 0x200L) == 0L ? v1 : v1 | 8;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        public void postToHandler(int v, int v1, int v2, Object object0, Bundle bundle0) {
            synchronized(this.mLock) {
                MessageHandler mediaSessionCompat$MediaSessionImplBase$MessageHandler0 = this.mHandler;
                if(mediaSessionCompat$MediaSessionImplBase$MessageHandler0 != null) {
                    Message message0 = mediaSessionCompat$MediaSessionImplBase$MessageHandler0.obtainMessage(v, v1, v2, object0);
                    Bundle bundle1 = new Bundle();
                    int v4 = Binder.getCallingUid();
                    bundle1.putInt("data_calling_uid", v4);
                    bundle1.putString("data_calling_pkg", this.getPackageNameForUid(v4));
                    int v5 = Binder.getCallingPid();
                    if(v5 > 0) {
                        bundle1.putInt("data_calling_pid", v5);
                    }
                    else {
                        bundle1.putInt("data_calling_pid", -1);
                    }
                    if(bundle0 != null) {
                        bundle1.putBundle("data_extras", bundle0);
                    }
                    message0.setData(bundle1);
                    message0.sendToTarget();
                }
            }
        }

        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent0, ComponentName componentName0) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            this.updateMbrAndRcc();
            this.sendSessionDestroyed();
            this.setCallback(null, null);
        }

        private void sendCaptioningEnabled(boolean z) {
            synchronized(this.mLock) {
                for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onCaptioningEnabledChanged(z);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendEvent(String s, Bundle bundle0) {
            synchronized(this.mLock) {
                for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onEvent(s, bundle0);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendExtras(Bundle bundle0) {
            synchronized(this.mLock) {
                for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onExtrasChanged(bundle0);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendMetadata(MediaMetadataCompat mediaMetadataCompat0) {
            synchronized(this.mLock) {
                for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onMetadataChanged(mediaMetadataCompat0);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueue(List list0) {
            synchronized(this.mLock) {
                for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onQueueChanged(list0);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueueTitle(CharSequence charSequence0) {
            synchronized(this.mLock) {
                for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onQueueTitleChanged(charSequence0);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendRepeatMode(int v) {
            synchronized(this.mLock) {
                for(int v2 = this.mControllerCallbacks.beginBroadcast() - 1; v2 >= 0; --v2) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v2);
                    try {
                        iMediaControllerCallback0.onRepeatModeChanged(v);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendSessionDestroyed() {
            synchronized(this.mLock) {
                for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onSessionDestroyed();
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
                this.mControllerCallbacks.kill();
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void sendSessionEvent(String s, Bundle bundle0) {
            this.sendEvent(s, bundle0);
        }

        private void sendShuffleMode(int v) {
            synchronized(this.mLock) {
                for(int v2 = this.mControllerCallbacks.beginBroadcast() - 1; v2 >= 0; --v2) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v2);
                    try {
                        iMediaControllerCallback0.onShuffleModeChanged(v);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendState(PlaybackStateCompat playbackStateCompat0) {
            synchronized(this.mLock) {
                for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onPlaybackStateChanged(playbackStateCompat0);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo0) {
            synchronized(this.mLock) {
                for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onVolumeInfoChanged(parcelableVolumeInfo0);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setActive(boolean z) {
            if(z == this.mIsActive) {
                return;
            }
            this.mIsActive = z;
            this.updateMbrAndRcc();
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
            synchronized(this.mLock) {
                MessageHandler mediaSessionCompat$MediaSessionImplBase$MessageHandler0 = this.mHandler;
                if(mediaSessionCompat$MediaSessionImplBase$MessageHandler0 != null) {
                    mediaSessionCompat$MediaSessionImplBase$MessageHandler0.removeCallbacksAndMessages(null);
                }
                this.mHandler = mediaSessionCompat$Callback0 == null || handler0 == null ? null : new MessageHandler(this, handler0.getLooper());
                if(this.mCallback != mediaSessionCompat$Callback0 && this.mCallback != null) {
                    this.mCallback.setSessionImpl(null, null);
                }
                this.mCallback = mediaSessionCompat$Callback0;
                if(this.mCallback != null) {
                    this.mCallback.setSessionImpl(this, handler0);
                }
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            if(this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                this.sendCaptioningEnabled(z);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCurrentControllerInfo(q q0) {
            synchronized(this.mLock) {
                this.mRemoteUserInfo = q0;
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setExtras(Bundle bundle0) {
            this.mExtras = bundle0;
            this.sendExtras(bundle0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setFlags(int v) {
            synchronized(this.mLock) {
                this.mFlags = v | 3;
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent pendingIntent0) {
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat0) {
            if(mediaMetadataCompat0 != null) {
                mediaMetadataCompat0 = new Builder(mediaMetadataCompat0, MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized(this.mLock) {
                this.mMetadata = mediaMetadataCompat0;
            }
            this.sendMetadata(mediaMetadataCompat0);
            if(!this.mIsActive) {
                return;
            }
            this.buildRccMetadata((mediaMetadataCompat0 == null ? null : mediaMetadataCompat0.getBundle())).apply();
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat0) {
            synchronized(this.mLock) {
                this.mState = playbackStateCompat0;
            }
            this.sendState(playbackStateCompat0);
            if(!this.mIsActive) {
                return;
            }
            if(playbackStateCompat0 == null) {
                this.mRcc.setPlaybackState(0);
                this.mRcc.setTransportControlFlags(0);
                return;
            }
            this.setRccState(playbackStateCompat0);
            this.mRcc.setTransportControlFlags(this.getRccTransportControlFlagsFromActions(playbackStateCompat0.getActions()));
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackToLocal(int v) {
            x x0 = this.mVolumeProvider;
            if(x0 != null) {
                x0.e = null;
            }
            this.mLocalStream = v;
            this.mVolumeType = 1;
            this.sendVolumeInfoChanged(new ParcelableVolumeInfo(1, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackToRemote(x x0) {
            if(x0 == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            x x1 = this.mVolumeProvider;
            if(x1 != null) {
                x1.e = null;
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = x0;
            this.sendVolumeInfoChanged(new ParcelableVolumeInfo(2, this.mLocalStream, this.mVolumeProvider.a, this.mVolumeProvider.b, this.mVolumeProvider.d));
            x0.e = this.mVolumeCallback;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setQueue(List list0) {
            this.mQueue = list0;
            this.sendQueue(list0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setQueueTitle(CharSequence charSequence0) {
            this.mQueueTitle = charSequence0;
            this.sendQueueTitle(charSequence0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRatingType(int v) {
            this.mRatingType = v;
        }

        public void setRccState(PlaybackStateCompat playbackStateCompat0) {
            this.mRcc.setPlaybackState(this.getRccStateFromState(playbackStateCompat0.getState()));
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRegistrationCallback(RegistrationCallback mediaSessionCompat$RegistrationCallback0, Handler handler0) {
            synchronized(this.mLock) {
                RegistrationCallbackHandler mediaSessionCompat$RegistrationCallbackHandler0 = this.mRegistrationCallbackHandler;
                if(mediaSessionCompat$RegistrationCallbackHandler0 != null) {
                    mediaSessionCompat$RegistrationCallbackHandler0.removeCallbacksAndMessages(null);
                }
                this.mRegistrationCallbackHandler = mediaSessionCompat$RegistrationCallback0 == null ? null : new RegistrationCallbackHandler(handler0.getLooper(), mediaSessionCompat$RegistrationCallback0);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRepeatMode(int v) {
            if(this.mRepeatMode != v) {
                this.mRepeatMode = v;
                this.sendRepeatMode(v);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setSessionActivity(PendingIntent pendingIntent0) {
            synchronized(this.mLock) {
                this.mSessionActivity = pendingIntent0;
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setShuffleMode(int v) {
            if(this.mShuffleMode != v) {
                this.mShuffleMode = v;
                this.sendShuffleMode(v);
            }
        }

        public void setVolumeTo(int v, int v1) {
            if(this.mVolumeType == 2) {
                x x0 = this.mVolumeProvider;
                if(x0 != null) {
                    c c0 = new c(((l4.d)x0), v, 0);
                    ((l4.d)x0).g.c.a.post(c0);
                }
                return;
            }
            this.mAudioManager.setStreamVolume(this.mLocalStream, v, v1);
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent0, ComponentName componentName0) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName0);
        }

        public void updateMbrAndRcc() {
            if(this.mIsActive) {
                this.registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                this.mAudioManager.registerRemoteControlClient(this.mRcc);
                this.setMetadata(this.mMetadata);
                this.setPlaybackState(this.mState);
                return;
            }
            this.unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        static class Api21Impl {
            public static MediaSession.QueueItem createQueueItem(MediaDescription mediaDescription0, long v) {
                return new MediaSession.QueueItem(mediaDescription0, v);
            }

            public static MediaDescription getDescription(MediaSession.QueueItem mediaSession$QueueItem0) {
                return mediaSession$QueueItem0.getDescription();
            }

            public static long getQueueId(MediaSession.QueueItem mediaSession$QueueItem0) {
                return mediaSession$QueueItem0.getQueueId();
            }
        }

        public static final Parcelable.Creator CREATOR = null;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private MediaSession.QueueItem mItemFwk;

        static {
            QueueItem.CREATOR = new Parcelable.Creator() {
                public QueueItem createFromParcel(Parcel parcel0) {
                    return new QueueItem(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public QueueItem[] newArray(int v) {
                    return new QueueItem[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        private QueueItem(MediaSession.QueueItem mediaSession$QueueItem0, MediaDescriptionCompat mediaDescriptionCompat0, long v) {
            if(mediaDescriptionCompat0 == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if(v == -1L) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.mDescription = mediaDescriptionCompat0;
            this.mId = v;
            this.mItemFwk = mediaSession$QueueItem0;
        }

        public QueueItem(Parcel parcel0) {
            this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel0);
            this.mId = parcel0.readLong();
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat0, long v) {
            this(null, mediaDescriptionCompat0, v);
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static QueueItem fromQueueItem(Object object0) {
            return object0 == null ? null : new QueueItem(((MediaSession.QueueItem)object0), MediaDescriptionCompat.fromMediaDescription(Api21Impl.getDescription(((MediaSession.QueueItem)object0))), Api21Impl.getQueueId(((MediaSession.QueueItem)object0)));
        }

        public static List fromQueueItemList(List list0) {
            if(list0 != null) {
                List list1 = new ArrayList(list0.size());
                for(Object object0: list0) {
                    ((ArrayList)list1).add(QueueItem.fromQueueItem(object0));
                }
                return list1;
            }
            return null;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            MediaSession.QueueItem mediaSession$QueueItem0 = this.mItemFwk;
            if(mediaSession$QueueItem0 == null) {
                mediaSession$QueueItem0 = Api21Impl.createQueueItem(((MediaDescription)this.mDescription.getMediaDescription()), this.mId);
                this.mItemFwk = mediaSession$QueueItem0;
            }
            return mediaSession$QueueItem0;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("MediaSession.QueueItem {Description=");
            stringBuilder0.append(this.mDescription);
            stringBuilder0.append(", Id=");
            return U4.x.h(this.mId, " }", stringBuilder0);
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            this.mDescription.writeToParcel(parcel0, v);
            parcel0.writeLong(this.mId);
        }
    }

    public interface RegistrationCallback {
        void onCallbackRegistered(int arg1, int arg2);

        void onCallbackUnregistered(int arg1, int arg2);
    }

    static final class RegistrationCallbackHandler extends Handler {
        private static final int MSG_CALLBACK_REGISTERED = 1001;
        private static final int MSG_CALLBACK_UNREGISTERED = 1002;
        private final RegistrationCallback mCallback;

        public RegistrationCallbackHandler(Looper looper0, RegistrationCallback mediaSessionCompat$RegistrationCallback0) {
            super(looper0);
            this.mCallback = mediaSessionCompat$RegistrationCallback0;
        }

        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            super.handleMessage(message0);
            switch(message0.what) {
                case 1001: {
                    this.mCallback.onCallbackRegistered(message0.arg1, message0.arg2);
                    return;
                }
                case 1002: {
                    this.mCallback.onCallbackUnregistered(message0.arg1, message0.arg2);
                }
            }
        }

        public void postCallbackRegistered(int v, int v1) {
            this.obtainMessage(1001, v, v1).sendToTarget();
        }

        public void postCallbackUnregistered(int v, int v1) {
            this.obtainMessage(1002, v, v1).sendToTarget();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        ResultReceiver mResultReceiver;

        static {
            ResultReceiverWrapper.CREATOR = new Parcelable.Creator() {
                public ResultReceiverWrapper createFromParcel(Parcel parcel0) {
                    return new ResultReceiverWrapper(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public ResultReceiverWrapper[] newArray(int v) {
                    return new ResultReceiverWrapper[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        public ResultReceiverWrapper(Parcel parcel0) {
            this.mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel0);
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver0) {
            this.mResultReceiver = resultReceiver0;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            this.mResultReceiver.writeToParcel(parcel0, v);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private final Object mLock;
        private d mSession2Token;

        static {
            Token.CREATOR = new Parcelable.Creator() {
                public Token createFromParcel(Parcel parcel0) {
                    return new Token(parcel0.readParcelable(null));
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public Token[] newArray(int v) {
                    return new Token[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        public Token(Object object0) {
            this(object0, null, null);
        }

        public Token(Object object0, IMediaSession iMediaSession0) {
            this(object0, iMediaSession0, null);
        }

        public Token(Object object0, IMediaSession iMediaSession0, d d0) {
            this.mLock = new Object();
            this.mInner = object0;
            this.mExtraBinder = iMediaSession0;
            this.mSession2Token = d0;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Token)) {
                return false;
            }
            Object object1 = this.mInner;
            if(object1 == null) {
                return ((Token)object0).mInner == null;
            }
            Object object2 = ((Token)object0).mInner;
            return object2 == null ? false : object1.equals(object2);
        }

        public static Token fromBundle(Bundle bundle0) {
            if(bundle0 != null) {
                bundle0.setClassLoader(Token.class.getClassLoader());
                IMediaSession iMediaSession0 = Stub.asInterface(bundle0.getBinder("android.support.v4.media.session.EXTRA_BINDER"));
                d d0 = a.s(bundle0);
                Token mediaSessionCompat$Token0 = (Token)bundle0.getParcelable("android.support.v4.media.session.TOKEN");
                return mediaSessionCompat$Token0 == null ? null : new Token(mediaSessionCompat$Token0.mInner, iMediaSession0, d0);
            }
            return null;
        }

        public static Token fromToken(Object object0) {
            return Token.fromToken(object0, null);
        }

        public static Token fromToken(Object object0, IMediaSession iMediaSession0) {
            if(object0 != null) {
                if(!(object0 instanceof MediaSession.Token)) {
                    throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
                }
                return new Token(object0, iMediaSession0);
            }
            return null;
        }

        public IMediaSession getExtraBinder() {
            synchronized(this.mLock) {
            }
            return this.mExtraBinder;
        }

        public d getSession2Token() {
            synchronized(this.mLock) {
            }
            return this.mSession2Token;
        }

        public Object getToken() {
            return this.mInner;
        }

        @Override
        public int hashCode() {
            return this.mInner == null ? 0 : this.mInner.hashCode();
        }

        public void setExtraBinder(IMediaSession iMediaSession0) {
            synchronized(this.mLock) {
                this.mExtraBinder = iMediaSession0;
            }
        }

        public void setSession2Token(d d0) {
            synchronized(this.mLock) {
                this.mSession2Token = d0;
            }
        }

        public Bundle toBundle() {
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("android.support.v4.media.session.TOKEN", this);
            synchronized(this.mLock) {
                IMediaSession iMediaSession0 = this.mExtraBinder;
                if(iMediaSession0 != null) {
                    bundle0.putBinder("android.support.v4.media.session.EXTRA_BINDER", iMediaSession0.asBinder());
                }
                d d0 = this.mSession2Token;
                if(d0 != null) {
                    a.x(bundle0, d0);
                }
                return bundle0;
            }
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeParcelable(((Parcelable)this.mInner), v);
        }
    }

    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    @Deprecated
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    @Deprecated
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    private final ArrayList mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;
    static int sMaxBitmapSize;

    private MediaSessionCompat(Context context0, MediaSessionImpl mediaSessionCompat$MediaSessionImpl0) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = mediaSessionCompat$MediaSessionImpl0;
        this.mController = new MediaControllerCompat(context0, this);
    }

    public MediaSessionCompat(Context context0, String s) {
        this(context0, s, null, null);
    }

    public MediaSessionCompat(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0) {
        this(context0, s, componentName0, pendingIntent0, null);
    }

    public MediaSessionCompat(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0, Bundle bundle0) {
        this(context0, s, componentName0, pendingIntent0, bundle0, null);
    }

    public MediaSessionCompat(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0, Bundle bundle0, d d0) {
        this.mActiveListeners = new ArrayList();
        if(context0 == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        if(componentName0 == null) {
            Intent intent0 = new Intent("android.intent.action.MEDIA_BUTTON");
            intent0.setPackage("com.iloen.melon");
            List list0 = context0.getPackageManager().queryBroadcastReceivers(intent0, 0);
            if(list0.size() == 1) {
                ActivityInfo activityInfo0 = ((ResolveInfo)list0.get(0)).activityInfo;
                componentName0 = new ComponentName(activityInfo0.packageName, activityInfo0.name);
            }
            else {
                if(list0.size() > 1) {
                    Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
                }
                componentName0 = null;
            }
            if(componentName0 == null) {
                Log.w("MediaSessionCompat", "Couldn\'t find a unique registered media button receiver in the given context.");
            }
        }
        if(componentName0 != null && pendingIntent0 == null) {
            Intent intent1 = new Intent("android.intent.action.MEDIA_BUTTON");
            intent1.setComponent(componentName0);
            pendingIntent0 = PendingIntent.getBroadcast(context0, 0, intent1, (Build.VERSION.SDK_INT < 0x1F ? 0 : 0x2000000));
        }
        int v = Build.VERSION.SDK_INT;
        if(v >= 29) {
            this.mImpl = new MediaSessionImplApi29(context0, s, d0, bundle0);
        }
        else if(v >= 28) {
            this.mImpl = new MediaSessionImplApi28(context0, s, d0, bundle0);
        }
        else {
            this.mImpl = new MediaSessionImplApi22(context0, s, d0, bundle0);
        }
        Handler handler0 = new Handler((Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper()));
        this.setCallback(new Callback() {
        }, handler0);
        this.mImpl.setMediaButtonReceiver(pendingIntent0);
        this.mController = new MediaControllerCompat(context0, this);
        if(MediaSessionCompat.sMaxBitmapSize == 0) {
            MediaSessionCompat.sMaxBitmapSize = (int)(TypedValue.applyDimension(1, 320.0f, context0.getResources().getDisplayMetrics()) + 0.5f);
        }
    }

    public void addOnActiveChangeListener(OnActiveChangeListener mediaSessionCompat$OnActiveChangeListener0) {
        if(mediaSessionCompat$OnActiveChangeListener0 == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.add(mediaSessionCompat$OnActiveChangeListener0);
    }

    public static void ensureClassLoader(Bundle bundle0) {
        if(bundle0 != null) {
            bundle0.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context0, Object object0) {
        int v = Build.VERSION.SDK_INT;
        if(context0 != null && object0 != null) {
            if(v >= 29) {
                return new MediaSessionCompat(context0, new MediaSessionImplApi29(object0));
            }
            return v < 28 ? new MediaSessionCompat(context0, new MediaSessionImplApi21(object0)) : new MediaSessionCompat(context0, new MediaSessionImplApi28(object0));
        }
        return null;
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public final q getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat0, MediaMetadataCompat mediaMetadataCompat0) {
        long v = -1L;
        if(playbackStateCompat0 != null && playbackStateCompat0.getPosition() != -1L && (playbackStateCompat0.getState() == 3 || playbackStateCompat0.getState() == 4 || playbackStateCompat0.getState() == 5)) {
            long v1 = playbackStateCompat0.getLastPositionUpdateTime();
            if(v1 > 0L) {
                long v2 = SystemClock.elapsedRealtime();
                long v3 = playbackStateCompat0.getPosition() + ((long)(playbackStateCompat0.getPlaybackSpeed() * ((float)(v2 - v1))));
                if(mediaMetadataCompat0 != null && mediaMetadataCompat0.containsKey("android.media.metadata.DURATION")) {
                    v = mediaMetadataCompat0.getLong("android.media.metadata.DURATION");
                }
                if(v >= 0L && v3 > v) {
                    return new android.support.v4.media.session.PlaybackStateCompat.Builder(playbackStateCompat0).setState(playbackStateCompat0.getState(), v, playbackStateCompat0.getPlaybackSpeed(), v2).build();
                }
                return v3 >= 0L ? new android.support.v4.media.session.PlaybackStateCompat.Builder(playbackStateCompat0).setState(playbackStateCompat0.getState(), v3, playbackStateCompat0.getPlaybackSpeed(), v2).build() : new android.support.v4.media.session.PlaybackStateCompat.Builder(playbackStateCompat0).setState(playbackStateCompat0.getState(), 0L, playbackStateCompat0.getPlaybackSpeed(), v2).build();
            }
        }
        return playbackStateCompat0;
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener mediaSessionCompat$OnActiveChangeListener0) {
        if(mediaSessionCompat$OnActiveChangeListener0 == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.remove(mediaSessionCompat$OnActiveChangeListener0);
    }

    public void sendSessionEvent(String s, Bundle bundle0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.mImpl.sendSessionEvent(s, bundle0);
    }

    public void setActive(boolean z) {
        this.mImpl.setActive(z);
        for(Object object0: this.mActiveListeners) {
            ((OnActiveChangeListener)object0).onActiveChanged();
        }
    }

    public void setCallback(Callback mediaSessionCompat$Callback0) {
        this.setCallback(mediaSessionCompat$Callback0, null);
    }

    public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
        if(mediaSessionCompat$Callback0 == null) {
            this.mImpl.setCallback(null, null);
            return;
        }
        MediaSessionImpl mediaSessionCompat$MediaSessionImpl0 = this.mImpl;
        if(handler0 == null) {
            handler0 = new Handler();
        }
        mediaSessionCompat$MediaSessionImpl0.setCallback(mediaSessionCompat$Callback0, handler0);
    }

    public void setCaptioningEnabled(boolean z) {
        this.mImpl.setCaptioningEnabled(z);
    }

    public void setExtras(Bundle bundle0) {
        this.mImpl.setExtras(bundle0);
    }

    public void setFlags(int v) {
        this.mImpl.setFlags(v);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent0) {
        this.mImpl.setMediaButtonReceiver(pendingIntent0);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat0) {
        this.mImpl.setMetadata(mediaMetadataCompat0);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat0) {
        this.mImpl.setPlaybackState(playbackStateCompat0);
    }

    public void setPlaybackToLocal(int v) {
        this.mImpl.setPlaybackToLocal(v);
    }

    public void setPlaybackToRemote(x x0) {
        if(x0 == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.mImpl.setPlaybackToRemote(x0);
    }

    public void setQueue(List list0) {
        if(list0 != null) {
            HashSet hashSet0 = new HashSet();
            for(Object object0: list0) {
                QueueItem mediaSessionCompat$QueueItem0 = (QueueItem)object0;
                if(mediaSessionCompat$QueueItem0 == null) {
                    throw new IllegalArgumentException("queue shouldn\'t have null items");
                }
                if(hashSet0.contains(mediaSessionCompat$QueueItem0.getQueueId())) {
                    Log.e("MediaSessionCompat", "Found duplicate queue id: " + mediaSessionCompat$QueueItem0.getQueueId(), new IllegalArgumentException("id of each queue item should be unique"));
                }
                hashSet0.add(mediaSessionCompat$QueueItem0.getQueueId());
            }
        }
        this.mImpl.setQueue(list0);
    }

    public void setQueueTitle(CharSequence charSequence0) {
        this.mImpl.setQueueTitle(charSequence0);
    }

    public void setRatingType(int v) {
        this.mImpl.setRatingType(v);
    }

    public void setRegistrationCallback(RegistrationCallback mediaSessionCompat$RegistrationCallback0, Handler handler0) {
        this.mImpl.setRegistrationCallback(mediaSessionCompat$RegistrationCallback0, handler0);
    }

    public void setRepeatMode(int v) {
        this.mImpl.setRepeatMode(v);
    }

    public void setSessionActivity(PendingIntent pendingIntent0) {
        this.mImpl.setSessionActivity(pendingIntent0);
    }

    public void setShuffleMode(int v) {
        this.mImpl.setShuffleMode(v);
    }

    public static Bundle unparcelWithClassLoader(Bundle bundle0) {
        if(bundle0 == null) {
            return null;
        }
        MediaSessionCompat.ensureClassLoader(bundle0);
        try {
            bundle0.isEmpty();
            return bundle0;
        }
        catch(BadParcelableException unused_ex) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }
}

