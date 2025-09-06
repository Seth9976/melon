package qc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import e1.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import lc.g;
import oc.V;
import sc.A1;
import sc.E1;
import sc.P0;
import sc.Q0;
import sc.S2;
import sc.Y0;
import sc.f1;
import sc.g2;
import sc.i1;
import sc.k2;
import sc.l1;

public final class f extends g {
    public final int r;
    public final Object s;

    public f(n0 n00, V v0) {
        this.r = 0;
        q.g(v0, "addData");
        this.s = n00;
        c c0 = new c(n00, null);
        d d0 = new d(n00, null);
        e e0 = new e(n00, null, 0);
        e e1 = new e(n00, null, 1);
        b b0 = new b(n00, 3);
        b b1 = new b(n00, 4);
        super(PlaylistId.MUSIC, n00.j, c0, d0, e0, e1, b0, b1, v0);
    }

    public f(P0 p00, V v0) {
        this.r = 1;
        q.g(v0, "addData");
        this.s = p00;
        sc.d d0 = new sc.d(p00, null);
        sc.e e0 = new sc.e(p00, null);
        e e1 = new e(p00, null, 2);
        e e2 = new e(p00, null, 3);
        sc.c c0 = new sc.c(p00, 3);
        sc.c c1 = new sc.c(p00, 4);
        super(PlaylistId.SMART, p00.o, d0, e0, e1, e2, c0, c1, v0);
    }

    @Override  // lc.g
    public final Object a(lc.f f0) {
        if(this.r != 0) {
            i1 i10 = ((P0)this.s).e;
            f1 f10 = ((P0)this.s).d;
            LinkedList linkedList0 = ((P0)this.s).n;
            if(this.i.a) {
                f10.getClass();
                q.g(linkedList0, "allOrderedList");
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, linkedList0));
                for(Object object0: linkedList0) {
                    arrayList0.add(PlayableExtensionsKt.toSmartEntity(((Playable)object0)));
                }
                Q0 q00 = new Q0(f10, arrayList0, null);
                BuildersKt__Builders_commonKt.launch$default(f10.c, null, null, q00, 3, null);
                ((S2)i10).getClass();
                q.g(linkedList0, "addList");
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, linkedList0));
                Iterator iterator1 = linkedList0.iterator();
                while(iterator1.hasNext()) {
                    iterator1.next();
                    arrayList1.add("");
                }
                l1 l10 = S2.u();
                if(l10 == null) {
                    LogU.error$default(((S2)i10).a, "clearAndAdd " + arrayList1 + " - userData is null", null, false, 6, null);
                    return g.b(this, f0);
                }
                E1 e10 = new E1(0, "clearAndAdd " + arrayList1, m.j(linkedList0), l10, ((S2)i10));
                A1 a10 = new A1(((S2)i10), "clearAndAdd " + arrayList1, null);
                BuildersKt__Builders_commonKt.launch$default(((S2)i10).c, null, null, a10, 3, null);
                ((S2)i10).d.enqueue(e10);
                return g.b(this, f0);
            }
            ArrayList arrayList2 = this.n;
            ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
            for(Object object1: arrayList2) {
                arrayList3.add(((lc.c)object1).b);
            }
            Collection collection0 = this.f();
            f10.getClass();
            q.g(collection0, "addList");
            q.g(linkedList0, "allOrderedList");
            Y0 y00 = new Y0(f10, arrayList3, collection0, p.P0(linkedList0), null);
            BuildersKt__Builders_commonKt.launch$default(f10.c, null, null, y00, 3, null);
            ArrayList arrayList4 = new ArrayList(je.q.Q(10, arrayList2));
            for(Object object2: arrayList2) {
                arrayList4.add(((lc.c)object2).b);
            }
            int v = this.m;
            Collection collection1 = this.f();
            ((S2)i10).getClass();
            q.g(collection1, "addList");
            ArrayList arrayList5 = new ArrayList(je.q.Q(10, arrayList4));
            Iterator iterator4 = arrayList4.iterator();
            while(iterator4.hasNext()) {
                iterator4.next();
                arrayList5.add("");
            }
            ArrayList arrayList6 = new ArrayList(je.q.Q(10, collection1));
            Iterator iterator5 = collection1.iterator();
            while(iterator5.hasNext()) {
                iterator5.next();
                arrayList6.add("");
            }
            String s = "Remove " + arrayList5 + " and Add " + arrayList6;
            l1 l11 = S2.u();
            if(l11 == null) {
                LogU.error$default(((S2)i10).a, s + " - userData is null", null, false, 6, null);
                return g.b(this, f0);
            }
            ArrayList arrayList7 = new ArrayList(je.q.Q(10, arrayList4));
            Iterator iterator6 = arrayList4.iterator();
            while(iterator6.hasNext()) {
                iterator6.next();
                arrayList7.add("");
            }
            k2 k20 = new k2(s, ((S2)i10), l11, v, m.j(collection1), arrayList7);
            g2 g20 = new g2(((S2)i10), s, null);
            BuildersKt__Builders_commonKt.launch$default(((S2)i10).c, null, null, g20, 3, null);
            ((S2)i10).d.enqueue(k20);
            return g.b(this, f0);
        }
        LinkedList linkedList1 = ((n0)this.s).i;
        C0 c00 = ((n0)this.s).b;
        if(this.i.a) {
            c00.getClass();
            q.g(linkedList1, "allOrderedList");
            ArrayList arrayList8 = new ArrayList(je.q.Q(10, linkedList1));
            for(Object object3: linkedList1) {
                arrayList8.add(PlayableExtensionsKt.toMusicEntity(((Playable)object3)));
            }
            o0 o00 = new o0(c00, arrayList8, null);
            BuildersKt__Builders_commonKt.launch$default(c00.c, null, null, o00, 3, null);
            return g.b(this, f0);
        }
        ArrayList arrayList9 = new ArrayList(je.q.Q(10, this.n));
        for(Object object4: this.n) {
            arrayList9.add(((lc.c)object4).b);
        }
        List list0 = this.f();
        c00.getClass();
        q.g(list0, "addList");
        q.g(linkedList1, "allOrderedList");
        w0 w00 = new w0(c00, arrayList9, list0, p.P0(linkedList1), null);
        BuildersKt__Builders_commonKt.launch$default(c00.c, null, null, w00, 3, null);
        return g.b(this, f0);
    }
}

