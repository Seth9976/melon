package vd;

import N0.v;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.jvm.internal.q;
import r1.l;
import yc.b;

public final class k implements we.k {
    public final int a;
    public final b0 b;

    public k(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((Integer)object0).intValue();
                this.b.setValue(((Integer)object0));
                return H.a;
            }
            case 1: {
                b0 b00 = this.b;
                if(!l.a(((l)b00.getValue()).a, ((l)object0))) {
                    b00.setValue(new l(((l)object0).a));
                }
                return H.a;
            }
            case 2: {
                ((Boolean)object0).booleanValue();
                this.b.setValue(((Boolean)object0));
                return H.a;
            }
            case 3: {
                q.g(((String)object0), "it");
                this.b.setValue(((String)object0));
                return H.a;
            }
            case 4: {
                b0 b01 = this.b;
                if(!l.a(((l)b01.getValue()).a, ((l)object0))) {
                    b01.setValue(new l(((l)object0).a));
                }
                return H.a;
            }
            case 5: {
                b0 b02 = this.b;
                if(!l.a(((l)b02.getValue()).a, ((l)object0))) {
                    b02.setValue(new l(((l)object0).a));
                }
                return H.a;
            }
            case 6: {
                b0 b03 = this.b;
                if(!l.a(((l)b03.getValue()).a, ((l)object0))) {
                    b03.setValue(new l(((l)object0).a));
                }
                return H.a;
            }
            case 7: {
                q.g(((v)object0), "coordinates");
                b0 b04 = this.b;
                if(!((Boolean)b04.getValue()).booleanValue() && Float.intBitsToFloat(((int)(((v)object0).j0(0L) & 0xFFFFFFFFL))) < b.f) {
                    b04.setValue(Boolean.TRUE);
                }
                return H.a;
            }
            default: {
                q.g(((v)object0), "coordinates");
                if(Float.intBitsToFloat(((int)(((v)object0).j0(0L) & 0xFFFFFFFFL))) < b.f) {
                    this.b.setValue(1.0f);
                }
                return H.a;
            }
        }
    }
}

