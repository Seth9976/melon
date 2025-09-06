package androidx.recyclerview.widget;

import I.H1;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import jeb.synthetic.FIN;

public abstract class q0 {
    public h0 a;
    public ArrayList b;
    public long c;
    public long d;
    public long e;
    public long f;

    public abstract boolean a(O0 arg1, O0 arg2, p0 arg3, p0 arg4);

    public static void b(O0 o00) {
        if(!o00.isInvalid() && (o00.mFlags & 4) == 0) {
            o00.getAbsoluteAdapterPosition();
        }
    }

    public final void c(O0 o00) {
        h0 h00 = this.a;
        if(h00 != null) {
            RecyclerView recyclerView0 = h00.a;
            int v = 1;
            o00.setIsRecyclable(true);
            if(o00.mShadowedHolder != null && o00.mShadowingHolder == null) {
                o00.mShadowedHolder = null;
            }
            o00.mShadowingHolder = null;
            if(!o00.shouldBeKeptAsChild()) {
                View view0 = o00.itemView;
                D0 d00 = recyclerView0.c;
                recyclerView0.e0();
                j j0 = recyclerView0.f;
                H1 h10 = j0.b;
                h0 h01 = j0.a;
                int v1 = j0.d;
                if(v1 == 1) {
                    if(j0.e != view0) {
                        throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
                    }
                    v = 0;
                }
                else {
                    if(v1 == 2) {
                        throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
                    }
                    int v2 = FIN.finallyOpen$NT();
                    j0.d = 2;
                    int v3 = h01.a.indexOfChild(view0);
                    if(v3 == -1) {
                        j0.l(view0);
                        goto label_32;
                    }
                    else if(h10.z(v3)) {
                        h10.D(v3);
                        j0.l(view0);
                        h01.k(v3);
                    label_32:
                        FIN.finallyCodeBegin$NT(v2);
                        j0.d = 0;
                        FIN.finallyCodeEnd$NT(v2);
                    }
                    else {
                        FIN.finallyExec$NT(v2);
                        v = 0;
                    }
                }
                if(v != 0) {
                    O0 o01 = RecyclerView.H(view0);
                    d00.l(o01);
                    d00.i(o01);
                    if(RecyclerView.Z0) {
                        Log.d("RecyclerView", "after removing animated view: " + view0 + ", " + recyclerView0);
                    }
                }
                recyclerView0.g0(((boolean)(v ^ 1)));
                if(v == 0 && o00.isTmpDetached()) {
                    recyclerView0.removeDetachedView(o00.itemView, false);
                }
            }
        }
    }

    public abstract void d(O0 arg1);

    public abstract void e();

    public abstract boolean f();
}

