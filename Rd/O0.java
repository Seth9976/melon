package rd;

import G.e;
import G.x0;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;
import y0.s;

public final class o0 extends i implements n {
    public final String B;
    public final Context D;
    public final b0 E;
    public final b0 G;
    public final b0 I;
    public final b0 M;
    public final e N;
    public final x0 S;
    public final e T;
    public int r;
    public Object w;

    public o0(String s, Context context0, b0 b00, b0 b01, b0 b02, b0 b03, e e0, x0 x00, e e1, Continuation continuation0) {
        this.B = s;
        this.D = context0;
        this.E = b00;
        this.G = b01;
        this.I = b02;
        this.M = b03;
        this.N = e0;
        this.S = x00;
        this.T = e1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new o0(this.B, this.D, this.E, this.G, this.I, this.M, this.N, this.S, this.T, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        String s = this.B;
        b0 b00 = this.E;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(!q.b(s, ((String)b00.getValue()))) {
                    this.w = coroutineScope0;
                    this.r = 1;
                    object0 = rd.a.w(this.D, s, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_14;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
            label_14:
                this.w = coroutineScope0;
                this.r = 2;
                object0 = rd.a.v(((BitmapDrawable)object0), this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_20;
            }
            case 2: {
                d5.n.D(object0);
            label_20:
                long v = ((s)object0).a;
                String s1 = (String)b00.getValue();
                b0 b01 = this.I;
                if(s1 != null) {
                    String s2 = (String)b00.getValue();
                    this.G.setValue(s2);
                    s s3 = new s(((s)b01.getValue()).a);
                    this.M.setValue(s3);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new m0(this.N, this.S, this.G, null), 3, null);
                    b00.setValue(s);
                    b01.setValue(new s(v));
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n0(this.T, this.S, null), 3, null);
                    return H.a;
                }
                b00.setValue(s);
                b01.setValue(new s(v));
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

