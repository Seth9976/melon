package Nc;

import J8.L2;
import U4.F;
import androidx.compose.runtime.l;
import ed.r;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import we.n;

public final class h1 implements n {
    public final int a;
    public final float b;
    public final Object c;

    public h1(L2 l20, float f) {
        this.a = 1;
        super();
        this.c = l20;
        this.b = f;
    }

    public h1(ArrayList arrayList0, float f, int v) {
        this.a = 0;
        super();
        this.c = arrayList0;
        this.b = f;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            q.g(((String)object1), "item");
            ((L2)this.c).d.animate().translationY(-this.b).setDuration(500L).withEndAction(new r(((L2)this.c), this.b, ((int)(((Integer)object0))), ((String)object1))).start();
            return H.a;
        }
        ((Integer)object1).getClass();
        F.d(((ArrayList)this.c), this.b, ((l)object0), 391);
        return H.a;
    }
}

