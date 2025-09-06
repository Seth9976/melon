package lc;

import Q0.D;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.LogU;
import e1.b;
import gd.M6;
import hd.h0;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import jd.e3;
import je.p;
import k8.Y;
import kotlin.jvm.internal.q;
import oc.Q;
import oc.V;
import oc.W;
import oc.X;
import oc.Z;
import oe.c;
import oe.i;
import we.a;
import we.k;
import we.n;
import we.o;

public abstract class g {
    public final PlaylistId a;
    public final int b;
    public final i c;
    public final i d;
    public final i e;
    public final i f;
    public final a g;
    public final a h;
    public final V i;
    public final LogU j;
    public Q k;
    public final r l;
    public int m;
    public final ArrayList n;
    public boolean o;
    public boolean p;
    public boolean q;

    public g(PlaylistId playlistId0, int v, k k0, n n0, o o0, o o1, a a0, a a1, V v1) {
        q.g(playlistId0, "id");
        q.g(v1, "addData");
        super();
        this.a = playlistId0;
        this.b = v;
        this.c = (i)k0;
        this.d = (i)n0;
        this.e = (i)o0;
        this.f = (i)o1;
        this.g = a0;
        this.h = a1;
        this.i = v1;
        this.j = new LogU("PlaylistRequestAddTask");
        this.l = d3.g.Q(new e3(this, 8));
        this.n = new ArrayList();
    }

    public abstract Object a(f arg1);

