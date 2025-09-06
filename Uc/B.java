package uc;

import Cb.i;
import ie.H;
import kotlin.jvm.internal.q;
import oc.V;
import we.k;

public final class b implements k {
    public final int a;
    public final V b;

    public b(V v0, int v1) {
        this.a = v1;
        this.b = v0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((StringBuilder)object0), "$this$buildDebug");
            ((StringBuilder)object0).append("add()");
            i.a(((StringBuilder)object0), "clearBefore: " + this.b.a);
            i.a(((StringBuilder)object0), "removeDuplicated: " + this.b.b);
            i.a(((StringBuilder)object0), "addPlayableListInfoSize: " + this.b.c.getUserRequestedPlaylist().size());
            i.a(((StringBuilder)object0), "position: " + this.b.d);
            i.a(((StringBuilder)object0), "isAddAndPlay: " + this.b.e);
            return H.a;
        }
        q.g(((StringBuilder)object0), "$this$buildDebug");
        ((StringBuilder)object0).append("add()");
        i.a(((StringBuilder)object0), "clearBefore: " + this.b.a);
        i.a(((StringBuilder)object0), "removeDuplicated: " + this.b.b);
        i.a(((StringBuilder)object0), "addPlayableListInfoSize: " + this.b.c.getUserRequestedPlaylist().size());
        i.a(((StringBuilder)object0), "position: " + this.b.d);
        i.a(((StringBuilder)object0), "isAddAndPlay: " + this.b.e);
        return H.a;
    }
}

