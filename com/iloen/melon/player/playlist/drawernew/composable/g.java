package com.iloen.melon.player.playlist.drawernew.composable;

import O.v;
import com.iloen.melon.player.playlist.common.PlaylistUiExtensionsKt;
import ie.H;
import kotlin.jvm.internal.q;
import p0.p;
import we.n;

public final class g implements n {
    public final int a;
    public final p b;

    public g(p p0, int v) {
        this.a = v;
        this.b = p0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                q.g(((v)object0), "from");
                q.g(((v)object1), "to");
                PlaylistUiExtensionsKt.move(this.b, ((v)object0).a, ((v)object1).a);
                return H.a;
            }
            case 1: {
                q.g(((v)object0), "from");
                q.g(((v)object1), "to");
                PlaylistUiExtensionsKt.move(this.b, ((v)object0).a, ((v)object1).a);
                return H.a;
            }
            default: {
                int v = (int)(((Integer)object0));
                int v1 = (int)(((Integer)object1));
                p p0 = this.b;
                q.g(p0, "<this>");
                if(v != v1) {
                    Object object2 = p0.remove(v);
                    if(object2 != null) {
                        p0.add(v1, object2);
                    }
                }
                return H.a;
            }
        }
    }
}

