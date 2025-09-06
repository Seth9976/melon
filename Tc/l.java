package tc;

import com.iloen.melon.playback.playlist.add.StationAddRequestPlayableListInfo;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class l extends i implements n {
    public final x B;
    public final List D;
    public final int E;
    public final StationAddRequestPlayableListInfo G;
    public x r;
    public int w;

    public l(int v, StationAddRequestPlayableListInfo stationAddRequestPlayableListInfo0, List list0, Continuation continuation0, x x0) {
        this.B = x0;
        this.D = list0;
        this.E = v;
        this.G = stationAddRequestPlayableListInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l(this.E, this.G, this.D, continuation0, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        x x1;
        a a0 = a.a;
        x x0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.r = x0;
                this.w = 1;
                object0 = x0.a.b(this);
                if(object0 == a0) {
                    return a0;
                }
                x1 = x0;
                break;
            }
            case 1: {
                x1 = this.r;
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        x1.e = ((Number)object0).longValue();
        k k0 = new k(this.E, this.G, this.D, null, x0);
        this.r = null;
        this.w = 2;
        Object object1 = x0.m(k0, this);
        return object1 == a0 ? a0 : object1;
    }
}

