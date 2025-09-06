package com.google.android.gms.cast.framework.media.internal;

import W.m;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat.Callback;
import android.view.KeyEvent;
import com.google.android.gms.cast.MediaSeekOptions.Builder;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

final class zzr extends Callback {
    final zzu zza;

    public zzr(zzu zzu0) {
        this.zza = zzu0;
        super();
    }

    @Override  // android.support.v4.media.session.MediaSessionCompat$Callback
    public final void onCustomAction(String s, Bundle bundle0) {
        zzu.zzf().d("onCustomAction with action = %s", new Object[]{s});
        switch(s) {
            case "com.google.android.gms.cast.framework.action.DISCONNECT": {
                zzu zzu1 = this.zza;
                if(zzu.zzc(zzu1) != null) {
                    zzu.zzc(zzu1).endCurrentSession(false);
                    return;
                }
                break;
            }
            case "com.google.android.gms.cast.framework.action.FORWARD": {
                this.zza(zzu.zzd(this.zza).getSkipStepMs());
                return;
            }
            case "com.google.android.gms.cast.framework.action.REWIND": {
                this.zza(-zzu.zzd(this.zza).getSkipStepMs());
                return;
            }
            case "com.google.android.gms.cast.framework.action.STOP_CASTING": {
                zzu zzu0 = this.zza;
                if(zzu.zzc(zzu0) != null) {
                    zzu.zzc(zzu0).endCurrentSession(true);
                    return;
                }
                break;
            }
            default: {
                Intent intent0 = new Intent(s);
                intent0.setComponent(zzu.zza(this.zza));
                Context context0 = zzu.zzb(this.zza);
                if(Build.VERSION.SDK_INT < 34) {
                    context0.sendBroadcast(intent0);
                    return;
                }
                m.u(context0, intent0, m.e(BroadcastOptions.makeBasic()).toBundle());
            }
        }
    }

    @Override  // android.support.v4.media.session.MediaSessionCompat$Callback
    public final boolean onMediaButtonEvent(Intent intent0) {
        zzu.zzf().d("onMediaButtonEvent", new Object[0]);
        KeyEvent keyEvent0 = (KeyEvent)intent0.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if(keyEvent0 != null) {
            switch(keyEvent0.getKeyCode()) {
                case 0x7E: 
                case 0x7F: {
                    zzu zzu0 = this.zza;
                    if(zzu.zze(zzu0) != null) {
                        zzu.zze(zzu0).togglePlayback();
                    }
                    break;
                }
                default: {
                    return true;
                }
            }
        }
        return true;
    }

    @Override  // android.support.v4.media.session.MediaSessionCompat$Callback
    public final void onPause() {
        zzu.zzf().d("onPause", new Object[0]);
        zzu zzu0 = this.zza;
        if(zzu.zze(zzu0) != null) {
            zzu.zze(zzu0).togglePlayback();
        }
    }

    @Override  // android.support.v4.media.session.MediaSessionCompat$Callback
    public final void onPlay() {
        zzu.zzf().d("onPlay", new Object[0]);
        zzu zzu0 = this.zza;
        if(zzu.zze(zzu0) != null) {
            zzu.zze(zzu0).togglePlayback();
        }
    }

    @Override  // android.support.v4.media.session.MediaSessionCompat$Callback
    public final void onSeekTo(long v) {
        zzu.zzf().d("onSeekTo %d", new Object[]{v});
        this.zzb(v);
    }

    @Override  // android.support.v4.media.session.MediaSessionCompat$Callback
    public final void onSkipToNext() {
        zzu.zzf().d("onSkipToNext", new Object[0]);
        zzu zzu0 = this.zza;
        if(zzu.zze(zzu0) != null) {
            zzu.zze(zzu0).queueNext(null);
        }
    }

    @Override  // android.support.v4.media.session.MediaSessionCompat$Callback
    public final void onSkipToPrevious() {
        zzu.zzf().d("onSkipToPrevious", new Object[0]);
        zzu zzu0 = this.zza;
        if(zzu.zze(zzu0) != null) {
            zzu.zze(zzu0).queuePrev(null);
        }
    }

    private final void zza(long v) {
        RemoteMediaClient remoteMediaClient0 = zzu.zze(this.zza);
        if(remoteMediaClient0 == null) {
            return;
        }
        long v1 = Math.max(0L, remoteMediaClient0.getApproximateStreamPosition() + v);
        this.zzb(Math.min(remoteMediaClient0.getStreamDuration(), v1));
    }

    private final void zzb(long v) {
        RemoteMediaClient remoteMediaClient0 = zzu.zze(this.zza);
        if(remoteMediaClient0 == null) {
            return;
        }
        Builder mediaSeekOptions$Builder0 = new Builder();
        mediaSeekOptions$Builder0.setPosition(v);
        remoteMediaClient0.seek(mediaSeekOptions$Builder0.build());
    }
}

