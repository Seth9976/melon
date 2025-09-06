package androidx.fragment.app;

import android.view.View;
import c2.M;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class p extends r implements k {
    public final int f;
    public final Collection g;

    public p(int v, Collection collection0) {
        this.f = v;
        this.g = collection0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        Collection collection0 = this.g;
        switch(this.f) {
            case 0: {
                q.g(((Map.Entry)object0), "entry");
                return Boolean.valueOf(je.p.d0(collection0, M.f(((View)((Map.Entry)object0).getValue()))));
            }
            case 1: {
                return Boolean.valueOf(collection0.contains(object0));
            }
            case 2: {
                return Boolean.valueOf(collection0.contains(object0));
            }
            default: {
                return Boolean.valueOf(((List)object0).retainAll(collection0));
            }
        }
    }
}

