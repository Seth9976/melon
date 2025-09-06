package androidx.media3.session;

import E9.g;
import I5.a;
import I6.V;
import I7.k;
import M6.B;
import M6.H;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.b;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.MediaSessionCompat.Token;
import androidx.media3.session.legacy.b0;
import androidx.media3.session.legacy.c0;
import androidx.media3.session.legacy.m;
import androidx.media3.session.legacy.o;
import androidx.media3.session.legacy.s;
import b3.E;
import com.google.firebase.messaging.u;
import e3.x;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class k0 extends MediaBrowserServiceCompat {
    public final c0 j;
    public final n0 k;
    public final u l;
    public final b m;
    public final n0 n;

    public k0(n0 n00) {
        this.j = c0.a(n00.f);
        this.k = n00;
        this.l = new u(n00);
        this.n = n00;
        this.m = new b(this, 2);
    }

    @Override  // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void b(String s, Bundle bundle0, o o0) {
        w0 w00 = this.l();
        if(w00 == null) {
            o0.e();
            return;
        }
        o0.a();
        a a0 = new a(this, s, w00, o0, bundle0, 4);
        x.P(this.n.l, a0);
    }

    @Override  // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final g c(Bundle bundle0) {
        Bundle bundle3;
        r r0;
        g g0;
        u u0 = this.l;
        s s0 = this.a;
        s0.getClass();
        b0 b00 = s0.l();
        Bundle bundle1 = bundle0 == null ? Bundle.EMPTY : bundle0;
        boolean z = this.j.b(b00);
        j0 j00 = new j0(this, b00);
        bundle1.getInt("androidx.media.utils.MediaBrowserCompat.extras.CUSTOM_BROWSER_ACTION_LIMIT", 0);
        w0 w00 = new w0(b00, 0, 0, z, j00, bundle1);
        AtomicReference atomicReference0 = new AtomicReference();
        S8.b b0 = new S8.b();  // 初始化器: Ljava/lang/Object;-><init>()V
        D5.a a0 = new D5.a(this, atomicReference0, w00, b0, 13);
        x.P(this.k.l, a0);
        try {
            b0.a();
        }
        catch(InterruptedException interruptedException0) {
            e3.b.q("MSSLegacyStub", "Couldn\'t get a result from onConnect", interruptedException0);
            g0 = null;
            goto label_24;
        }
        u0 u00 = (u0)atomicReference0.get();
        u00.getClass();
        u0.b(b00, w00, u00.a, u00.b);
        g0 = h1.a;
    label_24:
        if(g0 != null) {
            w0 w01 = this.l();
            if(w01 != null && u0.u(w01, 50000)) {
                n0 n00 = this.n;
                d0 d00 = q.i(n00.f, bundle0);
                AtomicReference atomicReference1 = new AtomicReference();
                S8.b b1 = new S8.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                a a1 = new a(this, atomicReference1, w01, d00, b1, 3);
                x.P(n00.l, a1);
                try {
                    b1.a();
                    r0 = (r)((B)atomicReference1.get()).get();
                    e3.b.h(r0, "LibraryResult must not be null");
                }
                catch(CancellationException | ExecutionException | InterruptedException cancellationException0) {
                    e3.b.q("MLSLegacyStub", "Couldn\'t get a result from onGetLibraryRoot", cancellationException0);
                    r0 = null;
                }
                if(r0 != null) {
                    Object object0 = r0.c;
                    if(r0.a == 0 && object0 != null) {
                        d0 d01 = r0.e;
                        if(d01 == null) {
                            bundle3 = new Bundle();
                        }
                        else {
                            Bundle bundle2 = d01.a;
                            bundle3 = new Bundle(bundle2);
                            if(bundle2.containsKey("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY")) {
                                boolean z1 = bundle2.getBoolean("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY", false);
                                bundle3.remove("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY");
                                bundle3.putInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", (z1 ? 1 : 3));
                            }
                            bundle3.putBoolean("android.service.media.extra.RECENT", d01.b);
                            bundle3.putBoolean("android.service.media.extra.OFFLINE", d01.c);
                            bundle3.putBoolean("android.service.media.extra.SUGGESTED", d01.d);
                        }
                        bundle3.putBoolean("android.media.browse.SEARCH_SUPPORTED", u0.u(w01, 50005));
                        V v1 = n00.r;
                        if(!v1.isEmpty()) {
                            ArrayList arrayList0 = new ArrayList();
                            for(int v = 0; v < v1.size(); ++v) {
                                androidx.media3.session.b b2 = (androidx.media3.session.b)v1.get(v);
                                if(b2.a != null && b2.a.a == 0) {
                                    Bundle bundle4 = new Bundle();
                                    s1 s10 = b2.a;
                                    Bundle bundle5 = b2.g;
                                    if(s10 != null) {
                                        bundle4.putString("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_ID", s10.b);
                                    }
                                    bundle4.putString("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_LABEL", b2.f.toString());
                                    Uri uri0 = b2.e;
                                    if(uri0 != null) {
                                        bundle4.putString("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_ICON_URI", uri0.toString());
                                    }
                                    if(!bundle5.isEmpty()) {
                                        bundle4.putBundle("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_EXTRAS", bundle5);
                                    }
                                    arrayList0.add(bundle4);
                                }
                            }
                            if(!arrayList0.isEmpty()) {
                                bundle3.putParcelableArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ROOT_LIST", arrayList0);
                            }
                        }
                        return new g(((E)object0).a, bundle3);
                    }
                }
                return r0 != null && r0.a != 0 ? null : h1.a;
            }
        }
        return null;
    }

    @Override  // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void d(String s, androidx.media3.session.legacy.u u0) {
        this.e(s, u0, null);
    }

    @Override  // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void e(String s, androidx.media3.session.legacy.u u0, Bundle bundle0) {
        w0 w00 = this.l();
        if(w00 == null) {
            u0.f(null);
            return;
        }
        if(TextUtils.isEmpty(s)) {
            e3.b.D("MLSLegacyStub", "onLoadChildren(): Ignoring empty parentId from " + w00);
            u0.f(null);
            return;
        }
        u0.a();
        a a0 = new a(this, w00, u0, bundle0, s);
        x.P(this.n.l, a0);
    }

    @Override  // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void f(String s, androidx.media3.session.legacy.u u0) {
        w0 w00 = this.l();
        if(w00 == null) {
            u0.f(null);
            return;
        }
        if(TextUtils.isEmpty(s)) {
            e3.b.D("MLSLegacyStub", "Ignoring empty itemId from " + w00);
            u0.f(null);
            return;
        }
        u0.a();
        D5.a a0 = new D5.a(8, s, this, w00, u0);
        x.P(this.n.l, a0);
    }

    @Override  // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void g(String s, Bundle bundle0, m m0) {
        w0 w00 = this.l();
        if(w00 == null) {
            m0.f(null);
            return;
        }
        if(TextUtils.isEmpty(s)) {
            e3.b.D("MLSLegacyStub", "Ignoring empty query from " + w00);
            m0.f(null);
            return;
        }
        if(!(w00.d instanceof j0)) {
            return;
        }
        m0.a();
        a a0 = new a(this, w00, m0, s, bundle0);
        x.P(this.n.l, a0);
    }

    @Override  // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void h(Bundle bundle0, String s) {
        w0 w00 = this.l();
        if(w00 == null) {
            return;
        }
        if(TextUtils.isEmpty(s)) {
            e3.b.D("MLSLegacyStub", "onSubscribe(): Ignoring empty id from " + w00);
            return;
        }
        D5.a a0 = new D5.a(7, s, this, w00, bundle0);
        x.P(this.n.l, a0);
    }

    @Override  // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public final void i(String s) {
        w0 w00 = this.l();
        if(w00 == null) {
            return;
        }
        if(TextUtils.isEmpty(s)) {
            e3.b.D("MLSLegacyStub", "onUnsubscribe(): Ignoring empty id from " + w00);
            return;
        }
        k k0 = new k(this, w00, s, 13);
        x.P(this.n.l, k0);
    }

    public static H k(k0 k00, r r0) {
        e3.b.h(r0, "LibraryResult must not be null");
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(r0.a == 0) {
            Object object0 = r0.c;
            if(object0 != null) {
                if(((V)object0).isEmpty()) {
                    h0.k(new ArrayList());
                    return h0;
                }
                ArrayList arrayList0 = new ArrayList();
                A3.m m0 = new A3.m(18, h0, arrayList0);
                M6.s s0 = M6.s.a;
                h0.addListener(m0, s0);
                D5.a a0 = new D5.a(k00, new AtomicInteger(0), ((V)object0), arrayList0, h0);
                for(int v = 0; v < ((V)object0).size(); ++v) {
                    byte[] arr_b = ((E)((V)object0).get(v)).d.k;
                    if(arr_b == null) {
                        arrayList0.add(null);
                        a0.run();
                    }
                    else {
                        B b0 = k00.n.m.a(arr_b);
                        arrayList0.add(b0);
                        b0.addListener(a0, s0);
                    }
                }
                return h0;
            }
        }
        h0.k(null);
        return h0;
    }

    public final w0 l() {
        s s0 = this.a;
        s0.getClass();
        b0 b00 = s0.l();
        return this.l.l(b00);
    }

    public final void m(MediaSessionCompat.Token mediaSessionCompat$Token0) {
        this.attachBaseContext(this.k.f);
        this.onCreate();
        if(mediaSessionCompat$Token0 == null) {
            throw new IllegalArgumentException("Session token may not be null");
        }
        if(this.h != null) {
            throw new IllegalStateException("The session token has already been set");
        }
        this.h = mediaSessionCompat$Token0;
        s s0 = this.a;
        s0.getClass();
        M6.u u0 = new M6.u(s0, mediaSessionCompat$Token0, false, 10);
        ((MediaBrowserServiceCompat)s0.d).g.c(u0);
    }
}

