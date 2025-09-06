package pc;

import Tf.v;
import U4.x;
import b3.Z;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import db.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import je.p;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import l2.i;
import ne.a;
import oe.c;

public final class y0 implements b0 {
    public final E0 a;
    public final q b;
    public final C0 c;
    public final EachPlytSettingPreferencesRepository d;
    public final i e;
    public final LogU f;
    public final CoroutineScope g;

    public y0(E0 e00, q q0, C0 c00, EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, i i0, g g0) {
        kotlin.jvm.internal.q.g(i0, "mixUpDataStore");
        super();
        this.a = e00;
        this.b = q0;
        this.c = c00;
        this.d = eachPlytSettingPreferencesRepository0;
        this.e = i0;
        LogU logU0 = Z.g("MixUpPlaylistRepositoryImpl", true);
        logU0.setCategory(Category.Playback);
        this.f = logU0;
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static final Object a(y0 y00, List list0, c c0) {
        E0 e01;
        f0 f00;
        if(c0 instanceof f0) {
            f00 = (f0)c0;
            int v = f00.E;
            if((v & 0x80000000) == 0) {
                f00 = new f0(y00, c0);
            }
            else {
                f00.E = v ^ 0x80000000;
            }
        }
        else {
            f00 = new f0(y00, c0);
        }
        Serializable serializable0 = f00.B;
        a a0 = a.a;
        switch(f00.E) {
            case 0: {
                n.D(serializable0);
                LogU.debug$default(y00.f, x.e(list0.size(), "fetchMoreWaitingList: playingList size="), null, false, 6, null);
                E0 e00 = y00.a;
                f00.r = e00;
                f00.w = list0;
                f00.E = 1;
                Serializable serializable1 = y00.c.a(f00);
                if(serializable1 == a0) {
                    return a0;
                }
                serializable0 = serializable1;
                e01 = e00;
                break;
            }
            case 1: {
                list0 = f00.w;
                e01 = f00.r;
                n.D(serializable0);
                break;
            }
            case 2: {
                n.D(serializable0);
                return serializable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        f00.r = null;
        f00.w = null;
        f00.E = 2;
        Object object0 = e01.a(list0, ((List)serializable0), f00);
        return object0 == a0 ? a0 : object0;
    }

    public final Object b(c c0) {
        j0 j00;
        if(c0 instanceof j0) {
            j00 = (j0)c0;
            int v = j00.B;
            if((v & 0x80000000) == 0) {
                j00 = new j0(this, c0);
            }
            else {
                j00.B = v ^ 0x80000000;
            }
        }
        else {
            j00 = new j0(this, c0);
        }
        Object object0 = j00.r;
        a a0 = a.a;
        switch(j00.B) {
            case 0: {
                n.D(object0);
                j00.B = 1;
                object0 = FlowKt.firstOrNull(this.d.getLastUniqueIdFlow(), j00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((String)object0) != null) {
            Integer integer0 = v.t0(((String)object0));
            return integer0 == null ? new Integer(-1) : new Integer(((int)integer0));
        }
        return new Integer(-1);
    }

    public final Object c(c c0) {
        l0 l00;
        if(c0 instanceof l0) {
            l00 = (l0)c0;
            int v = l00.B;
            if((v & 0x80000000) == 0) {
                l00 = new l0(this, c0);
            }
            else {
                l00.B = v ^ 0x80000000;
            }
        }
        else {
            l00 = new l0(this, c0);
        }
        Object object0 = l00.r;
        a a0 = a.a;
        switch(l00.B) {
            case 0: {
                n.D(object0);
                l00.B = 1;
                object0 = FlowKt.firstOrNull(this.d.getPlayedTimeFlow(), l00);
                if(object0 == a0) {
                    return a0;
                }
                return ((Long)object0) == null ? new Long(0L) : new Long(((long)(((Long)object0))));
            }
            case 1: {
                n.D(object0);
                return ((Long)object0) == null ? new Long(0L) : new Long(((long)(((Long)object0))));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final void d(List list0, Collection collection0, LinkedList linkedList0) {
        kotlin.jvm.internal.q.g(list0, "removedList");
        kotlin.jvm.internal.q.g(collection0, "addList");
        kotlin.jvm.internal.q.g(linkedList0, "allOrderedList");
        o0 o00 = new o0(this, list0, collection0, p.P0(linkedList0), null);
        BuildersKt__Builders_commonKt.launch$default(this.g, null, null, o00, 3, null);
    }

    public final void e(int v) {
        q0 q00 = new q0(v, null, this);
        BuildersKt__Builders_commonKt.launch$default(this.g, null, null, q00, 3, null);
    }

    public final void f(int v, String s) {
        kotlin.jvm.internal.q.g(s, "reason");
        r0 r00 = new r0(this, v, s, null);
        BuildersKt__Builders_commonKt.launch$default(this.g, null, null, r00, 3, null);
    }

    public final void g(long v, String s) {
        kotlin.jvm.internal.q.g(s, "reason");
        u0 u00 = new u0(this, v, s, null);
        BuildersKt__Builders_commonKt.launch$default(this.g, null, null, u00, 3, null);
    }

    public final Object h(List list0, c c0) {
        v0 v00;
        if(c0 instanceof v0) {
            v00 = (v0)c0;
            int v = v00.B;
            if((v & 0x80000000) == 0) {
                v00 = new v0(this, c0);
            }
            else {
                v00.B = v ^ 0x80000000;
            }
        }
        else {
            v00 = new v0(this, c0);
        }
        Serializable serializable0 = v00.r;
        a a0 = a.a;
        switch(v00.B) {
            case 0: {
                n.D(serializable0);
                w0 w00 = new w0(this, list0, null);
                v00.B = 1;
                serializable0 = this.c.c(w00, v00);
                if(serializable0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(serializable0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.f, x.e(((List)serializable0).size(), "takeNextRecommendSong: "), null, false, 6, null);
        return serializable0;
    }

    public final void i(String s, List list0) {
        kotlin.jvm.internal.q.g(list0, "list");
        kotlin.jvm.internal.q.g(s, "reason");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(PlayableExtensionsKt.toMixUpEntity(((Playable)object0)));
        }
        x0 x00 = new x0(this, arrayList0, null);
        BuildersKt__Builders_commonKt.launch$default(this.g, null, null, x00, 3, null);
    }
}

