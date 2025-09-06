package Q0;

import android.view.View;
import androidx.compose.runtime.p0;
import androidx.compose.runtime.u0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class i1 extends i implements n {
    public final View B;
    public int r;
    public final u0 w;

    public i1(u0 u00, View view0, Continuation continuation0) {
        this.w = u00;
        this.B = view0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        u0 u00 = this.w;
        View view0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                try {
                    this.r = 1;
                    p0 p00 = new p0(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    H h1 = FlowKt.first(u00.u, p00, this);
                    if(h1 != a0) {
                        h1 = h0;
                    }
                    if(h1 == a0) {
                        return a0;
                    label_14:
                        d5.n.D(object0);
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_17;
                }
            }
            case 1: {
                goto label_14;
            label_17:
                if(q1.b(view0) == u00) {
                    view0.setTag(0x7F0A009E, null);  // id:androidx_compose_ui_view_composition_context
                }
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(q1.b(view0) == u00) {
            view0.setTag(0x7F0A009E, null);  // id:androidx_compose_ui_view_composition_context
        }
        return h0;
    }
}

