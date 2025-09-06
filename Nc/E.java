package nc;

import A3.g;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.DrawerAddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import d8.d;
import df.v;
import e1.b;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import je.D;
import je.q;
import k9.j;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.F;
import ne.a;
import oe.i;
import we.n;

public final class e extends i implements n {
    public C0 B;
    public int D;
    public Object E;
    public final DrawerAddRequestPlayableListInfo G;
    public final u0 I;
    public final F M;
    public final C N;
    public final DrawerPlaylistInfo S;
    public String r;
    public ArrayList w;

    public e(DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo0, DrawerPlaylistInfo drawerPlaylistInfo0, Continuation continuation0, C c0, F f0, u0 u00) {
        this.G = drawerAddRequestPlayableListInfo0;
        this.I = u00;
        this.M = f0;
        this.N = c0;
        this.S = drawerPlaylistInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e(this.G, this.S, continuation0, this.N, this.M, this.I);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object3;
        ArrayList arrayList3;
        String s;
        u0 u00 = this.I;
        LinkedList linkedList0 = u00.j;
        C0 c00 = (C0)this.E;
        a a0 = a.a;
        DrawerAddRequestPlayableListInfo drawerAddRequestPlayableListInfo0 = this.G;
        F f0 = this.M;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                s = b.y(c00) == null ? null : "";
                ArrayList arrayList0 = b.B(c00);
                int v = D.N(q.Q(10, arrayList0));
                if(v < 16) {
                    v = 16;
                }
                LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
                for(Object object1: arrayList0) {
                    linkedHashMap0.put("", object1);
                }
                ArrayList arrayList1 = new ArrayList();
                Iterable iterable0 = drawerAddRequestPlayableListInfo0.getUserRequestedPlaylist();
                ArrayList arrayList2 = new ArrayList(q.Q(10, iterable0));
                for(Object object2: iterable0) {
                    Playable playable0 = (Playable)object2;
                    Playable playable1 = (Playable)linkedHashMap0.get("");
                    if(playable1 == null) {
                        arrayList1.add(playable0);
                    }
                    else {
                        playable0 = playable1;
                    }
                    arrayList2.add(playable0);
                }
                d.E(System.currentTimeMillis(), arrayList1);
                linkedList0.clear();
                linkedList0.addAll(arrayList2);
                if(((C0)u00.h.getValue()).f) {
                    j.f(arrayList1);
                }
                this.E = c00;
                this.r = s;
                this.w = arrayList2;
                this.D = 1;
                if(u00.p.a(linkedList0, "DrawerPlaylistImpl, addInternalWithoutUpdateRepository", this) == a0) {
                    return a0;
                }
                arrayList3 = arrayList2;
                goto label_49;
            }
            case 1: {
                arrayList3 = this.w;
                s = this.r;
                d5.n.D(object0);
            label_49:
                int v1 = 0;
                int v2 = 0;
                Iterator iterator2 = arrayList3.iterator();
                while(true) {
                    if(!iterator2.hasNext()) {
                        v2 = -1;
                        break;
                    }
                    iterator2.next();
                    if(kotlin.jvm.internal.q.b("", s)) {
                        break;
                    }
                    ++v2;
                }
                C c0 = this.N;
                if(v2 > -1) {
                    f0.a = v2;
                    c0.a = false;
                }
                else {
                    if(drawerAddRequestPlayableListInfo0.getUserRequestedPlaylist().isEmpty()) {
                        v1 = -1;
                    }
                    f0.a = v1;
                    c0.a = true;
                    u00.i = -1L;
                }
                if(c00.e) {
                    u00.n = new g(arrayList3.size(), f0.a);
                }
                this.E = null;
                this.r = null;
                this.w = null;
                this.B = c00;
                this.D = 2;
                object3 = v.k(arrayList3, u00.q, this);
                return object3 == a0 ? a0 : C0.f(c00, ((List)object3), f0.a, null, null, false, false, this.S, false, null, 444);
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        c00 = this.B;
        d5.n.D(object0);
        object3 = object0;
        return C0.f(c00, ((List)object3), f0.a, null, null, false, false, this.S, false, null, 444);
    }
}

