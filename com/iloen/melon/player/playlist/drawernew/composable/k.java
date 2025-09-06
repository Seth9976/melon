package com.iloen.melon.player.playlist.drawernew.composable;

import com.iloen.melon.player.playlist.common.PlaylistUiExtensionsKt;
import ie.H;
import p0.p;
import we.a;
import we.n;

public final class k implements we.k {
    public final int a;
    public final p b;
    public final a c;
    public final n d;

    public k(p p0, a a0, n n0, int v) {
        this.a = v;
        this.b = p0;
        this.c = a0;
        this.d = n0;
        super();
    }

    public k(a a0, p p0, n n0, int v) {
        this.a = v;
        this.c = a0;
        this.b = p0;
        this.d = n0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                int v1 = (int)(((Integer)object0));
                if(v1 > 0) {
                    this.c.invoke();
                    PlaylistUiExtensionsKt.move(this.b, v1, v1 - 1);
                    n n1 = this.d;
                    if(n1 != null) {
                        n1.invoke(((Integer)object0), ((int)(v1 - 1)));
                    }
                }
                return H.a;
            }
            case 1: {
                int v2 = (int)(((Integer)object0));
                p p1 = this.b;
                if(v2 < p1.size() - 1) {
                    this.c.invoke();
                    PlaylistUiExtensionsKt.move(p1, v2, v2 + 1);
                    n n2 = this.d;
                    if(n2 != null) {
                        n2.invoke(((Integer)object0), ((int)(v2 + 1)));
                    }
                }
                return H.a;
            }
            case 2: {
                int v3 = (int)(((Integer)object0));
                if(v3 > 0) {
                    this.c.invoke();
                    PlaylistUiExtensionsKt.move(this.b, v3, v3 - 1);
                    n n3 = this.d;
                    if(n3 != null) {
                        n3.invoke(((Integer)object0), ((int)(v3 - 1)));
                    }
                }
                return H.a;
            }
            default: {
                int v = (int)(((Integer)object0));
                p p0 = this.b;
                if(v < p0.size() - 1) {
                    this.c.invoke();
                    PlaylistUiExtensionsKt.move(p0, v, v + 1);
                    n n0 = this.d;
                    if(n0 != null) {
                        n0.invoke(((Integer)object0), ((int)(v + 1)));
                    }
                }
                return H.a;
            }
        }
    }
}

