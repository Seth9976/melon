package Rc;

import Ac.N;
import androidx.media3.session.legacy.V;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import e1.b;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oc.Q;
import oe.i;
import we.n;

public final class o0 extends i implements n {
    public int r;
    public final t0 w;

    public o0(t0 t00, Continuation continuation0) {
        this.w = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        t0 t00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                V v0 = t00.e;
                int v1 = !t00.m;
                String s = t00.getMenuId();
                PlaylistId playlistId0 = t00.d();
                q.d(playlistId0);
                Q q0 = t00.j;
                if(q0 != null) {
                    ArrayList arrayList0 = b.B(q0);
                    Q q1 = t00.j;
                    if(q1 != null) {
                        Playable playable0 = (Playable)arrayList0.get(q1.b());
                        this.r = 1;
                        object0 = v0.p(((boolean)v1), s, playlistId0, playable0);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    q.m("playlistState");
                    throw null;
                }
                q.m("playlistState");
                throw null;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        N n0 = new N(t00, 11);
        this.r = 2;
        return ((Flow)object0).collect(n0, this) == a0 ? a0 : H.a;
    }
}

