package j5;

import N0.k;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.O0;
import coil.request.ImageRequest.Builder;
import i.n.i.b.a.s.e.M3;
import i5.e;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.i;
import t5.d;
import t5.j;
import t5.s;
import u5.c;
import u5.f;
import we.n;

public final class h extends i implements n {
    public final l B;
    public int r;
    public Object w;

    public h(l l0, Continuation continuation0) {
        this.B = l0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((j)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        l l1;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                j j0 = (j)this.w;
                l l0 = this.B;
                e e0 = (e)((O0)l0.o).getValue();
                ImageRequest.Builder imageRequest$Builder0 = j.a(j0);
                imageRequest$Builder0.d = new j5.j(l0);
                imageRequest$Builder0.b();
                d d0 = j0.C;
                if(d0.a == null) {
                    imageRequest$Builder0.r = new j5.j(l0);
                    imageRequest$Builder0.b();
                }
                if(d0.b == null) {
                    k k0 = l0.j;
                    imageRequest$Builder0.s = q.b(k0, N0.j.c) || q.b(k0, N0.j.f) ? f.b : f.a;
                }
                if(d0.d != c.a) {
                    imageRequest$Builder0.g = c.b;
                }
                j j1 = imageRequest$Builder0.a();
                this.w = l0;
                this.r = 1;
                object0 = ((i5.n)e0).c(j1, this);
                if(object0 == a0) {
                    return a0;
                }
                l1 = l0;
                break;
            }
            case 1: {
                l1 = (l)this.w;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        l1.getClass();
        if(((t5.k)object0) instanceof s) {
            return new j5.f(l1.a(((s)(((t5.k)object0))).a), ((s)(((t5.k)object0))));
        }
        if(!(((t5.k)object0) instanceof t5.f)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        Drawable drawable0 = ((t5.f)(((t5.k)object0))).a;
        return drawable0 == null ? new j5.d(null, ((t5.f)(((t5.k)object0)))) : new j5.d(l1.a(drawable0), ((t5.f)(((t5.k)object0))));
    }
}

