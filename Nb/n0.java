package Nb;

import com.melon.playback.PlaybackLibraryService;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mb.k;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class n0 extends i implements n {
    public int r;
    public final PlaybackLibraryService w;

    public n0(PlaybackLibraryService playbackLibraryService0, Continuation continuation0) {
        this.w = playbackLibraryService0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                k k0 = this.w.r;
                if(k0 != null) {
                    Flow flow0 = FlowKt.drop(FlowKt.distinctUntilChanged(((e0)k0).n()), 1);
                    m0 m00 = new m0(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    this.r = 1;
                    return FlowKt.collectLatest(flow0, m00, this) == a0 ? a0 : H.a;
                }
                q.m("loginUseCase");
                throw null;
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

