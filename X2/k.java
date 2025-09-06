package X2;

import Q0.m;
import Ua.h;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.appcompat.app.o;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.n;
import androidx.media3.session.legacy.z;
import b2.b;
import com.google.firebase.messaging.u;
import h7.u0;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import jg.g;
import k8.Y;
import kotlin.jvm.internal.q;
import pc.t;
import pg.c;

public final class k implements Runnable {
    public final int a;
    public Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    public k(h h0, p p0, String s, Bundle bundle0, ResultReceiver resultReceiver0) {
        this.a = 1;
        super();
        this.e = h0;
        this.b = p0;
        this.c = s;
        this.d = bundle0;
        this.f = resultReceiver0;
    }

    public k(u u0, m m0) {
        this.a = 3;
        q.g(u0, "taskExecutors");
        super();
        this.d = u0;
        this.e = m0;
        List list0 = Collections.synchronizedList(new LinkedList());
        q.f(list0, "Collections.synchronizedList(LinkedList())");
        this.c = list0;
        this.f = new c(((t)u0.d));
    }

    public k(Object object0, Object object1, String s, IBinder iBinder0, Bundle bundle0, int v) {
        this.a = v;
        this.e = object0;
        this.b = object1;
        this.c = s;
        this.f = iBinder0;
        this.d = bundle0;
        super();
    }

    @Override
    public final void run() {
        ServerSocket serverSocket1;
        switch(this.a) {
            case 0: {
                String s = (String)this.c;
                IBinder iBinder0 = ((p)this.b).a.getBinder();
                h h0 = (h)this.e;
                a a0 = (a)((MediaBrowserServiceCompat)h0.a).e.get(iBinder0);
                if(a0 == null) {
                    o.A("addSubscription for callback that isn\'t registered id=", s, "MBServiceCompat");
                    return;
                }
                HashMap hashMap0 = a0.e;
                MediaBrowserServiceCompat mediaBrowserServiceCompat0 = (MediaBrowserServiceCompat)h0.a;
                IBinder iBinder1 = (IBinder)this.f;
                Bundle bundle0 = (Bundle)this.d;
                List list0 = (List)hashMap0.get(s);
                if(list0 == null) {
                    list0 = new ArrayList();
                }
                for(Object object0: list0) {
                    if(iBinder1 == ((b)object0).a && u0.i(bundle0, ((Bundle)((b)object0).b))) {
                        return;
                    }
                    if(false) {
                        break;
                    }
                }
                list0.add(new b(iBinder1, bundle0));
                hashMap0.put(s, list0);
                if(bundle0 != null) {
                }
                mediaBrowserServiceCompat0.b();
                throw new IllegalStateException(Y.l(new StringBuilder("onLoadChildren must call detach() or sendResult() before returning for package="), a0.a, " id=", s));
            }
            case 1: {
                IBinder iBinder2 = ((p)this.b).a.getBinder();
                if(((a)((MediaBrowserServiceCompat)((h)this.e).a).e.get(iBinder2)) == null) {
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn\'t registered action=" + ((String)this.c) + ", extras=" + ((Bundle)this.d));
                    return;
                }
                ((ResultReceiver)this.f).send(-1, null);
                return;
            }
            case 2: {
                String s1 = (String)this.c;
                IBinder iBinder3 = ((z)this.b).a.getBinder();
                androidx.lifecycle.b b1 = (androidx.lifecycle.b)this.e;
                n n0 = (n)((androidx.media3.session.legacy.MediaBrowserServiceCompat)b1.b).e.get(iBinder3);
                if(n0 == null) {
                    o.A("addSubscription for callback that isn\'t registered id=", s1, "MBServiceCompat");
                    return;
                }
                HashMap hashMap1 = n0.f;
                androidx.media3.session.legacy.MediaBrowserServiceCompat mediaBrowserServiceCompat1 = (androidx.media3.session.legacy.MediaBrowserServiceCompat)b1.b;
                IBinder iBinder4 = (IBinder)this.f;
                Bundle bundle1 = (Bundle)this.d;
                List list1 = (List)hashMap1.get(s1);
                if(list1 == null) {
                    list1 = new ArrayList();
                }
                for(Object object1: list1) {
                    b b2 = (b)object1;
                    if(iBinder4 != b2.a) {
                        continue;
                    }
                    Bundle bundle2 = (Bundle)b2.b;
                    if(bundle1 == bundle2) {
                        return;
                    }
                    if(bundle1 == null) {
                        e3.b.k(bundle2);
                        if(bundle2.getInt("android.media.browse.extra.PAGE", -1) != -1 || bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1) {
                            continue;
                        }
                        return;
                    }
                    if(bundle2 == null) {
                        if(bundle1.getInt("android.media.browse.extra.PAGE", -1) != -1 || bundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1) {
                            continue;
                        }
                        return;
                    }
                    if(bundle1.getInt("android.media.browse.extra.PAGE", -1) != bundle2.getInt("android.media.browse.extra.PAGE", -1) || bundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
                        continue;
                    }
                    return;
                }
                list1.add(new b(iBinder4, bundle1));
                hashMap1.put(s1, list1);
                mediaBrowserServiceCompat1.j(s1, n0, bundle1, null);
                mediaBrowserServiceCompat1.f = n0;
                mediaBrowserServiceCompat1.h(bundle1, s1);
                mediaBrowserServiceCompat1.f = null;
                return;
            }
            default: {
                c c0 = (c)this.f;
                Thread thread0 = Thread.currentThread();
                q.f(thread0, "it");
                thread0.setName("jeb-dexdec-sb-st-809-event-receiver");
                try {
                    ServerSocket serverSocket0 = new ServerSocket(0);
                    this.b = serverSocket0;
                    c0.b();
                    while(!c0.a()) {
                        Socket socket0 = serverSocket0.accept();
                        q.f(socket0, "it");
                        socket0.setSoTimeout(g.c);
                        og.b b0 = new og.b(((u)this.d), this, socket0);
                        ((List)this.c).add(b0);
                        b0.a.c(b0);
                    }
                }
                catch(IOException unused_ex) {
                    serverSocket1 = (ServerSocket)this.b;
                    if(serverSocket1 != null) {
                        try {
                            serverSocket1.close();
                        }
                        catch(IOException unused_ex) {
                        }
                    }
                    this.b = null;
                    return;
                }
                catch(Throwable throwable0) {
                    ServerSocket serverSocket2 = (ServerSocket)this.b;
                    if(serverSocket2 != null) {
                        try {
                            serverSocket2.close();
                        }
                        catch(IOException unused_ex) {
                        }
                    }
                    this.b = null;
                    throw throwable0;
                }
                serverSocket1 = (ServerSocket)this.b;
                if(serverSocket1 != null) {
                    try {
                        serverSocket1.close();
                    }
                    catch(IOException unused_ex) {
                    }
                }
                this.b = null;
            }
        }
    }
}

