package X2;

import Ua.h;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.b;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.z;
import java.util.Iterator;

public final class n implements Runnable {
    public final int a;
    public final int b;
    public final String c;
    public final int d;
    public final Object e;
    public final Object f;

    public n(Object object0, Object object1, int v, String s, int v1, Bundle bundle0, int v2) {
        this.a = v2;
        this.f = object0;
        this.e = object1;
        this.b = v;
        this.c = s;
        this.d = v1;
        super();
    }

    @Override
    public final void run() {
        a a0;
        androidx.media3.session.legacy.n n0;
        if(this.a != 0) {
            z z0 = (z)this.e;
            IBinder iBinder0 = z0.a.getBinder();
            ((MediaBrowserServiceCompat)((b)this.f).b).e.remove(iBinder0);
            MediaBrowserServiceCompat mediaBrowserServiceCompat0 = (MediaBrowserServiceCompat)((b)this.f).b;
            Iterator iterator0 = mediaBrowserServiceCompat0.d.iterator();
            while(true) {
                n0 = null;
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object0 = iterator0.next();
                androidx.media3.session.legacy.n n1 = (androidx.media3.session.legacy.n)object0;
                if(n1.c == this.b) {
                    if(TextUtils.isEmpty(this.c) || this.d <= 0) {
                        n0 = new androidx.media3.session.legacy.n(mediaBrowserServiceCompat0, n1.a, n1.b, n1.c, z0);
                    }
                    iterator0.remove();
                    break;
                }
            }
            if(n0 == null) {
                n0 = new androidx.media3.session.legacy.n(mediaBrowserServiceCompat0, this.c, this.d, this.b, z0);
            }
            mediaBrowserServiceCompat0.e.put(iBinder0, n0);
            try {
                iBinder0.linkToDeath(n0, 0);
            }
            catch(RemoteException unused_ex) {
                Log.w("MBServiceCompat", "IBinder is already dead.");
            }
            return;
        }
        p p0 = (p)this.e;
        IBinder iBinder1 = p0.a.getBinder();
        ((androidx.media.MediaBrowserServiceCompat)((h)this.f).a).e.remove(iBinder1);
        androidx.media.MediaBrowserServiceCompat mediaBrowserServiceCompat1 = (androidx.media.MediaBrowserServiceCompat)((h)this.f).a;
        Iterator iterator1 = mediaBrowserServiceCompat1.d.iterator();
        while(true) {
            a0 = null;
            if(!iterator1.hasNext()) {
                break;
            }
            Object object1 = iterator1.next();
            a a1 = (a)object1;
            if(a1.c == this.b) {
                if(TextUtils.isEmpty(this.c) || this.d <= 0) {
                    a0 = new a(mediaBrowserServiceCompat1, a1.a, a1.b, a1.c, p0);
                }
                iterator1.remove();
                break;
            }
        }
        if(a0 == null) {
            a0 = new a(mediaBrowserServiceCompat1, this.c, this.d, this.b, p0);
        }
        mediaBrowserServiceCompat1.e.put(iBinder1, a0);
        try {
            iBinder1.linkToDeath(a0, 0);
        }
        catch(RemoteException unused_ex) {
            Log.w("MBServiceCompat", "IBinder is already dead.");
        }
    }
}

