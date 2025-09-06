package androidx.fragment.app;

import Y1.b;
import android.util.Log;
import android.view.ViewGroup;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.a;

public final class m extends r implements a {
    public final int f;
    public final n g;
    public final Object h;
    public final ViewGroup i;

    public m(n n0, ViewGroup viewGroup0, Object object0) {
        this.f = 0;
        this.g = n0;
        this.i = viewGroup0;
        this.h = object0;
        super(0);
    }

    public m(n n0, Object object0, ViewGroup viewGroup0) {
        this.f = 1;
        this.g = n0;
        this.h = object0;
        this.i = viewGroup0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            n n0 = this.g;
            ArrayList arrayList0 = n0.c;
            G0 g00 = n0.f;
            if(!arrayList0.isEmpty()) {
                for(Object object0: arrayList0) {
                    if(!((o)object0).a.g) {
                        if(l0.P(2)) {
                            Log.v("FragmentManager", "Completing animating immediately");
                        }
                        b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                        I i0 = ((o)arrayList0.get(0)).a.c;
                        x x0 = new x(n0, 3);
                        g00.u(i0, this.h, b0, x0);
                        b0.a();
                        return H.a;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            if(l0.P(2)) {
                Log.v("FragmentManager", "Animating to start");
            }
            Object object1 = n0.q;
            q.d(object1);
            g00.d(object1, new l(n0, this.i));
            return H.a;
        }
        this.g.f.e(this.i, this.h);
        return H.a;
    }
}

