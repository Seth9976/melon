package androidx.media3.session.legacy;

import E9.m;
import Q0.a;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import e3.b;
import java.lang.ref.WeakReference;
import x9.c;

public final class h extends MediaBrowser.ConnectionCallback {
    public final a a;

    public h(a a0) {
        this.a = a0;
        super();
    }

    @Override  // android.media.browse.MediaBrowser$ConnectionCallback
    public final void onConnected() {
        Bundle bundle0;
        MediaBrowser mediaBrowser0;
        m m0;
        a a0 = this.a;
        i i0 = (i)a0.b;
        if(i0 != null) {
            try {
                m0 = i0.d;
                mediaBrowser0 = i0.b;
                bundle0 = mediaBrowser0.getExtras();
            }
            catch(IllegalStateException illegalStateException0) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", illegalStateException0);
                a0.p();
                return;
            }
            if(bundle0 != null) {
                boolean z = false;
                bundle0.getInt("extra_service_version", 0);
                IBinder iBinder0 = bundle0.getBinder("extra_messenger");
                if(iBinder0 != null) {
                    c c0 = new c(5);
                    c0.b = new Messenger(iBinder0);
                    c0.c = i0.c;
                    i0.f = c0;
                    Messenger messenger0 = new Messenger(m0);
                    i0.g = messenger0;
                    m0.getClass();
                    m0.c = new WeakReference(messenger0);
                    try {
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("data_package_name", "com.iloen.melon");
                        bundle1.putInt("data_calling_pid", Process.myPid());
                        bundle1.putBundle("data_root_hints", ((Bundle)c0.c));
                        c0.f(6, bundle1, messenger0);
                    }
                    catch(RemoteException unused_ex) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                f f0 = P.C0(bundle0.getBinder("extra_session_binder"));
                if(f0 != null) {
                    MediaSession.Token mediaSession$Token0 = mediaBrowser0.getSessionToken();
                    if(mediaSession$Token0 != null) {
                        z = true;
                    }
                    b.j(z);
                    if(mediaSession$Token0 == null) {
                        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
                    }
                    i0.h = new MediaSessionCompat.Token(mediaSession$Token0, f0, null);
                }
            }
        }
        a0.p();
    }

    @Override  // android.media.browse.MediaBrowser$ConnectionCallback
    public final void onConnectionFailed() {
        this.a.q();
    }

    @Override  // android.media.browse.MediaBrowser$ConnectionCallback
    public final void onConnectionSuspended() {
        a a0 = this.a;
        i i0 = (i)a0.b;
        if(i0 != null) {
            i0.f = null;
            i0.g = null;
            i0.h = null;
            i0.d.getClass();
            i0.d.c = new WeakReference(null);
        }
        a0.r();
    }
}

