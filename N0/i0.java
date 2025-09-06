package N0;

import P0.I;
import androidx.compose.runtime.s;
import ie.H;
import kotlin.jvm.internal.r;
import we.n;

public final class i0 extends r implements n {
    public final int f;
    public final j0 g;

    public i0(j0 j00, int v) {
        this.f = v;
        this.g = j00;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                I i2 = (I)object0;
                this.g.a().b = (s)object1;
                return H.a;
            }
            case 1: {
                N0.I i3 = this.g.a();
                ((I)object0).b0(new F(i3, ((n)object1), i3.r));
                return H.a;
            }
            default: {
                j0 j00 = (j0)object1;
                j0 j01 = this.g;
                m0 m00 = j01.a;
                N0.I i0 = ((I)object0).d0;
                if(i0 == null) {
                    i0 = new N0.I(((I)object0), m00);
                    ((I)object0).d0 = i0;
                }
                j01.b = i0;
                j01.a().e();
                N0.I i1 = j01.a();
                if(i1.c != m00) {
                    i1.c = m00;
                    i1.f(false);
                    I.W(i1.a, false, 7);
                }
                return H.a;
            }
        }
    }
}

