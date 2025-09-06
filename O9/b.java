package o9;

import A0.c;
import De.d;
import G.D0;
import G.E;
import M7.a0;
import Me.N;
import Pe.S;
import Y3.k;
import Y3.l;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.collection.K;
import androidx.collection.V;
import androidx.collection.f;
import androidx.collection.s;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import androidx.lifecycle.m0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.t;
import d5.i;
import e3.p;
import e3.x;
import i.n.i.b.a.s.e.C0;
import i.n.i.b.a.s.e.E1;
import i.n.i.b.a.s.e.F1;
import i.n.i.b.a.s.e.f8;
import i.n.i.b.a.s.e.g0;
import j.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.zip.Inflater;
import jf.m;
import k.r;
import k.z;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import qf.e;
import vf.j;
import vf.u;

public final class b implements D0, l, C0, a, m {
    public Object a;
    public Object b;
    public Object c;
    public Object d;

    public b(int v) {
        switch(v) {
            case 6: {
                super();
                this.a = new androidx.compose.foundation.lazy.layout.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                this.b = new K();
                return;
            }
            case 7: {
                super();
                this.a = new p();
                this.b = new p();
                this.c = new b4.a(0);
                return;
            }
            default: {
                super();
                this.a = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
                this.b = new SparseArray();
                this.c = new s(null);
                this.d = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
            }
        }
    }

    public b(c c0) {
        this.a = c0;
    }

    public b(E e0) {
        this(new c(e0, 20));
    }

    public b(Typeface typeface0, w2.b b0) {
        int v17;
        int v13;
        int v7;
        int v3;
        this.d = typeface0;
        this.a = b0;
        this.c = new v2.p(0x400);
        int v = b0.a(6);
        if(v == 0) {
            v3 = 0;
        }
        else {
            int v1 = v + b0.a;
            int v2 = ((ByteBuffer)b0.d).getInt(v1);
            v3 = ((ByteBuffer)b0.d).getInt(v2 + v1);
        }
        this.b = new char[v3 * 2];
        int v4 = b0.a(6);
        if(v4 == 0) {
            v7 = 0;
        }
        else {
            int v5 = v4 + b0.a;
            int v6 = ((ByteBuffer)b0.d).getInt(v5);
            v7 = ((ByteBuffer)b0.d).getInt(v6 + v5);
        }
        for(int v8 = 0; v8 < v7; ++v8) {
            v2.s s0 = new v2.s(this, v8);
            w2.a a0 = s0.b();
            int v9 = a0.a(4);
            if(v9 != 0) {
                ((ByteBuffer)a0.d).getInt(v9 + a0.a);
            }
            char[] arr_c = (char[])this.b;
            w2.a a1 = s0.b();
            int v10 = a1.a(16);
            if(v10 == 0) {
                v13 = 0;
            }
            else {
                int v11 = v10 + a1.a;
                int v12 = ((ByteBuffer)a1.d).getInt(v11);
                v13 = ((ByteBuffer)a1.d).getInt(v12 + v11);
            }
            Q1.c.l(v13 > 0, "invalid metadata codepoint length");
            v2.p p0 = (v2.p)this.c;
            w2.a a2 = s0.b();
            int v14 = a2.a(16);
            if(v14 == 0) {
                v17 = 0;
            }
            else {
                int v15 = v14 + a2.a;
                int v16 = ((ByteBuffer)a2.d).getInt(v15);
                v17 = ((ByteBuffer)a2.d).getInt(v16 + v15);
            }
            p0.a(s0, 0, v17 - 1);
        }
    }

