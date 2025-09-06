package androidx.media3.session;

import A3.l;
import A3.m;
import B0.t;
import D5.a;
import I6.V;
import I6.p0;
import I7.c;
import I7.k;
import M6.B;
import T3.e;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.collection.f;
import androidx.media3.session.legacy.MediaSessionCompat.Token;
import androidx.media3.session.legacy.Q;
import androidx.media3.session.legacy.b0;
import e3.b;
import e3.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public abstract class MediaSessionService extends Service {
    public final Object a;
    public final Handler b;
    public final f c;
    public O0 d;
    public t0 e;
    public DefaultMediaNotificationProvider f;
    public e g;
    public c h;
    public static final int i;

    public MediaSessionService() {
        this.a = new Object();
        this.b = new Handler(Looper.getMainLooper());
        this.c = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    public final void a(y0 y00) {
        boolean z = true;
        b.d(!y00.a.l(), "session is already released");
        synchronized(this.a) {
            y0 y01 = (y0)this.c.get(y00.a.i);
            if(y01 != null && y01 != y00) {
                z = false;
            }
            b.d(z, "Session ID should be unique");
            this.c.put(y00.a.i, y00);
        }
        if(y01 == null) {
            k k0 = new k(this, this.c(), y00, 18);
            x.P(this.b, k0);
        }
    }

    public final e b() {
        synchronized(this.a) {
            if(this.g == null) {
                e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                e0.a = 0;
                e0.b = this;
                this.g = e0;
            }
            return this.g;
        }
    }

    public final t0 c() {
        synchronized(this.a) {
            if(this.e == null) {
                if(this.f == null) {
                    Builder defaultMediaNotificationProvider$Builder0 = new Builder(this.getApplicationContext());
                    b.j(!defaultMediaNotificationProvider$Builder0.e);
                    DefaultMediaNotificationProvider defaultMediaNotificationProvider0 = new DefaultMediaNotificationProvider(defaultMediaNotificationProvider$Builder0.a, defaultMediaNotificationProvider$Builder0.b, defaultMediaNotificationProvider$Builder0.c, defaultMediaNotificationProvider$Builder0.d);
                    defaultMediaNotificationProvider$Builder0.e = true;
                    this.f = defaultMediaNotificationProvider0;
                }
                this.e = new t0(this, this.f, this.b());
            }
            return this.e;
        }
    }

    public final ArrayList d() {
        synchronized(this.a) {
        }
        return new ArrayList(this.c.values());
    }

    public final boolean e(y0 y00) {
        synchronized(this.a) {
        }
        return this.c.containsKey(y00.a.i);
    }

    public abstract f0 f(w0 arg1);

    public final void g(y0 y00, boolean z) {
        V v3;
        t0 t00 = this.c();
        if(t00.a.e(y00)) {
            v v0 = t00.a(y00);
            if(v0 != null && !v0.getCurrentTimeline().p() && v0.getPlaybackState() != 1) {
                int v1 = t00.h + 1;
                t00.h = v1;
                B b0 = (B)t00.g.get(y00);
                v v2 = null;
                if(b0 != null && b0.isDone()) {
                    try {
                        v2 = (v)com.google.firebase.b.D(b0);
                    }
                    catch(ExecutionException unused_ex) {
                    }
                }
                if(v2 == null) {
                    v3 = p0.e;
                }
                else {
                    v2.h0();
                    u u0 = v2.c;
                    v3 = u0.isConnected() ? u0.Z() : p0.e;
                }
                W5.e e0 = new W5.e(t00, v1, y00, 3);
                x.P(new Handler(y00.a().getApplicationLooper()), new q0(0, t00, y00, v3, e0, z));
                return;
            }
        }
        t00.b(true);
    }

    public final boolean h(y0 y00, boolean z) {
        try {
            this.g(y00, this.c().c(y00, z));
            return true;
        }
        catch(IllegalStateException illegalStateException0) {
            if(!t.C(illegalStateException0)) {
                throw illegalStateException0;
            }
            b.q("MSessionService", "Failed to start foreground", illegalStateException0);
            l l0 = new l(this, 20);
            this.b.post(l0);
            return false;
        }
    }

    public final void i(y0 y00) {
        synchronized(this.a) {
            b.d(this.c.containsKey(y00.a.i), "session not found");
            this.c.remove(y00.a.i);
        }
        m m0 = new m(24, this.c(), y00);
        x.P(this.b, m0);
    }

    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        if(intent0 != null) {
            String s = intent0.getAction();
            if(s != null) {
                if(s.equals("androidx.media3.session.MediaSessionService")) {
                    goto label_22;
                }
                if(s.equals("android.media.browse.MediaBrowserService")) {
                    f0 f00 = this.f(new w0(new b0("android.media.session.MediaController", -1, -1), 0, 0, false, null, Bundle.EMPTY));
                    if(f00 != null) {
                        this.a(f00);
                        n0 n00 = f00.a;
                        Object object0 = n00.a;
                        synchronized(object0) {
                            if(n00.x == null) {
                                MediaSessionCompat.Token mediaSessionCompat$Token0 = ((Q)n00.k.a.h.k.a).c;
                                k0 k00 = new k0(n00);
                                k00.m(mediaSessionCompat$Token0);
                                n00.x = k00;
                            }
                        }
                        return n00.x.onBind(new Intent("android.media.browse.MediaBrowserService"));
                    label_22:
                        synchronized(this.a) {
                            IBinder iBinder0 = this.d;
                            b.k(iBinder0);
                            return iBinder0;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override  // android.app.Service
    public void onCreate() {
        super.onCreate();
        synchronized(this.a) {
            this.d = new O0(this);
        }
    }

    @Override  // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        synchronized(this.a) {
            O0 o00 = this.d;
            if(o00 != null) {
                o00.a.clear();
                o00.b.removeCallbacksAndMessages(null);
                for(Object object1: o00.d) {
                    androidx.media3.session.k k0 = (androidx.media3.session.k)object1;
                    try {
                        k0.d();
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.d = null;
            }
        }
    }

    @Override  // android.app.Service
    public int onStartCommand(Intent intent0, int v, int v1) {
        y0 y01;
        y0 y00;
        if(intent0 != null) {
            e e0 = this.b();
            Uri uri0 = intent0.getData();
            Object object0 = null;
            if(uri0 == null) {
                y01 = null;
            }
            else {
                synchronized(y0.b) {
                    Iterator iterator0 = y0.c.values().iterator();
                    while(true) {
                        if(!iterator0.hasNext()) {
                            y00 = null;
                            break;
                        }
                        Object object2 = iterator0.next();
                        y00 = (y0)object2;
                        if(Objects.equals(y00.a.b, uri0)) {
                            break;
                        }
                    }
                }
                y01 = y00;
            }
            e0.getClass();
            if("android.intent.action.MEDIA_BUTTON".equals(intent0.getAction())) {
                if(y01 != null) {
                    goto label_30;
                }
                y01 = this.f(new w0(new b0("android.media.session.MediaController", -1, -1), 0, 0, false, null, Bundle.EMPTY));
                if(y01 != null) {
                    this.a(y01);
                label_30:
                    m m0 = new m(23, ((f0)y01).a, intent0);
                    ((f0)y01).a.l.post(m0);
                    return 1;
                }
            }
            else if(y01 != null && "androidx.media3.session.CUSTOM_NOTIFICATION_ACTION".equals(intent0.getAction())) {
                Bundle bundle0 = intent0.getExtras();
                Object object3 = bundle0 == null ? null : bundle0.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION");
                String s = object3 instanceof String ? ((String)object3) : null;
                if(s != null) {
                    Bundle bundle1 = intent0.getExtras();
                    if(bundle1 != null) {
                        object0 = bundle1.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS");
                    }
                    Bundle bundle2 = object0 instanceof Bundle ? ((Bundle)object0) : Bundle.EMPTY;
                    t0 t00 = this.c();
                    v v2 = t00.a(y01);
                    if(v2 != null) {
                        x.P(new Handler(y01.a().getApplicationLooper()), new a(t00, y01, s, bundle2, v2));
                    }
                }
            }
        }
        return 1;
    }

    @Override  // android.app.Service
    public void onTaskRemoved(Intent intent0) {
        if(!this.c().j) {
            this.stopSelf();
        }
    }
}

