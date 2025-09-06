package Cc;

import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import r1.l;
import we.n;

public final class i2 extends i implements n {
    public final b1 B;
    public final List D;
    public final b1 E;
    public final b1 G;
    public final b1 I;
    public final b0 r;
    public final float w;

    public i2(b0 b00, float f, b1 b10, List list0, b1 b11, b1 b12, b1 b13, Continuation continuation0) {
        this.r = b00;
        this.w = f;
        this.B = b10;
        this.D = list0;
        this.E = b11;
        this.G = b12;
        this.I = b13;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i2(this.r, this.w, this.B, this.D, this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((i2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        b0 b00 = this.r;
        boolean z = l.b(((l)b00.getValue()).a, 0L);
        H h0 = H.a;
        if(z) {
            return h0;
        }
        List list0 = u2.g(((l)b00.getValue()).a, this.w);
        b0 b01 = (b0)this.B;
        int v = ((z)list0.get(0)).a;
        int v1 = ((z)list0.get(0)).b;
        List list1 = this.D;
        Float float0 = list1.size() > 0 ? list1.get(0) : new Float(1.0f);
        b01.setValue(new z(v, v1, float0.floatValue()));
        b0 b02 = (b0)this.E;
        int v2 = ((z)list0.get(1)).a;
        int v3 = ((z)list0.get(1)).b;
        Float float1 = 1 < list1.size() ? list1.get(1) : new Float(1.0f);
        b02.setValue(new z(v2, v3, float1.floatValue()));
        b0 b03 = (b0)this.G;
        int v4 = ((z)list0.get(2)).a;
        int v5 = ((z)list0.get(2)).b;
        Float float2 = 2 < list1.size() ? list1.get(2) : new Float(1.0f);
        b03.setValue(new z(v4, v5, float2.floatValue()));
        b0 b04 = (b0)this.I;
        int v6 = ((z)list0.get(3)).a;
        int v7 = ((z)list0.get(3)).b;
        Float float3 = 3 < list1.size() ? list1.get(3) : new Float(1.0f);
        b04.setValue(new z(v6, v7, float3.floatValue()));
        return h0;
    }
}

