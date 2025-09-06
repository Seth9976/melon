package Gf;

import I.N0;
import I.g1;
import I0.a;
import a2.e;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.app.K;
import androidx.appcompat.view.menu.MenuBuilder;
import c2.B0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.B;
import com.google.android.material.internal.D;
import com.google.android.material.internal.E;
import d5.m;
import d5.n;
import e3.o;
import g7.j;
import g7.k;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import jg.b;
import jg.f;
import jg.g;
import k.v;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import mg.d;
import oe.c;

public final class l implements a, D, k, v {
    public final int a;
    public boolean b;
    public Object c;

    public l() {
        this.a = 6;
        super();
    }

    public l(e e0, boolean z) {
        this.a = 2;
        this(e0, 2);
        this.b = z;
    }

    public l(Object object0, int v) {
        this.a = v;
        this.c = object0;
        super();
    }

    public l(Object object0, boolean z, int v) {
        this.a = v;
        this.c = object0;
        this.b = z;
        super();
    }

    public l(StringBuilder stringBuilder0) {
        this.a = 5;
        super();
        this.c = stringBuilder0;
        this.b = true;
    }

    public l(boolean z) {
        this.a = 8;
        super();
        this.b = z;
    }

    public l(boolean z, String s) {
        this.a = 4;
        super();
        this.b = z;
        this.c = s;
    }

    @Override  // g7.k
    public void a(j j0, int v) {
        StringBuilder stringBuilder0 = (StringBuilder)this.c;
        if(this.b) {
            this.b = false;
        }
        else {
            stringBuilder0.append(", ");
        }
        stringBuilder0.append(v);
    }

    @Override  // k.v
    public void b(MenuBuilder menuBuilder0, boolean z) {
        K k0 = (K)this.c;
        if(this.b) {
            return;
        }
        this.b = true;
        k0.a.a();
        k0.b.onPanelClosed(108, menuBuilder0);
        this.b = false;
    }

