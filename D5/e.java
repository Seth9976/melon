package d5;

import A1.k;
import B3.N;
import B3.t;
import E9.w;
import I7.c;
import P0.E0;
import P0.I;
import a3.o;
import android.database.Cursor;
import android.net.Uri;
import android.util.SparseArray;
import androidx.room.H;
import androidx.room.O;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.iloen.melon.net.v5x.response.CastPopularListRes;
import com.iloen.melon.net.v5x.response.StationHomeRes;
import com.melon.playback.melon.streaming.tracker.NetworkEventSerializer;
import com.melon.playback.melon.streaming.tracker.NetworkEvents;
import com.melon.playback.melon.streaming.tracker.NetworkEventsSerializer;
import d3.g;
import dc.a;
import e3.p;
import e3.v;
import e3.x;
import g3.h;
import h4.C;
import h4.D;
import h4.E;
import h4.G;
import i.n.i.b.a.s.e.M3;
import i.n.i.b.a.s.e.kd;
import i.n.i.b.a.s.e.ne;
import ie.m;
import ie.s;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jg.d;
import kotlin.jvm.internal.q;
import lf.K;
import lf.L;
import lf.M;
import nf.f;

public final class e implements C, kd, d, f {
    public final int a;
    public Object b;
    public Object c;

    public e(int v) {
        this.a = v;
        switch(v) {
            case 8: {
                super();
                NetworkEventSerializer networkEventSerializer0 = new NetworkEventSerializer();
                m m0 = new m(a.class, networkEventSerializer0);
                NetworkEventsSerializer networkEventsSerializer0 = new NetworkEventsSerializer();
                this.b = je.C.S(new m[]{m0, new m(NetworkEvents.class, networkEventsSerializer0)});
                this.c = g.Q(new b9.a(this, 28));
                return;
            }
            case 11: {
                super();
                this.b = new HashMap();
                return;
            }
            default: {
                super();
                this.b = new c(15);
                this.c = new c(15);
            }
        }
    }

