package Z2;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.view.KeyEvent;

public final class b extends ConnectionCallback {
    public final Context a;
    public final Intent b;
    public final BroadcastReceiver.PendingResult c;
    public MediaBrowserCompat d;

    public b(BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0, Context context0, Intent intent0) {
        this.a = context0;
        this.b = intent0;
        this.c = broadcastReceiver$PendingResult0;
    }

    @Override  // android.support.v4.media.MediaBrowserCompat$ConnectionCallback
    public final void onConnected() {
        Token mediaSessionCompat$Token0 = this.d.getSessionToken();
        new MediaControllerCompat(this.a, mediaSessionCompat$Token0).dispatchMediaButtonEvent(((KeyEvent)this.b.getParcelableExtra("android.intent.extra.KEY_EVENT")));
        this.d.disconnect();
        this.c.finish();
    }

    @Override  // android.support.v4.media.MediaBrowserCompat$ConnectionCallback
    public final void onConnectionFailed() {
        this.d.disconnect();
        this.c.finish();
    }

    @Override  // android.support.v4.media.MediaBrowserCompat$ConnectionCallback
    public final void onConnectionSuspended() {
        this.d.disconnect();
        this.c.finish();
    }
}

