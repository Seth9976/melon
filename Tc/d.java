package tc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.StationAddRequestPlayableListInfo;
import com.melon.playlist.station.CastData;
import df.v;
import ie.H;
import java.util.Iterator;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class d extends i implements n {
    public int B;
    public int D;
    public Object E;
    public final AddRequestPlayableListInfo G;
    public final x I;
    public Playable r;
    public F w;

    public d(AddRequestPlayableListInfo addRequestPlayableListInfo0, Continuation continuation0, x x0) {
        this.G = addRequestPlayableListInfo0;
        this.I = x0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d(this.G, continuation0, this.I);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((F)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v;
        F f0 = (F)this.E;
        a a0 = a.a;
        x x0 = this.I;
        AddRequestPlayableListInfo addRequestPlayableListInfo0 = this.G;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                List list0 = ((StationAddRequestPlayableListInfo)addRequestPlayableListInfo0).getUserRequestedPlaylist();
                v = 0;
                int v1 = 0;
                Iterator iterator0 = list0.iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        v1 = -1;
                        break;
                    }
                    iterator0.next();
                    if(q.b("", ((StationAddRequestPlayableListInfo)addRequestPlayableListInfo0).getStartingContsId())) {
                        break;
                    }
                    ++v1;
                }
                if(v1 >= 0) {
                    v = v1;
                }
                Playable playable0 = (Playable)p.n0(v, list0);
                x0.e = -1L;
                this.E = null;
                this.r = playable0;
                this.w = f0;
                this.B = v;
                this.D = 1;
                Object object1 = v.k(list0, x0.g, this);
                if(object1 == a0) {
                    return a0;
                }
                object0 = object1;
                break;
            }
            case 1: {
                int v2 = this.B;
                F f1 = this.w;
                d5.n.D(object0);
                v = v2;
                f0 = f1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        CastData castData0 = y.a(((StationAddRequestPlayableListInfo)addRequestPlayableListInfo0).getResponse());
        f0.getClass();
        q.g(((List)object0), "playableDataList");
        F f2 = new F(((List)object0), v, castData0);
        B b0 = new B((castData0.a == null ? "" : castData0.a), null);
        BuildersKt__Builders_commonKt.launch$default(x0.a.a, Dispatchers.getIO(), null, b0, 2, null);
        D d0 = new D(x0.a, "", "add", null);
        BuildersKt__Builders_commonKt.launch$default(x0.a.a, null, null, d0, 3, null);
        x0.a.c(x0.e, "add");
        return f2;
    }
}

