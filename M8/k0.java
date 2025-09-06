package m8;

import M6.B;
import Ma.m;
import android.app.Activity;
import android.content.Context;
import com.google.firebase.b;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import k8.o;
import kc.d3;
import kc.s2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class k0 extends i implements n {
    public final k B;
    public int r;
    public final Activity w;

    public k0(Activity activity0, k k0, Continuation continuation0) {
        this.w = activity0;
        this.B = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                q.g(this.w, "context");
                Context context0 = this.w.getApplicationContext();
                q.d(context0);
                B b0 = ((d3)(((s2)((o)(((m)b.B(context0, m.class)))).w.get()))).g();
                this.r = 1;
                object0 = ListenableFutureKt.await(b0, this);
                if(object0 == a0) {
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
        boolean z = e.k.y(((oc.H)object0));
        H h0 = H.a;
        if(z) {
            ToastManager.showShort(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
            return h0;
        }
        this.B.invoke(((oc.H)object0));
        return h0;
    }
}

