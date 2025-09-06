package Cc;

import G.H;
import G.e;
import android.graphics.PathMeasure;
import androidx.compose.runtime.b0;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import r1.l;
import we.n;
import y0.g;
import y0.j;

public final class h2 extends i implements n {
    public final float B;
    public final y0.i D;
    public final a E;
    public final List G;
    public final e I;
    public final H M;
    public int r;
    public final b0 w;

    public h2(b0 b00, float f, y0.i i0, a a0, List list0, e e0, H h0, Continuation continuation0) {
        this.w = b00;
        this.B = f;
        this.D = i0;
        this.E = a0;
        this.G = list0;
        this.I = e0;
        this.M = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h2(this.w, this.B, this.D, this.E, this.G, this.I, this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ne.a a0 = ne.a.a;
        ie.H h0 = ie.H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                b0 b00 = this.w;
                if(!l.b(((l)b00.getValue()).a, 0L)) {
                    long v = ((l)b00.getValue()).a;
                    PathMeasure pathMeasure0 = new PathMeasure();
                    g g0 = j.a();
                    List list0 = u2.g(v, this.B);
                    g0.e(((float)((z)list0.get(0)).a), ((float)((z)list0.get(0)).b));
                    float f = ((float)(((z)list0.get(0)).a + ((z)list0.get(1)).a)) / 2.0f;
                    Object object1 = list0.get(0);
                    Object object2 = list0.get(1);
                    float f1 = ((float)(((int)(v & 0xFFFFFFFFL)))) / 8.0f;
                    float f2 = (float)((z)list0.get(1)).a;
                    float f3 = (float)((z)list0.get(1)).b;
                    g0.a.quadTo(f, ((float)(((z)object1).b + ((z)object2).b)) / 2.0f - f1, f2, f3);
                    pathMeasure0.setPath(g0.a, false);
                    float f4 = pathMeasure0.getLength();
                    float f5 = ((float)(((int)(v >> 0x20)))) / 4.0f;
                    float f6 = ((float)(((z)list0.get(1)).a + ((z)list0.get(2)).a)) / 2.0f + f5;
                    float f7 = ((float)(((z)list0.get(1)).b + ((z)list0.get(2)).b)) / 2.0f;
                    float f8 = (float)((z)list0.get(2)).a;
                    float f9 = (float)((z)list0.get(2)).b;
                    g0.a.quadTo(f6, f7, f8, f9);
                    pathMeasure0.setPath(g0.a, false);
                    float f10 = pathMeasure0.getLength();
                    float f11 = ((float)(((z)list0.get(2)).a + ((z)list0.get(3)).a)) / 2.0f;
                    int v1 = ((z)list0.get(2)).b;
                    Object object3 = list0.get(3);
                    float f12 = (float)((z)list0.get(3)).a;
                    float f13 = (float)((z)list0.get(3)).b;
                    g0.a.quadTo(f11, ((float)(v1 + ((z)object3).b)) / 2.0f + f1, f12, f13);
                    pathMeasure0.setPath(g0.a, false);
                    float f14 = pathMeasure0.getLength();
                    float f15 = ((float)(((z)list0.get(3)).a + ((z)list0.get(0)).a)) / 2.0f - f5;
                    float f16 = ((float)(((z)list0.get(3)).b + ((z)list0.get(0)).b)) / 2.0f;
                    float f17 = (float)((z)list0.get(0)).a;
                    float f18 = (float)((z)list0.get(0)).b;
                    g0.a.quadTo(f15, f16, f17, f18);
                    this.D.b(g0);
                    float f19 = this.D.a.getLength();
                    Float float0 = 1.0f;
                    List list1 = this.G;
                    Float float1 = list1.size() > 0 ? list1.get(0) : 1.0f;
                    float f20 = float1.floatValue();
                    Float float2 = 1 < list1.size() ? list1.get(1) : 1.0f;
                    float f21 = float2.floatValue();
                    Float float3 = 2 < list1.size() ? list1.get(2) : 1.0f;
                    float f22 = float3.floatValue();
                    if(3 < list1.size()) {
                        float0 = list1.get(3);
                    }
                    d2 d20 = new d2(f20, f4 / f19, f21, f10 / f19, f22, f14 / f19, float0.floatValue());
                    this.E.getClass();
                    this.E.a = d20;
                    this.r = 1;
                    if(this.I.e(new Float(0.0f), this) == a0) {
                        return a0;
                    }
                    goto label_72;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
            label_72:
                this.r = 2;
                if(e.c(this.I, new Float(1.0f), this.M, null, this, 12) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

