package tc;

import com.iloen.melon.playback.playlist.add.StationAddRequestPlayableListInfo;
import com.melon.playlist.station.CastData;
import df.v;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class k extends i implements n {
    public final x B;
    public final int D;
    public final StationAddRequestPlayableListInfo E;
    public int r;
    public final List w;

    public k(int v, StationAddRequestPlayableListInfo stationAddRequestPlayableListInfo0, List list0, Continuation continuation0, x x0) {
        this.w = list0;
        this.B = x0;
        this.D = v;
        this.E = stationAddRequestPlayableListInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k(this.D, this.E, this.w, continuation0, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((F)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = v.k(this.w, this.B.g, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        CastData castData0 = y.a(this.E.getResponse());
        return new F(((List)object0), this.D, castData0);
    }
}

