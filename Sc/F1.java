package sc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource;
import com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oc.p0;
import oc.q0;
import oc.r0;
import oc.s0;
import oc.t0;
import oc.u0;
import oc.v0;
import oc.w0;
import oc.x0;
import oc.y0;
import oe.c;

public final class f1 {
    public final SmartPlaylistDBDataSource a;
    public final EachPlytSettingPreferencesRepository b;
    public final CoroutineScope c;

    public f1(SmartPlaylistDBDataSource smartPlaylistDBDataSource0, EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0) {
        this.a = smartPlaylistDBDataSource0;
        this.b = eachPlytSettingPreferencesRepository0;
        new LogU("SmartPlaylistRepository");
        this.c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final Object a(c c0) {
        R0 r00;
        if(c0 instanceof R0) {
            r00 = (R0)c0;
            int v = r00.B;
            if((v & 0x80000000) == 0) {
                r00 = new R0(this, c0);
            }
            else {
                r00.B = v ^ 0x80000000;
            }
        }
        else {
            r00 = new R0(this, c0);
        }
        Object object0 = r00.r;
        a a0 = a.a;
        switch(r00.B) {
            case 0: {
                n.D(object0);
                r00.B = 1;
                object0 = FlowKt.firstOrNull(this.b.getLastUniqueIdFlow(), r00);
                if(object0 == a0) {
                    return a0;
                }
                return ((String)object0) == null ? "" : ((String)object0);
            }
            case 1: {
                n.D(object0);
                return ((String)object0) == null ? "" : ((String)object0);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object b(c c0) {
        S0 s00;
        if(c0 instanceof S0) {
            s00 = (S0)c0;
            int v = s00.B;
            if((v & 0x80000000) == 0) {
                s00 = new S0(this, c0);
            }
            else {
                s00.B = v ^ 0x80000000;
            }
        }
        else {
            s00 = new S0(this, c0);
        }
        Object object0 = s00.r;
        a a0 = a.a;
        switch(s00.B) {
            case 0: {
                n.D(object0);
                s00.B = 1;
                object0 = FlowKt.firstOrNull(this.b.getPlayedTimeFlow(), s00);
                if(object0 == a0) {
                    return a0;
                }
                return ((Long)object0) == null ? new Long(-1L) : new Long(((long)(((Long)object0))));
            }
            case 1: {
                n.D(object0);
                return ((Long)object0) == null ? new Long(-1L) : new Long(((long)(((Long)object0))));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object c(c c0) {
        T0 t00;
        if(c0 instanceof T0) {
            t00 = (T0)c0;
            int v = t00.B;
            if((v & 0x80000000) == 0) {
                t00 = new T0(this, c0);
            }
            else {
                t00.B = v ^ 0x80000000;
            }
        }
        else {
            t00 = new T0(this, c0);
        }
        Object object0 = t00.r;
        a a0 = a.a;
        switch(t00.B) {
            case 0: {
                n.D(object0);
                t00.B = 1;
                object0 = FlowKt.firstOrNull(this.b.getSelectedRepeatUniqueIdList(), t00);
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
        return ((List)object0) == null ? w.a : ((List)object0);
    }

    public final Object d(c c0) {
        U0 u00;
        if(c0 instanceof U0) {
            u00 = (U0)c0;
            int v = u00.B;
            if((v & 0x80000000) == 0) {
                u00 = new U0(this, c0);
            }
            else {
                u00.B = v ^ 0x80000000;
            }
        }
        else {
            u00 = new U0(this, c0);
        }
        Object object0 = u00.r;
        a a0 = a.a;
        switch(u00.B) {
            case 0: {
                n.D(object0);
                u00.B = 1;
                object0 = FlowKt.firstOrNull(this.b.getSortTypeFlow(), u00);
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
        if(((Integer)object0) != null) {
            int v1 = ((Integer)object0).intValue();
            switch(v1) {
                case 0: {
                    break;
                }
                case 1: {
                    return s0.b;
                }
                case 2: {
                    return u0.b;
                }
                case 3: {
                    return v0.b;
                }
                case 4: {
                    return q0.b;
                }
                case 5: {
                    return r0.b;
                }
                case 6: {
                    return w0.b;
                }
                case 7: {
                    return x0.b;
                }
                case 8: {
                    return p0.b;
                }
                default: {
                    throw new IllegalArgumentException("Unknown sort type: " + v1);
                }
            }
        }
        return t0.b;
    }

    public final void e(Playable playable0, String s) {
        q.g(s, "reason");
        Z0 z00 = new Z0(this, playable0, s, null);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, z00, 3, null);
    }

    public final void f(long v, String s) {
        q.g(s, "reason");
        a1 a10 = new a1(this, v, s, null);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, a10, 3, null);
    }

    public final void g(String s, List list0) {
        q.g(list0, "list");
        q.g(s, "reason");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(PlayableExtensionsKt.toSmartEntity(((Playable)object0)));
        }
        c1 c10 = new c1(this, arrayList0, null);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, c10, 3, null);
    }

    public final void h(List list0) {
        d1 d10 = new d1(this, list0, null);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, d10, 3, null);
    }

    public final void i(y0 y00, String s) {
        q.g(y00, "sortType");
        e1 e10 = new e1(this, y00, s, null);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, e10, 3, null);
    }
}