    public e(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public e(WorkDatabase workDatabase0) {
        this.a = 0;
        super();
        this.b = workDatabase0;
        this.c = new b(workDatabase0);
    }

    public e(gc.a a0) {
        this.a = 5;
        super();
        this.b = new SparseArray();
        this.c = new HashMap();
    }

    public e(E e0) {
        this.a = 9;
        super();
        this.c = e0;
        this.b = new N(new byte[4], 4, 2, 0);
    }

    public e(Object object0) {
        this.a = 2;
        super();
        this.b = object0;
        this.c = Thread.currentThread();
    }

    public e(Object object0, Object object1, boolean z, int v) {
        this.a = v;
        this.b = object1;
        this.c = object0;
        super();
    }

    public e(lf.N n0, M m0) {
        this.a = 13;
        q.g(n0, "strings");
        q.g(m0, "qualifiedNames");
        super();
        this.b = n0;
        this.c = m0;
    }

    @Override  // h4.C
    public void a(p p0) {
        E e0 = (E)this.c;
        SparseArray sparseArray0 = e0.h;
        N n0 = (N)this.b;
        if(p0.u() == 0 && (p0.u() & 0x80) != 0) {
            p0.H(6);
            int v = p0.a();
            for(int v1 = 0; v1 < v / 4; ++v1) {
                p0.e(n0.d, 0, 4);
                n0.L(0);
                int v2 = n0.D(16);
                n0.O(3);
                if(v2 == 0) {
                    n0.O(13);
                }
                else {
                    int v3 = n0.D(13);
                    if(sparseArray0.get(v3) == null) {
                        sparseArray0.put(v3, new D(new k(e0, v3)));
                        ++e0.n;
                    }
                }
            }
            if(e0.a != 2) {
                sparseArray0.remove(0);
            }
        }
    }

    @Override  // h4.C
    public void b(v v0, t t0, G g0) {
    }

    @Override  // nf.f
    public boolean c(int v) {
        return ((Boolean)this.p(v).c).booleanValue();
    }

    @Override  // jg.d
    public void d(OutputStream outputStream0) {
        ((mg.d)this.c).d(outputStream0);
    }

    @Override  // nf.f
    public String e(int v) {
        s s0 = this.p(v);
        List list0 = (List)s0.a;
        String s1 = je.p.q0(((List)s0.b), ".", null, null, null, 62);
        return list0.isEmpty() ? s1 : je.p.q0(list0, "/", null, null, null, 62) + '/' + s1;
    }

    @Override  // jg.d
    public String f(String s) {
        return ((mg.d)this.c).a.b(s);
    }

    public Map g() {
        synchronized(this) {
            if(((Map)this.c) == null) {
                this.c = Collections.unmodifiableMap(new HashMap(((HashMap)this.b)));
            }
            return (Map)this.c;
        }
    }

    @Override  // nf.f
    public String getString(int v) {
        String s = (String)((lf.N)this.b).b.get(v);
        q.f(s, "getString(...)");
        return s;
    }

    public void h(I i0, boolean z) {
        c c0 = (c)this.c;
        c c1 = (c)this.b;
        if(z) {
            c1.v(i0);
            c0.v(i0);
            return;
        }
        if(!((E0)c1.b).contains(i0)) {
            c0.v(i0);
        }
    }

    public Long i(String s) {
        Long long0 = null;
        O o0 = O.c(1, "SELECT long_value FROM Preference where `key`=?");
        o0.k(1, s);
        H h0 = (H)this.b;
        h0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(h0, o0, false);
        try {
            if(cursor0.moveToFirst() && !cursor0.isNull(0)) {
                long0 = cursor0.getLong(0);
            }
            return long0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    @Override  // i.n.i.b.a.s.e.kd
    public Object j(Uri uri0, h h0) {
        ne ne0 = (ne)((kd)this.b).j(uri0, h0);
        List list0 = (List)this.c;
        return list0.isEmpty() ? ne0 : ((ne)ne0.b(list0));
    }

    public Object k(oe.c c0) {
        xb.a a0;
        if(c0 instanceof xb.a) {
            a0 = (xb.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new xb.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new xb.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                try {
                    a0.B = 1;
                    object0 = ((Ua.h)this.c).G(a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        n.D(object0);
                    }
                    return new Na.e(((CastPopularListRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Na.d(exception0);
    }

    public Object l(oe.c c0) {
        xb.b b0;
        if(c0 instanceof xb.b) {
            b0 = (xb.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new xb.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new xb.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                try {
                    b0.B = 1;
                    object0 = ((A0.c)this.b).B(b0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new Na.e(((StationHomeRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Na.d(exception0);
    }

    public void m(d5.d d0) {
        H h0 = (H)this.b;
        h0.assertNotSuspendingTransaction();
        h0.beginTransaction();
        try {
            ((b)this.c).p(d0);
            h0.setTransactionSuccessful();
        }
        finally {
            h0.endTransaction();
        }
    }

    // 去混淆评级： 低(20)
    public boolean n() {
        return !((E0)((c)this.c).b).isEmpty() || !((E0)((c)this.b).b).isEmpty() ? 1 : 0;
    }

    public void o(List list0, MediaQueueItem[] arr_mediaQueueItem) {
        for(int v = 0; v < list0.size(); ++v) {
            HashMap hashMap0 = (HashMap)this.c;
            MediaInfo mediaInfo0 = arr_mediaQueueItem[v].getMedia();
            mediaInfo0.getClass();
            hashMap0.put(mediaInfo0.getContentId(), ((b3.E)list0.get(v)));
        }
    }

    public s p(int v) {
        LinkedList linkedList0 = new LinkedList();
        LinkedList linkedList1 = new LinkedList();
        boolean z = false;
        while(v != -1) {
            L l0 = (L)((M)this.c).b.get(v);
            String s = (String)((lf.N)this.b).b.get(l0.d);
            K k0 = l0.e;
            q.d(k0);
            switch(k0.ordinal()) {
                case 0: {
                    linkedList1.addFirst(s);
                    break;
                }
                case 1: {
                    linkedList0.addFirst(s);
                    break;
                }
                case 2: {
                    linkedList1.addFirst(s);
                    z = true;
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            v = l0.c;
        }
        return new s(linkedList0, linkedList1, Boolean.valueOf(z));
    }

    public void q(int v, b3.E e0, MediaInfo mediaInfo0, String s, long v1) {
        long v3;
        SparseArray sparseArray0 = (SparseArray)this.b;
        o o0 = (o)sparseArray0.get(v, o.f);
        if(mediaInfo0 == null) {
            v3 = 0x8000000000000001L;
        }
        else {
            long v2 = mediaInfo0.getStreamDuration();
            v3 = v2 == -1L ? 0x8000000000000001L : x.M(v2);
        }
        if(v3 == 0x8000000000000001L) {
            v3 = o0.a;
        }
        boolean z = mediaInfo0 == null ? o0.c : mediaInfo0.getStreamType() == 2;
        long v4 = v1 == 0x8000000000000001L ? o0.b : v1;
        if(v3 != o0.a || v4 != o0.b || z != o0.c || !s.equals(o0.e) || !e0.equals(o0.d)) {
            o0 = new o(v3, v4, z, e0, s);
        }
        sparseArray0.put(v, o0);
    }

    @Override  // jg.d
    public void setHeader(String s, String s1) {
        q.g(s1, "value");
        ((mg.d)this.c).setHeader(s, s1);
    }

    @Override
    public String toString() {
        return this.a == 12 ? ((mg.d)this.c).toString() : super.toString();
    }
}

