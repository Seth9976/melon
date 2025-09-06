package kd;

import android.content.Context;
import androidx.compose.runtime.b0;
import androidx.media3.session.legacy.V;
import coil.ImageLoader.Builder;
import coil.request.ImageRequest.Builder;
import ie.H;
import jd.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import t5.j;
import t5.k;
import we.n;

public final class o extends i implements n {
    public final p B;
    public final b0 D;
    public final b0 E;
    public final b0 G;
    public int r;
    public final Context w;

    public o(Context context0, p p0, b0 b00, b0 b01, b0 b02, Continuation continuation0) {
        this.w = context0;
        this.B = p0;
        this.D = b00;
        this.E = b01;
        this.G = b02;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        p p0 = this.B;
        String s = p0.a;
        a a0 = a.a;
        b0 b00 = this.G;
        b0 b01 = this.E;
        b0 b02 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(((Number)b02.getValue()).intValue() <= 3) {
                    ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(this.w);
                    imageRequest$Builder0.c = s;
                    imageRequest$Builder0.e = new V(p0, b01, b00);
                    j j0 = imageRequest$Builder0.a();
                    i5.n n0 = new ImageLoader.Builder(this.w).a();
                    this.r = 1;
                    object0 = n0.c(j0, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_23;
                }
                b01.setValue(s);
                b00.setValue(Boolean.FALSE);
                return H.a;
            }
            case 1: {
                d5.n.D(object0);
            label_23:
                if(((k)object0).a() != null || ((Number)b02.getValue()).intValue() >= 3) {
                    goto label_27;
                }
                this.r = 2;
                if(DelayKt.delay(500L, this) == a0) {
                    return a0;
                label_27:
                    if(((k)object0).a() == null) {
                        b01.setValue(s);
                        b00.setValue(Boolean.FALSE);
                        return H.a;
                    }
                    return H.a;
                }
                b02.setValue(((int)(((Number)b02.getValue()).intValue() + 1)));
                return H.a;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(object0);
        b02.setValue(((int)(((Number)b02.getValue()).intValue() + 1)));
        return H.a;
    }
}