    public void c() {
        m m0 = (m)this.c;
        if(m0 != null) {
            Socket socket0 = (Socket)m0.d;
            try {
                socket0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        this.c = null;
    }

    public boolean d() {
        return this.b;
    }

    public d5.e e(URL uRL0) {
        jg.e e0 = new jg.e("GET", "", "HTTP/1.1");
        o o0 = new o(e0, new d(e0, null));
        e0.a = "GET";
        o0.h(uRL0);
        o0.setHeader("User-Agent", "Linux/4.14.295-g84b42e6a786c-ab9578266 UPnP/1.0 mmupnp/3.0.0");
        o0.setHeader("Connection", (this.b ? "keep-alive" : "close"));
        d5.e e1 = this.h(0, o0);
        f f0 = (f)e1.b;
        d d0 = (d)e1.c;
        if(f0.a != b.d || d0.a() == null) {
            throw new IOException(d0.d.b());
        }
        return e1;
    }

    public boolean f(CharSequence charSequence0, int v) {
        if(charSequence0 != null && v >= 0 && charSequence0.length() - v >= 0) {
            e e0 = (e)this.c;
            if(e0 == null) {
                return this.d();
            }
            e0.getClass();
            int v2 = 2;
            for(int v1 = 0; v1 < v && v2 == 2; ++v1) {
                switch(Character.getDirectionality(charSequence0.charAt(v1))) {
                    case 0: 
                    case 14: 
                    case 15: {
                        v2 = 1;
                        break;
                    }
                    case 1: 
                    case 2: 
                    case 16: 
                    case 17: {
                        v2 = 0;
                        break;
                    }
                    default: {
                        v2 = 2;
                    }
                }
            }
            switch(v2) {
                case 0: {
                    return true;
                }
                case 1: {
                    return false;
                }
                default: {
                    return this.d();
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public m g(o o0) {
        Socket socket0 = new Socket();
        InetAddress inetAddress0 = (InetAddress)o0.d;
        if(inetAddress0 == null) {
            throw new IllegalStateException("address must be set");
        }
        socket0.connect(new InetSocketAddress(inetAddress0, o0.c), g.c);
        socket0.setSoTimeout(g.c);
        socket0.getLocalAddress();
        m m0 = new m(socket0);
        this.c = m0;
        return m0;
    }

    public d5.e h(int v, o o0) {
        d5.e e0;
        m m0 = (m)this.c;
        if(m0 == null) {
            this.c();
        }
        else {
            Socket socket0 = (Socket)m0.d;
            if(!socket0.isConnected() || !q.b(socket0.getInetAddress(), ((InetAddress)o0.d)) || socket0.getPort() != o0.c) {
                this.c();
            }
        }
        try {
            m m1 = (m)this.c;
            if(m1 == null) {
                e0 = l.i(this.g(o0), o0);
            }
            else {
                try {
                    e0 = l.i(m1, o0);
                }
                catch(IOException unused_ex) {
                    this.b = false;
                    this.c();
                    e0 = l.i(this.g(o0), o0);
                }
            }
        }
        catch(IOException iOException0) {
            this.c();
            throw iOException0;
        }
        d d0 = (d)e0.c;
        if(!this.b || !d0.c()) {
            this.c();
        }
        int v1 = ((f)e0.b).a.ordinal();
        if((v1 == 16 || (v1 == 11 || v1 == 12 || v1 == 13)) && v < 2) {
            String s = d0.a.b("LOCATION");
            if(s != null && s.length() != 0) {
                String s1 = ((jg.e)o0.e).a;
                String s2 = ((jg.e)o0.e).b;
                String s3 = ((jg.e)o0.e).c;
                q.g(s1, "method");
                q.g(s2, "uri");
                q.g(s3, "version");
                jg.e e1 = new jg.e(s1, s2, s3);
                o o1 = new o(e1, new d(e1, ((d)o0.b)));
                o1.d = (InetAddress)o0.d;
                o1.c = o0.c;
                o1.h(new URL(s));
                o1.setHeader("Connection", "close");
                return new l(false).h(v + 1, o1);
            }
        }
        return e0;
    }

    public static d5.e i(m m0, o o0) {
        o0.d(((BufferedOutputStream)m0.c));
        BufferedInputStream bufferedInputStream0 = (BufferedInputStream)m0.b;
        q.g(bufferedInputStream0, "input");
        f f0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        f0.a = b.c;
        f0.b = 0;
        f0.c = "";
        f0.d = "HTTP/1.1";
        d d0 = new d(f0, null);
        d5.e e0 = new d5.e(12, f0, d0);
        d0.e(bufferedInputStream0);
        return e0;
    }

    @Override  // com.google.android.material.internal.D
    public B0 k(View view0, B0 b00, E e0) {
        int v7;
        S1.d d0 = b00.a.g(0x207);
        S1.d d1 = b00.a.g(0x20);
        BottomSheetBehavior bottomSheetBehavior0 = (BottomSheetBehavior)this.c;
        int v = d0.c;
        int v1 = d0.a;
        bottomSheetBehavior0.M = d0.b;
        boolean z = B.l(view0);
        int v2 = view0.getPaddingBottom();
        int v3 = view0.getPaddingLeft();
        int v4 = view0.getPaddingRight();
        if(bottomSheetBehavior0.o) {
            int v5 = b00.a();
            bottomSheetBehavior0.I = v5;
            v2 = v5 + e0.d;
        }
        if(bottomSheetBehavior0.r) {
            v3 = (z ? e0.c : e0.a) + v1;
        }
        if(bottomSheetBehavior0.w) {
            v4 = (z ? e0.a : e0.c) + v;
        }
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v6 = 1;
        if(!bottomSheetBehavior0.D || viewGroup$MarginLayoutParams0.leftMargin == v1) {
            v7 = 0;
        }
        else {
            viewGroup$MarginLayoutParams0.leftMargin = v1;
            v7 = 1;
        }
        if(bottomSheetBehavior0.E && viewGroup$MarginLayoutParams0.rightMargin != v) {
            viewGroup$MarginLayoutParams0.rightMargin = v;
            v7 = 1;
        }
        if(bottomSheetBehavior0.G) {
            int v8 = d0.b;
            if(viewGroup$MarginLayoutParams0.topMargin == v8) {
                v6 = v7;
            }
            else {
                viewGroup$MarginLayoutParams0.topMargin = v8;
            }
        }
        else {
            v6 = v7;
        }
        if(v6 != 0) {
            view0.setLayoutParams(viewGroup$MarginLayoutParams0);
        }
        view0.setPadding(v3, view0.getPaddingTop(), v4, v2);
        boolean z1 = this.b;
        if(z1) {
            bottomSheetBehavior0.m = d1.d;
        }
        if(!bottomSheetBehavior0.o && !z1) {
            return b00;
        }
        bottomSheetBehavior0.U();
        return b00;
    }

    @Override  // k.v
    public boolean m(MenuBuilder menuBuilder0) {
        ((K)this.c).b.onMenuOpened(108, menuBuilder0);
        return true;
    }

    @Override  // I0.a
    public Object onPostFling-RZ2iAVY(long v, long v1, Continuation continuation0) {
        long v4;
        N0 n00;
        if(continuation0 instanceof N0) {
            n00 = (N0)continuation0;
            int v2 = n00.D;
            if((v2 & 0x80000000) == 0) {
                n00 = new N0(this, ((c)continuation0));
            }
            else {
                n00.D = v2 ^ 0x80000000;
            }
        }
        else {
            n00 = new N0(this, ((c)continuation0));
        }
        Object object0 = n00.w;
        ne.a a0 = ne.a.a;
        int v3 = n00.D;
        switch(v3) {
            case 0: {
                n.D(object0);
                v4 = 0L;
                if(this.b) {
                    g1 g10 = (g1)this.c;
                    if(g10.h) {
                        return new r1.q(r1.q.d(v1, 0L));
                    }
                    n00.r = v1;
                    n00.D = 1;
                    object0 = g10.b(v1, n00);
                    return object0 == a0 ? a0 : new r1.q(r1.q.d(v1, ((r1.q)object0).a));
                }
                break;
            }
            case 1: {
                v1 = n00.r;
                n.D(object0);
                v4 = r1.q.d(v1, ((r1.q)object0).a);
                break;
            }
            default: {
                if(v3 != 2) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                v1 = n00.r;
                n.D(object0);
                return new r1.q(r1.q.d(v1, ((r1.q)object0).a));
            }
        }
        return new r1.q(v4);
    }

    @Override  // I0.a
    public long onPostScroll-DzOQY0M(long v, long v1, int v2) {
        if(this.b) {
            g1 g10 = (g1)this.c;
            return g10.a.b() ? 0L : g10.g(g10.c(g10.a.e(g10.c(g10.f(v1)))));
        }
        return 0L;
    }

    @Override
    public String toString() {
        if(this.a != 0) {
            return super.toString();
        }
        return this.b ? "FALL_THROUGH" : String.valueOf(this.c);
    }
}

