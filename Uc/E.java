package uc;

import com.iloen.melon.playback.playlist.add.LiveAddRequestPlayableListInfo;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class e extends i implements n {
    public final List B;
    public final int D;
    public final LiveAddRequestPlayableListInfo E;
    public int r;
    public final j w;

    public e(j j0, List list0, int v, LiveAddRequestPlayableListInfo liveAddRequestPlayableListInfo0, Continuation continuation0) {
        this.w = j0;
        this.B = list0;
        this.D = v;
        this.E = liveAddRequestPlayableListInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d d0 = new d(this.B, this.D, this.E, null);
                this.r = 1;
                return this.w.e("add()", d0, this) == a0 ? a0 : H.a;
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

