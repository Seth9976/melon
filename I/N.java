package I;

import G.y;
import androidx.compose.foundation.gestures.a;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;

public final class n implements Z {
    public y a;
    public final H0 b;

    public n(y y0) {
        this.a = y0;
        this.b = a.b;
    }

    @Override  // I.Z
    public final Object a(b1 b10, float f, Continuation continuation0) {
        m m0 = new m(f, this, b10, null);
        return BuildersKt.withContext(this.b, m0, continuation0);
    }
}

