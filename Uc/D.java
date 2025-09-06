package uc;

import com.iloen.melon.playback.playlist.add.LiveAddRequestPlayableListInfo;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;
import we.n;

public final class d extends i implements n {
    public final int B;
    public final LiveAddRequestPlayableListInfo D;
    public Object r;
    public final List w;

    public d(List list0, int v, LiveAddRequestPlayableListInfo liveAddRequestPlayableListInfo0, Continuation continuation0) {
        this.w = list0;
        this.B = v;
        this.D = liveAddRequestPlayableListInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d(this.w, this.B, this.D, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((k)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        k k0 = (k)this.r;
        d5.n.D(object0);
        k0.getClass();
        q.g(this.w, "playableDataList");
        return new k(this.w, this.B, this.D.getDetailRes());
    }
}

