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

public final class o implements a {
    public final int a;
    public final T2.a b;
    public final N c;
    public final CommentConfig d;
    public final CommentUiModel e;
    public final n f;
    public final d g;
    public final k h;

    public o(T2.a a0, N n0, CommentConfig commentConfig0, CommentUiModel commentUiModel0, k k0, d d0, Y1 y10) {
        this.a = 1;
        super();
        this.b = a0;
        this.c = n0;
        this.d = commentConfig0;
        this.e = commentUiModel0;
        this.f = (n)k0;
        this.g = d0;
        this.h = y10;
    }

    public o(T2.a a0, N n0, CommentConfig commentConfig0, CommentUiModel commentUiModel0, k k0, d d0, Y1 y10, byte b) {
        this.a = 0;
        super();
        this.b = a0;
        this.c = n0;
        this.d = commentConfig0;
        this.e = commentUiModel0;
        this.f = (n)k0;
        this.g = d0;
        this.h = y10;
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            r r0 = new r(this.c, this.d, this.e, ((k)this.f), this.g, ((Y1)this.h), null);
            BuildersKt__Builders_commonKt.launch$default(this.b, Dispatchers.getIO(), null, r0, 2, null);
            return H.a;
        }
        q q0 = new q(this.c, this.d, this.e, ((k)this.f), this.g, ((Y1)this.h), null);
        BuildersKt__Builders_commonKt.launch$default(this.b, Dispatchers.getIO(), null, q0, 2, null);
        return H.a;
    }
}

