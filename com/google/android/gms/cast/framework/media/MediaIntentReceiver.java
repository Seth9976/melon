package com.google.android.gms.cast.framework.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;

@Keep
public class MediaIntentReceiver extends BroadcastReceiver {
    public static final String ACTION_DISCONNECT = "com.google.android.gms.cast.framework.action.DISCONNECT";
    public static final String ACTION_FORWARD = "com.google.android.gms.cast.framework.action.FORWARD";
    public static final String ACTION_REWIND = "com.google.android.gms.cast.framework.action.REWIND";
    public static final String ACTION_SKIP_NEXT = "com.google.android.gms.cast.framework.action.SKIP_NEXT";
    public static final String ACTION_SKIP_PREV = "com.google.android.gms.cast.framework.action.SKIP_PREV";
    public static final String ACTION_STOP_CASTING = "com.google.android.gms.cast.framework.action.STOP_CASTING";
    public static final String ACTION_TOGGLE_PLAYBACK = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK";
    public static final String EXTRA_SKIP_STEP_MS = "googlecast-extra_skip_step_ms";
    private static final String TAG = "MediaIntentReceiver";
    private static final Logger log;

    static {
        MediaIntentReceiver.log = new Logger("MediaIntentReceiver");
    }

    private static RemoteMediaClient getRemoteMediaClient(CastSession castSession0) {
        return castSession0 == null || !castSession0.isConnected() ? null : castSession0.getRemoteMediaClient();
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        String s = intent0.getAction();
        MediaIntentReceiver.log.d("onReceive action: %s", new Object[]{s});
        if(s != null) {
            SessionManager sessionManager0 = CastContext.getSharedInstance(context0).getSessionManager();
            Session session0 = sessionManager0.getCurrentSession();
            if(session0 != null) {
                switch(s) {
                    case "android.intent.action.MEDIA_BUTTON": {
                        this.onReceiveActionMediaButton(session0, intent0);
                        return;
                    }
                    case "com.google.android.gms.cast.framework.action.DISCONNECT": {
                        sessionManager0.endCurrentSession(false);
                        return;
                    }
                    case "com.google.android.gms.cast.framework.action.FORWARD": {
                        this.onReceiveActionForward(session0, intent0.getLongExtra("googlecast-extra_skip_step_ms", 0L));
                        return;
                    }
                    case "com.google.android.gms.cast.framework.action.REWIND": {
                        this.onReceiveActionRewind(session0, intent0.getLongExtra("googlecast-extra_skip_step_ms", 0L));
                        return;
                    }
                    case "com.google.android.gms.cast.framework.action.SKIP_NEXT": {
                        this.onReceiveActionSkipNext(session0);
                        return;
                    }
                    case "com.google.android.gms.cast.framework.action.SKIP_PREV": {
                        this.onReceiveActionSkipPrev(session0);
                        return;
                    }
                    case "com.google.android.gms.cast.framework.action.STOP_CASTING": {
                        sessionManager0.endCurrentSession(true);
                        return;
                    }
                    case "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK": {
                        this.onReceiveActionTogglePlayback(session0);
                        break;
                    }
                }
            }
        }
    }

    public void onReceiveActionForward(Session session0, long v) {
        if(session0 instanceof CastSession) {
            this.seek(((CastSession)session0), v);
        }
    }

    public void onReceiveActionMediaButton(Session session0, Intent intent0) {
        if(session0 instanceof CastSession && intent0.hasExtra("android.intent.extra.KEY_EVENT")) {
            KeyEvent keyEvent0 = (KeyEvent)((Bundle)Preconditions.checkNotNull(intent0.getExtras())).get("android.intent.extra.KEY_EVENT");
            if(keyEvent0 != null && keyEvent0.getAction() == 0 && keyEvent0.getKeyCode() == 85) {
                this.togglePlayback(((CastSession)session0));
            }
        }
    }

    public void onReceiveActionRewind(Session session0, long v) {
        if(session0 instanceof CastSession) {
            this.seek(((CastSession)session0), -v);
        }
    }

    public void onReceiveActionSkipNext(Session session0) {
        if(session0 instanceof CastSession) {
            RemoteMediaClient remoteMediaClient0 = MediaIntentReceiver.getRemoteMediaClient(((CastSession)session0));
            if(remoteMediaClient0 != null && !remoteMediaClient0.isPlayingAd()) {
                remoteMediaClient0.queueNext(null);
            }
        }
    }

    public void onReceiveActionSkipPrev(Session session0) {
        if(session0 instanceof CastSession) {
            RemoteMediaClient remoteMediaClient0 = MediaIntentReceiver.getRemoteMediaClient(((CastSession)session0));
            if(remoteMediaClient0 != null && !remoteMediaClient0.isPlayingAd()) {
                remoteMediaClient0.queuePrev(null);
            }
        }
    }

    public void onReceiveActionTogglePlayback(Session session0) {
        if(session0 instanceof CastSession) {
            this.togglePlayback(((CastSession)session0));
        }
    }

    public void onReceiveOtherAction(Context context0, String s, Intent intent0) {
    }

    @Deprecated
    public void onReceiveOtherAction(String s, Intent intent0) {
    }

    private void seek(CastSession castSession0, long v) {
        if(v != 0L) {
            RemoteMediaClient remoteMediaClient0 = MediaIntentReceiver.getRemoteMediaClient(castSession0);
            if(remoteMediaClient0 != null && !remoteMediaClient0.isLiveStream() && !remoteMediaClient0.isPlayingAd()) {
                remoteMediaClient0.seek(remoteMediaClient0.getApproximateStreamPosition() + v);
            }
        }
    }

    private void togglePlayback(CastSession castSession0) {
        RemoteMediaClient remoteMediaClient0 = MediaIntentReceiver.getRemoteMediaClient(castSession0);
        if(remoteMediaClient0 == null) {
            return;
        }
        remoteMediaClient0.togglePlayback();
    }
}

