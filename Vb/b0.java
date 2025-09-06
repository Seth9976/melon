package Vb;

import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oc.Q;
import oe.i;
import we.n;

public final class b0 extends i implements n {
    public int B;
    public final o0 D;
    public Q r;
    public long w;

    public b0(o0 o00, Continuation continuation0) {
        this.D = o00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b0(this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v1;
        Q q1;
        a a0 = a.a;
        o0 o00 = this.D;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                this.B = 1;
                object0 = o00.B.a(this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_10;
            }
            case 1: {
                d5.n.D(object0);
            label_10:
                Q q0 = ((d)object0).a;
                long v = ((d)object0).b;
                List list0 = q0.c();
                this.r = q0;
                this.w = v;
                this.B = 2;
                object0 = o00.u1(list0, this);
                if(object0 == a0) {
                    return a0;
                }
                q1 = q0;
                v1 = v;
                break;
            }
            case 2: {
                long v2 = this.w;
                Q q2 = this.r;
                d5.n.D(object0);
                v1 = v2;
                q1 = q2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o00.j1(new f(o00, ((List)object0), q1, v1, 1));
        LogU.debug$default(o00.e1(), "initPlaylistIfNeed - playlistInitJob end.", null, false, 6, null);
        return H.a;
    }
}

