package W;

import Q0.V;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScopeKt;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class e extends i implements n {
    public final k B;
    public final f D;
    public final r E;
    public int r;
    public Object w;

    public e(k k0, f f0, r r0, Continuation continuation0) {
        this.B = k0;
        this.D = f0;
        this.E = r0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((e)this.create(((V)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d d0 = new d(((V)this.w), this.B, this.D, this.E, null);
                this.r = 1;
                if(CoroutineScopeKt.coroutineScope(d0, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }
}

