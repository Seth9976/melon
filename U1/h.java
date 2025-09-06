package u1;

import android.util.SparseArray;
import ie.H;
import kotlin.jvm.internal.r;
import we.a;

public final class h extends r implements a {
    public final int f;
    public final o g;

    public h(o o0, int v) {
        this.f = v;
        this.g = o0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                this.g.getLayoutNode().B();
                return H.a;
            }
            case 1: {
                o o0 = this.g;
                if(o0.e && o0.isAttachedToWindow() && o0.getView().getParent() == o0) {
                    o0.getSnapshotObserver().a(o0, u1.a.i, o0.getUpdate());
                }
                return H.a;
            }
            case 2: {
                SparseArray sparseArray0 = new SparseArray();
                this.g.T.saveHierarchyState(sparseArray0);
                return sparseArray0;
            }
            case 3: {
                this.g.getReleaseBlock().invoke(this.g.T);
                o.h(this.g);
                return H.a;
            }
            case 4: {
                this.g.getResetBlock().invoke(this.g.T);
                return H.a;
            }
            default: {
                this.g.getUpdateBlock().invoke(this.g.T);
                return H.a;
            }
        }
    }
}

