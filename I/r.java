package I;

import androidx.compose.foundation.B0;
import androidx.compose.foundation.x0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScopeKt;
import ne.a;
import we.k;
import we.n;

public final class r implements X0 {
    public final kotlin.jvm.internal.r a;
    public final q b;
    public final B0 c;
    public final b0 d;
    public final b0 e;
    public final b0 f;

    public r(k k0) {
        this.a = (kotlin.jvm.internal.r)k0;
        this.b = new q(this);
        this.c = new B0();
        this.d = w.s(Boolean.FALSE);
        this.e = w.s(Boolean.FALSE);
        this.f = w.s(Boolean.FALSE);
    }

    @Override  // I.X0
    public final Object a(x0 x00, n n0, Continuation continuation0) {
        Object object0 = CoroutineScopeKt.coroutineScope(new p(this, x00, n0, null), continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Override  // I.X0
    public final boolean b() {
        return ((Boolean)((O0)this.d).getValue()).booleanValue();
    }

    @Override  // I.X0
    public final float e(float f) {
        return ((Number)((k)this.a).invoke(f)).floatValue();
    }
}

