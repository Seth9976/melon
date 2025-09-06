package I;

import F.g;
import G.f;
import G.p;
import G.y;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.E;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class m extends i implements n {
    public int B;
    public final float D;
    public final I.n E;
    public final b1 G;
    public E r;
    public p w;

    public m(float f, I.n n0, b1 b10, Continuation continuation0) {
        this.D = f;
        this.E = n0;
        this.G = b10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m(this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        p p1;
        E e0;
        float f;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                f = this.D;
                if(Math.abs(f) > 1.0f) {
                    e0 = new E();  // 初始化器: Ljava/lang/Object;-><init>()V
                    e0.a = f;
                    E e1 = new E();  // 初始化器: Ljava/lang/Object;-><init>()V
                    p p0 = f.b(0.0f, f, 28);
                    try {
                        y y0 = this.E.a;
                        g g0 = new g(e1, this.G, e0, this.E);
                        this.r = e0;
                        this.w = p0;
                        this.B = 1;
                        if(f.e(p0, y0, false, g0, this) == a0) {
                            return a0;
                        }
                    }
                    catch(CancellationException unused_ex) {
                        p1 = p0;
                        e0.a = ((Number)p1.a()).floatValue();
                        f = e0.a;
                        break;
                    }
                    return new Float(e0.a);
                }
                break;
            }
            case 1: {
                try {
                    p1 = this.w;
                    e0 = this.r;
                    d5.n.D(object0);
                    f = e0.a;
                    break;
                }
                catch(CancellationException unused_ex) {
                }
                e0.a = ((Number)p1.a()).floatValue();
                f = e0.a;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Float(f);
    }
}

