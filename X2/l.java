package X2;

import Ua.h;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.o;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.b0;
import androidx.media3.session.legacy.n;
import androidx.media3.session.legacy.z;
import androidx.room.H;
import androidx.room.I;
import androidx.room.J;
import b2.b;
import c2.g0;
import c2.l0;
import i.n.i.b.a.s.e.Ga;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import k.f;
import k.m;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import me.e;
import me.i;
import x9.c;

public final class l implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public l(int v, Object object0, Object object1, Object object2, Object object3, boolean z) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        this.d = object2;
        this.e = object3;
        super();
    }

    public l(Object object0, Object object1, Object object2, Object object3, int v) {
        this.a = v;
        this.e = object0;
        this.c = object1;
        this.b = object2;
        this.d = object3;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                String s = (String)this.b;
                IBinder iBinder0 = ((p)this.c).a.getBinder();
                a a0 = (a)((MediaBrowserServiceCompat)((h)this.e).a).e.get(iBinder0);
                if(a0 == null) {
                    o.A("removeSubscription for callback that isn\'t registered id=", s, "MBServiceCompat");
                    return;
                }
                HashMap hashMap0 = a0.e;
                IBinder iBinder1 = (IBinder)this.d;
                boolean z = false;
                if(iBinder1 != null) {
                    List list0 = (List)hashMap0.get(s);
                    if(list0 != null) {
                        Iterator iterator0 = list0.iterator();
                        while(iterator0.hasNext()) {
                            Object object0 = iterator0.next();
                            if(iBinder1 == ((b)object0).a) {
                                iterator0.remove();
                                z = true;
                            }
                        }
                        if(list0.size() == 0) {
                            hashMap0.remove(s);
                        }
                    }
                }
                else if(hashMap0.remove(s) != null) {
                    z = true;
                }
                if(!z) {
                    Log.w("MBServiceCompat", "removeSubscription called for " + s + " which is not subscribed");
                }
                return;
            }
            case 1: {
                androidx.media3.session.legacy.p p0 = (androidx.media3.session.legacy.p)this.e;
                for(int v = 0; v < ((androidx.media3.session.legacy.MediaBrowserServiceCompat)p0.d).e.size(); ++v) {
                    n n0 = (n)((androidx.media3.session.legacy.MediaBrowserServiceCompat)p0.d).e.valueAt(v);
                    if(n0.d.equals(((b0)this.c))) {
                        p0.m(n0, ((String)this.b), ((Bundle)this.d));
                    }
                }
                return;
            }
            case 2: {
                String s1 = (String)this.b;
                IBinder iBinder2 = ((z)this.c).a.getBinder();
                androidx.lifecycle.b b0 = (androidx.lifecycle.b)this.e;
                n n1 = (n)((androidx.media3.session.legacy.MediaBrowserServiceCompat)b0.b).e.get(iBinder2);
                if(n1 == null) {
                    o.A("removeSubscription for callback that isn\'t registered id=", s1, "MBServiceCompat");
                    return;
                }
                HashMap hashMap1 = n1.f;
                androidx.media3.session.legacy.MediaBrowserServiceCompat mediaBrowserServiceCompat0 = (androidx.media3.session.legacy.MediaBrowserServiceCompat)b0.b;
                IBinder iBinder3 = (IBinder)this.d;
                boolean z1 = false;
                try {
                    if(iBinder3 != null) {
                        List list1 = (List)hashMap1.get(s1);
                        if(list1 != null) {
                            Iterator iterator1 = list1.iterator();
                            while(iterator1.hasNext()) {
                                Object object1 = iterator1.next();
                                if(iBinder3 == ((b)object1).a) {
                                    iterator1.remove();
                                    z1 = true;
                                }
                            }
                            if(list1.size() == 0) {
                                hashMap1.remove(s1);
                            }
                        }
                    }
                    else if(hashMap1.remove(s1) != null) {
                        z1 = true;
                    }
                }
                finally {
                    mediaBrowserServiceCompat0.f = n1;
                    mediaBrowserServiceCompat0.i(s1);
                    mediaBrowserServiceCompat0.f = null;
                }
                if(!z1) {
                    Log.w("MBServiceCompat", "removeSubscription called for " + s1 + " which is not subscribed");
                }
                return;
            }
            case 3: {
                String s2 = (String)this.b;
                IBinder iBinder4 = ((z)this.c).a.getBinder();
                androidx.lifecycle.b b1 = (androidx.lifecycle.b)this.e;
                n n2 = (n)((androidx.media3.session.legacy.MediaBrowserServiceCompat)b1.b).e.get(iBinder4);
                if(n2 == null) {
                    o.A("getMediaItem for callback that isn\'t registered id=", s2, "MBServiceCompat");
                    return;
                }
                androidx.media3.session.legacy.MediaBrowserServiceCompat mediaBrowserServiceCompat1 = (androidx.media3.session.legacy.MediaBrowserServiceCompat)b1.b;
                androidx.media3.session.legacy.l l0 = new androidx.media3.session.legacy.l(s2, ((ResultReceiver)this.d));
                mediaBrowserServiceCompat1.f = n2;
                mediaBrowserServiceCompat1.f(s2, l0);
                mediaBrowserServiceCompat1.f = null;
                if(!l0.b()) {
                    throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + s2);
                }
                return;
            }
            case 4: {
                CancellableContinuationImpl cancellableContinuationImpl0 = (CancellableContinuationImpl)this.b;
                try {
                    BuildersKt.runBlocking(((i)this.c).minusKey(e.a), new I(((H)this.d), cancellableContinuationImpl0, ((J)this.e), null));
                }
                catch(Throwable throwable0) {
                    cancellableContinuationImpl0.cancel(throwable0);
                }
                return;
            }
            case 5: {
                g0.i(((View)this.c), ((l0)this.b), ((c)this.d));
                ((ValueAnimator)this.e).start();
                return;
            }
            default: {
                f f0 = (f)((Ga)this.e).b;
                m m0 = (m)this.b;
                k.e e0 = (k.e)this.c;
                if(e0 != null) {
                    f0.T = true;
                    e0.b.c(false);
                    f0.T = false;
                }
                if(m0.isEnabled() && m0.hasSubMenu()) {
                    ((MenuBuilder)this.d).q(m0, null, 4);
                }
            }
        }
    }
}