    public b(q0 q00, o0 o00, S2.c c0) {
        q.g(q00, "store");
        q.g(o00, "factory");
        q.g(c0, "defaultExtras");
        super();
        this.a = q00;
        this.b = o00;
        this.c = c0;
        this.d = new T2.c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // jf.m
    public void V(vf.f f0) {
        ((ArrayList)this.a).add(new u(new vf.s(f0)));  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
    }

    @Override  // jf.m
    public void W(qf.b b0, e e0) {
        ((ArrayList)this.a).add(new j(b0, e0));
    }

    @Override  // G.A0
    public long a(G.u u0, G.u u1, G.u u2) {
        int v = u0.b();
        long v1 = 0L;
        for(int v2 = 0; v2 < v; ++v2) {
            v1 = Math.max(v1, ((c)this.a).t(v2).e(u0.a(v2), u1.a(v2), u2.a(v2)));
        }
        return v1;
    }

    @Override  // i.n.i.b.a.s.e.C0
    public i.n.i.b.a.s.e.D0 a() {
        i.n.i.b.a.s.e.D0 d00 = new F1(((Context)this.a), ((f8)this.c).a(), ((E1[])((ArrayList)this.d).toArray(new E1[0])));
        g0 g00 = (g0)this.b;
        if(g00 != null) {
            ((F1)d00).l(g00);
        }
        return d00;
    }

    @Override  // jf.m
    public jf.l b0(qf.b b0) {
        ArrayList arrayList0 = new ArrayList();
        H8.q q0 = ((E9.u)this.b).B(b0, N.q, arrayList0);
        jf.l l0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        l0.b = q0;
        l0.c = this;
        l0.d = arrayList0;
        l0.a = q0;
        return l0;
    }

    @Override  // G.A0
    public G.u c(long v, G.u u0, G.u u1, G.u u2) {
        if(((G.u)this.c) == null) {
            this.c = u2.c();
        }
        G.u u3 = (G.u)this.c;
        if(u3 != null) {
            int v1 = u3.b();
            int v2 = 0;
            while(v2 < v1) {
                G.u u4 = (G.u)this.c;
                if(u4 != null) {
                    u4.e(((c)this.a).t(v2).d(v, u0.a(v2), u1.a(v2), u2.a(v2)), v2);
                    ++v2;
                    continue;
                }
                q.m("velocityVector");
                throw null;
            }
            G.u u5 = (G.u)this.c;
            if(u5 != null) {
                return u5;
            }
            q.m("velocityVector");
            throw null;
        }
        q.m("velocityVector");
        throw null;
    }

    @Override  // j.a
    public boolean d(j.b b0, Menu menu0) {
        ActionMode.Callback actionMode$Callback0 = (ActionMode.Callback)this.a;
        j.e e0 = this.p(b0);
        V v0 = (V)this.d;
        Menu menu1 = (Menu)v0.get(menu0);
        if(menu1 == null) {
            menu1 = new z(((Context)this.b), ((MenuBuilder)menu0));
            v0.put(menu0, menu1);
        }
        return actionMode$Callback0.onCreateActionMode(e0, menu1);
    }

    @Override  // j.a
    public void e(j.b b0) {
        ((ActionMode.Callback)this.a).onDestroyActionMode(this.p(b0));
    }

    @Override  // j.a
    public boolean f(j.b b0, MenuItem menuItem0) {
        return ((ActionMode.Callback)this.a).onActionItemClicked(this.p(b0), new r(((Context)this.b), ((U1.a)menuItem0)));
    }

    @Override  // Y3.l
    public void g(byte[] arr_b, int v, int v1, k k0, e3.e e0) {
        p p3;
        int v20;
        d3.b b0;
        ArrayList arrayList1;
        b4.a a0 = (b4.a)this.c;
        p p0 = (p)this.a;
        p0.E(arr_b, v + v1);
        p0.G(v);
        p p1 = (p)this.b;
        if(p0.a() > 0 && (p0.a[p0.b] & 0xFF) == 120) {
            if(((Inflater)this.d) == null) {
                this.d = new Inflater();
            }
            if(x.G(p0, p1, ((Inflater)this.d))) {
                p0.E(p1.a, p1.c);
            }
        }
        a0.c = 0;
        int[] arr_v = a0.a;
        p p2 = (p)a0.i;
        a0.d = 0;
        a0.e = 0;
        a0.f = 0;
        a0.g = 0;
        a0.h = 0;
        p2.D(0);
        a0.b = false;
        ArrayList arrayList0 = new ArrayList();
        while(p0.a() >= 3) {
            int v2 = p0.c;
            int v3 = p0.u();
            int v4 = p0.A();
            int v5 = p0.b + v4;
            if(v5 > v2) {
                p0.G(v2);
                arrayList1 = arrayList0;
                b0 = null;
            }
            else {
                if(v3 == 0x80) {
                    arrayList1 = arrayList0;
                    if(a0.c == 0 || a0.d == 0 || a0.g == 0 || a0.h == 0 || (p2.c == 0 || p2.b != p2.c || !a0.b)) {
                        b0 = null;
                    }
                    else {
                        p2.G(0);
                        int v17 = a0.g * a0.h;
                        int[] arr_v1 = new int[v17];
                        int v18 = 0;
                        while(v18 < v17) {
                            int v19 = p2.u();
                            if(v19 == 0) {
                                int v21 = p2.u();
                                if(v21 == 0) {
                                    continue;
                                }
                                v20 = ((v21 & 0x40) == 0 ? v21 & 0x3F : (v21 & 0x3F) << 8 | p2.u()) + v18;
                                Arrays.fill(arr_v1, v18, v20, ((v21 & 0x80) == 0 ? arr_v[0] : arr_v[p2.u()]));
                            }
                            else {
                                v20 = v18 + 1;
                                arr_v1[v18] = arr_v[v19];
                            }
                            v18 = v20;
                        }
                        Bitmap bitmap0 = Bitmap.createBitmap(arr_v1, a0.g, a0.h, Bitmap.Config.ARGB_8888);
                        float f = (float)a0.c;
                        float f1 = (float)a0.d;
                        b0 = new d3.b(null, null, null, bitmap0, ((float)a0.f) / f1, 0, 0, ((float)a0.e) / f, 0, 0x80000000, -3.402823E+38f, ((float)a0.g) / f, ((float)a0.h) / f1, false, 0xFF000000, 0x80000000, 0.0f);
                    }
                    a0.c = 0;
                    a0.d = 0;
                    a0.e = 0;
                    a0.f = 0;
                    a0.g = 0;
                    a0.h = 0;
                    p2.D(0);
                    a0.b = false;
                }
                else {
                    switch(v3) {
                        case 20: {
                            if(v4 % 5 == 2) {
                                p0.H(2);
                                Arrays.fill(arr_v, 0);
                                int v6 = v4 / 5;
                                for(int v7 = 0; v7 < v6; ++v7) {
                                    int v8 = p0.u();
                                    int v9 = p0.u();
                                    int v10 = p0.u();
                                    int v11 = p0.u();
                                    arr_v[v8] = x.h(((int)(1.402 * ((double)(v10 - 0x80)) + ((double)v9))), 0, 0xFF) << 16 | p0.u() << 24 | x.h(((int)(((double)v9) - 0.34414 * ((double)(v11 - 0x80)) - ((double)(v10 - 0x80)) * 0.71414)), 0, 0xFF) << 8 | x.h(((int)(((double)(v11 - 0x80)) * 1.772 + ((double)v9))), 0, 0xFF);
                                }
                                p3 = p2;
                                arrayList1 = arrayList0;
                                a0.b = true;
                                goto label_77;
                            }
                            break;
                        }
                        case 21: {
                            if(v4 >= 4) {
                                p0.H(3);
                                int v12 = v4 - 4;
                                if((0x80 & p0.u()) == 0) {
                                label_62:
                                    int v14 = p2.b;
                                    int v15 = p2.c;
                                    if(v14 < v15 && v12 > 0) {
                                        int v16 = Math.min(v12, v15 - v14);
                                        p0.e(p2.a, v14, v16);
                                        p2.G(v14 + v16);
                                    }
                                }
                                else if(v12 >= 7) {
                                    int v13 = p0.x();
                                    if(v13 >= 4) {
                                        a0.g = p0.A();
                                        a0.h = p0.A();
                                        p2.D(v13 - 4);
                                        v12 = v4 - 11;
                                        goto label_62;
                                    }
                                }
                            }
                            break;
                        }
                        case 22: {
                            if(v4 >= 19) {
                                a0.c = p0.A();
                                a0.d = p0.A();
                                p0.H(11);
                                a0.e = p0.A();
                                a0.f = p0.A();
                            }
                        }
                    }
                    p3 = p2;
                    arrayList1 = arrayList0;
                label_77:
                    p2 = p3;
                    b0 = null;
                }
                p0.G(v5);
            }
            arrayList0 = arrayList1;
            if(b0 != null) {
                arrayList0.add(b0);
            }
        }
        e0.accept(new Y3.a(arrayList0, 0x8000000000000001L, 0x8000000000000001L));
    }

    @Override  // G.A0
    public G.u h(long v, G.u u0, G.u u1, G.u u2) {
        if(((G.u)this.b) == null) {
            this.b = u0.c();
        }
        G.u u3 = (G.u)this.b;
        if(u3 != null) {
            int v1 = u3.b();
            int v2 = 0;
            while(v2 < v1) {
                G.u u4 = (G.u)this.b;
                if(u4 != null) {
                    u4.e(((c)this.a).t(v2).c(v, u0.a(v2), u1.a(v2), u2.a(v2)), v2);
                    ++v2;
                    continue;
                }
                q.m("valueVector");
                throw null;
            }
            G.u u5 = (G.u)this.b;
            if(u5 != null) {
                return u5;
            }
            q.m("valueVector");
            throw null;
        }
        q.m("valueVector");
        throw null;
    }

    @Override  // Y3.l
    public int j() {
        return 2;
    }

    @Override  // jf.m
    public void k() {
        H8.q q0 = (H8.q)this.d;
        e e0 = (e)this.c;
        ArrayList arrayList0 = (ArrayList)this.a;
        q0.getClass();
        q.g(arrayList0, "elements");
        if(e0 != null) {
            S s0 = V4.u.p(e0, ((Me.e)q0.d));
            if(s0 != null) {
                HashMap hashMap0 = (HashMap)q0.b;
                List list0 = Qf.k.d(arrayList0);
                Hf.x x0 = s0.getType();
                q.f(x0, "getType(...)");
                hashMap0.put(e0, new vf.z(list0, x0));
                return;
            }
            if(((E9.u)q0.c).z(((qf.b)q0.e)) && q.b(e0.b(), "value")) {
                ArrayList arrayList1 = new ArrayList();
                for(Object object0: arrayList0) {
                    if(object0 instanceof vf.a) {
                        arrayList1.add(object0);
                    }
                }
                Collection collection0 = (List)q0.f;
                for(Object object1: arrayList1) {
                    collection0.add(((Ne.b)((vf.a)object1).a));
                }
            }
        }
    }

    @Override  // G.A0
    public G.u l(G.u u0, G.u u1, G.u u2) {
        if(((G.u)this.d) == null) {
            this.d = u2.c();
        }
        G.u u3 = (G.u)this.d;
        if(u3 != null) {
            int v = u3.b();
            int v1 = 0;
            while(v1 < v) {
                G.u u4 = (G.u)this.d;
                if(u4 != null) {
                    u4.e(((c)this.a).t(v1).b(u0.a(v1), u1.a(v1), u2.a(v1)), v1);
                    ++v1;
                    continue;
                }
                q.m("endVelocityVector");
                throw null;
            }
            G.u u5 = (G.u)this.d;
            if(u5 != null) {
                return u5;
            }
            q.m("endVelocityVector");
            throw null;
        }
        q.m("endVelocityVector");
        throw null;
    }

    @Override  // j.a
    public boolean m(j.b b0, Menu menu0) {
        ActionMode.Callback actionMode$Callback0 = (ActionMode.Callback)this.a;
        j.e e0 = this.p(b0);
        V v0 = (V)this.d;
        Menu menu1 = (Menu)v0.get(menu0);
        if(menu1 == null) {
            menu1 = new z(((Context)this.b), ((MenuBuilder)menu0));
            v0.put(menu0, menu1);
        }
        return actionMode$Callback0.onPrepareActionMode(e0, menu1);
    }

    public static final Message o(b b0, ArrayList arrayList0, int v) {
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            if(((Message)object0).what == v) {
                arrayList1.add(object0);
            }
        }
        Iterator iterator1 = arrayList1.iterator();
        if(!iterator1.hasNext()) {
            return null;
        }
        Object object1 = iterator1.next();
        if(!iterator1.hasNext()) {
            return (Message)object1;
        }
        long v1 = ((Message)object1).getWhen();
        do {
            Object object2 = iterator1.next();
            long v2 = ((Message)object2).getWhen();
            if(v1 < v2) {
                object1 = object2;
                v1 = v2;
            }
        }
        while(iterator1.hasNext());
        return (Message)object1;
    }

