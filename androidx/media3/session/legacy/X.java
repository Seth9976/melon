package androidx.media3.session.legacy;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.lifecycle.b;

public final class x implements Runnable {
    public final int a;
    public final z b;
    public final String c;
    public final Bundle d;
    public final ResultReceiver e;
    public final b f;

    public x(b b0, z z0, String s, Bundle bundle0, ResultReceiver resultReceiver0, int v) {
        this.a = v;
        this.f = b0;
        this.b = z0;
        this.c = s;
        this.d = bundle0;
        this.e = resultReceiver0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            IBinder iBinder0 = this.b.a.getBinder();
            b b0 = this.f;
            n n0 = (n)((MediaBrowserServiceCompat)b0.b).e.get(iBinder0);
            Bundle bundle0 = this.d;
            String s = this.c;
            if(n0 == null) {
                Log.w("MBServiceCompat", "sendCustomAction for callback that isn\'t registered action=" + s + ", extras=" + bundle0);
                return;
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat0 = (MediaBrowserServiceCompat)b0.b;
            o o0 = new o(2, s, this.e);
            mediaBrowserServiceCompat0.f = n0;
            mediaBrowserServiceCompat0.b(s, (bundle0 == null ? Bundle.EMPTY : bundle0), o0);
            mediaBrowserServiceCompat0.f = null;
            if(!o0.b()) {
                throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + s + " extras=" + bundle0);
            }
            return;
        }
        IBinder iBinder1 = this.b.a.getBinder();
        b b1 = this.f;
        n n1 = (n)((MediaBrowserServiceCompat)b1.b).e.get(iBinder1);
        String s1 = this.c;
        if(n1 == null) {
            androidx.appcompat.app.o.A("search for callback that isn\'t registered query=", s1, "MBServiceCompat");
            return;
        }
        MediaBrowserServiceCompat mediaBrowserServiceCompat1 = (MediaBrowserServiceCompat)b1.b;
        m m0 = new m(s1, this.e);
        mediaBrowserServiceCompat1.f = n1;
        mediaBrowserServiceCompat1.g(s1, this.d, m0);
        mediaBrowserServiceCompat1.f = null;
        if(!m0.b()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + s1);
        }
    }
}

