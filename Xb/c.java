package Xb;

import com.iloen.melon.utils.log.LogU;
import ie.H;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class c extends i implements n {
    public final d B;
    public int r;
    public final s2 w;

    public c(s2 s20, d d0, Continuation continuation0) {
        this.w = s20;
        this.B = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                q.g(this.w, "playlistManager");
                x9.a a1 = new x9.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                a1.a = this.w;
                a1.b = new LogU("RemoveInCurrentPlaylistByMediaIdUseCase");
                this.r = 1;
                return a1.C(this.B.a, this) == a0 ? a0 : H.a;
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

