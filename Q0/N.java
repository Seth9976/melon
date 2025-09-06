package Q0;

import De.c;
import De.h;
import De.i;
import De.j;
import De.p;
import De.q;
import Zc.t0;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import com.melon.ui.k1;
import com.melon.ui.n0;
import gd.P5;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.u;
import w0.k;

public final class n extends u implements j {
    public final int b;

    public n(int v, int v1, Class class0, Object object0, String s, String s1) {
        this.b = v1;
        super(object0, class0, s, s1, v);
    }

    public n(P5 p50) {
        this.b = 5;
        super(p50, P5.class, "isFragmentVisible", "isFragmentVisible()Z", 0);
    }

    @Override  // De.m
    public final h b() {
        return this.b();
    }

    @Override  // De.j
    public final i b() {
        return ((j)this.getReflected()).b();
    }

    @Override  // kotlin.jvm.internal.e
    public final c computeReflected() {
        return I.a.d(this);
    }

    @Override  // De.r
    public final Object get() {
        switch(this.b) {
            case 0: {
                return ((Q0.u)this.receiver).getLayoutDirection();
            }
            case 1: {
                return Boolean.valueOf(((t0)this.receiver).isFragmentVisible());
            }
            case 2: {
                return Boolean.valueOf(((n0)this.receiver).isFragmentVisible());
            }
            case 3: {
                return Boolean.valueOf(((n0)this.receiver).isFragmentVisible());
            }
            case 4: {
                return Boolean.valueOf(((k1)this.receiver).isFragmentVisible());
            }
            case 5: {
                return Boolean.valueOf(((P5)this.receiver).isFragmentVisible());
            }
            case 6: {
                return ((ComposeViewAdapter)this.receiver).getClock$ui_tooling_release();
            }
            default: {
                return ((k)this.receiver).l;
            }
        }
    }

    @Override  // De.w
    public final p getGetter() {
        return this.getGetter();
    }

    @Override  // De.r
    public final q getGetter() {
        return ((j)this.getReflected()).getGetter();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.get();
    }
}

