package Fc;

import I0.a;
import androidx.compose.runtime.b0;
import kotlin.coroutines.Continuation;

public final class g implements a {
    public final b0 a;

    public g(b0 b00) {
        this.a = b00;
    }

    @Override  // I0.a
    public final long onPostScroll-DzOQY0M(long v, long v1, int v2) {
        return 0L;
    }

    @Override  // I0.a
    public final Object onPreFling-QWom1Mo(long v, Continuation continuation0) {
        this.a.setValue(Boolean.FALSE);
        return a.super.onPreFling-QWom1Mo(v, continuation0);
    }

    @Override  // I0.a
    public final long onPreScroll-OzD1aCk(long v, int v1) {
        return 0L;
    }
}

