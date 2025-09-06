package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oc.Q;
import oe.i;
import we.n;

public final class p extends i implements n {
    public final PlaylistId B;
    public final Q D;
    public final long E;
    public int r;
    public final b w;

    public p(b b0, PlaylistId playlistId0, Q q0, long v, Continuation continuation0) {
        this.w = b0;
        this.B = playlistId0;
        this.D = q0;
        this.E = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                o o0 = new o(this.w, this.D, this.E, null);
                this.r = 1;
                return this.w.p(this.B, o0, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