    public static Object b(g g0, c c0) {
        int v5;
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v = d0.E;
            if((v & 0x80000000) == 0) {
                d0 = new d(g0, c0);
            }
            else {
                d0.E = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(g0, c0);
        }
        Object object0 = d0.B;
        ne.a a0 = ne.a.a;
        switch(d0.E) {
            case 0: {
                d5.n.D(object0);
                LogU logU0 = g0.j;
                i i0 = g0.f;
                int v1 = g0.f().size();
                int v2 = g0.m;
                int v3 = g0.e().size();
                Q q0 = g0.k;
                if(q0 == null) {
                    q.m("prevState");
                    throw null;
                }
                int v4 = q0.b();
                StringBuilder stringBuilder0 = androidx.appcompat.app.o.t(v1, v2, "requestAdd - addingSize: ", ", addTo: ", ", currentSize: ");
                stringBuilder0.append(v3);
                stringBuilder0.append(" oldCurrentPlayingPos: ");
                stringBuilder0.append(v4);
                LogU.debug$default(logU0, stringBuilder0.toString(), null, false, 6, null);
                for(Object object1: g0.f()) {
                    LogU.debug$default(g0.j, "adding " + ((Playable)object1), null, false, 6, null);
                }
                Playable playable0 = g0.f().isEmpty() || !g0.i.e && !g0.o ? b.y(((Q)g0.g.invoke())) : ((Playable)g0.f().get(0));
                Q q1 = g0.k;
                if(q1 == null) {
                    q.m("prevState");
                    throw null;
                }
                v5 = b.y(q1) == playable0 ? 0 : 1;
                int v6 = d8.d.v(g0.e(), playable0);
                if(v6 == -1) {
                    LogU logU2 = g0.j;
                    Q q3 = g0.k;
                    if(q3 == null) {
                        q.m("prevState");
                        throw null;
                    }
                    LogU.debug$default(logU2, androidx.appcompat.app.o.j(q3.b(), "requestAdd - current deleted. pos:", " new current pos:0"), null, false, 6, null);
                    d0.r = g0;
                    d0.w = v5;
                    d0.E = 2;
                    if(((o)i0).invoke(new Integer(0), "requestAdd", d0) == a0) {
                        return a0;
                    }
                }
                else {
                    LogU logU1 = g0.j;
                    Q q2 = g0.k;
                    if(q2 == null) {
                        q.m("prevState");
                        throw null;
                    }
                    LogU.debug$default(logU1, Y.h(q2.b(), v6, "requestAdd - current changed. pos:", " ListPos new current pos:"), null, false, 6, null);
                    d0.r = g0;
                    d0.w = v5;
                    d0.E = 1;
                    if(((o)i0).invoke(new Integer(v6), "requestAdd", d0) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 1: 
            case 2: {
                int v7 = d0.w;
                g g1 = d0.r;
                d5.n.D(object0);
                v5 = v7;
                g0 = g1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        a a1 = g0.h;
        a a2 = g0.g;
        if(g0.i.c.getUserRequestedPlaylist().size() > g0.b) {
            g0.q = true;
        }
        if(g0.i.a) {
            List list0 = g0.f();
            Object object2 = a2.invoke();
            long v8 = ((Number)a1.invoke()).longValue();
            return new X(g0.a, list0, ((Q)object2), v8);
        }
        if(!g0.n.isEmpty()) {
            List list1 = g0.f();
            boolean z = g0.p;
            boolean z1 = g0.q;
            Object object3 = a2.invoke();
            long v9 = ((Number)a1.invoke()).longValue();
            return v5 == 0 ? new oc.Y(g0.a, list1, z, z1, g0.b, false, ((Q)object3), v9) : new oc.Y(g0.a, list1, z, z1, g0.b, true, ((Q)object3), v9);
        }
        List list2 = g0.f();
        Object object4 = a2.invoke();
        long v10 = ((Number)a1.invoke()).longValue();
        return new Z(g0.a, list2, v5 != 0, ((Q)object4), v10);
    }

    public static Object c(g g0, c c0) {
        int v11;
        ArrayList arrayList11;
        int v10;
        g g3;
        List list1;
        int v4;
        int v3;
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v = e0.M;
            if((v & 0x80000000) == 0) {
                e0 = new e(g0, c0);
            }
            else {
                e0.M = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(g0, c0);
        }
        Object object0 = e0.G;
        ne.a a0 = ne.a.a;
        switch(e0.M) {
            case 0: {
                d5.n.D(object0);
                ArrayList arrayList0 = g0.n;
                if(g0.i.c.getUserRequestedPlaylist().isEmpty()) {
                    return d5.n.t(new Exception("empty playables"));
                }
                V v1 = g0.i;
                if(v1.a) {
                    ArrayList arrayList1 = g0.e();
                    ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
                    int v2 = 0;
                    for(Object object1: arrayList1) {
                        if(v2 >= 0) {
                            arrayList2.add(new lc.c(v2, ((Playable)object1)));
                            ++v2;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    arrayList0.addAll(arrayList2);
                    e0.r = g0;
                    e0.D = 0;
                    e0.E = 0;
                    e0.M = 1;
                    if(((k)g0.c).invoke(e0) == a0) {
                        return a0;
                    }
                    v3 = 0;
                    v4 = 0;
                }
                else if(v1.b) {
                    List list0 = g0.f();
                    Q q0 = g0.k;
                    if(q0 == null) {
                        q.m("prevState");
                        throw null;
                    }
                    Playable playable0 = b.y(q0);
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    for(Object object2: list0) {
                        if(((Playable)object2).hasSongId()) {
                            arrayList4.add(object2);
                        }
                    }
                    ArrayList arrayList5 = new ArrayList(je.q.Q(10, arrayList4));
                    for(Object object3: arrayList4) {
                        arrayList5.add(((Playable)object3).getSongid());
                    }
                    HashSet hashSet0 = p.N0(arrayList5);
                    ArrayList arrayList6 = new ArrayList();
                    for(Object object4: list0) {
                        Playable playable1 = (Playable)object4;
                        try {
                            boolean z = false;
                            z = playable1.hasLocalFile();
                        }
                        catch(Exception unused_ex) {
                        }
                        if(z) {
                            arrayList6.add(object4);
                        }
                    }
                    int v5 = 0;
                    boolean z1 = false;
                    for(Object object5: g0.e()) {
                        if(v5 >= 0) {
                            Playable playable2 = (Playable)object5;
                            boolean z2 = hashSet0.contains(playable2.getSongid());
                            if(playable2.isOriginLocal() && !z2 && !arrayList6.isEmpty()) {
                                for(Object object6: arrayList6) {
                                    if(StorageUtils.equalsLocalFile(((Playable)object6), playable2)) {
                                        z2 = true;
                                        break;
                                    }
                                }
                            }
                            if(z2) {
                                arrayList3.add(new lc.c(v5, playable2));
                                if(!z1) {
                                    z1 = ClassUtils.equals(playable0, playable2);
                                }
                            }
                            ++v5;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    lc.b b0 = new lc.b(arrayList3, z1);
                    if(arrayList3.isEmpty()) {
                        v3 = 0;
                        v4 = 0;
                    }
                    else {
                        g0.p = true;
                        arrayList0.addAll(arrayList3);
                        i i0 = g0.d;
                        ArrayList arrayList7 = new ArrayList(je.q.Q(10, arrayList3));
                        for(Object object7: arrayList3) {
                            arrayList7.add(new Integer(((lc.c)object7).a));
                        }
                        e0.r = g0;
                        e0.w = b0;
                        e0.D = 0;
                        e0.E = 0;
                        e0.M = 2;
                        if(((n)i0).invoke(arrayList7, e0) == a0) {
                            return a0;
                        }
                        v3 = 0;
                        v4 = b0.b;
                    }
                }
                else {
                    v3 = 0;
                    v4 = 0;
                }
                goto label_134;
            }
            case 1: {
                int v6 = e0.E;
                v4 = e0.D;
                g g1 = e0.r;
                d5.n.D(object0);
                v3 = v6;
                g0 = g1;
                goto label_134;
            }
            case 2: {
                int v7 = e0.E;
                lc.b b1 = e0.w;
                g g2 = e0.r;
                d5.n.D(object0);
                v3 = v7;
                g0 = g2;
                v4 = b1.b;
            label_134:
                ArrayList arrayList8 = new ArrayList(g0.e());
                int v8 = g0.f().size() + arrayList8.size() - g0.b;
                StringBuilder stringBuilder0 = androidx.appcompat.app.o.t(arrayList8.size(), g0.b, "calcTruncatePos() - list:", ", maxSize: ", ", removeCount: ");
                stringBuilder0.append(v8);
                LogU.debug$default(g0.j, stringBuilder0.toString(), null, false, 6, null);
                if(v8 <= 0) {
                    list1 = Collections.EMPTY_LIST;
                    q.f(list1, "emptyList(...)");
                }
                else {
                    ArrayList arrayList9 = new ArrayList(je.q.Q(10, arrayList8));
                    int v9 = 0;
                    for(Object object8: arrayList8) {
                        if(v9 >= 0) {
                            arrayList9.add(new lc.c(v9, ((Playable)object8)));
                            ++v9;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    list1 = p.L0(v8, p.J0(arrayList9, new D(new M6(17), 2)));
                    String s = va.e.b("calcTruncatePos() - ", p.q0(list1, null, null, null, new h0(29), 0x1F));
                    LogU.verbose$default(g0.j, s, null, false, 6, null);
                }
                if(list1.isEmpty()) {
                    goto label_188;
                }
                g0.q = true;
                ArrayList arrayList10 = new ArrayList(je.q.Q(10, list1));
                for(Object object9: list1) {
                    arrayList10.add(new Integer(((lc.c)object9).a));
                }
                g0.n.addAll(list1);
                e0.r = g0;
                e0.w = null;
                e0.B = arrayList10;
                e0.D = v4;
                e0.E = v3;
                e0.M = 3;
                if(((n)g0.d).invoke(arrayList10, e0) == a0) {
                    return a0;
                }
                g3 = g0;
                v10 = v4;
                arrayList11 = arrayList10;
                break;
            }
            case 3: {
                v10 = e0.D;
                arrayList11 = e0.B;
                ArrayList arrayList12 = (ArrayList)e0.w;
                g3 = e0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Q q1 = g3.k;
        if(q1 != null) {
            v3 = arrayList11.contains(new Integer(q1.b()));
            v4 = v10;
            g0 = g3;
        label_188:
            g0.o = v4 != 0 || v3 != 0;
            switch(g0.i.d.ordinal()) {
                case 1: {
                    v11 = g0.e().size();
                    break;
                }
                case 2: {
                    Playable playable3 = b.y(((Q)g0.g.invoke()));
                    int v12 = playable3 == null ? -1 : playable3.getOrder();
                    if(g0.o) {
                        v11 = 0;
                    }
                    else {
                        ArrayList arrayList13 = g0.e();
                        if(arrayList13.isEmpty()) {
                            v11 = 0;
                        }
                        else {
                            int v13 = 0;
                            for(Object object10: arrayList13) {
                                if(((Playable)object10).getOrder() <= v12) {
                                    ++v13;
                                    if(v13 < 0) {
                                        e.k.N();
                                        throw null;
                                    }
                                    if(false) {
                                        break;
                                    }
                                }
                            }
                            v11 = v13;
                        }
                    }
                    break;
                }
                default: {
                    v11 = 0;
                }
            }
            g0.m = v11;
            return H.a;
        }
        q.m("prevState");
        throw null;
    }

    public final Object d(c c0) {
        Object object1;
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                d5.n.D(object0);
                Q q0 = (Q)this.g.invoke();
                q.g(q0, "<set-?>");
                this.k = q0;
                f0.B = 1;
                object1 = g.c(this, f0);
                if(object1 == a0) {
                    return a0;
                }
                goto label_25;
            }
            case 1: {
                d5.n.D(object0);
                object1 = ((ie.p)object0).a;
            label_25:
                if(object1 instanceof ie.o) {
                    Throwable throwable0 = ie.p.a(object1);
                    if(throwable0 != null) {
                        String s = throwable0.getMessage();
                        return s == null ? new W(this.a, "Unknown error") : new W(this.a, s);
                    }
                    return new W(this.a, "Unknown error");
                }
                Integer integer0 = new Integer(this.m);
                List list0 = this.f();
                f0.B = 2;
                if(((o)this.e).invoke(integer0, list0, f0) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                break;
            }
            case 3: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        f0.B = 3;
        Object object2 = this.a(f0);
        return object2 == a0 ? a0 : object2;
    }

    public final ArrayList e() {
        return b.B(((Q)this.g.invoke()));
    }

    public final List f() {
        return (List)this.l.getValue();
    }
}

