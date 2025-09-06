package gc;

import Nb.z0;
import Sb.b;
import android.net.Uri;
import b3.E;
import com.iloen.melon.utils.log.LogConstantsKt;
import ie.H;
import ie.o;
import ie.p;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import ne.a;
import oe.i;
import we.n;

public final class x extends i implements n {
    public int B;
    public int D;
    public Object E;
    public final y G;
    public final E I;
    public final z0 M;
    public y r;
    public E w;

    public x(y y0, E e0, z0 z00, Continuation continuation0) {
        this.G = y0;
        this.I = e0;
        this.M = z00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new x(this.G, this.I, this.M, continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        o o0;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.E;
        a a0 = a.a;
        z0 z00 = this.M;
        E e0 = this.I;
        y y0 = this.G;
        H h0 = H.a;
        Sb.a a1 = null;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                try {
                    this.E = null;
                    this.r = y0;
                    this.w = e0;
                    int v = 0;
                    this.B = 0;
                    this.D = 1;
                    Comparable comparable0 = y0.E0(e0, z00, this);
                    if(comparable0 == a0) {
                        return a0;
                    }
                    y y1 = y0;
                    E e1 = e0;
                    goto label_28;
                label_21:
                    v = this.B;
                    E e2 = this.w;
                    y y2 = this.r;
                    d5.n.D(object0);
                    y1 = y2;
                    e1 = e2;
                    comparable0 = object0;
                label_28:
                    LogConstantsKt.debugOnlyDebugMode(y1.l, "prepareItem() mediaUri: " + ((Uri)comparable0));
                    MainCoroutineDispatcher mainCoroutineDispatcher0 = Dispatchers.getMain().getImmediate();
                    w w0 = new w(y1, ((Uri)comparable0), e1, null);
                    this.E = null;
                    this.r = null;
                    this.w = null;
                    this.B = v;
                    this.D = 2;
                    if(BuildersKt.withContext(mainCoroutineDispatcher0, w0, this) == a0) {
                        return a0;
                    }
                    o0 = h0;
                    goto label_45;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                goto label_21;
            }
            case 2: {
                Uri uri0 = (Uri)this.w;
                CoroutineScope coroutineScope1 = (CoroutineScope)this.r;
                try {
                    d5.n.D(object0);
                    o0 = h0;
                    goto label_45;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o0 = d5.n.t(throwable0);
    label_45:
        Throwable throwable1 = p.a(o0);
        if(throwable1 != null) {
            if(throwable1 instanceof CancellationException) {
                LogConstantsKt.debugOnlyDebugMode(y0.l, "prepareItem() Cancelled.");
                return h0;
            }
            if(throwable1 instanceof Sb.a) {
                a1 = (Sb.a)throwable1;
            }
            if(a1 == null) {
                q.f("곡 재생에 실패하였습니다.", "getString(...)");
                a1 = new b("곡 재생에 실패하였습니다.", throwable1);
            }
            r r0 = new r(y0, z00, a1, e0, null);
            BuildersKt__Builders_commonKt.launch$default(y0.k, null, null, r0, 3, null);
        }
        return h0;
    }
}

