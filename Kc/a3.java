package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class a3 extends i implements n {
    public final PlaylistId B;
    public final String D;
    public final boolean E;
    public final boolean G;
    public final i I;
    public int r;
    public final d3 w;

    public a3(d3 d30, PlaylistId playlistId0, String s, boolean z, boolean z1, n n0, Continuation continuation0) {
        this.w = d30;
        this.B = playlistId0;
        this.D = s;
        this.E = z;
        this.G = z1;
        this.I = (i)n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a3(this.w, this.B, this.D, this.E, this.G, ((n)this.I), continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a3)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                Object object1 = ((b)this.w.a).i0(this.B, this.D, this.E, this.G, ((n)this.I), this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

