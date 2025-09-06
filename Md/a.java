package md;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import nd.b;
import we.n;

public final class a implements n {
    public final int a;
    public final h b;

    public a(h h0) {
        this.a = 0;
        super();
        this.b = h0;
    }

    public a(h h0, int v, int v1) {
        this.a = v1;
        this.b = h0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    h h0 = this.b;
                    if(((O0)h0.b).getValue() == b.a) {
                        ((p)(((l)object0))).a0(1258590910);
                        h0.a(((p)(((l)object0))), 0);
                        ((p)(((l)object0))).p(false);
                        return H.a;
                    }
                    ((p)(((l)object0))).a0(0x4B056BFC);
                    h0.b(((p)(((l)object0))), 0);
                    ((p)(((l)object0))).p(false);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                this.b.a(((l)object0), 1);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                this.b.b(((l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                this.b.b(((l)object0), 1);
                return H.a;
            }
        }
    }
}