    public j.e p(j.b b0) {
        ArrayList arrayList0 = (ArrayList)this.c;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            j.e e0 = (j.e)arrayList0.get(v1);
            if(e0 != null && e0.b == b0) {
                return e0;
            }
        }
        j.e e1 = new j.e(((Context)this.b), b0);
        arrayList0.add(e1);
        return e1;
    }

    public androidx.compose.foundation.lazy.layout.b q(Object object0) {
        androidx.compose.foundation.lazy.layout.b b0 = (androidx.compose.foundation.lazy.layout.b)this.d;
        if(this.c == object0 && b0 != null) {
            return b0;
        }
        K k0 = (K)this.b;
        androidx.compose.foundation.lazy.layout.b b1 = k0.g(object0);
        if(b1 == null) {
            androidx.compose.foundation.lazy.layout.b b2 = (androidx.compose.foundation.lazy.layout.b)this.a;
            androidx.compose.foundation.lazy.layout.b b3 = new androidx.compose.foundation.lazy.layout.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            b3.a = b2.a;
            b3.b = b2.b;
            k0.l(object0, b3);
            b1 = b3;
        }
        this.c = object0;
        this.d = b1;
        return b1;
    }

    public m0 s(d d0, String s) {
        m0 m01;
        q.g(d0, "modelClass");
        q.g(s, "key");
        synchronized(((T2.c)this.d)) {
            q0 q00 = (q0)this.a;
            q00.getClass();
            m0 m00 = (m0)q00.a.get(s);
            if(d0.k(m00)) {
                o0 o00 = (o0)this.b;
                if(o00 instanceof i0) {
                    q.d(m00);
                    ((i0)o00).getClass();
                    t t0 = ((i0)o00).d;
                    if(t0 != null) {
                        q.d(((i0)o00).e);
                        f0.a(m00, ((i0)o00).e, t0);
                    }
                }
                q.e(m00, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
            }
            else {
                S2.d d1 = new S2.d(((S2.c)this.c));
                d1.a.put(f0.e, s);
                o0 o01 = (o0)this.b;
                q.g(o01, "factory");
                try {
                    m01 = o01.create(d0, d1);
                }
                catch(AbstractMethodError unused_ex) {
                    try {
                        m01 = o01.create(df.d.v(d0), d1);
                    }
                    catch(AbstractMethodError unused_ex) {
                        m01 = o01.create(df.d.v(d0));
                    }
                }
                m00 = m01;
                q0 q01 = (q0)this.a;
                q01.getClass();
                q.g(m00, "viewModel");
                m0 m02 = (m0)q01.a.put(s, m00);
                if(m02 != null) {
                    m02.clear$lifecycle_viewmodel_release();
                }
            }
            return m00;
        }
    }

    public void t(Message message0) {
        LinkedBlockingDeque linkedBlockingDeque0 = (LinkedBlockingDeque)this.c;
        if(linkedBlockingDeque0.offer(message0)) {
            Log.d("SessionLifecycleClient", "Queued message " + message0.what + ". Queue size " + linkedBlockingDeque0.size());
            return;
        }
        Log.d("SessionLifecycleClient", "Failed to enqueue message " + message0.what + ". Dropping.");
    }

    public void u(int v) {
        ArrayList arrayList0 = new ArrayList();
        ((LinkedBlockingDeque)this.c).drainTo(arrayList0);
        Message message0 = Message.obtain(null, v, 0, 0);
        q.f(message0, "obtain(null, messageCode, 0, 0)");
        arrayList0.add(message0);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(((me.i)this.a)), null, null, new a0(this, arrayList0, null), 3, null);
    }

    @Override  // jf.m
    public void w0(Object object0) {
        ((ArrayList)this.a).add(E9.u.m(((E9.u)this.b), ((e)this.c), object0));
    }
}

