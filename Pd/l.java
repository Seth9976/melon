package pd;

import com.melon.ui.playback.VideoControllerHelper;
import ie.H;
import ie.m;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.MutableStateFlow;
import oe.i;
import we.n;

public final class l extends i implements n {
    public Object r;
    public final VideoControllerHelper w;

    public l(VideoControllerHelper videoControllerHelper0, Continuation continuation0) {
        this.w = videoControllerHelper0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((l)this.create(((m)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        m m0 = (m)this.r;
        d5.n.D(object0);
        m9.l l0 = new m9.l(4, m0, this.w);
        MutableStateFlow mutableStateFlow0 = this.w.n;
        do {
            Object object1 = mutableStateFlow0.getValue();
        }
        while(!mutableStateFlow0.compareAndSet(object1, l0.invoke(object1)));
        return H.a;
    }
}

