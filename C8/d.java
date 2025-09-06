package C8;

import A0.f;
import P0.K;
import X0.c;
import X0.u;
import X0.x;
import androidx.compose.runtime.b1;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import y0.N;
import y0.s;

public final class d implements k {
    public final int a;
    public final b1 b;

    public d(b1 b10, int v) {
        this.a = v;
        this.b = b10;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$semantics");
                boolean z = false;
                u.k(((x)object0), 0);
                u.g(((x)object0), new c(0, 1, 1, 1));
                if(((Number)this.b.getValue()).intValue() == 1) {
                    z = true;
                }
                u.l(((x)object0), z);
                return H.a;
            }
            case 1: {
                q.g(((x)object0), "$this$semantics");
                boolean z1 = false;
                u.k(((x)object0), 0);
                u.g(((x)object0), new c(0, 1, 0, 1));
                if(((Number)this.b.getValue()).intValue() == 0) {
                    z1 = true;
                }
                u.l(((x)object0), z1);
                return H.a;
            }
            case 2: {
                q.g(((N)object0), "$this$graphicsLayer");
                ((N)object0).a((((Boolean)this.b.getValue()).booleanValue() ? 0.5f : 1.0f));
                return H.a;
            }
            default: {
                q.g(((A0.d)object0), "$this$drawWithContent");
                ((K)(((A0.d)object0))).a();
                if(((Boolean)this.b.getValue()).booleanValue()) {
                    f.f0(((A0.d)object0), wc.u.f(e.k.A(new s[]{new s(s.f), new s(s.c(s.b, 1.0f))}), 0.0f, ((float)ViewUtilsKt.dpToPx(30)), 8), 0L, 0L, 0.0f, null, 62);
                }
                return H.a;
            }
        }
    }
}

