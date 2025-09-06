package Ua;

import Ac.Y1;
import Pc.d;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.CommentUiModel;
import ie.H;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import we.a;
import we.k;

public final class p implements a {
    public final T2.a a;
    public final N b;
    public final CommentConfig c;
    public final CommentUiModel d;
    public final boolean e;
    public final Y1 f;
    public final n g;
    public final d h;

    public p(T2.a a0, N n0, CommentConfig commentConfig0, CommentUiModel commentUiModel0, boolean z, Y1 y10, k k0, d d0) {
        this.a = a0;
        this.b = n0;
        this.c = commentConfig0;
        this.d = commentUiModel0;
        this.e = z;
        this.f = y10;
        this.g = (n)k0;
        this.h = d0;
    }

    @Override  // we.a
    public final Object invoke() {
        s s0 = new s(this.b, this.c, this.d, this.e, this.f, ((k)this.g), this.h, null);
        BuildersKt__Builders_commonKt.launch$default(this.a, Dispatchers.getIO(), null, s0, 2, null);
        return H.a;
    }
}

